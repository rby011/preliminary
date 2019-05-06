package com.samsung.tcm.schema;

public enum ETestFileIdentifierLocation implements IIdentifierLocation {
    FILE_NAME("FILE_NAME"),
    FILE_EXTENSIONS("FILE_EXTENSIONS"),
    NONE("NONE");

    String identifierLocationType;

    ETestFileIdentifierLocation(String identifierLocationType) {
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
