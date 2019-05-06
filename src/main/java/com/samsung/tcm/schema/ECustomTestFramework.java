package com.samsung.tcm.schema;

public enum ECustomTestFramework implements ITestFramework {
    TIZEN_TCT_NATIVE("TIZEN_TCT_NATIVE"),
    TIZEN_TCT_WEB("TIZEN_TCT_WEB"),
    TIZEN_RT("TIZEN_RT");

    private String testFramework;

    ECustomTestFramework(String customTestFramework) {
        this.testFramework = customTestFramework;
    }

    @Override
    public String getTestFramework() {
        return this.testFramework;
    }
}
