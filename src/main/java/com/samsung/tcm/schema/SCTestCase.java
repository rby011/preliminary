package com.samsung.tcm.schema;

import com.bpodgursky.jbool_expressions.Expression;
import com.bpodgursky.jbool_expressions.parsers.ExprParser;
import com.samsung.tcm.exceptions.InvalidFormatExpressionException;

import java.util.ArrayList;

/**
 * TestFile 에는 하나의 유형의 TestCase 가 존재하는 것으로 가정한다.
 * 만일 하나의 파일내에 Test Type 별로 여러 유형의 Test Case 가 포함되는 경우가 발생한다면,
 * TestFile 과 TestCase 의 관계를 OneToOne 이 아닌 OneToMany 로 변경이 필요하다.
 */
public class SCTestCase {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                             TC 식별, Positive 식별, Negative TC 식별
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TODO : HASHSET 으로 변경 필요 고려. 파스 트리에서의 입력 표현식이 고정되어 있다면 가능
    private ArrayList<SCITestCaseIdentifier> tcIdentifiers = new ArrayList<>();// 개별 TC 식별 문자열, 식별자 위치, 식별 규칙
    private String boolExpressionStr; // 개별 식별 간 논리 관계
    private Expression<String> boolExpression;

    // TODO : HASHSET 으로 변경 필요 고려. 파스 트리에서의 입력 표현식이 고정되어 있다면 가능
    // Negative TC 식별 문자열, 식별자 위치, 식별 규칙
    private ArrayList<SCITestCaseIdentifier> identifiersForNegTC = new ArrayList<>();
    private String boolExpressionForNegTCStr;
    private Expression<String> boolExpressionForNegTC;

    // TODO : HASHSET 으로 변경 필요 고려. 파스 트리에서의 입력 표현식이 고정되어 있다면 가능
    // Positive TC 식별 문자열, 식별자 위치, 식별 규칙
    private ArrayList<SCITestCaseIdentifier> identifiersForPosTC = new ArrayList<>();
    private String boolExpressionForPosTCStr;
    private Expression<String> boolExpressionForPosTC;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          메타 정보
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TC 작성 유형
    private ITestCaseFormatType formatType;

    // V&V 에서의 Test 유형
    private ITestType testType;

    // Test 대상의 유형 , e.g., API, HAL API, ETC. 보조 정보
    private SCTestTarget testTarget;

    // Test Framework
    private ITestFramework testFramework;

    // TC 작성 언어
    private ILanguage language;

    public SCTestCase(ETestCaseFormatType formatType) {
        this.formatType = formatType;
    }

    public SCTestCase(ETestCaseFormatType formatType, ETestFramework testFramework) {
        this.testFramework = testFramework;
        this.formatType = formatType;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                 SETTERS
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addTCIdentifier(SCITestCaseIdentifier identifier) {
        this.tcIdentifiers.add(identifier);
    }

    public void addPositiveTCIdentifier(SCITestCaseIdentifier identifier) {
        this.identifiersForPosTC.add(identifier);
    }

    public void addNegativeTCIdentifier(SCITestCaseIdentifier identifier) {
        this.identifiersForNegTC.add(identifier);
    }

    public ITestFramework getTestFramework() {
        return testFramework;
    }

    public void setTestFramework(ITestFramework testFramework) {
        this.testFramework = testFramework;
    }

    public ILanguage getLanguage() {
        return language;
    }

    public void setLanguage(ELanguage language) {
        this.language = language;
    }

    public void setFormatType(ETestCaseFormatType formatType) {
        this.formatType = formatType;
    }

    public void setTestType(ETestType testType) {
        this.testType = testType;
    }

    public void setTestTarget(SCTestTarget testTarget) {
        this.testTarget = testTarget;
    }

    public void setBoolExpressionStr(String boolExpressionStr) throws InvalidFormatExpressionException {
        this.boolExpressionStr = boolExpressionStr;
        try {
            this.boolExpression = ExprParser.parse(this.boolExpressionStr);
        } catch (RuntimeException ex) {
            // 명시적 오류핸들링을 위해 Checked Exception 으로 변경한다.
            throw new InvalidFormatExpressionException("The given bool expression has gramatical error." + boolExpressionForPosTCStr);
        }
    }

    public void setBoolExpressionForNegTCStr(String boolExpressionForNegTCStr) throws InvalidFormatExpressionException {
        this.boolExpressionForNegTCStr = boolExpressionForNegTCStr;
        try {
            this.boolExpressionForNegTC = ExprParser.parse(this.boolExpressionForNegTCStr);
        } catch (RuntimeException ex) {
            // 명시적 오류핸들링을 위해 Checked Exception 으로 변경한다.
            throw new InvalidFormatExpressionException("The given bool expression has gramatical error." + boolExpressionForPosTCStr);
        }
    }

    public void setBoolExpressionForPosTCStr(String boolExpressionForPosTCStr) throws InvalidFormatExpressionException {
        this.boolExpressionForPosTCStr = boolExpressionForPosTCStr;
        try {
            this.boolExpressionForPosTC = ExprParser.parse(this.boolExpressionForPosTCStr);
        } catch (RuntimeException ex) {
            // 명시적 오류핸들링을 위해 Checked Exception 으로 변경한다.
            throw new InvalidFormatExpressionException("The given bool expression has gramatical error." + boolExpressionForPosTCStr);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                GETTERS
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getBoolExpressionStr() {
        return boolExpressionStr;
    }

    public String getBoolExpressionForNegTCStr() {
        return boolExpressionForNegTCStr;
    }

    public String getBoolExpressionForPosTCStr() {
        return boolExpressionForPosTCStr;
    }

    public ArrayList<SCITestCaseIdentifier> getTcIdentifiers() {
        return tcIdentifiers;
    }

    public ArrayList<SCITestCaseIdentifier> getIdentifiersForNegTC() {
        return identifiersForNegTC;
    }

    public ArrayList<SCITestCaseIdentifier> getIdentifiersForPosTC() {
        return identifiersForPosTC;
    }

    public ITestCaseFormatType getFormatType() {
        return formatType;
    }

    public ITestType getTestType() {
        return testType;
    }

    public SCTestTarget getTestTarget() {
        return testTarget;
    }

    public Expression<String> getBoolExpression() {
        return boolExpression;
    }

    public Expression<String> getBoolExpressionForNegTC() {
        return boolExpressionForNegTC;
    }

    public Expression<String> getBoolExpressionForPosTC() {
        return boolExpressionForPosTC;
    }
}
