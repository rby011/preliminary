//package com.samsung.tcm.analysis.common;
//
//public class TestCaseCalleeInMethod implements CommonToken{
//    private int parameterCount;
//    private String calleeMethodName, key;
//
//    public TestCaseCalleeInMethod() {
//    }
//
//    public TestCaseCalleeInMethod(String calleeMethodName, int parameterCount) {
//        this.setCalleeMethodName(calleeMethodName);
//        this.setParameterCount(parameterCount);
//        this.setKey(this.generateKey(calleeMethodName, parameterCount));
//    }
//
//    public String getCalleeMethodName() {
//        return calleeMethodName;
//    }
//
//    public int getParameterCount() {
//        return parameterCount;
//    }
//
//    public String getKey() {
//        return this.key;
//    }
//
//    public void setCalleeMethodName(String calleeMethodName) {
//        this.calleeMethodName = calleeMethodName;
//        this.setKey(this.generateKey(calleeMethodName, this.parameterCount));
//    }
//
//    public void setParameterCount(int parameterCount) {
//        this.parameterCount = parameterCount;
//        this.setKey(this.generateKey(this.calleeMethodName, parameterCount));
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    private String generateKey(String methodName, int parameterCount) {
//        return methodName + PARAMETER_COUNT_BEFORE_DELIMITER + parameterCount;
//    }
//
//    @Override
//    public int hashCode() {
//        return key.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return key.equals(obj.toString());
//    }
//
//    @Override
//    public String toString() {
//        return key.toString();
//    }
//}
