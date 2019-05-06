package com.samsung.tcm.analysis.cpp;

import com.samsung.tcm.analysis.common.MethodAnalysisResult;
import com.samsung.tcm.core.parser.cpp.CPP14Lexer;
import com.samsung.tcm.core.parser.cpp.CPP14Parser;
import com.samsung.tcm.schema.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Set;

class CppTestcaseAnalyzer_Test01 {
    @Test
    void testAnalysisTask() {
        try {
            Hashtable<String, MethodAnalysisResult> analysisResult = analyzeFile("cpp/basic.cpp").getAnalysisResult();

            Assertions.assertEquals(2, analysisResult.size()); // 함수 선언 개수

            Set<String> funcKeySet = analysisResult.keySet();

            MethodAnalysisResult methodAnalysisResult = null;
            for (String funcKey : funcKeySet) {
                if (funcKey.equals("TEST|2")) {
                    methodAnalysisResult = analysisResult.get(funcKey);

                    Assertions.assertTrue(methodAnalysisResult.isNegativeTC());
                    Assertions.assertFalse(methodAnalysisResult.isPositiveTC());
                    Assertions.assertTrue(methodAnalysisResult.isTC());

                    Assertions.assertEquals(1, methodAnalysisResult.getStrongAssertions());
                    Assertions.assertEquals(0, methodAnalysisResult.getWeakAssertions());
                    Assertions.assertEquals(0, methodAnalysisResult.getRoughAssertions());

                    //HashMap<String, ArrayList<TestCaseCalleeInMethod>> calleeMap = methodAnalysisResult.getCalleeMap();

                    //Set<String> calleeKeySet = calleeMap.keySet();
                    //Assertions.assertEquals(5, calleeKeySet.size());

                    Assertions.assertEquals(1, methodAnalysisResult.getStrongAssertions());
                } else if (funcKey.equals("TEST_P|2")) {
                    methodAnalysisResult = analysisResult.get(funcKey);

                    Assertions.assertFalse(methodAnalysisResult.isNegativeTC());
                    Assertions.assertTrue(methodAnalysisResult.isPositiveTC());
                    Assertions.assertTrue(methodAnalysisResult.isTC());

                    Assertions.assertEquals(2, methodAnalysisResult.getStrongAssertions());
                    Assertions.assertEquals(0, methodAnalysisResult.getWeakAssertions());
                    Assertions.assertEquals(0, methodAnalysisResult.getRoughAssertions());

                    // HashMap<String, ArrayList<TestCaseCalleeInMethod>> calleeMap = methodAnalysisResult.getCalleeMap();

                    //Set<String> calleeKeySet = calleeMap.keySet();
                    //Assertions.assertEquals(5, calleeKeySet.size());
                } else {
                    Assertions.fail();
                }
            }
        } catch (IOException ex) {
            Assertions.fail(ex.getMessage());
        }
    }

    // @Test
    // TODO : NEED FIX PARSE ERROR , "std::vector<Matcher<int>>" error, "std::vector<Matcher>" is ok.
    void testParseErrorFix() {
        try {
            Hashtable<String, MethodAnalysisResult> analysisResult = analyzeFile("cpp/parse_error.cpp").getAnalysisResult();
            Set<String> funcKeySet = analysisResult.keySet();
            for (String funcKey : funcKeySet) {
                MethodAnalysisResult methodAnalysisResult = analysisResult.get(funcKey);
            }
        } catch (IOException ex) {
            Assertions.fail(ex.getMessage());
        }
    }

    CppTestCaseAnalysisHelper analyzeFile(String rscFilePath) throws IOException {
        InputStream file = this.getClass().getClassLoader().getResourceAsStream(rscFilePath);
        CPP14Lexer lexer = new CPP14Lexer(new ANTLRInputStream(file));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CPP14Parser parser = new CPP14Parser(tokenStream);

        CppTestCaseAnalysisHelper helper = new CppTestCaseAnalysisHelper(makeTestCase());
        CppTestcaseAnalyzer analyzer = new CppTestcaseAnalyzer(helper);

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(analyzer, parser.translationunit());

        return helper;
    }

    SCTestCase makeTestCase() {
        SCTestCase testcase = new SCTestCase(ETestCaseFormatType.CODE);
        // CONFIGURE LANGUAGE & TEST FRAMEWORK
        testcase.setLanguage(ELanguage.CPLUS);
        testcase.setTestFramework(ETestFramework.GTEST);

        // CONFIGURE RULE : Test Case 식별 규칙
        SCITestCaseIdentifier tcIdentifier1 = new SCITestCaseIdentifier(
                "TC_ID_RULE_1",
                "TEST",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        SCITestCaseIdentifier tcIdentifier2 = new SCITestCaseIdentifier(
                "TC_ID_RULE_2",
                "TEST_F",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        SCITestCaseIdentifier tcIdentifier3 = new SCITestCaseIdentifier(
                "TC_ID_RULE_2",
                "TEST_P",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        testcase.addTCIdentifier(tcIdentifier1);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionStr(tcIdentifier1.getID() + "|" + tcIdentifier2.getID() + "|" + tcIdentifier3.getID());
        });

        // CONFIGURE RULE : Negative Case 식별 규칙
        SCITestCaseIdentifier ntcIdentifier = new SCITestCaseIdentifier(
                "NTC_ID_RULE_1",
                "_N",
                ETestCaseIdentifyMethod.POSTFIX,
                ETestCaseIdentifierLocation.PARAMETER_NAME,
                1
        );
        testcase.addNegativeTCIdentifier(ntcIdentifier);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionForNegTCStr(ntcIdentifier.getID());
        });

        // CONFIGURE RULE : Positive Case 식별 규칙
        SCITestCaseIdentifier ptcIdentifier1 = new SCITestCaseIdentifier(
                "PTC_ID_RULE_1",
                "_P",
                ETestCaseIdentifyMethod.POSTFIX,
                ETestCaseIdentifierLocation.PARAMETER_NAME,
                1
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier1);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionForPosTCStr(ptcIdentifier1.getID());
        });
        return testcase;
    }
}