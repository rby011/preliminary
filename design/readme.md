## Installation dependency

### Design UML & Generate Class Diagram

#### Dependencies

| Prerequisite    | Download URL                         | Remark                                                                                       |
|:----------------|:-------------------------------------|:---------------------------------------------------------------------------------------------|
| GraphViz        | https://graphviz.gitlab.io/download/ | * GRAPHVIZ_DOT 환경 변수 : C:\Program Files (x86)\Graphviz2.38\bin\dot.exe |
| PlantUML Plugin | Using IntelliJ Setting               |  * UML 작성 도구                                                                                            |
| Sketch          | Using IntelliJ Setting  | * UML 생성 도구 (PlantUML 기반)                                                                                              |


#### How to use

* 'Tools > Sketch It' 선택하면 프로젝트 루트에 PlantUML 파일 생성
* 각 패키별로 클래스 다이어그램 이미지 생성됨
* 해당 파일 선택하면 플랜트 UML 플러그인에서 클래스 다이어그램 이미지로 볼 수 있음
* 그러나 컬랙션의 타입을 통해 aggregation 하거나 하면 관계 찾지 못함


### Generate Sequence Diagram

#### Dependency

https://plugins.jetbrains.com/plugin/8286-sequencediagram

#### Hot to use

with this plugin, you can + generate Simple Sequence Diagram.
+ Navigate the code by click the diagram shape.
+ Delete Class from diagram.
+ Export the diagram as image.
+ Exclude classes from diagram by Settings > Other Settings > Sequence
+ Smart Interface(experimental)