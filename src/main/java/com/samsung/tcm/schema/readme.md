TCM 으로의 입력으로서 중추 역할을 하는 패키지이다. TCM 동작위한 모든 정보가 잘 구조화 되어 담겨있어야 한다.
## OVERVIEW

* 프로젝트의 구조에 따른 테스트 케이스를 식별하기 위한 관계정보와 메타정보를 갖는 클래스와 인터페이스를 담는다.
* 클래스의 경우 생성자의 파라미터가 해당 인스턴스의 식별자가 된다.
* 다만, 1:1 관계로 분석된 경우 편의상 생성자에 해당 인스턴스를 넘겨 간단하게 관계 설정을 한다.
* 그러나 1:1 관계 수정이 필요한 경우 위 관계 설정 구현의 변경이 필요하다
* 예를 들어 TestFile 은 단일 유형의 TestCase 집합을 갖는 것으로 현재는 구현되어 있다.
* 만일 1:M 관계로의 변경이 필요한 경우 SCTestFile 은 SCTestCase 와 동일한 구조로 SCITestFileIdentifier 등을 이용 수정이 필요하다

## Naming Rule

* 역할에 따라 PreFix 로 구분한다

* "SC"  클래스    : 관계정보와 메타정보를 갖는 스키마 인스턴스를 의미한다
* "SCI" 클래스    : 식별방법에 대한 메타정보를 갖는 인스턴스를 갖는다. 독자적으로는 스키마를 대표할 수 없으며 스키마 인스턴스에 포함되어 사용된다.
* "E"   이넘      : 스키마가 갖는 정보가 유한한 경우 유효 정보 집합을 표현한다.
* "I"   인터페이스 : 정보 스키마 구조화를 위한 매개 구조이다.

## Conceptual Schema Structure

    ~~~
     ----------
    |  Project |
     ----------
       1  |
          | 1..*
     -------------
    |  SubProject |
     -------------
        1 |
          | 1..*
     -------------
    |  Repository |
     -------------
        1 |
          | 1..*
     -------------           
    |  TestFile  |         
    |    유형     |
     -------------         
        1 |                              
          | 1                             
     -------------              ------------------------
    |             |   1         | 1) 식별자 문자열       |
    |  TestCase   |   --------- | 2) 식별자 문자열 위치  |
    |    유형      |        1..* | 3) 식별 규칙(패턴)     |
    |             |             | 4)  논리 조건 (AND OR)|
     -------------              ------------------------
    ~~~

## Conditional Logic

