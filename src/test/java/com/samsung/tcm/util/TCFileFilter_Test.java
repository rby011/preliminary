package com.samsung.tcm.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;

class TCFileFilter_Test {
    private File root = new File("C:\\Users\\Changsun Song\\Desktop\\회사업무\\gitrepo\\tct\\csharp\\api\\tct-suite-vs");

    @Test
    void configure() {
        try {
            TestCaseFileFilter configure = TestCaseFileFilter.configure(root);
            if (configure == null)
                Assertions.fail();
        } catch (FileNotFoundException ex) {
            Assertions.fail();
        }
    }

    @Test
    void filterFiles_FilterType_FILE_EXT() {
        try {
            TestCaseFileFilter configure = TestCaseFileFilter.configure(root);
            if (configure == null)
                Assertions.fail();

            HashSet<File> files = configure
                    .filterFiles("cs", TestCaseFileFilter.FilterType.FILE_EXT)
                    .listTestcaseFiles();

            files.forEach(file -> {
                if (!file.getName().endsWith("cs"))
                    Assertions.fail();
            });
        } catch (FileNotFoundException ex) {
            Assertions.fail();
        }
    }

    @Test
    void filterFiles_FIlterTye_FILE_NAME() {
        try {
            TestCaseFileFilter configure = TestCaseFileFilter.configure(root);
            if (configure == null)
                Assertions.fail();

            HashSet<File> files = configure
                    .filterFiles("cs", TestCaseFileFilter.FilterType.FILE_EXT)
                    .filterFiles("TS", TestCaseFileFilter.FilterType.FILE_NAME_PREFIX)
                    .listTestcaseFiles();

            for (File file : files) {
                if (!file.getName().endsWith("cs") || !file.getName().startsWith("TS"))
                    Assertions.fail();
            }
        } catch (FileNotFoundException ex) {
            Assertions.fail();
        }
    }

    @Test
    void filterFiles_FIlterTye_DIR_NAME() {
        try {
            TestCaseFileFilter configure = TestCaseFileFilter.configure(root);
            if (configure == null)
                Assertions.fail();

            HashSet<File> files = configure
                    .filterFiles("Tests", TestCaseFileFilter.FilterType.DIR_NAME_POSTFIX)
                    .filterFiles("cs", TestCaseFileFilter.FilterType.FILE_EXT)
                    .filterFiles("TS", TestCaseFileFilter.FilterType.FILE_NAME_PREFIX)
                    .filterFiles("Application", TestCaseFileFilter.FilterType.FILE_NAME_POSTFIX)
                    .listTestcaseFiles();

            for (File file : files) {
                //System.out.println(file.getAbsolutePath());
            }
        } catch (FileNotFoundException ex) {
            Assertions.fail();
        }
    }

    @Test
    void filterFiles_FIlterTye_FILE_EXT() {
        try {
            TestCaseFileFilter configure = TestCaseFileFilter.configure(root);
            if (configure == null)
                Assertions.fail();

            HashSet<File> files = configure
                    .filterFiles("cs", TestCaseFileFilter.FilterType.FILE_EXT)
                    .listTestcaseFiles();

            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } catch (FileNotFoundException ex) {
            Assertions.fail();
        }
    }


    @Test
    void listTestcaseFiles() {
    }
}