package com.samsung.tcm.analysis.csharp;

import com.samsung.tcm.analysis.common.TestCaseAnalysisHelper;
import com.samsung.tcm.core.parser.csharp.CSharpParser;
import com.samsung.tcm.schema.ETestCaseIdentifierLocation;
import com.samsung.tcm.schema.SCTestCase;

public class CSharpTestCaseAnalysisHelper extends TestCaseAnalysisHelper {
    public CSharpTestCaseAnalysisHelper(SCTestCase testCase) {
        super(testCase);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                              BUILD PARSE TREE MAP (TO ETestCaseIdentifierLocation)
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void buildParseTreeMap() {
        parseTreeNodeMap.put(CSharpParser.AttributeContext.class.getName(), ETestCaseIdentifierLocation.ATTRIBUTE);
        parseTreeNodeMap.put(CSharpParser.Method_member_nameContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
    }

    @Override
    public void buildParseTreeMapPos() {
        parseTreeNodeMapPos.put(CSharpParser.AttributeContext.class.getName(), ETestCaseIdentifierLocation.ATTRIBUTE);
        parseTreeNodeMapPos.put(CSharpParser.Method_member_nameContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
    }

    @Override
    public void buildParseTreeMapNeg() {
        parseTreeNodeMapNeg.put(CSharpParser.AttributeContext.class.getName(), ETestCaseIdentifierLocation.ATTRIBUTE);
        parseTreeNodeMapNeg.put(CSharpParser.Method_member_nameContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
    }

}
