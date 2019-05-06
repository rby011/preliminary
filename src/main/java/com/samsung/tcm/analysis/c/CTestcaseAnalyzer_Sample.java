package com.samsung.tcm.analysis.c;

import com.samsung.tcm.core.parser.c.CBaseListener;
import com.samsung.tcm.core.parser.c.CParser;

public class CTestcaseAnalyzer_Sample extends CBaseListener {
    @Override
    public void enterCompilationUnit(CParser.CompilationUnitContext ctx) {
        super.enterCompilationUnit(ctx);
        System.out.print("[enterCompilationUnit]");
        String text = ctx.getText();
        System.out.println(text);
    }

    @Override
    public void enterIncludeDeclaration(CParser.IncludeDeclarationContext ctx) {
        super.enterIncludeDeclaration(ctx);
        System.out.print("[enterIncludeDeclaration]");
        String text = ctx.getText();
        System.out.println(text);
    }

    @Override
    public void enterDefineDeclaration(CParser.DefineDeclarationContext ctx) {
        super.enterDefineDeclaration(ctx);
        System.out.print("[enterDefineDeclaration]");
        String text = ctx.getText();
        System.out.println(text);
    }

    @Override
    public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        super.enterFunctionDefinition(ctx);
        System.out.print("[enterFunctionDefinition]");
        String text = ctx.getText();
        System.out.println(text);
    }

//    functionDefinition
//    :   declarationSpecifiers? declarator declarationList? compoundStatement
//    ;

    // 출력 : [enterDeclarationSpecifiers]staticvoid
    @Override
    public void enterDeclarationSpecifiers(CParser.DeclarationSpecifiersContext ctx) {
        super.enterDeclarationSpecifiers(ctx);
        System.out.print("[enterDeclarationSpecifiers]");
        String text = ctx.getText();
        System.out.println(text);
    }

    // 출력 : [enterDeclarator]load_error(void*data,Evas_Object*webview,void*event_info)
    @Override
    public void enterDeclarator(CParser.DeclaratorContext ctx) {
        super.enterDeclarator(ctx);
        System.out.print("[enterDeclarator]");
        String text = ctx.getText();
        System.out.println(text);
    }

//    declarator
//    :   pointer? directDeclarator gccDeclaratorExtension*

    @Override
    public void enterDirectDeclarator(CParser.DirectDeclaratorContext ctx) {
        super.enterDirectDeclarator(ctx);
        System.out.print("[enterDirectDeclarator]");
        String text = ctx.getText();
        System.out.println(text + " : IDENTIFIER --> " + ctx.Identifier());
    }


//    directDeclarator
//    :   Identifier
//    |   '(' declarator ')'
//            |   directDeclarator '[' typeQualifierList? assignmentExpression? ']'
//            |   directDeclarator '[' 'static' typeQualifierList? assignmentExpression ']'
//            |   directDeclarator '[' typeQualifierList 'static' assignmentExpression ']'
//            |   directDeclarator '[' typeQualifierList? '*' ']'
//            |   directDeclarator '(' parameterTypeList ')'
//            |   directDeclarator '(' identifierList? ')'
//            |   Identifier ':' DigitSequence  // bit field
//    |   '(' typeSpecifier? pointer directDeclarator ')' // function pointer like: (__cdecl *f)
//    ;

    @Override
    public void enterDeclarationList(CParser.DeclarationListContext ctx) {
        super.enterDeclarationList(ctx);
        System.out.print("[enterDeclarationList]");

        String text = ctx.getText();
        System.out.println(text);
    }

    @Override
    public void enterCompoundStatement(CParser.CompoundStatementContext ctx) {
        super.enterCompoundStatement(ctx);
        System.out.print("[enterCompoundStatement]");

        String text = ctx.getText();
        System.out.println(text);
    }
}
