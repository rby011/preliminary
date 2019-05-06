package com.samsung.tcm.schema;

public enum ETestType implements ITestType {
    UNIT_TEST("UNIT_TEST"),
    INTEGRATION_TEST("INTEGRATION_TEST"),
    SYSTEM_TEST("SYSTEM_TEST");

    String testType;

    ETestType(String testType) {
        this.testType = testType;
    }

    @Override
    public String getTestType() {
        return testType;
    }

    @Override
    public String toString() {
        return testType;
    }
}
