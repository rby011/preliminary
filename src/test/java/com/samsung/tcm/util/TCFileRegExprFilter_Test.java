package com.samsung.tcm.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.regex.Pattern;

class TCFileRegExprFilter_Test {

    @Test
    void listTestcaseFiles() {
        try {
            File root = new File("C:\\Users\\Changsun Song\\Desktop\\회사업무\\gitrepo\\tct\\csharp\\api\\tct-suite-vs");
            TestCaseFileRegExprFilter reFilter = new TestCaseFileRegExprFilter(root);
            Pattern dirPattern = Pattern.compile("^(Tizen.)(.)*(Tests)$");
            Pattern filePattern = Pattern.compile("^(TS)(.)+(.cs)$");

            ArrayList<File> tcFiles = reFilter.listTestcaseFiles(dirPattern, filePattern);

            for (File tcFile : tcFiles) {
                //System.out.println(tcFile.getAbsolutePath());
            }
        } catch (Exception ex) {
            Assertions.fail();
        }
    }

    @Test
    void listTestcaseFiles1() {
        try {
            File root = new File("C:\\Users\\Changsun Song\\Desktop\\회사업무\\gitrepo\\tct\\csharp\\api\\tct-suite-vs");
            TestCaseFileRegExprFilter reFilter = new TestCaseFileRegExprFilter(root);
            Pattern filePattern = Pattern.compile("^(TS)(.)+(.cs)$");

            ArrayList<File> tcFiles = reFilter.listTestcaseFiles(null, filePattern);

            findFiles(root);

            if (tcFiles.size() != ftable.size())
                Assertions.fail();

            Iterator<File> iterator = tcFiles.iterator();
            while (iterator.hasNext()) {
                File next = iterator.next();
                String key = next.getCanonicalPath();

                File value = ftable.get(key);

                if (!next.equals(value))
                    Assertions.fail();
            }

        } catch (IOException ex) {
            Assertions.fail();
        } catch (Exception ex) {
            Assertions.fail();
        }
    }

    @Test
    void testFileEquals() {
        File root1 = new File("C:\\Users\\Changsun Song\\Desktop\\회사업무\\gitrepo\\tct\\csharp\\api\\tct-suite-vs");
        File root2 = new File("C:\\Users\\Changsun Song\\Desktop\\회사업무\\gitrepo\\tct\\csharp\\api\\tct-suite-vs");

        if (!root1.equals(root2)) {
            Assertions.fail();
        }
    }

    private HashSet<File> fSet = new HashSet<>();
    private Hashtable<String, File> ftable = new Hashtable<>();

    private void findFiles(File file) throws Exception {
        if (file.isDirectory()) {
            File files[] = file.listFiles();
            for (File cfile : files) {
                findFiles(cfile);
            }
        }

        if (file.isFile()) {
            if (file.getName().startsWith("TS") && file.getName().endsWith(".cs"))
                ftable.put(file.getCanonicalPath(), file);
        }
    }
}