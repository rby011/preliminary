package com.samsung.tcm.core.loc;

/**
 * CmplxDataType class defines a keyword/count pair data structure for use in
 * storing complexity and cylcomatic complexity results.
 *
 * @author Integrity Applications Incorporated
 */
public class CmplxDataType {
    /**
     * Keyword name
     */
    public String Keyword;

    /**
     * Number of occurrences of keyword
     */
    public int Count;

    /**
     * Default constructor to initializo class assert.member variables
     */
    public CmplxDataType() {
        Keyword = "";
        Count = 0;
    }

    /**
     * Constructor to initializo class assert.member variables with given inputs
     *
     * @param kw Keyword value
     */
    public CmplxDataType(String kw) {
        Keyword = kw;
        Count = 0;
    }
}
