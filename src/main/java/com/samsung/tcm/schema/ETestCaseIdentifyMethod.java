package com.samsung.tcm.schema;

public enum ETestCaseIdentifyMethod implements IIdentifyMethod {
    PREFIX("PREFIX"),
    POSTFIX("POSTFIX"),
    REGEXPR("REGEXPR"),
    EXACT("EXACT"),
    NONE("NONE");

    String identifierMethodType;

    ETestCaseIdentifyMethod(String identifierMethodType) {
        this.identifierMethodType = identifierMethodType;
    }

    @Override
    public String getIdentifierMethodType() {
        return this.identifierMethodType;
    }


    @Override
    public String toString() {
        return identifierMethodType;
    }
}
