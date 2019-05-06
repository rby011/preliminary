package com.samsung.tcm.schema.assertion;

import com.samsung.tcm.exceptions.ResourceNotFoundException;

import java.io.IOException;

public abstract class SCAssertion {
    private boolean isOOPStyle;
    private String version;

    public SCAssertion(String version, boolean isOOPStyle) {
        this.version = version;
        this.isOOPStyle = isOOPStyle;
    }

    public boolean isOOPStyle() {
        return isOOPStyle;
    }

    public void setOOPStyle(boolean OOPStyle) {
        isOOPStyle = OOPStyle;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public abstract boolean contains(String member, boolean isStaticImport);

    public abstract boolean contains(String base);

    public abstract boolean contains(String base, String member);

    protected abstract void loadExpressions() throws IOException, ResourceNotFoundException;
}
