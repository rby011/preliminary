package com.samsung.tcm.analysis.common;

import com.bpodgursky.jbool_expressions.Expression;
import com.bpodgursky.jbool_expressions.eval.EvalEngine;
import com.samsung.tcm.context.TcmContext;
import com.samsung.tcm.core.loc.CodeCounter;
import com.samsung.tcm.exceptions.NoMatchingIdentifiersException;
import com.samsung.tcm.exceptions.NotSupportIdentifierAnalysisException;
import com.samsung.tcm.schema.*;
import com.samsung.tcm.schema.assertion.SCAssertion;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TestCaseAnalysisHelper {
    /**
     * checkTable
     * + key    : ETestIdentifierLocation
     * + value  : HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>
     * <p>
     * HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>
     * + key    : TestCaseUnitAnalysis
     * <pre>
     *            + hashcode  : genkey.tohashcode
     *            + euquals   : genkey.equals
     * </pre>
     * + value  : ETestCaseUnitAnalysisResult (TRUE, FALSE, NONE)
     *
     * @implNote 식별 목적을 TC 여부 식별, Neg TC 여부 식별, Pos TC 여부 식별로 정의하고 이 목적이 implicitly 정의된다.
     * 예를 들면, toCheckTCTable.size() = 0 이면 TC 여부 식별을 이 helper 를 갖는 분석기는 할 필요가 없다는 의미이다
     * 만일 size() = 2 이고 key 가 METHOD_NAME, ATTRIBUTE 라면 TC 여부 식별을 위해서는 메서드 이름과 속성을 함께 분석
     * 해야 한다는 의미고 각 개별 분석간의 관계는 value 로 정의된 HashMap 의 key 인 TestCaseUnitAnalysis 가
     * 정의된다. 해당 논리 관계는 현재는 OR 와 AND 만을 지원한다
     **/
    private Hashtable<IIdentifierLocation, HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> toCheckTCTable =
            new Hashtable<>();
    private Hashtable<IIdentifierLocation, HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> toCheckTCTablePos =
            new Hashtable<>();
    private Hashtable<IIdentifierLocation, HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> toCheckTCTableNeg =
            new Hashtable<>();

    private Expression<String> expr;
    private Expression<String> exprForPosTC;
    private Expression<String> exprForNegTC;

    /**
     * + key   : method signature  = namespace + method name + parameter(#)
     * <p>
     * + value :  An instance that contains analysis results including loc, number of assertions, negative or not.
     *
     * @implNote Analyzer 는 파일 단위로 생성되고 파일 내에는 복수개의 메서드가 존재한다.
     * 파일 분석 완료시 아래 자료 구조를 통해 최종 분석 결과를 가져가야 한다.
     */
    private Hashtable<String, MethodAnalysisResult> checkResult = new Hashtable<>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                  BEGIN OF 추가 필요
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private FileAnalysisResult fileResult = new FileAnalysisResult();// TODO ADD

    public FileAnalysisResult getFileResult() { // TODO ADD
        return fileResult;
    }

    public SCTestCase getTestCase() { // TODO ADD
        return testCase;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                  END OF 추가 필요
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * + key    : ETestCaseIdentifierLocation Enumeration (METHOD_NAME, ATTRIBUTE, ANNOTATION, ETC) 등 스키마 정보
     * + value  : 스키마가 알려주는 식별자 위치에 대응되는 파스 트리 노드 (CSharpParser.AttributeContext, etc)
     *
     * @implNote 스키마 월드와 파서 월드를 매핑시켜 과제별 변이 사항을 모듈화 시키는 목적이다.
     * 과제별 변이 사항 중 가장 주요 모듈화 대상은 식별자 위치와 추상 구문 트리 위치
     */
    protected Hashtable<String, IIdentifierLocation> parseTreeNodeMap = new Hashtable<>();
    protected Hashtable<String, IIdentifierLocation> parseTreeNodeMapPos = new Hashtable<>();
    protected Hashtable<String, IIdentifierLocation> parseTreeNodeMapNeg = new Hashtable<>();

    protected SCTestCase testCase;

    // TODO : 테스트 파일과 테스트 케이스가 One TO One 관계로 가정. 향후 One To Many 로 변경시 SCTestFile 로 변경 필요
    public TestCaseAnalysisHelper(SCTestCase testCase) {
        this.testCase = testCase;

        // 파스 트리 노드와 대응되는 스키마 매핑. eg., Attribute vs CSharpParseTree.AttributeContext
        buildParseTreeMap();        // TC 여부 판단
        buildParseTreeMapPos();     // Positive TC 여부 판단
        buildParseTreeMapNeg();     // Negative TC 여부 판단

        // Check Table 초기화
        initializo(this.testCase);
    }

    public ITestFramework getTestFramework() {
        return testCase.getTestFramework();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //             특정 Abstract Syntax Tree 노드 순회시 TC 식별 위한 중간 과정으로 해당 노드를 체크해야 하는지를 알려준다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean needToCheckForTCIdentify(String parseTreeContextClassName) {
        ETestCaseIdentifierLocation s = (ETestCaseIdentifierLocation) this.parseTreeNodeMap.get(parseTreeContextClassName);
        if (s == null) return false;

        return toCheckTCTable.get(s) != null;
    }

    public boolean needToCheckForPosTCIdentify(String parseTreeContextClassName) {
        ETestCaseIdentifierLocation s = (ETestCaseIdentifierLocation) this.parseTreeNodeMapPos.get(parseTreeContextClassName);
        if (s == null) return false;

        return toCheckTCTablePos.get(s) != null;
    }

    public boolean needToCheckForNegTCIdentify(String parseTreeContextClassName) {
        ETestCaseIdentifierLocation s = (ETestCaseIdentifierLocation) this.parseTreeNodeMapNeg.get(parseTreeContextClassName);
        if (s == null) return false;

        return toCheckTCTableNeg.get(s) != null;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                 특정 Abstract Syntax Tree 노드맵이 어떤 ETestCaseIdentifierLocation 을 가리키는지 알려준다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @param parseTreeContextClassName CSharpParseTree.Context 객체의 클래스 이름(i.e., getClass().getName())
     * @return PasreTree Context 에 대응되는 ETestCaseIdentificationLocation
     */
    public IIdentifierLocation getLocationSchema(String parseTreeContextClassName) {
        return this.parseTreeNodeMap.get(parseTreeContextClassName);
    }

    /**
     * @param parseTreeContextClassName CSharpParseTree.Context 객체의 클래스 이름(i.e., getClass().getName())
     * @return PasreTree Context 에 대응되는 ETestCaseIdentificationLocation
     */
    public IIdentifierLocation getLocationSchemaForPos(String parseTreeContextClassName) {
        return this.parseTreeNodeMapPos.get(parseTreeContextClassName);
    }

    public IIdentifierLocation getLocationSchemaForNeg(String parseTreeContextClassName) {
        return this.parseTreeNodeMapNeg.get(parseTreeContextClassName);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                특정 Abstract Syntax Tree 노드맵에서 어떤 체크를 해야 하는지 알려준다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> getTestCaseAnalysis(String parseTreeContextClassName) {
        ETestCaseIdentifierLocation idLocation = (ETestCaseIdentifierLocation) this.getLocationSchema(parseTreeContextClassName);
        if (idLocation == null)
            return null;
        return this.toCheckTCTable.get(idLocation);
    }

    public Collection<HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> getTestCaseAnalysis() {
        return this.toCheckTCTable.values();
    }


    public HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> getTestCaseAnalysisForPosTC(String parseTreeContextClassName) {
        ETestCaseIdentifierLocation idLocation = (ETestCaseIdentifierLocation) this.getLocationSchemaForPos(parseTreeContextClassName);// 수정 필요한가 ???
        if (idLocation == null)
            return null;
        return this.toCheckTCTablePos.get(idLocation);
    }

    public Collection<HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> getTestCaseAnalysisForPosTC() {
        return this.toCheckTCTablePos.values();
    }


    public HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> getTestCaseAnalysisForNegTC(String parseTreeContextClassName) {
        ETestCaseIdentifierLocation idLocation = (ETestCaseIdentifierLocation) this.getLocationSchemaForNeg(parseTreeContextClassName);
        if (idLocation == null)
            return null;

        return this.toCheckTCTableNeg.get(idLocation);
    }

    public Collection<HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> getTestCaseAnalysisForNegTC() {
        return this.toCheckTCTableNeg.values();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                       개별 체크 항목별로 결과를 저장한다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void putUnitAnalysisResult(String parseTreeContextClassName, String ID, boolean result)
            throws NoMatchingIdentifiersException {
        ETestCaseIdentifierLocation idLocation = (ETestCaseIdentifierLocation) this.parseTreeNodeMap.get(parseTreeContextClassName);

        if (idLocation == null)
            throw new NoMatchingIdentifiersException("There is no configured identification rule to check the given location : " + idLocation.toString());

        putUnitAnalysisResult(idLocation, ID, result, toCheckTCTable);
    }

    public void putUnitAnalysisResultForPosTC(String parseTreeContextClassName, String ID, boolean result)
            throws NoMatchingIdentifiersException {
        ETestCaseIdentifierLocation idLocation = (ETestCaseIdentifierLocation) this.parseTreeNodeMapPos.get(parseTreeContextClassName);
        if (idLocation == null)
            throw new NoMatchingIdentifiersException("There is no configured identification rule to check the given location : " + idLocation.toString());

        putUnitAnalysisResult(idLocation, ID, result, toCheckTCTablePos);
    }

    public void putUnitAnalysisResultForNegTC(String parseTreeContextClassName, String ID, boolean result)
            throws NoMatchingIdentifiersException {
        ETestCaseIdentifierLocation idLocation = (ETestCaseIdentifierLocation) this.parseTreeNodeMapNeg.get(parseTreeContextClassName);
        if (idLocation == null)
            throw new NoMatchingIdentifiersException("There is no configured identification rule to check the given location : " + idLocation.toString());

        putUnitAnalysisResult(idLocation, ID, result, toCheckTCTableNeg);
    }

    private void putUnitAnalysisResult(ETestCaseIdentifierLocation idLocation, String ID, boolean result,
                                       Hashtable<IIdentifierLocation, HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> toCheckTCTableCom)
            throws NoMatchingIdentifiersException {

        HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> analysisTable = toCheckTCTableCom.get(idLocation);
        if (analysisTable == null)
            throw new NoMatchingIdentifiersException("There is no configured identification rule to check the given location : " + idLocation.toString());

        TestCaseUnitAnalysis key = TestCaseUnitAnalysis.getKeyInstance(ID);

        if (analysisTable.get(key) == null)
            throw new NoMatchingIdentifiersException("There is no identification rule to check with the given key : " + key.toString());

        if (result)
            analysisTable.put(key, ETestCaseUnitAnalysisResult.TRUE);
        else
            analysisTable.put(key, ETestCaseUnitAnalysisResult.FALSE);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                       개별 체크 항목별로 결과를 조회한다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean getUnitAnalysisResult(String parseTreeContextClassName, String ID)
            throws NoMatchingIdentifiersException {
        ETestCaseIdentifierLocation idLocation = (ETestCaseIdentifierLocation) this.parseTreeNodeMap.get(parseTreeContextClassName);
        if (idLocation == null)
            throw new NoMatchingIdentifiersException("There is no identification result that was made with the given location : " + idLocation.toString());

        return getUnitAnalysisResults(idLocation, ID, toCheckTCTable);
    }

    public boolean getUnitAnalysisResultForPosTC(String parseTreeContextClassName, String ID)
            throws NoMatchingIdentifiersException {
        ETestCaseIdentifierLocation idLocation = (ETestCaseIdentifierLocation) this.parseTreeNodeMapPos.get(parseTreeContextClassName);
        if (idLocation == null)
            throw new NoMatchingIdentifiersException("There is no identification result that was made with the given location : " + idLocation.toString());

        return getUnitAnalysisResults(idLocation, ID, toCheckTCTablePos);
    }

    public boolean getUnitAnalysisResultForNegTC(String parseTreeContextClassName, String ID)
            throws NoMatchingIdentifiersException {
        ETestCaseIdentifierLocation idLocation = (ETestCaseIdentifierLocation) this.parseTreeNodeMapNeg.get(parseTreeContextClassName);
        if (idLocation == null)
            throw new NoMatchingIdentifiersException("There is no identification result that was made with the given location : " + idLocation.toString());

        return getUnitAnalysisResults(idLocation, ID, toCheckTCTableNeg);
    }

    private boolean getUnitAnalysisResults(ETestCaseIdentifierLocation idLocation, String ID,
                                           Hashtable<IIdentifierLocation, HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> toCheckTCTableCom)
            throws NoMatchingIdentifiersException {

        HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> idMethodTable = toCheckTCTableCom.get(idLocation);
        if (idMethodTable == null)
            throw new NoMatchingIdentifiersException("There is no identification result that was made with the given location : " + idLocation.toString());

        // SET KEY WITH NEW VALUE
        TestCaseUnitAnalysis key = TestCaseUnitAnalysis.getKeyInstance(ID);

        ETestCaseUnitAnalysisResult eResult = idMethodTable.get(key);
        if (eResult == null || eResult == ETestCaseUnitAnalysisResult.NONE)
            throw new NoMatchingIdentifiersException("There is no identification result that was made with the given key : " + key.toString());

        if (eResult == ETestCaseUnitAnalysisResult.FALSE) return false;
        else return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                    메서드 별로의 최종 분석 결과를 저장한다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void putMethodAnalysisResult(String methodSignature, MethodAnalysisResult methodResult) {
        if (checkResult.contains(methodSignature)) {
            // TODO : WARNING 필요함. 한 파일 내에서 동일한 메서드 시그네처를 가지는 경우.
        }
        checkResult.put(methodSignature, methodResult);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                추상 구문 트리에서 추출한 문자열과 식별 규칙의 문자열을 식별 방법에 따라 바교해 식별 여부를 판단한다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean matchWithParseTreeContext(String contextFromParseTree, ETestCaseIdentifyMethod idMethodFromSchema, String idFromSchema)
            throws NotSupportIdentifierAnalysisException {
        boolean result;
        if (idMethodFromSchema == ETestCaseIdentifyMethod.PREFIX) {
            result = contextFromParseTree.startsWith(idFromSchema);
        } else if (idMethodFromSchema == ETestCaseIdentifyMethod.POSTFIX) {
            result = contextFromParseTree.endsWith(idFromSchema);
        } else if (idMethodFromSchema == ETestCaseIdentifyMethod.EXACT) {
            result = contextFromParseTree.equals(idFromSchema);
        } else if (idMethodFromSchema == ETestCaseIdentifyMethod.REGEXPR) {
            Pattern compile = Pattern.compile(idFromSchema);
            Matcher matcher = compile.matcher(contextFromParseTree);
            result = matcher.matches();
        } else if (idMethodFromSchema == ETestCaseIdentifyMethod.NONE) {
            result = false;
        } else {
            throw new NotSupportIdentifierAnalysisException("The given identify method " + idMethodFromSchema + " is not supported");
        }
        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                모아진 정보로 TC 여부 (NEGATIVE, POSITIVE 포함) 를 판단한다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean decideTestCase(ETestCaseType testCaseType) {
        boolean ret = false;

        Collection<HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> tcAnalysis = null;

        if (testCaseType == ETestCaseType.NONE) {
            tcAnalysis = getTestCaseAnalysis();
        } else if (testCaseType == ETestCaseType.NEGATIVE) {
            tcAnalysis = getTestCaseAnalysisForNegTC();
        } else if (testCaseType == ETestCaseType.POSITIVE) {
            tcAnalysis = getTestCaseAnalysisForPosTC();
        }

        if (tcAnalysis == null) return ret;

        // 개별 식별 분석을 수행한다
        Map<String, Boolean> valueMap = new HashMap<>();
        Iterator<HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> iterator = tcAnalysis.iterator();
        while (iterator.hasNext()) {
            HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> next = iterator.next();
            Set<TestCaseUnitAnalysis> analyses = next.keySet();
            for (TestCaseUnitAnalysis analysis : analyses) {
                String id = analysis.getID();
                if (next.get(analysis) == ETestCaseUnitAnalysisResult.TRUE) {
                    valueMap.put(id, true);
                } else {
                    valueMap.put(id, false);
                }
            }
        }

        // 개별 분석 결과를 가지고 논리식을 평가한다
        if (testCaseType == ETestCaseType.NONE) {
            ret = EvalEngine.evaluateBoolean(this.expr, valueMap);
        } else if (testCaseType == ETestCaseType.NEGATIVE) {
            ret = EvalEngine.evaluateBoolean(this.exprForNegTC, valueMap);
        } else {//if(testCaseType == ETestCaseType.POSITIVE){
            ret = EvalEngine.evaluateBoolean(this.exprForPosTC, valueMap);
        }

        return ret;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                            BUILD CHECK TABLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void initializo(@NotNull SCTestCase testCase) {
        ArrayList<SCITestCaseIdentifier> tcIdentifiers = testCase.getTcIdentifiers();
        initCheckTable(tcIdentifiers, toCheckTCTable);

        ArrayList<SCITestCaseIdentifier> posTcIdentifiers = testCase.getIdentifiersForPosTC();
        initCheckTable(posTcIdentifiers, toCheckTCTablePos);

        ArrayList<SCITestCaseIdentifier> negTcIdentifiers = testCase.getIdentifiersForNegTC();
        initCheckTable(negTcIdentifiers, toCheckTCTableNeg);

        this.expr = testCase.getBoolExpression();
        this.exprForNegTC = testCase.getBoolExpressionForNegTC();
        this.exprForPosTC = testCase.getBoolExpressionForPosTC();
    }

    private void initCheckTable(@NotNull ArrayList<SCITestCaseIdentifier> identifiers,
                                @NotNull Hashtable<IIdentifierLocation, HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult>> toCheckTable) {
        for (SCITestCaseIdentifier identifier : identifiers) {
            ETestCaseIdentifierLocation idLocationEnum = (ETestCaseIdentifierLocation) identifier.getIdentifierLocationEnum();
            ETestCaseIdentifyMethod idMethodEnum = (ETestCaseIdentifyMethod) identifier.getIdentifierMethodEnum();
            String idStr = identifier.getIdentifier();
            String ID = identifier.getID();
            Integer idPosition = identifier.getIdPosition();

            boolean needPut = false;
            HashMap<TestCaseUnitAnalysis, ETestCaseUnitAnalysisResult> analysisSet = null;
            if (!toCheckTable.containsKey(idLocationEnum)) {
                analysisSet = new HashMap<>();
                needPut = true;
            } else {
                analysisSet = toCheckTable.get(idLocationEnum);
            }

            TestCaseUnitAnalysis analysis = new TestCaseUnitAnalysis(ID, idStr, idMethodEnum, idPosition);
            analysisSet.put(analysis, ETestCaseUnitAnalysisResult.NONE);

            if (needPut)
                toCheckTable.put(idLocationEnum, analysisSet);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                              다음 분석을 위해 checkTable 을 clear 한다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void reset() {
        toCheckTCTable.clear();
        toCheckTCTablePos.clear();
        toCheckTCTableNeg.clear();
        initializo(this.testCase);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                              BUILD PARSE TREE MAP (TO ETestCaseIdentifierLocation)
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public abstract void buildParseTreeMap();

    public abstract void buildParseTreeMapPos();

    public abstract void buildParseTreeMapNeg();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                             한 개의 파일을 모두 분석한 최종 결과를 가지고 온다
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Hashtable<String, MethodAnalysisResult> getAnalysisResult() {
        return checkResult;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                              GETTING LOC COUNTER AND ASSERTIONS FOR ANALYZER
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public CodeCounter getLocCodeCounter() {
        CodeCounter ret = null;
        try {
            ret = TcmContext.getInstance().getLocContext(testCase.getLanguage());
        } catch (Exception ex) {
            // TODO: WARNING LOG
        }
        return ret;
    }

    public SCAssertion getAssertionExpression() {
        SCAssertion scAssertion = null;
        try {
            scAssertion = TcmContext.getInstance().getAssertionContext(testCase.getTestFramework());
        } catch (Exception ex) {
            // TODO : WARNING LOG
        }
        return scAssertion;
    }
}
