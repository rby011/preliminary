package com.samsung.tcm.analysis.common;

import java.util.ArrayList;

public class MethodAnalysisResult implements CommonToken {
    private int strongAssertions, roughAssertions, weakAssertions;
    private boolean isTC, isNegativeTC, isPositiveTC;
    // 파라미터 정보
    private ArrayList<String> paramIdentifiers = null;
    private int parameterCount;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                    수정 필요
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // # 변수 목적과 명칭 변경
    // namespace 변수는 test case 가 소속되는 group 식별자
    // methodName 은 test case 의 이름
    private String namespace;
    private String methodName;

    public String getTestCaseSignature() {
        StringBuffer sbuf = new StringBuffer();
        String ns = this.getNamespace();
        if (ns != null && ns.length() > 0) {
            sbuf.append(this.getNamespace());
            sbuf.append("$");//TODO MODIFY
        }
        sbuf.append(this.getMethodName());
        return sbuf.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                    추가 필요
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // # Physical SLOC 정의 (From COCOMO)
    // one line starting with the first character and ending by a carriage return or an end-of-file marker of
    // the same line, and which excludes the blank and comment line.
    // # Logical SLOC 정의 (From COCOMO)
    // Lines of code intended to measure “statements”, which normally terminate by a semicolon (C/C++, Java, C#) or
    // a carriaeo return (VB, Assembly), etc. Logical SLOC are not sensitive to format and style conventions,
    // but they are language-dependent
    private int psloc, sloc;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                 BEiNG OF 삭제 대상
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int loc;
    // 함수 내에서 호출되는 함수들의 목록
    // private HashMap<String, ArrayList<TestCaseCalleeInMethod>> calleeMap = new HashMap<>();

    //    public void putTestCaseCallee(@NotNull String calleeKey, @NotNull TestCaseCalleeInMethod callee) {
    //        ArrayList<TestCaseCalleeInMethod> calleeList = null;
    //        boolean needToPut = false;
    //        if (calleeMap.containsKey(calleeKey)) {
    //            calleeList = calleeMap.get(calleeKey);
    //        } else {
    //            calleeList = new ArrayList<>();
    //            needToPut = true;
    //        }
    //        calleeList.add(callee);
    //        if (needToPut)
    //            calleeMap.put(calleeKey, calleeList);
    //    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                 END OF 삭제 대상
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //    public HashMap<String, ArrayList<TestCaseCalleeInMethod>> getCalleeMap() {
    //        return calleeMap;
    //    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getParameterCount() {
        return parameterCount;
    }

    public void setParameterCount(int parameterCount) {
        this.parameterCount = parameterCount;
    }

    public ArrayList<String> getParamIdentifiers() {
        return paramIdentifiers;
    }

    public void setParamIdentifiers(ArrayList<String> paramIdentifiers) {
        this.paramIdentifiers = new ArrayList<>(paramIdentifiers);
    }

    public int getLoc() {
        return loc;
    }

    public int getStrongAssertions() {
        return strongAssertions;
    }

    public int getRoughAssertions() {
        return roughAssertions;
    }

    public int getWeakAssertions() {
        return weakAssertions;
    }

    public boolean isTC() {
        return isTC;
    }

    public boolean isNegativeTC() {
        return isNegativeTC;
    }

    public boolean isPositiveTC() {
        return isPositiveTC;
    }


    public int getPsloc() {
        return psloc;
    }

    public void setPsloc(int psloc) {
        this.psloc = psloc;
    }

    public int getSloc() {
        return sloc;
    }

    public void setSloc(int sloc) {
        this.sloc = sloc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public void setStrongAssertions(int strongAssertions) {
        this.strongAssertions = strongAssertions;
    }

    public void setRoughAssertions(int roughAssertions) {
        this.roughAssertions = roughAssertions;
    }

    public void setWeakAssertions(int weakAssertions) {
        this.weakAssertions = weakAssertions;
    }

    public void setTC(boolean TC) {
        isTC = TC;
    }

    public void setNegativeTC(boolean negativeTC) {
        isNegativeTC = negativeTC;
    }

    public void setPositiveTC(boolean positiveTC) {
        isPositiveTC = positiveTC;
    }
}