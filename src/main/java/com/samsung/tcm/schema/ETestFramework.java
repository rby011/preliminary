package com.samsung.tcm.schema;

public enum ETestFramework implements ITestFramework {
    GTEST("GTEST"),
    JUNIT("JUNIT"),
    NUNIT("NUNIT"),
    MOCHA("MOCHA"),
    CHAI("CHAI"),
    CUSTOM("CUSTOM");

    String testFramework;

    ETestFramework(String testFramework) {
        this.testFramework = testFramework;
    }

    @Override
    public String getTestFramework() {
        return this.testFramework;
    }


    @Override
    public String toString() {
        return testFramework;
    }
}
