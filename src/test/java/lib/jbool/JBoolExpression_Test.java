package lib.jbool;

import com.bpodgursky.jbool_expressions.Expression;
import com.bpodgursky.jbool_expressions.eval.EvalEngine;
import com.bpodgursky.jbool_expressions.parsers.ExprParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @implNote https://github.com/bpodgursky/jbool_expressions/blob/master/src/test/java/com/bpodgursky/jbool_expressions/TestExpressions.java
 */
public class JBoolExpression_Test {
    @Test
    void simpleExpression() {
        // 논리식의 문자열은 스키마에서 온다
        // 개별 Variable, i.e., A, B, 은 CSharpTestCaseAnalysis 의 식별자를 의미한다
        Expression<String> logicalExpr = ExprParser.parse("(A & B) | C");

        // 단위 논리 변수 값(개별 분석 결과)는 분석기가 수행 결과를 Helper 에 저장한다
        Map<String, Boolean> exprValMap = new HashMap<>();
        exprValMap.put("A", true);
        exprValMap.put("B", true);
        exprValMap.put("C", false);

        // 메서드 별로 메서드 바디를 빠져나갈때 Helper 에 저장된 값을 가지고 최종 결과를 분석한다.
        // 이 또한 파일 별 최종 결과 저장 인스턴스에 메서드 시그네처 키로 그 결과를 저장한다
        boolean eval = EvalEngine.evaluateBoolean(logicalExpr, exprValMap);

        Assertions.assertTrue(eval);
    }

    @Test
    void wrongExpression() {
        // 실 사용 코드에서는 Runtime Exception 을 받아 Checked Exception 으로 변경했다.
        Assertions.assertThrows(RuntimeException.class, () -> {
            Expression<String> logicalExpr = ExprParser.parse("(A && B) | C");
        });
    }
}
