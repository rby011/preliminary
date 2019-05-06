package com.samsung.tcm.analysis.c;

import com.samsung.tcm.core.parser.c.CLexer;
import com.samsung.tcm.core.parser.c.CParser;
import com.samsung.tcm.util.TestCaseFileFilter;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class CAssertMacroAnalyzerTest {
    @Test
    void extractMacroTest() {
        String tcFilePath = "C:\\Users\\Changsun Song\\Desktop\\회사업무\\gitrepo\\tct\\native\\api";

        HashMap<String, HashMap<String, String>> rMap = new HashMap<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Tizen Native TCT Assertion Macro");
            FileOutputStream fout = new FileOutputStream("./result.xlsx");

            HashSet<File> files = TestCaseFileFilter.configure(new File(tcFilePath))
                    .filterFiles("h", TestCaseFileFilter.FilterType.FILE_EXT)
                    .filterFiles("assert", TestCaseFileFilter.FilterType.FILE_NAME_PREFIX)
                    .listTestcaseFiles();

            for (File file : files) {
                CLexer lexer = new CLexer(new ANTLRInputStream(new FileReader(file)));
                CommonTokenStream tokenStream = new CommonTokenStream(lexer);
                CParser parser = new CParser(tokenStream);

                HashMap<String, String> map = new HashMap<>();

                String fPath = file.getAbsolutePath();
                fPath = fPath.substring(fPath.indexOf("tct"));
                rMap.put(fPath, map);

                CAssertMacroAnalyzer analyzer = new CAssertMacroAnalyzer(map);
                ParseTreeWalker walker = new ParseTreeWalker();
                walker.walk(analyzer, parser.compilationUnit());
            }

            int ridx = 0, cidx = 0;
            Set<String> filePaths = rMap.keySet();
            for (String filePath : filePaths) {
                HashMap<String, String> fResultMap = rMap.get(filePath);
                Set<String> macroIDs = fResultMap.keySet();
                for (String macroID : macroIDs) {
                    cidx = 0;
                    String macroBody = fResultMap.get(macroID);
                    XSSFRow row = sheet.createRow(ridx++);
                    XSSFCell filePathCell = row.createCell(cidx++);
                    XSSFCell mIDCell = row.createCell(cidx++);
                    XSSFCell mBodyCell = row.createCell(cidx++);
                    filePathCell.setCellValue(filePath);
                    mIDCell.setCellValue(macroID);
                    mBodyCell.setCellValue(macroBody);
                }
            }
            workbook.write(fout);
            workbook.close();
        } catch (IOException e) {
            Assertions.fail("Root File Not Found");
        }
    }
}