package com.samsung.tcm.schema;

public enum ETestCaseIdentifierLocation implements IIdentifierLocation {
    METHOD_NAME("METHOD_NAME"),
    PARAMETER_NAME("PARAMETER_NAME"),
    ATTRIBUTE("ATTRIBUTE"),
    ANNOTATION("ANNOTATION"),
    NONE("NONE");

    String identifierLocationType;

    ETestCaseIdentifierLocation(String identifierLocationType) {
        this.identifierLocationType = identifierLocationType;
    }

    @Override
    public String getIdentifierLocationType() {
        return identifierLocationType;
    }
    @Override
    public String toString() {
        return identifierLocationType;
    }
}
