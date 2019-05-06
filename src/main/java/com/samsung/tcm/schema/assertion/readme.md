## Overview

* SCAssertion 은 Project 구조를 갖는 스키마와 독립적으로 관리한다
* SCAssertion 은 라이브러리 변경, 버전업에 따라 손쉽게 바뀔 수 있으므로 독립 관리가 필요하다
* 독립 관리의 방법으로 java 가 제공하는 resource 메커니즘을 따른다.
* 즉, SCAssertion 이 가질 수 있는 토큰들의 정보는 별도 파일로 관리하고 각 SCAssertion Schema 인스턴스는 자신이 생성되는 시점에 이를 읽어서 메타 정보를 채운다

## Token Files For Assertion Expression

* 현 TCM 프로젝트의 Root Class Loader 가 알고 있는 위치에 Token File 을 저장한다
* 객체 지향 언어의 경우 Token 파일의 구성은 base 와 member 로 구성한다. 그러나 절차 지향적 언어의 경우 member 로만 구성한다
* 예를 들어 Assertions.assertEqual() 의 경우 Assertions 가 base 이고 assertEqual 이 member 이다
* 또 다른 예로서 assertEqual() 로만 사용할 수 있기 때문에 이 두개를 모두 체크해야 한다. 다음 소스 코드는 동치이다.

   ~~~
   import static org.junit....Asserts;
   @Test
   void test(){
       ...
       assertEquals(a,b);
       ...
   }
   ~~~
   ~~~
   import org.junit.*;
   @Test
   void test(){
        ...
        Assertions.assertEquals(a,b);
        ...
   }
   ~~~
* Token 을 읽어오는 방법은 this.getClass().getClassLoader().getResourceAsStream() 이다
* ***아직 패키징 시 정상 동작함을 확인하지 않았다***

## Token File Structure
* 유닛 테스트 프레임워크 별 토큰 파일은 아래와 같이 구성한다.
    ~~~
          resource folder                  // class loader 가 인지하는 위치
                |
         unite test framework folder       // unit test framework 이름
                |
                ----- base                 // 1개 파일
                ----- <base string>.member // 복수개 가능 base 에 포함된 Token 개수만큼
    ~~~