//package com.samsung.tcm.analysis.common;
//
//import java.util.LinkedList;
//
//public class HashedLinkedListTable {
//
//    private LinkedList<LinkedList<MethodAnalysisResult>>[] table = null;
//    private int MAX_CAPACITY;
//
//    public HashedLinkedListTable() {
//        table = new LinkedList[MAX_CAPACITY];
//    }
//
//    public void put(String key, MethodAnalysisResult value) {
//        int index = key.hashCode() & 0x7fffffff % MAX_CAPACITY;
//
//        if (table[index] == null) {
//            table[index] = new LinkedList<LinkedList<MethodAnalysisResult>>();
//            LinkedList<MethodAnalysisResult> newList = new LinkedList<>();
//            newList.addLast(value);
//            table[index].addFirst(newList);
//        } else {
//            LinkedList<LinkedList<MethodAnalysisResult>> resultsList = table[index];
//            for (LinkedList<MethodAnalysisResult> resultList : resultsList) {
//                if (key.equals(value.getKeyForCallee())) {
//                    resultList.addLast(value);
//                    return;
//                }
//            }
//            // COLLISION 발생한 경우이다
//            LinkedList<MethodAnalysisResult> newResultList = new LinkedList<>();
//            newResultList.addLast(value);
//            resultsList.addLast(newResultList);
//        }
//    }
//
//    public LinkedList<MethodAnalysisResult> get(String key) {
//        int index = key.hashCode() & 0x7fffffff % MAX_CAPACITY;
//
//        if (table[index] == null) return null;
//
//        LinkedList<LinkedList<MethodAnalysisResult>> resultsList = table[index];
//
//        for (LinkedList<MethodAnalysisResult> resultList : resultsList) {
//            if (resultList.getFirst().getKeyForCallee().equals(key)) return resultList;
//        }
//
//        return null;
//    }
//}
