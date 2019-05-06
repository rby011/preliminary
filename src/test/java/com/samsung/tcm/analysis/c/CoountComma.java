package com.samsung.tcm.analysis.c;

import org.junit.jupiter.api.Test;

class CoountComma {
    @Test
    void testDirectives() {
        String document = "abc, def, \"abc, efe, fef\", \"acd,efk\"";
        int i = countComma(document, document.indexOf("\""), 0);

        System.out.println("i = " + i);

        String s = document.replaceAll(".(\")([^\"])*(\")", "replace");
        System.out.println(s);
    }

    private int countComma(String document, int bidx, int sum) {
        int eidx = 0;
        if ((eidx = document.indexOf("\"", bidx + 1)) <= 0) return sum;
        String substring = document.substring(bidx, eidx);
        int delta = substring.split(",").length;
        return countComma(document.substring(eidx + 1), eidx, sum + delta);
    }
}