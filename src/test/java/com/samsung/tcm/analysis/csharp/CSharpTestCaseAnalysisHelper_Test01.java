package com.samsung.tcm.analysis.csharp;

import com.samsung.tcm.analysis.common.TestCaseUnitAnalysis;
import com.samsung.tcm.analysis.common.ETestCaseUnitAnalysisResult;
import com.samsung.tcm.core.parser.csharp.CSharpParser;
import com.samsung.tcm.exceptions.NoMatchingIdentifiersException;
import com.samsung.tcm.schema.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;


class TestClass {
    static final ETestType testType3 = ETestType.UNIT_TEST;
    ETestType testType4 = ETestType.UNIT_TEST;
}

class CSharpTestCaseAnalysisHelper_Test01 {

    @org.junit.jupiter.api.Test
    void needToCheckForTCIdentify() {
        CSharpTestCaseAnalysisHelper helper = makeHelper();

        ETestCaseIdentifierLocation locationSchema = (ETestCaseIdentifierLocation) helper.getLocationSchema(CSharpParser.AttributeContext.class.getName());
        Assertions.assertEquals(locationSchema, ETestCaseIdentifierLocation.ATTRIBUTE);

        String attrClsName = CSharpParser.AttributeContext.class.getName();

        Assertions.assertTrue(helper.needToCheckForTCIdentify(attrClsName));
        Assertions.assertTrue(helper.needToCheckForNegTCIdentify(attrClsName));

        String methodNameClsName = CSharpParser.Method_member_nameContext.class.getName();
        Assertions.assertTrue(helper.needToCheckForPosTCIdentify(methodNameClsName));
        Assertions.assertTrue(helper.needToCheckForPosTCIdentify(attrClsName));
    }


    static final ETestType testTypeE2 = ETestType.UNIT_TEST;

    @org.junit.jupiter.api.Test
    void hashtableWithEnumTest() {
        Hashtable<ETestType, String> table = new Hashtable<>();
        ETestType testTypeE1 = ETestType.UNIT_TEST;
        table.put(testTypeE1, ETestType.UNIT_TEST.toString());
        String value = table.get(testTypeE2);
        Assertions.assertEquals(ETestType.UNIT_TEST.toString(), value);

        Hashtable<String, ETestType> table1 = new Hashtable<>();
        table1.put(ETestType.UNIT_TEST.toString(), testTypeE1);
        ETestType eTestType = table1.get(ETestType.UNIT_TEST.toString());
        Assertions.assertEquals(TestClass.testType3, eTestType);
        ETestType testType4 = new TestClass().testType4;
        Assertions.assertEquals(testType4, eTestType);
        Assertions.assertEquals(ETestType.UNIT_TEST, eTestType);

        Assertions.assertTrue(table.containsKey(testTypeE1));
    }

