package com.samsung.tcm.util;

import com.samsung.tcm.exceptions.FilterPatternMismatchException;
import com.samsung.tcm.exceptions.NotSupportFilterPatternException;
import com.samsung.tcm.schema.ETestFileIdentifierLocation;
import com.samsung.tcm.schema.ETestFileIdentifierMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Iterator;

public class TestCaseFileFilter {

    // SET @ configure() and RELEASE @ listTestcaseFiles()
    private File root;
    private boolean isInvoked;
    private HashSet<File> fileSet;

    private static TestCaseFileFilter tcFileFilter;

    public static TestCaseFileFilter configure(File root) throws FileNotFoundException {
        if (!root.exists())
            throw new FileNotFoundException("The given file does not exist");

        if (tcFileFilter == null)
            tcFileFilter = new TestCaseFileFilter();

        tcFileFilter.root = root;
        tcFileFilter.isInvoked = false;
        tcFileFilter.fileSet = new HashSet<>();

        return TestCaseFileFilter.tcFileFilter;
    }

    public TestCaseFileFilter filterFiles(String filterStr, FilterType filterType) throws InvalidParameterException {
        if (!isValidParameter(filterStr))
            throw new InvalidParameterException("The given filter string is empty or null");

        if (!isInvoked) {
            File[] chkFiles = root.listFiles();
            if (chkFiles == null) return new TestCaseFileFilter();
            for (File chkFile : chkFiles)
                listFilesWithFilterString(chkFile, filterStr, filterType, true);
            isInvoked = true;
        } else {
            filterOut(filterStr, filterType);
        }
        return this;
    }

    public HashSet<File> listTestcaseFiles() {
        HashSet<File> ret = tcFileFilter.fileSet;

        tcFileFilter.root = null;
        tcFileFilter.isInvoked = false;
        tcFileFilter.fileSet = null;

        return ret;
    }

