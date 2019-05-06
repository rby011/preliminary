package com.samsung.tcm.analysis.csharp;

import com.samsung.tcm.analysis.common.*;
import com.samsung.tcm.core.loc.CodeCounter;
import com.samsung.tcm.core.loc.UCCFile;
import com.samsung.tcm.core.parser.csharp.CSharpParser;
import com.samsung.tcm.core.parser.csharp.CSharpParserBaseListener;
import com.samsung.tcm.exceptions.NoMatchingIdentifiersException;
import com.samsung.tcm.exceptions.NotSupportIdentifierAnalysisException;
import com.samsung.tcm.schema.ETestCaseIdentifyMethod;
import com.samsung.tcm.schema.ETestCaseType;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CSharpTestCaseAnalyzer extends CSharpParserBaseListener implements CommonToken {// TODO ADD (CommonToken)
    private TestCaseAnalysisHelper helper;

    private boolean needCheckAttribute = false;
    private boolean needCheckForTCInAttribute = false, needCheckForPosTCInAttribute = false, needCheckForNegTCInAttribute = false;
    private boolean needCheckForTCInMethodName = false, needCheckForPosTCInMethodName = false, needCheckForNegTCInMethodName = false;

    private boolean isInMethodBody = false, isInMethodDecl = false, isInInvocation = false;

    private Stack<String> nsStack = new Stack<>(), clsStack = new Stack<>();// TODO ADD

    private MethodAnalysisResult methodAnalysisResult = null;

    public CSharpTestCaseAnalyzer(@NotNull TestCaseAnalysisHelper helper) {
        this.helper = helper;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                               파일의 최상위 루트
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterCompilation_unit(CSharpParser.Compilation_unitContext ctx) {
        super.enterCompilation_unit(ctx);

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
            System.out.println("[WARNING] Loc context for C# is null");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                   함수가 소속될 네임스페이스와 클래스를 식별한다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterNamespace_declaration(CSharpParser.Namespace_declarationContext ctx) {
        super.enterNamespace_declaration(ctx);
        List<ParseTree> childNodes = ctx.children;
        ParseTree parseTree = childNodes.get(1);
        String namespaceId = "";
        if (parseTree != null) namespaceId = parseTree.getText();
        if (!nsStack.isEmpty())
            nsStack.push(nsStack.peek() + NAMESPACE_BEFORE_DELIMITER + namespaceId);
        else
            nsStack.push(namespaceId);
    }

    @Override
    public void exitNamespace_body(CSharpParser.Namespace_bodyContext ctx) {
        super.exitNamespace_body(ctx);
        nsStack.pop();
    }

    @Override
    public void enterClass_definition(CSharpParser.Class_definitionContext ctx) {
        super.enterClass_definition(ctx);
        List<ParseTree> children = ctx.children;
        ParseTree parseTree = children.get(1);
        String classId = "";
        if (parseTree != null) classId = parseTree.getText();
        if (clsStack.isEmpty())
            clsStack.push(classId);
        else
            clsStack.push(clsStack.peek() + CLASS_BEFORE_DELIMITER + classId);
    }

    @Override
    public void exitClass_definition(CSharpParser.Class_definitionContext ctx) {
        super.exitClass_definition(ctx);
        clsStack.pop();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                    ATTRIBUTE 체크 필요 여부 판단 및 체크
    // TODO 현재는 Attribute Argument 노드 분석하지 않고 전체 Attribute Text 매칭을 통해 진행하고 있어 향후 수정 필요
    //       Parse 단에서 이미 Tokenizing 통해 Trim 작업등은 진행하고 있어 동작은 하고 있음
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterType_declaration(CSharpParser.Type_declarationContext ctx) {
        super.enterType_declaration(ctx);
        needCheckAttribute = false;// 클래스에 명기된 ATTRIBUTE 는 무시한다
    }

    @Override
    public void enterClass_member_declaration(CSharpParser.Class_member_declarationContext ctx) {
        super.enterClass_member_declaration(ctx);

        needCheckAttribute = false;

        CSharpParser.Common_member_declarationContext cmdCtx = ctx.common_member_declaration();
        if (cmdCtx == null) return;

        // @ VOID method_declaration 는 ATTRIBUTE 를 분석한다
        if (cmdCtx.method_declaration() != null) {
            needCheckAttribute = true;
            return;
        }

        // @ typed_method_declaration 는 ATTRIBUTE 를 분석한다
        CSharpParser.Typed_member_declarationContext typed_member_declarationContext = cmdCtx.typed_member_declaration();
        if (typed_member_declarationContext != null) {
            if (typed_member_declarationContext.method_declaration() != null)
                needCheckAttribute = true;
        }
    }

    @Override
    public void enterAttribute(CSharpParser.AttributeContext ctx) {
        super.enterAttribute(ctx);
        if (!needCheckAttribute) return;

        String className = ctx.getClass().getName();
        // 해당 노드에서 체크할 필요가 있는지 점검한다
        needCheckForTCInAttribute = helper.needToCheckForTCIdentify(className);
        needCheckForPosTCInAttribute = helper.needToCheckForPosTCIdentify(className);
        needCheckForNegTCInAttribute = helper.needToCheckForNegTCIdentify(className);

        if (!needCheckForTCInAttribute && !needCheckForPosTCInAttribute && !needCheckForNegTCInAttribute) return;

        // 체크할 Expression 을 추출한다
        String attrFullExpr = ctx.getText();
        CSharpParser.Namespace_or_type_nameContext namespace_or_type_nameContext = ctx.namespace_or_type_name();
        if (namespace_or_type_nameContext == null) {
            // TODO WARNING LOG
            System.err.println("[WARNING] Attribute name is not defined! SKip to analyze this : " + ctx.getText());
            needCheckForTCInAttribute = needCheckForPosTCInAttribute = needCheckForNegTCInAttribute = false;
            needCheckAttribute = false;
            return;
        }
        String attrNameExpr = namespace_or_type_nameContext.getText();

        // 추출한 Expression 을 체크하고 결과를 저장한다.
        if (needCheckForTCInAttribute) {
            try {
                matchWithSchemaIdentifiers(attrNameExpr, className, ETestCaseType.NONE);
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
                // TODO : INFO LOG 및 대응 로직 필요. 아마도 로직 오류. Do not Throw Exception!
            }
        }
        if (needCheckForPosTCInAttribute) {
            try {
                matchWithSchemaIdentifiers(attrFullExpr, className, ETestCaseType.POSITIVE);
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
                // TODO : INFO LOG 및 대응 로직 필요. 아마도 로직 오류. Do not Throw Exception!
            }
        }

        if (needCheckForNegTCInAttribute) {
            try {
                matchWithSchemaIdentifiers(attrFullExpr, className, ETestCaseType.NEGATIVE);
            } catch (NotSupportIdentifierAnalysisException | NoMatchingIdentifiersException e) {
                e.printStackTrace();
                // TODO : INFO LOG 및 대응 로직 필요. 아마도 로직 오류. Do not Throw Exception!
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          Method 선언부 체크
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterMethod_declaration(CSharpParser.Method_declarationContext ctx) {
        super.enterMethod_declaration(ctx);
        needCheckAttribute = false;                         // 메서드 위한 어트리뷰트 분석 완료
        isInMethodDecl = true;                              // 메서드 선언 시작
        methodAnalysisResult = new MethodAnalysisResult();  // 메서드 단위 분석 결과
    }

    @Override
    public void enterMethod_member_name(CSharpParser.Method_member_nameContext ctx) {
        super.enterMethod_member_name(ctx);

        if (!isInMethodDecl) return;

        String nsId = "", clsId = "";
        if (!clsStack.isEmpty())
            clsId = clsStack.peek();
        else
            System.out.println("[WARNING] METHOD IS DEFINED OUT SIDE OF CLASS");

        if (!nsStack.isEmpty())
            nsId = nsId + NAMESPACE_BEFORE_DELIMITER + nsStack.peek();
        else
            nsId = clsId;

        String methodNameExpr = ctx.getText();//A::B() 형태도 A::B 로 이름 정의

        methodAnalysisResult.setNamespace(nsId);
        methodAnalysisResult.setMethodName(methodNameExpr);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                    Method Body 의 Structural Property 분석
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterMethod_body(CSharpParser.Method_bodyContext ctx) {
        super.enterMethod_body(ctx);
        if (!isInMethodDecl) return;
        isInMethodBody = true;

        String expr = "";
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
            System.out.println("[WARNING] Loc context for C# is null");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                            Method Invocation @ METHOD BODY 분석 통해 Assertion 분석
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void enterPrimary_expression(CSharpParser.Primary_expressionContext ctx) {
        super.enterPrimary_expression(ctx);
        List<CSharpParser.Method_invocationContext> methodCallList = ctx.method_invocation();
        if (methodCallList.size() == 0) return;

        CSharpParser.Primary_expression_startContext primary_expression_startContext = ctx.primary_expression_start();
    }

    @Override
    public void enterMethod_invocation(CSharpParser.Method_invocationContext ctx) {
        super.enterMethod_invocation(ctx);
        if (!isInMethodBody) return;

        CSharpParser.Primary_expressionContext parent = null;

        try {
            parent = (CSharpParser.Primary_expressionContext) ctx.getParent();
        } catch (ClassCastException ex) {
            // TODO WARNING LOG 필요
            return; // 문법상으로는 Primary_expressionContext 이 method_invocation() 의 유일한 부모이다.
        }

        CSharpParser.Primary_expression_startContext primary_expression_startContext = parent.primary_expression_start();
        if (primary_expression_startContext == null) return; // primary_expression_start 에서 온것이 아니면 빠져나간다

        List<CSharpParser.Member_accessContext> member_accessContexts = parent.member_access();
        if (member_accessContexts == null) {
            String calleeMethodName = primary_expression_startContext.getText();
            if (helper.getAssertionExpression().contains(calleeMethodName, true)) {
                methodAnalysisResult.setWeakAssertions(1 + methodAnalysisResult.getWeakAssertions());
                helper.getFileResult().addAssertions(1);
            }
        } else {
            String prev = primary_expression_startContext.getText();
            for (CSharpParser.Member_accessContext ctxMemberAccess : member_accessContexts) {
                CSharpParser.IdentifierContext identifier = ctxMemberAccess.identifier();
                if (identifier == null) {
                    break;
                } else {
                    String cur = identifier.getText();
                    // TODO : 현재는 namespace.namespace.Assert.pass() 와 같은 구문만 처리한다
                    //  Assert.pass().throwexcpetion(); 와 같은 구문은 처리하지 못한다
                    if (helper.getAssertionExpression().contains(prev, cur)) {
                        methodAnalysisResult.setStrongAssertions(1 + methodAnalysisResult.getStrongAssertions());
                        helper.getFileResult().addAssertions(1);
                        break;
                    }
                    prev = cur;
                }
            }
        }
        isInInvocation = true;
    }

    @Override
    public void exitMethod_invocation(CSharpParser.Method_invocationContext ctx) {
        super.exitMethod_invocation(ctx);
        if (!isInInvocation) return;

        if (methodAnalysisResult == null) {
            isInInvocation = false;
            return;
        }
        isInInvocation = false;
    }


    @Override
    public void exitMethod_declaration(CSharpParser.Method_declarationContext ctx) {
        super.exitMethod_declaration(ctx);
        if (!isInMethodDecl || !isInMethodBody) return;

        // 각 메서드의 TC , Positive TC, Negative TC 여부를 분석하고 저장한다.
        if (needCheckForTCInAttribute || needCheckForTCInMethodName)
            methodAnalysisResult.setTC(helper.decideTestCase(ETestCaseType.NONE));
        if (needCheckForNegTCInAttribute || needCheckForNegTCInMethodName)
            methodAnalysisResult.setNegativeTC(helper.decideTestCase(ETestCaseType.NEGATIVE));
        if (needCheckForPosTCInAttribute || needCheckForPosTCInMethodName)
            methodAnalysisResult.setPositiveTC(helper.decideTestCase(ETestCaseType.POSITIVE));

        // 메서드 별 분석 결과 객체를 생성한 키로 저장한다
        helper.putMethodAnalysisResult(methodAnalysisResult.getTestCaseSignature(), methodAnalysisResult);

        // 상태변수를 초기화 한다
        initForMethodLevel();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          TC 식별 분석에 사용된다.
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
                return result;
            }
        }
        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                              UTILITY METHODS
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private UCCFile calcLogicalLoc(String methodBody) {
        CodeCounter locCodeCounter = helper.getLocCodeCounter();

        if (locCodeCounter == null) return null;

        UCCFile uccFile = new UCCFile();
        uccFile.feededLine = "";
        uccFile.orgLine = methodBody;

        locCodeCounter.MCountSLOC(uccFile);

        return uccFile;
    }

    private void initForMethodLevel() {
        methodAnalysisResult = null;
        isInMethodBody = false;

        needCheckForTCInMethodName = needCheckForTCInAttribute = false;
        needCheckForPosTCInMethodName = needCheckForPosTCInAttribute = false;
        needCheckForNegTCInMethodName = needCheckForNegTCInAttribute = false;

        // 다음 메서드 분석을 위해 Helper 를 리셋한다
        helper.reset();
    }
}