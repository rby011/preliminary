package com.samsung.tcm.analysis.cpp;

import com.samsung.tcm.analysis.common.*;
import com.samsung.tcm.core.loc.CodeCounter;
import com.samsung.tcm.core.loc.UCCFile;
import com.samsung.tcm.core.parser.cpp.CPP14BaseListener;
import com.samsung.tcm.core.parser.cpp.CPP14Parser;
import com.samsung.tcm.exceptions.NoMatchingIdentifiersException;
import com.samsung.tcm.exceptions.NotSupportIdentifierAnalysisException;
import com.samsung.tcm.schema.ETestCaseIdentifyMethod;
import com.samsung.tcm.schema.ETestCaseType;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class CppTestcaseAnalyzer extends CPP14BaseListener implements CommonToken {// TODO ADD

    private TestCaseAnalysisHelper helper = null;
    private CommonTokenStream tokenStream = null;   // TODO ADD

    // 네임 스페이스 식별 위한 노드 순회시 사용되는 스택과 오류 상태 변수이다.
    private boolean isErrInNamespace = false;
    private Stack<String> nsStack = new Stack<>();

    private ArrayList<String> mrcParams = new ArrayList<>(), funParams = new ArrayList<>();
    private ArrayList<String> finParams = null; //최종 저장될 파라미터 식별자 목록 참조
    private MethodAnalysisResult methodAnalysisResult = null;
    private String funName = "";

    // 함수 선언 식별 위한 노드 순회시 현재  위치와 진입 경로를 표현하기 위한 변수들이다.
    private boolean inParamDclClause, isInFunctionBody, isInFunctionDefinition;

    public CppTestcaseAnalyzer(TestCaseAnalysisHelper helper) {
        this.helper = helper;
    }

    public CppTestcaseAnalyzer(TestCaseAnalysisHelper helper, CommonTokenStream tokenStream) {// TODO ADD
        this.helper = helper;
        this.tokenStream = tokenStream;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          파일의 최상위 루트
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterTranslationunit(CPP14Parser.TranslationunitContext ctx) {
        super.enterTranslationunit(ctx);

        String expr = "";
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
            System.out.println("[WARNING] Loc context for CPP is null");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                   함수가 소속될 네임스페이스와 클래스를 식별한다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterNamespacedefinition(CPP14Parser.NamespacedefinitionContext ctx) {
        super.enterNamespacedefinition(ctx);

        String nsTxt = ctx.getText();
        int bidx = nsTxt.indexOf(NAMESPACE_TOKEN) + NAMESPACE_TOKEN.length();
        int eidx = nsTxt.indexOf(BRACKET_OPEN);

        if (bidx < 0 || eidx < 0) {
            isErrInNamespace = true;
            return;
        }

        String nsIdentifier = nsTxt.substring(bidx, eidx).trim();
        if (!nsStack.isEmpty())
            nsIdentifier = nsStack.peek() + NAMESPACE_BEFORE_DELIMITER + nsIdentifier;
        nsStack.push(nsIdentifier);
    }

    @Override
    public void exitNamespacedefinition(CPP14Parser.NamespacedefinitionContext ctx) {
        super.exitNamespacedefinition(ctx);
        if (!isErrInNamespace)
            nsStack.pop();
        else
            isErrInNamespace = false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          함수 선언부 체크
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterFunctiondefinition(CPP14Parser.FunctiondefinitionContext ctx) {
        super.enterFunctiondefinition(ctx);
        methodAnalysisResult = new MethodAnalysisResult();
        isInFunctionDefinition = true;
        funName = null;
    }

    @Override
    public void exitFunctiondefinition(CPP14Parser.FunctiondefinitionContext ctx) {
        super.exitFunctiondefinition(ctx);
        if (!isInFunctionDefinition) return;

        if (!isInFunctionBody) {
            // 소속 네임스페이스를 설정하고 네임스페이스가 없는 경우 null 로 유지시킨다
            if (!nsStack.isEmpty())
                methodAnalysisResult.setNamespace(nsStack.peek());

            methodAnalysisResult.setMethodName(funName);

            methodAnalysisResult.setTC(helper.decideTestCase(ETestCaseType.NONE));
            methodAnalysisResult.setNegativeTC(helper.decideTestCase(ETestCaseType.NEGATIVE));
            methodAnalysisResult.setPositiveTC(helper.decideTestCase(ETestCaseType.POSITIVE));

            // 함수 LOC 를 분석하고 저장한다. Complexity, Duplication Code 의 분석도 가능하다
            // String funBody = ctx.getText();
            // methodAnalysisResult.setLoc(calcLogicalLoc(funBody));

            helper.putMethodAnalysisResult(methodAnalysisResult.getTestCaseSignature(), methodAnalysisResult);

            // 상태 변수와 자료구조를 초기화 한다.
            isInFunctionDefinition = inParamDclClause = false;
            mrcParams.clear();
            funParams.clear();
            finParams = null;

            // Helper 를 초기화한다
            helper.reset();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                   파라미터 선언 내역 분석 @ 함수 선언
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterDeclaratorid(CPP14Parser.DeclaratoridContext ctx) {
        super.enterDeclaratorid(ctx);
        if (!isInFunctionDefinition) return;

        String expr = ctx.getText();

        if (!isInFunctionBody) {
            if (inParamDclClause) { // 파라미터 선언 구문을 통해 유입된 경우 파라미터 식별자이다.
                funParams.add(expr);
                return;
            }

            // 함수 식별자(e.g., TEST, TEST_F, etc) 로 TC 여부/유형을 식별하고 단위 결과를 저장한다
            funName = expr;
            String clsName = ctx.getClass().getName();
            try {
                if (helper.needToCheckForTCIdentify(clsName)) {
                    matchWithSchemaIdentifiers(expr, clsName, ETestCaseType.NONE);
                }
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
            }
            try {
                if (helper.needToCheckForPosTCIdentify(clsName)) {
                    matchWithSchemaIdentifiers(expr, clsName, ETestCaseType.POSITIVE);
                }
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
            }
            try {
                if (helper.needToCheckForNegTCIdentify(clsName)) {
                    matchWithSchemaIdentifiers(expr, clsName, ETestCaseType.NEGATIVE);
                }
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enterParameterdeclarationclause(CPP14Parser.ParameterdeclarationclauseContext ctx) {
        super.enterParameterdeclarationclause(ctx);
        if (!isInFunctionDefinition) return;

        if (!isInFunctionBody) {
            mrcParams.clear();// for g-test type macro, e.g., TEST(A,B)
            funParams.clear();// for normal function or method e.g., TEST(int A, int B)

            String expr = ctx.getText();
            String[] params = expr.split(",");
            for (int i = 0; i < params.length; i++) mrcParams.add(params[i]);

            inParamDclClause = true;
        }
    }

    @Override
    public void exitParameterdeclarationclause(CPP14Parser.ParameterdeclarationclauseContext ctx) {
        super.exitParameterdeclarationclause(ctx);
        if (!isInFunctionDefinition) return;

        if (!isInFunctionBody) {
            if (!inParamDclClause) return;

            inParamDclClause = false;

            if (funParams.size() == 0)
                finParams = mrcParams;
            else
                finParams = funParams;

            // 파라미터 정보를 저장한다.
            methodAnalysisResult.setParameterCount(finParams.size());
            methodAnalysisResult.setParamIdentifiers(finParams);

            // 파라미터 정보에 대한 "단위" "TC 식별 규칙"의 만족 여부를 판단하고 저장한다
            String clsName = ctx.getClass().getName();
            try {
                if (helper.needToCheckForTCIdentify(clsName)) {
                    matchWithSchemaIdentifiers(finParams, clsName, ETestCaseType.NONE);
                }
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
            }
            try {
                if (helper.needToCheckForPosTCIdentify(clsName)) {
                    matchWithSchemaIdentifiers(finParams, clsName, ETestCaseType.POSITIVE);
                }
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
            }
            try {
                if (helper.needToCheckForNegTCIdentify(ctx.getClass().getName())) {
                    matchWithSchemaIdentifiers(finParams, clsName, ETestCaseType.NEGATIVE);
                }
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                   함수 바디 분석 통해 LOC 분석 @ 함수 선언
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterFunctionbody(CPP14Parser.FunctionbodyContext ctx) {
        super.enterFunctionbody(ctx);
        if (!isInFunctionDefinition) return;
        if (isInFunctionBody) return;
        isInFunctionBody = true;

        String expr = "";
        try {
            int bidx = ctx.start.getTokenIndex(), eidx = ctx.stop.getStopIndex();
            expr = ctx.start.getInputStream().getText(new Interval(bidx, eidx));
        } catch (Exception ex) {
            expr = ctx.getText();
        }

        UCCFile result = calcLogicalLoc(expr);

        methodAnalysisResult.setLoc(result.NumLSLOC);
        methodAnalysisResult.setSloc(result.NumLSLOC);
        methodAnalysisResult.setPsloc(result.NumPSLOC);
    }

    @Override
    public void exitFunctionbody(CPP14Parser.FunctionbodyContext ctx) {
        super.exitFunctionbody(ctx);
        if (!isInFunctionDefinition) return;
        if (!isInFunctionBody) return;
        isInFunctionBody = false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                              함수 호출 분석 통해 ASSERTION 분석 @ 함수 바디 @ 함수 선언
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterPostfixexpression(CPP14Parser.PostfixexpressionContext ctx) {
        super.enterPostfixexpression(ctx);

        if (!isInFunctionDefinition || !isInFunctionBody) return;
        if (!CppTestcaseCalleeAnalyzer.isPostfixExprForFunctionCall(ctx).isForFunctionCall) return;

        CppTestcaseCalleeAnalyzer funCallAnalyzer = new CppTestcaseCalleeAnalyzer();
        funCallAnalyzer.visitPostfixexpression(ctx);

        String calledFuncName = funCallAnalyzer.getCalledFuncName();
        String calledQualiName = funCallAnalyzer.getCalledFuncQualifiedName();

        if (calledQualiName == null || calledFuncName == null) return;

        if (helper.getAssertionExpression().contains(calledFuncName)) {
            methodAnalysisResult.setStrongAssertions(methodAnalysisResult.getStrongAssertions() + 1);
            helper.getFileResult().addAssertions(1);// TODO ADD
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                            TC 식별 분석에 사용된다.
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
    private boolean matchWithSchemaIdentifiers(ArrayList<String> ctxList, String parseTreeNodeClassName, ETestCaseType testCaseType)
            throws NotSupportIdentifierAnalysisException, NoMatchingIdentifiersException {
        boolean result = false;

        // 파스 트리 노드 별로 체크해야 할 항목들을 가지고 온다.
        HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> testCaseAnalyses = null;
        if (ETestCaseType.NONE == testCaseType) { // TC 여부 식별 위함이라면
            testCaseAnalyses = helper.getTestCaseAnalysis(parseTreeNodeClassName);
        } else {
            if (ETestCaseType.NEGATIVE == testCaseType) { // Negative 여부 식별 위함이라면
                testCaseAnalyses = helper.getTestCaseAnalysisForNegTC(parseTreeNodeClassName);
            } else {
                testCaseAnalyses = helper.getTestCaseAnalysisForPosTC(parseTreeNodeClassName);
            }
        }

        // 체크 항목이 없으면 false 를 반환한다
        if (testCaseAnalyses == null) return false;

        // 체크 항목 별로 추출한 expression (i.e., context) 을 체크 한다
        Set<TestCaseUnitAnalysis> analyses = testCaseAnalyses.keySet();
        for (TestCaseUnitAnalysis analysis : analyses) {
            Integer idPosition = analysis.getIdPosition();// 몇 번째 파라미터를 봐야하는지에 대한 규칙이다
            if (idPosition == null) continue;
            if (idPosition >= ctxList.size()) {
                result = false;
            } else {
                String context = ctxList.get(idPosition);
                String idString = analysis.getIdString();
                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();
                result = helper.matchWithParseTreeContext(context, idMethod, idString);
            }

            String ID = analysis.getID();
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
        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                         UTILITY
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TODO : protected 로 해서 추상 부모 클래스로 올려야겠다
    private UCCFile calcLogicalLoc(String methodBody) {
        // COUNT LOC
        CodeCounter locCodeCounter = helper.getLocCodeCounter();

        if (locCodeCounter == null) return null;

        // MESSAGE TO BE GIVEN TO COUNTER
        UCCFile uccFile = new UCCFile();
        uccFile.feededLine = "";
        uccFile.orgLine = methodBody;

        locCodeCounter.MCountSLOC(uccFile);
        return uccFile;
    }
}
