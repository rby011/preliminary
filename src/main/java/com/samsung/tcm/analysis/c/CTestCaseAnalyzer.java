package com.samsung.tcm.analysis.c;

import com.samsung.tcm.analysis.common.*;
import com.samsung.tcm.core.loc.CodeCounter;
import com.samsung.tcm.core.loc.UCCFile;
import com.samsung.tcm.core.parser.c.CBaseListener;
import com.samsung.tcm.core.parser.c.CParser;
import com.samsung.tcm.exceptions.NoMatchingIdentifiersException;
import com.samsung.tcm.exceptions.NotSupportIdentifierAnalysisException;
import com.samsung.tcm.schema.ETestCaseIdentifyMethod;
import com.samsung.tcm.schema.ETestCaseType;
import org.antlr.v4.runtime.misc.Interval;

import java.util.HashMap;
import java.util.Set;

public class CTestCaseAnalyzer extends CBaseListener implements CommonToken {// TODO ADD
    private TestCaseAnalysisHelper helper = null;

    private String funcName = "";
    private MethodAnalysisResult methodAnalysisResult = null;

    private boolean isInFuncDefinition = false, inFunctionBody = false;

    public CTestCaseAnalyzer(TestCaseAnalysisHelper helper) {
        this.helper = helper;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                              최상위 루트
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterCompilationUnit(CParser.CompilationUnitContext ctx) {
        super.enterCompilationUnit(ctx);

        String expr;
        try {
            int bidx = ctx.start.getStartIndex(), eidx = ctx.stop.getStopIndex();
            expr = ctx.start.getInputStream().getText(new Interval(bidx, eidx));
        } catch (Exception ex) {
            expr = ctx.getText();
        }

        UCCFile result = calcLogicalLoc(expr);
        if (result != null) {
            helper.getFileResult().setPsloc(result.NumPSLOC);
            helper.getFileResult().setSloc(result.NumLSLOC);
        } else {
            System.out.println("[WARNING] Loc context for C is null");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                              함수 선언 부
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        super.enterFunctionDefinition(ctx);
        if (isInFuncDefinition) return;

        isInFuncDefinition = true;
        funcName = "";

        // 함수 분석 결과를 저장할 구조를 만든다
        methodAnalysisResult = new MethodAnalysisResult();
    }

    @Override
    public void enterDirectDeclarator(CParser.DirectDeclaratorContext ctx) {
        super.enterDirectDeclarator(ctx);
        if (!isInFuncDefinition) return;

        String declTxt = ctx.getText();

        if (declTxt != null && declTxt.contains("(") && declTxt.contains(")")) {
            CParser.DirectDeclaratorContext directDeclaratorContext = ctx.directDeclarator();
            if (directDeclaratorContext == null) {
                isInFuncDefinition = false;
                // TODO : 함수 분석 포기.WARNING 필요
                return;
            }
            // 함수의 식별자를 추출한다
            this.funcName = directDeclaratorContext.Identifier().getText();
            try {
                // 함수 식별자 저장
                methodAnalysisResult.setMethodName(funcName);
                // 함수의 TC 여부를 주어진 식별 규칙에 맞게 판단하고 결과를 저장한다
                matchWithSchemaIdentifiers(this.funcName, ctx.getClass().getName(), ETestCaseType.NONE);
                matchWithSchemaIdentifiers(this.funcName, ctx.getClass().getName(), ETestCaseType.POSITIVE);
                matchWithSchemaIdentifiers(this.funcName, ctx.getClass().getName(), ETestCaseType.NEGATIVE);
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
                // TODO : WARNING 필요
            }
        }
    }

    @Override
    public void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        super.exitFunctionDefinition(ctx);

        // 현재 함수의 TC , Positive TC, Negative TC 여부를 분석하고 저장한다.
        methodAnalysisResult.setTC(helper.decideTestCase(ETestCaseType.NONE));
        methodAnalysisResult.setNegativeTC(helper.decideTestCase(ETestCaseType.NEGATIVE));
        methodAnalysisResult.setPositiveTC(helper.decideTestCase(ETestCaseType.POSITIVE));

        // 함수내에서 호출했던 다른 함수들을 집계한다. 같은 이름이면 덮어씌운다.
        // for (TestCaseCalleeInMethod c : callees)
        //    methodAnalysisResult.putTestCaseCallee(c.getCalleeMethodName(), c);

        // 함수 별 분석 결과 객체를 생성한 키로 저장한다
        helper.putMethodAnalysisResult(methodAnalysisResult.getTestCaseSignature(), methodAnalysisResult);

        // 다음 함수의 분석을 위해 초기화 한다
        isInFuncDefinition = false;
        funcName = "";
        // candidateFunctionParamCnt = 0;
        // callees.clear();
        helper.reset();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                              함수 바디 @ 함수 선언 부
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterCompoundStatement(CParser.CompoundStatementContext ctx) {
        super.enterCompoundStatement(ctx);
        if (!isInFuncDefinition) return;
        inFunctionBody = true;

        String expr;
        try {
            int bidx = ctx.start.getStartIndex(), eidx = ctx.stop.getStopIndex();
            expr = ctx.start.getInputStream().getText(new Interval(bidx, eidx));
        } catch (Exception ex) {
            expr = ctx.getText();
        }

        UCCFile result = calcLogicalLoc(expr);
        if (result != null) {
            methodAnalysisResult.setLoc(result.NumLSLOC);
            methodAnalysisResult.setSloc(result.NumLSLOC);
            methodAnalysisResult.setPsloc(result.NumPSLOC);
        } else {
            System.out.println("[WARNING] Loc context for C is null");
        }
    }

    @Override
    public void exitCompoundStatement(CParser.CompoundStatementContext ctx) {
        super.exitCompoundStatement(ctx);
        if (!isInFuncDefinition) return;
        if (!inFunctionBody) return;
        inFunctionBody = false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                      함수 호출 구문 @ 함수 바디 @ 함수 선언 부
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterPostfixExpression(CParser.PostfixExpressionContext ctx) {
        super.enterPostfixExpression(ctx);
        if (!isInFuncDefinition || !inFunctionBody) return;
        if (!CTestcaseCalleeAnalyzer.isPostfixExprForFunctionCall(ctx).isForFunctionCall) return;

        CTestcaseCalleeAnalyzer funcCallAnalyzer = new CTestcaseCalleeAnalyzer();
        funcCallAnalyzer.visitPostfixExpression(ctx);
        String calledFuncName = funcCallAnalyzer.getCalledFuncName();

        if (calledFuncName == null) return;

        if (helper.getAssertionExpression().contains(calledFuncName)) {
            methodAnalysisResult.setStrongAssertions(methodAnalysisResult.getStrongAssertions() + 1);
            helper.getFileResult().addAssertions(1);
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          TC 식별 분석에 사용된다.
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TODO : protected 로 해서 추상 부모 클래스로 올려야겠다
    private boolean matchWithSchemaIdentifiers(String context, String parseTreeNodeClassName, ETestCaseType testCaseType)
            throws NotSupportIdentifierAnalysisException, NoMatchingIdentifiersException {
        boolean result = false;

        // 파스 트리 노드 별로 체크해야 할 항목들을 가지고 온다.
        HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> testCaseAnalysis = null;
        if (ETestCaseType.NONE == testCaseType) { // TC 여부 식별 위함이라면
            testCaseAnalysis = helper.getTestCaseAnalysis(parseTreeNodeClassName);
        } else {
            if (ETestCaseType.NEGATIVE == testCaseType) { // Negative 여부 식별 위함이라면
                testCaseAnalysis = helper.getTestCaseAnalysisForNegTC(parseTreeNodeClassName);
            } else {
                testCaseAnalysis = helper.getTestCaseAnalysisForPosTC(parseTreeNodeClassName);
            }
        }

        // 체크 항목이 없으면 false 를 반환한다
        if (testCaseAnalysis == null) return false;

        // 체크 항목 별로 추출한 expression (i.e., context) 을 체크 한다
        Set<TestCaseUnitAnalysis> analyses = testCaseAnalysis.keySet();
        for (TestCaseUnitAnalysis analysis : analyses) {
            String ID = analysis.getID();
            String idString = analysis.getIdString();
            ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();

            result = helper.matchWithParseTreeContext(context, idMethod, idString);

            if (result) {
                if (ETestCaseType.NONE == testCaseType) {
                    helper.putUnitAnalysisResult(parseTreeNodeClassName, ID, result);
                } else {
                    if (ETestCaseType.NEGATIVE == testCaseType) {
                        helper.putUnitAnalysisResultForNegTC(parseTreeNodeClassName, ID, result);
                    } else {
                        helper.putUnitAnalysisResultForPosTC(parseTreeNodeClassName, ID, result);
                    }
                }
            }
        }
        return result;
    }

    // TODO : protected 로 해서 추상 부모 클래스로 올려야겠다
    private UCCFile calcLogicalLoc(String methodBody) {
        // COUNT LOC
        CodeCounter locCodeCounter = helper.getLocCodeCounter();

        if (locCodeCounter == null) return null;

        UCCFile uccFile = new UCCFile();
        uccFile.feededLine = "";
        uccFile.orgLine = methodBody;

        locCodeCounter.MCountSLOC(uccFile);
        return uccFile;
    }
}