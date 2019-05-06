package com.samsung.tcm.analysis.c;

import com.samsung.tcm.analysis.common.MethodAnalysisResult;
import com.samsung.tcm.core.parser.c.CLexer;
import com.samsung.tcm.core.parser.c.CParser;
import com.samsung.tcm.schema.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

//https://stackoverflow.com/questions/48320194/antlr-parsing-multiline-define-for-c-g4
//https://stackoverflow.com/questions/25010496/why-is-there-no-viable-alternative-for-include-statement-in-antlr-4-with-c-gram
class CTestcaseAnalyzerTest {
    @Test
    void testDirectives() {
        try {
            InputStream file = this.getClass().getClassLoader().getResourceAsStream("c/basic.c");
            CLexer lexer = new CLexer(new ANTLRInputStream(file));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CParser parser = new CParser(tokenStream);

            CTestCaseAnalysisHelper helper = new CTestCaseAnalysisHelper(makeTestCase());
            CTestCaseAnalyzer analyzer = new CTestCaseAnalyzer(helper);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(analyzer, parser.compilationUnit());

            Hashtable<String, MethodAnalysisResult> analysisResult = helper.getAnalysisResult();

            System.out.println(analysisResult.size());
        } catch (IOException ex) {
            Assertions.fail(ex.getMessage());
        }
    }

    SCTestCase makeTestCase() {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //                                      TIZEN - TCT TC 식별 규칙
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SCTestCase testcase = new SCTestCase(ETestCaseFormatType.CODE);
        // CONFIGURE LANGUAGE & TEST FRAMEWORK
        testcase.setLanguage(ELanguage.C);
        testcase.setTestFramework(ECustomTestFramework.TIZEN_TCT_NATIVE);

        // CONFIGURE RULE : Test Case 식별 규칙
        SCITestCaseIdentifier tcIdentifier1 = new SCITestCaseIdentifier(
                "TC_ID_RULE_1",
                "utc",
                ETestCaseIdentifyMethod.PREFIX,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        SCITestCaseIdentifier tcIdentifier2 = new SCITestCaseIdentifier(
                "TC_ID_RULE_2",
                "ITc",
                ETestCaseIdentifyMethod.PREFIX,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        SCITestCaseIdentifier tcIdentifier3 = new SCITestCaseIdentifier(
                "TC_ID_RULE_3",
                "CTs",
                ETestCaseIdentifyMethod.PREFIX,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        testcase.addTCIdentifier(tcIdentifier1);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionStr(tcIdentifier1.getID() + "|" + tcIdentifier2.getID() + "|" + tcIdentifier3.getID());
        });


        // CONFIGURE RULE : Negative Case 식별 규칙
        SCITestCaseIdentifier ntcIdentifier = new SCITestCaseIdentifier(
                "NTC_ID_RULE_1",
                "^(.)*(_n)([0-9])*$",
                ETestCaseIdentifyMethod.REGEXPR,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        testcase.addNegativeTCIdentifier(ntcIdentifier);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionForNegTCStr(ntcIdentifier.getID());
        });

        // CONFIGURE RULE : Positive Case 식별 규칙
        SCITestCaseIdentifier ptcIdentifier1 = new SCITestCaseIdentifier(
                "PTC_ID_RULE_1",
                "^(.)*(_p)([0-9])*$",
                ETestCaseIdentifyMethod.REGEXPR,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier1);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionForPosTCStr(ptcIdentifier1.getID());
        });
        return testcase;
    }

}