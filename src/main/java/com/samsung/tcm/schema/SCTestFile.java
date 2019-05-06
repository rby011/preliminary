package com.samsung.tcm.schema;

import java.io.File;
import java.util.ArrayList;

/**
 * Repository 별로 복수개의 TestFile 을 가질 수 있다.
 * 단일 TestFile 은 그 유형과 이를 식별하는 식별 규칙의 모음이 식별자가 된다
 * 즉, 유형 + 식별자 문자열 + 식별자 위치 + 식별 방법 이 TestFile 의 키가 된다.
 * <p>
 * 그러나 현재는 단일 TestFile 은 단일 유형의 TestCase 를 갖는 것으로 정의한다.
 * 따라서 그 구현 또한 TestFile 과 TestCase 를 1:1 매핑시켰다. 향후 TestFile 과
 * TestCase 의 관계가 1 : M 관계로 형성되는 경우 SCTestCase 와 동일한 구조로 정의해야 한다
 */
public class SCTestFile {
    /**
     * SCTestFile 규칙으로 탐색되는 파일에는 하나의 SCTestCase 만 존재한다고 가정
     * 향후 확장성 필요한 경우 이를 컬랙션으로 정의해야 함
     */
    private SCTestCase testcase;

    /**
     * <pre>
     * @see SCTestCase 식별하는 방법을 기술하는 클래스
     *
     * @implNote File 식별위한 identifier 들은 AND 조건으로 결합된다.
     *  현재까지는 Boolean Expression 이 필요한 상황을 식별하지 못했다.
     *  </pre>
     */
    private ArrayList<SCITestFileIdentifier> identifiers = new ArrayList<SCITestFileIdentifier>();

    public SCTestFile(SCTestCase testcase) {
        this.testcase = testcase;
    }

    public SCTestCase getTestcase() {
        return testcase;
    }

    public void setTestcase(SCTestCase testcases) {
        this.testcase = testcase;
    }

    public ArrayList<SCITestFileIdentifier> getIdentifiers() {
        return this.identifiers;
    }

    public void addIdentifier(SCITestFileIdentifier identifier) {
        this.identifiers.add(identifier);
    }
}