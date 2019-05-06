//package com.samsung.tcm.analysis.cpp;
//
//import com.samsung.tcm.analysis.common.*;
//import com.samsung.tcm.core.loc.CodeCounter;
//import com.samsung.tcm.core.loc.UCCFile;
//import com.samsung.tcm.core.parser.cpp.CPP14BaseListener;
//import com.samsung.tcm.core.parser.cpp.CPP14Parser;
//import com.samsung.tcm.exceptions.NoMatchingIdentifiersException;
//import com.samsung.tcm.exceptions.NotSupportIdentifierAnalysisException;
//import com.samsung.tcm.schema.ETestCaseIdentifyMethod;
//import com.samsung.tcm.schema.ETestCaseType;
//
//import java.util.*;
//
//public class CppTestcaseAnalyzer extends CPP14BaseListener implements CommonToken {
//    // 공조 분석을 위한 Helper 클래스이다
//    private TestCaseAnalysisHelper helper;
//
//    // 메서드 별로 집계된 분석 결과를 저장한다.
//    private MethodAnalysisResult methodAnalysisResult = null;
//
//    // 네임 스페이스 식별 위한 노드 순회시 사용되는 스택과 오류 상태 변수이다.
//    private boolean isErrInNamespace = false;
//    private Stack<String> nsStack = new Stack<>();
//
//    // 함수 선언 구문의 파라미터 식별자 목록을 저장한다.
//    private ArrayList<String> mrcParams = new ArrayList<>();
//    private ArrayList<String> funParams = new ArrayList<>();
//    private ArrayList<String> finParams = null; //최종 저장될 파라미터 식별자 목록
//
//    // 함수 선언 식별 위한 노드 순회시 현재  위치와 진입 경로를 표현하기 위한 변수들이다.
//    private boolean inParamDclClause, isInFunctionBody, isInFunctionDefinition;
//    private String funName = "";    // 함수 이름, 함수 바디 구문을 저장한다
//
//    // 함수 선언 내 호출 함수 목록을 저장한다
//    private LinkedList<TestCaseCalleeInMethod> calleeList = null;
//
//    public CppTestcaseAnalyzer(TestCaseAnalysisHelper helper) {
//        this.helper = helper;
//    }
//
//    @Override
//    public void enterNamespacedefinition(CPP14Parser.NamespacedefinitionContext ctx) {
//        super.enterNamespacedefinition(ctx);
//
//        String nsTxt = ctx.getText();
//        int bidx = nsTxt.indexOf(NAMESPACE_TOKEN) + NAMESPACE_TOKEN.length();
//        int eidx = nsTxt.indexOf(BRACKET_OPEN);
//
//        if (bidx < 0 || eidx < 0) {
//            isErrInNamespace = true;
//            return;
//        }
//
//        // 계층적 구조를 '.' 으로 표현하고 익명인 경우 empty string 으로 처리한다
//        String nsIdentifier = nsTxt.substring(bidx, eidx).trim();
//        if (!nsStack.isEmpty())
//            nsIdentifier = nsStack.peek() + NAMESPACE_BEFORE_DELIMITER + nsIdentifier;
//        nsStack.push(nsIdentifier);
//    }
//
//    @Override
//    public void exitNamespacedefinition(CPP14Parser.NamespacedefinitionContext ctx) {
//        super.exitNamespacedefinition(ctx);
//        if (!isErrInNamespace)
//            nsStack.pop();
//        else
//            isErrInNamespace = false;
//    }
//
//    @Override
//    public void enterFunctiondefinition(CPP14Parser.FunctiondefinitionContext ctx) {
//        super.enterFunctiondefinition(ctx);
//        methodAnalysisResult = new MethodAnalysisResult();
//        calleeList = new LinkedList<>();
//        isInFunctionDefinition = true;
//        funName = null;
//    }
//
//    @Override
//    public void enterPostfixexpression(CPP14Parser.PostfixexpressionContext ctx) {
//        super.enterPostfixexpression(ctx);
//        if (!isInFunctionDefinition) return;
//        if (!isInFunctionBody) return;
//        if (!CppTestcaseCalleeAnalyzer.isPostfixExprForFunctionCall(ctx).isForFunctionCall) return;
//
//        // 현 노드를 루트로해서 별도 분석을 수행한다
//        CppTestcaseCalleeAnalyzer funCallAnalyzer = new CppTestcaseCalleeAnalyzer();
//        funCallAnalyzer.visitPostfixexpression(ctx);
//
//        String calledFuncName = funCallAnalyzer.getCalledFuncName();
//        String calledQualifiedName = funCallAnalyzer.getCalledFuncQualifiedName();
//        int paramCount = funCallAnalyzer.getParamCount();
//
//        helper.getAssertionExpression().contains(calledFuncName);
//
//        calleeList.addFirst(new TestCaseCalleeInMethod(calledFuncName, paramCount));// 최종 리스트는 호출 순서데로 저장한다
//    }
//
//    @Override
//    public void enterDeclaratorid(CPP14Parser.DeclaratoridContext ctx) {
//        super.enterDeclaratorid(ctx);
//        if (!isInFunctionDefinition) return;
//
//        String expr = ctx.getText();
//
//        if (!isInFunctionBody) {    // 함수 바디 안에 있지 않다
//            if (inParamDclClause) { // 파라미터 선언 구문을 통해 유입된 경우,
//                funParams.add(expr);// 현재 표현식은 파라미터 식별자이다.
//                return;
//            }
//
//            // 함수 식별자(e.g., TEST, TEST_F, etc) 로 TC 여부/유형을 식별하고 단위 결과를 저장한다
//            funName = expr;
//            String clsName = ctx.getClass().getName();
//            try {
//                if (helper.needToCheckForTCIdentify(clsName)) {
//                    matchWithSchemaIdentifiers(expr, clsName, ETestCaseType.NONE);
//                }
//            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (helper.needToCheckForPosTCIdentify(clsName)) {
//                    matchWithSchemaIdentifiers(expr, clsName, ETestCaseType.POSITIVE);
//                }
//            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (helper.needToCheckForNegTCIdentify(clsName)) {
//                    matchWithSchemaIdentifiers(expr, clsName, ETestCaseType.NEGATIVE);
//                }
//            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    @Override
//    public void enterParameterdeclarationclause(CPP14Parser.ParameterdeclarationclauseContext ctx) {
//        super.enterParameterdeclarationclause(ctx);
//        if (!isInFunctionDefinition) return;
//
//        if (!isInFunctionBody) {
//            mrcParams.clear();// for g-test type macro, e.g., TEST(A,B)
//            funParams.clear();// for normal function or method e.g., TEST(int A, int B)
//
//            String expr = ctx.getText();
//            String[] params = expr.split(",");
//            for (int i = 0; i < params.length; i++)
//                // 함수, 매크로 구분 없이 토큰나이징하므로 함수인 경우 잘못된 결과를 갖는다.
//                // 이는 exit 호출시 정제된다
//                mrcParams.add(params[i]);
//
//            inParamDclClause = true;
//        }
//    }
//
//    @Override
//    public void exitParameterdeclarationclause(CPP14Parser.ParameterdeclarationclauseContext ctx) {
//        super.exitParameterdeclarationclause(ctx);
//        if (!isInFunctionDefinition) return;
//
//        if (!isInFunctionBody) {
//            inParamDclClause = false;
//
//            if (funParams.size() == 0)
//                finParams = mrcParams;
//            else
//                finParams = funParams;
//
//            // TEST 등의 토큰에만 의존하고 있으며 아규먼트 유/무, 개수에는 독립적으로 Test Case 가 식별된다.
//            // if (toAnalyze.size() != 2) {
//            //    isNotTC = true;
//            //    return; // 모든 GTest 의 TEST 매크로의 파라미터는 2 개이다.
//            // }
//
//            // 파라미터 정보를 저장한다.
//            methodAnalysisResult.setParameterCount(finParams.size());
//            methodAnalysisResult.setParamIdentifiers(finParams);
//
//            // 파라미터 정보에 대한 "단위" "TC 식별 규칙"의 만족 여부를 판단하고 저장한다
//            String clsName = ctx.getClass().getName();
//            try {
//                if (helper.needToCheckForTCIdentify(clsName)) {
//                    matchWithSchemaIdentifiers(finParams, clsName, ETestCaseType.NONE);
//                }
//            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (helper.needToCheckForPosTCIdentify(clsName)) {
//                    matchWithSchemaIdentifiers(finParams, clsName, ETestCaseType.POSITIVE);
//                }
//            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (helper.needToCheckForNegTCIdentify(ctx.getClass().getName())) {
//                    matchWithSchemaIdentifiers(finParams, clsName, ETestCaseType.NEGATIVE);
//                }
//            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public void enterFunctionbody(CPP14Parser.FunctionbodyContext ctx) {
//        super.enterFunctionbody(ctx);
//        if (!isInFunctionDefinition) return;
//        if (isInFunctionBody) return;
//        isInFunctionBody = true;
//    }
//
//    @Override
//    public void exitFunctionbody(CPP14Parser.FunctionbodyContext ctx) {
//        super.exitFunctionbody(ctx);
//        if (!isInFunctionDefinition) return;
//        if (!isInFunctionBody) return;
//        isInFunctionBody = false;
//    }
//
//    @Override
//    public void exitFunctiondefinition(CPP14Parser.FunctiondefinitionContext ctx) {
//        super.exitFunctiondefinition(ctx);
//        if (!isInFunctionDefinition) return;
//
//        if (!isInFunctionBody) {
//            // 소속 네임스페이스를 설정하고 네임스페이스가 없는 경우 null 로 유지시킨다
//            if (!nsStack.isEmpty())
//                methodAnalysisResult.setNamespace(nsStack.peek());
//
//            // 함수의 이름을 설정한다. 클래스 멤버의 정의인 경우에도 ClassName::MethodName 으로 식별된다.
//            methodAnalysisResult.setMethodName(funName);
//
//            // 본 함수의 TC 유형을 분석한다
//            methodAnalysisResult.setTC(helper.decideTestCase(ETestCaseType.NONE));
//            methodAnalysisResult.setNegativeTC(helper.decideTestCase(ETestCaseType.NEGATIVE));
//            methodAnalysisResult.setPositiveTC(helper.decideTestCase(ETestCaseType.POSITIVE));
//            // if (isNotTC) methodAnalysisResult.setTC(false); 파라미터 유/무, 개수에 관계 없이 TEST 등의 토큰에만 의존한다
//
//            // 함수 LOC 를 분석하고 저장한다. Complexity, Duplication Code 의 분석도 가능하다
//            String funBody = ctx.getText();
//            methodAnalysisResult.setLoc(calcLogicalLoc(funBody));
//
//            // 함수내에서 호출했던 함수 정보를 저장한다.
//            for (TestCaseCalleeInMethod callee : calleeList) {
//                methodAnalysisResult.putTestCaseCallee(callee.getKey(), callee);
//            }
//
//            // 함수 선언문내에서 호출되는 Assertion 문장 개수를 카운트한다
//            int assertCnt = 0;
//            Set<String> calleeSet = methodAnalysisResult.getCalleeMap().keySet();
//            for (String callee : calleeSet) {
//                int bidx = callee.indexOf(FUNCTION_BEFORE_DELIMITER);
//                int eidx = callee.indexOf(PARAMETER_COUNT_AFTER_DELIMITER);
//
//                if (bidx == -1 && eidx == -1) {
//                    System.out.println("[WARNING]");
//                    continue;
//                }
//
//                String calleeName = "";
//                if (bidx == -1) calleeName = callee.substring(0, eidx);
//                else calleeName = callee.substring(bidx, eidx);
//
//                if (helper.getAssertionExpression().contains(calleeName)) assertCnt++;
//            }
//            methodAnalysisResult.setStrongAssertions(assertCnt);
//
//            // 향후 콜 그래프 생성시 조회를 위한 키를 생성한다.
//            String resultKey;
//            if (methodAnalysisResult.getNamespace() != null)
//                resultKey = methodAnalysisResult.getNamespace() + FUNCTION_BEFORE_DELIMITER + methodAnalysisResult.getMethodName()
//                        + PARAMETER_COUNT_AFTER_DELIMITER + methodAnalysisResult.getParameterCount();
//            else
//                resultKey = methodAnalysisResult.getMethodName() + PARAMETER_COUNT_AFTER_DELIMITER + methodAnalysisResult.getParameterCount();
//
//            // 생성한 키로 결과를 저장한다
//            helper.putMethodAnalysisResult(resultKey, methodAnalysisResult);
//
//            // 상태 변수와 자료구조를 초기화 한다.
//            isInFunctionDefinition = inParamDclClause = false;
//            mrcParams.clear();
//            funParams.clear();
//
//            // Helper 를 초기화한다
//            helper.reset();
//        }
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    //                                          TC 식별 분석에 사용된다.
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    // TODO : protected 로 해서 추상 부모 클래스로 올려야겠다
//    private boolean matchWithSchemaIdentifiers(String context, String parseTreeNodeClassName, ETestCaseType testCaseType)
//            throws NotSupportIdentifierAnalysisException, NoMatchingIdentifiersException {
//        boolean result = false;
//
//        // 파스 트리 노드 별로 체크해야 할 항목들을 가지고 온다.
//        HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> testCaseAnalysis = null;
//        if (ETestCaseType.NONE == testCaseType) { // TC 여부 식별 위함이라면
//            testCaseAnalysis = helper.getTestCaseAnalysis(parseTreeNodeClassName);
//        } else {
//            if (ETestCaseType.NEGATIVE == testCaseType) { // Negative 여부 식별 위함이라면
//                testCaseAnalysis = helper.getTestCaseAnalysisForNegTC(parseTreeNodeClassName);
//            } else {
//                testCaseAnalysis = helper.getTestCaseAnalysisForPosTC(parseTreeNodeClassName);
//            }
//        }
//
//        // 체크 항목이 없으면 false 를 반환한다
//        if (testCaseAnalysis == null) return false;
//
//        // 체크 항목 별로 추출한 expression (i.e., context) 을 체크 한다
//        Set<TestCaseUnitAnalysis> analyses = testCaseAnalysis.keySet();
//        for (TestCaseUnitAnalysis analysis : analyses) {
//            String ID = analysis.getID();
//            String idString = analysis.getIdString();
//            ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();
//
//            result = helper.matchWithParseTreeContext(context, idMethod, idString);
//
//            if (result) {
//                if (ETestCaseType.NONE == testCaseType) {
//                    helper.putUnitAnalysisResult(parseTreeNodeClassName, ID, result);
//                } else {
//                    if (ETestCaseType.NEGATIVE == testCaseType) {
//                        helper.putUnitAnalysisResultForNegTC(parseTreeNodeClassName, ID, result);
//                    } else {
//                        helper.putUnitAnalysisResultForPosTC(parseTreeNodeClassName, ID, result);
//                    }
//                }
//                return result;
//            }
//        }
//        return result;
//    }
//
//    // TODO : protected 로 해서 추상 부모 클래스로 올려야겠다
//    private boolean matchWithSchemaIdentifiers(ArrayList<String> ctxList, String parseTreeNodeClassName, ETestCaseType testCaseType)
//            throws NotSupportIdentifierAnalysisException, NoMatchingIdentifiersException {
//        boolean result = false;
//
//        // 파스 트리 노드 별로 체크해야 할 항목들을 가지고 온다.
//        HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> testCaseAnalyses = null;
//        if (ETestCaseType.NONE == testCaseType) { // TC 여부 식별 위함이라면
//            testCaseAnalyses = helper.getTestCaseAnalysis(parseTreeNodeClassName);
//        } else {
//            if (ETestCaseType.NEGATIVE == testCaseType) { // Negative 여부 식별 위함이라면
//                testCaseAnalyses = helper.getTestCaseAnalysisForNegTC(parseTreeNodeClassName);
//            } else {
//                testCaseAnalyses = helper.getTestCaseAnalysisForPosTC(parseTreeNodeClassName);
//            }
//        }
//
//        // 체크 항목이 없으면 false 를 반환한다
//        if (testCaseAnalyses == null) return false;
//
//        // 체크 항목 별로 추출한 expression (i.e., context) 을 체크 한다
//        Set<TestCaseUnitAnalysis> analyses = testCaseAnalyses.keySet();
//        for (TestCaseUnitAnalysis analysis : analyses) {
//            Integer idPosition = analysis.getIdPosition();// 몇 번째 파라미터를 봐야하는지에 대한 규칙이다
//            if (idPosition == null) continue;
//            if (idPosition >= ctxList.size()) {
//                result = false;
//            } else {
//                String context = ctxList.get(idPosition);
//                String idString = analysis.getIdString();
//                ETestCaseIdentifyMethod idMethod = analysis.getIdMethod();
//                result = helper.matchWithParseTreeContext(context, idMethod, idString);
//            }
//
//            String ID = analysis.getID();
//            if (ETestCaseType.NONE == testCaseType) {
//                helper.putUnitAnalysisResult(parseTreeNodeClassName, ID, result);
//            } else {
//                if (ETestCaseType.NEGATIVE == testCaseType) {
//                    helper.putUnitAnalysisResultForNegTC(parseTreeNodeClassName, ID, result);
//                } else {
//                    helper.putUnitAnalysisResultForPosTC(parseTreeNodeClassName, ID, result);
//                }
//            }
//            return result;
//        }
//        return result;
//    }
//
//    // TODO : protected 로 해서 추상 부모 클래스로 올려야겠다
//    private int calcLogicalLoc(String methodBody) {
//        // COUNT LOC
//        CodeCounter locCodeCounter = helper.getLocCodeCounter();
//
//        if (locCodeCounter == null) return -1;
//
//        // MESSAGE TO BE GIVEN TO COUNTER
//        UCCFile uccFile = new UCCFile();
//        uccFile.feededLine = "";
//        uccFile.orgLine = methodBody;
//
//        locCodeCounter.MCountSLOC(uccFile);
//        return uccFile.NumLSLOC;
//    }
//}