    @org.junit.jupiter.api.Test
    void getLocationSchema() {
        CSharpTestCaseAnalysisHelper helper = makeHelper();
        ETestCaseIdentifierLocation locationSchema = (ETestCaseIdentifierLocation) helper.getLocationSchema(CSharpParser.AttributeContext.class.getName());
        Assertions.assertEquals(locationSchema, ETestCaseIdentifierLocation.ATTRIBUTE);

        ETestCaseIdentifierLocation locationSchema1 = (ETestCaseIdentifierLocation) helper.getLocationSchema(CSharpParser.Method_member_nameContext.class.getName());
        Assertions.assertEquals(locationSchema1, ETestCaseIdentifierLocation.METHOD_NAME);

        ETestCaseIdentifierLocation locationSchemaForPos = (ETestCaseIdentifierLocation) helper.getLocationSchemaForPos(CSharpParser.AttributeContext.class.getName());
        Assertions.assertEquals(locationSchemaForPos, ETestCaseIdentifierLocation.ATTRIBUTE);

        ETestCaseIdentifierLocation locationSchemaForPos1 = (ETestCaseIdentifierLocation) helper.getLocationSchemaForPos(CSharpParser.Method_member_nameContext.class.getName());
        Assertions.assertEquals(locationSchemaForPos1, ETestCaseIdentifierLocation.METHOD_NAME);

        ETestCaseIdentifierLocation locationSchemaForPos2 = (ETestCaseIdentifierLocation) helper.getLocationSchemaForPos(CSharpParser.AttributeContext.class.getName());
        Assertions.assertEquals(locationSchemaForPos2, ETestCaseIdentifierLocation.ATTRIBUTE);

        ETestCaseIdentifierLocation locationSchemaForNeg = (ETestCaseIdentifierLocation) helper.getLocationSchemaForNeg(CSharpParser.AttributeContext.class.getName());
        Assertions.assertEquals(locationSchemaForNeg, ETestCaseIdentifierLocation.ATTRIBUTE);

        ETestCaseIdentifierLocation locationSchemaForNeg1 = (ETestCaseIdentifierLocation) helper.getLocationSchemaForNeg(CSharpParser.Method_member_nameContext.class.getName());
        Assertions.assertEquals(locationSchemaForNeg1, ETestCaseIdentifierLocation.METHOD_NAME);
    }

    @org.junit.jupiter.api.Test
    void analyzeTC() {
        CSharpTestCaseAnalysisHelper helper = makeHelper();

        try {
            boolean verdict = true;

            String parseTreeContextClsName = CSharpParser.AttributeContext.class.getName();

            HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> analysisTable = helper.getTestCaseAnalysis(parseTreeContextClsName);
            Set<TestCaseUnitAnalysis> analyses = analysisTable.keySet();
            for (TestCaseUnitAnalysis analysis : analyses) {
                String ID = analysis.getID();
                String idString = analysis.getIdString();
                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();

                helper.putUnitAnalysisResult(parseTreeContextClsName, ID, verdict);
            }
            for (TestCaseUnitAnalysis analysis : analyses) {
                String ID = analysis.getID();
                String idString = analysis.getIdString();
                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();

                boolean result = helper.getUnitAnalysisResult(parseTreeContextClsName, ID);
                Assertions.assertEquals(result, verdict);
            }
        } catch (NoMatchingIdentifiersException ex) {
            Assertions.fail();
        }
    }

    @org.junit.jupiter.api.Test
    void analyzeTC_ForPos() {
        CSharpTestCaseAnalysisHelper helper = makeHelper();

        try {
            boolean verdict = true;

            /**
             * Attribute @ ParseTree Node
             */
            // ParseTree Node 에서 체크해야 할 항목을 가지고 온다
            String parseTreeContextClsName = CSharpParser.AttributeContext.class.getName();
            HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> analysisTable = helper.getTestCaseAnalysisForPosTC(parseTreeContextClsName);

            // 개별 체크 항목별로 체크하여 결과를 저장한다
            Set<TestCaseUnitAnalysis> analyses = analysisTable.keySet();
            for (TestCaseUnitAnalysis analysis : analyses) {
                String ID = analysis.getID();
                String idString = analysis.getIdString();
                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();

                // do something to check

                // 체크 결과를 저정한다
                helper.putUnitAnalysisResultForPosTC(parseTreeContextClsName, ID, verdict);
            }

            // 저장 결과를 확인한다
            for (TestCaseUnitAnalysis analysis : analyses) {
                String idString = analysis.getIdString();
                String ID = analysis.getID();

                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();
                boolean result = helper.getUnitAnalysisResultForPosTC(parseTreeContextClsName, ID);

                System.out.println(analysis + " = " + result);

                Assertions.assertEquals(result, verdict);
            }

            /**
             * Method Declaration Node @ Abstract Syntax Tree
             */
            parseTreeContextClsName = CSharpParser.Method_member_nameContext.class.getName();
            analysisTable = helper.getTestCaseAnalysisForPosTC(parseTreeContextClsName);
            if (analysisTable == null) Assertions.fail();
            // 개별 체크 항목별로 체크하여 결과를 저장한다
            analyses = analysisTable.keySet();

            if (analyses == null) Assertions.fail();

            for (TestCaseUnitAnalysis analysis : analyses) {
                String ID = analysis.getID();
                String idString = analysis.getIdString();
                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();

                // do something to check

                // 체크 결과를 저정한다
                helper.putUnitAnalysisResultForPosTC(parseTreeContextClsName, ID, verdict);
            }

            // 저장 결과를 확인한다
            for (TestCaseUnitAnalysis analysis : analyses) {
                String ID = analysis.getID();
                String idString = analysis.getIdString();
                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();
                boolean result = helper.getUnitAnalysisResultForPosTC(parseTreeContextClsName, ID);

                System.out.println(analysis + " = " + result);

                Assertions.assertEquals(result, verdict);
            }

        } catch (NoMatchingIdentifiersException ex) {
            Assertions.fail();
        }
    }

