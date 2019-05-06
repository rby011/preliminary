* 향후 com.samsung.tcm.analysis.csharp 내의 클래스들이 공통 모듈로 빠지는 경우 언어별 별도 패키지와 언어별 공통 패키지로 구분될 것이다.
* TestCaseAnalysisHelper, TestCaseAnalyzer, TestFilePrepreocessor 는 언어별로 구현될 것이고
* MethodAnalysisResult, TestCaseCalleeeInMethod, TestCaseUnitAnalysis, TestCasUnitAnalysisResult, ITestCaseUnitAnalysisResult 는 언어 독립적인 공통 모듈이 될 것이다
* 특히 이들간에 Abstract Class 나 Interface 정의가 필요한지 검토할 필요가 있다