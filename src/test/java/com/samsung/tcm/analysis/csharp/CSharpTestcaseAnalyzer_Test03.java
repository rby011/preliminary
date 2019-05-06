package com.samsung.tcm.analysis.csharp;

import com.samsung.tcm.analysis.common.MethodAnalysisResult;
import com.samsung.tcm.core.loc.CSharpCounter;
import com.samsung.tcm.core.loc.CSharpLanguageProperties;
import com.samsung.tcm.core.parser.csharp.CSharpLexer;
import com.samsung.tcm.core.parser.csharp.CSharpParser;
import com.samsung.tcm.exceptions.ResourceNotFoundException;
import com.samsung.tcm.schema.*;
import com.samsung.tcm.schema.assertion.nunit.SCNUnitAssertion;
import com.samsung.tcm.util.StringSearcher;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * <pre>
 * -----------------------------------------------------------------------
 *                 TC NAME                           IS TC       TC TYPE
 * -----------------------------------------------------------------------
 * Xamarin.Forms.Core.UnitTests.Date_UILK_Test            NO TC        NA
 * Xamarin.Forms.Core.UnitTests.DatePicker_UIBH_Test       TC        NEGATIVE
 * Xamarin.Forms.Core.UnitTests.MaximumDate_UIBH_Test      TC        NEGATIVE
 * Xamarin.Forms.Core.UnitTests.MinimumDate_UIBH          NO TC      POSITIVE
 * Xamarin.Forms.Core.UnitTests.TextColor_UILK_Test       NO TC      POSITIVE
 * -----------------------------------------------------------------------
 * </pre>
 */
class CSharpTestcaseAnalyzer_Test03 {
    @Test
    void testWithOneFile() {
        try {
            // DO ANALYSIS
            InputStream file = this.getClass().getClassLoader().getResourceAsStream("csharp_analysis/testcase03.cs");
            CSharpLexer lexer = new CSharpLexer(new ANTLRInputStream(file));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CSharpParser parser = new CSharpParser(tokenStream);

            CSharpTestCaseAnalysisHelper helper = new CSharpTestCaseAnalysisHelper(makeTestCase());
            CSharpTestCaseAnalyzer analyzer = new CSharpTestCaseAnalyzer(helper);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(analyzer, parser.compilation_unit());


            // MAKE VERDICT
            int numberOfMethod = 5;
            String namespace = "Xamarin.Forms.Core.UnitTests";
            String methodNames[] = {
                    "Xamarin.Forms.Core.UnitTests.Date_UILK_Test",           // TC   POSITIVE
                    "Xamarin.Forms.Core.UnitTests.DatePicker_UIBH_Test",     // TC   NEGATIVE
                    "Xamarin.Forms.Core.UnitTests.MaximumDate_UIBH_Test",    // TC   NEGATIVE
                    "Xamarin.Forms.Core.UnitTests.MinimumDate_UIBH",         // NO   POSITIVE
                    "Xamarin.Forms.Core.UnitTests.TextColor_UILK_Test"       // NO   POSITIVE
            };

            Map<String, Boolean> tcMap = new HashMap<>();
            tcMap.put(methodNames[0], false);
            tcMap.put(methodNames[1], true);
            tcMap.put(methodNames[2], true);
            tcMap.put(methodNames[3], false);
            tcMap.put(methodNames[4], false);
            Map<String, Boolean> negTCMap = new HashMap<>();
            negTCMap.put(methodNames[0], false);
            negTCMap.put(methodNames[1], true);
            negTCMap.put(methodNames[2], true);
            negTCMap.put(methodNames[3], false);
            negTCMap.put(methodNames[4], false);
            Map<String, Boolean> posTCMap = new HashMap<>();
            posTCMap.put(methodNames[0], false);
            posTCMap.put(methodNames[1], false);
            posTCMap.put(methodNames[2], false);
            posTCMap.put(methodNames[3], true);
            posTCMap.put(methodNames[4], true);

            // ASSERTIONS
            Hashtable<String, MethodAnalysisResult> checkResult = helper.getAnalysisResult();
            Assertions.assertEquals(checkResult.size(), numberOfMethod); // number of method

            for (int i = 0; i < 5; i++) {
                MethodAnalysisResult analysisResult = checkResult.get(methodNames[i]);
                Assertions.assertEquals(analysisResult.isTC(), tcMap.get(methodNames[i]));
            }

            for (int i = 0; i < 5; i++) {
                MethodAnalysisResult analysisResult = checkResult.get(methodNames[i]);
                Assertions.assertEquals(analysisResult.isNegativeTC(), negTCMap.get(methodNames[i]));
            }

            for (int i = 0; i < 5; i++) {
                MethodAnalysisResult analysisResult = checkResult.get(methodNames[i]);
                Assertions.assertEquals(analysisResult.isPositiveTC(), posTCMap.get(methodNames[i]));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }


    SCTestCase makeTestCase() {
        SCTestCase testcase = new SCTestCase(ETestCaseFormatType.CODE);

        // CONFIGURE LANGUAGE & TEST FRAMEWORK
        testcase.setLanguage(ELanguage.CSHARP);
        testcase.setTestFramework(ETestFramework.NUNIT);

        // CONFIGURE RULE : Test Case 식별 규칙
        SCITestCaseIdentifier tcIdentifier1 = new SCITestCaseIdentifier(
                "TC_ID_RULE_1",
                "Test",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        SCITestCaseIdentifier tcIdentifier2 = new SCITestCaseIdentifier(
                "TC_ID_RULE_2",
                "Test",
                ETestCaseIdentifyMethod.POSTFIX,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        testcase.addTCIdentifier(tcIdentifier1);
        testcase.addTCIdentifier(tcIdentifier2);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionStr(tcIdentifier1.getID() + "&" + tcIdentifier2.getID());
        });


        // CONFIGURE RULE : Negative Case 식별 규칙
        SCITestCaseIdentifier ntcIdentifier = new SCITestCaseIdentifier(
                "NTC_ID_RULE_1",
                "Category(\"P2\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addNegativeTCIdentifier(ntcIdentifier);
        Assertions.assertDoesNotThrow(() -> {
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
                "PTC_ID_RULE_2",
                "Category(\"P3\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier2);
        SCITestCaseIdentifier ptcIdentifier3 = new SCITestCaseIdentifier(
                "PTC_ID_RULE_3",
                "Category(\"P4\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier3);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionForPosTCStr(ptcIdentifier1.getID() + "|" + ptcIdentifier2.getID() + "|" + ptcIdentifier3.getID());
        });
        return testcase;
    }
}