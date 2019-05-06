package com.samsung.tcm.analysis.c;

import com.samsung.tcm.core.parser.c.CBaseListener;
import com.samsung.tcm.core.parser.c.CParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;

public class CAssertMacroAnalyzer extends CBaseListener {
    private String define = "#define";

    private HashMap<String, String> mMap = null;

    public CAssertMacroAnalyzer(HashMap<String, String> map) {
        this.mMap = map;
    }

    @Override
    public void enterDefineDeclaration(CParser.DefineDeclarationContext ctx) {
        super.enterDefineDeclaration(ctx);
        TerminalNode terminalNode = ctx.DefineBlock();
        String expr = terminalNode.getText();

        int bidx = expr.indexOf(define);
        if (bidx < 0) return;
        bidx = bidx + define.length();

        String macroID = "", macroBody = "";
        int tidx = expr.indexOf("\\"), eidx = 0;
        if (tidx < 0) {// IN CASE OF SINGLE-LINE MACRO
            eidx = expr.indexOf(" ", bidx + 1);
            if (eidx < 0) {
                eidx = expr.length() - 1;
            }
        } else {// IN CASE OF MULTI-LINE MACRO
            eidx = expr.indexOf(")", bidx) + 1;
        }

        macroID = expr.substring(bidx, eidx);
        macroBody = expr.substring(eidx + 1);

        this.mMap.put(macroID, macroBody);
    }
}