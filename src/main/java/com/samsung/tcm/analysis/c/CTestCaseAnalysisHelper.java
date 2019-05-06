package com.samsung.tcm.analysis.c;

import com.samsung.tcm.analysis.common.TestCaseAnalysisHelper;
import com.samsung.tcm.core.parser.c.CParser;
import com.samsung.tcm.schema.ETestCaseIdentifierLocation;
import com.samsung.tcm.schema.SCTestCase;

public class CTestCaseAnalysisHelper extends TestCaseAnalysisHelper {

    public CTestCaseAnalysisHelper(SCTestCase testCase) {
        super(testCase);
    }

    @Override
    public void buildParseTreeMap() {
        parseTreeNodeMap.put(CParser.DirectDeclaratorContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
    }

    @Override
    public void buildParseTreeMapPos() {
        parseTreeNodeMapPos.put(CParser.DirectDeclaratorContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
    }

    @Override
    public void buildParseTreeMapNeg() {
        parseTreeNodeMapNeg.put(CParser.DirectDeclaratorContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
    }
}
