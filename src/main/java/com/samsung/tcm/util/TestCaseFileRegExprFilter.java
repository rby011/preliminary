package com.samsung.tcm.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class TestCaseFileRegExprFilter {
    private File root;
    private Pattern dirPattern, filePattern;

    public TestCaseFileRegExprFilter(File root) throws FileNotFoundException {
        if (!root.exists())
            throw new FileNotFoundException("Could not reach the root file path");
        this.root = root;
    }

    public ArrayList<File> listTestcaseFiles(Pattern nameRegExpr) {
        return listTestcaseFiles(null, nameRegExpr);
    }

    /**
     * @param dirRegExpr  nullable and must be given as the result of Pattern.compile(regexprStr)
     * @param nameRegExpr non-nulls and must be given as the result of Pattern.compile(regexprStr)
     * @return The file list that matches the given regular expression
     */
    public ArrayList<File> listTestcaseFiles(Pattern dirRegExpr, Pattern nameRegExpr) throws InvalidParameterException {
        if (nameRegExpr == null)
            throw new InvalidParameterException("The 'nameRegExpr' parameter is null");

        this.dirPattern = dirRegExpr;
        this.filePattern = nameRegExpr;

        ArrayList list = new ArrayList<File>();

        listFilesWithPattern(this.root, list, false);

        return list;
    }

    // TODO java.io 대신 apache.common.io 사용 고려 필요 TOGETHER WITH "RegExprFilter"
    private void listFilesWithPattern(File chkFile, ArrayList<File> list, boolean isInTestDir) {
        if (chkFile.isFile() && filePattern.matcher(chkFile.getName()).matches())
            list.add(chkFile);

        if (chkFile.isDirectory()) {
            boolean needCheck = false, inTestDir = false;
            // TEST ROOT DIRECTORY
            if (chkFile.equals(root)) {
                needCheck = true;
                inTestDir = false;
            }

            // CHILD UNDER ROOT DIRECTORY
            if (isInTestDir) {
                needCheck = true;
                inTestDir = true;
            }

            // PATTERN-MATCHED CHILD UNDER ROOT DIRECTORY
            if (dirPattern == null || dirPattern.matcher(chkFile.getName()).matches()) {
                needCheck = true;
                inTestDir = true;
            }

            if (needCheck) {
                File[] files = chkFile.listFiles();
                if (files == null) return;
                for (File file : files)
                    listFilesWithPattern(file, list, inTestDir);
            }
        }
    }
}