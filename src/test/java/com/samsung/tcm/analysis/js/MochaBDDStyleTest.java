package com.samsung.tcm.analysis.js;

import com.samsung.tcm.core.parser.js.JavaScriptLexer;
import com.samsung.tcm.core.parser.js.JavaScriptParser;
import com.samsung.tcm.schema.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.InputStream;

public class MochaBDDStyleTest {

    @Test
    public void mochaBDDStyleTest02() {
        try {
            JSTestCaseAnalysisHelper helper = analyzeFile("javascript/mocha_bdd_style_02.js");

            System.out.println("EEE");
        } catch (IOException ex) {
            Assertions.fail(ex);
        }
    }

    private JSTestCaseAnalysisHelper analyzeFile(String filePath) throws IOException {
        InputStream file = this.getClass().getClassLoader().getResourceAsStream(filePath);
        JavaScriptLexer lexer = new JavaScriptLexer(new ANTLRInputStream(file));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        JavaScriptParser parser = new JavaScriptParser(tokenStream);

        JSTestCaseAnalysisHelper helper = new JSTestCaseAnalysisHelper(makeTestCase());
        JSTestCaseAnalyzer analyzer = new JSTestCaseAnalyzer(helper);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(analyzer, parser.program());

        return helper;
    }

    SCTestCase makeTestCase() {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //                                      TIZEN - TCT TC 식별 규칙
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SCTestCase testcase = new SCTestCase(ETestCaseFormatType.CODE);
        // CONFIGURE LANGUAGE & TEST FRAMEWORK
        testcase.setLanguage(ELanguage.JAVASCRIPT);
        testcase.setTestFramework(ETestFramework.CHAI);// TODO 구조 변경 필요, 다중 프레임워크인 경우

        // CONFIGURE RULE : Test Case 식별 규칙
        SCITestCaseIdentifier tcIdentifier1 = new SCITestCaseIdentifier(
                "TC_ID_RULE_1",
                "it",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        testcase.addTCIdentifier(tcIdentifier1);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionStr(tcIdentifier1.getID());
        });

        // CONFIGURE RULE : Negative Case 식별 규칙
        SCITestCaseIdentifier ntcIdentifier = new SCITestCaseIdentifier(
                "NTC_ID_RULE_1",
                "_n",
                ETestCaseIdentifyMethod.POSTFIX,
                ETestCaseIdentifierLocation.PARAMETER_NAME,
                0
        );
        testcase.addNegativeTCIdentifier(ntcIdentifier);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionForNegTCStr(ntcIdentifier.getID());
        });

        // CONFIGURE RULE : Positive Case 식별 규칙
        SCITestCaseIdentifier ptcIdentifier1 = new SCITestCaseIdentifier(
                "PTC_ID_RULE_1",
                "_p",
                ETestCaseIdentifyMethod.POSTFIX,
                ETestCaseIdentifierLocation.PARAMETER_NAME,
                0
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier1);
        Assertions.assertDoesNotThrow(() -> {
            testcase.setBoolExpressionForPosTCStr(ptcIdentifier1.getID());
        });

        return testcase;
    }
}
