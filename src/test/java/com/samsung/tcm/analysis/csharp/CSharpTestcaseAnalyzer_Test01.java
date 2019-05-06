package com.samsung.tcm.analysis.csharp;

import com.samsung.tcm.analysis.common.MethodAnalysisResult;
import com.samsung.tcm.context.TcmContext;
import com.samsung.tcm.core.parser.csharp.CSharpLexer;
import com.samsung.tcm.core.parser.csharp.CSharpParser;
import com.samsung.tcm.schema.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

class CSharpTestcaseAnalyzer_Test01 {
    @Test
    void testWithOneFile() {
        try {
            // DO ANALYSIS
            InputStream file = this.getClass().getClassLoader().getResourceAsStream("csharp_analysis/basic.cs");
            CSharpLexer lexer = new CSharpLexer(new ANTLRInputStream(file));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CSharpParser parser = new CSharpParser(tokenStream);

            parser.addErrorListener(new ANTLRErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                    System.out.println("syntaxError");
                }

                @Override
                public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
                    System.out.println("reportAmbiguity");
                }

                @Override
                public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
                    System.out.println("reportAttemptingFullContext");
                }

                @Override
                public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
                    System.out.println("reportContextSensitivity");
                }
            });

            CSharpTestCaseAnalysisHelper helper = new CSharpTestCaseAnalysisHelper(makeTestCase());
            CSharpTestCaseAnalyzer analyzer = new CSharpTestCaseAnalyzer(helper);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(analyzer, parser.compilation_unit());

            // MAKE VERDICT
            makeVerdict();

            // ASSERTIONS
            Hashtable<String, MethodAnalysisResult> checkResult = helper.getAnalysisResult();
            Assertions.assertEquals(checkResult.size(), numberOfMethod); // number of method
            Set<String> strings = checkResult.keySet();
            for (String mName : strings) {
                // CHECK TC IDENTIFICATION RESULT
                Assertions.assertTrue(tcMap.get(mName), "Fail at " + mName);
                Assertions.assertFalse(negTCMap.get(mName), "Fail at " + mName);
                Assertions.assertTrue(posTCMap.get(mName), "Fail at " + mName);

                // CHECK ASSERTION ANALYSIS RESULT
                MethodAnalysisResult analysisResult = checkResult.get(mName);
                if (mName.equals(methodNames[0])) {
                    Assertions.assertEquals(analysisResult.getStrongAssertions(), 0);
                } else if (mName.equals(methodNames[1])) {
                    Assertions.assertEquals(analysisResult.getStrongAssertions(), 1);
                } else if (mName.equals(methodNames[2])) {
                    Assertions.assertEquals(analysisResult.getStrongAssertions(), 1);
                } else if (mName.equals(methodNames[3])) {
                    Assertions.assertEquals(analysisResult.getStrongAssertions(), 1);
                } else if (mName.equals(methodNames[4])) {
                    Assertions.assertEquals(analysisResult.getStrongAssertions(), 0);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }

    int numberOfMethod;
    String namespace;
    String methodNames[] = new String[5];
    Map<String, Boolean> tcMap = new HashMap<>();
    Map<String, Boolean> negTCMap = new HashMap<>();
    Map<String, Boolean> posTCMap = new HashMap<>();

    void makeVerdict() {
        // MAKE VERDICT
        numberOfMethod = 5;
        namespace = "Xamarin.Forms.Core.UnitTests";
        methodNames[0] = namespace + ".Date_UILK";
        methodNames[1] = namespace + ".DatePicker_UIBH";
        methodNames[2] = namespace + ".MaximumDate_UIBH";
        methodNames[3] = namespace + ".MinimumDate_UIBH";
        methodNames[4] = namespace + ".TextColor_UILK";

        tcMap.clear();
        tcMap.put(methodNames[0], true);
        tcMap.put(methodNames[1], true);
        tcMap.put(methodNames[2], true);
        tcMap.put(methodNames[3], true);
        tcMap.put(methodNames[4], true);

        negTCMap.clear();
        negTCMap.put(methodNames[0], false);
        negTCMap.put(methodNames[1], false);
        negTCMap.put(methodNames[2], false);
        negTCMap.put(methodNames[3], false);
        negTCMap.put(methodNames[4], false);

        posTCMap.clear();
        posTCMap.put(methodNames[0], true);
        posTCMap.put(methodNames[1], true);
        posTCMap.put(methodNames[2], true);
        posTCMap.put(methodNames[3], true);
        posTCMap.put(methodNames[4], true);
    }

    SCTestCase makeTestCase() {
        SCTestCase testcase = new SCTestCase(ETestCaseFormatType.CODE);

        // CONFIGURE LANGUAGE & TEST FRAMEWORK
        testcase.setLanguage(ELanguage.CSHARP);
        testcase.setTestFramework(ETestFramework.NUNIT);

        // CONFIGURE RULE : Test Case 식별 규칙
        SCITestCaseIdentifier tcIdentifier = new SCITestCaseIdentifier(
                "TC_ID_RULE_1",
                "Test",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addTCIdentifier(tcIdentifier);
        Assertions.assertDoesNotThrow(()->{
            testcase.setBoolExpressionStr(tcIdentifier.getID());
        });

        // CONFIGURE RULE : Negative Case 식별 규칙
        SCITestCaseIdentifier ntcIdentifier = new SCITestCaseIdentifier(
                "NTC_ID_RULE_1",
                "Category(\"P2\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addNegativeTCIdentifier(ntcIdentifier);
        Assertions.assertDoesNotThrow(()->{
            testcase.setBoolExpressionForNegTCStr(ntcIdentifier.getID());
        });

        // CONFIGURE RULE : Positive Case 식별 규칙
        SCITestCaseIdentifier ptcIdentifier1 = new SCITestCaseIdentifier(
                "PTC_ID_RULE_1",
                "Category(\"P1\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier1);
        SCITestCaseIdentifier ptcIdentifier2 = new SCITestCaseIdentifier(
                "TC_ID_RULE_2",
                "Category(\"P3\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier2);
        SCITestCaseIdentifier ptcIdentifier3 = new SCITestCaseIdentifier(
                "TC_ID_RULE_3",
                "Category(\"P4\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier3);
        Assertions.assertDoesNotThrow(()->{
            testcase.setBoolExpressionForPosTCStr(ptcIdentifier1.getID() + "|" + ptcIdentifier2.getID() + "|" + ptcIdentifier3.getID());
        });
        return testcase;
    }
}