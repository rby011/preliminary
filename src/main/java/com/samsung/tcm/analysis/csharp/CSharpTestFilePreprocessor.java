package com.samsung.tcm.analysis.csharp;

import com.samsung.tcm.core.parser.csharp.CSharpLexer;
import com.samsung.tcm.core.parser.csharp.CSharpParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSharpTestFilePreprocessor {

    /**
     * TODO : static using 되는 Assert 을 파악하여 SCTestCase 에 설정해두어야 할 필요 검토 필요하다.
     *  자바의 경우는 아래와 같은 구문이 자주 사용된다.
     * <code>
     *      import static org.junit.Assertions;
     *      class TestCalss{
     *          void testMethod(){
     *              assertEquals(a, b); // Assertions.assertEquals(a,b) 를 축약한 형태이다
     *          }
     *      }
     * </code>
     */

    /**
     * @implNote  "https://stackoverflow.com/questions/50455070/issues-with-the-csharp-grammar-preprocessor-directives"
     * * TSTagCommand : #region 등 의 전처리 지시자를 parser 가 파싱을 못하는 것 때문에 이를 모두 제외 시켜버림
     */
    public static CSharpParser removeDirectives(String filePath) throws IOException {
        List<Token> codeTokens = new ArrayList<>();
        CharStream cs = CharStreams.fromPath(Paths.get(filePath));
        CSharpLexer lexer = new CSharpLexer(cs);
        List<? extends Token> tokens = lexer.getAllTokens();

        int index = 0;
        while (index < tokens.size()) {
            Token token = tokens.get(index);

            if (token.getType() == CSharpLexer.SHARP) {// '#' 최초 진입 시 (지시자 만나면)
                int i = index + 1;
                while (tokens.get(i).getType() != CSharpLexer.EOF &&
                        tokens.get(i).getType() != CSharpLexer.DIRECTIVE_NEW_LINE &&
                        tokens.get(i).getType() != CSharpLexer.LINE) {
                    i++;
                }
                index = i;
            } else if (token.getChannel() != Lexer.HIDDEN && token.getType() != CSharpLexer.DIRECTIVE_NEW_LINE) {
                // 일반 실행 코드 토큰 모으기
                codeTokens.add(token);
            }
            index++;
        }

        // 실행 코드 토큰들로 파스 트리 만들기
        ListTokenSource codeTokenSource = new ListTokenSource(codeTokens);
        CommonTokenStream codeTokenStream = new CommonTokenStream(codeTokenSource);
        CSharpParser parser = new CSharpParser(codeTokenStream);
        parser.setBuildParseTree(true);

        return parser;
    }
}
