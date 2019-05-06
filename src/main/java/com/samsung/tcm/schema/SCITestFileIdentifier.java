package com.samsung.tcm.schema;

/**
 * 단일 레포지토리 내에서 테스트 케이스를 포함하고 있는 파일을 식별하는 방법을 기술하는 스키마
 * 레포지토리는 복수개의 SCITestFileIdentifier 를 가질 수 있다.
 * 이는 단일 레포지토리내에 여러 유형의 테스트 파일 (포함하는 테스트 케이스에 따라서) 을 가질 수
 * 있기 때문이다. 현재는 테스트 파일과 테스트 케이스는 1:1 관계로 가정하고 있다.
 * <p>
 * 해당 파일을 식별하기 위해서는 문자열의 식별자와 해당 문자열이 위치하고 있는 위치(파일 이름, 확장자 이름)
 * 그리고 해당 식별 위치에서의 비교 방법이 필요하다. 각각 identifer, idMethod, idLocation 이 그 역할을
 * 하고 있다.
 * <p>
 * 또한 식별 위치는 운영체제의 파일 이름 규칙을 준수한다. 즉, 경로를 제외한 파일 식별자는 파일 이름과
 * 파일 확장자로 구분하고, 해당 스키마도 파일 이름과 파일 확장자를 식별 위치로 지원한다.
 * <p>
 * 또한 식별 방법은 기본적으로 정규식(Regular Expression)을 권고하나 사용법에 익숙하지 않은 경우
 * PRE FIX, POST FIX 등의 태그를 이용할 수 있다. 또한 EXACT 도 제공한다.
 */
public class SCITestFileIdentifier implements IIdentifier, IIdentifierLocation, IIdentifyMethod {
    private String identifier;
    private String idMethod;
    private String idLocation;

    private ETestFileIdentifierLocation testFileIdentifierLocation;
    private ETestFileIdentifierMethod testFileIdentifierMethod;

    public SCITestFileIdentifier(String identifier, ETestFileIdentifierMethod idMethod, ETestFileIdentifierLocation idLocation) {
        setIdentifier(identifier);
        setIdMethod(idMethod.toString());
        setIdLocation(idLocation.toString());

        this.testFileIdentifierLocation = idLocation;
        this.testFileIdentifierMethod = idMethod;
    }


    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getIdentifierLocationType() {
        return idLocation;
    }

    @Override
    public String getIdentifierMethodType() {
        return idMethod;
    }

    public ETestFileIdentifierLocation getIdentifierLocationE() {
        return testFileIdentifierLocation;
    }

    public ETestFileIdentifierMethod getIdentifierMethodTE() {
        return testFileIdentifierMethod;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setIdMethod(String idMethod) {
        this.idMethod = idMethod;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }
}
