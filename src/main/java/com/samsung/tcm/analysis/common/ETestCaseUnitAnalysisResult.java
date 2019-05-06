package com.samsung.tcm.analysis.common;

public enum ETestCaseUnitAnalysisResult implements ITestCaseUnitAnalysisResult {
    TRUE("TRUE"),
    FALSE("FALSE"),
    NONE("NONE");

    String result;

    ETestCaseUnitAnalysisResult(String result) {
        this.result = result;
    }

    @Override
    public String getTestCaseUnitAnalysisResult() {
        return this.result;
    }
}
