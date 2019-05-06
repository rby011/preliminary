# Generic Approach For Supporting Possibly All Languages

The test cases have been written in a various languages, e.g., C/C++, Java, JavaScript, 
C#, Python, Go, etc, in samsung electronics according the characteristics of products to test.
The TC Reviewer tool must handle this language variety for identifying and analyzing all the test cases in samsung. 
This is the reason of applying this approach.

Need to discuss on this approach with members in the TC TG.

## Language Parser Generator

All the required information (i.e., name, test case loc, # of assert expression in a test case, etc.)
are inherent in the source code of the test case. A possibly nature approach is to parse the source code to gather the above kinds of information.

However, there are many languages to handle! There must be a generic architectural component to handle this variety. In our view, 
the [ANTLR4](https://github.com/antlr/antlr4) is the one of best solution. It's because of the followngs :
+ [ANTLR4](https://github.com/antlr/antlr4) provides a easy-to-use mechanism to generate parsers for a language
+ [ANTLR4](https://github.com/antlr/antlr4) provides a set of pre-defined grammar files to use these as inputs for generating parsers.
+ [ANTLR4](https://github.com/antlr/antlr4) provides a build mechanism to integrate with maven
+ [ANTLR4](https://github.com/antlr/antlr4) provides a nice mechanism to use in our IntellJ


But this [ANTLR4](https://github.com/antlr/antlr4) has limitations as its nature :

+ Because [ANTLR4](https://github.com/antlr/antlr4) doesn't provide pre-processing logic in it for the C/C++,
developers have to implement pre-processing logic to handle macros like #include, #define, #ifdef, etc. 
+ [ANTLR4](https://github.com/antlr/antlr4) parsers doesn't consider a comment as a parse tree node by default.
Therefore if there needs to analyze the comment, we have to modify grammar files. In order to do this, we can refer to [a guide](http://lms.ui.ac.ir/public/group/90/59/01/15738_ce57.pdf
)

Here are helpful references for [ANTLR4](https://github.com/antlr/antlr4). Please enjoy these :

+ https://github.com/julianthome/inmemantlr
+ http://ati.ttu.ee/~hkinks/antlr/tutorial.pdf --> 환경 셋업
+ http://jakubdziworski.github.io/java/2016/04/01/antlr_visitor_vs_listener.html
+ https://stackoverflow.com/questions/21534316/is-there-a-simple-example-of-using-antlr4-to-create-an-ast-from-java-source-code/21552478#21552478
+ http://blog.dgunia.de/2017/10/26/creating-and-testing-an-antlr-parser-with-intellij-idea-or-android-studio/
+ https://www.antlr.org/api/maven-plugin/latest/
+ https://www.baeldung.com/java-antlr
+ http://lms.ui.ac.ir/public/group/90/59/01/15738_ce57.pdf --> Reference Book
+ https://stackoverflow.com/questions/12485132/catching-and-keeping-all-comments-with-antlr --> 커멘트를 문법으로 정의하기
+ https://www.antlr3.org/pipermail/antlr-interest/2004-July/008724.html
+ https://www.ibm.com/developerworks/aix/library/au-c_plusplus_antlr/index.html

## Supporting Language Version

These grammar definition files come from the antlr github.

Please take a look the git repository first : https://github.com/antlr/grammars-v4/wiki

This repository provides grammar files for various versions of programming languages.
However, there must be a limitation for supporting all the versions of languages.

Please refer to the below regarding the limitations for each language.

### C

- The C.g4 grammar file is for the ANSI-C standards. 

### C++

- The CPP14.g4 grammar file is for the C++ 14.

### Java

- The Java8.g4 grammar file is for the Java 8.


### JavaScript - EcmaScript

- The JavaScript{Lexer|Parser}.g4 fiel is for the ECMA-6.

### C#

- The CSharp{Lexer|Parser|PreprocessorParser}.g4 is for the C# 6.