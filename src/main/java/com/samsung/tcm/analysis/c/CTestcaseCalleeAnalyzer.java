package com.samsung.tcm.analysis.c;

import com.samsung.tcm.analysis.common.CommonToken;
import com.samsung.tcm.analysis.cpp.CppTestCaseAnalysisHelper;
import com.samsung.tcm.core.parser.c.CBaseVisitor;
import com.samsung.tcm.core.parser.c.CParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class CTestcaseCalleeAnalyzer extends CBaseVisitor implements CommonToken {
    private CppTestCaseAnalysisHelper helper = null;

    // 순회 유형을 저장, 판단하기 위한 상태 변수이다.
    private boolean beingTraversedForFunctionCall, beingTraversedForFunctionName, beingTraversedForParamCount;

    // 순회를 통해 도출할 값이다.
    private String calledFuncName = null;

    public CTestcaseCalleeAnalyzer() {
        this(null);
    }

    public CTestcaseCalleeAnalyzer(CppTestCaseAnalysisHelper helper) {
        this.beingTraversedForFunctionCall = false;
        this.beingTraversedForFunctionName = false;
        this.beingTraversedForParamCount = false;
        this.helper = helper;
    }

    @Override
    public Object visitPostfixExpression(CParser.PostfixExpressionContext ctx) {
        CTestcaseCalleeAnalyzer.PostfixPreAnalysisResult result = CTestcaseCalleeAnalyzer.isPostfixExprForFunctionCall(ctx);
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
                    visitPostfixExpression((CParser.PostfixExpressionContext) ctx.children.get(0));
                }
                beingTraversedForFunctionName = false;

                //                if (result.hasExpressionList) {
                //                    beingTraversedForParamCount = true;
                //                    {
                //                        visitExpressionlist(result.expressionlist);
                //                    }
                //                    beingTraversedForParamCount = false;
                //                }

                // 두 가지 분석을 완료 후 순회를 종료한다
                return true;
            }
        }

        return super.visitPostfixExpression(ctx);
    }

    @Override
    public Object visitPrimaryExpression(CParser.PrimaryExpressionContext ctx) {
        if (beingTraversedForFunctionCall && beingTraversedForFunctionName && !beingTraversedForParamCount) {
            calledFuncName = ctx.getText();
            return true;
        }
        return super.visitPrimaryExpression(ctx);
    }

    public static PostfixPreAnalysisResult isPostfixExprForFunctionCall(CParser.PostfixExpressionContext ctx) {
        List<ParseTree> children = ctx.children;
        PostfixPreAnalysisResult result = new PostfixPreAnalysisResult();

        int childNodeSize = children.size();
        if (childNodeSize < 3) return result;

        ParseTree th1stNode = children.get(0);
        if (!(th1stNode instanceof CParser.PostfixExpressionContext)) return result;

        ParseTree lastNode = children.get(childNodeSize - 1);
        if (!lastNode.getText().equals(CommonToken.PARENTHIS_CLOSE)) return result;

        ParseTree midNode = children.get(childNodeSize - 2);
        if (midNode.getText().equals(CommonToken.PARENTHIS_OPEN)) {
            result.isForFunctionCall = true;
        } else if (midNode instanceof CParser.ArgumentExpressionListContext) {
            result.argExprList = (CParser.ArgumentExpressionListContext) midNode;
            result.isForFunctionCall = result.hasExpressionList = true;
        }

        return result;
    }

    public String getCalledFuncName() {
        return calledFuncName;
    }

    static class PostfixPreAnalysisResult {
        boolean isForFunctionCall, hasExpressionList;
        CParser.ArgumentExpressionListContext argExprList;
    }
}