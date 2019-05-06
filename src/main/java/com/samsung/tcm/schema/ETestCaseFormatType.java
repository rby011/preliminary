package com.samsung.tcm.schema;

public enum ETestCaseFormatType implements ITestCaseFormatType {
    CODE("CODE"),
    TOOL("TOOL"),
    DOCUMENT("DOCUMENT"),
    NONE("NONE");

    String testCaseFormatType;

    ETestCaseFormatType(String testCaseFormatType) {
        this.testCaseFormatType = testCaseFormatType;
    }

    @Override
    public String getTestCaseFormatType() {
        return testCaseFormatType;
    }

    @Override
    public String toString() {
        return testCaseFormatType;
    }
}