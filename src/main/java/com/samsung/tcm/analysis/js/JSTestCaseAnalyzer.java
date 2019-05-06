package com.samsung.tcm.analysis.js;

import com.samsung.tcm.analysis.common.*;
import com.samsung.tcm.core.loc.CodeCounter;
import com.samsung.tcm.core.loc.UCCFile;
import com.samsung.tcm.core.parser.js.JavaScriptParser;
import com.samsung.tcm.core.parser.js.JavaScriptParserBaseListener;
import com.samsung.tcm.exceptions.NoMatchingIdentifiersException;
import com.samsung.tcm.exceptions.NotSupportIdentifierAnalysisException;
import com.samsung.tcm.schema.ETestCaseIdentifyMethod;
import com.samsung.tcm.schema.ETestCaseType;
import com.samsung.tcm.schema.SCTestCase;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class JSTestCaseAnalyzer extends JavaScriptParserBaseListener implements CommonToken {
    private SCTestCase testCase;
    private TestCaseAnalysisHelper gHelper;
    private RandomUniqueIDGenerator idGenerator; // 분석 파일 별로 초기화 필요하다

    private Stack<String> grpStack = new Stack<>();
    private Stack<ParseTree> nodeStack = new Stack<>();

    private Stack<TestCaseAnalysisHelper> helperStack = new Stack<>();
    private LinkedList<TestCaseAnalysisHelper> helperList = new LinkedList<>();
    private Stack<MethodAnalysisResult> methodStack = new Stack<>();

    public JSTestCaseAnalyzer(TestCaseAnalysisHelper helper) {
        this.testCase = helper.getTestCase();
        this.gHelper = helper;
        this.idGenerator = new RandomUniqueIDGenerator();
    }

    private TestCaseAnalysisHelper createHelper() {
        return new JSTestCaseAnalysisHelper(this.testCase);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                              최상위 루트
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterProgram(JavaScriptParser.ProgramContext ctx) {
        super.enterProgram(ctx);
        String expr;
        try {
            int bidx = ctx.start.getStartIndex(), eidx = ctx.stop.getStopIndex();
            expr = ctx.start.getInputStream().getText(new Interval(bidx, eidx));
        } catch (Exception ex) {
            expr = ctx.getText();
        }

        UCCFile result = calcLogicalLoc(expr);
        if (result != null) {
            gHelper.getFileResult().setPsloc(result.NumPSLOC);
            gHelper.getFileResult().setSloc(result.NumLSLOC);
        } else {
            System.out.println("[WARNING] Loc context for JavaScript is null");
        }
    }

    @Override
    public void exitProgram(JavaScriptParser.ProgramContext ctx) {
        super.exitProgram(ctx);
        // Global Helper 에 복사한다. TODO 다중 식별 규칙 정의 지원위해 다른 방법 찾아 볼 필요 있다
        for (TestCaseAnalysisHelper helper : helperList) {
            Hashtable<String, MethodAnalysisResult> analysisResult = helper.getAnalysisResult();
            Set<String> keys = analysisResult.keySet();
            for (String key : keys) {
                this.gHelper.putMethodAnalysisResult(key, analysisResult.get(key));
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                              함수 호출 부
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
        super.enterArgumentsExpression(ctx);

        // 첫 번째 자식 노드가 IdentifierExpression 인 함수 호출 구문을 분석 대상으로 한다
        List<ParseTree> children = ctx.children;
        if (children.size() < 2) return;
        ParseTree th1stNode = children.get(0);
        if (!(th1stNode instanceof JavaScriptParser.IdentifierExpressionContext)) return;
        if (!isForCase(ctx) && !isForSutie(ctx)) return;

        // Helper 를 생성하고 저장한다
        TestCaseAnalysisHelper helper = createHelper();
        helperStack.push(helper);

        // 호출 함수의 이름을 저장한다
        String idExpr = th1stNode.getText();
        MethodAnalysisResult methodAnalysisResult = new MethodAnalysisResult();
        methodAnalysisResult.setMethodName(idExpr);
        methodStack.push(methodAnalysisResult);

        // 부모/자식 관계 추적 위해 노드를 저장한다
        nodeStack.push(ctx);

        // TC 여부 판단위한 단위 식별 규칙 만족 여부를 판단하고 저장한다
        String clsName = ctx.getClass().getName();
        try {
            if (helper.needToCheckForTCIdentify(clsName)) {
                matchWithSchemaIdentifiers(helper, idExpr, clsName, ETestCaseType.NONE);
            }
        } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
        super.exitArgumentsExpression(ctx);
        // 첫 번째 자식 노드가 IdentifierExpression 인 함수 호출 구문을 분석 대상으로 한다
        List<ParseTree> children = ctx.children;
        if (children.size() < 2) return;
        ParseTree th1stNode = children.get(0);
        if (!(th1stNode instanceof JavaScriptParser.IdentifierExpressionContext)) return;
        if (!isForCase(ctx) && !isForSutie(ctx)) return;


        if (nodeStack.isEmpty() || !nodeStack.peek().equals(ctx)) {
            System.out.println("[WARNING] Stack for the ArgumentExpression node is invalid");
        } else {
            nodeStack.pop();
        }

        if (grpStack.isEmpty()) {
            System.out.println("[WARNING] Stack for the ArgumentExpression id is invalid");
        } else {
            grpStack.pop();
        }

        if (methodStack.isEmpty()) {
            System.out.println("[WARNING] Stack for the Method Analysis result is invalid");
        } else {
            MethodAnalysisResult pop = methodStack.pop();

            if (helperStack.isEmpty()) {
                System.out.println("[WARNING] Helper stack is null");
                return;
            }
            TestCaseAnalysisHelper helper = helperStack.pop();

            // TC 여부, TC 유형을 최종 판단하고 이를 helper 에 저장한다
            pop.setTC(helper.decideTestCase(ETestCaseType.NONE));
            pop.setPositiveTC(helper.decideTestCase(ETestCaseType.POSITIVE));
            pop.setNegativeTC(helper.decideTestCase(ETestCaseType.NEGATIVE));

            // 최종 분석 결과를 저장한다
            helperList.addFirst(helper);
            helper.putMethodAnalysisResult(pop.getTestCaseSignature(), pop);
        }
    }

    @Override
    public void enterArguments(JavaScriptParser.ArgumentsContext ctx) { // 파라미터 정보를 통해 TC 유형을 식별한다
        super.enterArguments(ctx);

        // 앞선 분석 대상 함수 호출 구문만을 분석 대상으로 한다
        if (nodeStack.isEmpty()) return;
        ParserRuleContext parent = ctx.getParent();
        if (!parent.equals(nodeStack.peek())) return;
        if (!isForCase((JavaScriptParser.ArgumentsExpressionContext) parent) &&
                !isForSutie((JavaScriptParser.ArgumentsExpressionContext) parent)) return;

        if (helperStack.isEmpty()) {
            System.out.println("[WARNING] Helper stack is empty");
            return;
        }
        TestCaseAnalysisHelper helper = helperStack.peek();

        List<ParseTree> children = ctx.children;// { '(' , arg1 , ',' , arg2  ...  ')' }

        ParseTree th1stNode = null, th2ndNode = null;

        if (children.size() >= 3) th1stNode = children.get(1);
        if (children.size() >= 5) th2ndNode = children.get(3);

        // 첫 번째 아규먼트로 그룹핑 식별자를 생성한다
        String th1stNodeExpr;
        if (th1stNode instanceof JavaScriptParser.LiteralExpressionContext) {
            th1stNodeExpr = stripQuotation(th1stNode.getText());
        } else {
            th1stNodeExpr = idGenerator.generateUniqueID();// 파일 내에서 유일성 보장하는 식별자 생성한다.
        }

        String grpId;
        if (grpStack.isEmpty()) {
            grpStack.push((grpId = th1stNodeExpr));
        } else {
            grpStack.push((grpId = grpStack.peek() + CommonToken.FUNCTION_BEFORE_DELIMITER + th1stNodeExpr));
        }

        if (methodStack.isEmpty()) {
            System.out.println("[WARNING] Method stack is empty, but needs to update top");
        } else {
            methodStack.peek().setNamespace(grpId);
            ArrayList<String> params = new ArrayList<>();
            params.add(th1stNodeExpr);
            methodStack.peek().setParamIdentifiers(params);
            methodStack.peek().setParameterCount((children.size() - 1) / 2);
        }

        // 두 번째 아규먼트를 분석, LoC 와 Assertion 을 계수한다
        if (th2ndNode instanceof JavaScriptParser.FunctionExpressionContext) {
            JSFunctionExpressionAnalyzer subAnalyzer = new JSFunctionExpressionAnalyzer(gHelper);
            subAnalyzer.visitFunctionExpression((JavaScriptParser.FunctionExpressionContext) th2ndNode);
            if (methodStack.isEmpty()) {
                System.out.println("[WARNING] Method stack is empty, but needs to update top");
            } else {
                methodStack.peek().setStrongAssertions(subAnalyzer.getAssertCnt());
                methodStack.peek().setLoc(subAnalyzer.getLoc());
                methodStack.peek().setPsloc(subAnalyzer.getPsloc());
                methodStack.peek().setSloc(subAnalyzer.getSloc());
            }
        } else {
            // 분석 불가능함을 명시적으로 표시한다
            methodStack.peek().setStrongAssertions(-1);
            methodStack.peek().setSloc(-1);
            methodStack.peek().setLoc(-1);
            methodStack.peek().setPsloc(-1);
        }


        String clsName = ctx.getClass().getName();
        boolean debug = false;
        try {
            if (helper.needToCheckForPosTCIdentify(clsName)) {
                debug = matchWithSchemaIdentifiers(helper, methodStack.peek().getParamIdentifiers(), clsName, ETestCaseType.POSITIVE);
            }
        } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
            e.printStackTrace();
        }
        try {
            if (helper.needToCheckForNegTCIdentify(clsName)) {
                debug = matchWithSchemaIdentifiers(helper, methodStack.peek().getParamIdentifiers(), clsName, ETestCaseType.NEGATIVE);
            }
        } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                            TC 식별 분석에 사용된다.
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean matchWithSchemaIdentifiers(TestCaseAnalysisHelper helper, String context, String parseTreeNodeClassName, ETestCaseType testCaseType)
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

    private boolean matchWithSchemaIdentifiers(TestCaseAnalysisHelper helper, ArrayList<String> ctxList, String parseTreeNodeClassName, ETestCaseType testCaseType)
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
    //                                                 UTILITY
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private UCCFile calcLogicalLoc(String methodBody) {
        // COUNT LOC
        CodeCounter locCodeCounter = gHelper.getLocCodeCounter();

        if (locCodeCounter == null) return null;

        UCCFile uccFile = new UCCFile();
        uccFile.feededLine = "";
        uccFile.orgLine = methodBody;

        locCodeCounter.MCountSLOC(uccFile);
        return uccFile;
    }

    private String stripQuotation(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(str.indexOf("\"") + 1, str.lastIndexOf("\""));
        }
        return str;
    }

    private boolean isForSutie(JavaScriptParser.ArgumentsExpressionContext ctx) {
        List<ParseTree> children = ctx.children;

        if (children.size() == 0) return false;

        ParseTree idNode = children.get(0);
        if (!(idNode instanceof JavaScriptParser.IdentifierExpressionContext)) return false;

        return idNode.getText().equals("describe"); // TODO "describe" 정보를 스키마 추가 필요함
    }

    private boolean isForCase(JavaScriptParser.ArgumentsExpressionContext ctx) {
        List<ParseTree> children = ctx.children;

        if (children.size() == 0) return false;

        ParseTree idNode = children.get(0);
        if (!(idNode instanceof JavaScriptParser.IdentifierExpressionContext)) return false;

        //for (SCITestCaseIdentifier identifier : testCase.getTcIdentifiers()) {
        //    if (identifier.getIdentifier().equals(idNode.getText())) return true;
        //}

        return idNode.getText().equals("it");// TODO "describe" 추가 후 위 코드로 대체
    }
}

class RandomUniqueIDGenerator {
    private HashSet<Integer> set = new HashSet<>();
    private static int seed = 12345;
    private final int MAX = 0xffff;

    public String generateUniqueID() {
        int cnt = 0;
        int id = pseudo_rand(MAX);
        while (set.contains(id) && cnt < 100) {
            id = pseudo_rand(MAX);
            cnt++;
        }
        if (cnt == 100) System.out.println("[WARNING] Fail to generate unique id");
        set.add(cnt);
        return Integer.toHexString(id);
    }

    public void init() {
        set.clear();
        seed = 12345;
    }

    private int pseudo_rand(int max) {
        seed = (int) (((long) seed * 1103515245 + 12345) & 0x0FFFFFFF);
        return seed % max;
    }
}