    public FilterType generateFilterType(ETestFileIdentifierMethod iMethod, ETestFileIdentifierLocation iLocation)
            throws NotSupportFilterPatternException, FilterPatternMismatchException {
        return FilterTypeMapper.mapToFilterType(iMethod, iLocation);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                    컬렉션에서 Filter 조건 맞지 않으면 제거
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void filterOut(String filterStr, FilterType filterType) {
        Iterator<File> iterator = tcFileFilter.fileSet.iterator();
        while (iterator.hasNext()) {
            File next = iterator.next();
            if (filterType == FilterType.FILE_EXT) {
                if (!next.getName().endsWith(filterStr)) iterator.remove();
            } else if (filterType == FilterType.FILE_NAME_PREFIX) {
                if (!next.getName().startsWith(filterStr)) iterator.remove();
            } else if (filterType == FilterType.FILE_NAME_POSTFIX) {
                String fnameonly = getFileNameWithoutExt(next.getName());
                if (fnameonly == null || !fnameonly.endsWith(filterStr)) iterator.remove();
            } else if (isDirFiltered(filterType)) {
                filterOut(next.getParentFile(), filterStr, filterType, next);
            }
        }
    }

    private void filterOut(File directory, String filterStr, FilterType filterType, File file) {
        if (directory.equals(tcFileFilter.root)) {//WHEN TRAVERSAL MEETS ROOT (END OF TRAVERSAL)
            if (isMatch(directory, filterStr, filterType)) return;
            // TODO 스레드 안전성 유의. 다중 스레드 처리 時 추후 별도 자료구조 필요
            tcFileFilter.fileSet.remove(file);
            return;
        }
        if (isMatch(directory, filterStr, filterType)) return;
        filterOut(directory.getParentFile(), filterStr, filterType, file);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          첫 번째 조건으로 파일 필터링
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void listFilesWithFilterString(File chkFile, String filterStr, FilterType filterType, boolean isInMatchedDir) {
        if (chkFile.isFile())
            addToFileSetByFilter(chkFile, filterStr, filterType);

        if (chkFile.isDirectory()) {
            NeedCheck check = new NeedCheck(chkFile, filterStr, filterType, isInMatchedDir).decide();
            if (check.isNeedCheck()) {
                File[] needChkFiles = chkFile.listFiles();
                if (needChkFiles == null) return;
                for (File needChkFile : needChkFiles)
                    listFilesWithFilterString(needChkFile, filterStr, filterType, check.isInMatchedDir());
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                               기타 유틸성
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void addToFileSetByFilter(File chkFile, String filterStr, FilterType filterType) {
        if (filterType == FilterType.FILE_EXT) {
            if (chkFile.getName().endsWith(filterStr)) tcFileFilter.fileSet.add(chkFile);
        } else if (filterType == FilterType.FILE_NAME_PREFIX) {
            if (chkFile.getName().startsWith(filterStr)) tcFileFilter.fileSet.add(chkFile);
        } else if (filterType == FilterType.FILE_NAME_POSTFIX) {
            String fnameonly = getFileNameWithoutExt(chkFile.getName());
            if (fnameonly != null && fnameonly.endsWith(filterStr)) tcFileFilter.fileSet.add(chkFile);
        } else if (filterType == FilterType.FILE_NAME_EXACTLY) {
            String fnameonly = getFileNameWithoutExt(chkFile.getName());
            if (fnameonly != null && fnameonly.equalsIgnoreCase(filterStr)) tcFileFilter.fileSet.add(chkFile);
        } else if (filterType == FilterType.FILE_NAME_ALL || isDirFiltered(filterType)) {
            tcFileFilter.fileSet.add(chkFile);
        }
    }

    private boolean isMatch(File directory, String filterStr, FilterType filterType) {
        String name = directory.getName();
        if (filterType == FilterType.DIR_NAME_PREFIX) {
            return name.startsWith(filterStr);
        } else if (filterType == FilterType.DIR_NAME_POSTFIX) {
            return name.endsWith(filterStr);
        } else if (filterType == FilterType.DIR_NAME_EXACTLY) {
            return name.equalsIgnoreCase(filterStr);
        }
        return false;
    }

    private boolean isDirFiltered(FilterType filterType) {
        return filterType == FilterType.DIR_NAME_ALL ||
                filterType == FilterType.DIR_NAME_PREFIX ||
                filterType == FilterType.DIR_NAME_POSTFIX ||
                filterType == FilterType.FILE_NAME_EXACTLY;
    }

    private String getFileNameWithoutExt(String fileName) throws InvalidParameterException {
        if (!isValidParameter(fileName))
            throw new InvalidParameterException("The given file name is empty or null.");

        // TODO java.io 대신 apache.common.io 사용 고려 필요 TOGETHER WITH "RegExprFilter"
        int idx = fileName.lastIndexOf(".");
        if (idx < 0)
            return null;
        return fileName.substring(0, idx);
    }

    private boolean isValidParameter(String param) {
        return param != null && param.length() != 0;
    }

    private class NeedCheck {
        private File chkFile;
        private String filterStr;
        private FilterType filterType;
        private boolean isInMatchedDir;
        private boolean needCheck;
        private boolean inMatchedDir;

        NeedCheck(File chkFile, String filterStr, FilterType filterType, boolean isInMatchedDir) {
            this.chkFile = chkFile;
            this.filterStr = filterStr;
            this.filterType = filterType;
            this.isInMatchedDir = isInMatchedDir;
        }

        boolean isNeedCheck() {
            return needCheck;
        }

        boolean isInMatchedDir() {
            return inMatchedDir;
        }

        NeedCheck decide() {
            needCheck = false;
            inMatchedDir = false;

            if (isInMatchedDir) {
                needCheck = true;
                inMatchedDir = true;
            }

            if (filterType == FilterType.DIR_NAME_PREFIX) {
                if (chkFile.getName().startsWith(filterStr)) {
                    needCheck = true;
                    inMatchedDir = true;
                }
            } else if (filterType == FilterType.DIR_NAME_POSTFIX) {
                if (chkFile.getName().endsWith(filterStr)) {
                    needCheck = true;
                    inMatchedDir = true;
                }
            } else if (filterType == FilterType.DIR_NAME_EXACTLY) {
                if (chkFile.getName().equalsIgnoreCase(filterStr)) {
                    needCheck = true;
                    inMatchedDir = true;
                }
            } else if (filterType == FilterType.DIR_NAME_ALL) {
                needCheck = true;
                inMatchedDir = true;
            }
            return this;
        }
    }

    static class FilterTypeMapper {
        public static FilterType mapToFilterType(ETestFileIdentifierMethod idMethod, ETestFileIdentifierLocation idLocation)
                throws NotSupportFilterPatternException, FilterPatternMismatchException {
            if (idLocation == ETestFileIdentifierLocation.FILE_NAME) {
                if (idMethod == ETestFileIdentifierMethod.PREFIX) {
                    return FilterType.FILE_NAME_PREFIX;
                } else if (idMethod == ETestFileIdentifierMethod.POSTFIX) {
                    return FilterType.FILE_NAME_POSTFIX;
                } else if (idMethod == ETestFileIdentifierMethod.EXACT) {
                    return FilterType.FILE_NAME_EXACTLY;
                }
            } else if (idLocation == ETestFileIdentifierLocation.FILE_EXTENSIONS) {
                if (idMethod == ETestFileIdentifierMethod.EXACT) {
                    return FilterType.FILE_EXT;
                } else {
                    throw new FilterPatternMismatchException("The given filter pattern does not match.");
                }
            }
            throw new NotSupportFilterPatternException("Other type filters are not supported.");
        }
    }

    public enum FilterType {
        FILE_EXT, FILE_NAME_PREFIX, FILE_NAME_POSTFIX, FILE_NAME_EXACTLY, FILE_NAME_ALL, DIR_NAME_PREFIX, DIR_NAME_POSTFIX, DIR_NAME_EXACTLY, DIR_NAME_ALL
    }
}