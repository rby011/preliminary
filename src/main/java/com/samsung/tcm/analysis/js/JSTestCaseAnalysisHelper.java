package com.samsung.tcm.analysis.js;

import com.samsung.tcm.analysis.common.TestCaseAnalysisHelper;
import com.samsung.tcm.core.parser.js.JavaScriptParser;
import com.samsung.tcm.schema.ETestCaseIdentifierLocation;
import com.samsung.tcm.schema.SCTestCase;

public class JSTestCaseAnalysisHelper extends TestCaseAnalysisHelper {
    public JSTestCaseAnalysisHelper(SCTestCase testCase) {
        super(testCase);
    }

    @Override
    public void buildParseTreeMap() {
        parseTreeNodeMap.put(JavaScriptParser.ArgumentsExpressionContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
    }

    @Override
    public void buildParseTreeMapPos() {
        parseTreeNodeMapPos.put(JavaScriptParser.ArgumentsContext.class.getName(), ETestCaseIdentifierLocation.PARAMETER_NAME);
    }

    @Override
    public void buildParseTreeMapNeg() {
        parseTreeNodeMapNeg.put(JavaScriptParser.ArgumentsContext.class.getName(), ETestCaseIdentifierLocation.PARAMETER_NAME);
    }
}
