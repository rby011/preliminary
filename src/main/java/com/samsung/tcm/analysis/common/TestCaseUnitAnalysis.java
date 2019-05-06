package com.samsung.tcm.analysis.common;

import com.samsung.tcm.schema.ETestCaseIdentifyMethod;
import org.jetbrains.annotations.NotNull;

public class TestCaseUnitAnalysis {
    // PRIMARY KEY
    private String ID;
    // PRIMITIVE MEMBERS
    private String idString;
    private ETestCaseIdentifyMethod idMethod;
    private Integer idPosition;
    // ADDITIONAL PROPERTY
    private Integer paramCount;

    private static TestCaseUnitAnalysis key = new TestCaseUnitAnalysis("");

    private TestCaseUnitAnalysis(String ID) {
        this.ID = ID;
    }

    public TestCaseUnitAnalysis(@NotNull String ID, @NotNull String idString, @NotNull ETestCaseIdentifyMethod idMethod, Integer idPosition) {
        this.ID = ID;
        this.idString = idString;
        this.idMethod = idMethod;
        this.idPosition = idPosition;
    }

    public static TestCaseUnitAnalysis getKeyInstance(String ID) {
        key.ID = ID;
        return key;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                    OVERRIDE FOR USING THIS IN HASHTABLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int hashCode() {
        return ID.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ID.equals(obj.toString());
    }

    @Override
    public String toString() { //JUST FOR DEBUG
        return ID;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                             GETTER AND SETTER
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getID() {
        return ID;
    }

    public Integer getParamCount() {
        return paramCount;
    }

    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
    }

    public String getIdString() {
        return idString;
    }

    public ETestCaseIdentifyMethod getIdMethod() {
        return idMethod;
    }


    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

    public void setIdMethod(ETestCaseIdentifyMethod idMethod) {
        this.idMethod = idMethod;
    }
}