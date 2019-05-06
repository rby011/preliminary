package com.samsung.tcm.analysis.js;

import com.samsung.tcm.analysis.common.TestCaseAnalysisHelper;
import com.samsung.tcm.core.loc.CodeCounter;
import com.samsung.tcm.core.loc.UCCFile;
import com.samsung.tcm.core.parser.js.JavaScriptParser;
import com.samsung.tcm.core.parser.js.JavaScriptParserBaseVisitor;
import com.samsung.tcm.schema.assertion.SCAssertion;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class JSFunctionExpressionAnalyzer extends JavaScriptParserBaseVisitor {
    private boolean toCheckChain, done;
    private int assertCnt = 0, loc = 0, sloc = 0, psloc = 0;

    private TestCaseAnalysisHelper helper;

    public JSFunctionExpressionAnalyzer(TestCaseAnalysisHelper helper) {
        this.helper = helper;
    }

    @Override
    public Object visitFunctionExpression(JavaScriptParser.FunctionExpressionContext ctx) {
        String expr = "";
        if (!done) {
            try {
                int bidx = ctx.start.getStartIndex(), eidx = ctx.stop.getStopIndex();
                expr = ctx.start.getInputStream().getText(new Interval(bidx, eidx));
            } catch (Exception ex) {
                expr = ctx.getText();
            }

            UCCFile result = calcLogicalLoc(expr);
            if (result != null) {
                this.loc = result.NumLSLOC;
                this.sloc = result.NumLSLOC;
                this.psloc = result.NumPSLOC;
            }
            done = true;
        }
        return super.visitFunctionExpression(ctx);
    }

    @Override
    public Object visitFunctionBody(JavaScriptParser.FunctionBodyContext ctx) {
        return super.visitFunctionBody(ctx);
    }

    @Override
    public Object visitArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
        // Assertion 분석
        List<ParseTree> children = ctx.children;
        ParseTree th1stNode = children.get(0);
        if (th1stNode instanceof JavaScriptParser.MemberDotExpressionContext) {
            toCheckChain = true;
            {
                visitMemberDotExpression((JavaScriptParser.MemberDotExpressionContext) th1stNode);
            }
            toCheckChain = false;
            return true;
        } else if (th1stNode instanceof JavaScriptParser.IdentifierExpressionContext) {
            SCAssertion assertionExpression = helper.getAssertionExpression();
            if (assertionExpression != null) {
                if (assertionExpression.contains(th1stNode.getText())) assertCnt++;
            } else {
                System.out.println("[WARNING] Assertion context for JavaScript is null");
            }
            return true;
        }
        return super.visitArgumentsExpression(ctx);
    }

    @Override
    public Object visitMemberDotExpression(JavaScriptParser.MemberDotExpressionContext ctx) {
        if (toCheckChain) {
            List<ParseTree> children = ctx.children;
            ParseTree th1st = children.get(0);
            if (th1st instanceof JavaScriptParser.IdentifierExpressionContext) {
                SCAssertion assertionExpression = helper.getAssertionExpression();
                if (assertionExpression != null) {
                    if (assertionExpression.contains(th1st.getText())) assertCnt++;
                } else {
                    System.out.println("[WARNING] Assertion context for JavaScript is null");
                }
            }
        }
        return super.visitMemberDotExpression(ctx);
    }

    @Override
    public Object visitIdentifierExpression(JavaScriptParser.IdentifierExpressionContext ctx) {
        return super.visitIdentifierExpression(ctx);
    }

    public int getAssertCnt() {
        return assertCnt;
    }

    public int getLoc() {
        return loc;
    }

    public int getSloc() {
        return sloc;
    }

    public int getPsloc() {
        return psloc;
    }

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