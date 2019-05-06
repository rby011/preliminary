package com.samsung.tcm.schema;

public enum ELanguage implements ILanguage {
    C("C"),
    CPLUS("CPLUS"),
    CSHARP("CSHARP"),
    JAVA("JAVA"),
    JAVASCRIPT("JAVASCRIPT"),
    XML("XML"),
    GO("GO"),
    PYTHON("PYTHON");
    String language;

    ELanguage(String language) {
        this.language = language;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return language;
    }
}
