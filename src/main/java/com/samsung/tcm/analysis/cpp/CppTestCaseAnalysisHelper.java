package com.samsung.tcm.analysis.cpp;

import com.samsung.tcm.analysis.common.TestCaseAnalysisHelper;
import com.samsung.tcm.core.parser.cpp.CPP14Parser;
import com.samsung.tcm.schema.ETestCaseIdentifierLocation;
import com.samsung.tcm.schema.SCTestCase;

public class CppTestCaseAnalysisHelper extends TestCaseAnalysisHelper {

    public CppTestCaseAnalysisHelper(SCTestCase testCase) {
        super(testCase);
    }

    @Override
    public void buildParseTreeMap() {
        parseTreeNodeMap.put(CPP14Parser.DeclaratoridContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
        parseTreeNodeMap.put(CPP14Parser.ParameterdeclarationclauseContext.class.getName(), ETestCaseIdentifierLocation.PARAMETER_NAME);
    }

    @Override
    public void buildParseTreeMapPos() {
        parseTreeNodeMapPos.put(CPP14Parser.DeclaratoridContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
        parseTreeNodeMapPos.put(CPP14Parser.ParameterdeclarationclauseContext.class.getName(), ETestCaseIdentifierLocation.PARAMETER_NAME);
    }

    @Override
    public void buildParseTreeMapNeg() {
        parseTreeNodeMapNeg.put(CPP14Parser.DeclaratoridContext.class.getName(), ETestCaseIdentifierLocation.METHOD_NAME);
        parseTreeNodeMapNeg.put(CPP14Parser.ParameterdeclarationclauseContext.class.getName(), ETestCaseIdentifierLocation.PARAMETER_NAME);
    }
}