* 예를 들어 Positive TC 에 대해  식별 문자열 ,식별 문자열 위치, 식별 규칙이  아래와 같이 구성되어 있다.
   ~~~
   [Test("Something")]
   [Category("P1")]
   public void TS_GetTestCase_P(){
        // do something
   }
   
   [Test("Something")]
   [Category("P3")]
   public void TS_GetTestSuite_P(){
        // do something
   }
   
   [Test("Something")]
   [Category("P4")]
   public void TS_GetTestFile_P(){
        // do something
   }
   
   [식별#1]
   식별 문자열 =  Test 
   식별 문자열 위치 = Attribute
   식별 규칙(패턴) = Exact Matching   // Attribute 가 Test 인 것이 있음 Test("asdf") Test("none") 모두 포함
   
   [식별#2]
   식별 문자열 =  Category("P1") 
   식별 문자열 위치 = Attribute
   식별 규칙(패턴) = Exact Matching   
   
   [식별#3]
   식별 문자열 =  Category("P3") 
   식별 문자열 위치 = Attribute
   식별 규칙(패턴) = Exact Matching   
      
   [식별#4]
   식별 문자열 =  Category("P4") 
   식별 문자열 위치 = Attribute
   식별 규칙(패턴) = Exact Matching   
      
   [식별#5]
   식별 문자열 = TS
   식별 문자열 위치 = Method Name
   식별 규칙(패턴) =  Pre Fix        
   
   [식별#6]
   식별 문자열 = _P
   식별 문자열 위치 = Method Name
   식별 규칙(패턴) =  Post Fix        
   
   
   식별 문자열(Pattern String)은 IIdentifier, 식별 문자열 위치(Location)는 IIdentifierLocation, 식별 규칙(Matching Method)은 IIdentifierMethod 을 의미한다
   ~~~

* 이를 종합하여 Positive 를 식별하는 규칙을 아래 예제에 대해 Tabular 형태로 표현하고 이것이 Positive TC 인지 분별하는 논리식을 작성하면 아래와 같다

    ~~~
    [Test]
    [Category("P2")]
    public void TSGetTestCase_P(){
        //do something
    }
    ~~~

    | 목적         | Location    | Pattern String | Matching Method | Matching Result | ID     |
    |:-----------|:----------|:--------------|:---------------|:-------------|:-------|
    | Positive TC 여부 식별 | Attribute   | Test           | EXACT           | True            | 식별#1 |
    |             | Attribute   | Category("P1") | EXACT           | False           | 식별#2 |
    |             | Attribute   | Category("P3") | EXACT           | False           | 식별#3 |
    |             | Attribute   | Category("P4") | EXACT           | False           | 식별#4 |
    |             | Method Name | TS             | PRE FIX         | True            | 식별#5 |
    |             | Method Name | _P             | POST FIX        | True            | 식별#6  |

   개별 식별 간의 논리식은 아래와 같이 구성되고 그 결과는 False 이며 즉 이는 아래처럼 포현되고 이러한 노테이션과 값이 주어진 경우 평가할 수 있는 방법이 필요하다
   ~~~
      if  ( 식별#1 & (식별#2 | 식별#3 | 식별 #4 ) & 식별#5 & 식별#6 )    then    
      
          TSGetTestCase is a Positive TC
      
      otherwise
        
          TSGEtTestCase is not a Positive TC <--- result
   ~~~
### Class Diagram of SCTestCase (This is a key class)

* SCTestCase 는 Analyzer 와 연결되는 중심 클래스이다. (* Analyzer 에서는 SCTestCase 를 입력 받아 분석하기 용이하도록 Helper 를 통해 정보의 재구조화 진행한다)
* SCTestCase 는 식별 대상에 따라 TC 여부 식별, Negative TC 여부 식별, Positive TC 여부 식별을 위한 모든 것을 가지고 있다.
* "여부 식별" 을 위해서는 식별 문자열, 식별 위치, 식별 방법으로 구성되고 "식별" = "식별 문자열 + 식별 위치 + "식별 방법" 으로 정의한다
* 또한 위의 예처럼 식별 유형 (TC 여부, Neg TC 여부) 별로 복수의 "식별"을 갖는다
* 따라서 SCTestCase 는 아래의 구조를 갖는다
* 또한 Identifier, IdentifierLocation, IdentifierMethod 간에는 1:1 관계가 유지된다.
* Logical Expression 과 Expression Evaluator 는 링크를 참고 바란다. [readme](../../../../../../test/java/lib/jbool/readme.md)
~~~
                                        _____________________                              ----------                              -----------
                                        |                   |                              |         |    <분석 용이성 제공>        |           |
                  << TC 여부 식별 >>     |                   |   1  <분석 목적, 방법 제공>  1 |         | 1  <분석 결과 저장소 제공> 1 |            |
        ---------------------------<<>> |     SCTestCase    | ---------------------------->|  Helper |--------------------------->|  Analyzer  |---
       |                            1   |                   |   1                          |         |                            |            |   |
       |                                |                   |                              |         |                            |            |   |
       |                                _____________________                              __________                             -------------    |
       |                                     1 <<>>   1 <<>>                                                                                       |
       |                <<Negative TC 여부 식별  |         |  <<Positive TC 여부 식별>>                                                              |
       |          ------------------------------          |                                   * Analyzer   : 분석 대상 문자열 추출                   |
       |          |            ___________________________                                    * Helper     : 분석 결과 저장                         |
       |     1..* |       1..* |                                                              * SCTestCase : 분석 목적, 대상 등 제공                 |
       |       _____________________                                                          * SCTestCaseIdentifier : 분석 방법 제공                |  <사용>
       |      |                     | 1     <<식별문자열>>  1..*  --------------------                                                                |
       |      |                     |<<>>--------------------- |   Identifier      |          * 궁극적으로 Schema 는 Analyzer 에 정보 제공 목적이다       |
       |      |     SCTestCase      | 1      <<식별위치>>  1..*  ---------------------         * 이는 Helper 를 통해 이루어지고 Analyzer 는 Helper 의     |
       -------|     Identifier      |<<>>---------------------- | IdentifierLocation|           도움으로 분석을 완료할 수 있다.                          |
      1..*    |                     | 1     <<식별방법>>   1..*  ---------------------                                                                  |
              |_____________________|<<>>-----------------------| IdentifyMethod    |                                                                    |        
                      <<>>  1                                   ---------------------                                                                    |        
                        |                                                                                                                                |
                        |                                                            ---------------------------         ---------------------------     |
                        |                                                       1    |   Logical Expression    |  <평가> |    Logical Expression    |    |
                        |----------------------------------------------------------- |       (Bool Expr)       |<--------|      (Bool Expr)         |<---
                                                <<식별 간 논리 관계>>                  |        Builder          |         |        Evaluator         | 
                                                                                    ---------------------------         ----------------------------
                                                                                     e.g)  ( A | B ) & C
       <<>>---- : 강한 연결 관계 (생명 주기를 같이 한다)
       -------- : 연결 관계
~~~
