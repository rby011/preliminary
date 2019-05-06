package com.samsung.tcm.schema;

public enum ETestCaseType implements ITestCaseType{
    POSITIVE("POSITIVE"),
    NEGATIVE("NEGATIVE"),
    NONE("NONE");

    private String testCaseType;

    ETestCaseType(String testCaseType){
        this.testCaseType = testCaseType;
    }

    @Override
    public String getTypeCaseType() {
        return this.testCaseType;
    }
}
