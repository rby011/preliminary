package com.samsung.tcm.analysis.common;

public class FileAnalysisResult {
    // 파일 전체의 sloc, ploc, assertions 개수
    private int sloc, psloc;
    private int assertions;

    public int getSloc() {
        return sloc;
    }

    public void setSloc(int sloc) {
        this.sloc = sloc;
    }

    public int getPsloc() {
        return psloc;
    }

    public void setPsloc(int psloc) {
        this.psloc = psloc;
    }

    public int getAssertions() {
        return assertions;
    }

    public void setAssertions(int assertions) {
        this.assertions = assertions;
    }

    public void addAssertions(int assertions) {
        this.assertions += assertions;
    }
}