    @org.junit.jupiter.api.Test
    void analyzeTC_ForNeg() {
        CSharpTestCaseAnalysisHelper helper = makeHelper();

        try {
            boolean verdict = true;

            String parseTreeContextClsName = CSharpParser.AttributeContext.class.getName();

            HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> analysisTable = helper.getTestCaseAnalysisForNegTC(parseTreeContextClsName);

            Set<TestCaseUnitAnalysis> analyses = analysisTable.keySet();
            for (TestCaseUnitAnalysis analysis : analyses) {
                String ID = analysis.getID();
                String idString = analysis.getIdString();
                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();

                helper.putUnitAnalysisResultForNegTC(parseTreeContextClsName, ID, verdict);
            }
            for (TestCaseUnitAnalysis analysis : analyses) {
                String ID = analysis.getID();
                String idString = analysis.getIdString();
                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();

                boolean result = helper.getUnitAnalysisResultForNegTC(parseTreeContextClsName, ID);
                Assertions.assertEquals(result, verdict);
            }
        } catch (NoMatchingIdentifiersException ex) {
            Assertions.fail();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                               Test Harness
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @NotNull
    private CSharpTestCaseAnalysisHelper makeHelper() {
        SCTestCase scTestCase = makeTestCaseSchema();
        return new CSharpTestCaseAnalysisHelper(scTestCase);
    }

    @NotNull
    private SCTestCase makeTestCaseSchema() {
        SCTestCase testcase = new SCTestCase(ETestCaseFormatType.CODE);

        // 1. CONFIGURE RULE : Test Case 식별 규칙
        SCITestCaseIdentifier tcIdentifier = new SCITestCaseIdentifier(
                "TC_ID_RULE_1",
                "Test",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addTCIdentifier(tcIdentifier);

        // 2. CONFIGURE RULE : Positive Case 식별 규칙
        SCITestCaseIdentifier ptcIdentifier = new SCITestCaseIdentifier(
                "POS_TC_ID_RULE_1",
                "Category(\"P1\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier);
        ptcIdentifier = new SCITestCaseIdentifier(
                "POS_TC_ID_RULE_2",
                "Category(\"P3\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier);
        ptcIdentifier = new SCITestCaseIdentifier(
                "POS_TC_ID_RULE_3",
                "_P",
                ETestCaseIdentifyMethod.POSTFIX,
                ETestCaseIdentifierLocation.METHOD_NAME
        );
        testcase.addPositiveTCIdentifier(ptcIdentifier);

        // 3. CONFIGURE RULE : Negative Case 식별 규칙
        SCITestCaseIdentifier ntcIdentifier = new SCITestCaseIdentifier(
                "NEG_TC_ID_RULE_1",
                "Category(\"P2\")",
                ETestCaseIdentifyMethod.EXACT,
                ETestCaseIdentifierLocation.ATTRIBUTE
        );
        testcase.addNegativeTCIdentifier(ntcIdentifier);


        return testcase;
    }
}