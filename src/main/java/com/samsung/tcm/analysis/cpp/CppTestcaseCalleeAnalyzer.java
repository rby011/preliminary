package com.samsung.tcm.analysis.cpp;

import com.samsung.tcm.analysis.common.CommonToken;
import com.samsung.tcm.core.parser.cpp.CPP14BaseVisitor;
import com.samsung.tcm.core.parser.cpp.CPP14Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class CppTestcaseCalleeAnalyzer extends CPP14BaseVisitor implements CommonToken {
    private CppTestCaseAnalysisHelper helper = null;

    // 순회 유형을 저장, 판단하기 위한 상태 변수이다.
    private boolean beingTraversedForFunctionCall, beingTraversedForFunctionName, beingTraversedForParamCount;

    // 순회를 통해 도출할 값이다.
    private String calledFuncName = null, calledFuncQualifiedName = null;

    public CppTestcaseCalleeAnalyzer() {
        this(null);
    }

    public CppTestcaseCalleeAnalyzer(CppTestCaseAnalysisHelper helper) {
        this.beingTraversedForFunctionCall = false;
        this.beingTraversedForFunctionName = false;
        this.beingTraversedForParamCount = false;
        this.helper = helper;
    }

    @Override
    public Object visitPostfixexpression(CPP14Parser.PostfixexpressionContext ctx) {
        PostfixPreAnalysisResult result = isPostfixExprForFunctionCall(ctx);
        if (result.isForFunctionCall) {
            // 순회중 또다른 함수 호출 구문을 만나면 순회를 중지한다.
            if (beingTraversedForFunctionCall) {
                beingTraversedForFunctionCall = false;
                return true;
            }
            // 함수 호출 구문을 분석하기 위한 트리 순회이다
            beingTraversedForFunctionCall = true;
            {
                // 호출되는 함수의 이름을 구하기 위한 트리 순회이다
                beingTraversedForFunctionName = true;
                {
                    visitPostfixexpression((CPP14Parser.PostfixexpressionContext) ctx.children.get(0));
                }
                beingTraversedForFunctionName = false;

                // 호출되는 함수의 파라미터 개수를 구하기 위한 트리 순회이다.
                if (result.hasExpressionList) {
                    beingTraversedForParamCount = true;
                    {
                        visitExpressionlist(result.expressionlist);
                    }
                    beingTraversedForParamCount = false;
                }

                // 두 가지 분석을 완료 후 순회를 종료한다
                return true;
            }
        }
        return super.visitPostfixexpression(ctx);
    }

    @Override
    public Object visitQualifiedid(CPP14Parser.QualifiedidContext ctx) {
        if (beingTraversedForFunctionCall && beingTraversedForFunctionName && !beingTraversedForParamCount) {
            if (calledFuncQualifiedName == null) calledFuncQualifiedName = "";
            calledFuncQualifiedName = CommonToken.NAMESPACE_BEFORE_DELIMITER + ctx.getText();
            return true;
        }
        return super.visitQualifiedid(ctx);
    }

    @Override
    public Object visitUnqualifiedid(CPP14Parser.UnqualifiedidContext ctx) {
        if (beingTraversedForFunctionCall && beingTraversedForFunctionName && !beingTraversedForParamCount) {
            calledFuncName = ctx.getText();
            return true;
        }
        return super.visitUnqualifiedid(ctx);
    }


    public static PostfixPreAnalysisResult isPostfixExprForFunctionCall(CPP14Parser.PostfixexpressionContext ctx) {
        List<ParseTree> children = ctx.children;
        PostfixPreAnalysisResult result = new PostfixPreAnalysisResult();

        int childNodeSize = children.size();
        if (childNodeSize < 3) return result;

        ParseTree th1stNode = children.get(0);
        if (!(th1stNode instanceof CPP14Parser.PostfixexpressionContext)) return result;

        ParseTree lastNode = children.get(childNodeSize - 1);
        if (!lastNode.getText().equals(CommonToken.PARENTHIS_CLOSE)) return result;

        ParseTree midNode = children.get(childNodeSize - 2);
        if (midNode.getText().equals(CommonToken.PARENTHIS_OPEN)) {
            result.isForFunctionCall = true;
        } else if (midNode instanceof CPP14Parser.ExpressionlistContext) {
            result.expressionlist = (CPP14Parser.ExpressionlistContext) midNode;
            result.isForFunctionCall = result.hasExpressionList = true;
        }

        return result;
    }

    public String getCalledFuncQualifiedName() {
        return calledFuncQualifiedName;
    }

    public String getCalledFuncName() {
        return calledFuncName;
    }

    static class PostfixPreAnalysisResult {
        boolean isForFunctionCall, hasExpressionList;
        CPP14Parser.ExpressionlistContext expressionlist;
    }
}