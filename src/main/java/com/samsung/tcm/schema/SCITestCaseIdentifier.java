package com.samsung.tcm.schema;

/**
 * 단일 파일 내에서 테스트케이스를 식별하는 방법을 기술하는 스키마
 * <p>
 * 해당 테스트 케이스를 식별하기 위해서는 문자열 형식의 식별자와 해당 문자열이 위치하고 있는 위치 (소스 코드 구조 관점의)
 * 그리고 해당 식별 위치에서의 비교 방법이 필요하다. 각각 identifer, idMethod, idLocation 이 그 역할을
 * 하고 있다.
 * <p>
 * 또한 식별 위치는 소스 코드의 구조를 고려한다. 함수 이름, 함수의 어트리뷰트 (C#), 함수의 어노테이션(JAVA)
 * 등이 식별 위치로 정의될 수 있다. 이는 소스 코드 수준에서 확장 가능하고 이는 ETestCaseIdentifierLocation
 * 을 수정하면 된다.
 * <p>
 * 또한 식별 방법은 기본적으로 정규식(Regular Expression)을 권고하나 사용법에 익숙하지 않은 경우
 * PRE FIX, POST FIX 등의 태그를 이용할 수 있다. 또한 EXACT 도 제공한다.
 */
public class SCITestCaseIdentifier implements IIdentifier, IIdentifyMethod, IIdentifierLocation, IIdentifierPosition {
    private String ID;              // SCTestCase 내에서 유일성이 보장되어야 함

    private String identifier;
    private String idMethod;
    private String idLocation;
    private Integer idPosition;

    private IIdentifyMethod idMethodE;
    private IIdentifierLocation idLocationE;

    public SCITestCaseIdentifier(String ID, String identifier, IIdentifyMethod idMethod, IIdentifierLocation idLocation) {
        this.ID = ID;

        setIdentifier(identifier);
        setIdMethod(idMethod.toString());
        setIdLocation(idLocation.toString());

        this.idMethodE = idMethod;
        this.idLocationE = idLocation;
    }

    public SCITestCaseIdentifier(String ID, String identifier, IIdentifyMethod idMethod, IIdentifierLocation idLocation, Integer idPosition) {
        this(ID, identifier, idMethod, idLocation);
        setIdPosition(idPosition);
    }


    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    public String getIdentifierLocationType() {
        return this.idLocation;
    }

    @Override
    public String getIdentifierMethodType() {
        return this.idMethod;
    }

    //GETTERS
    public String getID() {
        return ID;
    }

    public IIdentifyMethod getIdentifierMethodEnum() {
        return idMethodE;
    }

    public IIdentifierLocation getIdentifierLocationEnum() {
        return idLocationE;
    }

    //SETTERS
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setIdMethod(String idMethod) {
        this.idMethod = idMethod;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    @Override
    public Integer getIdentifierPosition() {
        return getIdPosition();
    }
}
