package com.samsung.tcm.util;

public class StringSearcher {
    // TODO : THRESHOLD 는 실험 통해 결정할 필요 있음
    private final int THRESHOLD = 1000;

    public StringSearcher() {
    }

    public synchronized boolean contains(String pattern, String document) {
        if (document.length() < THRESHOLD)
            return document.contains(pattern);
        return search(pattern, document, true) > 0;
    }

    public synchronized boolean startsWith(String pattern, String document) {
        if (document.length() < THRESHOLD)
            return document.startsWith(pattern);
        return document.startsWith(pattern);
    }

    public synchronized int count(String pattern, String document) {
        if (document.length() < THRESHOLD)
            return search(pattern, document);
        return search(pattern, document, false);
    }

    // 순차 탐색
    private synchronized int search(String pattern, String document) {
        int bidx = 0, eidx = 0, occurence = 0;
        int plen = pattern.length();
        while ((bidx = document.indexOf(pattern, bidx)) > 0) {
            bidx = bidx + plen;
            occurence++;
        }
        return occurence;
    }

    // KMP 탐색
    private synchronized int search(String pattern, String document, boolean stopAtOccurrence) {
        int M = pattern.length();
        int N = document.length();

        int[] lps = new int[M];
        int pidx = 0;  // pattern 인덱스

        // 빌드 STATE TRANSITION FLOW
        computeLPSArray(pattern, M, lps);

        int didx = 0;  // document 인덱스
        int occurrence = 0;
        int next_idx = 0;

        while (didx < N) {
            if (pattern.charAt(pidx) == document.charAt(didx)) {
                pidx++;
                didx++;
            }
            if (pidx == M) {
                pidx = lps[pidx - 1]; // 첫 패턴 발견시 후속 패턴 존재 여부 탐색

                if (!stopAtOccurrence)
                    occurrence++;
                else
                    return ++occurrence;

                if (lps[pidx] != 0)
                    didx = ++next_idx;
                pidx = 0;
            } else if (didx < N && pattern.charAt(pidx) != document.charAt(didx)) {
                if (pidx != 0)
                    pidx = lps[pidx - 1];
                else
                    didx = didx + 1;
            }
        }
        return occurrence;
    }

    private synchronized void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0, idx = 1;
        lps[0] = 0;  // lps[0] is always 0

        while (idx < M) {
            if (pat.charAt(idx) == pat.charAt(len)) {
                len++;
                lps[idx] = len;
                idx++;
            } else { // (pat[i] != pat[len]), TRICKY , AAACAAAA and i = 7
                if (len != 0) {
                    len = lps[len - 1];
                } else { // if (len == 0)
                    lps[idx] = len;
                    idx++;
                }
            }
        }
    }
}