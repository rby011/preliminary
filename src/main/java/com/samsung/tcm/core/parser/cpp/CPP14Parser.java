package com.samsung.tcm.core.parser.cpp;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CPP14Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IncludeDirective=1, ImportDirective=2, DefineStart=3, DefineDirective=4, 
		ErrorDirective=5, WarningDirective=6, UndefDirective=7, IfDirective=8, 
		EndIfDirective=9, ElseDirective=10, LineDirective=11, UsingDirective=12, 
		Progrma=13, Alignas=14, Alignof=15, Asm=16, Auto=17, Bool=18, Break=19, 
		Case=20, Catch=21, Char=22, Char16=23, Char32=24, Class=25, Const=26, 
		Constexpr=27, Const_cast=28, Continue=29, Decltype=30, Default=31, Delete=32, 
		Do=33, Double=34, Dynamic_cast=35, Else=36, Enum=37, Explicit=38, Export=39, 
		Extern=40, False=41, Final=42, Float=43, For=44, Friend=45, Goto=46, If=47, 
		Inline=48, Int=49, Long=50, Mutable=51, Namespace=52, New=53, Noexcept=54, 
		Nullptr=55, Operator=56, Override=57, Private=58, Protected=59, Public=60, 
		Register=61, Reinterpret_cast=62, Return=63, Short=64, Signed=65, Sizeof=66, 
		Static=67, Static_assert=68, Static_cast=69, Struct=70, Switch=71, Template=72, 
		This=73, Thread_local=74, Throw=75, True=76, Try=77, Typedef=78, Typeid_=79, 
		Typename_=80, Union=81, Unsigned=82, Using=83, Virtual=84, Void=85, Volatile=86, 
		Wchar=87, While=88, LeftParen=89, RightParen=90, LeftBracket=91, RightBracket=92, 
		LeftBrace=93, RightBrace=94, Plus=95, Minus=96, Star=97, Div=98, Mod=99, 
		Caret=100, And=101, Or=102, Tilde=103, Not=104, Assign=105, Less=106, 
		Greater=107, PlusAssign=108, MinusAssign=109, StarAssign=110, DivAssign=111, 
		ModAssign=112, XorAssign=113, AndAssign=114, OrAssign=115, LeftShift=116, 
		RightShift=117, LeftShiftAssign=118, RightShiftAssign=119, Equal=120, 
		NotEqual=121, LessEqual=122, GreaterEqual=123, AndAnd=124, OrOr=125, PlusPlus=126, 
		MinusMinus=127, Comma=128, ArrowStar=129, Arrow=130, Question=131, Colon=132, 
		Doublecolon=133, Semi=134, Dot=135, DotStar=136, Ellipsis=137, Identifier=138, 
		Integerliteral=139, Decimalliteral=140, Octalliteral=141, Hexadecimalliteral=142, 
		Binaryliteral=143, Integersuffix=144, Characterliteral=145, Floatingliteral=146, 
		Stringliteral=147, Userdefinedintegerliteral=148, Userdefinedfloatingliteral=149, 
		Userdefinedstringliteral=150, Userdefinedcharacterliteral=151, Whitespace=152, 
		Newline=153, BlockComment=154, LineComment=155;
	public static final int
		RULE_translationunit = 0, RULE_primaryexpression = 1, RULE_idexpression = 2, 
		RULE_unqualifiedid = 3, RULE_qualifiedid = 4, RULE_nestednamespecifier = 5, 
		RULE_lambdaexpression = 6, RULE_lambdaintroducer = 7, RULE_lambdacapture = 8, 
		RULE_capturedefault = 9, RULE_capturelist = 10, RULE_capture = 11, RULE_simplecapture = 12, 
		RULE_initcapture = 13, RULE_lambdadeclarator = 14, RULE_postfixexpression = 15, 
		RULE_typeidofexpr = 16, RULE_typeidofthetypeid = 17, RULE_expressionlist = 18, 
		RULE_pseudodestructorname = 19, RULE_unaryexpression = 20, RULE_unaryoperator = 21, 
		RULE_newexpression = 22, RULE_newplacement = 23, RULE_newtypeid = 24, 
		RULE_newdeclarator = 25, RULE_noptrnewdeclarator = 26, RULE_newinitializer = 27, 
		RULE_deleteexpression = 28, RULE_noexceptexpression = 29, RULE_castexpression = 30, 
		RULE_pmexpression = 31, RULE_multiplicativeexpression = 32, RULE_additiveexpression = 33, 
		RULE_shiftexpression = 34, RULE_shiftoperator = 35, RULE_relationalexpression = 36, 
		RULE_equalityexpression = 37, RULE_andexpression = 38, RULE_exclusiveorexpression = 39, 
		RULE_inclusiveorexpression = 40, RULE_logicalandexpression = 41, RULE_logicalorexpression = 42, 
		RULE_conditionalexpression = 43, RULE_assignmentexpression = 44, RULE_assignmentoperator = 45, 
		RULE_expression = 46, RULE_constantexpression = 47, RULE_statement = 48, 
		RULE_labeledstatement = 49, RULE_expressionstatement = 50, RULE_compoundstatement = 51, 
		RULE_statementseq = 52, RULE_selectionstatement = 53, RULE_condition = 54, 
		RULE_iterationstatement = 55, RULE_forinitstatement = 56, RULE_forrangedeclaration = 57, 
		RULE_forrangeinitializer = 58, RULE_jumpstatement = 59, RULE_declarationstatement = 60, 
		RULE_declarationseq = 61, RULE_declaration = 62, RULE_blockdeclaration = 63, 
		RULE_aliasdeclaration = 64, RULE_simpledeclaration = 65, RULE_static_assertdeclaration = 66, 
		RULE_emptydeclaration = 67, RULE_attributedeclaration = 68, RULE_declspecifier = 69, 
		RULE_declspecifierseq = 70, RULE_storageclassspecifier = 71, RULE_functionspecifier = 72, 
		RULE_typedefname = 73, RULE_typespecifier = 74, RULE_trailingtypespecifier = 75, 
		RULE_typespecifierseq = 76, RULE_trailingtypespecifierseq = 77, RULE_simpletypespecifier = 78, 
		RULE_thetypename = 79, RULE_decltypespecifier = 80, RULE_elaboratedtypespecifier = 81, 
		RULE_enumname = 82, RULE_enumspecifier = 83, RULE_enumhead = 84, RULE_opaqueenumdeclaration = 85, 
		RULE_enumkey = 86, RULE_enumbase = 87, RULE_enumeratorlist = 88, RULE_enumeratordefinition = 89, 
		RULE_enumerator = 90, RULE_namespacename = 91, RULE_originalnamespacename = 92, 
		RULE_namespacedefinition = 93, RULE_namednamespacedefinition = 94, RULE_originalnamespacedefinition = 95, 
		RULE_extensionnamespacedefinition = 96, RULE_unnamednamespacedefinition = 97, 
		RULE_namespacebody = 98, RULE_namespacealias = 99, RULE_namespacealiasdefinition = 100, 
		RULE_qualifiednamespacespecifier = 101, RULE_usingdeclaration = 102, RULE_usingdirective = 103, 
		RULE_asmdefinition = 104, RULE_linkagespecification = 105, RULE_attributespecifierseq = 106, 
		RULE_attributespecifier = 107, RULE_alignmentspecifier = 108, RULE_attributelist = 109, 
		RULE_attribute = 110, RULE_attributetoken = 111, RULE_attributescopedtoken = 112, 
		RULE_attributenamespace = 113, RULE_attributeargumentclause = 114, RULE_balancedtokenseq = 115, 
		RULE_balancedtoken = 116, RULE_initdeclaratorlist = 117, RULE_initdeclarator = 118, 
		RULE_declarator = 119, RULE_ptrdeclarator = 120, RULE_noptrdeclarator = 121, 
		RULE_parametersandqualifiers = 122, RULE_trailingreturntype = 123, RULE_ptroperator = 124, 
		RULE_cvqualifierseq = 125, RULE_cvqualifier = 126, RULE_refqualifier = 127, 
		RULE_declaratorid = 128, RULE_thetypeid = 129, RULE_abstractdeclarator = 130, 
		RULE_ptrabstractdeclarator = 131, RULE_noptrabstractdeclarator = 132, 
		RULE_abstractpackdeclarator = 133, RULE_noptrabstractpackdeclarator = 134, 
		RULE_parameterdeclarationclause = 135, RULE_parameterdeclarationlist = 136, 
		RULE_parameterdeclaration = 137, RULE_functiondefinition = 138, RULE_functionbody = 139, 
		RULE_initializer = 140, RULE_braceorequalinitializer = 141, RULE_initializerclause = 142, 
		RULE_initializerlist = 143, RULE_bracedinitlist = 144, RULE_classname = 145, 
		RULE_classspecifier = 146, RULE_classhead = 147, RULE_classheadname = 148, 
		RULE_classvirtspecifier = 149, RULE_classkey = 150, RULE_memberspecification = 151, 
		RULE_memberdeclaration = 152, RULE_memberdeclaratorlist = 153, RULE_memberdeclarator = 154, 
		RULE_virtspecifierseq = 155, RULE_virtspecifier = 156, RULE_purespecifier = 157, 
		RULE_baseclause = 158, RULE_basespecifierlist = 159, RULE_basespecifier = 160, 
		RULE_classordecltype = 161, RULE_basetypespecifier = 162, RULE_accessspecifier = 163, 
		RULE_conversionfunctionid = 164, RULE_conversiontypeid = 165, RULE_conversiondeclarator = 166, 
		RULE_ctorinitializer = 167, RULE_meminitializerlist = 168, RULE_meminitializer = 169, 
		RULE_meminitializerid = 170, RULE_operatorfunctionid = 171, RULE_literaloperatorid = 172, 
		RULE_templatedeclaration = 173, RULE_templateparameterlist = 174, RULE_templateparameter = 175, 
		RULE_typeparameter = 176, RULE_simpletemplateid = 177, RULE_templateid = 178, 
		RULE_templatename = 179, RULE_templateargumentlist = 180, RULE_templateargument = 181, 
		RULE_typenamespecifier = 182, RULE_explicitinstantiation = 183, RULE_explicitspecialization = 184, 
		RULE_tryblock = 185, RULE_functiontryblock = 186, RULE_handlerseq = 187, 
		RULE_handler = 188, RULE_exceptiondeclaration = 189, RULE_throwexpression = 190, 
		RULE_exceptionspecification = 191, RULE_dynamicexceptionspecification = 192, 
		RULE_typeidlist = 193, RULE_noexceptspecification = 194, RULE_defineDeclaration = 195, 
		RULE_includeDeclaration = 196, RULE_theoperator = 197, RULE_literal = 198, 
		RULE_booleanliteral = 199, RULE_pointerliteral = 200, RULE_userdefinedliteral = 201;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationunit", "primaryexpression", "idexpression", "unqualifiedid", 
			"qualifiedid", "nestednamespecifier", "lambdaexpression", "lambdaintroducer", 
			"lambdacapture", "capturedefault", "capturelist", "capture", "simplecapture", 
			"initcapture", "lambdadeclarator", "postfixexpression", "typeidofexpr", 
			"typeidofthetypeid", "expressionlist", "pseudodestructorname", "unaryexpression", 
			"unaryoperator", "newexpression", "newplacement", "newtypeid", "newdeclarator", 
			"noptrnewdeclarator", "newinitializer", "deleteexpression", "noexceptexpression", 
			"castexpression", "pmexpression", "multiplicativeexpression", "additiveexpression", 
			"shiftexpression", "shiftoperator", "relationalexpression", "equalityexpression", 
			"andexpression", "exclusiveorexpression", "inclusiveorexpression", "logicalandexpression", 
			"logicalorexpression", "conditionalexpression", "assignmentexpression", 
			"assignmentoperator", "expression", "constantexpression", "statement", 
			"labeledstatement", "expressionstatement", "compoundstatement", "statementseq", 
			"selectionstatement", "condition", "iterationstatement", "forinitstatement", 
			"forrangedeclaration", "forrangeinitializer", "jumpstatement", "declarationstatement", 
			"declarationseq", "declaration", "blockdeclaration", "aliasdeclaration", 
			"simpledeclaration", "static_assertdeclaration", "emptydeclaration", 
			"attributedeclaration", "declspecifier", "declspecifierseq", "storageclassspecifier", 
			"functionspecifier", "typedefname", "typespecifier", "trailingtypespecifier", 
			"typespecifierseq", "trailingtypespecifierseq", "simpletypespecifier", 
			"thetypename", "decltypespecifier", "elaboratedtypespecifier", "enumname", 
			"enumspecifier", "enumhead", "opaqueenumdeclaration", "enumkey", "enumbase", 
			"enumeratorlist", "enumeratordefinition", "enumerator", "namespacename", 
			"originalnamespacename", "namespacedefinition", "namednamespacedefinition", 
			"originalnamespacedefinition", "extensionnamespacedefinition", "unnamednamespacedefinition", 
			"namespacebody", "namespacealias", "namespacealiasdefinition", "qualifiednamespacespecifier", 
			"usingdeclaration", "usingdirective", "asmdefinition", "linkagespecification", 
			"attributespecifierseq", "attributespecifier", "alignmentspecifier", 
			"attributelist", "attribute", "attributetoken", "attributescopedtoken", 
			"attributenamespace", "attributeargumentclause", "balancedtokenseq", 
			"balancedtoken", "initdeclaratorlist", "initdeclarator", "declarator", 
			"ptrdeclarator", "noptrdeclarator", "parametersandqualifiers", "trailingreturntype", 
			"ptroperator", "cvqualifierseq", "cvqualifier", "refqualifier", "declaratorid", 
			"thetypeid", "abstractdeclarator", "ptrabstractdeclarator", "noptrabstractdeclarator", 
			"abstractpackdeclarator", "noptrabstractpackdeclarator", "parameterdeclarationclause", 
			"parameterdeclarationlist", "parameterdeclaration", "functiondefinition", 
			"functionbody", "initializer", "braceorequalinitializer", "initializerclause", 
			"initializerlist", "bracedinitlist", "classname", "classspecifier", "classhead", 
			"classheadname", "classvirtspecifier", "classkey", "memberspecification", 
			"memberdeclaration", "memberdeclaratorlist", "memberdeclarator", "virtspecifierseq", 
			"virtspecifier", "purespecifier", "baseclause", "basespecifierlist", 
			"basespecifier", "classordecltype", "basetypespecifier", "accessspecifier", 
			"conversionfunctionid", "conversiontypeid", "conversiondeclarator", "ctorinitializer", 
			"meminitializerlist", "meminitializer", "meminitializerid", "operatorfunctionid", 
			"literaloperatorid", "templatedeclaration", "templateparameterlist", 
			"templateparameter", "typeparameter", "simpletemplateid", "templateid", 
			"templatename", "templateargumentlist", "templateargument", "typenamespecifier", 
			"explicitinstantiation", "explicitspecialization", "tryblock", "functiontryblock", 
			"handlerseq", "handler", "exceptiondeclaration", "throwexpression", "exceptionspecification", 
			"dynamicexceptionspecification", "typeidlist", "noexceptspecification", 
			"defineDeclaration", "includeDeclaration", "theoperator", "literal", 
			"booleanliteral", "pointerliteral", "userdefinedliteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'alignas'", "'alignof'", "'asm'", "'auto'", "'bool'", "'break'", 
			"'case'", "'catch'", "'char'", "'char16_t'", "'char32_t'", "'class'", 
			"'const'", "'constexpr'", "'const_cast'", "'continue'", "'decltype'", 
			"'default'", "'delete'", "'do'", "'double'", "'dynamic_cast'", "'else'", 
			"'enum'", "'explicit'", "'export'", "'extern'", "'false'", "'final'", 
			"'float'", "'for'", "'friend'", "'goto'", "'if'", "'inline'", "'int'", 
			"'long'", "'mutable'", "'namespace'", "'new'", "'noexcept'", "'nullptr'", 
			"'operator'", "'override'", "'private'", "'protected'", "'public'", "'register'", 
			"'reinterpret_cast'", "'return'", "'short'", "'signed'", "'sizeof'", 
			"'static'", "'static_assert'", "'static_cast'", "'struct'", "'switch'", 
			"'template'", "'this'", "'thread_local'", "'throw'", "'true'", "'try'", 
			"'typedef'", "'typeid'", "'typename'", "'union'", "'unsigned'", "'using'", 
			"'virtual'", "'void'", "'volatile'", "'wchar_t'", "'while'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", 
			"'&'", "'|'", "'~'", "'!'", "'='", "'<'", "'>'", "'+='", "'-='", "'*='", 
			"'/='", "'%='", "'^='", "'&='", "'|='", "'<<'", "'>>'", "'<<='", "'>>='", 
			"'=='", "'!='", "'<='", "'>='", "'&&'", "'||'", "'++'", "'--'", "','", 
			"'->*'", "'->'", "'?'", "':'", "'::'", "';'", "'.'", "'.*'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IncludeDirective", "ImportDirective", "DefineStart", "DefineDirective", 
			"ErrorDirective", "WarningDirective", "UndefDirective", "IfDirective", 
			"EndIfDirective", "ElseDirective", "LineDirective", "UsingDirective", 
			"Progrma", "Alignas", "Alignof", "Asm", "Auto", "Bool", "Break", "Case", 
			"Catch", "Char", "Char16", "Char32", "Class", "Const", "Constexpr", "Const_cast", 
			"Continue", "Decltype", "Default", "Delete", "Do", "Double", "Dynamic_cast", 
			"Else", "Enum", "Explicit", "Export", "Extern", "False", "Final", "Float", 
			"For", "Friend", "Goto", "If", "Inline", "Int", "Long", "Mutable", "Namespace", 
			"New", "Noexcept", "Nullptr", "Operator", "Override", "Private", "Protected", 
			"Public", "Register", "Reinterpret_cast", "Return", "Short", "Signed", 
			"Sizeof", "Static", "Static_assert", "Static_cast", "Struct", "Switch", 
			"Template", "This", "Thread_local", "Throw", "True", "Try", "Typedef", 
			"Typeid_", "Typename_", "Union", "Unsigned", "Using", "Virtual", "Void", 
			"Volatile", "Wchar", "While", "LeftParen", "RightParen", "LeftBracket", 
			"RightBracket", "LeftBrace", "RightBrace", "Plus", "Minus", "Star", "Div", 
			"Mod", "Caret", "And", "Or", "Tilde", "Not", "Assign", "Less", "Greater", 
			"PlusAssign", "MinusAssign", "StarAssign", "DivAssign", "ModAssign", 
			"XorAssign", "AndAssign", "OrAssign", "LeftShift", "RightShift", "LeftShiftAssign", 
			"RightShiftAssign", "Equal", "NotEqual", "LessEqual", "GreaterEqual", 
			"AndAnd", "OrOr", "PlusPlus", "MinusMinus", "Comma", "ArrowStar", "Arrow", 
			"Question", "Colon", "Doublecolon", "Semi", "Dot", "DotStar", "Ellipsis", 
			"Identifier", "Integerliteral", "Decimalliteral", "Octalliteral", "Hexadecimalliteral", 
			"Binaryliteral", "Integersuffix", "Characterliteral", "Floatingliteral", 
			"Stringliteral", "Userdefinedintegerliteral", "Userdefinedfloatingliteral", 
			"Userdefinedstringliteral", "Userdefinedcharacterliteral", "Whitespace", 
			"Newline", "BlockComment", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CPP14.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CPP14Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TranslationunitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CPP14Parser.EOF, 0); }
		public DeclarationseqContext declarationseq() {
			return getRuleContext(DeclarationseqContext.class,0);
		}
		public TranslationunitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationunit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTranslationunit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTranslationunit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTranslationunit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslationunitContext translationunit() throws RecognitionException {
		TranslationunitContext _localctx = new TranslationunitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translationunit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IncludeDirective) | (1L << DefineDirective) | (1L << Alignas) | (1L << Asm) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Decltype) | (1L << Double) | (1L << Enum) | (1L << Explicit) | (1L << Extern) | (1L << Float) | (1L << Friend) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << Namespace) | (1L << Operator) | (1L << Register))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Static - 64)) | (1L << (Static_assert - 64)) | (1L << (Struct - 64)) | (1L << (Template - 64)) | (1L << (Thread_local - 64)) | (1L << (Typedef - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Using - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Tilde - 64)) | (1L << (AndAnd - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Semi - 133)) | (1L << (Ellipsis - 133)) | (1L << (Identifier - 133)))) != 0)) {
				{
				setState(404);
				declarationseq(0);
				}
			}

			setState(407);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryexpressionContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode This() { return getToken(CPP14Parser.This, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public IdexpressionContext idexpression() {
			return getRuleContext(IdexpressionContext.class,0);
		}
		public LambdaexpressionContext lambdaexpression() {
			return getRuleContext(LambdaexpressionContext.class,0);
		}
		public PrimaryexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterPrimaryexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitPrimaryexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitPrimaryexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryexpressionContext primaryexpression() throws RecognitionException {
		PrimaryexpressionContext _localctx = new PrimaryexpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primaryexpression);
		try {
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case False:
			case Nullptr:
			case True:
			case Integerliteral:
			case Characterliteral:
			case Floatingliteral:
			case Stringliteral:
			case Userdefinedintegerliteral:
			case Userdefinedfloatingliteral:
			case Userdefinedstringliteral:
			case Userdefinedcharacterliteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(409);
				literal();
				}
				break;
			case This:
				enterOuterAlt(_localctx, 2);
				{
				setState(410);
				match(This);
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 3);
				{
				setState(411);
				match(LeftParen);
				setState(412);
				expression(0);
				setState(413);
				match(RightParen);
				}
				break;
			case Decltype:
			case Operator:
			case Tilde:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(415);
				idexpression();
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 5);
				{
				setState(416);
				lambdaexpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdexpressionContext extends ParserRuleContext {
		public UnqualifiedidContext unqualifiedid() {
			return getRuleContext(UnqualifiedidContext.class,0);
		}
		public QualifiedidContext qualifiedid() {
			return getRuleContext(QualifiedidContext.class,0);
		}
		public IdexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterIdexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitIdexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitIdexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdexpressionContext idexpression() throws RecognitionException {
		IdexpressionContext _localctx = new IdexpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_idexpression);
		try {
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				unqualifiedid();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				qualifiedid();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnqualifiedidContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public OperatorfunctionidContext operatorfunctionid() {
			return getRuleContext(OperatorfunctionidContext.class,0);
		}
		public ConversionfunctionidContext conversionfunctionid() {
			return getRuleContext(ConversionfunctionidContext.class,0);
		}
		public LiteraloperatoridContext literaloperatorid() {
			return getRuleContext(LiteraloperatoridContext.class,0);
		}
		public TerminalNode Tilde() { return getToken(CPP14Parser.Tilde, 0); }
		public ClassnameContext classname() {
			return getRuleContext(ClassnameContext.class,0);
		}
		public DecltypespecifierContext decltypespecifier() {
			return getRuleContext(DecltypespecifierContext.class,0);
		}
		public TemplateidContext templateid() {
			return getRuleContext(TemplateidContext.class,0);
		}
		public UnqualifiedidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unqualifiedid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterUnqualifiedid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitUnqualifiedid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitUnqualifiedid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnqualifiedidContext unqualifiedid() throws RecognitionException {
		UnqualifiedidContext _localctx = new UnqualifiedidContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_unqualifiedid);
		try {
			setState(432);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				operatorfunctionid();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				conversionfunctionid();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(426);
				literaloperatorid();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(427);
				match(Tilde);
				setState(428);
				classname();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(429);
				match(Tilde);
				setState(430);
				decltypespecifier();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(431);
				templateid();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedidContext extends ParserRuleContext {
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public UnqualifiedidContext unqualifiedid() {
			return getRuleContext(UnqualifiedidContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public QualifiedidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterQualifiedid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitQualifiedid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitQualifiedid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedidContext qualifiedid() throws RecognitionException {
		QualifiedidContext _localctx = new QualifiedidContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_qualifiedid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			nestednamespecifier(0);
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Template) {
				{
				setState(435);
				match(Template);
				}
			}

			setState(438);
			unqualifiedid();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NestednamespecifierContext extends ParserRuleContext {
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public ThetypenameContext thetypename() {
			return getRuleContext(ThetypenameContext.class,0);
		}
		public NamespacenameContext namespacename() {
			return getRuleContext(NamespacenameContext.class,0);
		}
		public DecltypespecifierContext decltypespecifier() {
			return getRuleContext(DecltypespecifierContext.class,0);
		}
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public SimpletemplateidContext simpletemplateid() {
			return getRuleContext(SimpletemplateidContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public NestednamespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestednamespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNestednamespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNestednamespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNestednamespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestednamespecifierContext nestednamespecifier() throws RecognitionException {
		return nestednamespecifier(0);
	}

	private NestednamespecifierContext nestednamespecifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NestednamespecifierContext _localctx = new NestednamespecifierContext(_ctx, _parentState);
		NestednamespecifierContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_nestednamespecifier, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(441);
				match(Doublecolon);
				}
				break;
			case 2:
				{
				setState(442);
				thetypename();
				setState(443);
				match(Doublecolon);
				}
				break;
			case 3:
				{
				setState(445);
				namespacename();
				setState(446);
				match(Doublecolon);
				}
				break;
			case 4:
				{
				setState(448);
				decltypespecifier();
				setState(449);
				match(Doublecolon);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(465);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(463);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new NestednamespecifierContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nestednamespecifier);
						setState(453);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(454);
						match(Identifier);
						setState(455);
						match(Doublecolon);
						}
						break;
					case 2:
						{
						_localctx = new NestednamespecifierContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nestednamespecifier);
						setState(456);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(458);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Template) {
							{
							setState(457);
							match(Template);
							}
						}

						setState(460);
						simpletemplateid();
						setState(461);
						match(Doublecolon);
						}
						break;
					}
					} 
				}
				setState(467);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LambdaexpressionContext extends ParserRuleContext {
		public LambdaintroducerContext lambdaintroducer() {
			return getRuleContext(LambdaintroducerContext.class,0);
		}
		public CompoundstatementContext compoundstatement() {
			return getRuleContext(CompoundstatementContext.class,0);
		}
		public LambdadeclaratorContext lambdadeclarator() {
			return getRuleContext(LambdadeclaratorContext.class,0);
		}
		public LambdaexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLambdaexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLambdaexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLambdaexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaexpressionContext lambdaexpression() throws RecognitionException {
		LambdaexpressionContext _localctx = new LambdaexpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lambdaexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			lambdaintroducer();
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(469);
				lambdadeclarator();
				}
			}

			setState(472);
			compoundstatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaintroducerContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public LambdacaptureContext lambdacapture() {
			return getRuleContext(LambdacaptureContext.class,0);
		}
		public LambdaintroducerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaintroducer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLambdaintroducer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLambdaintroducer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLambdaintroducer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaintroducerContext lambdaintroducer() throws RecognitionException {
		LambdaintroducerContext _localctx = new LambdaintroducerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lambdaintroducer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(LeftBracket);
			setState(476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (This - 73)) | (1L << (And - 73)) | (1L << (Assign - 73)))) != 0) || _la==Identifier) {
				{
				setState(475);
				lambdacapture();
				}
			}

			setState(478);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdacaptureContext extends ParserRuleContext {
		public CapturedefaultContext capturedefault() {
			return getRuleContext(CapturedefaultContext.class,0);
		}
		public CapturelistContext capturelist() {
			return getRuleContext(CapturelistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public LambdacaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdacapture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLambdacapture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLambdacapture(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLambdacapture(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdacaptureContext lambdacapture() throws RecognitionException {
		LambdacaptureContext _localctx = new LambdacaptureContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lambdacapture);
		try {
			setState(486);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(480);
				capturedefault();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(481);
				capturelist(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(482);
				capturedefault();
				setState(483);
				match(Comma);
				setState(484);
				capturelist(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CapturedefaultContext extends ParserRuleContext {
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public CapturedefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capturedefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterCapturedefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitCapturedefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitCapturedefault(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CapturedefaultContext capturedefault() throws RecognitionException {
		CapturedefaultContext _localctx = new CapturedefaultContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_capturedefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			_la = _input.LA(1);
			if ( !(_la==And || _la==Assign) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CapturelistContext extends ParserRuleContext {
		public CaptureContext capture() {
			return getRuleContext(CaptureContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public CapturelistContext capturelist() {
			return getRuleContext(CapturelistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public CapturelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capturelist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterCapturelist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitCapturelist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitCapturelist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CapturelistContext capturelist() throws RecognitionException {
		return capturelist(0);
	}

	private CapturelistContext capturelist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CapturelistContext _localctx = new CapturelistContext(_ctx, _parentState);
		CapturelistContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_capturelist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(491);
			capture();
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(492);
				match(Ellipsis);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(503);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CapturelistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_capturelist);
					setState(495);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(496);
					match(Comma);
					setState(497);
					capture();
					setState(499);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(498);
						match(Ellipsis);
						}
						break;
					}
					}
					} 
				}
				setState(505);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CaptureContext extends ParserRuleContext {
		public SimplecaptureContext simplecapture() {
			return getRuleContext(SimplecaptureContext.class,0);
		}
		public InitcaptureContext initcapture() {
			return getRuleContext(InitcaptureContext.class,0);
		}
		public CaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterCapture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitCapture(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitCapture(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaptureContext capture() throws RecognitionException {
		CaptureContext _localctx = new CaptureContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_capture);
		try {
			setState(508);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(506);
				simplecapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(507);
				initcapture();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimplecaptureContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode This() { return getToken(CPP14Parser.This, 0); }
		public SimplecaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simplecapture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterSimplecapture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitSimplecapture(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitSimplecapture(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimplecaptureContext simplecapture() throws RecognitionException {
		SimplecaptureContext _localctx = new SimplecaptureContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simplecapture);
		try {
			setState(514);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(510);
				match(Identifier);
				}
				break;
			case And:
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				match(And);
				setState(512);
				match(Identifier);
				}
				break;
			case This:
				enterOuterAlt(_localctx, 3);
				{
				setState(513);
				match(This);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitcaptureContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public InitcaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initcapture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterInitcapture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitInitcapture(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitInitcapture(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitcaptureContext initcapture() throws RecognitionException {
		InitcaptureContext _localctx = new InitcaptureContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_initcapture);
		try {
			setState(521);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				match(Identifier);
				setState(517);
				initializer();
				}
				break;
			case And:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
				match(And);
				setState(519);
				match(Identifier);
				setState(520);
				initializer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdadeclaratorContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ParameterdeclarationclauseContext parameterdeclarationclause() {
			return getRuleContext(ParameterdeclarationclauseContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Mutable() { return getToken(CPP14Parser.Mutable, 0); }
		public ExceptionspecificationContext exceptionspecification() {
			return getRuleContext(ExceptionspecificationContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TrailingreturntypeContext trailingreturntype() {
			return getRuleContext(TrailingreturntypeContext.class,0);
		}
		public LambdadeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdadeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLambdadeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLambdadeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLambdadeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdadeclaratorContext lambdadeclarator() throws RecognitionException {
		LambdadeclaratorContext _localctx = new LambdadeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lambdadeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			match(LeftParen);
			setState(524);
			parameterdeclarationclause();
			setState(525);
			match(RightParen);
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Mutable) {
				{
				setState(526);
				match(Mutable);
				}
			}

			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Noexcept || _la==Throw) {
				{
				setState(529);
				exceptionspecification();
				}
			}

			setState(533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(532);
				attributespecifierseq(0);
				}
			}

			setState(536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Arrow) {
				{
				setState(535);
				trailingreturntype();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixexpressionContext extends ParserRuleContext {
		public PrimaryexpressionContext primaryexpression() {
			return getRuleContext(PrimaryexpressionContext.class,0);
		}
		public SimpletypespecifierContext simpletypespecifier() {
			return getRuleContext(SimpletypespecifierContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public ExpressionlistContext expressionlist() {
			return getRuleContext(ExpressionlistContext.class,0);
		}
		public TypenamespecifierContext typenamespecifier() {
			return getRuleContext(TypenamespecifierContext.class,0);
		}
		public BracedinitlistContext bracedinitlist() {
			return getRuleContext(BracedinitlistContext.class,0);
		}
		public TerminalNode Dynamic_cast() { return getToken(CPP14Parser.Dynamic_cast, 0); }
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public ThetypeidContext thetypeid() {
			return getRuleContext(ThetypeidContext.class,0);
		}
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Static_cast() { return getToken(CPP14Parser.Static_cast, 0); }
		public TerminalNode Reinterpret_cast() { return getToken(CPP14Parser.Reinterpret_cast, 0); }
		public TerminalNode Const_cast() { return getToken(CPP14Parser.Const_cast, 0); }
		public TypeidofthetypeidContext typeidofthetypeid() {
			return getRuleContext(TypeidofthetypeidContext.class,0);
		}
		public PostfixexpressionContext postfixexpression() {
			return getRuleContext(PostfixexpressionContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public TerminalNode Dot() { return getToken(CPP14Parser.Dot, 0); }
		public IdexpressionContext idexpression() {
			return getRuleContext(IdexpressionContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode Arrow() { return getToken(CPP14Parser.Arrow, 0); }
		public PseudodestructornameContext pseudodestructorname() {
			return getRuleContext(PseudodestructornameContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(CPP14Parser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPP14Parser.MinusMinus, 0); }
		public PostfixexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterPostfixexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitPostfixexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitPostfixexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixexpressionContext postfixexpression() throws RecognitionException {
		return postfixexpression(0);
	}

	private PostfixexpressionContext postfixexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixexpressionContext _localctx = new PostfixexpressionContext(_ctx, _parentState);
		PostfixexpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_postfixexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(539);
				primaryexpression();
				}
				break;
			case 2:
				{
				setState(540);
				simpletypespecifier();
				setState(541);
				match(LeftParen);
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(542);
					expressionlist();
					}
				}

				setState(545);
				match(RightParen);
				}
				break;
			case 3:
				{
				setState(547);
				typenamespecifier();
				setState(548);
				match(LeftParen);
				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(549);
					expressionlist();
					}
				}

				setState(552);
				match(RightParen);
				}
				break;
			case 4:
				{
				setState(554);
				simpletypespecifier();
				setState(555);
				bracedinitlist();
				}
				break;
			case 5:
				{
				setState(557);
				typenamespecifier();
				setState(558);
				bracedinitlist();
				}
				break;
			case 6:
				{
				setState(560);
				match(Dynamic_cast);
				setState(561);
				match(Less);
				setState(562);
				thetypeid();
				setState(563);
				match(Greater);
				setState(564);
				match(LeftParen);
				setState(565);
				expression(0);
				setState(566);
				match(RightParen);
				}
				break;
			case 7:
				{
				setState(568);
				match(Static_cast);
				setState(569);
				match(Less);
				setState(570);
				thetypeid();
				setState(571);
				match(Greater);
				setState(572);
				match(LeftParen);
				setState(573);
				expression(0);
				setState(574);
				match(RightParen);
				}
				break;
			case 8:
				{
				setState(576);
				match(Reinterpret_cast);
				setState(577);
				match(Less);
				setState(578);
				thetypeid();
				setState(579);
				match(Greater);
				setState(580);
				match(LeftParen);
				setState(581);
				expression(0);
				setState(582);
				match(RightParen);
				}
				break;
			case 9:
				{
				setState(584);
				match(Const_cast);
				setState(585);
				match(Less);
				setState(586);
				thetypeid();
				setState(587);
				match(Greater);
				setState(588);
				match(LeftParen);
				setState(589);
				expression(0);
				setState(590);
				match(RightParen);
				}
				break;
			case 10:
				{
				setState(592);
				typeidofthetypeid();
				setState(593);
				match(LeftParen);
				setState(594);
				expression(0);
				setState(595);
				match(RightParen);
				}
				break;
			case 11:
				{
				setState(597);
				typeidofthetypeid();
				setState(598);
				match(LeftParen);
				setState(599);
				thetypeid();
				setState(600);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(644);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(642);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixexpression);
						setState(604);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(605);
						match(LeftBracket);
						setState(606);
						expression(0);
						setState(607);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new PostfixexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixexpression);
						setState(609);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(610);
						match(LeftBracket);
						setState(611);
						bracedinitlist();
						setState(612);
						match(RightBracket);
						}
						break;
					case 3:
						{
						_localctx = new PostfixexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixexpression);
						setState(614);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(615);
						match(LeftParen);
						setState(617);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
							{
							setState(616);
							expressionlist();
							}
						}

						setState(619);
						match(RightParen);
						}
						break;
					case 4:
						{
						_localctx = new PostfixexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixexpression);
						setState(620);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(621);
						match(Dot);
						setState(623);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Template) {
							{
							setState(622);
							match(Template);
							}
						}

						setState(625);
						idexpression();
						}
						break;
					case 5:
						{
						_localctx = new PostfixexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixexpression);
						setState(626);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(627);
						match(Arrow);
						setState(629);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Template) {
							{
							setState(628);
							match(Template);
							}
						}

						setState(631);
						idexpression();
						}
						break;
					case 6:
						{
						_localctx = new PostfixexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixexpression);
						setState(632);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(633);
						match(Dot);
						setState(634);
						pseudodestructorname();
						}
						break;
					case 7:
						{
						_localctx = new PostfixexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixexpression);
						setState(635);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(636);
						match(Arrow);
						setState(637);
						pseudodestructorname();
						}
						break;
					case 8:
						{
						_localctx = new PostfixexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixexpression);
						setState(638);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(639);
						match(PlusPlus);
						}
						break;
					case 9:
						{
						_localctx = new PostfixexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixexpression);
						setState(640);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(641);
						match(MinusMinus);
						}
						break;
					}
					} 
				}
				setState(646);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeidofexprContext extends ParserRuleContext {
		public TerminalNode Typeid_() { return getToken(CPP14Parser.Typeid_, 0); }
		public TypeidofexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeidofexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTypeidofexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTypeidofexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTypeidofexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeidofexprContext typeidofexpr() throws RecognitionException {
		TypeidofexprContext _localctx = new TypeidofexprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeidofexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			match(Typeid_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeidofthetypeidContext extends ParserRuleContext {
		public TerminalNode Typeid_() { return getToken(CPP14Parser.Typeid_, 0); }
		public TypeidofthetypeidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeidofthetypeid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTypeidofthetypeid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTypeidofthetypeid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTypeidofthetypeid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeidofthetypeidContext typeidofthetypeid() throws RecognitionException {
		TypeidofthetypeidContext _localctx = new TypeidofthetypeidContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeidofthetypeid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(Typeid_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionlistContext extends ParserRuleContext {
		public InitializerlistContext initializerlist() {
			return getRuleContext(InitializerlistContext.class,0);
		}
		public ExpressionlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterExpressionlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitExpressionlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitExpressionlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionlistContext expressionlist() throws RecognitionException {
		ExpressionlistContext _localctx = new ExpressionlistContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionlist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			initializerlist(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PseudodestructornameContext extends ParserRuleContext {
		public List<ThetypenameContext> thetypename() {
			return getRuleContexts(ThetypenameContext.class);
		}
		public ThetypenameContext thetypename(int i) {
			return getRuleContext(ThetypenameContext.class,i);
		}
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public TerminalNode Tilde() { return getToken(CPP14Parser.Tilde, 0); }
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public SimpletemplateidContext simpletemplateid() {
			return getRuleContext(SimpletemplateidContext.class,0);
		}
		public DecltypespecifierContext decltypespecifier() {
			return getRuleContext(DecltypespecifierContext.class,0);
		}
		public PseudodestructornameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pseudodestructorname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterPseudodestructorname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitPseudodestructorname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitPseudodestructorname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PseudodestructornameContext pseudodestructorname() throws RecognitionException {
		PseudodestructornameContext _localctx = new PseudodestructornameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pseudodestructorname);
		int _la;
		try {
			setState(675);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(654);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(653);
					nestednamespecifier(0);
					}
					break;
				}
				setState(656);
				thetypename();
				setState(657);
				match(Doublecolon);
				setState(658);
				match(Tilde);
				setState(659);
				thetypename();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(661);
				nestednamespecifier(0);
				setState(662);
				match(Template);
				setState(663);
				simpletemplateid();
				setState(664);
				match(Doublecolon);
				setState(665);
				match(Tilde);
				setState(666);
				thetypename();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(669);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(668);
					nestednamespecifier(0);
					}
				}

				setState(671);
				match(Tilde);
				setState(672);
				thetypename();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(673);
				match(Tilde);
				setState(674);
				decltypespecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryexpressionContext extends ParserRuleContext {
		public PostfixexpressionContext postfixexpression() {
			return getRuleContext(PostfixexpressionContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(CPP14Parser.PlusPlus, 0); }
		public CastexpressionContext castexpression() {
			return getRuleContext(CastexpressionContext.class,0);
		}
		public TerminalNode MinusMinus() { return getToken(CPP14Parser.MinusMinus, 0); }
		public UnaryoperatorContext unaryoperator() {
			return getRuleContext(UnaryoperatorContext.class,0);
		}
		public TerminalNode Sizeof() { return getToken(CPP14Parser.Sizeof, 0); }
		public UnaryexpressionContext unaryexpression() {
			return getRuleContext(UnaryexpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ThetypeidContext thetypeid() {
			return getRuleContext(ThetypeidContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Alignof() { return getToken(CPP14Parser.Alignof, 0); }
		public NoexceptexpressionContext noexceptexpression() {
			return getRuleContext(NoexceptexpressionContext.class,0);
		}
		public NewexpressionContext newexpression() {
			return getRuleContext(NewexpressionContext.class,0);
		}
		public DeleteexpressionContext deleteexpression() {
			return getRuleContext(DeleteexpressionContext.class,0);
		}
		public UnaryexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterUnaryexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitUnaryexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitUnaryexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryexpressionContext unaryexpression() throws RecognitionException {
		UnaryexpressionContext _localctx = new UnaryexpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unaryexpression);
		try {
			setState(705);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(677);
				postfixexpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(678);
				match(PlusPlus);
				setState(679);
				castexpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(680);
				match(MinusMinus);
				setState(681);
				castexpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(682);
				unaryoperator();
				setState(683);
				castexpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(685);
				match(Sizeof);
				setState(686);
				unaryexpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(687);
				match(Sizeof);
				setState(688);
				match(LeftParen);
				setState(689);
				thetypeid();
				setState(690);
				match(RightParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(692);
				match(Sizeof);
				setState(693);
				match(Ellipsis);
				setState(694);
				match(LeftParen);
				setState(695);
				match(Identifier);
				setState(696);
				match(RightParen);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(697);
				match(Alignof);
				setState(698);
				match(LeftParen);
				setState(699);
				thetypeid();
				setState(700);
				match(RightParen);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(702);
				noexceptexpression();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(703);
				newexpression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(704);
				deleteexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryoperatorContext extends ParserRuleContext {
		public TerminalNode Or() { return getToken(CPP14Parser.Or, 0); }
		public TerminalNode Star() { return getToken(CPP14Parser.Star, 0); }
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode Plus() { return getToken(CPP14Parser.Plus, 0); }
		public TerminalNode Not() { return getToken(CPP14Parser.Not, 0); }
		public TerminalNode Tilde() { return getToken(CPP14Parser.Tilde, 0); }
		public TerminalNode Minus() { return getToken(CPP14Parser.Minus, 0); }
		public UnaryoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryoperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterUnaryoperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitUnaryoperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitUnaryoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryoperatorContext unaryoperator() throws RecognitionException {
		UnaryoperatorContext _localctx = new UnaryoperatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_unaryoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			_la = _input.LA(1);
			if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (Plus - 95)) | (1L << (Minus - 95)) | (1L << (Star - 95)) | (1L << (And - 95)) | (1L << (Or - 95)) | (1L << (Tilde - 95)) | (1L << (Not - 95)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewexpressionContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(CPP14Parser.New, 0); }
		public NewtypeidContext newtypeid() {
			return getRuleContext(NewtypeidContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public NewplacementContext newplacement() {
			return getRuleContext(NewplacementContext.class,0);
		}
		public NewinitializerContext newinitializer() {
			return getRuleContext(NewinitializerContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ThetypeidContext thetypeid() {
			return getRuleContext(ThetypeidContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NewexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNewexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNewexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNewexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewexpressionContext newexpression() throws RecognitionException {
		NewexpressionContext _localctx = new NewexpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_newexpression);
		int _la;
		try {
			setState(733);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(710);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Doublecolon) {
					{
					setState(709);
					match(Doublecolon);
					}
				}

				setState(712);
				match(New);
				setState(714);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParen) {
					{
					setState(713);
					newplacement();
					}
				}

				setState(716);
				newtypeid();
				setState(718);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(717);
					newinitializer();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Doublecolon) {
					{
					setState(720);
					match(Doublecolon);
					}
				}

				setState(723);
				match(New);
				setState(725);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(724);
					newplacement();
					}
					break;
				}
				setState(727);
				match(LeftParen);
				setState(728);
				thetypeid();
				setState(729);
				match(RightParen);
				setState(731);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(730);
					newinitializer();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewplacementContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExpressionlistContext expressionlist() {
			return getRuleContext(ExpressionlistContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NewplacementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newplacement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNewplacement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNewplacement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNewplacement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewplacementContext newplacement() throws RecognitionException {
		NewplacementContext _localctx = new NewplacementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_newplacement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			match(LeftParen);
			setState(736);
			expressionlist();
			setState(737);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewtypeidContext extends ParserRuleContext {
		public TypespecifierseqContext typespecifierseq() {
			return getRuleContext(TypespecifierseqContext.class,0);
		}
		public NewdeclaratorContext newdeclarator() {
			return getRuleContext(NewdeclaratorContext.class,0);
		}
		public NewtypeidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newtypeid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNewtypeid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNewtypeid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNewtypeid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewtypeidContext newtypeid() throws RecognitionException {
		NewtypeidContext _localctx = new NewtypeidContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_newtypeid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			typespecifierseq();
			setState(741);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(740);
				newdeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewdeclaratorContext extends ParserRuleContext {
		public PtroperatorContext ptroperator() {
			return getRuleContext(PtroperatorContext.class,0);
		}
		public NewdeclaratorContext newdeclarator() {
			return getRuleContext(NewdeclaratorContext.class,0);
		}
		public NoptrnewdeclaratorContext noptrnewdeclarator() {
			return getRuleContext(NoptrnewdeclaratorContext.class,0);
		}
		public NewdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNewdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNewdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNewdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewdeclaratorContext newdeclarator() throws RecognitionException {
		NewdeclaratorContext _localctx = new NewdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_newdeclarator);
		try {
			setState(748);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Star:
			case And:
			case AndAnd:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(743);
				ptroperator();
				setState(745);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(744);
					newdeclarator();
					}
					break;
				}
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(747);
				noptrnewdeclarator(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoptrnewdeclaratorContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public NoptrnewdeclaratorContext noptrnewdeclarator() {
			return getRuleContext(NoptrnewdeclaratorContext.class,0);
		}
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public NoptrnewdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noptrnewdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNoptrnewdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNoptrnewdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNoptrnewdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoptrnewdeclaratorContext noptrnewdeclarator() throws RecognitionException {
		return noptrnewdeclarator(0);
	}

	private NoptrnewdeclaratorContext noptrnewdeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoptrnewdeclaratorContext _localctx = new NoptrnewdeclaratorContext(_ctx, _parentState);
		NoptrnewdeclaratorContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_noptrnewdeclarator, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(751);
			match(LeftBracket);
			setState(752);
			expression(0);
			setState(753);
			match(RightBracket);
			setState(755);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(754);
				attributespecifierseq(0);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(766);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoptrnewdeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noptrnewdeclarator);
					setState(757);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(758);
					match(LeftBracket);
					setState(759);
					constantexpression();
					setState(760);
					match(RightBracket);
					setState(762);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						setState(761);
						attributespecifierseq(0);
						}
						break;
					}
					}
					} 
				}
				setState(768);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NewinitializerContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public ExpressionlistContext expressionlist() {
			return getRuleContext(ExpressionlistContext.class,0);
		}
		public BracedinitlistContext bracedinitlist() {
			return getRuleContext(BracedinitlistContext.class,0);
		}
		public NewinitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newinitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNewinitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNewinitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNewinitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewinitializerContext newinitializer() throws RecognitionException {
		NewinitializerContext _localctx = new NewinitializerContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_newinitializer);
		int _la;
		try {
			setState(775);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(769);
				match(LeftParen);
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(770);
					expressionlist();
					}
				}

				setState(773);
				match(RightParen);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(774);
				bracedinitlist();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteexpressionContext extends ParserRuleContext {
		public TerminalNode Delete() { return getToken(CPP14Parser.Delete, 0); }
		public CastexpressionContext castexpression() {
			return getRuleContext(CastexpressionContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public DeleteexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDeleteexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDeleteexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDeleteexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteexpressionContext deleteexpression() throws RecognitionException {
		DeleteexpressionContext _localctx = new DeleteexpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_deleteexpression);
		int _la;
		try {
			setState(789);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Doublecolon) {
					{
					setState(777);
					match(Doublecolon);
					}
				}

				setState(780);
				match(Delete);
				setState(781);
				castexpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(783);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Doublecolon) {
					{
					setState(782);
					match(Doublecolon);
					}
				}

				setState(785);
				match(Delete);
				setState(786);
				match(LeftBracket);
				setState(787);
				match(RightBracket);
				setState(788);
				castexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoexceptexpressionContext extends ParserRuleContext {
		public TerminalNode Noexcept() { return getToken(CPP14Parser.Noexcept, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NoexceptexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noexceptexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNoexceptexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNoexceptexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNoexceptexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoexceptexpressionContext noexceptexpression() throws RecognitionException {
		NoexceptexpressionContext _localctx = new NoexceptexpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_noexceptexpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			match(Noexcept);
			setState(792);
			match(LeftParen);
			setState(793);
			expression(0);
			setState(794);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastexpressionContext extends ParserRuleContext {
		public UnaryexpressionContext unaryexpression() {
			return getRuleContext(UnaryexpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ThetypeidContext thetypeid() {
			return getRuleContext(ThetypeidContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public CastexpressionContext castexpression() {
			return getRuleContext(CastexpressionContext.class,0);
		}
		public CastexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterCastexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitCastexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitCastexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastexpressionContext castexpression() throws RecognitionException {
		CastexpressionContext _localctx = new CastexpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_castexpression);
		try {
			setState(802);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(796);
				unaryexpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(797);
				match(LeftParen);
				setState(798);
				thetypeid();
				setState(799);
				match(RightParen);
				setState(800);
				castexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PmexpressionContext extends ParserRuleContext {
		public CastexpressionContext castexpression() {
			return getRuleContext(CastexpressionContext.class,0);
		}
		public PmexpressionContext pmexpression() {
			return getRuleContext(PmexpressionContext.class,0);
		}
		public TerminalNode DotStar() { return getToken(CPP14Parser.DotStar, 0); }
		public TerminalNode ArrowStar() { return getToken(CPP14Parser.ArrowStar, 0); }
		public PmexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pmexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterPmexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitPmexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitPmexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PmexpressionContext pmexpression() throws RecognitionException {
		return pmexpression(0);
	}

	private PmexpressionContext pmexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PmexpressionContext _localctx = new PmexpressionContext(_ctx, _parentState);
		PmexpressionContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_pmexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(805);
			castexpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(815);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(813);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						_localctx = new PmexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pmexpression);
						setState(807);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(808);
						match(DotStar);
						setState(809);
						castexpression();
						}
						break;
					case 2:
						{
						_localctx = new PmexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pmexpression);
						setState(810);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(811);
						match(ArrowStar);
						setState(812);
						castexpression();
						}
						break;
					}
					} 
				}
				setState(817);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeexpressionContext extends ParserRuleContext {
		public PmexpressionContext pmexpression() {
			return getRuleContext(PmexpressionContext.class,0);
		}
		public MultiplicativeexpressionContext multiplicativeexpression() {
			return getRuleContext(MultiplicativeexpressionContext.class,0);
		}
		public TerminalNode Star() { return getToken(CPP14Parser.Star, 0); }
		public TerminalNode Div() { return getToken(CPP14Parser.Div, 0); }
		public TerminalNode Mod() { return getToken(CPP14Parser.Mod, 0); }
		public MultiplicativeexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterMultiplicativeexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitMultiplicativeexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitMultiplicativeexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeexpressionContext multiplicativeexpression() throws RecognitionException {
		return multiplicativeexpression(0);
	}

	private MultiplicativeexpressionContext multiplicativeexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeexpressionContext _localctx = new MultiplicativeexpressionContext(_ctx, _parentState);
		MultiplicativeexpressionContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_multiplicativeexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(819);
			pmexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(832);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(830);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeexpression);
						setState(821);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(822);
						match(Star);
						setState(823);
						pmexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeexpression);
						setState(824);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(825);
						match(Div);
						setState(826);
						pmexpression(0);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeexpression);
						setState(827);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(828);
						match(Mod);
						setState(829);
						pmexpression(0);
						}
						break;
					}
					} 
				}
				setState(834);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveexpressionContext extends ParserRuleContext {
		public MultiplicativeexpressionContext multiplicativeexpression() {
			return getRuleContext(MultiplicativeexpressionContext.class,0);
		}
		public AdditiveexpressionContext additiveexpression() {
			return getRuleContext(AdditiveexpressionContext.class,0);
		}
		public TerminalNode Plus() { return getToken(CPP14Parser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CPP14Parser.Minus, 0); }
		public AdditiveexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAdditiveexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAdditiveexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAdditiveexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveexpressionContext additiveexpression() throws RecognitionException {
		return additiveexpression(0);
	}

	private AdditiveexpressionContext additiveexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveexpressionContext _localctx = new AdditiveexpressionContext(_ctx, _parentState);
		AdditiveexpressionContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_additiveexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(836);
			multiplicativeexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(846);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(844);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveexpression);
						setState(838);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(839);
						match(Plus);
						setState(840);
						multiplicativeexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveexpression);
						setState(841);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(842);
						match(Minus);
						setState(843);
						multiplicativeexpression(0);
						}
						break;
					}
					} 
				}
				setState(848);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftexpressionContext extends ParserRuleContext {
		public AdditiveexpressionContext additiveexpression() {
			return getRuleContext(AdditiveexpressionContext.class,0);
		}
		public ShiftexpressionContext shiftexpression() {
			return getRuleContext(ShiftexpressionContext.class,0);
		}
		public ShiftoperatorContext shiftoperator() {
			return getRuleContext(ShiftoperatorContext.class,0);
		}
		public ShiftexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterShiftexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitShiftexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitShiftexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftexpressionContext shiftexpression() throws RecognitionException {
		return shiftexpression(0);
	}

	private ShiftexpressionContext shiftexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftexpressionContext _localctx = new ShiftexpressionContext(_ctx, _parentState);
		ShiftexpressionContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_shiftexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(850);
			additiveexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(858);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ShiftexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shiftexpression);
					setState(852);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(853);
					shiftoperator();
					setState(854);
					additiveexpression(0);
					}
					} 
				}
				setState(860);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftoperatorContext extends ParserRuleContext {
		public TerminalNode RightShift() { return getToken(CPP14Parser.RightShift, 0); }
		public TerminalNode LeftShift() { return getToken(CPP14Parser.LeftShift, 0); }
		public ShiftoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftoperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterShiftoperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitShiftoperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitShiftoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftoperatorContext shiftoperator() throws RecognitionException {
		ShiftoperatorContext _localctx = new ShiftoperatorContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_shiftoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(861);
			_la = _input.LA(1);
			if ( !(_la==LeftShift || _la==RightShift) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalexpressionContext extends ParserRuleContext {
		public ShiftexpressionContext shiftexpression() {
			return getRuleContext(ShiftexpressionContext.class,0);
		}
		public RelationalexpressionContext relationalexpression() {
			return getRuleContext(RelationalexpressionContext.class,0);
		}
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(CPP14Parser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(CPP14Parser.GreaterEqual, 0); }
		public RelationalexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterRelationalexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitRelationalexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitRelationalexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalexpressionContext relationalexpression() throws RecognitionException {
		return relationalexpression(0);
	}

	private RelationalexpressionContext relationalexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalexpressionContext _localctx = new RelationalexpressionContext(_ctx, _parentState);
		RelationalexpressionContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_relationalexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(864);
			shiftexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(880);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(878);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalexpression);
						setState(866);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(867);
						match(Less);
						setState(868);
						shiftexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new RelationalexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalexpression);
						setState(869);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(870);
						match(Greater);
						setState(871);
						shiftexpression(0);
						}
						break;
					case 3:
						{
						_localctx = new RelationalexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalexpression);
						setState(872);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(873);
						match(LessEqual);
						setState(874);
						shiftexpression(0);
						}
						break;
					case 4:
						{
						_localctx = new RelationalexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalexpression);
						setState(875);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(876);
						match(GreaterEqual);
						setState(877);
						shiftexpression(0);
						}
						break;
					}
					} 
				}
				setState(882);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityexpressionContext extends ParserRuleContext {
		public RelationalexpressionContext relationalexpression() {
			return getRuleContext(RelationalexpressionContext.class,0);
		}
		public EqualityexpressionContext equalityexpression() {
			return getRuleContext(EqualityexpressionContext.class,0);
		}
		public TerminalNode Equal() { return getToken(CPP14Parser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(CPP14Parser.NotEqual, 0); }
		public EqualityexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEqualityexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEqualityexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEqualityexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityexpressionContext equalityexpression() throws RecognitionException {
		return equalityexpression(0);
	}

	private EqualityexpressionContext equalityexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityexpressionContext _localctx = new EqualityexpressionContext(_ctx, _parentState);
		EqualityexpressionContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_equalityexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(884);
			relationalexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(894);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(892);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityexpression);
						setState(886);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(887);
						match(Equal);
						setState(888);
						relationalexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualityexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityexpression);
						setState(889);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(890);
						match(NotEqual);
						setState(891);
						relationalexpression(0);
						}
						break;
					}
					} 
				}
				setState(896);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndexpressionContext extends ParserRuleContext {
		public EqualityexpressionContext equalityexpression() {
			return getRuleContext(EqualityexpressionContext.class,0);
		}
		public AndexpressionContext andexpression() {
			return getRuleContext(AndexpressionContext.class,0);
		}
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public AndexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAndexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAndexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAndexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndexpressionContext andexpression() throws RecognitionException {
		return andexpression(0);
	}

	private AndexpressionContext andexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndexpressionContext _localctx = new AndexpressionContext(_ctx, _parentState);
		AndexpressionContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_andexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(898);
			equalityexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(905);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andexpression);
					setState(900);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(901);
					match(And);
					setState(902);
					equalityexpression(0);
					}
					} 
				}
				setState(907);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExclusiveorexpressionContext extends ParserRuleContext {
		public AndexpressionContext andexpression() {
			return getRuleContext(AndexpressionContext.class,0);
		}
		public ExclusiveorexpressionContext exclusiveorexpression() {
			return getRuleContext(ExclusiveorexpressionContext.class,0);
		}
		public TerminalNode Caret() { return getToken(CPP14Parser.Caret, 0); }
		public ExclusiveorexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveorexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterExclusiveorexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitExclusiveorexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitExclusiveorexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExclusiveorexpressionContext exclusiveorexpression() throws RecognitionException {
		return exclusiveorexpression(0);
	}

	private ExclusiveorexpressionContext exclusiveorexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExclusiveorexpressionContext _localctx = new ExclusiveorexpressionContext(_ctx, _parentState);
		ExclusiveorexpressionContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_exclusiveorexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(909);
			andexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(916);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExclusiveorexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exclusiveorexpression);
					setState(911);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(912);
					match(Caret);
					setState(913);
					andexpression(0);
					}
					} 
				}
				setState(918);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InclusiveorexpressionContext extends ParserRuleContext {
		public ExclusiveorexpressionContext exclusiveorexpression() {
			return getRuleContext(ExclusiveorexpressionContext.class,0);
		}
		public InclusiveorexpressionContext inclusiveorexpression() {
			return getRuleContext(InclusiveorexpressionContext.class,0);
		}
		public TerminalNode Or() { return getToken(CPP14Parser.Or, 0); }
		public InclusiveorexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveorexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterInclusiveorexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitInclusiveorexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitInclusiveorexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InclusiveorexpressionContext inclusiveorexpression() throws RecognitionException {
		return inclusiveorexpression(0);
	}

	private InclusiveorexpressionContext inclusiveorexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InclusiveorexpressionContext _localctx = new InclusiveorexpressionContext(_ctx, _parentState);
		InclusiveorexpressionContext _prevctx = _localctx;
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_inclusiveorexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(920);
			exclusiveorexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(927);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InclusiveorexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_inclusiveorexpression);
					setState(922);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(923);
					match(Or);
					setState(924);
					exclusiveorexpression(0);
					}
					} 
				}
				setState(929);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalandexpressionContext extends ParserRuleContext {
		public InclusiveorexpressionContext inclusiveorexpression() {
			return getRuleContext(InclusiveorexpressionContext.class,0);
		}
		public LogicalandexpressionContext logicalandexpression() {
			return getRuleContext(LogicalandexpressionContext.class,0);
		}
		public TerminalNode AndAnd() { return getToken(CPP14Parser.AndAnd, 0); }
		public LogicalandexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalandexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLogicalandexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLogicalandexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLogicalandexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalandexpressionContext logicalandexpression() throws RecognitionException {
		return logicalandexpression(0);
	}

	private LogicalandexpressionContext logicalandexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalandexpressionContext _localctx = new LogicalandexpressionContext(_ctx, _parentState);
		LogicalandexpressionContext _prevctx = _localctx;
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_logicalandexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(931);
			inclusiveorexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(938);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalandexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalandexpression);
					setState(933);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(934);
					match(AndAnd);
					setState(935);
					inclusiveorexpression(0);
					}
					} 
				}
				setState(940);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalorexpressionContext extends ParserRuleContext {
		public LogicalandexpressionContext logicalandexpression() {
			return getRuleContext(LogicalandexpressionContext.class,0);
		}
		public LogicalorexpressionContext logicalorexpression() {
			return getRuleContext(LogicalorexpressionContext.class,0);
		}
		public TerminalNode OrOr() { return getToken(CPP14Parser.OrOr, 0); }
		public LogicalorexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalorexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLogicalorexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLogicalorexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLogicalorexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalorexpressionContext logicalorexpression() throws RecognitionException {
		return logicalorexpression(0);
	}

	private LogicalorexpressionContext logicalorexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalorexpressionContext _localctx = new LogicalorexpressionContext(_ctx, _parentState);
		LogicalorexpressionContext _prevctx = _localctx;
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_logicalorexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(942);
			logicalandexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(949);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalorexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalorexpression);
					setState(944);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(945);
					match(OrOr);
					setState(946);
					logicalandexpression(0);
					}
					} 
				}
				setState(951);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionalexpressionContext extends ParserRuleContext {
		public LogicalorexpressionContext logicalorexpression() {
			return getRuleContext(LogicalorexpressionContext.class,0);
		}
		public TerminalNode Question() { return getToken(CPP14Parser.Question, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public AssignmentexpressionContext assignmentexpression() {
			return getRuleContext(AssignmentexpressionContext.class,0);
		}
		public ConditionalexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterConditionalexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitConditionalexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitConditionalexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalexpressionContext conditionalexpression() throws RecognitionException {
		ConditionalexpressionContext _localctx = new ConditionalexpressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_conditionalexpression);
		try {
			setState(959);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(952);
				logicalorexpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(953);
				logicalorexpression(0);
				setState(954);
				match(Question);
				setState(955);
				expression(0);
				setState(956);
				match(Colon);
				setState(957);
				assignmentexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentexpressionContext extends ParserRuleContext {
		public ConditionalexpressionContext conditionalexpression() {
			return getRuleContext(ConditionalexpressionContext.class,0);
		}
		public LogicalorexpressionContext logicalorexpression() {
			return getRuleContext(LogicalorexpressionContext.class,0);
		}
		public AssignmentoperatorContext assignmentoperator() {
			return getRuleContext(AssignmentoperatorContext.class,0);
		}
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public ThrowexpressionContext throwexpression() {
			return getRuleContext(ThrowexpressionContext.class,0);
		}
		public AssignmentexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAssignmentexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAssignmentexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAssignmentexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentexpressionContext assignmentexpression() throws RecognitionException {
		AssignmentexpressionContext _localctx = new AssignmentexpressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_assignmentexpression);
		try {
			setState(967);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(961);
				conditionalexpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(962);
				logicalorexpression(0);
				setState(963);
				assignmentoperator();
				setState(964);
				initializerclause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(966);
				throwexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentoperatorContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public TerminalNode StarAssign() { return getToken(CPP14Parser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(CPP14Parser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(CPP14Parser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(CPP14Parser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(CPP14Parser.MinusAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(CPP14Parser.RightShiftAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(CPP14Parser.LeftShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(CPP14Parser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(CPP14Parser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(CPP14Parser.OrAssign, 0); }
		public AssignmentoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentoperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAssignmentoperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAssignmentoperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAssignmentoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentoperatorContext assignmentoperator() throws RecognitionException {
		AssignmentoperatorContext _localctx = new AssignmentoperatorContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_assignmentoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
			_la = _input.LA(1);
			if ( !(((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Assign - 105)) | (1L << (PlusAssign - 105)) | (1L << (MinusAssign - 105)) | (1L << (StarAssign - 105)) | (1L << (DivAssign - 105)) | (1L << (ModAssign - 105)) | (1L << (XorAssign - 105)) | (1L << (AndAssign - 105)) | (1L << (OrAssign - 105)) | (1L << (LeftShiftAssign - 105)) | (1L << (RightShiftAssign - 105)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentexpressionContext assignmentexpression() {
			return getRuleContext(AssignmentexpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 92;
		enterRecursionRule(_localctx, 92, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(972);
			assignmentexpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(979);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(974);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(975);
					match(Comma);
					setState(976);
					assignmentexpression();
					}
					} 
				}
				setState(981);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstantexpressionContext extends ParserRuleContext {
		public ConditionalexpressionContext conditionalexpression() {
			return getRuleContext(ConditionalexpressionContext.class,0);
		}
		public ConstantexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterConstantexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitConstantexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitConstantexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantexpressionContext constantexpression() throws RecognitionException {
		ConstantexpressionContext _localctx = new ConstantexpressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_constantexpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(982);
			conditionalexpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LabeledstatementContext labeledstatement() {
			return getRuleContext(LabeledstatementContext.class,0);
		}
		public ExpressionstatementContext expressionstatement() {
			return getRuleContext(ExpressionstatementContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public CompoundstatementContext compoundstatement() {
			return getRuleContext(CompoundstatementContext.class,0);
		}
		public SelectionstatementContext selectionstatement() {
			return getRuleContext(SelectionstatementContext.class,0);
		}
		public IterationstatementContext iterationstatement() {
			return getRuleContext(IterationstatementContext.class,0);
		}
		public JumpstatementContext jumpstatement() {
			return getRuleContext(JumpstatementContext.class,0);
		}
		public DeclarationstatementContext declarationstatement() {
			return getRuleContext(DeclarationstatementContext.class,0);
		}
		public TryblockContext tryblock() {
			return getRuleContext(TryblockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_statement);
		int _la;
		try {
			setState(1010);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(984);
				labeledstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(986);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(985);
					attributespecifierseq(0);
					}
					break;
				}
				setState(988);
				expressionstatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(990);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(989);
					attributespecifierseq(0);
					}
				}

				setState(992);
				compoundstatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(994);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(993);
					attributespecifierseq(0);
					}
				}

				setState(996);
				selectionstatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(998);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(997);
					attributespecifierseq(0);
					}
				}

				setState(1000);
				iterationstatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1002);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1001);
					attributespecifierseq(0);
					}
				}

				setState(1004);
				jumpstatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1005);
				declarationstatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1007);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1006);
					attributespecifierseq(0);
					}
				}

				setState(1009);
				tryblock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledstatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TerminalNode Case() { return getToken(CPP14Parser.Case, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public TerminalNode Default() { return getToken(CPP14Parser.Default, 0); }
		public LabeledstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLabeledstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLabeledstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLabeledstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabeledstatementContext labeledstatement() throws RecognitionException {
		LabeledstatementContext _localctx = new LabeledstatementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_labeledstatement);
		int _la;
		try {
			setState(1032);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1013);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1012);
					attributespecifierseq(0);
					}
				}

				setState(1015);
				match(Identifier);
				setState(1016);
				match(Colon);
				setState(1017);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1019);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1018);
					attributespecifierseq(0);
					}
				}

				setState(1021);
				match(Case);
				setState(1022);
				constantexpression();
				setState(1023);
				match(Colon);
				setState(1024);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1027);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1026);
					attributespecifierseq(0);
					}
				}

				setState(1029);
				match(Default);
				setState(1030);
				match(Colon);
				setState(1031);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionstatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterExpressionstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitExpressionstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitExpressionstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionstatementContext expressionstatement() throws RecognitionException {
		ExpressionstatementContext _localctx = new ExpressionstatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_expressionstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1035);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
				{
				setState(1034);
				expression(0);
				}
			}

			setState(1037);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundstatementContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public StatementseqContext statementseq() {
			return getRuleContext(StatementseqContext.class,0);
		}
		public CompoundstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterCompoundstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitCompoundstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitCompoundstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundstatementContext compoundstatement() throws RecognitionException {
		CompoundstatementContext _localctx = new CompoundstatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_compoundstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1039);
			match(LeftBrace);
			setState(1041);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignas) | (1L << Alignof) | (1L << Asm) | (1L << Auto) | (1L << Bool) | (1L << Break) | (1L << Case) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Const_cast) | (1L << Continue) | (1L << Decltype) | (1L << Default) | (1L << Delete) | (1L << Do) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << Explicit) | (1L << Extern) | (1L << False) | (1L << Float) | (1L << For) | (1L << Friend) | (1L << Goto) | (1L << If) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << Namespace) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Register) | (1L << Reinterpret_cast) | (1L << Return))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static - 64)) | (1L << (Static_assert - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (Switch - 64)) | (1L << (This - 64)) | (1L << (Thread_local - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Try - 64)) | (1L << (Typedef - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Using - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (While - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (AndAnd - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Semi - 133)) | (1L << (Ellipsis - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
				{
				setState(1040);
				statementseq(0);
				}
			}

			setState(1043);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementseqContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementseqContext statementseq() {
			return getRuleContext(StatementseqContext.class,0);
		}
		public StatementseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterStatementseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitStatementseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitStatementseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementseqContext statementseq() throws RecognitionException {
		return statementseq(0);
	}

	private StatementseqContext statementseq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementseqContext _localctx = new StatementseqContext(_ctx, _parentState);
		StatementseqContext _prevctx = _localctx;
		int _startState = 104;
		enterRecursionRule(_localctx, 104, RULE_statementseq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1046);
			statement();
			}
			_ctx.stop = _input.LT(-1);
			setState(1052);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementseqContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_statementseq);
					setState(1048);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1049);
					statement();
					}
					} 
				}
				setState(1054);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SelectionstatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(CPP14Parser.If, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(CPP14Parser.Else, 0); }
		public TerminalNode Switch() { return getToken(CPP14Parser.Switch, 0); }
		public SelectionstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterSelectionstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitSelectionstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitSelectionstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionstatementContext selectionstatement() throws RecognitionException {
		SelectionstatementContext _localctx = new SelectionstatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_selectionstatement);
		try {
			setState(1075);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1055);
				match(If);
				setState(1056);
				match(LeftParen);
				setState(1057);
				condition();
				setState(1058);
				match(RightParen);
				setState(1059);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1061);
				match(If);
				setState(1062);
				match(LeftParen);
				setState(1063);
				condition();
				setState(1064);
				match(RightParen);
				setState(1065);
				statement();
				setState(1066);
				match(Else);
				setState(1067);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1069);
				match(Switch);
				setState(1070);
				match(LeftParen);
				setState(1071);
				condition();
				setState(1072);
				match(RightParen);
				setState(1073);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public BracedinitlistContext bracedinitlist() {
			return getRuleContext(BracedinitlistContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_condition);
		int _la;
		try {
			setState(1093);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1077);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1079);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1078);
					attributespecifierseq(0);
					}
				}

				setState(1081);
				declspecifierseq();
				setState(1082);
				declarator();
				setState(1083);
				match(Assign);
				setState(1084);
				initializerclause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1087);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1086);
					attributespecifierseq(0);
					}
				}

				setState(1089);
				declspecifierseq();
				setState(1090);
				declarator();
				setState(1091);
				bracedinitlist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationstatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(CPP14Parser.While, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(CPP14Parser.Do, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public TerminalNode For() { return getToken(CPP14Parser.For, 0); }
		public ForinitstatementContext forinitstatement() {
			return getRuleContext(ForinitstatementContext.class,0);
		}
		public ForrangedeclarationContext forrangedeclaration() {
			return getRuleContext(ForrangedeclarationContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public ForrangeinitializerContext forrangeinitializer() {
			return getRuleContext(ForrangeinitializerContext.class,0);
		}
		public IterationstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterIterationstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitIterationstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitIterationstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationstatementContext iterationstatement() throws RecognitionException {
		IterationstatementContext _localctx = new IterationstatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_iterationstatement);
		int _la;
		try {
			setState(1130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1095);
				match(While);
				setState(1096);
				match(LeftParen);
				setState(1097);
				condition();
				setState(1098);
				match(RightParen);
				setState(1099);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1101);
				match(Do);
				setState(1102);
				statement();
				setState(1103);
				match(While);
				setState(1104);
				match(LeftParen);
				setState(1105);
				expression(0);
				setState(1106);
				match(RightParen);
				setState(1107);
				match(Semi);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1109);
				match(For);
				setState(1110);
				match(LeftParen);
				setState(1111);
				forinitstatement();
				setState(1113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignas) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << Explicit) | (1L << Extern) | (1L << False) | (1L << Float) | (1L << Friend) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Register) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (This - 64)) | (1L << (Thread_local - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typedef - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(1112);
					condition();
					}
				}

				setState(1115);
				match(Semi);
				setState(1117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(1116);
					expression(0);
					}
				}

				setState(1119);
				match(RightParen);
				setState(1120);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1122);
				match(For);
				setState(1123);
				match(LeftParen);
				setState(1124);
				forrangedeclaration();
				setState(1125);
				match(Colon);
				setState(1126);
				forrangeinitializer();
				setState(1127);
				match(RightParen);
				setState(1128);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForinitstatementContext extends ParserRuleContext {
		public ExpressionstatementContext expressionstatement() {
			return getRuleContext(ExpressionstatementContext.class,0);
		}
		public SimpledeclarationContext simpledeclaration() {
			return getRuleContext(SimpledeclarationContext.class,0);
		}
		public ForinitstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forinitstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterForinitstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitForinitstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitForinitstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForinitstatementContext forinitstatement() throws RecognitionException {
		ForinitstatementContext _localctx = new ForinitstatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_forinitstatement);
		try {
			setState(1134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1132);
				expressionstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1133);
				simpledeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForrangedeclarationContext extends ParserRuleContext {
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public ForrangedeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forrangedeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterForrangedeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitForrangedeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitForrangedeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForrangedeclarationContext forrangedeclaration() throws RecognitionException {
		ForrangedeclarationContext _localctx = new ForrangedeclarationContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_forrangedeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1136);
				attributespecifierseq(0);
				}
			}

			setState(1139);
			declspecifierseq();
			setState(1140);
			declarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForrangeinitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracedinitlistContext bracedinitlist() {
			return getRuleContext(BracedinitlistContext.class,0);
		}
		public ForrangeinitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forrangeinitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterForrangeinitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitForrangeinitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitForrangeinitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForrangeinitializerContext forrangeinitializer() throws RecognitionException {
		ForrangeinitializerContext _localctx = new ForrangeinitializerContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_forrangeinitializer);
		try {
			setState(1144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Alignof:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Const_cast:
			case Decltype:
			case Delete:
			case Double:
			case Dynamic_cast:
			case False:
			case Float:
			case Int:
			case Long:
			case New:
			case Noexcept:
			case Nullptr:
			case Operator:
			case Reinterpret_cast:
			case Short:
			case Signed:
			case Sizeof:
			case Static_cast:
			case This:
			case Throw:
			case True:
			case Typeid_:
			case Typename_:
			case Unsigned:
			case Void:
			case Wchar:
			case LeftParen:
			case LeftBracket:
			case Plus:
			case Minus:
			case Star:
			case And:
			case Or:
			case Tilde:
			case Not:
			case PlusPlus:
			case MinusMinus:
			case Doublecolon:
			case Identifier:
			case Integerliteral:
			case Characterliteral:
			case Floatingliteral:
			case Stringliteral:
			case Userdefinedintegerliteral:
			case Userdefinedfloatingliteral:
			case Userdefinedstringliteral:
			case Userdefinedcharacterliteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(1142);
				expression(0);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1143);
				bracedinitlist();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpstatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(CPP14Parser.Break, 0); }
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public TerminalNode Continue() { return getToken(CPP14Parser.Continue, 0); }
		public TerminalNode Return() { return getToken(CPP14Parser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracedinitlistContext bracedinitlist() {
			return getRuleContext(BracedinitlistContext.class,0);
		}
		public TerminalNode Goto() { return getToken(CPP14Parser.Goto, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public JumpstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterJumpstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitJumpstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitJumpstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpstatementContext jumpstatement() throws RecognitionException {
		JumpstatementContext _localctx = new JumpstatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_jumpstatement);
		int _la;
		try {
			setState(1162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1146);
				match(Break);
				setState(1147);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1148);
				match(Continue);
				setState(1149);
				match(Semi);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1150);
				match(Return);
				setState(1152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(1151);
					expression(0);
					}
				}

				setState(1154);
				match(Semi);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1155);
				match(Return);
				setState(1156);
				bracedinitlist();
				setState(1157);
				match(Semi);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1159);
				match(Goto);
				setState(1160);
				match(Identifier);
				setState(1161);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationstatementContext extends ParserRuleContext {
		public BlockdeclarationContext blockdeclaration() {
			return getRuleContext(BlockdeclarationContext.class,0);
		}
		public DeclarationstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDeclarationstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDeclarationstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDeclarationstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationstatementContext declarationstatement() throws RecognitionException {
		DeclarationstatementContext _localctx = new DeclarationstatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_declarationstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1164);
			blockdeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationseqContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationseqContext declarationseq() {
			return getRuleContext(DeclarationseqContext.class,0);
		}
		public DeclarationseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDeclarationseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDeclarationseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDeclarationseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationseqContext declarationseq() throws RecognitionException {
		return declarationseq(0);
	}

	private DeclarationseqContext declarationseq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DeclarationseqContext _localctx = new DeclarationseqContext(_ctx, _parentState);
		DeclarationseqContext _prevctx = _localctx;
		int _startState = 122;
		enterRecursionRule(_localctx, 122, RULE_declarationseq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1167);
			declaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(1173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DeclarationseqContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_declarationseq);
					setState(1169);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1170);
					declaration();
					}
					} 
				}
				setState(1175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public BlockdeclarationContext blockdeclaration() {
			return getRuleContext(BlockdeclarationContext.class,0);
		}
		public FunctiondefinitionContext functiondefinition() {
			return getRuleContext(FunctiondefinitionContext.class,0);
		}
		public TemplatedeclarationContext templatedeclaration() {
			return getRuleContext(TemplatedeclarationContext.class,0);
		}
		public ExplicitinstantiationContext explicitinstantiation() {
			return getRuleContext(ExplicitinstantiationContext.class,0);
		}
		public ExplicitspecializationContext explicitspecialization() {
			return getRuleContext(ExplicitspecializationContext.class,0);
		}
		public LinkagespecificationContext linkagespecification() {
			return getRuleContext(LinkagespecificationContext.class,0);
		}
		public NamespacedefinitionContext namespacedefinition() {
			return getRuleContext(NamespacedefinitionContext.class,0);
		}
		public EmptydeclarationContext emptydeclaration() {
			return getRuleContext(EmptydeclarationContext.class,0);
		}
		public AttributedeclarationContext attributedeclaration() {
			return getRuleContext(AttributedeclarationContext.class,0);
		}
		public DefineDeclarationContext defineDeclaration() {
			return getRuleContext(DefineDeclarationContext.class,0);
		}
		public IncludeDeclarationContext includeDeclaration() {
			return getRuleContext(IncludeDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_declaration);
		try {
			setState(1187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1176);
				blockdeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1177);
				functiondefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1178);
				templatedeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1179);
				explicitinstantiation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1180);
				explicitspecialization();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1181);
				linkagespecification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1182);
				namespacedefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1183);
				emptydeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1184);
				attributedeclaration();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1185);
				defineDeclaration();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1186);
				includeDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockdeclarationContext extends ParserRuleContext {
		public SimpledeclarationContext simpledeclaration() {
			return getRuleContext(SimpledeclarationContext.class,0);
		}
		public AsmdefinitionContext asmdefinition() {
			return getRuleContext(AsmdefinitionContext.class,0);
		}
		public NamespacealiasdefinitionContext namespacealiasdefinition() {
			return getRuleContext(NamespacealiasdefinitionContext.class,0);
		}
		public UsingdeclarationContext usingdeclaration() {
			return getRuleContext(UsingdeclarationContext.class,0);
		}
		public UsingdirectiveContext usingdirective() {
			return getRuleContext(UsingdirectiveContext.class,0);
		}
		public Static_assertdeclarationContext static_assertdeclaration() {
			return getRuleContext(Static_assertdeclarationContext.class,0);
		}
		public AliasdeclarationContext aliasdeclaration() {
			return getRuleContext(AliasdeclarationContext.class,0);
		}
		public OpaqueenumdeclarationContext opaqueenumdeclaration() {
			return getRuleContext(OpaqueenumdeclarationContext.class,0);
		}
		public BlockdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBlockdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBlockdeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBlockdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockdeclarationContext blockdeclaration() throws RecognitionException {
		BlockdeclarationContext _localctx = new BlockdeclarationContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_blockdeclaration);
		try {
			setState(1197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1189);
				simpledeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1190);
				asmdefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1191);
				namespacealiasdefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1192);
				usingdeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1193);
				usingdirective();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1194);
				static_assertdeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1195);
				aliasdeclaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1196);
				opaqueenumdeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasdeclarationContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(CPP14Parser.Using, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public ThetypeidContext thetypeid() {
			return getRuleContext(ThetypeidContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public AliasdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAliasdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAliasdeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAliasdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasdeclarationContext aliasdeclaration() throws RecognitionException {
		AliasdeclarationContext _localctx = new AliasdeclarationContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_aliasdeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1199);
			match(Using);
			setState(1200);
			match(Identifier);
			setState(1202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1201);
				attributespecifierseq(0);
				}
			}

			setState(1204);
			match(Assign);
			setState(1205);
			thetypeid();
			setState(1206);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpledeclarationContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public InitdeclaratorlistContext initdeclaratorlist() {
			return getRuleContext(InitdeclaratorlistContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public SimpledeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpledeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterSimpledeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitSimpledeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitSimpledeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpledeclarationContext simpledeclaration() throws RecognitionException {
		SimpledeclarationContext _localctx = new SimpledeclarationContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_simpledeclaration);
		int _la;
		try {
			setState(1222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Constexpr:
			case Decltype:
			case Double:
			case Enum:
			case Explicit:
			case Extern:
			case Float:
			case Friend:
			case Inline:
			case Int:
			case Long:
			case Mutable:
			case Operator:
			case Register:
			case Short:
			case Signed:
			case Static:
			case Struct:
			case Thread_local:
			case Typedef:
			case Typename_:
			case Union:
			case Unsigned:
			case Virtual:
			case Void:
			case Volatile:
			case Wchar:
			case LeftParen:
			case Star:
			case And:
			case Tilde:
			case AndAnd:
			case Doublecolon:
			case Semi:
			case Ellipsis:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1209);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(1208);
					declspecifierseq();
					}
					break;
				}
				setState(1212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Operator || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (LeftParen - 89)) | (1L << (Star - 89)) | (1L << (And - 89)) | (1L << (Tilde - 89)) | (1L << (AndAnd - 89)) | (1L << (Doublecolon - 89)) | (1L << (Ellipsis - 89)) | (1L << (Identifier - 89)))) != 0)) {
					{
					setState(1211);
					initdeclaratorlist(0);
					}
				}

				setState(1214);
				match(Semi);
				}
				break;
			case Alignas:
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1215);
				attributespecifierseq(0);
				setState(1217);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
				case 1:
					{
					setState(1216);
					declspecifierseq();
					}
					break;
				}
				setState(1219);
				initdeclaratorlist(0);
				setState(1220);
				match(Semi);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Static_assertdeclarationContext extends ParserRuleContext {
		public TerminalNode Static_assert() { return getToken(CPP14Parser.Static_assert, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public TerminalNode Stringliteral() { return getToken(CPP14Parser.Stringliteral, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public Static_assertdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_assertdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterStatic_assertdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitStatic_assertdeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitStatic_assertdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Static_assertdeclarationContext static_assertdeclaration() throws RecognitionException {
		Static_assertdeclarationContext _localctx = new Static_assertdeclarationContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_static_assertdeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1224);
			match(Static_assert);
			setState(1225);
			match(LeftParen);
			setState(1226);
			constantexpression();
			setState(1227);
			match(Comma);
			setState(1228);
			match(Stringliteral);
			setState(1229);
			match(RightParen);
			setState(1230);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptydeclarationContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public EmptydeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptydeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEmptydeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEmptydeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEmptydeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptydeclarationContext emptydeclaration() throws RecognitionException {
		EmptydeclarationContext _localctx = new EmptydeclarationContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_emptydeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1232);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributedeclarationContext extends ParserRuleContext {
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributedeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributedeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAttributedeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAttributedeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAttributedeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributedeclarationContext attributedeclaration() throws RecognitionException {
		AttributedeclarationContext _localctx = new AttributedeclarationContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_attributedeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1234);
			attributespecifierseq(0);
			setState(1235);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclspecifierContext extends ParserRuleContext {
		public StorageclassspecifierContext storageclassspecifier() {
			return getRuleContext(StorageclassspecifierContext.class,0);
		}
		public TypespecifierContext typespecifier() {
			return getRuleContext(TypespecifierContext.class,0);
		}
		public FunctionspecifierContext functionspecifier() {
			return getRuleContext(FunctionspecifierContext.class,0);
		}
		public TerminalNode Friend() { return getToken(CPP14Parser.Friend, 0); }
		public TerminalNode Typedef() { return getToken(CPP14Parser.Typedef, 0); }
		public TerminalNode Constexpr() { return getToken(CPP14Parser.Constexpr, 0); }
		public DeclspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDeclspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDeclspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDeclspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclspecifierContext declspecifier() throws RecognitionException {
		DeclspecifierContext _localctx = new DeclspecifierContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_declspecifier);
		try {
			setState(1243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Extern:
			case Mutable:
			case Register:
			case Static:
			case Thread_local:
				enterOuterAlt(_localctx, 1);
				{
				setState(1237);
				storageclassspecifier();
				}
				break;
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Decltype:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Struct:
			case Typename_:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case Wchar:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1238);
				typespecifier();
				}
				break;
			case Explicit:
			case Inline:
			case Virtual:
				enterOuterAlt(_localctx, 3);
				{
				setState(1239);
				functionspecifier();
				}
				break;
			case Friend:
				enterOuterAlt(_localctx, 4);
				{
				setState(1240);
				match(Friend);
				}
				break;
			case Typedef:
				enterOuterAlt(_localctx, 5);
				{
				setState(1241);
				match(Typedef);
				}
				break;
			case Constexpr:
				enterOuterAlt(_localctx, 6);
				{
				setState(1242);
				match(Constexpr);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclspecifierseqContext extends ParserRuleContext {
		public DeclspecifierContext declspecifier() {
			return getRuleContext(DeclspecifierContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public DeclspecifierseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declspecifierseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDeclspecifierseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDeclspecifierseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDeclspecifierseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclspecifierseqContext declspecifierseq() throws RecognitionException {
		DeclspecifierseqContext _localctx = new DeclspecifierseqContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_declspecifierseq);
		try {
			setState(1252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1245);
				declspecifier();
				setState(1247);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
				case 1:
					{
					setState(1246);
					attributespecifierseq(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1249);
				declspecifier();
				setState(1250);
				declspecifierseq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageclassspecifierContext extends ParserRuleContext {
		public TerminalNode Register() { return getToken(CPP14Parser.Register, 0); }
		public TerminalNode Static() { return getToken(CPP14Parser.Static, 0); }
		public TerminalNode Thread_local() { return getToken(CPP14Parser.Thread_local, 0); }
		public TerminalNode Extern() { return getToken(CPP14Parser.Extern, 0); }
		public TerminalNode Mutable() { return getToken(CPP14Parser.Mutable, 0); }
		public StorageclassspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageclassspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterStorageclassspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitStorageclassspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitStorageclassspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StorageclassspecifierContext storageclassspecifier() throws RecognitionException {
		StorageclassspecifierContext _localctx = new StorageclassspecifierContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_storageclassspecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1254);
			_la = _input.LA(1);
			if ( !(((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (Extern - 40)) | (1L << (Mutable - 40)) | (1L << (Register - 40)) | (1L << (Static - 40)) | (1L << (Thread_local - 40)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionspecifierContext extends ParserRuleContext {
		public TerminalNode Inline() { return getToken(CPP14Parser.Inline, 0); }
		public TerminalNode Virtual() { return getToken(CPP14Parser.Virtual, 0); }
		public TerminalNode Explicit() { return getToken(CPP14Parser.Explicit, 0); }
		public FunctionspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterFunctionspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitFunctionspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitFunctionspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionspecifierContext functionspecifier() throws RecognitionException {
		FunctionspecifierContext _localctx = new FunctionspecifierContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_functionspecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1256);
			_la = _input.LA(1);
			if ( !(((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & ((1L << (Explicit - 38)) | (1L << (Inline - 38)) | (1L << (Virtual - 38)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedefnameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TypedefnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedefname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTypedefname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTypedefname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTypedefname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedefnameContext typedefname() throws RecognitionException {
		TypedefnameContext _localctx = new TypedefnameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_typedefname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1258);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypespecifierContext extends ParserRuleContext {
		public TrailingtypespecifierContext trailingtypespecifier() {
			return getRuleContext(TrailingtypespecifierContext.class,0);
		}
		public ClassspecifierContext classspecifier() {
			return getRuleContext(ClassspecifierContext.class,0);
		}
		public EnumspecifierContext enumspecifier() {
			return getRuleContext(EnumspecifierContext.class,0);
		}
		public TypespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTypespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTypespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTypespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypespecifierContext typespecifier() throws RecognitionException {
		TypespecifierContext _localctx = new TypespecifierContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_typespecifier);
		try {
			setState(1263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1260);
				trailingtypespecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1261);
				classspecifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1262);
				enumspecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrailingtypespecifierContext extends ParserRuleContext {
		public SimpletypespecifierContext simpletypespecifier() {
			return getRuleContext(SimpletypespecifierContext.class,0);
		}
		public ElaboratedtypespecifierContext elaboratedtypespecifier() {
			return getRuleContext(ElaboratedtypespecifierContext.class,0);
		}
		public TypenamespecifierContext typenamespecifier() {
			return getRuleContext(TypenamespecifierContext.class,0);
		}
		public CvqualifierContext cvqualifier() {
			return getRuleContext(CvqualifierContext.class,0);
		}
		public TrailingtypespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingtypespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTrailingtypespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTrailingtypespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTrailingtypespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrailingtypespecifierContext trailingtypespecifier() throws RecognitionException {
		TrailingtypespecifierContext _localctx = new TrailingtypespecifierContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_trailingtypespecifier);
		try {
			setState(1269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Decltype:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Wchar:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1265);
				simpletypespecifier();
				}
				break;
			case Class:
			case Enum:
			case Struct:
			case Union:
				enterOuterAlt(_localctx, 2);
				{
				setState(1266);
				elaboratedtypespecifier();
				}
				break;
			case Typename_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1267);
				typenamespecifier();
				}
				break;
			case Const:
			case Volatile:
				enterOuterAlt(_localctx, 4);
				{
				setState(1268);
				cvqualifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypespecifierseqContext extends ParserRuleContext {
		public TypespecifierContext typespecifier() {
			return getRuleContext(TypespecifierContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TypespecifierseqContext typespecifierseq() {
			return getRuleContext(TypespecifierseqContext.class,0);
		}
		public TypespecifierseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typespecifierseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTypespecifierseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTypespecifierseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTypespecifierseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypespecifierseqContext typespecifierseq() throws RecognitionException {
		TypespecifierseqContext _localctx = new TypespecifierseqContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_typespecifierseq);
		try {
			setState(1278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1271);
				typespecifier();
				setState(1273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(1272);
					attributespecifierseq(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1275);
				typespecifier();
				setState(1276);
				typespecifierseq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrailingtypespecifierseqContext extends ParserRuleContext {
		public TrailingtypespecifierContext trailingtypespecifier() {
			return getRuleContext(TrailingtypespecifierContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TrailingtypespecifierseqContext trailingtypespecifierseq() {
			return getRuleContext(TrailingtypespecifierseqContext.class,0);
		}
		public TrailingtypespecifierseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingtypespecifierseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTrailingtypespecifierseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTrailingtypespecifierseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTrailingtypespecifierseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrailingtypespecifierseqContext trailingtypespecifierseq() throws RecognitionException {
		TrailingtypespecifierseqContext _localctx = new TrailingtypespecifierseqContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_trailingtypespecifierseq);
		try {
			setState(1287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1280);
				trailingtypespecifier();
				setState(1282);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
				case 1:
					{
					setState(1281);
					attributespecifierseq(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1284);
				trailingtypespecifier();
				setState(1285);
				trailingtypespecifierseq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpletypespecifierContext extends ParserRuleContext {
		public ThetypenameContext thetypename() {
			return getRuleContext(ThetypenameContext.class,0);
		}
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public SimpletemplateidContext simpletemplateid() {
			return getRuleContext(SimpletemplateidContext.class,0);
		}
		public TerminalNode Char() { return getToken(CPP14Parser.Char, 0); }
		public TerminalNode Char16() { return getToken(CPP14Parser.Char16, 0); }
		public TerminalNode Char32() { return getToken(CPP14Parser.Char32, 0); }
		public TerminalNode Wchar() { return getToken(CPP14Parser.Wchar, 0); }
		public TerminalNode Bool() { return getToken(CPP14Parser.Bool, 0); }
		public TerminalNode Short() { return getToken(CPP14Parser.Short, 0); }
		public TerminalNode Int() { return getToken(CPP14Parser.Int, 0); }
		public TerminalNode Long() { return getToken(CPP14Parser.Long, 0); }
		public TerminalNode Signed() { return getToken(CPP14Parser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(CPP14Parser.Unsigned, 0); }
		public TerminalNode Float() { return getToken(CPP14Parser.Float, 0); }
		public TerminalNode Double() { return getToken(CPP14Parser.Double, 0); }
		public TerminalNode Void() { return getToken(CPP14Parser.Void, 0); }
		public TerminalNode Auto() { return getToken(CPP14Parser.Auto, 0); }
		public DecltypespecifierContext decltypespecifier() {
			return getRuleContext(DecltypespecifierContext.class,0);
		}
		public SimpletypespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpletypespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterSimpletypespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitSimpletypespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitSimpletypespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpletypespecifierContext simpletypespecifier() throws RecognitionException {
		SimpletypespecifierContext _localctx = new SimpletypespecifierContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_simpletypespecifier);
		try {
			setState(1312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1290);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
				case 1:
					{
					setState(1289);
					nestednamespecifier(0);
					}
					break;
				}
				setState(1292);
				thetypename();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1293);
				nestednamespecifier(0);
				setState(1294);
				match(Template);
				setState(1295);
				simpletemplateid();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1297);
				match(Char);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1298);
				match(Char16);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1299);
				match(Char32);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1300);
				match(Wchar);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1301);
				match(Bool);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1302);
				match(Short);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1303);
				match(Int);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1304);
				match(Long);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1305);
				match(Signed);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1306);
				match(Unsigned);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1307);
				match(Float);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1308);
				match(Double);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1309);
				match(Void);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1310);
				match(Auto);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1311);
				decltypespecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThetypenameContext extends ParserRuleContext {
		public ClassnameContext classname() {
			return getRuleContext(ClassnameContext.class,0);
		}
		public EnumnameContext enumname() {
			return getRuleContext(EnumnameContext.class,0);
		}
		public TypedefnameContext typedefname() {
			return getRuleContext(TypedefnameContext.class,0);
		}
		public SimpletemplateidContext simpletemplateid() {
			return getRuleContext(SimpletemplateidContext.class,0);
		}
		public ThetypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thetypename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterThetypename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitThetypename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitThetypename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThetypenameContext thetypename() throws RecognitionException {
		ThetypenameContext _localctx = new ThetypenameContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_thetypename);
		try {
			setState(1318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1314);
				classname();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1315);
				enumname();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1316);
				typedefname();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1317);
				simpletemplateid();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecltypespecifierContext extends ParserRuleContext {
		public TerminalNode Decltype() { return getToken(CPP14Parser.Decltype, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Auto() { return getToken(CPP14Parser.Auto, 0); }
		public DecltypespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decltypespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDecltypespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDecltypespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDecltypespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecltypespecifierContext decltypespecifier() throws RecognitionException {
		DecltypespecifierContext _localctx = new DecltypespecifierContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_decltypespecifier);
		try {
			setState(1329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1320);
				match(Decltype);
				setState(1321);
				match(LeftParen);
				setState(1322);
				expression(0);
				setState(1323);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1325);
				match(Decltype);
				setState(1326);
				match(LeftParen);
				setState(1327);
				match(Auto);
				setState(1328);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElaboratedtypespecifierContext extends ParserRuleContext {
		public ClasskeyContext classkey() {
			return getRuleContext(ClasskeyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public SimpletemplateidContext simpletemplateid() {
			return getRuleContext(SimpletemplateidContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode Enum() { return getToken(CPP14Parser.Enum, 0); }
		public ElaboratedtypespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elaboratedtypespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterElaboratedtypespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitElaboratedtypespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitElaboratedtypespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElaboratedtypespecifierContext elaboratedtypespecifier() throws RecognitionException {
		ElaboratedtypespecifierContext _localctx = new ElaboratedtypespecifierContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_elaboratedtypespecifier);
		int _la;
		try {
			setState(1355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1331);
				classkey();
				setState(1333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1332);
					attributespecifierseq(0);
					}
				}

				setState(1336);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
				case 1:
					{
					setState(1335);
					nestednamespecifier(0);
					}
					break;
				}
				setState(1338);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1340);
				classkey();
				setState(1341);
				simpletemplateid();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1343);
				classkey();
				setState(1344);
				nestednamespecifier(0);
				setState(1346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Template) {
					{
					setState(1345);
					match(Template);
					}
				}

				setState(1348);
				simpletemplateid();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1350);
				match(Enum);
				setState(1352);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
				case 1:
					{
					setState(1351);
					nestednamespecifier(0);
					}
					break;
				}
				setState(1354);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumnameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public EnumnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEnumname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEnumname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEnumname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumnameContext enumname() throws RecognitionException {
		EnumnameContext _localctx = new EnumnameContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_enumname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1357);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumspecifierContext extends ParserRuleContext {
		public EnumheadContext enumhead() {
			return getRuleContext(EnumheadContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public EnumeratorlistContext enumeratorlist() {
			return getRuleContext(EnumeratorlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public EnumspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEnumspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEnumspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEnumspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumspecifierContext enumspecifier() throws RecognitionException {
		EnumspecifierContext _localctx = new EnumspecifierContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_enumspecifier);
		int _la;
		try {
			setState(1372);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1359);
				enumhead();
				setState(1360);
				match(LeftBrace);
				setState(1362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1361);
					enumeratorlist(0);
					}
				}

				setState(1364);
				match(RightBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1366);
				enumhead();
				setState(1367);
				match(LeftBrace);
				setState(1368);
				enumeratorlist(0);
				setState(1369);
				match(Comma);
				setState(1370);
				match(RightBrace);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumheadContext extends ParserRuleContext {
		public EnumkeyContext enumkey() {
			return getRuleContext(EnumkeyContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public EnumbaseContext enumbase() {
			return getRuleContext(EnumbaseContext.class,0);
		}
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public EnumheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumhead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEnumhead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEnumhead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEnumhead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumheadContext enumhead() throws RecognitionException {
		EnumheadContext _localctx = new EnumheadContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_enumhead);
		int _la;
		try {
			setState(1393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1374);
				enumkey();
				setState(1376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1375);
					attributespecifierseq(0);
					}
				}

				setState(1379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1378);
					match(Identifier);
					}
				}

				setState(1382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1381);
					enumbase();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1384);
				enumkey();
				setState(1386);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1385);
					attributespecifierseq(0);
					}
				}

				setState(1388);
				nestednamespecifier(0);
				setState(1389);
				match(Identifier);
				setState(1391);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1390);
					enumbase();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpaqueenumdeclarationContext extends ParserRuleContext {
		public EnumkeyContext enumkey() {
			return getRuleContext(EnumkeyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public EnumbaseContext enumbase() {
			return getRuleContext(EnumbaseContext.class,0);
		}
		public OpaqueenumdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opaqueenumdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterOpaqueenumdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitOpaqueenumdeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitOpaqueenumdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpaqueenumdeclarationContext opaqueenumdeclaration() throws RecognitionException {
		OpaqueenumdeclarationContext _localctx = new OpaqueenumdeclarationContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_opaqueenumdeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1395);
			enumkey();
			setState(1397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1396);
				attributespecifierseq(0);
				}
			}

			setState(1399);
			match(Identifier);
			setState(1401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1400);
				enumbase();
				}
			}

			setState(1403);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumkeyContext extends ParserRuleContext {
		public TerminalNode Enum() { return getToken(CPP14Parser.Enum, 0); }
		public TerminalNode Class() { return getToken(CPP14Parser.Class, 0); }
		public TerminalNode Struct() { return getToken(CPP14Parser.Struct, 0); }
		public EnumkeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumkey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEnumkey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEnumkey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEnumkey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumkeyContext enumkey() throws RecognitionException {
		EnumkeyContext _localctx = new EnumkeyContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_enumkey);
		try {
			setState(1410);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1405);
				match(Enum);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1406);
				match(Enum);
				setState(1407);
				match(Class);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1408);
				match(Enum);
				setState(1409);
				match(Struct);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumbaseContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public TypespecifierseqContext typespecifierseq() {
			return getRuleContext(TypespecifierseqContext.class,0);
		}
		public EnumbaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumbase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEnumbase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEnumbase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEnumbase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumbaseContext enumbase() throws RecognitionException {
		EnumbaseContext _localctx = new EnumbaseContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_enumbase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1412);
			match(Colon);
			setState(1413);
			typespecifierseq();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorlistContext extends ParserRuleContext {
		public EnumeratordefinitionContext enumeratordefinition() {
			return getRuleContext(EnumeratordefinitionContext.class,0);
		}
		public EnumeratorlistContext enumeratorlist() {
			return getRuleContext(EnumeratorlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public EnumeratorlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEnumeratorlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEnumeratorlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEnumeratorlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumeratorlistContext enumeratorlist() throws RecognitionException {
		return enumeratorlist(0);
	}

	private EnumeratorlistContext enumeratorlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EnumeratorlistContext _localctx = new EnumeratorlistContext(_ctx, _parentState);
		EnumeratorlistContext _prevctx = _localctx;
		int _startState = 176;
		enterRecursionRule(_localctx, 176, RULE_enumeratorlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1416);
			enumeratordefinition();
			}
			_ctx.stop = _input.LT(-1);
			setState(1423);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EnumeratorlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_enumeratorlist);
					setState(1418);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1419);
					match(Comma);
					setState(1420);
					enumeratordefinition();
					}
					} 
				}
				setState(1425);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EnumeratordefinitionContext extends ParserRuleContext {
		public EnumeratorContext enumerator() {
			return getRuleContext(EnumeratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public EnumeratordefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratordefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEnumeratordefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEnumeratordefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEnumeratordefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumeratordefinitionContext enumeratordefinition() throws RecognitionException {
		EnumeratordefinitionContext _localctx = new EnumeratordefinitionContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_enumeratordefinition);
		try {
			setState(1431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1426);
				enumerator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1427);
				enumerator();
				setState(1428);
				match(Assign);
				setState(1429);
				constantexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterEnumerator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitEnumerator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitEnumerator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_enumerator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1433);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacenameContext extends ParserRuleContext {
		public OriginalnamespacenameContext originalnamespacename() {
			return getRuleContext(OriginalnamespacenameContext.class,0);
		}
		public NamespacealiasContext namespacealias() {
			return getRuleContext(NamespacealiasContext.class,0);
		}
		public NamespacenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNamespacename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNamespacename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNamespacename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespacenameContext namespacename() throws RecognitionException {
		NamespacenameContext _localctx = new NamespacenameContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_namespacename);
		try {
			setState(1437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1435);
				originalnamespacename();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1436);
				namespacealias();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OriginalnamespacenameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public OriginalnamespacenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_originalnamespacename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterOriginalnamespacename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitOriginalnamespacename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitOriginalnamespacename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OriginalnamespacenameContext originalnamespacename() throws RecognitionException {
		OriginalnamespacenameContext _localctx = new OriginalnamespacenameContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_originalnamespacename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1439);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacedefinitionContext extends ParserRuleContext {
		public NamednamespacedefinitionContext namednamespacedefinition() {
			return getRuleContext(NamednamespacedefinitionContext.class,0);
		}
		public UnnamednamespacedefinitionContext unnamednamespacedefinition() {
			return getRuleContext(UnnamednamespacedefinitionContext.class,0);
		}
		public NamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacedefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNamespacedefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNamespacedefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNamespacedefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespacedefinitionContext namespacedefinition() throws RecognitionException {
		NamespacedefinitionContext _localctx = new NamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_namespacedefinition);
		try {
			setState(1443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1441);
				namednamespacedefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1442);
				unnamednamespacedefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamednamespacedefinitionContext extends ParserRuleContext {
		public OriginalnamespacedefinitionContext originalnamespacedefinition() {
			return getRuleContext(OriginalnamespacedefinitionContext.class,0);
		}
		public ExtensionnamespacedefinitionContext extensionnamespacedefinition() {
			return getRuleContext(ExtensionnamespacedefinitionContext.class,0);
		}
		public NamednamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namednamespacedefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNamednamespacedefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNamednamespacedefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNamednamespacedefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamednamespacedefinitionContext namednamespacedefinition() throws RecognitionException {
		NamednamespacedefinitionContext _localctx = new NamednamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_namednamespacedefinition);
		try {
			setState(1447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1445);
				originalnamespacedefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1446);
				extensionnamespacedefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OriginalnamespacedefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(CPP14Parser.Namespace, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public NamespacebodyContext namespacebody() {
			return getRuleContext(NamespacebodyContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public TerminalNode Inline() { return getToken(CPP14Parser.Inline, 0); }
		public OriginalnamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_originalnamespacedefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterOriginalnamespacedefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitOriginalnamespacedefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitOriginalnamespacedefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OriginalnamespacedefinitionContext originalnamespacedefinition() throws RecognitionException {
		OriginalnamespacedefinitionContext _localctx = new OriginalnamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_originalnamespacedefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Inline) {
				{
				setState(1449);
				match(Inline);
				}
			}

			setState(1452);
			match(Namespace);
			setState(1453);
			match(Identifier);
			setState(1454);
			match(LeftBrace);
			setState(1455);
			namespacebody();
			setState(1456);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtensionnamespacedefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(CPP14Parser.Namespace, 0); }
		public OriginalnamespacenameContext originalnamespacename() {
			return getRuleContext(OriginalnamespacenameContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public NamespacebodyContext namespacebody() {
			return getRuleContext(NamespacebodyContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public TerminalNode Inline() { return getToken(CPP14Parser.Inline, 0); }
		public ExtensionnamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extensionnamespacedefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterExtensionnamespacedefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitExtensionnamespacedefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitExtensionnamespacedefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtensionnamespacedefinitionContext extensionnamespacedefinition() throws RecognitionException {
		ExtensionnamespacedefinitionContext _localctx = new ExtensionnamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_extensionnamespacedefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Inline) {
				{
				setState(1458);
				match(Inline);
				}
			}

			setState(1461);
			match(Namespace);
			setState(1462);
			originalnamespacename();
			setState(1463);
			match(LeftBrace);
			setState(1464);
			namespacebody();
			setState(1465);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnnamednamespacedefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(CPP14Parser.Namespace, 0); }
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public NamespacebodyContext namespacebody() {
			return getRuleContext(NamespacebodyContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public TerminalNode Inline() { return getToken(CPP14Parser.Inline, 0); }
		public UnnamednamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unnamednamespacedefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterUnnamednamespacedefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitUnnamednamespacedefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitUnnamednamespacedefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnnamednamespacedefinitionContext unnamednamespacedefinition() throws RecognitionException {
		UnnamednamespacedefinitionContext _localctx = new UnnamednamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_unnamednamespacedefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Inline) {
				{
				setState(1467);
				match(Inline);
				}
			}

			setState(1470);
			match(Namespace);
			setState(1471);
			match(LeftBrace);
			setState(1472);
			namespacebody();
			setState(1473);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacebodyContext extends ParserRuleContext {
		public DeclarationseqContext declarationseq() {
			return getRuleContext(DeclarationseqContext.class,0);
		}
		public NamespacebodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacebody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNamespacebody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNamespacebody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNamespacebody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespacebodyContext namespacebody() throws RecognitionException {
		NamespacebodyContext _localctx = new NamespacebodyContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_namespacebody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IncludeDirective) | (1L << DefineDirective) | (1L << Alignas) | (1L << Asm) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Decltype) | (1L << Double) | (1L << Enum) | (1L << Explicit) | (1L << Extern) | (1L << Float) | (1L << Friend) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << Namespace) | (1L << Operator) | (1L << Register))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Static - 64)) | (1L << (Static_assert - 64)) | (1L << (Struct - 64)) | (1L << (Template - 64)) | (1L << (Thread_local - 64)) | (1L << (Typedef - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Using - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Tilde - 64)) | (1L << (AndAnd - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Semi - 133)) | (1L << (Ellipsis - 133)) | (1L << (Identifier - 133)))) != 0)) {
				{
				setState(1475);
				declarationseq(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacealiasContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public NamespacealiasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacealias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNamespacealias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNamespacealias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNamespacealias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespacealiasContext namespacealias() throws RecognitionException {
		NamespacealiasContext _localctx = new NamespacealiasContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_namespacealias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacealiasdefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(CPP14Parser.Namespace, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public QualifiednamespacespecifierContext qualifiednamespacespecifier() {
			return getRuleContext(QualifiednamespacespecifierContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public NamespacealiasdefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacealiasdefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNamespacealiasdefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNamespacealiasdefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNamespacealiasdefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespacealiasdefinitionContext namespacealiasdefinition() throws RecognitionException {
		NamespacealiasdefinitionContext _localctx = new NamespacealiasdefinitionContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_namespacealiasdefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1480);
			match(Namespace);
			setState(1481);
			match(Identifier);
			setState(1482);
			match(Assign);
			setState(1483);
			qualifiednamespacespecifier();
			setState(1484);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiednamespacespecifierContext extends ParserRuleContext {
		public NamespacenameContext namespacename() {
			return getRuleContext(NamespacenameContext.class,0);
		}
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public QualifiednamespacespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiednamespacespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterQualifiednamespacespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitQualifiednamespacespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitQualifiednamespacespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiednamespacespecifierContext qualifiednamespacespecifier() throws RecognitionException {
		QualifiednamespacespecifierContext _localctx = new QualifiednamespacespecifierContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_qualifiednamespacespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1487);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				{
				setState(1486);
				nestednamespecifier(0);
				}
				break;
			}
			setState(1489);
			namespacename();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingdeclarationContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(CPP14Parser.Using, 0); }
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public UnqualifiedidContext unqualifiedid() {
			return getRuleContext(UnqualifiedidContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public TerminalNode Typename_() { return getToken(CPP14Parser.Typename_, 0); }
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public UsingdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterUsingdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitUsingdeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitUsingdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingdeclarationContext usingdeclaration() throws RecognitionException {
		UsingdeclarationContext _localctx = new UsingdeclarationContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_usingdeclaration);
		int _la;
		try {
			setState(1504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1491);
				match(Using);
				setState(1493);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Typename_) {
					{
					setState(1492);
					match(Typename_);
					}
				}

				setState(1495);
				nestednamespecifier(0);
				setState(1496);
				unqualifiedid();
				setState(1497);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1499);
				match(Using);
				setState(1500);
				match(Doublecolon);
				setState(1501);
				unqualifiedid();
				setState(1502);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingdirectiveContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(CPP14Parser.Using, 0); }
		public TerminalNode Namespace() { return getToken(CPP14Parser.Namespace, 0); }
		public NamespacenameContext namespacename() {
			return getRuleContext(NamespacenameContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public UsingdirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingdirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterUsingdirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitUsingdirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitUsingdirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingdirectiveContext usingdirective() throws RecognitionException {
		UsingdirectiveContext _localctx = new UsingdirectiveContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_usingdirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1506);
				attributespecifierseq(0);
				}
			}

			setState(1509);
			match(Using);
			setState(1510);
			match(Namespace);
			setState(1512);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
			case 1:
				{
				setState(1511);
				nestednamespecifier(0);
				}
				break;
			}
			setState(1514);
			namespacename();
			setState(1515);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsmdefinitionContext extends ParserRuleContext {
		public TerminalNode Asm() { return getToken(CPP14Parser.Asm, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode Stringliteral() { return getToken(CPP14Parser.Stringliteral, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AsmdefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asmdefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAsmdefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAsmdefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAsmdefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsmdefinitionContext asmdefinition() throws RecognitionException {
		AsmdefinitionContext _localctx = new AsmdefinitionContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_asmdefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1517);
			match(Asm);
			setState(1518);
			match(LeftParen);
			setState(1519);
			match(Stringliteral);
			setState(1520);
			match(RightParen);
			setState(1521);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LinkagespecificationContext extends ParserRuleContext {
		public TerminalNode Extern() { return getToken(CPP14Parser.Extern, 0); }
		public TerminalNode Stringliteral() { return getToken(CPP14Parser.Stringliteral, 0); }
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public DeclarationseqContext declarationseq() {
			return getRuleContext(DeclarationseqContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public LinkagespecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linkagespecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLinkagespecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLinkagespecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLinkagespecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinkagespecificationContext linkagespecification() throws RecognitionException {
		LinkagespecificationContext _localctx = new LinkagespecificationContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_linkagespecification);
		int _la;
		try {
			setState(1533);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1523);
				match(Extern);
				setState(1524);
				match(Stringliteral);
				setState(1525);
				match(LeftBrace);
				setState(1527);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IncludeDirective) | (1L << DefineDirective) | (1L << Alignas) | (1L << Asm) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Decltype) | (1L << Double) | (1L << Enum) | (1L << Explicit) | (1L << Extern) | (1L << Float) | (1L << Friend) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << Namespace) | (1L << Operator) | (1L << Register))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Static - 64)) | (1L << (Static_assert - 64)) | (1L << (Struct - 64)) | (1L << (Template - 64)) | (1L << (Thread_local - 64)) | (1L << (Typedef - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Using - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Tilde - 64)) | (1L << (AndAnd - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Semi - 133)) | (1L << (Ellipsis - 133)) | (1L << (Identifier - 133)))) != 0)) {
					{
					setState(1526);
					declarationseq(0);
					}
				}

				setState(1529);
				match(RightBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1530);
				match(Extern);
				setState(1531);
				match(Stringliteral);
				setState(1532);
				declaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributespecifierseqContext extends ParserRuleContext {
		public AttributespecifierContext attributespecifier() {
			return getRuleContext(AttributespecifierContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public AttributespecifierseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributespecifierseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAttributespecifierseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAttributespecifierseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAttributespecifierseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributespecifierseqContext attributespecifierseq() throws RecognitionException {
		return attributespecifierseq(0);
	}

	private AttributespecifierseqContext attributespecifierseq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AttributespecifierseqContext _localctx = new AttributespecifierseqContext(_ctx, _parentState);
		AttributespecifierseqContext _prevctx = _localctx;
		int _startState = 212;
		enterRecursionRule(_localctx, 212, RULE_attributespecifierseq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1536);
			attributespecifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(1542);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AttributespecifierseqContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_attributespecifierseq);
					setState(1538);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1539);
					attributespecifier();
					}
					} 
				}
				setState(1544);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AttributespecifierContext extends ParserRuleContext {
		public List<TerminalNode> LeftBracket() { return getTokens(CPP14Parser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(CPP14Parser.LeftBracket, i);
		}
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public List<TerminalNode> RightBracket() { return getTokens(CPP14Parser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(CPP14Parser.RightBracket, i);
		}
		public AlignmentspecifierContext alignmentspecifier() {
			return getRuleContext(AlignmentspecifierContext.class,0);
		}
		public AttributespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAttributespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAttributespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAttributespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributespecifierContext attributespecifier() throws RecognitionException {
		AttributespecifierContext _localctx = new AttributespecifierContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_attributespecifier);
		try {
			setState(1552);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1545);
				match(LeftBracket);
				setState(1546);
				match(LeftBracket);
				setState(1547);
				attributelist(0);
				setState(1548);
				match(RightBracket);
				setState(1549);
				match(RightBracket);
				}
				break;
			case Alignas:
				enterOuterAlt(_localctx, 2);
				{
				setState(1551);
				alignmentspecifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlignmentspecifierContext extends ParserRuleContext {
		public TerminalNode Alignas() { return getToken(CPP14Parser.Alignas, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ThetypeidContext thetypeid() {
			return getRuleContext(ThetypeidContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public AlignmentspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alignmentspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAlignmentspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAlignmentspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAlignmentspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlignmentspecifierContext alignmentspecifier() throws RecognitionException {
		AlignmentspecifierContext _localctx = new AlignmentspecifierContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_alignmentspecifier);
		int _la;
		try {
			setState(1570);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1554);
				match(Alignas);
				setState(1555);
				match(LeftParen);
				setState(1556);
				thetypeid();
				setState(1558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1557);
					match(Ellipsis);
					}
				}

				setState(1560);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1562);
				match(Alignas);
				setState(1563);
				match(LeftParen);
				setState(1564);
				constantexpression();
				setState(1566);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1565);
					match(Ellipsis);
					}
				}

				setState(1568);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributelistContext extends ParserRuleContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public AttributelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributelist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAttributelist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAttributelist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAttributelist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributelistContext attributelist() throws RecognitionException {
		return attributelist(0);
	}

	private AttributelistContext attributelist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AttributelistContext _localctx = new AttributelistContext(_ctx, _parentState);
		AttributelistContext _prevctx = _localctx;
		int _startState = 218;
		enterRecursionRule(_localctx, 218, RULE_attributelist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1579);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				{
				setState(1574);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1573);
					attribute();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(1576);
				attribute();
				setState(1577);
				match(Ellipsis);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1593);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1591);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
					case 1:
						{
						_localctx = new AttributelistContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_attributelist);
						setState(1581);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1582);
						match(Comma);
						setState(1584);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
						case 1:
							{
							setState(1583);
							attribute();
							}
							break;
						}
						}
						break;
					case 2:
						{
						_localctx = new AttributelistContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_attributelist);
						setState(1586);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1587);
						match(Comma);
						setState(1588);
						attribute();
						setState(1589);
						match(Ellipsis);
						}
						break;
					}
					} 
				}
				setState(1595);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public AttributetokenContext attributetoken() {
			return getRuleContext(AttributetokenContext.class,0);
		}
		public AttributeargumentclauseContext attributeargumentclause() {
			return getRuleContext(AttributeargumentclauseContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1596);
			attributetoken();
			setState(1598);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
			case 1:
				{
				setState(1597);
				attributeargumentclause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributetokenContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public AttributescopedtokenContext attributescopedtoken() {
			return getRuleContext(AttributescopedtokenContext.class,0);
		}
		public AttributetokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributetoken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAttributetoken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAttributetoken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAttributetoken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributetokenContext attributetoken() throws RecognitionException {
		AttributetokenContext _localctx = new AttributetokenContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_attributetoken);
		try {
			setState(1602);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1600);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1601);
				attributescopedtoken();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributescopedtokenContext extends ParserRuleContext {
		public AttributenamespaceContext attributenamespace() {
			return getRuleContext(AttributenamespaceContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public AttributescopedtokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributescopedtoken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAttributescopedtoken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAttributescopedtoken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAttributescopedtoken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributescopedtokenContext attributescopedtoken() throws RecognitionException {
		AttributescopedtokenContext _localctx = new AttributescopedtokenContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_attributescopedtoken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1604);
			attributenamespace();
			setState(1605);
			match(Doublecolon);
			setState(1606);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributenamespaceContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public AttributenamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributenamespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAttributenamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAttributenamespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAttributenamespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributenamespaceContext attributenamespace() throws RecognitionException {
		AttributenamespaceContext _localctx = new AttributenamespaceContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_attributenamespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1608);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeargumentclauseContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public BalancedtokenseqContext balancedtokenseq() {
			return getRuleContext(BalancedtokenseqContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public AttributeargumentclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeargumentclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAttributeargumentclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAttributeargumentclause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAttributeargumentclause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeargumentclauseContext attributeargumentclause() throws RecognitionException {
		AttributeargumentclauseContext _localctx = new AttributeargumentclauseContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_attributeargumentclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1610);
			match(LeftParen);
			setState(1611);
			balancedtokenseq(0);
			setState(1612);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BalancedtokenseqContext extends ParserRuleContext {
		public BalancedtokenContext balancedtoken() {
			return getRuleContext(BalancedtokenContext.class,0);
		}
		public BalancedtokenseqContext balancedtokenseq() {
			return getRuleContext(BalancedtokenseqContext.class,0);
		}
		public BalancedtokenseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balancedtokenseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBalancedtokenseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBalancedtokenseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBalancedtokenseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BalancedtokenseqContext balancedtokenseq() throws RecognitionException {
		return balancedtokenseq(0);
	}

	private BalancedtokenseqContext balancedtokenseq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BalancedtokenseqContext _localctx = new BalancedtokenseqContext(_ctx, _parentState);
		BalancedtokenseqContext _prevctx = _localctx;
		int _startState = 230;
		enterRecursionRule(_localctx, 230, RULE_balancedtokenseq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1616);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
			case 1:
				{
				setState(1615);
				balancedtoken();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1622);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BalancedtokenseqContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_balancedtokenseq);
					setState(1618);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1619);
					balancedtoken();
					}
					} 
				}
				setState(1624);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BalancedtokenContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public BalancedtokenseqContext balancedtokenseq() {
			return getRuleContext(BalancedtokenseqContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public BalancedtokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balancedtoken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBalancedtoken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBalancedtoken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBalancedtoken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BalancedtokenContext balancedtoken() throws RecognitionException {
		BalancedtokenContext _localctx = new BalancedtokenContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_balancedtoken);
		try {
			setState(1637);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(1625);
				match(LeftParen);
				setState(1626);
				balancedtokenseq(0);
				setState(1627);
				match(RightParen);
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1629);
				match(LeftBracket);
				setState(1630);
				balancedtokenseq(0);
				setState(1631);
				match(RightBracket);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 3);
				{
				setState(1633);
				match(LeftBrace);
				setState(1634);
				balancedtokenseq(0);
				setState(1635);
				match(RightBrace);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitdeclaratorlistContext extends ParserRuleContext {
		public InitdeclaratorContext initdeclarator() {
			return getRuleContext(InitdeclaratorContext.class,0);
		}
		public InitdeclaratorlistContext initdeclaratorlist() {
			return getRuleContext(InitdeclaratorlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public InitdeclaratorlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initdeclaratorlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterInitdeclaratorlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitInitdeclaratorlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitInitdeclaratorlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitdeclaratorlistContext initdeclaratorlist() throws RecognitionException {
		return initdeclaratorlist(0);
	}

	private InitdeclaratorlistContext initdeclaratorlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InitdeclaratorlistContext _localctx = new InitdeclaratorlistContext(_ctx, _parentState);
		InitdeclaratorlistContext _prevctx = _localctx;
		int _startState = 234;
		enterRecursionRule(_localctx, 234, RULE_initdeclaratorlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1640);
			initdeclarator();
			}
			_ctx.stop = _input.LT(-1);
			setState(1647);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InitdeclaratorlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_initdeclaratorlist);
					setState(1642);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1643);
					match(Comma);
					setState(1644);
					initdeclarator();
					}
					} 
				}
				setState(1649);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InitdeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterInitdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitInitdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitInitdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitdeclaratorContext initdeclarator() throws RecognitionException {
		InitdeclaratorContext _localctx = new InitdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_initdeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1650);
			declarator();
			setState(1652);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				{
				setState(1651);
				initializer();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends ParserRuleContext {
		public PtrdeclaratorContext ptrdeclarator() {
			return getRuleContext(PtrdeclaratorContext.class,0);
		}
		public NoptrdeclaratorContext noptrdeclarator() {
			return getRuleContext(NoptrdeclaratorContext.class,0);
		}
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public TrailingreturntypeContext trailingreturntype() {
			return getRuleContext(TrailingreturntypeContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_declarator);
		try {
			setState(1659);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1654);
				ptrdeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1655);
				noptrdeclarator(0);
				setState(1656);
				parametersandqualifiers();
				setState(1657);
				trailingreturntype();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PtrdeclaratorContext extends ParserRuleContext {
		public NoptrdeclaratorContext noptrdeclarator() {
			return getRuleContext(NoptrdeclaratorContext.class,0);
		}
		public PtroperatorContext ptroperator() {
			return getRuleContext(PtroperatorContext.class,0);
		}
		public PtrdeclaratorContext ptrdeclarator() {
			return getRuleContext(PtrdeclaratorContext.class,0);
		}
		public PtrdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptrdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterPtrdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitPtrdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitPtrdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PtrdeclaratorContext ptrdeclarator() throws RecognitionException {
		PtrdeclaratorContext _localctx = new PtrdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_ptrdeclarator);
		try {
			setState(1665);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1661);
				noptrdeclarator(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1662);
				ptroperator();
				setState(1663);
				ptrdeclarator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoptrdeclaratorContext extends ParserRuleContext {
		public DeclaratoridContext declaratorid() {
			return getRuleContext(DeclaratoridContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public PtrdeclaratorContext ptrdeclarator() {
			return getRuleContext(PtrdeclaratorContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NoptrdeclaratorContext noptrdeclarator() {
			return getRuleContext(NoptrdeclaratorContext.class,0);
		}
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public NoptrdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noptrdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNoptrdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNoptrdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNoptrdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoptrdeclaratorContext noptrdeclarator() throws RecognitionException {
		return noptrdeclarator(0);
	}

	private NoptrdeclaratorContext noptrdeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoptrdeclaratorContext _localctx = new NoptrdeclaratorContext(_ctx, _parentState);
		NoptrdeclaratorContext _prevctx = _localctx;
		int _startState = 242;
		enterRecursionRule(_localctx, 242, RULE_noptrdeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1676);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Operator:
			case Tilde:
			case Doublecolon:
			case Ellipsis:
			case Identifier:
				{
				setState(1668);
				declaratorid();
				setState(1670);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
				case 1:
					{
					setState(1669);
					attributespecifierseq(0);
					}
					break;
				}
				}
				break;
			case LeftParen:
				{
				setState(1672);
				match(LeftParen);
				setState(1673);
				ptrdeclarator();
				setState(1674);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1691);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1689);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
					case 1:
						{
						_localctx = new NoptrdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrdeclarator);
						setState(1678);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1679);
						parametersandqualifiers();
						}
						break;
					case 2:
						{
						_localctx = new NoptrdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrdeclarator);
						setState(1680);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1681);
						match(LeftBracket);
						setState(1683);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
							{
							setState(1682);
							constantexpression();
							}
						}

						setState(1685);
						match(RightBracket);
						setState(1687);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
						case 1:
							{
							setState(1686);
							attributespecifierseq(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1693);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParametersandqualifiersContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ParameterdeclarationclauseContext parameterdeclarationclause() {
			return getRuleContext(ParameterdeclarationclauseContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public CvqualifierseqContext cvqualifierseq() {
			return getRuleContext(CvqualifierseqContext.class,0);
		}
		public RefqualifierContext refqualifier() {
			return getRuleContext(RefqualifierContext.class,0);
		}
		public ExceptionspecificationContext exceptionspecification() {
			return getRuleContext(ExceptionspecificationContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public ParametersandqualifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersandqualifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterParametersandqualifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitParametersandqualifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitParametersandqualifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersandqualifiersContext parametersandqualifiers() throws RecognitionException {
		ParametersandqualifiersContext _localctx = new ParametersandqualifiersContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_parametersandqualifiers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1694);
			match(LeftParen);
			setState(1695);
			parameterdeclarationclause();
			setState(1696);
			match(RightParen);
			setState(1698);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
			case 1:
				{
				setState(1697);
				cvqualifierseq();
				}
				break;
			}
			setState(1701);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
			case 1:
				{
				setState(1700);
				refqualifier();
				}
				break;
			}
			setState(1704);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
			case 1:
				{
				setState(1703);
				exceptionspecification();
				}
				break;
			}
			setState(1707);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
			case 1:
				{
				setState(1706);
				attributespecifierseq(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrailingreturntypeContext extends ParserRuleContext {
		public TerminalNode Arrow() { return getToken(CPP14Parser.Arrow, 0); }
		public TrailingtypespecifierseqContext trailingtypespecifierseq() {
			return getRuleContext(TrailingtypespecifierseqContext.class,0);
		}
		public AbstractdeclaratorContext abstractdeclarator() {
			return getRuleContext(AbstractdeclaratorContext.class,0);
		}
		public TrailingreturntypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingreturntype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTrailingreturntype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTrailingreturntype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTrailingreturntype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrailingreturntypeContext trailingreturntype() throws RecognitionException {
		TrailingreturntypeContext _localctx = new TrailingreturntypeContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_trailingreturntype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1709);
			match(Arrow);
			setState(1710);
			trailingtypespecifierseq();
			setState(1712);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				{
				setState(1711);
				abstractdeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PtroperatorContext extends ParserRuleContext {
		public TerminalNode Star() { return getToken(CPP14Parser.Star, 0); }
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public CvqualifierseqContext cvqualifierseq() {
			return getRuleContext(CvqualifierseqContext.class,0);
		}
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode AndAnd() { return getToken(CPP14Parser.AndAnd, 0); }
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public PtroperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptroperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterPtroperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitPtroperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitPtroperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PtroperatorContext ptroperator() throws RecognitionException {
		PtroperatorContext _localctx = new PtroperatorContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_ptroperator);
		try {
			setState(1737);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Star:
				enterOuterAlt(_localctx, 1);
				{
				setState(1714);
				match(Star);
				setState(1716);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
				case 1:
					{
					setState(1715);
					attributespecifierseq(0);
					}
					break;
				}
				setState(1719);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
				case 1:
					{
					setState(1718);
					cvqualifierseq();
					}
					break;
				}
				}
				break;
			case And:
				enterOuterAlt(_localctx, 2);
				{
				setState(1721);
				match(And);
				setState(1723);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
				case 1:
					{
					setState(1722);
					attributespecifierseq(0);
					}
					break;
				}
				}
				break;
			case AndAnd:
				enterOuterAlt(_localctx, 3);
				{
				setState(1725);
				match(AndAnd);
				setState(1727);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
				case 1:
					{
					setState(1726);
					attributespecifierseq(0);
					}
					break;
				}
				}
				break;
			case Decltype:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(1729);
				nestednamespecifier(0);
				setState(1730);
				match(Star);
				setState(1732);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
				case 1:
					{
					setState(1731);
					attributespecifierseq(0);
					}
					break;
				}
				setState(1735);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
				case 1:
					{
					setState(1734);
					cvqualifierseq();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CvqualifierseqContext extends ParserRuleContext {
		public CvqualifierContext cvqualifier() {
			return getRuleContext(CvqualifierContext.class,0);
		}
		public CvqualifierseqContext cvqualifierseq() {
			return getRuleContext(CvqualifierseqContext.class,0);
		}
		public CvqualifierseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cvqualifierseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterCvqualifierseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitCvqualifierseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitCvqualifierseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CvqualifierseqContext cvqualifierseq() throws RecognitionException {
		CvqualifierseqContext _localctx = new CvqualifierseqContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_cvqualifierseq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1739);
			cvqualifier();
			setState(1741);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
			case 1:
				{
				setState(1740);
				cvqualifierseq();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CvqualifierContext extends ParserRuleContext {
		public TerminalNode Const() { return getToken(CPP14Parser.Const, 0); }
		public TerminalNode Volatile() { return getToken(CPP14Parser.Volatile, 0); }
		public CvqualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cvqualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterCvqualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitCvqualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitCvqualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CvqualifierContext cvqualifier() throws RecognitionException {
		CvqualifierContext _localctx = new CvqualifierContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_cvqualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1743);
			_la = _input.LA(1);
			if ( !(_la==Const || _la==Volatile) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RefqualifierContext extends ParserRuleContext {
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode AndAnd() { return getToken(CPP14Parser.AndAnd, 0); }
		public RefqualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refqualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterRefqualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitRefqualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitRefqualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefqualifierContext refqualifier() throws RecognitionException {
		RefqualifierContext _localctx = new RefqualifierContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_refqualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1745);
			_la = _input.LA(1);
			if ( !(_la==And || _la==AndAnd) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratoridContext extends ParserRuleContext {
		public IdexpressionContext idexpression() {
			return getRuleContext(IdexpressionContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public DeclaratoridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaratorid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDeclaratorid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDeclaratorid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDeclaratorid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratoridContext declaratorid() throws RecognitionException {
		DeclaratoridContext _localctx = new DeclaratoridContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_declaratorid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1748);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1747);
				match(Ellipsis);
				}
			}

			setState(1750);
			idexpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThetypeidContext extends ParserRuleContext {
		public TypespecifierseqContext typespecifierseq() {
			return getRuleContext(TypespecifierseqContext.class,0);
		}
		public AbstractdeclaratorContext abstractdeclarator() {
			return getRuleContext(AbstractdeclaratorContext.class,0);
		}
		public ThetypeidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thetypeid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterThetypeid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitThetypeid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitThetypeid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThetypeidContext thetypeid() throws RecognitionException {
		ThetypeidContext _localctx = new ThetypeidContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_thetypeid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1752);
			typespecifierseq();
			setState(1754);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				{
				setState(1753);
				abstractdeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractdeclaratorContext extends ParserRuleContext {
		public PtrabstractdeclaratorContext ptrabstractdeclarator() {
			return getRuleContext(PtrabstractdeclaratorContext.class,0);
		}
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public TrailingreturntypeContext trailingreturntype() {
			return getRuleContext(TrailingreturntypeContext.class,0);
		}
		public NoptrabstractdeclaratorContext noptrabstractdeclarator() {
			return getRuleContext(NoptrabstractdeclaratorContext.class,0);
		}
		public AbstractpackdeclaratorContext abstractpackdeclarator() {
			return getRuleContext(AbstractpackdeclaratorContext.class,0);
		}
		public AbstractdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAbstractdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAbstractdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAbstractdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractdeclaratorContext abstractdeclarator() throws RecognitionException {
		AbstractdeclaratorContext _localctx = new AbstractdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_abstractdeclarator);
		try {
			setState(1764);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1756);
				ptrabstractdeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1758);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
				case 1:
					{
					setState(1757);
					noptrabstractdeclarator(0);
					}
					break;
				}
				setState(1760);
				parametersandqualifiers();
				setState(1761);
				trailingreturntype();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1763);
				abstractpackdeclarator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PtrabstractdeclaratorContext extends ParserRuleContext {
		public NoptrabstractdeclaratorContext noptrabstractdeclarator() {
			return getRuleContext(NoptrabstractdeclaratorContext.class,0);
		}
		public PtroperatorContext ptroperator() {
			return getRuleContext(PtroperatorContext.class,0);
		}
		public PtrabstractdeclaratorContext ptrabstractdeclarator() {
			return getRuleContext(PtrabstractdeclaratorContext.class,0);
		}
		public PtrabstractdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptrabstractdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterPtrabstractdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitPtrabstractdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitPtrabstractdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PtrabstractdeclaratorContext ptrabstractdeclarator() throws RecognitionException {
		PtrabstractdeclaratorContext _localctx = new PtrabstractdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_ptrabstractdeclarator);
		try {
			setState(1771);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1766);
				noptrabstractdeclarator(0);
				}
				break;
			case Decltype:
			case Star:
			case And:
			case AndAnd:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1767);
				ptroperator();
				setState(1769);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
				case 1:
					{
					setState(1768);
					ptrabstractdeclarator();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoptrabstractdeclaratorContext extends ParserRuleContext {
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public PtrabstractdeclaratorContext ptrabstractdeclarator() {
			return getRuleContext(PtrabstractdeclaratorContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NoptrabstractdeclaratorContext noptrabstractdeclarator() {
			return getRuleContext(NoptrabstractdeclaratorContext.class,0);
		}
		public NoptrabstractdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noptrabstractdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNoptrabstractdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNoptrabstractdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNoptrabstractdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoptrabstractdeclaratorContext noptrabstractdeclarator() throws RecognitionException {
		return noptrabstractdeclarator(0);
	}

	private NoptrabstractdeclaratorContext noptrabstractdeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoptrabstractdeclaratorContext _localctx = new NoptrabstractdeclaratorContext(_ctx, _parentState);
		NoptrabstractdeclaratorContext _prevctx = _localctx;
		int _startState = 264;
		enterRecursionRule(_localctx, 264, RULE_noptrabstractdeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1787);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
			case 1:
				{
				setState(1774);
				parametersandqualifiers();
				}
				break;
			case 2:
				{
				setState(1775);
				match(LeftBracket);
				setState(1777);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(1776);
					constantexpression();
					}
				}

				setState(1779);
				match(RightBracket);
				setState(1781);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
				case 1:
					{
					setState(1780);
					attributespecifierseq(0);
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(1783);
				match(LeftParen);
				setState(1784);
				ptrabstractdeclarator();
				setState(1785);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1802);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1800);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
					case 1:
						{
						_localctx = new NoptrabstractdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrabstractdeclarator);
						setState(1789);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1790);
						parametersandqualifiers();
						}
						break;
					case 2:
						{
						_localctx = new NoptrabstractdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrabstractdeclarator);
						setState(1791);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1792);
						match(LeftBracket);
						setState(1794);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
							{
							setState(1793);
							constantexpression();
							}
						}

						setState(1796);
						match(RightBracket);
						setState(1798);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
						case 1:
							{
							setState(1797);
							attributespecifierseq(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1804);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AbstractpackdeclaratorContext extends ParserRuleContext {
		public NoptrabstractpackdeclaratorContext noptrabstractpackdeclarator() {
			return getRuleContext(NoptrabstractpackdeclaratorContext.class,0);
		}
		public PtroperatorContext ptroperator() {
			return getRuleContext(PtroperatorContext.class,0);
		}
		public AbstractpackdeclaratorContext abstractpackdeclarator() {
			return getRuleContext(AbstractpackdeclaratorContext.class,0);
		}
		public AbstractpackdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractpackdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAbstractpackdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAbstractpackdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAbstractpackdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractpackdeclaratorContext abstractpackdeclarator() throws RecognitionException {
		AbstractpackdeclaratorContext _localctx = new AbstractpackdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_abstractpackdeclarator);
		try {
			setState(1809);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Ellipsis:
				enterOuterAlt(_localctx, 1);
				{
				setState(1805);
				noptrabstractpackdeclarator(0);
				}
				break;
			case Decltype:
			case Star:
			case And:
			case AndAnd:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1806);
				ptroperator();
				setState(1807);
				abstractpackdeclarator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoptrabstractpackdeclaratorContext extends ParserRuleContext {
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public NoptrabstractpackdeclaratorContext noptrabstractpackdeclarator() {
			return getRuleContext(NoptrabstractpackdeclaratorContext.class,0);
		}
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public NoptrabstractpackdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noptrabstractpackdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNoptrabstractpackdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNoptrabstractpackdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNoptrabstractpackdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoptrabstractpackdeclaratorContext noptrabstractpackdeclarator() throws RecognitionException {
		return noptrabstractpackdeclarator(0);
	}

	private NoptrabstractpackdeclaratorContext noptrabstractpackdeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoptrabstractpackdeclaratorContext _localctx = new NoptrabstractpackdeclaratorContext(_ctx, _parentState);
		NoptrabstractpackdeclaratorContext _prevctx = _localctx;
		int _startState = 268;
		enterRecursionRule(_localctx, 268, RULE_noptrabstractpackdeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1812);
			match(Ellipsis);
			}
			_ctx.stop = _input.LT(-1);
			setState(1827);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1825);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
					case 1:
						{
						_localctx = new NoptrabstractpackdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrabstractpackdeclarator);
						setState(1814);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1815);
						parametersandqualifiers();
						}
						break;
					case 2:
						{
						_localctx = new NoptrabstractpackdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrabstractpackdeclarator);
						setState(1816);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1817);
						match(LeftBracket);
						setState(1819);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
							{
							setState(1818);
							constantexpression();
							}
						}

						setState(1821);
						match(RightBracket);
						setState(1823);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
						case 1:
							{
							setState(1822);
							attributespecifierseq(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1829);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParameterdeclarationclauseContext extends ParserRuleContext {
		public ParameterdeclarationlistContext parameterdeclarationlist() {
			return getRuleContext(ParameterdeclarationlistContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public ParameterdeclarationclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterdeclarationclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterParameterdeclarationclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitParameterdeclarationclause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitParameterdeclarationclause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterdeclarationclauseContext parameterdeclarationclause() throws RecognitionException {
		ParameterdeclarationclauseContext _localctx = new ParameterdeclarationclauseContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_parameterdeclarationclause);
		int _la;
		try {
			setState(1840);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1831);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignas) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << Explicit) | (1L << Extern) | (1L << False) | (1L << Float) | (1L << Friend) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Register) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (This - 64)) | (1L << (Thread_local - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typedef - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(1830);
					parameterdeclarationlist(0);
					}
				}

				setState(1834);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1833);
					match(Ellipsis);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1836);
				parameterdeclarationlist(0);
				setState(1837);
				match(Comma);
				setState(1838);
				match(Ellipsis);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterdeclarationlistContext extends ParserRuleContext {
		public ParameterdeclarationContext parameterdeclaration() {
			return getRuleContext(ParameterdeclarationContext.class,0);
		}
		public ParameterdeclarationlistContext parameterdeclarationlist() {
			return getRuleContext(ParameterdeclarationlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public ParameterdeclarationlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterdeclarationlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterParameterdeclarationlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitParameterdeclarationlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitParameterdeclarationlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterdeclarationlistContext parameterdeclarationlist() throws RecognitionException {
		return parameterdeclarationlist(0);
	}

	private ParameterdeclarationlistContext parameterdeclarationlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParameterdeclarationlistContext _localctx = new ParameterdeclarationlistContext(_ctx, _parentState);
		ParameterdeclarationlistContext _prevctx = _localctx;
		int _startState = 272;
		enterRecursionRule(_localctx, 272, RULE_parameterdeclarationlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1843);
			parameterdeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(1850);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,210,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParameterdeclarationlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_parameterdeclarationlist);
					setState(1845);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1846);
					match(Comma);
					setState(1847);
					parameterdeclaration();
					}
					} 
				}
				setState(1852);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,210,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParameterdeclarationContext extends ParserRuleContext {
		public PrimaryexpressionContext primaryexpression() {
			return getRuleContext(PrimaryexpressionContext.class,0);
		}
		public PostfixexpressionContext postfixexpression() {
			return getRuleContext(PostfixexpressionContext.class,0);
		}
		public UnaryexpressionContext unaryexpression() {
			return getRuleContext(UnaryexpressionContext.class,0);
		}
		public EqualityexpressionContext equalityexpression() {
			return getRuleContext(EqualityexpressionContext.class,0);
		}
		public ExclusiveorexpressionContext exclusiveorexpression() {
			return getRuleContext(ExclusiveorexpressionContext.class,0);
		}
		public AdditiveexpressionContext additiveexpression() {
			return getRuleContext(AdditiveexpressionContext.class,0);
		}
		public AndexpressionContext andexpression() {
			return getRuleContext(AndexpressionContext.class,0);
		}
		public AssignmentexpressionContext assignmentexpression() {
			return getRuleContext(AssignmentexpressionContext.class,0);
		}
		public CastexpressionContext castexpression() {
			return getRuleContext(CastexpressionContext.class,0);
		}
		public ConditionalexpressionContext conditionalexpression() {
			return getRuleContext(ConditionalexpressionContext.class,0);
		}
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public DeleteexpressionContext deleteexpression() {
			return getRuleContext(DeleteexpressionContext.class,0);
		}
		public IdexpressionContext idexpression() {
			return getRuleContext(IdexpressionContext.class,0);
		}
		public InclusiveorexpressionContext inclusiveorexpression() {
			return getRuleContext(InclusiveorexpressionContext.class,0);
		}
		public LambdaexpressionContext lambdaexpression() {
			return getRuleContext(LambdaexpressionContext.class,0);
		}
		public LogicalandexpressionContext logicalandexpression() {
			return getRuleContext(LogicalandexpressionContext.class,0);
		}
		public LogicalorexpressionContext logicalorexpression() {
			return getRuleContext(LogicalorexpressionContext.class,0);
		}
		public MultiplicativeexpressionContext multiplicativeexpression() {
			return getRuleContext(MultiplicativeexpressionContext.class,0);
		}
		public NewexpressionContext newexpression() {
			return getRuleContext(NewexpressionContext.class,0);
		}
		public NoexceptexpressionContext noexceptexpression() {
			return getRuleContext(NoexceptexpressionContext.class,0);
		}
		public RelationalexpressionContext relationalexpression() {
			return getRuleContext(RelationalexpressionContext.class,0);
		}
		public ShiftexpressionContext shiftexpression() {
			return getRuleContext(ShiftexpressionContext.class,0);
		}
		public ThrowexpressionContext throwexpression() {
			return getRuleContext(ThrowexpressionContext.class,0);
		}
		public CompoundstatementContext compoundstatement() {
			return getRuleContext(CompoundstatementContext.class,0);
		}
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public AbstractdeclaratorContext abstractdeclarator() {
			return getRuleContext(AbstractdeclaratorContext.class,0);
		}
		public ParameterdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterParameterdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitParameterdeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitParameterdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterdeclarationContext parameterdeclaration() throws RecognitionException {
		ParameterdeclarationContext _localctx = new ParameterdeclarationContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_parameterdeclaration);
		int _la;
		try {
			setState(1908);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1853);
				primaryexpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1854);
				postfixexpression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1855);
				unaryexpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1856);
				equalityexpression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1857);
				exclusiveorexpression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1858);
				additiveexpression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1859);
				andexpression(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1860);
				assignmentexpression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1861);
				castexpression();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1862);
				conditionalexpression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1863);
				constantexpression();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1864);
				deleteexpression();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1865);
				idexpression();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1866);
				inclusiveorexpression(0);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1867);
				lambdaexpression();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1868);
				logicalandexpression(0);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1869);
				logicalorexpression(0);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1870);
				multiplicativeexpression(0);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1871);
				newexpression();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(1872);
				noexceptexpression();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(1873);
				relationalexpression(0);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(1874);
				shiftexpression(0);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(1875);
				throwexpression();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(1876);
				compoundstatement();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(1878);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1877);
					attributespecifierseq(0);
					}
				}

				setState(1880);
				declspecifierseq();
				setState(1881);
				declarator();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(1884);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1883);
					attributespecifierseq(0);
					}
				}

				setState(1886);
				declspecifierseq();
				setState(1887);
				declarator();
				setState(1888);
				match(Assign);
				setState(1889);
				initializerclause();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(1892);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1891);
					attributespecifierseq(0);
					}
				}

				setState(1894);
				declspecifierseq();
				setState(1896);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
				case 1:
					{
					setState(1895);
					abstractdeclarator();
					}
					break;
				}
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(1899);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1898);
					attributespecifierseq(0);
					}
				}

				setState(1901);
				declspecifierseq();
				setState(1903);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (LeftParen - 89)) | (1L << (LeftBracket - 89)) | (1L << (Star - 89)) | (1L << (And - 89)) | (1L << (AndAnd - 89)) | (1L << (Doublecolon - 89)) | (1L << (Ellipsis - 89)) | (1L << (Identifier - 89)))) != 0)) {
					{
					setState(1902);
					abstractdeclarator();
					}
				}

				setState(1905);
				match(Assign);
				setState(1906);
				initializerclause();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiondefinitionContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public FunctionbodyContext functionbody() {
			return getRuleContext(FunctionbodyContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public VirtspecifierseqContext virtspecifierseq() {
			return getRuleContext(VirtspecifierseqContext.class,0);
		}
		public FunctiondefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterFunctiondefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitFunctiondefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitFunctiondefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiondefinitionContext functiondefinition() throws RecognitionException {
		FunctiondefinitionContext _localctx = new FunctiondefinitionContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_functiondefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1911);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1910);
				attributespecifierseq(0);
				}
			}

			setState(1914);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
			case 1:
				{
				setState(1913);
				declspecifierseq();
				}
				break;
			}
			setState(1916);
			declarator();
			setState(1918);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Final || _la==Override) {
				{
				setState(1917);
				virtspecifierseq(0);
				}
			}

			setState(1920);
			functionbody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionbodyContext extends ParserRuleContext {
		public CompoundstatementContext compoundstatement() {
			return getRuleContext(CompoundstatementContext.class,0);
		}
		public CtorinitializerContext ctorinitializer() {
			return getRuleContext(CtorinitializerContext.class,0);
		}
		public FunctiontryblockContext functiontryblock() {
			return getRuleContext(FunctiontryblockContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public TerminalNode Default() { return getToken(CPP14Parser.Default, 0); }
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public TerminalNode Delete() { return getToken(CPP14Parser.Delete, 0); }
		public FunctionbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterFunctionbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitFunctionbody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitFunctionbody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionbodyContext functionbody() throws RecognitionException {
		FunctionbodyContext _localctx = new FunctionbodyContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_functionbody);
		int _la;
		try {
			setState(1933);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1923);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1922);
					ctorinitializer();
					}
				}

				setState(1925);
				compoundstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1926);
				functiontryblock();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1927);
				match(Assign);
				setState(1928);
				match(Default);
				setState(1929);
				match(Semi);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1930);
				match(Assign);
				setState(1931);
				match(Delete);
				setState(1932);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public BraceorequalinitializerContext braceorequalinitializer() {
			return getRuleContext(BraceorequalinitializerContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExpressionlistContext expressionlist() {
			return getRuleContext(ExpressionlistContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_initializer);
		try {
			setState(1940);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1935);
				braceorequalinitializer();
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(1936);
				match(LeftParen);
				setState(1937);
				expressionlist();
				setState(1938);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BraceorequalinitializerContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public BracedinitlistContext bracedinitlist() {
			return getRuleContext(BracedinitlistContext.class,0);
		}
		public BraceorequalinitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceorequalinitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBraceorequalinitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBraceorequalinitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBraceorequalinitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BraceorequalinitializerContext braceorequalinitializer() throws RecognitionException {
		BraceorequalinitializerContext _localctx = new BraceorequalinitializerContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_braceorequalinitializer);
		try {
			setState(1945);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1942);
				match(Assign);
				setState(1943);
				initializerclause();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1944);
				bracedinitlist();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerclauseContext extends ParserRuleContext {
		public AssignmentexpressionContext assignmentexpression() {
			return getRuleContext(AssignmentexpressionContext.class,0);
		}
		public BracedinitlistContext bracedinitlist() {
			return getRuleContext(BracedinitlistContext.class,0);
		}
		public InitializerclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterInitializerclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitInitializerclause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitInitializerclause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerclauseContext initializerclause() throws RecognitionException {
		InitializerclauseContext _localctx = new InitializerclauseContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_initializerclause);
		try {
			setState(1949);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Alignof:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Const_cast:
			case Decltype:
			case Delete:
			case Double:
			case Dynamic_cast:
			case False:
			case Float:
			case Int:
			case Long:
			case New:
			case Noexcept:
			case Nullptr:
			case Operator:
			case Reinterpret_cast:
			case Short:
			case Signed:
			case Sizeof:
			case Static_cast:
			case This:
			case Throw:
			case True:
			case Typeid_:
			case Typename_:
			case Unsigned:
			case Void:
			case Wchar:
			case LeftParen:
			case LeftBracket:
			case Plus:
			case Minus:
			case Star:
			case And:
			case Or:
			case Tilde:
			case Not:
			case PlusPlus:
			case MinusMinus:
			case Doublecolon:
			case Identifier:
			case Integerliteral:
			case Characterliteral:
			case Floatingliteral:
			case Stringliteral:
			case Userdefinedintegerliteral:
			case Userdefinedfloatingliteral:
			case Userdefinedstringliteral:
			case Userdefinedcharacterliteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(1947);
				assignmentexpression();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1948);
				bracedinitlist();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerlistContext extends ParserRuleContext {
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public InitializerlistContext initializerlist() {
			return getRuleContext(InitializerlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public InitializerlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterInitializerlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitInitializerlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitInitializerlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerlistContext initializerlist() throws RecognitionException {
		return initializerlist(0);
	}

	private InitializerlistContext initializerlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InitializerlistContext _localctx = new InitializerlistContext(_ctx, _parentState);
		InitializerlistContext _prevctx = _localctx;
		int _startState = 286;
		enterRecursionRule(_localctx, 286, RULE_initializerlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1952);
			initializerclause();
			setState(1954);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,226,_ctx) ) {
			case 1:
				{
				setState(1953);
				match(Ellipsis);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1964);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,228,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InitializerlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_initializerlist);
					setState(1956);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1957);
					match(Comma);
					setState(1958);
					initializerclause();
					setState(1960);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,227,_ctx) ) {
					case 1:
						{
						setState(1959);
						match(Ellipsis);
						}
						break;
					}
					}
					} 
				}
				setState(1966);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,228,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BracedinitlistContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public InitializerlistContext initializerlist() {
			return getRuleContext(InitializerlistContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public BracedinitlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracedinitlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBracedinitlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBracedinitlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBracedinitlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracedinitlistContext bracedinitlist() throws RecognitionException {
		BracedinitlistContext _localctx = new BracedinitlistContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_bracedinitlist);
		int _la;
		try {
			setState(1976);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,230,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1967);
				match(LeftBrace);
				setState(1968);
				initializerlist(0);
				setState(1970);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1969);
					match(Comma);
					}
				}

				setState(1972);
				match(RightBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1974);
				match(LeftBrace);
				setState(1975);
				match(RightBrace);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassnameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public SimpletemplateidContext simpletemplateid() {
			return getRuleContext(SimpletemplateidContext.class,0);
		}
		public ClassnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterClassname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitClassname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitClassname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassnameContext classname() throws RecognitionException {
		ClassnameContext _localctx = new ClassnameContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_classname);
		try {
			setState(1980);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1978);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1979);
				simpletemplateid();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassspecifierContext extends ParserRuleContext {
		public ClassheadContext classhead() {
			return getRuleContext(ClassheadContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public MemberspecificationContext memberspecification() {
			return getRuleContext(MemberspecificationContext.class,0);
		}
		public ClassspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterClassspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitClassspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitClassspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassspecifierContext classspecifier() throws RecognitionException {
		ClassspecifierContext _localctx = new ClassspecifierContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_classspecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1982);
			classhead();
			setState(1983);
			match(LeftBrace);
			setState(1985);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (Alignas - 14)) | (1L << (Auto - 14)) | (1L << (Bool - 14)) | (1L << (Char - 14)) | (1L << (Char16 - 14)) | (1L << (Char32 - 14)) | (1L << (Class - 14)) | (1L << (Const - 14)) | (1L << (Constexpr - 14)) | (1L << (Decltype - 14)) | (1L << (Double - 14)) | (1L << (Enum - 14)) | (1L << (Explicit - 14)) | (1L << (Extern - 14)) | (1L << (Float - 14)) | (1L << (Friend - 14)) | (1L << (Inline - 14)) | (1L << (Int - 14)) | (1L << (Long - 14)) | (1L << (Mutable - 14)) | (1L << (Operator - 14)) | (1L << (Private - 14)) | (1L << (Protected - 14)) | (1L << (Public - 14)) | (1L << (Register - 14)) | (1L << (Short - 14)) | (1L << (Signed - 14)) | (1L << (Static - 14)) | (1L << (Static_assert - 14)) | (1L << (Struct - 14)) | (1L << (Template - 14)) | (1L << (Thread_local - 14)))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (Typedef - 78)) | (1L << (Typename_ - 78)) | (1L << (Union - 78)) | (1L << (Unsigned - 78)) | (1L << (Using - 78)) | (1L << (Virtual - 78)) | (1L << (Void - 78)) | (1L << (Volatile - 78)) | (1L << (Wchar - 78)) | (1L << (LeftParen - 78)) | (1L << (LeftBracket - 78)) | (1L << (Star - 78)) | (1L << (And - 78)) | (1L << (Tilde - 78)) | (1L << (AndAnd - 78)) | (1L << (Colon - 78)) | (1L << (Doublecolon - 78)) | (1L << (Semi - 78)) | (1L << (Ellipsis - 78)) | (1L << (Identifier - 78)))) != 0)) {
				{
				setState(1984);
				memberspecification();
				}
			}

			setState(1987);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassheadContext extends ParserRuleContext {
		public ClasskeyContext classkey() {
			return getRuleContext(ClasskeyContext.class,0);
		}
		public ClassheadnameContext classheadname() {
			return getRuleContext(ClassheadnameContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public ClassvirtspecifierContext classvirtspecifier() {
			return getRuleContext(ClassvirtspecifierContext.class,0);
		}
		public BaseclauseContext baseclause() {
			return getRuleContext(BaseclauseContext.class,0);
		}
		public ClassheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classhead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterClasshead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitClasshead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitClasshead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassheadContext classhead() throws RecognitionException {
		ClassheadContext _localctx = new ClassheadContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_classhead);
		int _la;
		try {
			setState(2007);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1989);
				classkey();
				setState(1991);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1990);
					attributespecifierseq(0);
					}
				}

				setState(1993);
				classheadname();
				setState(1995);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Final) {
					{
					setState(1994);
					classvirtspecifier();
					}
				}

				setState(1998);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1997);
					baseclause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2000);
				classkey();
				setState(2002);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(2001);
					attributespecifierseq(0);
					}
				}

				setState(2005);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(2004);
					baseclause();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassheadnameContext extends ParserRuleContext {
		public ClassnameContext classname() {
			return getRuleContext(ClassnameContext.class,0);
		}
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public ClassheadnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classheadname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterClassheadname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitClassheadname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitClassheadname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassheadnameContext classheadname() throws RecognitionException {
		ClassheadnameContext _localctx = new ClassheadnameContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_classheadname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2010);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,239,_ctx) ) {
			case 1:
				{
				setState(2009);
				nestednamespecifier(0);
				}
				break;
			}
			setState(2012);
			classname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassvirtspecifierContext extends ParserRuleContext {
		public TerminalNode Final() { return getToken(CPP14Parser.Final, 0); }
		public ClassvirtspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classvirtspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterClassvirtspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitClassvirtspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitClassvirtspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassvirtspecifierContext classvirtspecifier() throws RecognitionException {
		ClassvirtspecifierContext _localctx = new ClassvirtspecifierContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_classvirtspecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2014);
			match(Final);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClasskeyContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(CPP14Parser.Class, 0); }
		public TerminalNode Struct() { return getToken(CPP14Parser.Struct, 0); }
		public TerminalNode Union() { return getToken(CPP14Parser.Union, 0); }
		public ClasskeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classkey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterClasskey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitClasskey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitClasskey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClasskeyContext classkey() throws RecognitionException {
		ClasskeyContext _localctx = new ClasskeyContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_classkey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2016);
			_la = _input.LA(1);
			if ( !(((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (Class - 25)) | (1L << (Struct - 25)) | (1L << (Union - 25)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberspecificationContext extends ParserRuleContext {
		public MemberdeclarationContext memberdeclaration() {
			return getRuleContext(MemberdeclarationContext.class,0);
		}
		public MemberspecificationContext memberspecification() {
			return getRuleContext(MemberspecificationContext.class,0);
		}
		public AccessspecifierContext accessspecifier() {
			return getRuleContext(AccessspecifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public MemberspecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberspecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterMemberspecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitMemberspecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitMemberspecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberspecificationContext memberspecification() throws RecognitionException {
		MemberspecificationContext _localctx = new MemberspecificationContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_memberspecification);
		int _la;
		try {
			setState(2027);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Alignas:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Constexpr:
			case Decltype:
			case Double:
			case Enum:
			case Explicit:
			case Extern:
			case Float:
			case Friend:
			case Inline:
			case Int:
			case Long:
			case Mutable:
			case Operator:
			case Register:
			case Short:
			case Signed:
			case Static:
			case Static_assert:
			case Struct:
			case Template:
			case Thread_local:
			case Typedef:
			case Typename_:
			case Union:
			case Unsigned:
			case Using:
			case Virtual:
			case Void:
			case Volatile:
			case Wchar:
			case LeftParen:
			case LeftBracket:
			case Star:
			case And:
			case Tilde:
			case AndAnd:
			case Colon:
			case Doublecolon:
			case Semi:
			case Ellipsis:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2018);
				memberdeclaration();
				setState(2020);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (Alignas - 14)) | (1L << (Auto - 14)) | (1L << (Bool - 14)) | (1L << (Char - 14)) | (1L << (Char16 - 14)) | (1L << (Char32 - 14)) | (1L << (Class - 14)) | (1L << (Const - 14)) | (1L << (Constexpr - 14)) | (1L << (Decltype - 14)) | (1L << (Double - 14)) | (1L << (Enum - 14)) | (1L << (Explicit - 14)) | (1L << (Extern - 14)) | (1L << (Float - 14)) | (1L << (Friend - 14)) | (1L << (Inline - 14)) | (1L << (Int - 14)) | (1L << (Long - 14)) | (1L << (Mutable - 14)) | (1L << (Operator - 14)) | (1L << (Private - 14)) | (1L << (Protected - 14)) | (1L << (Public - 14)) | (1L << (Register - 14)) | (1L << (Short - 14)) | (1L << (Signed - 14)) | (1L << (Static - 14)) | (1L << (Static_assert - 14)) | (1L << (Struct - 14)) | (1L << (Template - 14)) | (1L << (Thread_local - 14)))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (Typedef - 78)) | (1L << (Typename_ - 78)) | (1L << (Union - 78)) | (1L << (Unsigned - 78)) | (1L << (Using - 78)) | (1L << (Virtual - 78)) | (1L << (Void - 78)) | (1L << (Volatile - 78)) | (1L << (Wchar - 78)) | (1L << (LeftParen - 78)) | (1L << (LeftBracket - 78)) | (1L << (Star - 78)) | (1L << (And - 78)) | (1L << (Tilde - 78)) | (1L << (AndAnd - 78)) | (1L << (Colon - 78)) | (1L << (Doublecolon - 78)) | (1L << (Semi - 78)) | (1L << (Ellipsis - 78)) | (1L << (Identifier - 78)))) != 0)) {
					{
					setState(2019);
					memberspecification();
					}
				}

				}
				break;
			case Private:
			case Protected:
			case Public:
				enterOuterAlt(_localctx, 2);
				{
				setState(2022);
				accessspecifier();
				setState(2023);
				match(Colon);
				setState(2025);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (Alignas - 14)) | (1L << (Auto - 14)) | (1L << (Bool - 14)) | (1L << (Char - 14)) | (1L << (Char16 - 14)) | (1L << (Char32 - 14)) | (1L << (Class - 14)) | (1L << (Const - 14)) | (1L << (Constexpr - 14)) | (1L << (Decltype - 14)) | (1L << (Double - 14)) | (1L << (Enum - 14)) | (1L << (Explicit - 14)) | (1L << (Extern - 14)) | (1L << (Float - 14)) | (1L << (Friend - 14)) | (1L << (Inline - 14)) | (1L << (Int - 14)) | (1L << (Long - 14)) | (1L << (Mutable - 14)) | (1L << (Operator - 14)) | (1L << (Private - 14)) | (1L << (Protected - 14)) | (1L << (Public - 14)) | (1L << (Register - 14)) | (1L << (Short - 14)) | (1L << (Signed - 14)) | (1L << (Static - 14)) | (1L << (Static_assert - 14)) | (1L << (Struct - 14)) | (1L << (Template - 14)) | (1L << (Thread_local - 14)))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (Typedef - 78)) | (1L << (Typename_ - 78)) | (1L << (Union - 78)) | (1L << (Unsigned - 78)) | (1L << (Using - 78)) | (1L << (Virtual - 78)) | (1L << (Void - 78)) | (1L << (Volatile - 78)) | (1L << (Wchar - 78)) | (1L << (LeftParen - 78)) | (1L << (LeftBracket - 78)) | (1L << (Star - 78)) | (1L << (And - 78)) | (1L << (Tilde - 78)) | (1L << (AndAnd - 78)) | (1L << (Colon - 78)) | (1L << (Doublecolon - 78)) | (1L << (Semi - 78)) | (1L << (Ellipsis - 78)) | (1L << (Identifier - 78)))) != 0)) {
					{
					setState(2024);
					memberspecification();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberdeclarationContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public MemberdeclaratorlistContext memberdeclaratorlist() {
			return getRuleContext(MemberdeclaratorlistContext.class,0);
		}
		public FunctiondefinitionContext functiondefinition() {
			return getRuleContext(FunctiondefinitionContext.class,0);
		}
		public UsingdeclarationContext usingdeclaration() {
			return getRuleContext(UsingdeclarationContext.class,0);
		}
		public Static_assertdeclarationContext static_assertdeclaration() {
			return getRuleContext(Static_assertdeclarationContext.class,0);
		}
		public TemplatedeclarationContext templatedeclaration() {
			return getRuleContext(TemplatedeclarationContext.class,0);
		}
		public AliasdeclarationContext aliasdeclaration() {
			return getRuleContext(AliasdeclarationContext.class,0);
		}
		public EmptydeclarationContext emptydeclaration() {
			return getRuleContext(EmptydeclarationContext.class,0);
		}
		public MemberdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterMemberdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitMemberdeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitMemberdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberdeclarationContext memberdeclaration() throws RecognitionException {
		MemberdeclarationContext _localctx = new MemberdeclarationContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_memberdeclaration);
		int _la;
		try {
			setState(2045);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,246,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2030);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
				case 1:
					{
					setState(2029);
					attributespecifierseq(0);
					}
					break;
				}
				setState(2033);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,244,_ctx) ) {
				case 1:
					{
					setState(2032);
					declspecifierseq();
					}
					break;
				}
				setState(2036);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignas) | (1L << Decltype) | (1L << Operator))) != 0) || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (LeftParen - 89)) | (1L << (LeftBracket - 89)) | (1L << (Star - 89)) | (1L << (And - 89)) | (1L << (Tilde - 89)) | (1L << (AndAnd - 89)) | (1L << (Colon - 89)) | (1L << (Doublecolon - 89)) | (1L << (Ellipsis - 89)) | (1L << (Identifier - 89)))) != 0)) {
					{
					setState(2035);
					memberdeclaratorlist(0);
					}
				}

				setState(2038);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2039);
				functiondefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2040);
				usingdeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2041);
				static_assertdeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2042);
				templatedeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2043);
				aliasdeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2044);
				emptydeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberdeclaratorlistContext extends ParserRuleContext {
		public MemberdeclaratorContext memberdeclarator() {
			return getRuleContext(MemberdeclaratorContext.class,0);
		}
		public MemberdeclaratorlistContext memberdeclaratorlist() {
			return getRuleContext(MemberdeclaratorlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public MemberdeclaratorlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberdeclaratorlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterMemberdeclaratorlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitMemberdeclaratorlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitMemberdeclaratorlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberdeclaratorlistContext memberdeclaratorlist() throws RecognitionException {
		return memberdeclaratorlist(0);
	}

	private MemberdeclaratorlistContext memberdeclaratorlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MemberdeclaratorlistContext _localctx = new MemberdeclaratorlistContext(_ctx, _parentState);
		MemberdeclaratorlistContext _prevctx = _localctx;
		int _startState = 306;
		enterRecursionRule(_localctx, 306, RULE_memberdeclaratorlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2048);
			memberdeclarator();
			}
			_ctx.stop = _input.LT(-1);
			setState(2055);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MemberdeclaratorlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_memberdeclaratorlist);
					setState(2050);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2051);
					match(Comma);
					setState(2052);
					memberdeclarator();
					}
					} 
				}
				setState(2057);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MemberdeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public VirtspecifierseqContext virtspecifierseq() {
			return getRuleContext(VirtspecifierseqContext.class,0);
		}
		public PurespecifierContext purespecifier() {
			return getRuleContext(PurespecifierContext.class,0);
		}
		public BraceorequalinitializerContext braceorequalinitializer() {
			return getRuleContext(BraceorequalinitializerContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public MemberdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberdeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterMemberdeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitMemberdeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitMemberdeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberdeclaratorContext memberdeclarator() throws RecognitionException {
		MemberdeclaratorContext _localctx = new MemberdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_memberdeclarator);
		int _la;
		try {
			setState(2077);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2058);
				declarator();
				setState(2060);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
				case 1:
					{
					setState(2059);
					virtspecifierseq(0);
					}
					break;
				}
				setState(2063);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
				case 1:
					{
					setState(2062);
					purespecifier();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2065);
				declarator();
				setState(2067);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
				case 1:
					{
					setState(2066);
					braceorequalinitializer();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2070);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(2069);
					match(Identifier);
					}
				}

				setState(2073);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(2072);
					attributespecifierseq(0);
					}
				}

				setState(2075);
				match(Colon);
				setState(2076);
				constantexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VirtspecifierseqContext extends ParserRuleContext {
		public VirtspecifierContext virtspecifier() {
			return getRuleContext(VirtspecifierContext.class,0);
		}
		public VirtspecifierseqContext virtspecifierseq() {
			return getRuleContext(VirtspecifierseqContext.class,0);
		}
		public VirtspecifierseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_virtspecifierseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterVirtspecifierseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitVirtspecifierseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitVirtspecifierseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VirtspecifierseqContext virtspecifierseq() throws RecognitionException {
		return virtspecifierseq(0);
	}

	private VirtspecifierseqContext virtspecifierseq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VirtspecifierseqContext _localctx = new VirtspecifierseqContext(_ctx, _parentState);
		VirtspecifierseqContext _prevctx = _localctx;
		int _startState = 310;
		enterRecursionRule(_localctx, 310, RULE_virtspecifierseq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2080);
			virtspecifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(2086);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VirtspecifierseqContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_virtspecifierseq);
					setState(2082);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2083);
					virtspecifier();
					}
					} 
				}
				setState(2088);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VirtspecifierContext extends ParserRuleContext {
		public TerminalNode Override() { return getToken(CPP14Parser.Override, 0); }
		public TerminalNode Final() { return getToken(CPP14Parser.Final, 0); }
		public VirtspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_virtspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterVirtspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitVirtspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitVirtspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VirtspecifierContext virtspecifier() throws RecognitionException {
		VirtspecifierContext _localctx = new VirtspecifierContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_virtspecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2089);
			_la = _input.LA(1);
			if ( !(_la==Final || _la==Override) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PurespecifierContext extends ParserRuleContext {
		public Token val;
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public TerminalNode Octalliteral() { return getToken(CPP14Parser.Octalliteral, 0); }
		public PurespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_purespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterPurespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitPurespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitPurespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PurespecifierContext purespecifier() throws RecognitionException {
		PurespecifierContext _localctx = new PurespecifierContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_purespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2091);
			match(Assign);
			setState(2092);
			((PurespecifierContext)_localctx).val = match(Octalliteral);
			if((((PurespecifierContext)_localctx).val!=null?((PurespecifierContext)_localctx).val.getText():null).compareTo("0")!=0) throw new InputMismatchException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseclauseContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public BasespecifierlistContext basespecifierlist() {
			return getRuleContext(BasespecifierlistContext.class,0);
		}
		public BaseclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBaseclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBaseclause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBaseclause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseclauseContext baseclause() throws RecognitionException {
		BaseclauseContext _localctx = new BaseclauseContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_baseclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2095);
			match(Colon);
			setState(2096);
			basespecifierlist(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasespecifierlistContext extends ParserRuleContext {
		public BasespecifierContext basespecifier() {
			return getRuleContext(BasespecifierContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public BasespecifierlistContext basespecifierlist() {
			return getRuleContext(BasespecifierlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public BasespecifierlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basespecifierlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBasespecifierlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBasespecifierlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBasespecifierlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasespecifierlistContext basespecifierlist() throws RecognitionException {
		return basespecifierlist(0);
	}

	private BasespecifierlistContext basespecifierlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BasespecifierlistContext _localctx = new BasespecifierlistContext(_ctx, _parentState);
		BasespecifierlistContext _prevctx = _localctx;
		int _startState = 318;
		enterRecursionRule(_localctx, 318, RULE_basespecifierlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2099);
			basespecifier();
			setState(2101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,255,_ctx) ) {
			case 1:
				{
				setState(2100);
				match(Ellipsis);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(2111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,257,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BasespecifierlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_basespecifierlist);
					setState(2103);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2104);
					match(Comma);
					setState(2105);
					basespecifier();
					setState(2107);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,256,_ctx) ) {
					case 1:
						{
						setState(2106);
						match(Ellipsis);
						}
						break;
					}
					}
					} 
				}
				setState(2113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,257,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BasespecifierContext extends ParserRuleContext {
		public BasetypespecifierContext basetypespecifier() {
			return getRuleContext(BasetypespecifierContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public TerminalNode Virtual() { return getToken(CPP14Parser.Virtual, 0); }
		public AccessspecifierContext accessspecifier() {
			return getRuleContext(AccessspecifierContext.class,0);
		}
		public BasespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBasespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBasespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBasespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasespecifierContext basespecifier() throws RecognitionException {
		BasespecifierContext _localctx = new BasespecifierContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_basespecifier);
		int _la;
		try {
			setState(2135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,263,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(2114);
					attributespecifierseq(0);
					}
				}

				setState(2117);
				basetypespecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(2118);
					attributespecifierseq(0);
					}
				}

				setState(2121);
				match(Virtual);
				setState(2123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Private) | (1L << Protected) | (1L << Public))) != 0)) {
					{
					setState(2122);
					accessspecifier();
					}
				}

				setState(2125);
				basetypespecifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(2126);
					attributespecifierseq(0);
					}
				}

				setState(2129);
				accessspecifier();
				setState(2131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Virtual) {
					{
					setState(2130);
					match(Virtual);
					}
				}

				setState(2133);
				basetypespecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassordecltypeContext extends ParserRuleContext {
		public ClassnameContext classname() {
			return getRuleContext(ClassnameContext.class,0);
		}
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public DecltypespecifierContext decltypespecifier() {
			return getRuleContext(DecltypespecifierContext.class,0);
		}
		public ClassordecltypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classordecltype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterClassordecltype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitClassordecltype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitClassordecltype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassordecltypeContext classordecltype() throws RecognitionException {
		ClassordecltypeContext _localctx = new ClassordecltypeContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_classordecltype);
		try {
			setState(2142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,265,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
				case 1:
					{
					setState(2137);
					nestednamespecifier(0);
					}
					break;
				}
				setState(2140);
				classname();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2141);
				decltypespecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasetypespecifierContext extends ParserRuleContext {
		public ClassordecltypeContext classordecltype() {
			return getRuleContext(ClassordecltypeContext.class,0);
		}
		public BasetypespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basetypespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBasetypespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBasetypespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBasetypespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasetypespecifierContext basetypespecifier() throws RecognitionException {
		BasetypespecifierContext _localctx = new BasetypespecifierContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_basetypespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2144);
			classordecltype();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessspecifierContext extends ParserRuleContext {
		public TerminalNode Private() { return getToken(CPP14Parser.Private, 0); }
		public TerminalNode Protected() { return getToken(CPP14Parser.Protected, 0); }
		public TerminalNode Public() { return getToken(CPP14Parser.Public, 0); }
		public AccessspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterAccessspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitAccessspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitAccessspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessspecifierContext accessspecifier() throws RecognitionException {
		AccessspecifierContext _localctx = new AccessspecifierContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_accessspecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2146);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Private) | (1L << Protected) | (1L << Public))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversionfunctionidContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(CPP14Parser.Operator, 0); }
		public ConversiontypeidContext conversiontypeid() {
			return getRuleContext(ConversiontypeidContext.class,0);
		}
		public ConversionfunctionidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversionfunctionid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterConversionfunctionid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitConversionfunctionid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitConversionfunctionid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConversionfunctionidContext conversionfunctionid() throws RecognitionException {
		ConversionfunctionidContext _localctx = new ConversionfunctionidContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_conversionfunctionid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2148);
			match(Operator);
			setState(2149);
			conversiontypeid();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversiontypeidContext extends ParserRuleContext {
		public TypespecifierseqContext typespecifierseq() {
			return getRuleContext(TypespecifierseqContext.class,0);
		}
		public ConversiondeclaratorContext conversiondeclarator() {
			return getRuleContext(ConversiondeclaratorContext.class,0);
		}
		public ConversiontypeidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversiontypeid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterConversiontypeid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitConversiontypeid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitConversiontypeid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConversiontypeidContext conversiontypeid() throws RecognitionException {
		ConversiontypeidContext _localctx = new ConversiontypeidContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_conversiontypeid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2151);
			typespecifierseq();
			setState(2153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,266,_ctx) ) {
			case 1:
				{
				setState(2152);
				conversiondeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversiondeclaratorContext extends ParserRuleContext {
		public PtroperatorContext ptroperator() {
			return getRuleContext(PtroperatorContext.class,0);
		}
		public ConversiondeclaratorContext conversiondeclarator() {
			return getRuleContext(ConversiondeclaratorContext.class,0);
		}
		public ConversiondeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversiondeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterConversiondeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitConversiondeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitConversiondeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConversiondeclaratorContext conversiondeclarator() throws RecognitionException {
		ConversiondeclaratorContext _localctx = new ConversiondeclaratorContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_conversiondeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2155);
			ptroperator();
			setState(2157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				setState(2156);
				conversiondeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtorinitializerContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public MeminitializerlistContext meminitializerlist() {
			return getRuleContext(MeminitializerlistContext.class,0);
		}
		public CtorinitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctorinitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterCtorinitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitCtorinitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitCtorinitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtorinitializerContext ctorinitializer() throws RecognitionException {
		CtorinitializerContext _localctx = new CtorinitializerContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_ctorinitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2159);
			match(Colon);
			setState(2160);
			meminitializerlist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MeminitializerlistContext extends ParserRuleContext {
		public MeminitializerContext meminitializer() {
			return getRuleContext(MeminitializerContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public MeminitializerlistContext meminitializerlist() {
			return getRuleContext(MeminitializerlistContext.class,0);
		}
		public MeminitializerlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meminitializerlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterMeminitializerlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitMeminitializerlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitMeminitializerlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MeminitializerlistContext meminitializerlist() throws RecognitionException {
		MeminitializerlistContext _localctx = new MeminitializerlistContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_meminitializerlist);
		int _la;
		try {
			setState(2173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2162);
				meminitializer();
				setState(2164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(2163);
					match(Ellipsis);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2166);
				meminitializer();
				setState(2168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(2167);
					match(Ellipsis);
					}
				}

				setState(2170);
				match(Comma);
				setState(2171);
				meminitializerlist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MeminitializerContext extends ParserRuleContext {
		public MeminitializeridContext meminitializerid() {
			return getRuleContext(MeminitializeridContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public ExpressionlistContext expressionlist() {
			return getRuleContext(ExpressionlistContext.class,0);
		}
		public BracedinitlistContext bracedinitlist() {
			return getRuleContext(BracedinitlistContext.class,0);
		}
		public MeminitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meminitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterMeminitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitMeminitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitMeminitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MeminitializerContext meminitializer() throws RecognitionException {
		MeminitializerContext _localctx = new MeminitializerContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_meminitializer);
		int _la;
		try {
			setState(2185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,272,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2175);
				meminitializerid();
				setState(2176);
				match(LeftParen);
				setState(2178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (This - 64)) | (1L << (Throw - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(2177);
					expressionlist();
					}
				}

				setState(2180);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2182);
				meminitializerid();
				setState(2183);
				bracedinitlist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MeminitializeridContext extends ParserRuleContext {
		public ClassordecltypeContext classordecltype() {
			return getRuleContext(ClassordecltypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public MeminitializeridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meminitializerid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterMeminitializerid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitMeminitializerid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitMeminitializerid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MeminitializeridContext meminitializerid() throws RecognitionException {
		MeminitializeridContext _localctx = new MeminitializeridContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_meminitializerid);
		try {
			setState(2189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2187);
				classordecltype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2188);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorfunctionidContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(CPP14Parser.Operator, 0); }
		public TheoperatorContext theoperator() {
			return getRuleContext(TheoperatorContext.class,0);
		}
		public OperatorfunctionidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorfunctionid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterOperatorfunctionid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitOperatorfunctionid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitOperatorfunctionid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorfunctionidContext operatorfunctionid() throws RecognitionException {
		OperatorfunctionidContext _localctx = new OperatorfunctionidContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_operatorfunctionid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2191);
			match(Operator);
			setState(2192);
			theoperator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteraloperatoridContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(CPP14Parser.Operator, 0); }
		public TerminalNode Stringliteral() { return getToken(CPP14Parser.Stringliteral, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Userdefinedstringliteral() { return getToken(CPP14Parser.Userdefinedstringliteral, 0); }
		public LiteraloperatoridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literaloperatorid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLiteraloperatorid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLiteraloperatorid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLiteraloperatorid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteraloperatoridContext literaloperatorid() throws RecognitionException {
		LiteraloperatoridContext _localctx = new LiteraloperatoridContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_literaloperatorid);
		try {
			setState(2199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2194);
				match(Operator);
				setState(2195);
				match(Stringliteral);
				setState(2196);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2197);
				match(Operator);
				setState(2198);
				match(Userdefinedstringliteral);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplatedeclarationContext extends ParserRuleContext {
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TemplateparameterlistContext templateparameterlist() {
			return getRuleContext(TemplateparameterlistContext.class,0);
		}
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TemplatedeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templatedeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTemplatedeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTemplatedeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTemplatedeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplatedeclarationContext templatedeclaration() throws RecognitionException {
		TemplatedeclarationContext _localctx = new TemplatedeclarationContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_templatedeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2201);
			match(Template);
			setState(2202);
			match(Less);
			setState(2203);
			templateparameterlist(0);
			setState(2204);
			match(Greater);
			setState(2205);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateparameterlistContext extends ParserRuleContext {
		public TemplateparameterContext templateparameter() {
			return getRuleContext(TemplateparameterContext.class,0);
		}
		public TemplateparameterlistContext templateparameterlist() {
			return getRuleContext(TemplateparameterlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public TemplateparameterlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateparameterlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTemplateparameterlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTemplateparameterlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTemplateparameterlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateparameterlistContext templateparameterlist() throws RecognitionException {
		return templateparameterlist(0);
	}

	private TemplateparameterlistContext templateparameterlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TemplateparameterlistContext _localctx = new TemplateparameterlistContext(_ctx, _parentState);
		TemplateparameterlistContext _prevctx = _localctx;
		int _startState = 348;
		enterRecursionRule(_localctx, 348, RULE_templateparameterlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2208);
			templateparameter();
			}
			_ctx.stop = _input.LT(-1);
			setState(2215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,275,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TemplateparameterlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_templateparameterlist);
					setState(2210);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2211);
					match(Comma);
					setState(2212);
					templateparameter();
					}
					} 
				}
				setState(2217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,275,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TemplateparameterContext extends ParserRuleContext {
		public TypeparameterContext typeparameter() {
			return getRuleContext(TypeparameterContext.class,0);
		}
		public ParameterdeclarationContext parameterdeclaration() {
			return getRuleContext(ParameterdeclarationContext.class,0);
		}
		public TemplateparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateparameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTemplateparameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTemplateparameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTemplateparameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateparameterContext templateparameter() throws RecognitionException {
		TemplateparameterContext _localctx = new TemplateparameterContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_templateparameter);
		try {
			setState(2220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,276,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2218);
				typeparameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2219);
				parameterdeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeparameterContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(CPP14Parser.Class, 0); }
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public ThetypeidContext thetypeid() {
			return getRuleContext(ThetypeidContext.class,0);
		}
		public TerminalNode Typename_() { return getToken(CPP14Parser.Typename_, 0); }
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TemplateparameterlistContext templateparameterlist() {
			return getRuleContext(TemplateparameterlistContext.class,0);
		}
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public IdexpressionContext idexpression() {
			return getRuleContext(IdexpressionContext.class,0);
		}
		public TypeparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeparameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTypeparameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTypeparameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTypeparameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeparameterContext typeparameter() throws RecognitionException {
		TypeparameterContext _localctx = new TypeparameterContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_typeparameter);
		int _la;
		try {
			setState(2270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,286,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2222);
				match(Class);
				setState(2224);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,277,_ctx) ) {
				case 1:
					{
					setState(2223);
					match(Ellipsis);
					}
					break;
				}
				setState(2227);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,278,_ctx) ) {
				case 1:
					{
					setState(2226);
					match(Identifier);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2229);
				match(Class);
				setState(2231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(2230);
					match(Identifier);
					}
				}

				setState(2233);
				match(Assign);
				setState(2234);
				thetypeid();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2235);
				match(Typename_);
				setState(2237);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,280,_ctx) ) {
				case 1:
					{
					setState(2236);
					match(Ellipsis);
					}
					break;
				}
				setState(2240);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,281,_ctx) ) {
				case 1:
					{
					setState(2239);
					match(Identifier);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2242);
				match(Typename_);
				setState(2244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(2243);
					match(Identifier);
					}
				}

				setState(2246);
				match(Assign);
				setState(2247);
				thetypeid();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2248);
				match(Template);
				setState(2249);
				match(Less);
				setState(2250);
				templateparameterlist(0);
				setState(2251);
				match(Greater);
				setState(2252);
				match(Class);
				setState(2254);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,283,_ctx) ) {
				case 1:
					{
					setState(2253);
					match(Ellipsis);
					}
					break;
				}
				setState(2257);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,284,_ctx) ) {
				case 1:
					{
					setState(2256);
					match(Identifier);
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2259);
				match(Template);
				setState(2260);
				match(Less);
				setState(2261);
				templateparameterlist(0);
				setState(2262);
				match(Greater);
				setState(2263);
				match(Class);
				setState(2265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(2264);
					match(Identifier);
					}
				}

				setState(2267);
				match(Assign);
				setState(2268);
				idexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpletemplateidContext extends ParserRuleContext {
		public TemplatenameContext templatename() {
			return getRuleContext(TemplatenameContext.class,0);
		}
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public TemplateargumentlistContext templateargumentlist() {
			return getRuleContext(TemplateargumentlistContext.class,0);
		}
		public SimpletemplateidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpletemplateid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterSimpletemplateid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitSimpletemplateid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitSimpletemplateid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpletemplateidContext simpletemplateid() throws RecognitionException {
		SimpletemplateidContext _localctx = new SimpletemplateidContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_simpletemplateid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2272);
			templatename();
			setState(2273);
			match(Less);
			setState(2275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (This - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
				{
				setState(2274);
				templateargumentlist(0);
				}
			}

			setState(2277);
			match(Greater);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateidContext extends ParserRuleContext {
		public SimpletemplateidContext simpletemplateid() {
			return getRuleContext(SimpletemplateidContext.class,0);
		}
		public OperatorfunctionidContext operatorfunctionid() {
			return getRuleContext(OperatorfunctionidContext.class,0);
		}
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public TemplateargumentlistContext templateargumentlist() {
			return getRuleContext(TemplateargumentlistContext.class,0);
		}
		public LiteraloperatoridContext literaloperatorid() {
			return getRuleContext(LiteraloperatoridContext.class,0);
		}
		public TemplateidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTemplateid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTemplateid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTemplateid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateidContext templateid() throws RecognitionException {
		TemplateidContext _localctx = new TemplateidContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_templateid);
		int _la;
		try {
			setState(2294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2279);
				simpletemplateid();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2280);
				operatorfunctionid();
				setState(2281);
				match(Less);
				setState(2283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (This - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(2282);
					templateargumentlist(0);
					}
				}

				setState(2285);
				match(Greater);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2287);
				literaloperatorid();
				setState(2288);
				match(Less);
				setState(2290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << False) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Reinterpret_cast))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Short - 64)) | (1L << (Signed - 64)) | (1L << (Sizeof - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (This - 64)) | (1L << (True - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (Doublecolon - 133)) | (1L << (Identifier - 133)) | (1L << (Integerliteral - 133)) | (1L << (Characterliteral - 133)) | (1L << (Floatingliteral - 133)) | (1L << (Stringliteral - 133)) | (1L << (Userdefinedintegerliteral - 133)) | (1L << (Userdefinedfloatingliteral - 133)) | (1L << (Userdefinedstringliteral - 133)) | (1L << (Userdefinedcharacterliteral - 133)))) != 0)) {
					{
					setState(2289);
					templateargumentlist(0);
					}
				}

				setState(2292);
				match(Greater);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplatenameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TemplatenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templatename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTemplatename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTemplatename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTemplatename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplatenameContext templatename() throws RecognitionException {
		TemplatenameContext _localctx = new TemplatenameContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_templatename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2296);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateargumentlistContext extends ParserRuleContext {
		public TemplateargumentContext templateargument() {
			return getRuleContext(TemplateargumentContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public TemplateargumentlistContext templateargumentlist() {
			return getRuleContext(TemplateargumentlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public TemplateargumentlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateargumentlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTemplateargumentlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTemplateargumentlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTemplateargumentlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateargumentlistContext templateargumentlist() throws RecognitionException {
		return templateargumentlist(0);
	}

	private TemplateargumentlistContext templateargumentlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TemplateargumentlistContext _localctx = new TemplateargumentlistContext(_ctx, _parentState);
		TemplateargumentlistContext _prevctx = _localctx;
		int _startState = 360;
		enterRecursionRule(_localctx, 360, RULE_templateargumentlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2299);
			templateargument();
			setState(2301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
			case 1:
				{
				setState(2300);
				match(Ellipsis);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(2311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,293,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TemplateargumentlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_templateargumentlist);
					setState(2303);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2304);
					match(Comma);
					setState(2305);
					templateargument();
					setState(2307);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
					case 1:
						{
						setState(2306);
						match(Ellipsis);
						}
						break;
					}
					}
					} 
				}
				setState(2313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,293,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TemplateargumentContext extends ParserRuleContext {
		public ThetypeidContext thetypeid() {
			return getRuleContext(ThetypeidContext.class,0);
		}
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public IdexpressionContext idexpression() {
			return getRuleContext(IdexpressionContext.class,0);
		}
		public TemplateargumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateargument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTemplateargument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTemplateargument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTemplateargument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateargumentContext templateargument() throws RecognitionException {
		TemplateargumentContext _localctx = new TemplateargumentContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_templateargument);
		try {
			setState(2317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2314);
				thetypeid();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2315);
				constantexpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2316);
				idexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypenamespecifierContext extends ParserRuleContext {
		public TerminalNode Typename_() { return getToken(CPP14Parser.Typename_, 0); }
		public NestednamespecifierContext nestednamespecifier() {
			return getRuleContext(NestednamespecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public SimpletemplateidContext simpletemplateid() {
			return getRuleContext(SimpletemplateidContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TypenamespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typenamespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTypenamespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTypenamespecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTypenamespecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypenamespecifierContext typenamespecifier() throws RecognitionException {
		TypenamespecifierContext _localctx = new TypenamespecifierContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_typenamespecifier);
		int _la;
		try {
			setState(2330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2319);
				match(Typename_);
				setState(2320);
				nestednamespecifier(0);
				setState(2321);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2323);
				match(Typename_);
				setState(2324);
				nestednamespecifier(0);
				setState(2326);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Template) {
					{
					setState(2325);
					match(Template);
					}
				}

				setState(2328);
				simpletemplateid();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitinstantiationContext extends ParserRuleContext {
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Extern() { return getToken(CPP14Parser.Extern, 0); }
		public ExplicitinstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitinstantiation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterExplicitinstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitExplicitinstantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitExplicitinstantiation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitinstantiationContext explicitinstantiation() throws RecognitionException {
		ExplicitinstantiationContext _localctx = new ExplicitinstantiationContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_explicitinstantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Extern) {
				{
				setState(2332);
				match(Extern);
				}
			}

			setState(2335);
			match(Template);
			setState(2336);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitspecializationContext extends ParserRuleContext {
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExplicitspecializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitspecialization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterExplicitspecialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitExplicitspecialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitExplicitspecialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitspecializationContext explicitspecialization() throws RecognitionException {
		ExplicitspecializationContext _localctx = new ExplicitspecializationContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_explicitspecialization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2338);
			match(Template);
			setState(2339);
			match(Less);
			setState(2340);
			match(Greater);
			setState(2341);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryblockContext extends ParserRuleContext {
		public TerminalNode Try() { return getToken(CPP14Parser.Try, 0); }
		public CompoundstatementContext compoundstatement() {
			return getRuleContext(CompoundstatementContext.class,0);
		}
		public HandlerseqContext handlerseq() {
			return getRuleContext(HandlerseqContext.class,0);
		}
		public TryblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTryblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTryblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTryblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryblockContext tryblock() throws RecognitionException {
		TryblockContext _localctx = new TryblockContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_tryblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2343);
			match(Try);
			setState(2344);
			compoundstatement();
			setState(2345);
			handlerseq();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiontryblockContext extends ParserRuleContext {
		public TerminalNode Try() { return getToken(CPP14Parser.Try, 0); }
		public CompoundstatementContext compoundstatement() {
			return getRuleContext(CompoundstatementContext.class,0);
		}
		public HandlerseqContext handlerseq() {
			return getRuleContext(HandlerseqContext.class,0);
		}
		public CtorinitializerContext ctorinitializer() {
			return getRuleContext(CtorinitializerContext.class,0);
		}
		public FunctiontryblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiontryblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterFunctiontryblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitFunctiontryblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitFunctiontryblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiontryblockContext functiontryblock() throws RecognitionException {
		FunctiontryblockContext _localctx = new FunctiontryblockContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_functiontryblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2347);
			match(Try);
			setState(2349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(2348);
				ctorinitializer();
				}
			}

			setState(2351);
			compoundstatement();
			setState(2352);
			handlerseq();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HandlerseqContext extends ParserRuleContext {
		public HandlerContext handler() {
			return getRuleContext(HandlerContext.class,0);
		}
		public HandlerseqContext handlerseq() {
			return getRuleContext(HandlerseqContext.class,0);
		}
		public HandlerseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handlerseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterHandlerseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitHandlerseq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitHandlerseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HandlerseqContext handlerseq() throws RecognitionException {
		HandlerseqContext _localctx = new HandlerseqContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_handlerseq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2354);
			handler();
			setState(2356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,299,_ctx) ) {
			case 1:
				{
				setState(2355);
				handlerseq();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HandlerContext extends ParserRuleContext {
		public TerminalNode Catch() { return getToken(CPP14Parser.Catch, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExceptiondeclarationContext exceptiondeclaration() {
			return getRuleContext(ExceptiondeclarationContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public CompoundstatementContext compoundstatement() {
			return getRuleContext(CompoundstatementContext.class,0);
		}
		public HandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handler; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitHandler(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HandlerContext handler() throws RecognitionException {
		HandlerContext _localctx = new HandlerContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_handler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2358);
			match(Catch);
			setState(2359);
			match(LeftParen);
			setState(2360);
			exceptiondeclaration();
			setState(2361);
			match(RightParen);
			setState(2362);
			compoundstatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptiondeclarationContext extends ParserRuleContext {
		public TypespecifierseqContext typespecifierseq() {
			return getRuleContext(TypespecifierseqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AttributespecifierseqContext attributespecifierseq() {
			return getRuleContext(AttributespecifierseqContext.class,0);
		}
		public AbstractdeclaratorContext abstractdeclarator() {
			return getRuleContext(AbstractdeclaratorContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public ExceptiondeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptiondeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterExceptiondeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitExceptiondeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitExceptiondeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptiondeclarationContext exceptiondeclaration() throws RecognitionException {
		ExceptiondeclarationContext _localctx = new ExceptiondeclarationContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_exceptiondeclaration);
		int _la;
		try {
			setState(2378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,303,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(2364);
					attributespecifierseq(0);
					}
				}

				setState(2367);
				typespecifierseq();
				setState(2368);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(2370);
					attributespecifierseq(0);
					}
				}

				setState(2373);
				typespecifierseq();
				setState(2375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (LeftParen - 89)) | (1L << (LeftBracket - 89)) | (1L << (Star - 89)) | (1L << (And - 89)) | (1L << (AndAnd - 89)) | (1L << (Doublecolon - 89)) | (1L << (Ellipsis - 89)) | (1L << (Identifier - 89)))) != 0)) {
					{
					setState(2374);
					abstractdeclarator();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2377);
				match(Ellipsis);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowexpressionContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(CPP14Parser.Throw, 0); }
		public AssignmentexpressionContext assignmentexpression() {
			return getRuleContext(AssignmentexpressionContext.class,0);
		}
		public ThrowexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterThrowexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitThrowexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitThrowexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowexpressionContext throwexpression() throws RecognitionException {
		ThrowexpressionContext _localctx = new ThrowexpressionContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_throwexpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2380);
			match(Throw);
			setState(2382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
			case 1:
				{
				setState(2381);
				assignmentexpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionspecificationContext extends ParserRuleContext {
		public DynamicexceptionspecificationContext dynamicexceptionspecification() {
			return getRuleContext(DynamicexceptionspecificationContext.class,0);
		}
		public NoexceptspecificationContext noexceptspecification() {
			return getRuleContext(NoexceptspecificationContext.class,0);
		}
		public ExceptionspecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionspecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterExceptionspecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitExceptionspecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitExceptionspecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptionspecificationContext exceptionspecification() throws RecognitionException {
		ExceptionspecificationContext _localctx = new ExceptionspecificationContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_exceptionspecification);
		try {
			setState(2386);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Throw:
				enterOuterAlt(_localctx, 1);
				{
				setState(2384);
				dynamicexceptionspecification();
				}
				break;
			case Noexcept:
				enterOuterAlt(_localctx, 2);
				{
				setState(2385);
				noexceptspecification();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DynamicexceptionspecificationContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(CPP14Parser.Throw, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TypeidlistContext typeidlist() {
			return getRuleContext(TypeidlistContext.class,0);
		}
		public DynamicexceptionspecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dynamicexceptionspecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDynamicexceptionspecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDynamicexceptionspecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDynamicexceptionspecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DynamicexceptionspecificationContext dynamicexceptionspecification() throws RecognitionException {
		DynamicexceptionspecificationContext _localctx = new DynamicexceptionspecificationContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_dynamicexceptionspecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2388);
			match(Throw);
			setState(2389);
			match(LeftParen);
			setState(2391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (Auto - 17)) | (1L << (Bool - 17)) | (1L << (Char - 17)) | (1L << (Char16 - 17)) | (1L << (Char32 - 17)) | (1L << (Class - 17)) | (1L << (Const - 17)) | (1L << (Decltype - 17)) | (1L << (Double - 17)) | (1L << (Enum - 17)) | (1L << (Float - 17)) | (1L << (Int - 17)) | (1L << (Long - 17)) | (1L << (Short - 17)) | (1L << (Signed - 17)) | (1L << (Struct - 17)) | (1L << (Typename_ - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (Union - 81)) | (1L << (Unsigned - 81)) | (1L << (Void - 81)) | (1L << (Volatile - 81)) | (1L << (Wchar - 81)) | (1L << (Doublecolon - 81)) | (1L << (Identifier - 81)))) != 0)) {
				{
				setState(2390);
				typeidlist(0);
				}
			}

			setState(2393);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeidlistContext extends ParserRuleContext {
		public ThetypeidContext thetypeid() {
			return getRuleContext(ThetypeidContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public TypeidlistContext typeidlist() {
			return getRuleContext(TypeidlistContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public TypeidlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeidlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTypeidlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTypeidlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTypeidlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeidlistContext typeidlist() throws RecognitionException {
		return typeidlist(0);
	}

	private TypeidlistContext typeidlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeidlistContext _localctx = new TypeidlistContext(_ctx, _parentState);
		TypeidlistContext _prevctx = _localctx;
		int _startState = 386;
		enterRecursionRule(_localctx, 386, RULE_typeidlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2396);
			thetypeid();
			setState(2398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,307,_ctx) ) {
			case 1:
				{
				setState(2397);
				match(Ellipsis);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(2408);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,309,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeidlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeidlist);
					setState(2400);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2401);
					match(Comma);
					setState(2402);
					thetypeid();
					setState(2404);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,308,_ctx) ) {
					case 1:
						{
						setState(2403);
						match(Ellipsis);
						}
						break;
					}
					}
					} 
				}
				setState(2410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,309,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NoexceptspecificationContext extends ParserRuleContext {
		public TerminalNode Noexcept() { return getToken(CPP14Parser.Noexcept, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NoexceptspecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noexceptspecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterNoexceptspecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitNoexceptspecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitNoexceptspecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoexceptspecificationContext noexceptspecification() throws RecognitionException {
		NoexceptspecificationContext _localctx = new NoexceptspecificationContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_noexceptspecification);
		try {
			setState(2417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,310,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2411);
				match(Noexcept);
				setState(2412);
				match(LeftParen);
				setState(2413);
				constantexpression();
				setState(2414);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2416);
				match(Noexcept);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineDeclarationContext extends ParserRuleContext {
		public TerminalNode DefineDirective() { return getToken(CPP14Parser.DefineDirective, 0); }
		public DefineDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterDefineDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitDefineDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitDefineDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineDeclarationContext defineDeclaration() throws RecognitionException {
		DefineDeclarationContext _localctx = new DefineDeclarationContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_defineDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2419);
			match(DefineDirective);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeDeclarationContext extends ParserRuleContext {
		public TerminalNode IncludeDirective() { return getToken(CPP14Parser.IncludeDirective, 0); }
		public IncludeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterIncludeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitIncludeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitIncludeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeDeclarationContext includeDeclaration() throws RecognitionException {
		IncludeDeclarationContext _localctx = new IncludeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_includeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2421);
			match(IncludeDirective);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TheoperatorContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(CPP14Parser.New, 0); }
		public TerminalNode Delete() { return getToken(CPP14Parser.Delete, 0); }
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public TerminalNode Plus() { return getToken(CPP14Parser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CPP14Parser.Minus, 0); }
		public TerminalNode Star() { return getToken(CPP14Parser.Star, 0); }
		public TerminalNode Div() { return getToken(CPP14Parser.Div, 0); }
		public TerminalNode Mod() { return getToken(CPP14Parser.Mod, 0); }
		public TerminalNode Caret() { return getToken(CPP14Parser.Caret, 0); }
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode Or() { return getToken(CPP14Parser.Or, 0); }
		public TerminalNode Tilde() { return getToken(CPP14Parser.Tilde, 0); }
		public TerminalNode Not() { return getToken(CPP14Parser.Not, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public TerminalNode PlusAssign() { return getToken(CPP14Parser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(CPP14Parser.MinusAssign, 0); }
		public TerminalNode StarAssign() { return getToken(CPP14Parser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(CPP14Parser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(CPP14Parser.ModAssign, 0); }
		public TerminalNode XorAssign() { return getToken(CPP14Parser.XorAssign, 0); }
		public TerminalNode AndAssign() { return getToken(CPP14Parser.AndAssign, 0); }
		public TerminalNode OrAssign() { return getToken(CPP14Parser.OrAssign, 0); }
		public TerminalNode LeftShift() { return getToken(CPP14Parser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(CPP14Parser.RightShift, 0); }
		public TerminalNode RightShiftAssign() { return getToken(CPP14Parser.RightShiftAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(CPP14Parser.LeftShiftAssign, 0); }
		public TerminalNode Equal() { return getToken(CPP14Parser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(CPP14Parser.NotEqual, 0); }
		public TerminalNode LessEqual() { return getToken(CPP14Parser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(CPP14Parser.GreaterEqual, 0); }
		public TerminalNode AndAnd() { return getToken(CPP14Parser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(CPP14Parser.OrOr, 0); }
		public TerminalNode PlusPlus() { return getToken(CPP14Parser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPP14Parser.MinusMinus, 0); }
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public TerminalNode ArrowStar() { return getToken(CPP14Parser.ArrowStar, 0); }
		public TerminalNode Arrow() { return getToken(CPP14Parser.Arrow, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TheoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theoperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterTheoperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitTheoperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitTheoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TheoperatorContext theoperator() throws RecognitionException {
		TheoperatorContext _localctx = new TheoperatorContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_theoperator);
		try {
			setState(2471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,311,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2423);
				match(New);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2424);
				match(Delete);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2425);
				match(New);
				setState(2426);
				match(LeftBracket);
				setState(2427);
				match(RightBracket);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2428);
				match(Delete);
				setState(2429);
				match(LeftBracket);
				setState(2430);
				match(RightBracket);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2431);
				match(Plus);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2432);
				match(Minus);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2433);
				match(Star);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2434);
				match(Div);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2435);
				match(Mod);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2436);
				match(Caret);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2437);
				match(And);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2438);
				match(Or);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(2439);
				match(Tilde);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(2440);
				match(Not);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(2441);
				match(Assign);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(2442);
				match(Less);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(2443);
				match(Greater);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(2444);
				match(PlusAssign);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(2445);
				match(MinusAssign);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(2446);
				match(StarAssign);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(2447);
				match(DivAssign);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(2448);
				match(ModAssign);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(2449);
				match(XorAssign);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(2450);
				match(AndAssign);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(2451);
				match(OrAssign);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(2452);
				match(LeftShift);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(2453);
				match(RightShift);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(2454);
				match(RightShiftAssign);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(2455);
				match(LeftShiftAssign);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(2456);
				match(Equal);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(2457);
				match(NotEqual);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(2458);
				match(LessEqual);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(2459);
				match(GreaterEqual);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(2460);
				match(AndAnd);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(2461);
				match(OrOr);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(2462);
				match(PlusPlus);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(2463);
				match(MinusMinus);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(2464);
				match(Comma);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(2465);
				match(ArrowStar);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(2466);
				match(Arrow);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(2467);
				match(LeftParen);
				setState(2468);
				match(RightParen);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(2469);
				match(LeftBracket);
				setState(2470);
				match(RightBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode Integerliteral() { return getToken(CPP14Parser.Integerliteral, 0); }
		public TerminalNode Characterliteral() { return getToken(CPP14Parser.Characterliteral, 0); }
		public TerminalNode Floatingliteral() { return getToken(CPP14Parser.Floatingliteral, 0); }
		public List<TerminalNode> Stringliteral() { return getTokens(CPP14Parser.Stringliteral); }
		public TerminalNode Stringliteral(int i) {
			return getToken(CPP14Parser.Stringliteral, i);
		}
		public BooleanliteralContext booleanliteral() {
			return getRuleContext(BooleanliteralContext.class,0);
		}
		public PointerliteralContext pointerliteral() {
			return getRuleContext(PointerliteralContext.class,0);
		}
		public UserdefinedliteralContext userdefinedliteral() {
			return getRuleContext(UserdefinedliteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_literal);
		try {
			int _alt;
			setState(2484);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integerliteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(2473);
				match(Integerliteral);
				}
				break;
			case Characterliteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(2474);
				match(Characterliteral);
				}
				break;
			case Floatingliteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(2475);
				match(Floatingliteral);
				}
				break;
			case Stringliteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(2477); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2476);
						match(Stringliteral);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2479); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,312,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case False:
			case True:
				enterOuterAlt(_localctx, 5);
				{
				setState(2481);
				booleanliteral();
				}
				break;
			case Nullptr:
				enterOuterAlt(_localctx, 6);
				{
				setState(2482);
				pointerliteral();
				}
				break;
			case Userdefinedintegerliteral:
			case Userdefinedfloatingliteral:
			case Userdefinedstringliteral:
			case Userdefinedcharacterliteral:
				enterOuterAlt(_localctx, 7);
				{
				setState(2483);
				userdefinedliteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanliteralContext extends ParserRuleContext {
		public TerminalNode False() { return getToken(CPP14Parser.False, 0); }
		public TerminalNode True() { return getToken(CPP14Parser.True, 0); }
		public BooleanliteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanliteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterBooleanliteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitBooleanliteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitBooleanliteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanliteralContext booleanliteral() throws RecognitionException {
		BooleanliteralContext _localctx = new BooleanliteralContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_booleanliteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2486);
			_la = _input.LA(1);
			if ( !(_la==False || _la==True) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerliteralContext extends ParserRuleContext {
		public TerminalNode Nullptr() { return getToken(CPP14Parser.Nullptr, 0); }
		public PointerliteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerliteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterPointerliteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitPointerliteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitPointerliteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerliteralContext pointerliteral() throws RecognitionException {
		PointerliteralContext _localctx = new PointerliteralContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_pointerliteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2488);
			match(Nullptr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UserdefinedliteralContext extends ParserRuleContext {
		public TerminalNode Userdefinedintegerliteral() { return getToken(CPP14Parser.Userdefinedintegerliteral, 0); }
		public TerminalNode Userdefinedfloatingliteral() { return getToken(CPP14Parser.Userdefinedfloatingliteral, 0); }
		public TerminalNode Userdefinedstringliteral() { return getToken(CPP14Parser.Userdefinedstringliteral, 0); }
		public TerminalNode Userdefinedcharacterliteral() { return getToken(CPP14Parser.Userdefinedcharacterliteral, 0); }
		public UserdefinedliteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userdefinedliteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).enterUserdefinedliteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPP14Listener ) ((CPP14Listener)listener).exitUserdefinedliteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPP14Visitor ) return ((CPP14Visitor<? extends T>)visitor).visitUserdefinedliteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserdefinedliteralContext userdefinedliteral() throws RecognitionException {
		UserdefinedliteralContext _localctx = new UserdefinedliteralContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_userdefinedliteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2490);
			_la = _input.LA(1);
			if ( !(((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (Userdefinedintegerliteral - 148)) | (1L << (Userdefinedfloatingliteral - 148)) | (1L << (Userdefinedstringliteral - 148)) | (1L << (Userdefinedcharacterliteral - 148)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return nestednamespecifier_sempred((NestednamespecifierContext)_localctx, predIndex);
		case 10:
			return capturelist_sempred((CapturelistContext)_localctx, predIndex);
		case 15:
			return postfixexpression_sempred((PostfixexpressionContext)_localctx, predIndex);
		case 26:
			return noptrnewdeclarator_sempred((NoptrnewdeclaratorContext)_localctx, predIndex);
		case 31:
			return pmexpression_sempred((PmexpressionContext)_localctx, predIndex);
		case 32:
			return multiplicativeexpression_sempred((MultiplicativeexpressionContext)_localctx, predIndex);
		case 33:
			return additiveexpression_sempred((AdditiveexpressionContext)_localctx, predIndex);
		case 34:
			return shiftexpression_sempred((ShiftexpressionContext)_localctx, predIndex);
		case 36:
			return relationalexpression_sempred((RelationalexpressionContext)_localctx, predIndex);
		case 37:
			return equalityexpression_sempred((EqualityexpressionContext)_localctx, predIndex);
		case 38:
			return andexpression_sempred((AndexpressionContext)_localctx, predIndex);
		case 39:
			return exclusiveorexpression_sempred((ExclusiveorexpressionContext)_localctx, predIndex);
		case 40:
			return inclusiveorexpression_sempred((InclusiveorexpressionContext)_localctx, predIndex);
		case 41:
			return logicalandexpression_sempred((LogicalandexpressionContext)_localctx, predIndex);
		case 42:
			return logicalorexpression_sempred((LogicalorexpressionContext)_localctx, predIndex);
		case 46:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 52:
			return statementseq_sempred((StatementseqContext)_localctx, predIndex);
		case 61:
			return declarationseq_sempred((DeclarationseqContext)_localctx, predIndex);
		case 88:
			return enumeratorlist_sempred((EnumeratorlistContext)_localctx, predIndex);
		case 106:
			return attributespecifierseq_sempred((AttributespecifierseqContext)_localctx, predIndex);
		case 109:
			return attributelist_sempred((AttributelistContext)_localctx, predIndex);
		case 115:
			return balancedtokenseq_sempred((BalancedtokenseqContext)_localctx, predIndex);
		case 117:
			return initdeclaratorlist_sempred((InitdeclaratorlistContext)_localctx, predIndex);
		case 121:
			return noptrdeclarator_sempred((NoptrdeclaratorContext)_localctx, predIndex);
		case 132:
			return noptrabstractdeclarator_sempred((NoptrabstractdeclaratorContext)_localctx, predIndex);
		case 134:
			return noptrabstractpackdeclarator_sempred((NoptrabstractpackdeclaratorContext)_localctx, predIndex);
		case 136:
			return parameterdeclarationlist_sempred((ParameterdeclarationlistContext)_localctx, predIndex);
		case 143:
			return initializerlist_sempred((InitializerlistContext)_localctx, predIndex);
		case 153:
			return memberdeclaratorlist_sempred((MemberdeclaratorlistContext)_localctx, predIndex);
		case 155:
			return virtspecifierseq_sempred((VirtspecifierseqContext)_localctx, predIndex);
		case 159:
			return basespecifierlist_sempred((BasespecifierlistContext)_localctx, predIndex);
		case 174:
			return templateparameterlist_sempred((TemplateparameterlistContext)_localctx, predIndex);
		case 180:
			return templateargumentlist_sempred((TemplateargumentlistContext)_localctx, predIndex);
		case 193:
			return typeidlist_sempred((TypeidlistContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean nestednamespecifier_sempred(NestednamespecifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean capturelist_sempred(CapturelistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfixexpression_sempred(PostfixexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 19);
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 8);
		case 11:
			return precpred(_ctx, 7);
		}
		return true;
	}
	private boolean noptrnewdeclarator_sempred(NoptrnewdeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean pmexpression_sempred(PmexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeexpression_sempred(MultiplicativeexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 3);
		case 16:
			return precpred(_ctx, 2);
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveexpression_sempred(AdditiveexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shiftexpression_sempred(ShiftexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalexpression_sempred(RelationalexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return precpred(_ctx, 4);
		case 22:
			return precpred(_ctx, 3);
		case 23:
			return precpred(_ctx, 2);
		case 24:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityexpression_sempred(EqualityexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 25:
			return precpred(_ctx, 2);
		case 26:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andexpression_sempred(AndexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 27:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exclusiveorexpression_sempred(ExclusiveorexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 28:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inclusiveorexpression_sempred(InclusiveorexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 29:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalandexpression_sempred(LogicalandexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 30:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalorexpression_sempred(LogicalorexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 31:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 32:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean statementseq_sempred(StatementseqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 33:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean declarationseq_sempred(DeclarationseqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 34:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean enumeratorlist_sempred(EnumeratorlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 35:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean attributespecifierseq_sempred(AttributespecifierseqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 36:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean attributelist_sempred(AttributelistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 37:
			return precpred(_ctx, 3);
		case 38:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean balancedtokenseq_sempred(BalancedtokenseqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 39:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean initdeclaratorlist_sempred(InitdeclaratorlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 40:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean noptrdeclarator_sempred(NoptrdeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 41:
			return precpred(_ctx, 3);
		case 42:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean noptrabstractdeclarator_sempred(NoptrabstractdeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 43:
			return precpred(_ctx, 5);
		case 44:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean noptrabstractpackdeclarator_sempred(NoptrabstractpackdeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 45:
			return precpred(_ctx, 3);
		case 46:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean parameterdeclarationlist_sempred(ParameterdeclarationlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 47:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean initializerlist_sempred(InitializerlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 48:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean memberdeclaratorlist_sempred(MemberdeclaratorlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 49:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean virtspecifierseq_sempred(VirtspecifierseqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 50:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean basespecifierlist_sempred(BasespecifierlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 51:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean templateparameterlist_sempred(TemplateparameterlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 52:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean templateargumentlist_sempred(TemplateargumentlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 53:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean typeidlist_sempred(TypeidlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 54:
			return precpred(_ctx, 1);
		}
		return true;
	}

	private static final int _serializedATNSegments = 2;
	private static final String _serializedATNSegment0 =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u009d\u09bf\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"+
		"\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"+
		"\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"+
		"\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8\t\u00c8"+
		"\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\3\2\5\2\u0198\n\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u01a4\n\3\3\4\3\4\5\4\u01a8\n"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u01b3\n\5\3\6\3\6\5\6\u01b7"+
		"\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u01c6\n\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7\u01cd\n\7\3\7\3\7\3\7\7\7\u01d2\n\7\f\7\16\7"+
		"\u01d5\13\7\3\b\3\b\5\b\u01d9\n\b\3\b\3\b\3\t\3\t\5\t\u01df\n\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u01e9\n\n\3\13\3\13\3\f\3\f\3\f\5\f\u01f0"+
		"\n\f\3\f\3\f\3\f\3\f\5\f\u01f6\n\f\7\f\u01f8\n\f\f\f\16\f\u01fb\13\f\3"+
		"\r\3\r\5\r\u01ff\n\r\3\16\3\16\3\16\3\16\5\16\u0205\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u020c\n\17\3\20\3\20\3\20\3\20\5\20\u0212\n\20\3\20\5"+
		"\20\u0215\n\20\3\20\5\20\u0218\n\20\3\20\5\20\u021b\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u0222\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u0229\n\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u025d\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u026c\n\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0272\n\21\3\21\3\21\3\21\3\21\5\21\u0278\n\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0285\n\21"+
		"\f\21\16\21\u0288\13\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\5\25\u0291"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u02a0\n\25\3\25\3\25\3\25\3\25\5\25\u02a6\n\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u02c4\n\26"+
		"\3\27\3\27\3\30\5\30\u02c9\n\30\3\30\3\30\5\30\u02cd\n\30\3\30\3\30\5"+
		"\30\u02d1\n\30\3\30\5\30\u02d4\n\30\3\30\3\30\5\30\u02d8\n\30\3\30\3\30"+
		"\3\30\3\30\5\30\u02de\n\30\5\30\u02e0\n\30\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\5\32\u02e8\n\32\3\33\3\33\5\33\u02ec\n\33\3\33\5\33\u02ef\n\33\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u02f6\n\34\3\34\3\34\3\34\3\34\3\34\5\34\u02fd"+
		"\n\34\7\34\u02ff\n\34\f\34\16\34\u0302\13\34\3\35\3\35\5\35\u0306\n\35"+
		"\3\35\3\35\5\35\u030a\n\35\3\36\5\36\u030d\n\36\3\36\3\36\3\36\5\36\u0312"+
		"\n\36\3\36\3\36\3\36\3\36\5\36\u0318\n\36\3\37\3\37\3\37\3\37\3\37\3 "+
		"\3 \3 \3 \3 \3 \5 \u0325\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0330\n!\f!"+
		"\16!\u0333\13!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0341"+
		"\n\"\f\"\16\"\u0344\13\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u034f\n#\f#\16"+
		"#\u0352\13#\3$\3$\3$\3$\3$\3$\3$\7$\u035b\n$\f$\16$\u035e\13$\3%\3%\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u0371\n&\f&\16&\u0374\13"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u037f\n\'\f\'\16\'\u0382\13"+
		"\'\3(\3(\3(\3(\3(\3(\7(\u038a\n(\f(\16(\u038d\13(\3)\3)\3)\3)\3)\3)\7"+
		")\u0395\n)\f)\16)\u0398\13)\3*\3*\3*\3*\3*\3*\7*\u03a0\n*\f*\16*\u03a3"+
		"\13*\3+\3+\3+\3+\3+\3+\7+\u03ab\n+\f+\16+\u03ae\13+\3,\3,\3,\3,\3,\3,"+
		"\7,\u03b6\n,\f,\16,\u03b9\13,\3-\3-\3-\3-\3-\3-\3-\5-\u03c2\n-\3.\3.\3"+
		".\3.\3.\3.\5.\u03ca\n.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\7\60\u03d4"+
		"\n\60\f\60\16\60\u03d7\13\60\3\61\3\61\3\62\3\62\5\62\u03dd\n\62\3\62"+
		"\3\62\5\62\u03e1\n\62\3\62\3\62\5\62\u03e5\n\62\3\62\3\62\5\62\u03e9\n"+
		"\62\3\62\3\62\5\62\u03ed\n\62\3\62\3\62\3\62\5\62\u03f2\n\62\3\62\5\62"+
		"\u03f5\n\62\3\63\5\63\u03f8\n\63\3\63\3\63\3\63\3\63\5\63\u03fe\n\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\5\63\u0406\n\63\3\63\3\63\3\63\5\63\u040b"+
		"\n\63\3\64\5\64\u040e\n\64\3\64\3\64\3\65\3\65\5\65\u0414\n\65\3\65\3"+
		"\65\3\66\3\66\3\66\3\66\3\66\7\66\u041d\n\66\f\66\16\66\u0420\13\66\3"+
		"\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\3\67\5\67\u0436\n\67\38\38\58\u043a\n8\38\38\3"+
		"8\38\38\38\58\u0442\n8\38\38\38\38\58\u0448\n8\39\39\39\39\39\39\39\3"+
		"9\39\39\39\39\39\39\39\39\39\39\59\u045c\n9\39\39\59\u0460\n9\39\39\3"+
		"9\39\39\39\39\39\39\39\39\59\u046d\n9\3:\3:\5:\u0471\n:\3;\5;\u0474\n"+
		";\3;\3;\3;\3<\3<\5<\u047b\n<\3=\3=\3=\3=\3=\3=\5=\u0483\n=\3=\3=\3=\3"+
		"=\3=\3=\3=\3=\5=\u048d\n=\3>\3>\3?\3?\3?\3?\3?\7?\u0496\n?\f?\16?\u0499"+
		"\13?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u04a6\n@\3A\3A\3A\3A\3A\3A\3"+
		"A\3A\5A\u04b0\nA\3B\3B\3B\5B\u04b5\nB\3B\3B\3B\3B\3C\5C\u04bc\nC\3C\5"+
		"C\u04bf\nC\3C\3C\3C\5C\u04c4\nC\3C\3C\3C\5C\u04c9\nC\3D\3D\3D\3D\3D\3"+
		"D\3D\3D\3E\3E\3F\3F\3F\3G\3G\3G\3G\3G\3G\5G\u04de\nG\3H\3H\5H\u04e2\n"+
		"H\3H\3H\3H\5H\u04e7\nH\3I\3I\3J\3J\3K\3K\3L\3L\3L\5L\u04f2\nL\3M\3M\3"+
		"M\3M\5M\u04f8\nM\3N\3N\5N\u04fc\nN\3N\3N\3N\5N\u0501\nN\3O\3O\5O\u0505"+
		"\nO\3O\3O\3O\5O\u050a\nO\3P\5P\u050d\nP\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P"+
		"\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\5P\u0523\nP\3Q\3Q\3Q\3Q\5Q\u0529\nQ\3R"+
		"\3R\3R\3R\3R\3R\3R\3R\3R\5R\u0534\nR\3S\3S\5S\u0538\nS\3S\5S\u053b\nS"+
		"\3S\3S\3S\3S\3S\3S\3S\3S\5S\u0545\nS\3S\3S\3S\3S\5S\u054b\nS\3S\5S\u054e"+
		"\nS\3T\3T\3U\3U\3U\5U\u0555\nU\3U\3U\3U\3U\3U\3U\3U\3U\5U\u055f\nU\3V"+
		"\3V\5V\u0563\nV\3V\5V\u0566\nV\3V\5V\u0569\nV\3V\3V\5V\u056d\nV\3V\3V"+
		"\3V\5V\u0572\nV\5V\u0574\nV\3W\3W\5W\u0578\nW\3W\3W\5W\u057c\nW\3W\3W"+
		"\3X\3X\3X\3X\3X\5X\u0585\nX\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\7Z\u0590\nZ\fZ"+
		"\16Z\u0593\13Z\3[\3[\3[\3[\3[\5[\u059a\n[\3\\\3\\\3]\3]\5]\u05a0\n]\3"+
		"^\3^\3_\3_\5_\u05a6\n_\3`\3`\5`\u05aa\n`\3a\5a\u05ad\na\3a\3a\3a\3a\3"+
		"a\3a\3b\5b\u05b6\nb\3b\3b\3b\3b\3b\3b\3c\5c\u05bf\nc\3c\3c\3c\3c\3c\3"+
		"d\5d\u05c7\nd\3e\3e\3f\3f\3f\3f\3f\3f\3g\5g\u05d2\ng\3g\3g\3h\3h\5h\u05d8"+
		"\nh\3h\3h\3h\3h\3h\3h\3h\3h\3h\5h\u05e3\nh\3i\5i\u05e6\ni\3i\3i\3i\5i"+
		"\u05eb\ni\3i\3i\3i\3j\3j\3j\3j\3j\3j\3k\3k\3k\3k\5k\u05fa\nk\3k\3k\3k"+
		"\3k\5k\u0600\nk\3l\3l\3l\3l\3l\7l\u0607\nl\fl\16l\u060a\13l\3m\3m\3m\3"+
		"m\3m\3m\3m\5m\u0613\nm\3n\3n\3n\3n\5n\u0619\nn\3n\3n\3n\3n\3n\3n\5n\u0621"+
		"\nn\3n\3n\5n\u0625\nn\3o\3o\5o\u0629\no\3o\3o\3o\5o\u062e\no\3o\3o\3o"+
		"\5o\u0633\no\3o\3o\3o\3o\3o\7o\u063a\no\fo\16o\u063d\13o\3p\3p\5p\u0641"+
		"\np\3q\3q\5q\u0645\nq\3r\3r\3r\3r\3s\3s\3t\3t\3t\3t\3u\3u\5u\u0653\nu"+
		"\3u\3u\7u\u0657\nu\fu\16u\u065a\13u\3v\3v\3v\3v\3v\3v\3v\3v\3v\3v\3v\3"+
		"v\5v\u0668\nv\3w\3w\3w\3w\3w\3w\7w\u0670\nw\fw\16w\u0673\13w\3x\3x\5x"+
		"\u0677\nx\3y\3y\3y\3y\3y\5y\u067e\ny\3z\3z\3z\3z\5z\u0684\nz\3{\3{\3{"+
		"\5{\u0689\n{\3{\3{\3{\3{\5{\u068f\n{\3{\3{\3{\3{\3{\5{\u0696\n{\3{\3{"+
		"\5{\u069a\n{\7{\u069c\n{\f{\16{\u069f\13{\3|\3|\3|\3|\5|\u06a5\n|\3|\5"+
		"|\u06a8\n|\3|\5|\u06ab\n|\3|\5|\u06ae\n|\3}\3}\3}\5}\u06b3\n}\3~\3~\5"+
		"~\u06b7\n~\3~\5~\u06ba\n~\3~\3~\5~\u06be\n~\3~\3~\5~\u06c2\n~\3~\3~\3"+
		"~\5~\u06c7\n~\3~\5~\u06ca\n~\5~\u06cc\n~\3\177\3\177\5\177\u06d0\n\177"+
		"\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\5\u0082\u06d7\n\u0082\3\u0082"+
		"\3\u0082\3\u0083\3\u0083\5\u0083\u06dd\n\u0083\3\u0084\3\u0084\5\u0084"+
		"\u06e1\n\u0084\3\u0084\3\u0084\3\u0084\3\u0084\5\u0084\u06e7\n\u0084\3"+
		"\u0085\3\u0085\3\u0085\5\u0085\u06ec\n\u0085\5\u0085\u06ee\n\u0085\3\u0086"+
		"\3\u0086\3\u0086\3\u0086\5\u0086\u06f4\n\u0086\3\u0086\3\u0086\5\u0086"+
		"\u06f8\n\u0086\3\u0086\3\u0086\3\u0086\3\u0086\5\u0086\u06fe\n\u0086\3"+
		"\u0086\3\u0086\3\u0086\3\u0086\3\u0086\5\u0086\u0705\n\u0086\3\u0086\3"+
		"\u0086\5\u0086\u0709\n\u0086\7\u0086\u070b\n\u0086\f\u0086\16\u0086\u070e"+
		"\13\u0086\3\u0087\3\u0087\3\u0087\3\u0087\5\u0087\u0714\n\u0087\3\u0088"+
		"\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\5\u0088\u071e"+
		"\n\u0088\3\u0088\3\u0088\5\u0088\u0722\n\u0088\7\u0088\u0724\n\u0088\f"+
		"\u0088\16\u0088\u0727\13\u0088\3\u0089\5\u0089\u072a\n\u0089\3\u0089\5"+
		"\u0089\u072d\n\u0089\3\u0089\3\u0089\3\u0089\3\u0089\5\u0089\u0733\n\u0089"+
		"\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\7\u008a\u073b\n\u008a"+
		"\f\u008a\16\u008a\u073e\13\u008a\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\3\u008b\5\u008b\u0759\n\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\5\u008b\u075f\n\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\5\u008b\u0767\n\u008b\3\u008b\3\u008b\5\u008b\u076b\n\u008b\3\u008b\5"+
		"\u008b\u076e\n\u008b\3\u008b\3\u008b\5\u008b\u0772\n\u008b\3\u008b\3\u008b"+
		"\3\u008b\5\u008b\u0777\n\u008b\3\u008c\5\u008c\u077a\n\u008c\3\u008c\5"+
		"\u008c\u077d\n\u008c\3\u008c\3\u008c\5\u008c\u0781\n\u008c\3\u008c\3\u008c"+
		"\3\u008d\5\u008d\u0786\n\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d"+
		"\3\u008d\3\u008d\3\u008d\5\u008d\u0790\n\u008d\3\u008e\3\u008e\3\u008e"+
		"\3\u008e\3\u008e\5\u008e\u0797\n\u008e\3\u008f\3\u008f\3\u008f\5\u008f"+
		"\u079c\n\u008f\3\u0090\3\u0090\5\u0090\u07a0\n\u0090\3\u0091\3\u0091\3"+
		"\u0091\5\u0091\u07a5\n\u0091\3\u0091\3\u0091\3\u0091\3\u0091\5\u0091\u07ab"+
		"\n\u0091\7\u0091\u07ad\n\u0091\f\u0091\16\u0091\u07b0\13\u0091\3\u0092"+
		"\3\u0092\3\u0092\5\u0092\u07b5\n\u0092\3\u0092\3\u0092\3\u0092\3\u0092"+
		"\5\u0092\u07bb\n\u0092\3\u0093\3\u0093\5\u0093\u07bf\n\u0093\3\u0094\3"+
		"\u0094\3\u0094\5\u0094\u07c4\n\u0094\3\u0094\3\u0094\3\u0095\3\u0095\5"+
		"\u0095\u07ca\n\u0095\3\u0095\3\u0095\5\u0095\u07ce\n\u0095\3\u0095\5\u0095"+
		"\u07d1\n\u0095\3\u0095\3\u0095\5\u0095\u07d5\n\u0095\3\u0095\5\u0095\u07d8"+
		"\n\u0095\5\u0095\u07da\n\u0095\3\u0096\5\u0096\u07dd\n\u0096\3\u0096\3"+
		"\u0096\3\u0097\3\u0097\3\u0098\3\u0098\3\u0099\3\u0099\5\u0099\u07e7\n"+
		"\u0099\3\u0099\3\u0099\3\u0099\5\u0099\u07ec\n\u0099\5\u0099\u07ee\n\u0099"+
		"\3\u009a\5\u009a\u07f1\n\u009a\3\u009a\5\u009a\u07f4\n\u009a\3\u009a\5"+
		"\u009a\u07f7\n\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3"+
		"\u009a\5\u009a\u0800\n\u009a\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3"+
		"\u009b\7\u009b\u0808\n\u009b\f\u009b\16\u009b\u080b\13\u009b\3\u009c\3"+
		"\u009c\5\u009c\u080f\n\u009c\3\u009c\5\u009c\u0812\n\u009c\3\u009c\3\u009c"+
		"\5\u009c\u0816\n\u009c\3\u009c\5\u009c\u0819\n\u009c\3\u009c\5\u009c\u081c"+
		"\n\u009c\3\u009c\3\u009c\5\u009c\u0820\n\u009c\3\u009d\3\u009d\3\u009d"+
		"\3\u009d\3\u009d\7\u009d\u0827\n\u009d\f\u009d\16\u009d\u082a\13\u009d"+
		"\3\u009e\3\u009e\3\u009f\3\u009f\3\u009f\3\u009f\3\u00a0\3\u00a0\3\u00a0"+
		"\3\u00a1\3\u00a1\3\u00a1\5\u00a1\u0838\n\u00a1\3\u00a1\3\u00a1\3\u00a1"+
		"\3\u00a1\5\u00a1\u083e\n\u00a1\7\u00a1\u0840\n\u00a1\f\u00a1\16\u00a1"+
		"\u0843\13\u00a1\3\u00a2\5\u00a2\u0846\n\u00a2\3\u00a2\3\u00a2\5\u00a2"+
		"\u084a\n\u00a2\3\u00a2\3\u00a2\5\u00a2\u084e\n\u00a2\3\u00a2\3\u00a2\5"+
		"\u00a2\u0852\n\u00a2\3\u00a2\3\u00a2\5\u00a2\u0856\n\u00a2\3\u00a2\3\u00a2"+
		"\5\u00a2\u085a\n\u00a2\3\u00a3\5\u00a3\u085d\n\u00a3\3\u00a3\3\u00a3\5"+
		"\u00a3\u0861\n\u00a3\3\u00a4\3\u00a4\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3"+
		"\u00a6\3\u00a7\3\u00a7\5\u00a7\u086c\n\u00a7\3\u00a8\3\u00a8\5\u00a8\u0870"+
		"\n\u00a8\3\u00a9\3\u00a9\3\u00a9\3\u00aa\3\u00aa\5\u00aa\u0877\n\u00aa"+
		"\3\u00aa\3\u00aa\5\u00aa\u087b\n\u00aa\3\u00aa\3\u00aa\3\u00aa\5\u00aa"+
		"\u0880\n\u00aa\3\u00ab\3\u00ab\3\u00ab\5\u00ab\u0885\n\u00ab\3\u00ab\3"+
		"\u00ab\3\u00ab\3\u00ab\3\u00ab\5\u00ab\u088c\n\u00ab\3\u00ac\3\u00ac\5"+
		"\u00ac\u0890\n\u00ac\3\u00ad\3\u00ad\3\u00ad\3\u00ae\3\u00ae\3\u00ae\3"+
		"\u00ae\3\u00ae\5\u00ae\u089a\n\u00ae\3\u00af\3\u00af\3\u00af\3\u00af\3"+
		"\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\7\u00b0"+
		"\u08a8\n\u00b0\f\u00b0\16\u00b0\u08ab\13\u00b0\3\u00b1\3\u00b1\5\u00b1"+
		"\u08af\n\u00b1\3\u00b2\3\u00b2\5\u00b2\u08b3\n\u00b2\3\u00b2\5\u00b2\u08b6"+
		"\n\u00b2\3\u00b2\3\u00b2\5\u00b2\u08ba\n\u00b2\3\u00b2\3\u00b2\3\u00b2"+
		"\3\u00b2\5\u00b2\u08c0\n\u00b2\3\u00b2\5\u00b2\u08c3\n\u00b2\3\u00b2\3"+
		"\u00b2\5\u00b2\u08c7\n\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3"+
		"\u00b2\3\u00b2\3\u00b2\5\u00b2\u08d1\n\u00b2\3\u00b2\5\u00b2\u08d4\n\u00b2"+
		"\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\5\u00b2\u08dc\n\u00b2"+
		"\3\u00b2\3\u00b2\3\u00b2\5\u00b2\u08e1\n\u00b2\3\u00b3\3\u00b3\3\u00b3"+
		"\5\u00b3\u08e6\n\u00b3\3\u00b3\3\u00b3\3\u00b4\3\u00b4\3\u00b4\3\u00b4"+
		"\5\u00b4\u08ee\n\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\5\u00b4"+
		"\u08f5\n\u00b4\3\u00b4\3\u00b4\5\u00b4\u08f9\n\u00b4\3\u00b5\3\u00b5\3"+
		"\u00b6\3\u00b6\3\u00b6\5\u00b6\u0900\n\u00b6\3\u00b6\3\u00b6\3\u00b6\3"+
		"\u00b6\5\u00b6\u0906\n\u00b6\7\u00b6\u0908\n\u00b6\f\u00b6\16\u00b6\u090b"+
		"\13\u00b6\3\u00b7\3\u00b7\3\u00b7\5\u00b7\u0910\n\u00b7\3\u00b8\3\u00b8"+
		"\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\5\u00b8\u0919\n\u00b8\3\u00b8"+
		"\3\u00b8\5\u00b8\u091d\n\u00b8\3\u00b9\5\u00b9\u0920\n\u00b9\3\u00b9\3"+
		"\u00b9\3\u00b9\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00bb\3\u00bb"+
		"\3\u00bb\3\u00bb\3\u00bc\3\u00bc\5\u00bc\u0930\n\u00bc\3\u00bc\3\u00bc"+
		"\3\u00bc\3\u00bd\3\u00bd\5\u00bd\u0937\n\u00bd\3\u00be\3\u00be\3\u00be"+
		"\3\u00be\3\u00be\3\u00be\3\u00bf\5\u00bf\u0940\n\u00bf\3\u00bf\3\u00bf"+
		"\3\u00bf\3\u00bf\5\u00bf\u0946\n\u00bf\3\u00bf\3\u00bf\5\u00bf\u094a\n"+
		"\u00bf\3\u00bf\5\u00bf\u094d\n\u00bf\3\u00c0\3\u00c0\5\u00c0\u0951\n\u00c0"+
		"\3\u00c1\3\u00c1\5\u00c1\u0955\n\u00c1\3\u00c2\3\u00c2\3\u00c2\5\u00c2"+
		"\u095a\n\u00c2\3\u00c2\3\u00c2\3\u00c3\3\u00c3\3\u00c3\5\u00c3\u0961\n"+
		"\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\5\u00c3\u0967\n\u00c3\7\u00c3\u0969"+
		"\n\u00c3\f\u00c3\16\u00c3\u096c\13\u00c3\3\u00c4\3\u00c4\3\u00c4\3\u00c4"+
		"\3\u00c4\3\u00c4\5\u00c4\u0974\n\u00c4\3\u00c5\3\u00c5\3\u00c6\3\u00c6"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7"+
		"\3\u00c7\3\u00c7\3\u00c7\5\u00c7\u09aa\n\u00c7\3\u00c8\3\u00c8\3\u00c8"+
		"\3\u00c8\6\u00c8\u09b0\n\u00c8\r\u00c8\16\u00c8\u09b1\3\u00c8\3\u00c8"+
		"\3\u00c8\5\u00c8\u09b7\n\u00c8\3\u00c9\3\u00c9\3\u00ca\3\u00ca\3\u00cb"+
		"\3\u00cb\3\u00cb\2$\f\26 \66@BDFJLNPRTV^j|\u00b2\u00d6\u00dc\u00e8\u00ec"+
		"\u00f4\u010a\u010e\u0112\u0120\u0134\u0138\u0140\u015e\u016a\u0184\u00cc"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH"+
		"JLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4"+
		"\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc"+
		"\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4"+
		"\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec"+
		"\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104"+
		"\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c"+
		"\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134"+
		"\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146\u0148\u014a\u014c"+
		"\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e\u0160\u0162\u0164"+
		"\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176\u0178\u017a\u017c"+
		"\u017e\u0180\u0182\u0184\u0186\u0188\u018a\u018c\u018e\u0190\u0192\u0194"+
		"\2\17\4\2ggkk\4\2acgj\3\2vw\5\2kknuxy\7\2**\65\65??EELL\5\2((\62\62VV"+
		"\4\2\34\34XX\4\2gg~~\5\2\33\33HHSS\4\2,,;;\3\2<>\4\2++NN\3\2\u0096\u0099"+
		"\2\u0aed\2\u0197\3\2\2\2\4\u01a3\3\2\2\2\6\u01a7\3\2\2\2\b\u01b2\3\2\2"+
		"\2\n\u01b4\3\2\2\2\f\u01c5\3\2\2\2\16\u01d6\3\2\2\2\20\u01dc\3\2\2\2\22"+
		"\u01e8\3\2\2\2\24\u01ea\3\2\2\2\26\u01ec\3\2\2\2\30\u01fe\3\2\2\2\32\u0204"+
		"\3\2\2\2\34\u020b\3\2\2\2\36\u020d\3\2\2\2 \u025c\3\2\2\2\"\u0289\3\2"+
		"\2\2$\u028b\3\2\2\2&\u028d\3\2\2\2(\u02a5\3\2\2\2*\u02c3\3\2\2\2,\u02c5"+
		"\3\2\2\2.\u02df\3\2\2\2\60\u02e1\3\2\2\2\62\u02e5\3\2\2\2\64\u02ee\3\2"+
		"\2\2\66\u02f0\3\2\2\28\u0309\3\2\2\2:\u0317\3\2\2\2<\u0319\3\2\2\2>\u0324"+
		"\3\2\2\2@\u0326\3\2\2\2B\u0334\3\2\2\2D\u0345\3\2\2\2F\u0353\3\2\2\2H"+
		"\u035f\3\2\2\2J\u0361\3\2\2\2L\u0375\3\2\2\2N\u0383\3\2\2\2P\u038e\3\2"+
		"\2\2R\u0399\3\2\2\2T\u03a4\3\2\2\2V\u03af\3\2\2\2X\u03c1\3\2\2\2Z\u03c9"+
		"\3\2\2\2\\\u03cb\3\2\2\2^\u03cd\3\2\2\2`\u03d8\3\2\2\2b\u03f4\3\2\2\2"+
		"d\u040a\3\2\2\2f\u040d\3\2\2\2h\u0411\3\2\2\2j\u0417\3\2\2\2l\u0435\3"+
		"\2\2\2n\u0447\3\2\2\2p\u046c\3\2\2\2r\u0470\3\2\2\2t\u0473\3\2\2\2v\u047a"+
		"\3\2\2\2x\u048c\3\2\2\2z\u048e\3\2\2\2|\u0490\3\2\2\2~\u04a5\3\2\2\2\u0080"+
		"\u04af\3\2\2\2\u0082\u04b1\3\2\2\2\u0084\u04c8\3\2\2\2\u0086\u04ca\3\2"+
		"\2\2\u0088\u04d2\3\2\2\2\u008a\u04d4\3\2\2\2\u008c\u04dd\3\2\2\2\u008e"+
		"\u04e6\3\2\2\2\u0090\u04e8\3\2\2\2\u0092\u04ea\3\2\2\2\u0094\u04ec\3\2"+
		"\2\2\u0096\u04f1\3\2\2\2\u0098\u04f7\3\2\2\2\u009a\u0500\3\2\2\2\u009c"+
		"\u0509\3\2\2\2\u009e\u0522\3\2\2\2\u00a0\u0528\3\2\2\2\u00a2\u0533\3\2"+
		"\2\2\u00a4\u054d\3\2\2\2\u00a6\u054f\3\2\2\2\u00a8\u055e\3\2\2\2\u00aa"+
		"\u0573\3\2\2\2\u00ac\u0575\3\2\2\2\u00ae\u0584\3\2\2\2\u00b0\u0586\3\2"+
		"\2\2\u00b2\u0589\3\2\2\2\u00b4\u0599\3\2\2\2\u00b6\u059b\3\2\2\2\u00b8"+
		"\u059f\3\2\2\2\u00ba\u05a1\3\2\2\2\u00bc\u05a5\3\2\2\2\u00be\u05a9\3\2"+
		"\2\2\u00c0\u05ac\3\2\2\2\u00c2\u05b5\3\2\2\2\u00c4\u05be\3\2\2\2\u00c6"+
		"\u05c6\3\2\2\2\u00c8\u05c8\3\2\2\2\u00ca\u05ca\3\2\2\2\u00cc\u05d1\3\2"+
		"\2\2\u00ce\u05e2\3\2\2\2\u00d0\u05e5\3\2\2\2\u00d2\u05ef\3\2\2\2\u00d4"+
		"\u05ff\3\2\2\2\u00d6\u0601\3\2\2\2\u00d8\u0612\3\2\2\2\u00da\u0624\3\2"+
		"\2\2\u00dc\u062d\3\2\2\2\u00de\u063e\3\2\2\2\u00e0\u0644\3\2\2\2\u00e2"+
		"\u0646\3\2\2\2\u00e4\u064a\3\2\2\2\u00e6\u064c\3\2\2\2\u00e8\u0650\3\2"+
		"\2\2\u00ea\u0667\3\2\2\2\u00ec\u0669\3\2\2\2\u00ee\u0674\3\2\2\2\u00f0"+
		"\u067d\3\2\2\2\u00f2\u0683\3\2\2\2\u00f4\u068e\3\2\2\2\u00f6\u06a0\3\2"+
		"\2\2\u00f8\u06af\3\2\2\2\u00fa\u06cb\3\2\2\2\u00fc\u06cd\3\2\2\2\u00fe"+
		"\u06d1\3\2\2\2\u0100\u06d3\3\2\2\2\u0102\u06d6\3\2\2\2\u0104\u06da\3\2"+
		"\2\2\u0106\u06e6\3\2\2\2\u0108\u06ed\3\2\2\2\u010a\u06fd\3\2\2\2\u010c"+
		"\u0713\3\2\2\2\u010e\u0715\3\2\2\2\u0110\u0732\3\2\2\2\u0112\u0734\3\2"+
		"\2\2\u0114\u0776\3\2\2\2\u0116\u0779\3\2\2\2\u0118\u078f\3\2\2\2\u011a"+
		"\u0796\3\2\2\2\u011c\u079b\3\2\2\2\u011e\u079f\3\2\2\2\u0120\u07a1\3\2"+
		"\2\2\u0122\u07ba\3\2\2\2\u0124\u07be\3\2\2\2\u0126\u07c0\3\2\2\2\u0128"+
		"\u07d9\3\2\2\2\u012a\u07dc\3\2\2\2\u012c\u07e0\3\2\2\2\u012e\u07e2\3\2"+
		"\2\2\u0130\u07ed\3\2\2\2\u0132\u07ff\3\2\2\2\u0134\u0801\3\2\2\2\u0136"+
		"\u081f\3\2\2\2\u0138\u0821\3\2\2\2\u013a\u082b\3\2\2\2\u013c\u082d\3\2"+
		"\2\2\u013e\u0831\3\2\2\2\u0140\u0834\3\2\2\2\u0142\u0859\3\2\2\2\u0144"+
		"\u0860\3\2\2\2\u0146\u0862\3\2\2\2\u0148\u0864\3\2\2\2\u014a\u0866\3\2"+
		"\2\2\u014c\u0869\3\2\2\2\u014e\u086d\3\2\2\2\u0150\u0871\3\2\2\2\u0152"+
		"\u087f\3\2\2\2\u0154\u088b\3\2\2\2\u0156\u088f\3\2\2\2\u0158\u0891\3\2"+
		"\2\2\u015a\u0899\3\2\2\2\u015c\u089b\3\2\2\2\u015e\u08a1\3\2\2\2\u0160"+
		"\u08ae\3\2\2\2\u0162\u08e0\3\2\2\2\u0164\u08e2\3\2\2\2\u0166\u08f8\3\2"+
		"\2\2\u0168\u08fa\3\2\2\2\u016a\u08fc\3\2\2\2\u016c\u090f\3\2\2\2\u016e"+
		"\u091c\3\2\2\2\u0170\u091f\3\2\2\2\u0172\u0924\3\2\2\2\u0174\u0929\3\2"+
		"\2\2\u0176\u092d\3\2\2\2\u0178\u0934\3\2\2\2\u017a\u0938\3\2\2\2\u017c"+
		"\u094c\3\2\2\2\u017e\u094e\3\2\2\2\u0180\u0954\3\2\2\2\u0182\u0956\3\2"+
		"\2\2\u0184\u095d\3\2\2\2\u0186\u0973\3\2\2\2\u0188\u0975\3\2\2\2\u018a"+
		"\u0977\3\2\2\2\u018c\u09a9\3\2\2\2\u018e\u09b6\3\2\2\2\u0190\u09b8\3\2"+
		"\2\2\u0192\u09ba\3\2\2\2\u0194\u09bc\3\2\2\2\u0196\u0198\5|?\2\u0197\u0196"+
		"\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\7\2\2\3\u019a"+
		"\3\3\2\2\2\u019b\u01a4\5\u018e\u00c8\2\u019c\u01a4\7K\2\2\u019d\u019e"+
		"\7[\2\2\u019e\u019f\5^\60\2\u019f\u01a0\7\\\2\2\u01a0\u01a4\3\2\2\2\u01a1"+
		"\u01a4\5\6\4\2\u01a2\u01a4\5\16\b\2\u01a3\u019b\3\2\2\2\u01a3\u019c\3"+
		"\2\2\2\u01a3\u019d\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a4"+
		"\5\3\2\2\2\u01a5\u01a8\5\b\5\2\u01a6\u01a8\5\n\6\2\u01a7\u01a5\3\2\2\2"+
		"\u01a7\u01a6\3\2\2\2\u01a8\7\3\2\2\2\u01a9\u01b3\7\u008c\2\2\u01aa\u01b3"+
		"\5\u0158\u00ad\2\u01ab\u01b3\5\u014a\u00a6\2\u01ac\u01b3\5\u015a\u00ae"+
		"\2\u01ad\u01ae\7i\2\2\u01ae\u01b3\5\u0124\u0093\2\u01af\u01b0\7i\2\2\u01b0"+
		"\u01b3\5\u00a2R\2\u01b1\u01b3\5\u0166\u00b4\2\u01b2\u01a9\3\2\2\2\u01b2"+
		"\u01aa\3\2\2\2\u01b2\u01ab\3\2\2\2\u01b2\u01ac\3\2\2\2\u01b2\u01ad\3\2"+
		"\2\2\u01b2\u01af\3\2\2\2\u01b2\u01b1\3\2\2\2\u01b3\t\3\2\2\2\u01b4\u01b6"+
		"\5\f\7\2\u01b5\u01b7\7J\2\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01b8\3\2\2\2\u01b8\u01b9\5\b\5\2\u01b9\13\3\2\2\2\u01ba\u01bb\b\7\1"+
		"\2\u01bb\u01c6\7\u0087\2\2\u01bc\u01bd\5\u00a0Q\2\u01bd\u01be\7\u0087"+
		"\2\2\u01be\u01c6\3\2\2\2\u01bf\u01c0\5\u00b8]\2\u01c0\u01c1\7\u0087\2"+
		"\2\u01c1\u01c6\3\2\2\2\u01c2\u01c3\5\u00a2R\2\u01c3\u01c4\7\u0087\2\2"+
		"\u01c4\u01c6\3\2\2\2\u01c5\u01ba\3\2\2\2\u01c5\u01bc\3\2\2\2\u01c5\u01bf"+
		"\3\2\2\2\u01c5\u01c2\3\2\2\2\u01c6\u01d3\3\2\2\2\u01c7\u01c8\f\4\2\2\u01c8"+
		"\u01c9\7\u008c\2\2\u01c9\u01d2\7\u0087\2\2\u01ca\u01cc\f\3\2\2\u01cb\u01cd"+
		"\7J\2\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce"+
		"\u01cf\5\u0164\u00b3\2\u01cf\u01d0\7\u0087\2\2\u01d0\u01d2\3\2\2\2\u01d1"+
		"\u01c7\3\2\2\2\u01d1\u01ca\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2"+
		"\2\2\u01d3\u01d4\3\2\2\2\u01d4\r\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6\u01d8"+
		"\5\20\t\2\u01d7\u01d9\5\36\20\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2"+
		"\2\u01d9\u01da\3\2\2\2\u01da\u01db\5h\65\2\u01db\17\3\2\2\2\u01dc\u01de"+
		"\7]\2\2\u01dd\u01df\5\22\n\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2\2\2\u01df"+
		"\u01e0\3\2\2\2\u01e0\u01e1\7^\2\2\u01e1\21\3\2\2\2\u01e2\u01e9\5\24\13"+
		"\2\u01e3\u01e9\5\26\f\2\u01e4\u01e5\5\24\13\2\u01e5\u01e6\7\u0082\2\2"+
		"\u01e6\u01e7\5\26\f\2\u01e7\u01e9\3\2\2\2\u01e8\u01e2\3\2\2\2\u01e8\u01e3"+
		"\3\2\2\2\u01e8\u01e4\3\2\2\2\u01e9\23\3\2\2\2\u01ea\u01eb\t\2\2\2\u01eb"+
		"\25\3\2\2\2\u01ec\u01ed\b\f\1\2\u01ed\u01ef\5\30\r\2\u01ee\u01f0\7\u008b"+
		"\2\2\u01ef\u01ee\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f9\3\2\2\2\u01f1"+
		"\u01f2\f\3\2\2\u01f2\u01f3\7\u0082\2\2\u01f3\u01f5\5\30\r\2\u01f4\u01f6"+
		"\7\u008b\2\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8\3\2\2"+
		"\2\u01f7\u01f1\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa"+
		"\3\2\2\2\u01fa\27\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fc\u01ff\5\32\16\2\u01fd"+
		"\u01ff\5\34\17\2\u01fe\u01fc\3\2\2\2\u01fe\u01fd\3\2\2\2\u01ff\31\3\2"+
		"\2\2\u0200\u0205\7\u008c\2\2\u0201\u0202\7g\2\2\u0202\u0205\7\u008c\2"+
		"\2\u0203\u0205\7K\2\2\u0204\u0200\3\2\2\2\u0204\u0201\3\2\2\2\u0204\u0203"+
		"\3\2\2\2\u0205\33\3\2\2\2\u0206\u0207\7\u008c\2\2\u0207\u020c\5\u011a"+
		"\u008e\2\u0208\u0209\7g\2\2\u0209\u020a\7\u008c\2\2\u020a\u020c\5\u011a"+
		"\u008e\2\u020b\u0206\3\2\2\2\u020b\u0208\3\2\2\2\u020c\35\3\2\2\2\u020d"+
		"\u020e\7[\2\2\u020e\u020f\5\u0110\u0089\2\u020f\u0211\7\\\2\2\u0210\u0212"+
		"\7\65\2\2\u0211\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0214\3\2\2\2"+
		"\u0213\u0215\5\u0180\u00c1\2\u0214\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u0215"+
		"\u0217\3\2\2\2\u0216\u0218\5\u00d6l\2\u0217\u0216\3\2\2\2\u0217\u0218"+
		"\3\2\2\2\u0218\u021a\3\2\2\2\u0219\u021b\5\u00f8}\2\u021a\u0219\3\2\2"+
		"\2\u021a\u021b\3\2\2\2\u021b\37\3\2\2\2\u021c\u021d\b\21\1\2\u021d\u025d"+
		"\5\4\3\2\u021e\u021f\5\u009eP\2\u021f\u0221\7[\2\2\u0220\u0222\5&\24\2"+
		"\u0221\u0220\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0224"+
		"\7\\\2\2\u0224\u025d\3\2\2\2\u0225\u0226\5\u016e\u00b8\2\u0226\u0228\7"+
		"[\2\2\u0227\u0229\5&\24\2\u0228\u0227\3\2\2\2\u0228\u0229\3\2\2\2\u0229"+
		"\u022a\3\2\2\2\u022a\u022b\7\\\2\2\u022b\u025d\3\2\2\2\u022c\u022d\5\u009e"+
		"P\2\u022d\u022e\5\u0122\u0092\2\u022e\u025d\3\2\2\2\u022f\u0230\5\u016e"+
		"\u00b8\2\u0230\u0231\5\u0122\u0092\2\u0231\u025d\3\2\2\2\u0232\u0233\7"+
		"%\2\2\u0233\u0234\7l\2\2\u0234\u0235\5\u0104\u0083\2\u0235\u0236\7m\2"+
		"\2\u0236\u0237\7[\2\2\u0237\u0238\5^\60\2\u0238\u0239\7\\\2\2\u0239\u025d"+
		"\3\2\2\2\u023a\u023b\7G\2\2\u023b\u023c\7l\2\2\u023c\u023d\5\u0104\u0083"+
		"\2\u023d\u023e\7m\2\2\u023e\u023f\7[\2\2\u023f\u0240\5^\60\2\u0240\u0241"+
		"\7\\\2\2\u0241\u025d\3\2\2\2\u0242\u0243\7@\2\2\u0243\u0244\7l\2\2\u0244"+
		"\u0245\5\u0104\u0083\2\u0245\u0246\7m\2\2\u0246\u0247\7[\2\2\u0247\u0248"+
		"\5^\60\2\u0248\u0249\7\\\2\2\u0249\u025d\3\2\2\2\u024a\u024b\7\36\2\2"+
		"\u024b\u024c\7l\2\2\u024c\u024d\5\u0104\u0083\2\u024d\u024e\7m\2\2\u024e"+
		"\u024f\7[\2\2\u024f\u0250\5^\60\2\u0250\u0251\7\\\2\2\u0251\u025d\3\2"+
		"\2\2\u0252\u0253\5$\23\2\u0253\u0254\7[\2\2\u0254\u0255\5^\60\2\u0255"+
		"\u0256\7\\\2\2\u0256\u025d\3\2\2\2\u0257\u0258\5$\23\2\u0258\u0259\7["+
		"\2\2\u0259\u025a\5\u0104\u0083\2\u025a\u025b\7\\\2\2\u025b\u025d\3\2\2"+
		"\2\u025c\u021c\3\2\2\2\u025c\u021e\3\2\2\2\u025c\u0225\3\2\2\2\u025c\u022c"+
		"\3\2\2\2\u025c\u022f\3\2\2\2\u025c\u0232\3\2\2\2\u025c\u023a\3\2\2\2\u025c"+
		"\u0242\3\2\2\2\u025c\u024a\3\2\2\2\u025c\u0252\3\2\2\2\u025c\u0257\3\2"+
		"\2\2\u025d\u0286\3\2\2\2\u025e\u025f\f\25\2\2\u025f\u0260\7]\2\2\u0260"+
		"\u0261\5^\60\2\u0261\u0262\7^\2\2\u0262\u0285\3\2\2\2\u0263\u0264\f\24"+
		"\2\2\u0264\u0265\7]\2\2\u0265\u0266\5\u0122\u0092\2\u0266\u0267\7^\2\2"+
		"\u0267\u0285\3\2\2\2\u0268\u0269\f\23\2\2\u0269\u026b\7[\2\2\u026a\u026c"+
		"\5&\24\2\u026b\u026a\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d"+
		"\u0285\7\\\2\2\u026e\u026f\f\16\2\2\u026f\u0271\7\u0089\2\2\u0270\u0272"+
		"\7J\2\2\u0271\u0270\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\3\2\2\2\u0273"+
		"\u0285\5\6\4\2\u0274\u0275\f\r\2\2\u0275\u0277\7\u0084\2\2\u0276\u0278"+
		"\7J\2\2\u0277\u0276\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\3\2\2\2\u0279"+
		"\u0285\5\6\4\2\u027a\u027b\f\f\2\2\u027b\u027c\7\u0089\2\2\u027c\u0285"+
		"\5(\25\2\u027d\u027e\f\13\2\2\u027e\u027f\7\u0084\2\2\u027f\u0285\5(\25"+
		"\2\u0280\u0281\f\n\2\2\u0281\u0285\7\u0080\2\2\u0282\u0283\f\t\2\2\u0283"+
		"\u0285\7\u0081\2\2\u0284\u025e\3\2\2\2\u0284\u0263\3\2\2\2\u0284\u0268"+
		"\3\2\2\2\u0284\u026e\3\2\2\2\u0284\u0274\3\2\2\2\u0284\u027a\3\2\2\2\u0284"+
		"\u027d\3\2\2\2\u0284\u0280\3\2\2\2\u0284\u0282\3\2\2\2\u0285\u0288\3\2"+
		"\2\2\u0286\u0284\3\2\2\2\u0286\u0287\3\2\2\2\u0287!\3\2\2\2\u0288\u0286"+
		"\3\2\2\2\u0289\u028a\7Q\2\2\u028a#\3\2\2\2\u028b\u028c\7Q\2\2\u028c%\3"+
		"\2\2\2\u028d\u028e\5\u0120\u0091\2\u028e\'\3\2\2\2\u028f\u0291\5\f\7\2"+
		"\u0290\u028f\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293"+
		"\5\u00a0Q\2\u0293\u0294\7\u0087\2\2\u0294\u0295\7i\2\2\u0295\u0296\5\u00a0"+
		"Q\2\u0296\u02a6\3\2\2\2\u0297\u0298\5\f\7\2\u0298\u0299\7J\2\2\u0299\u029a"+
		"\5\u0164\u00b3\2\u029a\u029b\7\u0087\2\2\u029b\u029c\7i\2\2\u029c\u029d"+
		"\5\u00a0Q\2\u029d\u02a6\3\2\2\2\u029e\u02a0\5\f\7\2\u029f\u029e\3\2\2"+
		"\2\u029f\u02a0\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a2\7i\2\2\u02a2\u02a6"+
		"\5\u00a0Q\2\u02a3\u02a4\7i\2\2\u02a4\u02a6\5\u00a2R\2\u02a5\u0290\3\2"+
		"\2\2\u02a5\u0297\3\2\2\2\u02a5\u029f\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a6"+
		")\3\2\2\2\u02a7\u02c4\5 \21\2\u02a8\u02a9\7\u0080\2\2\u02a9\u02c4\5> "+
		"\2\u02aa\u02ab\7\u0081\2\2\u02ab\u02c4\5> \2\u02ac\u02ad\5,\27\2\u02ad"+
		"\u02ae\5> \2\u02ae\u02c4\3\2\2\2\u02af\u02b0\7D\2\2\u02b0\u02c4\5*\26"+
		"\2\u02b1\u02b2\7D\2\2\u02b2\u02b3\7[\2\2\u02b3\u02b4\5\u0104\u0083\2\u02b4"+
		"\u02b5\7\\\2\2\u02b5\u02c4\3\2\2\2\u02b6\u02b7\7D\2\2\u02b7\u02b8\7\u008b"+
		"\2\2\u02b8\u02b9\7[\2\2\u02b9\u02ba\7\u008c\2\2\u02ba\u02c4\7\\\2\2\u02bb"+
		"\u02bc\7\21\2\2\u02bc\u02bd\7[\2\2\u02bd\u02be\5\u0104\u0083\2\u02be\u02bf"+
		"\7\\\2\2\u02bf\u02c4\3\2\2\2\u02c0\u02c4\5<\37\2\u02c1\u02c4\5.\30\2\u02c2"+
		"\u02c4\5:\36\2\u02c3\u02a7\3\2\2\2\u02c3\u02a8\3\2\2\2\u02c3\u02aa\3\2"+
		"\2\2\u02c3\u02ac\3\2\2\2\u02c3\u02af\3\2\2\2\u02c3\u02b1\3\2\2\2\u02c3"+
		"\u02b6\3\2\2\2\u02c3\u02bb\3\2\2\2\u02c3\u02c0\3\2\2\2\u02c3\u02c1\3\2"+
		"\2\2\u02c3\u02c2\3\2\2\2\u02c4+\3\2\2\2\u02c5\u02c6\t\3\2\2\u02c6-\3\2"+
		"\2\2\u02c7\u02c9\7\u0087\2\2\u02c8\u02c7\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9"+
		"\u02ca\3\2\2\2\u02ca\u02cc\7\67\2\2\u02cb\u02cd\5\60\31\2\u02cc\u02cb"+
		"\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02d0\5\62\32\2"+
		"\u02cf\u02d1\58\35\2\u02d0\u02cf\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02e0"+
		"\3\2\2\2\u02d2\u02d4\7\u0087\2\2\u02d3\u02d2\3\2\2\2\u02d3\u02d4\3\2\2"+
		"\2\u02d4\u02d5\3\2\2\2\u02d5\u02d7\7\67\2\2\u02d6\u02d8\5\60\31\2\u02d7"+
		"\u02d6\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\7["+
		"\2\2\u02da\u02db\5\u0104\u0083\2\u02db\u02dd\7\\\2\2\u02dc\u02de\58\35"+
		"\2\u02dd\u02dc\3\2\2\2\u02dd\u02de\3\2\2\2\u02de\u02e0\3\2\2\2\u02df\u02c8"+
		"\3\2\2\2\u02df\u02d3\3\2\2\2\u02e0/\3\2\2\2\u02e1\u02e2\7[\2\2\u02e2\u02e3"+
		"\5&\24\2\u02e3\u02e4\7\\\2\2\u02e4\61\3\2\2\2\u02e5\u02e7\5\u009aN\2\u02e6"+
		"\u02e8\5\64\33\2\u02e7\u02e6\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\63\3\2"+
		"\2\2\u02e9\u02eb\5\u00fa~\2\u02ea\u02ec\5\64\33\2\u02eb\u02ea\3\2\2\2"+
		"\u02eb\u02ec\3\2\2\2\u02ec\u02ef\3\2\2\2\u02ed\u02ef\5\66\34\2\u02ee\u02e9"+
		"\3\2\2\2\u02ee\u02ed\3\2\2\2\u02ef\65\3\2\2\2\u02f0\u02f1\b\34\1\2\u02f1"+
		"\u02f2\7]\2\2\u02f2\u02f3\5^\60\2\u02f3\u02f5\7^\2\2\u02f4\u02f6\5\u00d6"+
		"l\2\u02f5\u02f4\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u0300\3\2\2\2\u02f7"+
		"\u02f8\f\3\2\2\u02f8\u02f9\7]\2\2\u02f9\u02fa\5`\61\2\u02fa\u02fc\7^\2"+
		"\2\u02fb\u02fd\5\u00d6l\2\u02fc\u02fb\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd"+
		"\u02ff\3\2\2\2\u02fe\u02f7\3\2\2\2\u02ff\u0302\3\2\2\2\u0300\u02fe\3\2"+
		"\2\2\u0300\u0301\3\2\2\2\u0301\67\3\2\2\2\u0302\u0300\3\2\2\2\u0303\u0305"+
		"\7[\2\2\u0304\u0306\5&\24\2\u0305\u0304\3\2\2\2\u0305\u0306\3\2\2\2\u0306"+
		"\u0307\3\2\2\2\u0307\u030a\7\\\2\2\u0308\u030a\5\u0122\u0092\2\u0309\u0303"+
		"\3\2\2\2\u0309\u0308\3\2\2\2\u030a9\3\2\2\2\u030b\u030d\7\u0087\2\2\u030c"+
		"\u030b\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030f\7\""+
		"\2\2\u030f\u0318\5> \2\u0310\u0312\7\u0087\2\2\u0311\u0310\3\2\2\2\u0311"+
		"\u0312\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0314\7\"\2\2\u0314\u0315\7]"+
		"\2\2\u0315\u0316\7^\2\2\u0316\u0318\5> \2\u0317\u030c\3\2\2\2\u0317\u0311"+
		"\3\2\2\2\u0318;\3\2\2\2\u0319\u031a\78\2\2\u031a\u031b\7[\2\2\u031b\u031c"+
		"\5^\60\2\u031c\u031d\7\\\2\2\u031d=\3\2\2\2\u031e\u0325\5*\26\2\u031f"+
		"\u0320\7[\2\2\u0320\u0321\5\u0104\u0083\2\u0321\u0322\7\\\2\2\u0322\u0323"+
		"\5> \2\u0323\u0325\3\2\2\2\u0324\u031e\3\2\2\2\u0324\u031f\3\2\2\2\u0325"+
		"?\3\2\2\2\u0326\u0327\b!\1\2\u0327\u0328\5> \2\u0328\u0331\3\2\2\2\u0329"+
		"\u032a\f\4\2\2\u032a\u032b\7\u008a\2\2\u032b\u0330\5> \2\u032c\u032d\f"+
		"\3\2\2\u032d\u032e\7\u0083\2\2\u032e\u0330\5> \2\u032f\u0329\3\2\2\2\u032f"+
		"\u032c\3\2\2\2\u0330\u0333\3\2\2\2\u0331\u032f\3\2\2\2\u0331\u0332\3\2"+
		"\2\2\u0332A\3\2\2\2\u0333\u0331\3\2\2\2\u0334\u0335\b\"\1\2\u0335\u0336"+
		"\5@!\2\u0336\u0342\3\2\2\2\u0337\u0338\f\5\2\2\u0338\u0339\7c\2\2\u0339"+
		"\u0341\5@!\2\u033a\u033b\f\4\2\2\u033b\u033c\7d\2\2\u033c\u0341\5@!\2"+
		"\u033d\u033e\f\3\2\2\u033e\u033f\7e\2\2\u033f\u0341\5@!\2\u0340\u0337"+
		"\3\2\2\2\u0340\u033a\3\2\2\2\u0340\u033d\3\2\2\2\u0341\u0344\3\2\2\2\u0342"+
		"\u0340\3\2\2\2\u0342\u0343\3\2\2\2\u0343C\3\2\2\2\u0344\u0342\3\2\2\2"+
		"\u0345\u0346\b#\1\2\u0346\u0347\5B\"\2\u0347\u0350\3\2\2\2\u0348\u0349"+
		"\f\4\2\2\u0349\u034a\7a\2\2\u034a\u034f\5B\"\2\u034b\u034c\f\3\2\2\u034c"+
		"\u034d\7b\2\2\u034d\u034f\5B\"\2\u034e\u0348\3\2\2\2\u034e\u034b\3\2\2"+
		"\2\u034f\u0352\3\2\2\2\u0350\u034e\3\2\2\2\u0350\u0351\3\2\2\2\u0351E"+
		"\3\2\2\2\u0352\u0350\3\2\2\2\u0353\u0354\b$\1\2\u0354\u0355\5D#\2\u0355"+
		"\u035c\3\2\2\2\u0356\u0357\f\3\2\2\u0357\u0358\5H%\2\u0358\u0359\5D#\2"+
		"\u0359\u035b\3\2\2\2\u035a\u0356\3\2\2\2\u035b\u035e\3\2\2\2\u035c\u035a"+
		"\3\2\2\2\u035c\u035d\3\2\2\2\u035dG\3\2\2\2\u035e\u035c\3\2\2\2\u035f"+
		"\u0360\t\4\2\2\u0360I\3\2\2\2\u0361\u0362\b&\1\2\u0362\u0363\5F$\2\u0363"+
		"\u0372\3\2\2\2\u0364\u0365\f\6\2\2\u0365\u0366\7l\2\2\u0366\u0371\5F$"+
		"\2\u0367\u0368\f\5\2\2\u0368\u0369\7m\2\2\u0369\u0371\5F$\2\u036a\u036b"+
		"\f\4\2\2\u036b\u036c\7|\2\2\u036c\u0371\5F$\2\u036d\u036e\f\3\2\2\u036e"+
		"\u036f\7}\2\2\u036f\u0371\5F$\2\u0370\u0364\3\2\2\2\u0370\u0367\3\2\2"+
		"\2\u0370\u036a\3\2\2\2\u0370\u036d\3\2\2\2\u0371\u0374\3\2\2\2\u0372\u0370"+
		"\3\2\2\2\u0372\u0373\3\2\2\2\u0373K\3\2\2\2\u0374\u0372\3\2\2\2\u0375"+
		"\u0376\b\'\1\2\u0376\u0377\5J&\2\u0377\u0380\3\2\2\2\u0378\u0379\f\4\2"+
		"\2\u0379\u037a\7z\2\2\u037a\u037f\5J&\2\u037b\u037c\f\3\2\2\u037c\u037d"+
		"\7{\2\2\u037d\u037f\5J&\2\u037e\u0378\3\2\2\2\u037e\u037b\3\2\2\2\u037f"+
		"\u0382\3\2\2\2\u0380\u037e\3\2\2\2\u0380\u0381\3\2\2\2\u0381M\3\2\2\2"+
		"\u0382\u0380\3\2\2\2\u0383\u0384\b(\1\2\u0384\u0385\5L\'\2\u0385\u038b"+
		"\3\2\2\2\u0386\u0387\f\3\2\2\u0387\u0388\7g\2\2\u0388\u038a\5L\'\2\u0389"+
		"\u0386\3\2\2\2\u038a\u038d\3\2\2\2\u038b\u0389\3\2\2\2\u038b\u038c\3\2"+
		"\2\2\u038cO\3\2\2\2\u038d\u038b\3\2\2\2\u038e\u038f\b)\1\2\u038f\u0390"+
		"\5N(\2\u0390\u0396\3\2\2\2\u0391\u0392\f\3\2\2\u0392\u0393\7f\2\2\u0393"+
		"\u0395\5N(\2\u0394\u0391\3\2\2\2\u0395\u0398\3\2\2\2\u0396\u0394\3\2\2"+
		"\2\u0396\u0397\3\2\2\2\u0397Q\3\2\2\2\u0398\u0396\3\2\2\2\u0399\u039a"+
		"\b*\1\2\u039a\u039b\5P)\2\u039b\u03a1\3\2\2\2\u039c\u039d\f\3\2\2\u039d"+
		"\u039e\7h\2\2\u039e\u03a0\5P)\2\u039f\u039c\3\2\2\2\u03a0\u03a3\3\2\2"+
		"\2\u03a1\u039f\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2S\3\2\2\2\u03a3\u03a1"+
		"\3\2\2\2\u03a4\u03a5\b+\1\2\u03a5\u03a6\5R*\2\u03a6\u03ac\3\2\2\2\u03a7"+
		"\u03a8\f\3\2\2\u03a8\u03a9\7~\2\2\u03a9\u03ab\5R*\2\u03aa\u03a7\3\2\2"+
		"\2\u03ab\u03ae\3\2\2\2\u03ac\u03aa\3\2\2\2\u03ac\u03ad\3\2\2\2\u03adU"+
		"\3\2\2\2\u03ae\u03ac\3\2\2\2\u03af\u03b0\b,\1\2\u03b0\u03b1\5T+\2\u03b1"+
		"\u03b7\3\2\2\2\u03b2\u03b3\f\3\2\2\u03b3\u03b4\7\177\2\2\u03b4\u03b6\5"+
		"T+\2\u03b5\u03b2\3\2\2\2\u03b6\u03b9\3\2\2\2\u03b7\u03b5\3\2\2\2\u03b7"+
		"\u03b8\3\2\2\2\u03b8W\3\2\2\2\u03b9\u03b7\3\2\2\2\u03ba\u03c2\5V,\2\u03bb"+
		"\u03bc\5V,\2\u03bc\u03bd\7\u0085\2\2\u03bd\u03be\5^\60\2\u03be\u03bf\7"+
		"\u0086\2\2\u03bf\u03c0\5Z.\2\u03c0\u03c2\3\2\2\2\u03c1\u03ba\3\2\2\2\u03c1"+
		"\u03bb\3\2\2\2\u03c2Y\3\2\2\2\u03c3\u03ca\5X-\2\u03c4\u03c5\5V,\2\u03c5"+
		"\u03c6\5\\/\2\u03c6\u03c7\5\u011e\u0090\2\u03c7\u03ca\3\2\2\2\u03c8\u03ca"+
		"\5\u017e\u00c0\2\u03c9\u03c3\3\2\2\2\u03c9\u03c4\3\2\2\2\u03c9\u03c8\3"+
		"\2\2\2\u03ca[\3\2\2\2\u03cb\u03cc\t\5\2\2\u03cc]\3\2\2\2\u03cd\u03ce\b"+
		"\60\1\2\u03ce\u03cf\5Z.\2\u03cf\u03d5\3\2\2\2\u03d0\u03d1\f\3\2\2\u03d1"+
		"\u03d2\7\u0082\2\2\u03d2\u03d4\5Z.\2\u03d3\u03d0\3\2\2\2\u03d4\u03d7\3"+
		"\2\2\2\u03d5\u03d3\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6_\3\2\2\2\u03d7\u03d5"+
		"\3\2\2\2\u03d8\u03d9\5X-\2\u03d9a\3\2\2\2\u03da\u03f5\5d\63\2\u03db\u03dd"+
		"\5\u00d6l\2\u03dc\u03db\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03de\3\2\2"+
		"\2\u03de\u03f5\5f\64\2\u03df\u03e1\5\u00d6l\2\u03e0\u03df\3\2\2\2\u03e0"+
		"\u03e1\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2\u03f5\5h\65\2\u03e3\u03e5\5\u00d6"+
		"l\2\u03e4\u03e3\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6"+
		"\u03f5\5l\67\2\u03e7\u03e9\5\u00d6l\2\u03e8\u03e7\3\2\2\2\u03e8\u03e9"+
		"\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea\u03f5\5p9\2\u03eb\u03ed\5\u00d6l\2"+
		"\u03ec\u03eb\3\2\2\2\u03ec\u03ed\3\2\2\2\u03ed\u03ee\3\2\2\2\u03ee\u03f5"+
		"\5x=\2\u03ef\u03f5\5z>\2\u03f0\u03f2\5\u00d6l\2\u03f1\u03f0\3\2\2\2\u03f1"+
		"\u03f2\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f5\5\u0174\u00bb\2\u03f4\u03da"+
		"\3\2\2\2\u03f4\u03dc\3\2\2\2\u03f4\u03e0\3\2\2\2\u03f4\u03e4\3\2\2\2\u03f4"+
		"\u03e8\3\2\2\2\u03f4\u03ec\3\2\2\2\u03f4\u03ef\3\2\2\2\u03f4\u03f1\3\2"+
		"\2\2\u03f5c\3\2\2\2\u03f6\u03f8\5\u00d6l\2\u03f7\u03f6\3\2\2\2\u03f7\u03f8"+
		"\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9\u03fa\7\u008c\2\2\u03fa\u03fb\7\u0086"+
		"\2\2\u03fb\u040b\5b\62\2\u03fc\u03fe\5\u00d6l\2\u03fd\u03fc\3\2\2\2\u03fd"+
		"\u03fe\3\2\2\2\u03fe\u03ff\3\2\2\2\u03ff\u0400\7\26\2\2\u0400\u0401\5"+
		"`\61\2\u0401\u0402\7\u0086\2\2\u0402\u0403\5b\62\2\u0403\u040b\3\2\2\2"+
		"\u0404\u0406\5\u00d6l\2\u0405\u0404\3\2\2\2\u0405\u0406\3\2\2\2\u0406"+
		"\u0407\3\2\2\2\u0407\u0408\7!\2\2\u0408\u0409\7\u0086\2\2\u0409\u040b"+
		"\5b\62\2\u040a\u03f7\3\2\2\2\u040a\u03fd\3\2\2\2\u040a\u0405\3\2\2\2\u040b"+
		"e\3\2\2\2\u040c\u040e\5^\60\2\u040d\u040c\3\2\2\2\u040d\u040e\3\2\2\2"+
		"\u040e\u040f\3\2\2\2\u040f\u0410\7\u0088\2\2\u0410g\3\2\2\2\u0411\u0413"+
		"\7_\2\2\u0412\u0414\5j\66\2\u0413\u0412\3\2\2\2\u0413\u0414\3\2\2\2\u0414"+
		"\u0415\3\2\2\2\u0415\u0416\7`\2\2\u0416i\3\2\2\2\u0417\u0418\b\66\1\2"+
		"\u0418\u0419\5b\62\2\u0419\u041e\3\2\2\2\u041a\u041b\f\3\2\2\u041b\u041d"+
		"\5b\62\2\u041c\u041a\3\2\2\2\u041d\u0420\3\2\2\2\u041e\u041c\3\2\2\2\u041e"+
		"\u041f\3\2\2\2\u041fk\3\2\2\2\u0420\u041e\3\2\2\2\u0421\u0422\7\61\2\2"+
		"\u0422\u0423\7[\2\2\u0423\u0424\5n8\2\u0424\u0425\7\\\2\2\u0425\u0426"+
		"\5b\62\2\u0426\u0436\3\2\2\2\u0427\u0428\7\61\2\2\u0428\u0429\7[\2\2\u0429"+
		"\u042a\5n8\2\u042a\u042b\7\\\2\2\u042b\u042c\5b\62\2\u042c\u042d\7&\2"+
		"\2\u042d\u042e\5b\62\2\u042e\u0436\3\2\2\2\u042f\u0430\7I\2\2\u0430\u0431"+
		"\7[\2\2\u0431\u0432\5n8\2\u0432\u0433\7\\\2\2\u0433\u0434\5b\62\2\u0434"+
		"\u0436\3\2\2\2\u0435\u0421\3\2\2\2\u0435\u0427\3\2\2\2\u0435\u042f\3\2"+
		"\2\2\u0436m\3\2\2\2\u0437\u0448\5^\60\2\u0438\u043a\5\u00d6l\2\u0439\u0438"+
		"\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u043b\3\2\2\2\u043b\u043c\5\u008eH"+
		"\2\u043c\u043d\5\u00f0y\2\u043d\u043e\7k\2\2\u043e\u043f\5\u011e\u0090"+
		"\2\u043f\u0448\3\2\2\2\u0440\u0442\5\u00d6l\2\u0441\u0440\3\2\2\2\u0441"+
		"\u0442\3\2\2\2\u0442\u0443\3\2\2\2\u0443\u0444\5\u008eH\2\u0444\u0445"+
		"\5\u00f0y\2\u0445\u0446\5\u0122\u0092\2\u0446\u0448\3\2\2\2\u0447\u0437"+
		"\3\2\2\2\u0447\u0439\3\2\2\2\u0447\u0441\3\2\2\2\u0448o\3\2\2\2\u0449"+
		"\u044a\7Z\2\2\u044a\u044b\7[\2\2\u044b\u044c\5n8\2\u044c\u044d\7\\\2\2"+
		"\u044d\u044e\5b\62\2\u044e\u046d\3\2\2\2\u044f\u0450\7#\2\2\u0450\u0451"+
		"\5b\62\2\u0451\u0452\7Z\2\2\u0452\u0453\7[\2\2\u0453\u0454\5^\60\2\u0454"+
		"\u0455\7\\\2\2\u0455\u0456\7\u0088\2\2\u0456\u046d\3\2\2\2\u0457\u0458"+
		"\7.\2\2\u0458\u0459\7[\2\2\u0459\u045b\5r:\2\u045a\u045c\5n8\2\u045b\u045a"+
		"\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045d\3\2\2\2\u045d\u045f\7\u0088\2"+
		"\2\u045e\u0460\5^\60\2\u045f\u045e\3\2\2\2\u045f\u0460\3\2\2\2\u0460\u0461"+
		"\3\2\2\2\u0461\u0462\7\\\2\2\u0462\u0463\5b\62\2\u0463\u046d\3\2\2\2\u0464"+
		"\u0465\7.\2\2\u0465\u0466\7[\2\2\u0466\u0467\5t;\2\u0467\u0468\7\u0086"+
		"\2\2\u0468\u0469\5v<\2\u0469\u046a\7\\\2\2\u046a\u046b\5b\62\2\u046b\u046d"+
		"\3\2\2\2\u046c\u0449\3\2\2\2\u046c\u044f\3\2\2\2\u046c\u0457\3\2\2\2\u046c"+
		"\u0464\3\2\2\2\u046dq\3\2\2\2\u046e\u0471\5f\64\2\u046f\u0471\5\u0084"+
		"C\2\u0470\u046e\3\2\2\2\u0470\u046f\3\2\2\2\u0471s\3\2\2\2\u0472\u0474"+
		"\5\u00d6l\2\u0473\u0472\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u0475\3\2\2"+
		"\2\u0475\u0476\5\u008eH\2\u0476\u0477\5\u00f0y\2\u0477u\3\2\2\2\u0478"+
		"\u047b\5^\60\2\u0479\u047b\5\u0122\u0092\2\u047a\u0478\3\2\2\2\u047a\u0479"+
		"\3\2\2\2\u047bw\3\2\2\2\u047c\u047d\7\25\2\2\u047d\u048d\7\u0088\2\2\u047e"+
		"\u047f\7\37\2\2\u047f\u048d\7\u0088\2\2\u0480\u0482\7A\2\2\u0481\u0483"+
		"\5^\60\2\u0482\u0481\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u0484\3\2\2\2\u0484"+
		"\u048d\7\u0088\2\2\u0485\u0486\7A\2\2\u0486\u0487\5\u0122\u0092\2\u0487"+
		"\u0488\7\u0088\2\2\u0488\u048d\3\2\2\2\u0489\u048a\7\60\2\2\u048a\u048b"+
		"\7\u008c\2\2\u048b\u048d\7\u0088\2\2\u048c\u047c\3\2\2\2\u048c\u047e\3"+
		"\2\2\2\u048c\u0480\3\2\2\2\u048c\u0485\3\2\2\2\u048c\u0489\3\2\2\2\u048d"+
		"y\3\2\2\2\u048e\u048f\5\u0080A\2\u048f{\3\2\2\2\u0490\u0491\b?\1\2\u0491"+
		"\u0492\5~@\2\u0492\u0497\3\2\2\2\u0493\u0494\f\3\2\2\u0494\u0496\5~@\2"+
		"\u0495\u0493\3\2\2\2\u0496\u0499\3\2\2\2\u0497\u0495\3\2\2\2\u0497\u0498"+
		"\3\2\2\2\u0498}\3\2\2\2\u0499\u0497\3\2\2\2\u049a\u04a6\5\u0080A\2\u049b"+
		"\u04a6\5\u0116\u008c\2\u049c\u04a6\5\u015c\u00af\2\u049d\u04a6\5\u0170"+
		"\u00b9\2\u049e\u04a6\5\u0172\u00ba\2\u049f\u04a6\5\u00d4k\2\u04a0\u04a6"+
		"\5\u00bc_\2\u04a1\u04a6\5\u0088E\2\u04a2\u04a6\5\u008aF\2\u04a3\u04a6"+
		"\5\u0188\u00c5\2\u04a4\u04a6\5\u018a\u00c6\2\u04a5\u049a\3\2\2\2\u04a5"+
		"\u049b\3\2\2\2\u04a5\u049c\3\2\2\2\u04a5\u049d\3\2\2\2\u04a5\u049e\3\2"+
		"\2\2\u04a5\u049f\3\2\2\2\u04a5\u04a0\3\2\2\2\u04a5\u04a1\3\2\2\2\u04a5"+
		"\u04a2\3\2\2\2\u04a5\u04a3\3\2\2\2\u04a5\u04a4\3\2\2\2\u04a6\177\3\2\2"+
		"\2\u04a7\u04b0\5\u0084C\2\u04a8\u04b0\5\u00d2j\2\u04a9\u04b0\5\u00caf"+
		"\2\u04aa\u04b0\5\u00ceh\2\u04ab\u04b0\5\u00d0i\2\u04ac\u04b0\5\u0086D"+
		"\2\u04ad\u04b0\5\u0082B\2\u04ae\u04b0\5\u00acW\2\u04af\u04a7\3\2\2\2\u04af"+
		"\u04a8\3\2\2\2\u04af\u04a9\3\2\2\2\u04af\u04aa\3\2\2\2\u04af\u04ab\3\2"+
		"\2\2\u04af\u04ac\3\2\2\2\u04af\u04ad\3\2\2\2\u04af\u04ae\3\2\2\2\u04b0"+
		"\u0081\3\2\2\2\u04b1\u04b2\7U\2\2\u04b2\u04b4\7\u008c\2\2\u04b3\u04b5"+
		"\5\u00d6l\2\u04b4\u04b3\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5\u04b6\3\2\2"+
		"\2\u04b6\u04b7\7k\2\2\u04b7\u04b8\5\u0104\u0083\2\u04b8\u04b9\7\u0088"+
		"\2\2\u04b9\u0083\3\2\2\2\u04ba\u04bc\5\u008eH\2\u04bb\u04ba\3\2\2\2\u04bb"+
		"\u04bc\3\2\2\2\u04bc\u04be\3\2\2\2\u04bd\u04bf\5\u00ecw\2\u04be\u04bd"+
		"\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04c0\3\2\2\2\u04c0\u04c9\7\u0088\2"+
		"\2\u04c1\u04c3\5\u00d6l\2\u04c2\u04c4\5\u008eH\2\u04c3\u04c2\3\2\2\2\u04c3"+
		"\u04c4\3\2\2\2\u04c4\u04c5\3\2\2\2\u04c5\u04c6\5\u00ecw\2\u04c6\u04c7"+
		"\7\u0088\2\2\u04c7\u04c9\3\2\2\2\u04c8\u04bb\3\2\2\2\u04c8\u04c1\3\2\2"+
		"\2\u04c9\u0085\3\2\2\2\u04ca\u04cb\7F\2\2\u04cb\u04cc\7[\2\2\u04cc\u04cd"+
		"\5`\61\2\u04cd\u04ce\7\u0082\2\2\u04ce\u04cf\7\u0095\2\2\u04cf\u04d0\7"+
		"\\\2\2\u04d0\u04d1\7\u0088\2\2\u04d1\u0087\3\2\2\2\u04d2\u04d3\7\u0088"+
		"\2\2\u04d3\u0089\3\2\2\2\u04d4\u04d5\5\u00d6l\2\u04d5\u04d6\7\u0088\2"+
		"\2\u04d6\u008b\3\2\2\2\u04d7\u04de\5\u0090I\2\u04d8\u04de\5\u0096L\2\u04d9"+
		"\u04de\5\u0092J\2\u04da\u04de\7/\2\2\u04db\u04de\7P\2\2\u04dc\u04de\7"+
		"\35\2\2\u04dd\u04d7\3\2\2\2\u04dd\u04d8\3\2\2\2\u04dd\u04d9\3\2\2\2\u04dd"+
		"\u04da\3\2\2\2\u04dd\u04db\3\2\2\2\u04dd\u04dc\3\2\2\2\u04de\u008d\3\2"+
		"\2\2\u04df\u04e1\5\u008cG\2\u04e0\u04e2\5\u00d6l\2\u04e1\u04e0\3\2\2\2"+
		"\u04e1\u04e2\3\2\2\2\u04e2\u04e7\3\2\2\2\u04e3\u04e4\5\u008cG\2\u04e4"+
		"\u04e5\5\u008eH\2\u04e5\u04e7\3\2\2\2\u04e6\u04df\3\2\2\2\u04e6\u04e3"+
		"\3\2\2\2\u04e7\u008f\3\2\2\2\u04e8\u04e9\t\6\2\2\u04e9\u0091\3\2\2\2\u04ea"+
		"\u04eb\t\7\2\2\u04eb\u0093\3\2\2\2\u04ec\u04ed\7\u008c\2\2\u04ed\u0095"+
		"\3\2\2\2\u04ee\u04f2\5\u0098M\2\u04ef\u04f2\5\u0126\u0094\2\u04f0\u04f2"+
		"\5\u00a8U\2\u04f1\u04ee\3\2\2\2\u04f1\u04ef\3\2\2\2\u04f1\u04f0\3\2\2"+
		"\2\u04f2\u0097\3\2\2\2\u04f3\u04f8\5\u009eP\2\u04f4\u04f8\5\u00a4S\2\u04f5"+
		"\u04f8\5\u016e\u00b8\2\u04f6\u04f8\5\u00fe\u0080\2\u04f7\u04f3\3\2\2\2"+
		"\u04f7\u04f4\3\2\2\2\u04f7\u04f5\3\2\2\2\u04f7\u04f6\3\2\2\2\u04f8\u0099"+
		"\3\2\2\2\u04f9\u04fb\5\u0096L\2\u04fa\u04fc\5\u00d6l\2\u04fb\u04fa\3\2"+
		"\2\2\u04fb\u04fc\3\2\2\2\u04fc\u0501\3\2\2\2\u04fd\u04fe\5\u0096L\2\u04fe"+
		"\u04ff\5\u009aN\2\u04ff\u0501\3\2\2\2\u0500\u04f9\3\2\2\2\u0500\u04fd"+
		"\3\2\2\2\u0501\u009b\3\2\2\2\u0502\u0504\5\u0098M\2\u0503\u0505\5\u00d6"+
		"l\2\u0504\u0503\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u050a\3\2\2\2\u0506"+
		"\u0507\5\u0098M\2\u0507\u0508\5\u009cO\2\u0508\u050a\3\2\2\2\u0509\u0502"+
		"\3\2\2\2\u0509\u0506\3\2\2\2\u050a\u009d\3\2\2\2\u050b\u050d\5\f\7\2\u050c"+
		"\u050b\3\2\2\2\u050c\u050d\3\2\2\2\u050d\u050e\3\2\2\2\u050e\u0523\5\u00a0"+
		"Q\2\u050f\u0510\5\f\7\2\u0510\u0511\7J\2\2\u0511\u0512\5\u0164\u00b3\2"+
		"\u0512\u0523\3\2\2\2\u0513\u0523\7\30\2\2\u0514\u0523\7\31\2\2\u0515\u0523"+
		"\7\32\2\2\u0516\u0523\7Y\2\2\u0517\u0523\7\24\2\2\u0518\u0523\7B\2\2\u0519"+
		"\u0523\7\63\2\2\u051a\u0523\7\64\2\2\u051b\u0523\7C\2\2\u051c\u0523\7"+
		"T\2\2\u051d\u0523\7-\2\2\u051e\u0523\7$\2\2\u051f\u0523\7W\2\2\u0520\u0523"+
		"\7\23\2\2\u0521\u0523\5\u00a2R\2\u0522\u050c\3\2\2\2\u0522\u050f\3\2\2"+
		"\2\u0522\u0513\3\2\2\2\u0522\u0514\3\2\2\2\u0522\u0515\3\2\2\2\u0522\u0516"+
		"\3\2\2\2\u0522\u0517\3\2\2\2\u0522\u0518\3\2\2\2\u0522\u0519\3\2\2\2\u0522"+
		"\u051a\3\2\2\2\u0522\u051b\3\2\2\2\u0522\u051c\3\2\2\2\u0522\u051d\3\2"+
		"\2\2\u0522\u051e\3\2\2\2\u0522\u051f\3\2\2\2\u0522\u0520\3\2\2\2\u0522"+
		"\u0521\3\2\2\2\u0523\u009f\3\2\2\2\u0524\u0529\5\u0124\u0093\2\u0525\u0529"+
		"\5\u00a6T\2\u0526\u0529\5\u0094K\2\u0527\u0529\5\u0164\u00b3\2\u0528\u0524"+
		"\3\2\2\2\u0528\u0525\3\2\2\2\u0528\u0526\3\2\2\2\u0528\u0527\3\2\2\2\u0529"+
		"\u00a1\3\2\2\2\u052a\u052b\7 \2\2\u052b\u052c\7[\2\2\u052c\u052d\5^\60"+
		"\2\u052d\u052e\7\\\2\2\u052e\u0534\3\2\2\2\u052f\u0530\7 \2\2\u0530\u0531"+
		"\7[\2\2\u0531\u0532\7\23\2\2\u0532\u0534\7\\\2\2\u0533\u052a\3\2\2\2\u0533"+
		"\u052f\3\2\2\2\u0534\u00a3\3\2\2\2\u0535\u0537\5\u012e\u0098\2\u0536\u0538"+
		"\5\u00d6l\2\u0537\u0536\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u053a\3\2\2"+
		"\2\u0539\u053b\5\f\7\2\u053a\u0539\3\2\2\2\u053a\u053b\3\2\2\2\u053b\u053c"+
		"\3\2\2\2\u053c\u053d\7\u008c\2\2\u053d\u054e\3\2\2\2\u053e\u053f\5\u012e"+
		"\u0098\2\u053f\u0540\5\u0164\u00b3\2\u0540\u054e\3\2\2\2\u0541\u0542\5"+
		"\u012e\u0098\2\u0542\u0544\5\f\7\2\u0543\u0545\7J\2\2\u0544\u0543\3\2"+
		"\2\2\u0544\u0545\3\2\2\2\u0545\u0546\3\2\2\2\u0546\u0547\5\u0164\u00b3"+
		"\2\u0547\u054e\3\2\2\2\u0548\u054a\7\'\2\2\u0549\u054b\5\f\7\2\u054a\u0549"+
		"\3\2\2\2\u054a\u054b\3\2\2\2\u054b\u054c\3\2\2\2\u054c\u054e\7\u008c\2"+
		"\2\u054d\u0535\3\2\2\2\u054d\u053e\3\2\2\2\u054d\u0541\3\2\2\2\u054d\u0548"+
		"\3\2\2\2\u054e\u00a5\3\2\2\2\u054f\u0550\7\u008c\2\2\u0550\u00a7\3\2\2"+
		"\2\u0551\u0552\5\u00aaV\2\u0552\u0554\7_\2\2\u0553\u0555\5\u00b2Z\2\u0554"+
		"\u0553\3\2\2\2\u0554\u0555\3\2\2\2\u0555\u0556\3\2\2\2\u0556\u0557\7`"+
		"\2\2\u0557\u055f\3\2\2\2\u0558\u0559\5\u00aaV\2\u0559\u055a\7_\2\2\u055a"+
		"\u055b\5\u00b2Z\2\u055b\u055c\7\u0082\2\2\u055c\u055d\7`\2\2\u055d\u055f"+
		"\3\2\2\2\u055e\u0551\3\2\2\2\u055e\u0558\3\2\2\2\u055f\u00a9\3\2\2\2\u0560"+
		"\u0562\5\u00aeX\2\u0561\u0563\5\u00d6l\2\u0562\u0561\3\2\2\2\u0562\u0563"+
		"\3\2\2\2\u0563\u0565\3\2\2\2\u0564\u0566\7\u008c\2\2\u0565\u0564\3\2\2"+
		"\2\u0565\u0566\3\2\2\2\u0566\u0568\3\2\2\2\u0567\u0569\5\u00b0Y\2\u0568"+
		"\u0567\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u0574\3\2\2\2\u056a\u056c\5\u00ae"+
		"X\2\u056b\u056d\5\u00d6l\2\u056c\u056b\3\2\2\2\u056c\u056d\3\2\2\2\u056d"+
		"\u056e\3\2\2\2\u056e\u056f\5\f\7\2\u056f\u0571\7\u008c\2\2\u0570\u0572"+
		"\5\u00b0Y\2\u0571\u0570\3\2\2\2\u0571\u0572\3\2\2\2\u0572\u0574\3\2\2"+
		"\2\u0573\u0560\3\2\2\2\u0573\u056a\3\2\2\2\u0574\u00ab\3\2\2\2\u0575\u0577"+
		"\5\u00aeX\2\u0576\u0578\5\u00d6l\2\u0577\u0576\3\2\2\2\u0577\u0578\3\2"+
		"\2\2\u0578\u0579\3\2\2\2\u0579\u057b\7\u008c\2\2\u057a\u057c\5\u00b0Y"+
		"\2\u057b\u057a\3\2\2\2\u057b\u057c\3\2\2\2\u057c\u057d\3\2\2\2\u057d\u057e"+
		"\7\u0088\2\2\u057e\u00ad\3\2\2\2\u057f\u0585\7\'\2\2\u0580\u0581\7\'\2"+
		"\2\u0581\u0585\7\33\2\2\u0582\u0583\7\'\2\2\u0583\u0585\7H\2\2\u0584\u057f"+
		"\3\2\2\2\u0584\u0580\3\2\2\2\u0584\u0582\3\2\2\2\u0585\u00af\3\2\2\2\u0586"+
		"\u0587\7\u0086\2\2\u0587\u0588\5\u009aN\2\u0588\u00b1\3\2\2\2\u0589\u058a"+
		"\bZ\1\2\u058a\u058b\5\u00b4[\2\u058b\u0591\3\2\2\2\u058c\u058d\f\3\2\2"+
		"\u058d\u058e\7\u0082\2\2\u058e\u0590\5\u00b4[\2\u058f\u058c\3\2\2\2\u0590"+
		"\u0593\3\2\2\2\u0591\u058f\3\2\2\2\u0591\u0592\3\2\2\2\u0592\u00b3\3\2"+
		"\2\2\u0593\u0591\3\2\2\2\u0594\u059a\5\u00b6\\\2\u0595\u0596\5\u00b6\\"+
		"\2\u0596\u0597\7k\2\2\u0597\u0598\5`\61\2\u0598\u059a\3\2\2\2\u0599\u0594"+
		"\3\2\2\2\u0599\u0595\3\2\2\2\u059a\u00b5\3\2\2\2\u059b\u059c\7\u008c\2"+
		"\2\u059c\u00b7\3\2\2\2\u059d\u05a0\5\u00ba^\2\u059e\u05a0\5\u00c8e\2\u059f"+
		"\u059d\3\2\2\2\u059f\u059e\3\2\2\2\u05a0\u00b9\3\2\2\2\u05a1\u05a2\7\u008c"+
		"\2\2\u05a2\u00bb\3\2\2\2\u05a3\u05a6\5\u00be`\2\u05a4\u05a6\5\u00c4c\2"+
		"\u05a5\u05a3\3\2\2\2\u05a5\u05a4\3\2\2\2\u05a6\u00bd\3\2\2\2\u05a7\u05aa"+
		"\5\u00c0a\2\u05a8\u05aa\5\u00c2b\2\u05a9\u05a7\3\2\2\2\u05a9\u05a8\3\2"+
		"\2\2\u05aa\u00bf\3\2\2\2\u05ab\u05ad\7\62\2\2\u05ac\u05ab\3\2\2\2\u05ac"+
		"\u05ad\3\2\2\2\u05ad\u05ae\3\2\2\2\u05ae\u05af\7\66\2\2\u05af\u05b0\7"+
		"\u008c\2\2\u05b0\u05b1\7_\2\2\u05b1\u05b2\5\u00c6d\2\u05b2\u05b3\7`\2"+
		"\2\u05b3\u00c1\3\2\2\2\u05b4\u05b6\7\62\2\2\u05b5\u05b4\3\2\2\2\u05b5"+
		"\u05b6\3\2\2\2\u05b6\u05b7\3\2\2\2\u05b7\u05b8\7\66\2\2\u05b8\u05b9\5"+
		"\u00ba^\2\u05b9\u05ba\7_\2\2\u05ba\u05bb\5\u00c6d\2\u05bb\u05bc\7`\2\2"+
		"\u05bc\u00c3\3\2\2\2\u05bd\u05bf\7\62\2\2\u05be\u05bd\3\2\2\2\u05be\u05bf"+
		"\3\2\2\2\u05bf\u05c0\3\2\2\2\u05c0\u05c1\7\66\2\2\u05c1\u05c2\7_\2\2\u05c2"+
		"\u05c3\5\u00c6d\2\u05c3\u05c4\7`\2\2\u05c4\u00c5\3\2\2\2\u05c5\u05c7\5"+
		"|?\2\u05c6\u05c5\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u00c7\3\2\2\2\u05c8"+
		"\u05c9\7\u008c\2\2\u05c9\u00c9\3\2\2\2\u05ca\u05cb\7\66\2\2\u05cb\u05cc"+
		"\7\u008c\2\2\u05cc\u05cd\7k\2\2\u05cd\u05ce\5\u00ccg\2\u05ce\u05cf\7\u0088"+
		"\2\2\u05cf\u00cb\3\2\2\2\u05d0\u05d2\5\f\7\2\u05d1\u05d0\3\2\2\2\u05d1"+
		"\u05d2\3\2\2\2\u05d2\u05d3\3\2\2\2\u05d3\u05d4\5\u00b8]\2\u05d4\u00cd"+
		"\3\2\2\2\u05d5\u05d7\7U\2\2\u05d6\u05d8\7R\2\2\u05d7\u05d6\3\2\2\2\u05d7"+
		"\u05d8\3\2\2\2\u05d8\u05d9\3\2\2\2\u05d9\u05da\5\f\7\2\u05da\u05db\5\b"+
		"\5\2\u05db\u05dc\7\u0088\2\2\u05dc\u05e3\3\2\2\2\u05dd\u05de\7U\2\2\u05de"+
		"\u05df\7\u0087\2\2\u05df\u05e0\5\b\5\2\u05e0\u05e1\7\u0088\2\2\u05e1\u05e3"+
		"\3\2\2\2\u05e2\u05d5\3\2\2\2\u05e2\u05dd\3\2\2\2\u05e3\u00cf\3\2\2\2\u05e4"+
		"\u05e6\5\u00d6l\2\u05e5\u05e4\3\2\2\2\u05e5\u05e6\3\2\2\2\u05e6\u05e7"+
		"\3\2\2\2\u05e7\u05e8\7U\2\2\u05e8\u05ea\7\66\2\2\u05e9\u05eb\5\f\7\2\u05ea"+
		"\u05e9\3\2\2\2\u05ea\u05eb\3\2\2\2\u05eb\u05ec\3\2\2\2\u05ec\u05ed\5\u00b8"+
		"]\2\u05ed\u05ee\7\u0088\2\2\u05ee\u00d1\3\2\2\2\u05ef\u05f0\7\22\2\2\u05f0"+
		"\u05f1\7[\2\2\u05f1\u05f2\7\u0095\2\2\u05f2\u05f3\7\\\2\2\u05f3\u05f4"+
		"\7\u0088\2\2\u05f4\u00d3\3\2\2\2\u05f5\u05f6\7*\2\2\u05f6\u05f7\7\u0095"+
		"\2\2\u05f7\u05f9\7_\2\2\u05f8\u05fa\5|?\2\u05f9\u05f8\3\2\2\2\u05f9\u05fa"+
		"\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fb\u0600\7`\2\2\u05fc\u05fd\7*\2\2\u05fd"+
		"\u05fe\7\u0095\2\2\u05fe\u0600\5~@\2\u05ff\u05f5\3\2\2\2\u05ff\u05fc\3"+
		"\2\2\2\u0600\u00d5\3\2\2\2\u0601\u0602\bl\1\2\u0602\u0603\5\u00d8m\2\u0603"+
		"\u0608\3\2\2\2\u0604\u0605\f\3\2\2\u0605\u0607\5\u00d8m\2\u0606\u0604"+
		"\3\2\2\2\u0607\u060a\3\2\2\2\u0608\u0606\3\2\2\2\u0608\u0609\3\2\2\2\u0609"+
		"\u00d7\3\2\2\2\u060a\u0608\3\2\2\2\u060b\u060c\7]\2\2\u060c\u060d\7]\2"+
		"\2\u060d\u060e\5\u00dco\2\u060e\u060f\7^\2\2\u060f\u0610\7^\2\2\u0610"+
		"\u0613\3\2\2\2\u0611\u0613\5\u00dan\2\u0612\u060b\3\2\2\2\u0612\u0611"+
		"\3\2\2\2\u0613\u00d9\3\2\2\2\u0614\u0615\7\20\2\2\u0615\u0616\7[\2\2\u0616"+
		"\u0618\5\u0104\u0083\2\u0617\u0619\7\u008b\2\2\u0618\u0617\3\2\2\2\u0618"+
		"\u0619\3\2\2\2\u0619\u061a\3\2\2\2\u061a\u061b\7\\\2\2\u061b\u0625\3\2"+
		"\2\2\u061c\u061d\7\20\2\2\u061d\u061e\7[\2\2\u061e\u0620\5`\61\2\u061f"+
		"\u0621\7\u008b\2\2\u0620\u061f\3\2\2\2\u0620\u0621\3\2\2\2\u0621\u0622"+
		"\3\2\2\2\u0622\u0623\7\\\2\2\u0623\u0625\3\2\2\2\u0624\u0614\3\2\2\2\u0624"+
		"\u061c\3\2\2\2\u0625\u00db\3\2\2\2\u0626\u0628\bo\1\2\u0627\u0629\5\u00de"+
		"p\2\u0628\u0627\3\2\2\2\u0628\u0629\3\2\2\2\u0629\u062e\3\2\2\2\u062a"+
		"\u062b\5\u00dep\2\u062b\u062c\7\u008b\2\2\u062c\u062e\3\2\2\2\u062d\u0626"+
		"\3\2\2\2\u062d\u062a\3\2\2\2\u062e\u063b\3\2\2\2\u062f\u0630\f\5\2\2\u0630"+
		"\u0632\7\u0082\2\2\u0631\u0633\5\u00dep\2\u0632\u0631\3\2\2\2\u0632\u0633"+
		"\3\2\2\2\u0633\u063a\3\2\2\2\u0634\u0635\f\3\2\2\u0635\u0636\7\u0082\2"+
		"\2\u0636\u0637\5\u00dep\2\u0637\u0638\7\u008b\2\2\u0638\u063a\3\2\2\2"+
		"\u0639\u062f\3\2\2\2\u0639\u0634\3\2\2\2\u063a\u063d\3\2\2\2\u063b\u0639"+
		"\3\2\2\2\u063b\u063c\3\2\2\2\u063c\u00dd\3\2\2\2\u063d\u063b\3\2\2\2\u063e"+
		"\u0640\5\u00e0q\2\u063f\u0641\5\u00e6t\2\u0640\u063f\3\2\2\2\u0640\u0641"+
		"\3\2\2\2\u0641\u00df\3\2\2\2\u0642\u0645\7\u008c\2\2\u0643\u0645\5\u00e2"+
		"r\2\u0644\u0642\3\2\2\2\u0644\u0643\3\2\2\2\u0645\u00e1\3\2\2\2\u0646"+
		"\u0647\5\u00e4s\2\u0647\u0648\7\u0087\2\2\u0648\u0649\7\u008c\2\2\u0649"+
		"\u00e3\3\2\2\2\u064a\u064b\7\u008c\2\2\u064b\u00e5\3\2\2\2\u064c\u064d"+
		"\7[\2\2\u064d\u064e\5\u00e8u\2\u064e\u064f\7\\\2\2\u064f\u00e7\3\2\2\2"+
		"\u0650\u0652\bu\1\2\u0651\u0653\5\u00eav\2\u0652\u0651\3\2\2\2\u0652\u0653"+
		"\3\2\2\2\u0653\u0658\3\2\2\2\u0654\u0655\f\3\2\2\u0655\u0657\5\u00eav"+
		"\2\u0656\u0654\3\2\2\2\u0657\u065a\3\2\2\2\u0658\u0656\3\2\2\2\u0658\u0659"+
		"\3\2\2\2\u0659\u00e9\3\2\2\2\u065a\u0658\3\2\2\2\u065b\u065c\7[\2\2\u065c"+
		"\u065d\5\u00e8u\2\u065d\u065e\7\\\2\2\u065e\u0668\3\2\2\2\u065f\u0660"+
		"\7]\2\2\u0660\u0661\5\u00e8u\2\u0661\u0662\7^\2\2\u0662\u0668\3\2\2\2"+
		"\u0663\u0664\7_\2\2\u0664\u0665\5\u00e8u\2\u0665\u0666\7`\2\2\u0666\u0668"+
		"\3\2\2\2\u0667\u065b\3\2\2\2\u0667\u065f\3\2\2\2\u0667\u0663\3\2\2\2\u0668"+
		"\u00eb\3\2\2\2\u0669\u066a\bw\1\2\u066a\u066b\5\u00eex\2\u066b\u0671\3"+
		"\2\2\2\u066c\u066d\f\3\2\2\u066d\u066e\7\u0082\2\2\u066e\u0670\5\u00ee"+
		"x\2\u066f\u066c\3\2\2\2\u0670\u0673\3\2\2\2\u0671\u066f\3\2\2\2\u0671"+
		"\u0672\3\2\2\2\u0672\u00ed\3\2\2\2\u0673\u0671\3\2\2\2\u0674\u0676\5\u00f0"+
		"y\2\u0675\u0677\5\u011a\u008e\2\u0676\u0675\3\2\2\2\u0676\u0677\3\2\2"+
		"\2\u0677\u00ef\3\2\2\2\u0678\u067e\5\u00f2z\2\u0679\u067a\5\u00f4{\2\u067a"+
		"\u067b\5\u00f6|\2\u067b\u067c\5\u00f8}\2\u067c\u067e\3\2\2\2\u067d\u0678"+
		"\3\2\2\2\u067d\u0679\3\2\2\2\u067e\u00f1\3\2\2\2\u067f\u0684\5\u00f4{"+
		"\2\u0680\u0681\5\u00fa~\2\u0681\u0682\5\u00f2z\2\u0682\u0684\3\2\2\2\u0683"+
		"\u067f\3\2\2\2\u0683\u0680\3\2\2\2\u0684\u00f3\3\2\2\2\u0685\u0686\b{"+
		"\1\2\u0686\u0688\5\u0102\u0082\2\u0687\u0689\5\u00d6l\2\u0688\u0687\3"+
		"\2\2\2\u0688\u0689\3\2\2\2\u0689\u068f\3\2\2\2\u068a\u068b\7[\2\2\u068b"+
		"\u068c\5\u00f2z\2\u068c\u068d\7\\\2\2\u068d\u068f\3\2\2\2\u068e\u0685"+
		"\3\2\2\2\u068e\u068a\3\2\2\2\u068f\u069d\3\2\2\2\u0690\u0691\f\5\2\2\u0691"+
		"\u069c\5\u00f6|\2\u0692\u0693\f\4\2\2\u0693\u0695\7]\2\2\u0694\u0696\5"+
		"`\61\2\u0695\u0694\3\2\2\2\u0695\u0696\3\2\2\2\u0696\u0697\3\2\2\2\u0697"+
		"\u0699\7^\2\2\u0698\u069a\5\u00d6l\2\u0699\u0698\3\2\2\2\u0699\u069a\3"+
		"\2\2\2\u069a\u069c\3\2\2\2\u069b\u0690\3\2\2\2\u069b\u0692\3\2\2\2\u069c"+
		"\u069f\3\2\2\2\u069d\u069b\3\2\2\2\u069d\u069e\3\2\2\2\u069e\u00f5\3\2"+
		"\2\2\u069f\u069d\3\2\2\2\u06a0\u06a1\7[\2\2\u06a1\u06a2\5\u0110\u0089"+
		"\2\u06a2\u06a4\7\\\2\2\u06a3\u06a5\5\u00fc\177\2\u06a4\u06a3\3\2\2\2\u06a4"+
		"\u06a5\3\2\2\2\u06a5\u06a7\3\2\2\2\u06a6\u06a8\5\u0100\u0081\2\u06a7\u06a6"+
		"\3\2\2\2\u06a7\u06a8\3\2\2\2\u06a8\u06aa\3\2\2\2\u06a9\u06ab\5\u0180\u00c1"+
		"\2\u06aa\u06a9\3\2\2\2\u06aa\u06ab\3\2\2\2\u06ab\u06ad\3\2\2\2\u06ac\u06ae"+
		"\5\u00d6l\2\u06ad\u06ac\3\2\2\2\u06ad\u06ae\3\2\2\2\u06ae\u00f7\3\2\2"+
		"\2\u06af\u06b0\7\u0084\2\2\u06b0\u06b2\5\u009cO\2\u06b1\u06b3\5\u0106"+
		"\u0084\2\u06b2\u06b1\3\2\2\2\u06b2\u06b3\3\2\2\2\u06b3\u00f9\3\2\2\2\u06b4"+
		"\u06b6\7c\2\2\u06b5\u06b7\5\u00d6l\2\u06b6\u06b5\3\2\2\2\u06b6\u06b7\3"+
		"\2\2\2\u06b7\u06b9\3\2\2\2\u06b8\u06ba\5\u00fc\177\2\u06b9\u06b8\3\2\2"+
		"\2\u06b9\u06ba\3\2\2\2\u06ba\u06cc\3\2\2\2\u06bb\u06bd\7g\2\2\u06bc\u06be"+
		"\5\u00d6l\2\u06bd\u06bc\3\2\2\2\u06bd\u06be\3\2\2\2\u06be\u06cc\3\2\2"+
		"\2\u06bf\u06c1\7~\2\2\u06c0\u06c2\5\u00d6l\2\u06c1\u06c0\3\2\2\2\u06c1"+
		"\u06c2\3\2\2\2\u06c2\u06cc\3\2\2\2\u06c3\u06c4\5\f\7\2\u06c4\u06c6\7c"+
		"\2\2\u06c5\u06c7\5\u00d6l\2\u06c6\u06c5\3\2\2\2\u06c6\u06c7\3\2\2\2\u06c7"+
		"\u06c9\3\2\2\2\u06c8\u06ca\5\u00fc\177\2\u06c9\u06c8\3\2\2\2\u06c9\u06ca"+
		"\3\2\2\2\u06ca\u06cc\3\2\2\2\u06cb\u06b4\3\2\2\2\u06cb\u06bb\3\2\2\2\u06cb"+
		"\u06bf\3\2\2\2\u06cb\u06c3\3\2\2\2\u06cc\u00fb\3\2\2\2\u06cd\u06cf\5\u00fe"+
		"\u0080\2\u06ce\u06d0\5\u00fc\177\2\u06cf\u06ce\3\2\2\2\u06cf\u06d0\3\2"+
		"\2\2\u06d0\u00fd\3\2\2\2\u06d1\u06d2\t\b\2\2\u06d2\u00ff\3\2\2\2\u06d3"+
		"\u06d4\t\t\2\2\u06d4\u0101\3\2\2\2\u06d5\u06d7\7\u008b\2\2\u06d6\u06d5"+
		"\3\2\2\2\u06d6\u06d7\3\2\2\2\u06d7\u06d8\3\2\2\2\u06d8\u06d9\5\6\4\2\u06d9"+
		"\u0103\3\2\2\2\u06da\u06dc\5\u009aN\2\u06db\u06dd\5\u0106\u0084\2\u06dc"+
		"\u06db\3\2\2\2\u06dc\u06dd\3\2\2\2\u06dd\u0105\3\2\2\2\u06de\u06e7\5\u0108"+
		"\u0085\2\u06df\u06e1\5\u010a\u0086\2\u06e0\u06df\3\2\2\2\u06e0\u06e1\3"+
		"\2\2\2\u06e1\u06e2\3\2\2\2\u06e2\u06e3\5\u00f6|\2\u06e3\u06e4\5\u00f8"+
		"}\2\u06e4\u06e7\3\2\2\2\u06e5\u06e7\5\u010c\u0087\2\u06e6\u06de\3\2\2"+
		"\2\u06e6\u06e0\3\2\2\2\u06e6\u06e5\3\2\2\2\u06e7\u0107\3\2\2\2\u06e8\u06ee"+
		"\5\u010a\u0086\2\u06e9\u06eb\5\u00fa~\2\u06ea\u06ec\5\u0108\u0085\2\u06eb"+
		"\u06ea\3\2\2\2\u06eb\u06ec\3\2\2\2\u06ec\u06ee\3\2\2\2\u06ed\u06e8\3\2"+
		"\2\2\u06ed\u06e9\3\2\2\2\u06ee\u0109\3\2\2\2\u06ef\u06f0\b\u0086\1\2\u06f0"+
		"\u06fe\5\u00f6|\2\u06f1\u06f3\7]\2\2\u06f2\u06f4\5`\61\2\u06f3\u06f2\3"+
		"\2\2\2\u06f3\u06f4\3\2\2\2\u06f4\u06f5\3\2\2\2\u06f5\u06f7\7^\2\2\u06f6"+
		"\u06f8\5\u00d6l\2\u06f7\u06f6\3\2\2\2\u06f7\u06f8\3\2\2\2\u06f8\u06fe"+
		"\3\2\2\2\u06f9\u06fa\7[\2\2\u06fa\u06fb\5\u0108\u0085\2\u06fb\u06fc\7"+
		"\\\2\2\u06fc\u06fe\3\2\2\2\u06fd\u06ef\3\2\2\2\u06fd\u06f1\3\2\2\2\u06fd"+
		"\u06f9\3\2\2\2\u06fe\u070c\3\2\2\2\u06ff\u0700\f\7\2\2\u0700\u070b\5\u00f6"+
		"|\2\u0701\u0702\f\5\2\2\u0702\u0704\7]\2\2\u0703\u0705\5`\61\2\u0704\u0703"+
		"\3\2\2\2\u0704\u0705\3\2\2\2\u0705\u0706\3\2\2\2\u0706\u0708\7^\2\2\u0707"+
		"\u0709\5\u00d6l\2\u0708\u0707\3\2\2\2\u0708\u0709\3\2\2\2\u0709\u070b"+
		"\3\2\2\2\u070a\u06ff\3\2\2\2\u070a\u0701\3\2\2\2\u070b\u070e\3\2\2\2\u070c"+
		"\u070a\3\2\2\2\u070c\u070d\3\2\2\2\u070d\u010b\3\2\2\2\u070e\u070c\3\2"+
		"\2\2\u070f\u0714\5\u010e\u0088\2\u0710\u0711\5\u00fa~\2\u0711\u0712\5"+
		"\u010c\u0087\2\u0712\u0714\3\2\2\2\u0713\u070f\3\2\2\2\u0713\u0710\3\2"+
		"\2\2\u0714\u010d\3\2\2\2\u0715\u0716\b\u0088\1\2\u0716\u0717\7\u008b\2"+
		"\2\u0717\u0725\3\2\2\2\u0718\u0719\f\5\2\2\u0719\u0724\5\u00f6|\2\u071a"+
		"\u071b\f\4\2\2\u071b\u071d\7]\2\2\u071c\u071e\5`\61\2\u071d\u071c\3\2"+
		"\2\2\u071d\u071e\3\2\2\2\u071e\u071f\3\2\2\2\u071f\u0721\7^\2\2\u0720"+
		"\u0722\5\u00d6l\2\u0721\u0720\3\2\2\2\u0721\u0722\3\2\2\2\u0722\u0724"+
		"\3\2\2\2\u0723\u0718\3\2\2\2\u0723\u071a\3\2\2\2\u0724\u0727\3\2\2\2\u0725"+
		"\u0723\3\2\2\2\u0725\u0726\3\2\2\2\u0726\u010f\3\2\2\2\u0727\u0725\3\2"+
		"\2\2\u0728\u072a\5\u0112\u008a\2\u0729\u0728\3\2\2\2\u0729\u072a\3\2\2"+
		"\2\u072a\u072c\3\2\2\2\u072b\u072d\7\u008b\2\2\u072c\u072b\3\2\2\2\u072c"+
		"\u072d\3\2\2\2\u072d\u0733\3\2\2\2\u072e\u072f\5\u0112\u008a\2\u072f\u0730"+
		"\7\u0082\2\2\u0730\u0731\7\u008b\2\2\u0731\u0733\3\2\2\2\u0732\u0729\3"+
		"\2\2\2\u0732\u072e\3\2\2\2\u0733\u0111\3\2\2\2\u0734\u0735\b\u008a\1\2"+
		"\u0735\u0736\5\u0114\u008b\2\u0736\u073c\3\2\2\2\u0737\u0738\f\3\2\2\u0738"+
		"\u0739\7\u0082\2\2\u0739\u073b\5\u0114\u008b\2\u073a\u0737\3\2\2\2\u073b"+
		"\u073e\3\2\2\2\u073c\u073a\3\2\2\2\u073c\u073d\3\2\2\2\u073d\u0113\3\2"+
		"\2\2\u073e\u073c\3\2\2\2\u073f\u0777\5\4\3\2\u0740\u0777\5 \21\2\u0741"+
		"\u0777\5*\26\2\u0742\u0777\5L\'\2\u0743\u0777\5P)\2\u0744\u0777\5D#\2"+
		"\u0745\u0777\5N(\2\u0746\u0777\5Z.\2\u0747\u0777\5> \2\u0748\u0777\5X"+
		"-\2\u0749\u0777\5`\61\2\u074a\u0777\5:\36\2\u074b\u0777\5\6\4\2\u074c"+
		"\u0777\5R*\2\u074d\u0777\5\16\b\2\u074e\u0777\5T+\2\u074f\u0777\5V,\2"+
		"\u0750\u0777\5B\"\2\u0751\u0777\5.\30\2\u0752\u0777\5<\37\2\u0753\u0777"+
		"\5J&\2\u0754\u0777\5F$\2\u0755\u0777\5\u017e\u00c0\2\u0756\u0777\5h\65"+
		"\2\u0757\u0759\5\u00d6l\2\u0758\u0757\3\2\2\2\u0758\u0759\3\2\2\2\u0759"+
		"\u075a\3\2\2\2\u075a\u075b\5\u008eH\2\u075b\u075c\5\u00f0y\2\u075c\u0777"+
		"\3\2\2\2\u075d\u075f\5\u00d6l\2\u075e\u075d\3\2\2\2\u075e\u075f\3\2\2"+
		"\2\u075f\u0760\3\2\2\2\u0760\u0761\5\u008eH\2\u0761\u0762\5\u00f0y\2\u0762"+
		"\u0763\7k\2\2\u0763\u0764\5\u011e\u0090\2\u0764\u0777\3\2\2\2\u0765\u0767"+
		"\5\u00d6l\2\u0766\u0765\3\2\2\2\u0766\u0767\3\2\2\2\u0767\u0768\3\2\2"+
		"\2\u0768\u076a\5\u008eH\2\u0769\u076b\5\u0106\u0084\2\u076a\u0769\3\2"+
		"\2\2\u076a\u076b\3\2\2\2\u076b\u0777\3\2\2\2\u076c\u076e\5\u00d6l\2\u076d"+
		"\u076c\3\2\2\2\u076d\u076e\3\2\2\2\u076e\u076f\3\2\2\2\u076f\u0771\5\u008e"+
		"H\2\u0770\u0772\5\u0106\u0084\2\u0771\u0770\3\2\2\2\u0771\u0772\3\2\2"+
		"\2\u0772\u0773\3\2\2\2\u0773\u0774\7k\2\2\u0774\u0775\5\u011e\u0090\2"+
		"\u0775\u0777\3\2\2\2\u0776\u073f\3\2\2\2\u0776\u0740\3\2\2\2\u0776\u0741"+
		"\3\2\2\2\u0776\u0742\3\2\2\2\u0776\u0743\3\2\2\2\u0776\u0744\3\2\2\2\u0776"+
		"\u0745\3\2\2\2\u0776\u0746\3\2\2\2\u0776\u0747\3\2\2\2\u0776\u0748\3\2"+
		"\2\2\u0776\u0749\3\2\2\2\u0776\u074a\3\2\2\2\u0776\u074b\3\2\2\2\u0776"+
		"\u074c\3\2\2\2\u0776\u074d\3\2\2\2\u0776\u074e\3\2\2\2\u0776\u074f\3\2"+
		"\2\2\u0776\u0750\3\2\2\2\u0776\u0751\3\2\2\2\u0776\u0752\3\2\2\2\u0776"+
		"\u0753\3\2\2\2\u0776\u0754\3\2\2\2\u0776\u0755\3\2\2\2\u0776\u0756\3\2"+
		"\2\2\u0776\u0758\3\2\2\2\u0776\u075e\3\2\2\2\u0776\u0766\3\2\2\2\u0776"+
		"\u076d\3\2\2\2\u0777\u0115\3\2\2\2\u0778\u077a\5\u00d6l\2\u0779\u0778"+
		"\3\2\2\2\u0779\u077a\3\2\2\2\u077a\u077c\3\2\2\2\u077b\u077d\5\u008eH"+
		"\2\u077c\u077b\3\2\2\2\u077c\u077d\3\2\2\2\u077d\u077e\3\2\2\2\u077e\u0780"+
		"\5\u00f0y\2\u077f\u0781\5\u0138\u009d\2\u0780\u077f\3\2\2\2\u0780\u0781"+
		"\3\2\2\2\u0781\u0782\3\2\2\2\u0782\u0783\5\u0118\u008d\2\u0783\u0117\3"+
		"\2\2\2\u0784\u0786\5\u0150\u00a9\2\u0785\u0784\3\2\2\2\u0785\u0786\3\2"+
		"\2\2\u0786\u0787\3\2\2\2\u0787\u0790\5h\65\2\u0788\u0790\5\u0176\u00bc"+
		"\2\u0789\u078a\7k\2\2\u078a\u078b\7!\2\2\u078b\u0790\7\u0088\2\2\u078c"+
		"\u078d\7k\2\2\u078d\u078e\7\"\2\2\u078e\u0790\7\u0088\2\2\u078f\u0785"+
		"\3\2\2\2\u078f\u0788\3\2\2\2\u078f\u0789\3\2\2\2\u078f\u078c\3\2\2\2\u0790"+
		"\u0119\3\2\2\2\u0791\u0797\5\u011c\u008f\2\u0792\u0793\7[\2\2\u0793\u0794"+
		"\5&\24\2\u0794\u0795\7\\\2\2\u0795\u0797\3\2\2\2\u0796\u0791\3\2\2\2\u0796"+
		"\u0792\3\2\2\2\u0797\u011b\3\2\2\2\u0798\u0799\7k\2\2\u0799\u079c\5\u011e"+
		"\u0090\2\u079a\u079c\5\u0122\u0092\2\u079b\u0798\3\2\2\2\u079b\u079a\3"+
		"\2\2\2\u079c\u011d\3\2\2\2\u079d\u07a0\5Z.\2\u079e\u07a0\5\u0122\u0092"+
		"\2\u079f\u079d\3\2\2\2\u079f\u079e\3\2\2\2\u07a0\u011f\3\2\2\2\u07a1\u07a2"+
		"\b\u0091\1\2\u07a2\u07a4\5\u011e\u0090\2\u07a3\u07a5\7\u008b\2\2\u07a4"+
		"\u07a3\3\2\2\2\u07a4\u07a5\3\2\2\2\u07a5\u07ae\3\2\2\2\u07a6\u07a7\f\3"+
		"\2\2\u07a7\u07a8\7\u0082\2\2\u07a8\u07aa\5\u011e\u0090\2\u07a9\u07ab\7"+
		"\u008b\2\2\u07aa\u07a9\3\2\2\2\u07aa\u07ab\3\2\2\2\u07ab\u07ad\3\2\2\2"+
		"\u07ac\u07a6\3\2\2\2\u07ad\u07b0\3\2\2\2\u07ae\u07ac\3\2\2\2\u07ae\u07af"+
		"\3\2\2\2\u07af\u0121\3\2\2\2\u07b0\u07ae\3\2\2\2\u07b1\u07b2\7_\2\2\u07b2"+
		"\u07b4\5\u0120\u0091\2\u07b3\u07b5\7\u0082\2\2\u07b4\u07b3\3\2\2\2\u07b4"+
		"\u07b5\3\2\2\2\u07b5\u07b6\3\2\2\2\u07b6\u07b7\7`\2\2\u07b7\u07bb\3\2"+
		"\2\2\u07b8\u07b9\7_\2\2\u07b9\u07bb\7`\2\2\u07ba\u07b1\3\2\2\2\u07ba\u07b8"+
		"\3\2\2\2\u07bb\u0123\3\2\2\2\u07bc\u07bf\7\u008c\2\2\u07bd\u07bf\5\u0164"+
		"\u00b3\2\u07be\u07bc\3\2\2\2\u07be\u07bd\3\2\2\2\u07bf\u0125\3\2\2\2\u07c0"+
		"\u07c1\5\u0128\u0095\2\u07c1\u07c3\7_\2\2\u07c2\u07c4\5\u0130\u0099\2"+
		"\u07c3\u07c2\3\2\2\2\u07c3\u07c4\3\2\2\2\u07c4\u07c5\3\2\2\2\u07c5\u07c6"+
		"\7`\2\2\u07c6\u0127\3\2\2\2\u07c7\u07c9\5\u012e\u0098\2\u07c8\u07ca\5"+
		"\u00d6l\2\u07c9\u07c8\3\2\2\2\u07c9\u07ca\3\2\2\2\u07ca\u07cb\3\2\2\2"+
		"\u07cb\u07cd\5\u012a\u0096\2\u07cc\u07ce\5\u012c\u0097\2\u07cd\u07cc\3"+
		"\2\2\2\u07cd\u07ce\3\2\2\2\u07ce\u07d0\3\2\2\2\u07cf\u07d1\5\u013e\u00a0"+
		"\2\u07d0\u07cf\3\2\2\2\u07d0\u07d1\3\2\2\2\u07d1\u07da\3\2\2\2\u07d2\u07d4"+
		"\5\u012e\u0098\2\u07d3\u07d5\5\u00d6l\2\u07d4\u07d3\3\2\2\2\u07d4\u07d5"+
		"\3\2\2\2\u07d5\u07d7\3\2\2\2\u07d6\u07d8\5\u013e\u00a0\2\u07d7\u07d6\3"+
		"\2\2\2\u07d7\u07d8\3\2\2\2\u07d8\u07da\3\2\2\2\u07d9\u07c7\3\2\2\2\u07d9"+
		"\u07d2\3\2\2\2\u07da\u0129\3\2\2\2\u07db\u07dd\5\f\7\2\u07dc\u07db\3\2"+
		"\2\2\u07dc\u07dd\3\2\2\2\u07dd\u07de\3\2\2\2\u07de\u07df\5\u0124\u0093"+
		"\2\u07df\u012b\3\2\2\2\u07e0\u07e1\7,\2\2\u07e1\u012d\3\2\2\2\u07e2\u07e3"+
		"\t\n\2\2\u07e3\u012f\3\2\2\2\u07e4\u07e6\5\u0132\u009a\2\u07e5\u07e7\5"+
		"\u0130\u0099\2\u07e6\u07e5\3\2\2\2\u07e6\u07e7\3\2\2\2\u07e7\u07ee\3\2"+
		"\2\2\u07e8\u07e9\5\u0148\u00a5\2\u07e9\u07eb\7\u0086\2\2\u07ea\u07ec\5"+
		"\u0130\u0099\2\u07eb\u07ea\3\2\2\2\u07eb\u07ec\3\2\2\2\u07ec\u07ee\3\2"+
		"\2\2\u07ed\u07e4\3\2\2\2\u07ed\u07e8\3\2\2\2\u07ee\u0131\3\2\2\2\u07ef"+
		"\u07f1\5\u00d6l\2\u07f0\u07ef\3\2\2\2\u07f0\u07f1\3\2\2\2\u07f1\u07f3"+
		"\3\2\2\2\u07f2\u07f4\5\u008eH\2\u07f3\u07f2\3\2\2\2\u07f3\u07f4\3\2\2"+
		"\2\u07f4\u07f6\3\2\2\2\u07f5\u07f7\5\u0134\u009b\2\u07f6\u07f5\3\2\2\2"+
		"\u07f6\u07f7\3\2\2\2\u07f7\u07f8\3\2\2\2\u07f8\u0800\7\u0088\2\2\u07f9"+
		"\u0800\5\u0116\u008c\2\u07fa\u0800\5\u00ceh\2\u07fb\u0800\5\u0086D\2\u07fc"+
		"\u0800\5\u015c\u00af\2\u07fd\u0800\5\u0082B\2\u07fe\u0800\5\u0088E\2\u07ff"+
		"\u07f0\3\2\2\2\u07ff\u07f9\3\2\2\2\u07ff\u07fa\3\2\2\2\u07ff\u07fb\3\2"+
		"\2\2\u07ff\u07fc\3\2\2\2\u07ff\u07fd\3\2\2\2\u07ff\u07fe\3\2\2\2\u0800"+
		"\u0133\3\2\2\2\u0801\u0802\b\u009b\1\2\u0802\u0803\5\u0136\u009c\2\u0803"+
		"\u0809\3\2\2\2\u0804\u0805\f\3\2\2\u0805\u0806\7\u0082\2\2\u0806\u0808"+
		"\5\u0136\u009c\2\u0807\u0804\3\2\2\2\u0808\u080b\3\2\2\2\u0809\u0807\3"+
		"\2\2\2\u0809\u080a\3\2\2\2\u080a\u0135\3\2\2\2\u080b\u0809\3\2\2\2\u080c"+
		"\u080e\5\u00f0y\2\u080d\u080f\5\u0138\u009d\2\u080e\u080d\3\2\2\2\u080e"+
		"\u080f\3\2\2\2\u080f\u0811\3\2\2\2\u0810\u0812\5\u013c\u009f\2\u0811\u0810"+
		"\3\2\2\2\u0811\u0812\3\2\2\2\u0812\u0820\3\2\2\2\u0813\u0815\5\u00f0y"+
		"\2\u0814\u0816\5\u011c\u008f\2\u0815\u0814\3\2\2\2\u0815\u0816\3\2\2\2"+
		"\u0816\u0820\3\2\2\2\u0817\u0819\7\u008c\2\2\u0818\u0817\3\2\2\2\u0818"+
		"\u0819\3\2\2\2\u0819\u081b\3\2\2\2\u081a\u081c\5\u00d6l\2\u081b\u081a"+
		"\3\2\2\2\u081b\u081c\3\2\2\2\u081c\u081d\3\2\2\2\u081d\u081e\7\u0086\2"+
		"\2\u081e\u0820\5`\61\2\u081f\u080c\3\2\2\2\u081f\u0813\3\2\2\2\u081f\u0818"+
		"\3\2\2\2\u0820\u0137\3\2\2\2\u0821\u0822\b\u009d\1\2\u0822\u0823\5\u013a"+
		"\u009e\2\u0823\u0828\3\2\2\2\u0824\u0825\f\3\2\2\u0825\u0827\5\u013a\u009e"+
		"\2\u0826\u0824\3\2\2\2\u0827\u082a\3\2\2\2\u0828\u0826\3\2\2\2\u0828\u0829"+
		"\3\2\2\2\u0829\u0139\3\2\2\2\u082a\u0828\3\2\2\2\u082b\u082c\t\13\2\2"+
		"\u082c\u013b\3\2\2\2\u082d\u082e\7k\2\2\u082e\u082f\7\u008f\2\2\u082f"+
		"\u0830\b\u009f\1\2\u0830\u013d\3\2\2\2\u0831\u0832\7\u0086\2\2\u0832\u0833"+
		"\5\u0140\u00a1\2\u0833\u013f\3\2\2\2\u0834\u0835\b\u00a1\1\2\u0835\u0837"+
		"\5\u0142\u00a2\2\u0836\u0838\7\u008b\2\2\u0837\u0836\3\2\2\2\u0837\u0838"+
		"\3\2\2\2\u0838\u0841\3\2\2\2\u0839\u083a\f\3\2\2\u083a\u083b\7\u0082\2"+
		"\2\u083b\u083d\5\u0142\u00a2\2\u083c\u083e\7\u008b\2\2\u083d\u083c\3\2"+
		"\2\2\u083d\u083e\3\2\2\2\u083e\u0840\3\2\2\2\u083f\u0839\3\2\2\2\u0840"+
		"\u0843\3\2\2\2\u0841\u083f\3\2\2\2\u0841\u0842\3\2\2\2\u0842\u0141\3\2"+
		"\2\2\u0843\u0841\3\2\2\2\u0844\u0846\5\u00d6l\2\u0845\u0844\3\2\2\2\u0845"+
		"\u0846\3\2\2\2\u0846\u0847\3\2\2\2\u0847\u085a\5\u0146\u00a4\2\u0848\u084a"+
		"\5\u00d6l\2\u0849\u0848\3\2\2\2\u0849\u084a\3\2\2\2\u084a\u084b\3\2\2"+
		"\2\u084b\u084d\7V\2\2\u084c\u084e\5\u0148\u00a5\2\u084d\u084c\3\2\2\2"+
		"\u084d\u084e\3\2\2\2\u084e\u084f\3\2\2\2\u084f\u085a\5\u0146\u00a4\2\u0850"+
		"\u0852\5\u00d6l\2\u0851\u0850\3\2\2\2\u0851\u0852\3\2\2\2\u0852\u0853"+
		"\3\2\2\2\u0853\u0855\5\u0148\u00a5\2\u0854\u0856\7V\2\2\u0855\u0854\3"+
		"\2\2\2\u0855\u0856\3\2\2\2\u0856\u0857\3\2\2\2\u0857\u0858\5\u0146\u00a4"+
		"\2\u0858\u085a\3\2\2\2\u0859\u0845\3\2\2\2\u0859\u0849\3\2\2\2\u0859\u0851"+
		"\3\2\2\2\u085a\u0143\3\2\2\2\u085b\u085d\5\f\7\2\u085c\u085b\3\2\2\2\u085c"+
		"\u085d\3\2\2\2\u085d\u085e\3\2\2\2\u085e\u0861\5\u0124\u0093\2\u085f\u0861"+
		"\5\u00a2R\2\u0860\u085c\3\2\2\2\u0860\u085f\3\2\2\2\u0861\u0145\3\2\2"+
		"\2\u0862\u0863\5\u0144\u00a3\2\u0863\u0147\3\2\2\2\u0864\u0865\t\f\2\2"+
		"\u0865\u0149\3\2\2\2\u0866\u0867\7:\2\2\u0867\u0868\5\u014c\u00a7\2\u0868"+
		"\u014b\3\2\2\2\u0869\u086b\5\u009aN\2\u086a\u086c\5\u014e\u00a8\2\u086b"+
		"\u086a\3\2\2\2\u086b\u086c\3\2\2\2\u086c\u014d\3\2\2\2\u086d\u086f\5\u00fa"+
		"~\2\u086e\u0870\5\u014e\u00a8\2\u086f\u086e\3\2\2\2\u086f\u0870\3\2\2"+
		"\2\u0870\u014f\3\2\2\2\u0871\u0872\7\u0086\2\2\u0872\u0873\5\u0152\u00aa"+
		"\2\u0873\u0151\3\2\2\2\u0874\u0876\5\u0154\u00ab\2\u0875\u0877\7\u008b"+
		"\2\2\u0876\u0875\3\2\2\2\u0876\u0877\3\2\2\2\u0877\u0880\3\2\2\2\u0878"+
		"\u087a\5\u0154\u00ab\2\u0879\u087b\7\u008b\2\2\u087a\u0879\3\2\2\2\u087a"+
		"\u087b\3\2\2\2\u087b\u087c\3\2\2\2\u087c\u087d\7\u0082\2\2\u087d\u087e"+
		"\5\u0152\u00aa\2\u087e\u0880\3\2\2\2\u087f\u0874\3\2\2\2\u087f\u0878\3"+
		"\2\2\2\u0880\u0153\3\2\2\2\u0881\u0882\5\u0156\u00ac\2\u0882\u0884\7["+
		"\2\2\u0883\u0885\5&\24\2\u0884\u0883\3\2\2\2\u0884\u0885\3\2\2\2\u0885"+
		"\u0886\3\2\2\2\u0886\u0887\7\\\2\2\u0887\u088c\3\2\2\2\u0888\u0889\5\u0156"+
		"\u00ac\2\u0889\u088a\5\u0122\u0092\2\u088a\u088c\3\2\2\2\u088b\u0881\3"+
		"\2\2\2\u088b\u0888\3\2\2\2\u088c\u0155\3\2\2\2\u088d\u0890\5\u0144\u00a3"+
		"\2\u088e\u0890\7\u008c\2\2\u088f\u088d\3\2\2\2\u088f\u088e\3\2\2\2\u0890"+
		"\u0157\3\2\2\2\u0891\u0892\7:\2\2\u0892\u0893\5\u018c\u00c7\2\u0893\u0159"+
		"\3\2\2\2\u0894\u0895\7:\2\2\u0895\u0896\7\u0095\2\2\u0896\u089a\7\u008c"+
		"\2\2\u0897\u0898\7:\2\2\u0898\u089a\7\u0098\2\2\u0899\u0894\3\2\2\2\u0899"+
		"\u0897\3\2\2\2\u089a\u015b\3\2\2\2\u089b\u089c\7J\2\2\u089c\u089d\7l\2"+
		"\2\u089d\u089e\5\u015e\u00b0\2\u089e\u089f\7m\2\2\u089f\u08a0\5~@\2\u08a0"+
		"\u015d\3\2\2\2\u08a1\u08a2\b\u00b0\1\2\u08a2\u08a3\5\u0160\u00b1\2\u08a3"+
		"\u08a9\3\2\2\2\u08a4\u08a5\f\3\2\2\u08a5\u08a6\7\u0082\2\2\u08a6\u08a8"+
		"\5\u0160\u00b1\2\u08a7\u08a4\3\2\2\2\u08a8\u08ab\3\2\2\2\u08a9\u08a7\3"+
		"\2\2\2\u08a9\u08aa\3\2\2\2\u08aa\u015f\3\2\2\2\u08ab\u08a9\3\2\2\2\u08ac"+
		"\u08af\5\u0162\u00b2\2\u08ad\u08af\5\u0114\u008b\2\u08ae\u08ac\3\2\2\2"+
		"\u08ae\u08ad\3\2\2\2\u08af\u0161\3\2\2\2\u08b0\u08b2\7\33\2\2\u08b1\u08b3"+
		"\7\u008b\2\2\u08b2\u08b1\3\2\2\2\u08b2\u08b3\3\2\2\2\u08b3\u08b5\3\2\2"+
		"\2\u08b4\u08b6\7\u008c\2\2\u08b5\u08b4\3\2\2\2\u08b5\u08b6\3\2\2\2\u08b6"+
		"\u08e1\3\2\2\2\u08b7\u08b9\7\33\2\2\u08b8\u08ba\7\u008c\2\2\u08b9\u08b8"+
		"\3\2\2\2\u08b9\u08ba\3\2\2\2\u08ba\u08bb\3\2\2\2\u08bb\u08bc\7k\2\2\u08bc"+
		"\u08e1\5\u0104\u0083\2\u08bd\u08bf\7R\2\2\u08be\u08c0\7\u008b\2\2\u08bf"+
		"\u08be\3\2\2\2\u08bf\u08c0\3\2\2\2\u08c0\u08c2\3\2\2\2\u08c1\u08c3\7\u008c"+
		"\2\2\u08c2\u08c1\3\2\2\2\u08c2\u08c3\3\2\2\2\u08c3\u08e1\3\2\2\2\u08c4"+
		"\u08c6\7R\2\2\u08c5\u08c7\7\u008c\2\2\u08c6\u08c5\3\2\2\2\u08c6\u08c7"+
		"\3\2\2\2\u08c7\u08c8\3\2\2\2\u08c8\u08c9\7k\2\2\u08c9\u08e1\5\u0104\u0083"+
		"\2\u08ca\u08cb\7J\2\2\u08cb\u08cc\7l\2\2\u08cc\u08cd\5\u015e\u00b0\2\u08cd"+
		"\u08ce\7m\2\2\u08ce\u08d0\7\33\2\2\u08cf\u08d1\7\u008b\2\2\u08d0\u08cf"+
		"\3\2\2\2\u08d0\u08d1\3\2\2\2\u08d1\u08d3\3\2\2\2\u08d2\u08d4\7\u008c\2"+
		"\2\u08d3\u08d2\3\2\2\2\u08d3\u08d4\3\2\2\2\u08d4\u08e1\3\2\2\2\u08d5\u08d6"+
		"\7J\2\2\u08d6\u08d7\7l\2\2\u08d7\u08d8\5\u015e\u00b0\2\u08d8\u08d9\7m"+
		"\2\2\u08d9\u08db\7\33\2\2\u08da\u08dc\7\u008c\2\2\u08db\u08da\3\2\2\2"+
		"\u08db\u08dc\3\2\2\2\u08dc\u08dd\3\2\2\2\u08dd\u08de\7k\2\2\u08de\u08df"+
		"\5\6\4\2\u08df\u08e1\3\2\2\2\u08e0\u08b0\3\2\2\2\u08e0\u08b7\3\2\2\2\u08e0"+
		"\u08bd\3\2\2\2\u08e0\u08c4\3\2\2\2\u08e0\u08ca\3\2\2\2\u08e0\u08d5\3\2"+
		"\2\2\u08e1\u0163\3\2\2\2\u08e2\u08e3\5\u0168\u00b5\2\u08e3\u08e5\7l\2"+
		"\2\u08e4\u08e6\5\u016a\u00b6\2\u08e5\u08e4\3\2\2\2\u08e5\u08e6\3\2\2\2"+
		"\u08e6\u08e7\3\2\2\2\u08e7\u08e8\7m\2\2\u08e8\u0165\3\2\2\2\u08e9\u08f9"+
		"\5\u0164\u00b3\2\u08ea\u08eb\5\u0158\u00ad\2\u08eb\u08ed\7l\2\2\u08ec"+
		"\u08ee\5\u016a\u00b6\2\u08ed\u08ec\3\2\2\2\u08ed\u08ee\3\2\2\2\u08ee\u08ef"+
		"\3\2\2\2\u08ef\u08f0\7m\2\2\u08f0\u08f9\3\2\2\2\u08f1\u08f2\5\u015a\u00ae"+
		"\2\u08f2\u08f4\7l\2\2\u08f3\u08f5\5\u016a\u00b6\2\u08f4\u08f3\3\2\2\2"+
		"\u08f4\u08f5\3\2\2\2\u08f5\u08f6\3\2\2\2\u08f6\u08f7\7m\2\2\u08f7\u08f9"+
		"\3\2\2\2\u08f8\u08e9\3\2\2\2\u08f8\u08ea\3\2\2\2\u08f8\u08f1\3\2\2\2\u08f9"+
		"\u0167\3\2\2\2\u08fa\u08fb\7\u008c\2\2\u08fb\u0169\3\2\2\2\u08fc\u08fd"+
		"\b\u00b6\1\2\u08fd\u08ff\5\u016c\u00b7\2\u08fe\u0900\7\u008b\2\2\u08ff"+
		"\u08fe\3\2\2\2\u08ff\u0900\3\2\2\2\u0900\u0909\3\2\2\2\u0901\u0902\f\3"+
		"\2\2\u0902\u0903\7\u0082\2\2\u0903\u0905\5\u016c\u00b7\2\u0904\u0906\7"+
		"\u008b\2\2\u0905\u0904\3\2\2\2\u0905\u0906\3\2\2\2\u0906\u0908\3\2\2\2"+
		"\u0907\u0901\3\2\2\2\u0908\u090b\3\2\2\2\u0909\u0907\3\2\2\2\u0909\u090a"+
		"\3\2\2\2\u090a\u016b\3\2\2\2\u090b\u0909\3\2\2\2\u090c\u0910\5\u0104\u0083"+
		"\2\u090d\u0910\5`\61\2\u090e\u0910\5\6\4\2\u090f\u090c\3\2\2\2\u090f\u090d"+
		"\3\2\2\2\u090f\u090e\3\2\2\2\u0910\u016d\3\2\2\2\u0911\u0912\7R\2\2\u0912"+
		"\u0913\5\f\7\2\u0913\u0914\7\u008c\2\2\u0914\u091d\3\2\2\2\u0915\u0916"+
		"\7R\2\2\u0916\u0918\5\f\7\2\u0917\u0919\7J\2\2\u0918\u0917\3\2\2\2\u0918"+
		"\u0919\3\2\2\2\u0919\u091a\3\2\2\2\u091a\u091b\5\u0164\u00b3\2\u091b\u091d"+
		"\3\2\2\2\u091c\u0911\3\2\2\2\u091c\u0915\3\2\2\2\u091d\u016f\3\2\2\2\u091e"+
		"\u0920\7*\2\2\u091f\u091e\3\2\2\2\u091f\u0920\3\2\2\2\u0920\u0921\3\2"+
		"\2\2\u0921\u0922\7J\2\2\u0922\u0923\5~@\2\u0923\u0171\3\2\2\2\u0924\u0925"+
		"\7J\2\2\u0925\u0926\7l\2\2\u0926\u0927\7m\2\2\u0927\u0928\5~@\2\u0928"+
		"\u0173\3\2\2\2\u0929\u092a\7O\2\2\u092a\u092b\5h\65\2\u092b\u092c\5\u0178"+
		"\u00bd\2\u092c\u0175\3\2\2\2\u092d\u092f\7O\2\2\u092e\u0930\5\u0150\u00a9"+
		"\2\u092f\u092e\3\2\2\2\u092f\u0930\3\2\2\2\u0930\u0931\3\2\2\2\u0931\u0932"+
		"\5h\65\2\u0932\u0933\5\u0178\u00bd\2\u0933\u0177\3\2\2\2\u0934\u0936\5"+
		"\u017a\u00be\2\u0935\u0937\5\u0178\u00bd\2\u0936\u0935\3\2\2\2\u0936\u0937"+
		"\3\2\2\2\u0937\u0179\3\2\2\2\u0938\u0939\7\27\2\2\u0939\u093a\7[\2\2\u093a"+
		"\u093b\5\u017c\u00bf\2\u093b\u093c\7\\\2\2\u093c\u093d\5h\65\2\u093d\u017b"+
		"\3\2\2\2\u093e\u0940\5\u00d6l\2\u093f\u093e\3\2\2\2\u093f\u0940\3\2\2"+
		"\2\u0940\u0941\3\2\2\2\u0941\u0942\5\u009aN\2\u0942\u0943\5\u00f0y\2\u0943"+
		"\u094d\3\2\2\2\u0944\u0946\5\u00d6l\2\u0945\u0944\3\2\2\2\u0945\u0946"+
		"\3\2\2\2\u0946\u0947\3\2\2\2\u0947\u0949\5\u009aN\2\u0948\u094a\5\u0106"+
		"\u0084\2\u0949\u0948\3\2\2\2\u0949\u094a\3\2\2\2\u094a\u094d\3\2\2\2\u094b"+
		"\u094d\7\u008b\2\2\u094c\u093f\3\2\2\2\u094c\u0945\3\2\2\2\u094c\u094b"+
		"\3\2\2\2\u094d\u017d\3\2\2\2\u094e\u0950\7M\2\2\u094f\u0951\5Z.\2\u0950"+
		"\u094f\3\2\2\2\u0950\u0951\3\2\2\2\u0951\u017f\3\2\2\2\u0952\u0955\5\u0182"+
		"\u00c2\2\u0953\u0955\5\u0186\u00c4\2\u0954\u0952\3\2\2\2\u0954\u0953\3"+
		"\2\2\2\u0955\u0181\3\2\2\2\u0956\u0957\7M\2\2\u0957\u0959\7[\2\2\u0958"+
		"\u095a\5\u0184\u00c3\2\u0959\u0958\3\2\2\2\u0959\u095a\3\2\2\2\u095a\u095b"+
		"\3\2\2\2\u095b\u095c\7\\\2\2\u095c\u0183\3\2\2\2\u095d\u095e\b\u00c3\1"+
		"\2\u095e\u0960\5\u0104\u0083\2\u095f\u0961\7\u008b\2\2\u0960\u095f\3\2"+
		"\2\2\u0960\u0961\3\2\2\2\u0961\u096a\3\2\2\2\u0962\u0963\f\3\2\2\u0963"+
		"\u0964\7\u0082\2\2\u0964\u0966\5\u0104\u0083\2\u0965\u0967\7\u008b\2\2"+
		"\u0966\u0965\3\2\2\2\u0966\u0967\3\2\2\2\u0967\u0969\3\2\2\2\u0968\u0962"+
		"\3\2\2\2\u0969\u096c\3\2\2\2\u096a\u0968\3\2\2\2\u096a\u096b\3\2\2\2\u096b"+
		"\u0185\3\2\2\2\u096c\u096a\3\2\2\2\u096d\u096e\78\2\2\u096e\u096f\7[\2"+
		"\2\u096f\u0970\5`\61\2\u0970\u0971\7\\\2\2\u0971\u0974\3\2\2\2\u0972\u0974"+
		"\78\2\2\u0973\u096d\3\2\2\2\u0973\u0972\3\2\2\2\u0974\u0187\3\2\2\2\u0975"+
		"\u0976\7\6\2\2\u0976\u0189\3\2\2\2\u0977\u0978\7\3\2\2\u0978\u018b\3\2"+
		"\2\2\u0979\u09aa\7\67\2\2\u097a\u09aa\7\"\2\2\u097b\u097c\7\67\2\2\u097c"+
		"\u097d\7]\2\2\u097d\u09aa\7^\2\2\u097e\u097f\7\"\2\2\u097f\u0980\7]\2"+
		"\2\u0980\u09aa\7^\2\2\u0981\u09aa\7a\2\2\u0982\u09aa\7b\2\2\u0983\u09aa"+
		"\7c\2\2\u0984\u09aa\7d\2\2\u0985\u09aa\7e\2\2\u0986\u09aa\7f\2\2\u0987"+
		"\u09aa\7g\2\2\u0988\u09aa\7h\2\2\u0989\u09aa\7i\2\2\u098a\u09aa\7j\2\2"+
		"\u098b\u09aa\7k\2\2";
	private static final String _serializedATNSegment1 =
		"\u098c\u09aa\7l\2\2\u098d\u09aa\7m\2\2\u098e\u09aa\7n\2\2\u098f\u09aa"+
		"\7o\2\2\u0990\u09aa\7p\2\2\u0991\u09aa\7q\2\2\u0992\u09aa\7r\2\2\u0993"+
		"\u09aa\7s\2\2\u0994\u09aa\7t\2\2\u0995\u09aa\7u\2\2\u0996\u09aa\7v\2\2"+
		"\u0997\u09aa\7w\2\2\u0998\u09aa\7y\2\2\u0999\u09aa\7x\2\2\u099a\u09aa"+
		"\7z\2\2\u099b\u09aa\7{\2\2\u099c\u09aa\7|\2\2\u099d\u09aa\7}\2\2\u099e"+
		"\u09aa\7~\2\2\u099f\u09aa\7\177\2\2\u09a0\u09aa\7\u0080\2\2\u09a1\u09aa"+
		"\7\u0081\2\2\u09a2\u09aa\7\u0082\2\2\u09a3\u09aa\7\u0083\2\2\u09a4\u09aa"+
		"\7\u0084\2\2\u09a5\u09a6\7[\2\2\u09a6\u09aa\7\\\2\2\u09a7\u09a8\7]\2\2"+
		"\u09a8\u09aa\7^\2\2\u09a9\u0979\3\2\2\2\u09a9\u097a\3\2\2\2\u09a9\u097b"+
		"\3\2\2\2\u09a9\u097e\3\2\2\2\u09a9\u0981\3\2\2\2\u09a9\u0982\3\2\2\2\u09a9"+
		"\u0983\3\2\2\2\u09a9\u0984\3\2\2\2\u09a9\u0985\3\2\2\2\u09a9\u0986\3\2"+
		"\2\2\u09a9\u0987\3\2\2\2\u09a9\u0988\3\2\2\2\u09a9\u0989\3\2\2\2\u09a9"+
		"\u098a\3\2\2\2\u09a9\u098b\3\2\2\2\u09a9\u098c\3\2\2\2\u09a9\u098d\3\2"+
		"\2\2\u09a9\u098e\3\2\2\2\u09a9\u098f\3\2\2\2\u09a9\u0990\3\2\2\2\u09a9"+
		"\u0991\3\2\2\2\u09a9\u0992\3\2\2\2\u09a9\u0993\3\2\2\2\u09a9\u0994\3\2"+
		"\2\2\u09a9\u0995\3\2\2\2\u09a9\u0996\3\2\2\2\u09a9\u0997\3\2\2\2\u09a9"+
		"\u0998\3\2\2\2\u09a9\u0999\3\2\2\2\u09a9\u099a\3\2\2\2\u09a9\u099b\3\2"+
		"\2\2\u09a9\u099c\3\2\2\2\u09a9\u099d\3\2\2\2\u09a9\u099e\3\2\2\2\u09a9"+
		"\u099f\3\2\2\2\u09a9\u09a0\3\2\2\2\u09a9\u09a1\3\2\2\2\u09a9\u09a2\3\2"+
		"\2\2\u09a9\u09a3\3\2\2\2\u09a9\u09a4\3\2\2\2\u09a9\u09a5\3\2\2\2\u09a9"+
		"\u09a7\3\2\2\2\u09aa\u018d\3\2\2\2\u09ab\u09b7\7\u008d\2\2\u09ac\u09b7"+
		"\7\u0093\2\2\u09ad\u09b7\7\u0094\2\2\u09ae\u09b0\7\u0095\2\2\u09af\u09ae"+
		"\3\2\2\2\u09b0\u09b1\3\2\2\2\u09b1\u09af\3\2\2\2\u09b1\u09b2\3\2\2\2\u09b2"+
		"\u09b7\3\2\2\2\u09b3\u09b7\5\u0190\u00c9\2\u09b4\u09b7\5\u0192\u00ca\2"+
		"\u09b5\u09b7\5\u0194\u00cb\2\u09b6\u09ab\3\2\2\2\u09b6\u09ac\3\2\2\2\u09b6"+
		"\u09ad\3\2\2\2\u09b6\u09af\3\2\2\2\u09b6\u09b3\3\2\2\2\u09b6\u09b4\3\2"+
		"\2\2\u09b6\u09b5\3\2\2\2\u09b7\u018f\3\2\2\2\u09b8\u09b9\t\r\2\2\u09b9"+
		"\u0191\3\2\2\2\u09ba\u09bb\79\2\2\u09bb\u0193\3\2\2\2\u09bc\u09bd\t\16"+
		"\2\2\u09bd\u0195\3\2\2\2\u013c\u0197\u01a3\u01a7\u01b2\u01b6\u01c5\u01cc"+
		"\u01d1\u01d3\u01d8\u01de\u01e8\u01ef\u01f5\u01f9\u01fe\u0204\u020b\u0211"+
		"\u0214\u0217\u021a\u0221\u0228\u025c\u026b\u0271\u0277\u0284\u0286\u0290"+
		"\u029f\u02a5\u02c3\u02c8\u02cc\u02d0\u02d3\u02d7\u02dd\u02df\u02e7\u02eb"+
		"\u02ee\u02f5\u02fc\u0300\u0305\u0309\u030c\u0311\u0317\u0324\u032f\u0331"+
		"\u0340\u0342\u034e\u0350\u035c\u0370\u0372\u037e\u0380\u038b\u0396\u03a1"+
		"\u03ac\u03b7\u03c1\u03c9\u03d5\u03dc\u03e0\u03e4\u03e8\u03ec\u03f1\u03f4"+
		"\u03f7\u03fd\u0405\u040a\u040d\u0413\u041e\u0435\u0439\u0441\u0447\u045b"+
		"\u045f\u046c\u0470\u0473\u047a\u0482\u048c\u0497\u04a5\u04af\u04b4\u04bb"+
		"\u04be\u04c3\u04c8\u04dd\u04e1\u04e6\u04f1\u04f7\u04fb\u0500\u0504\u0509"+
		"\u050c\u0522\u0528\u0533\u0537\u053a\u0544\u054a\u054d\u0554\u055e\u0562"+
		"\u0565\u0568\u056c\u0571\u0573\u0577\u057b\u0584\u0591\u0599\u059f\u05a5"+
		"\u05a9\u05ac\u05b5\u05be\u05c6\u05d1\u05d7\u05e2\u05e5\u05ea\u05f9\u05ff"+
		"\u0608\u0612\u0618\u0620\u0624\u0628\u062d\u0632\u0639\u063b\u0640\u0644"+
		"\u0652\u0658\u0667\u0671\u0676\u067d\u0683\u0688\u068e\u0695\u0699\u069b"+
		"\u069d\u06a4\u06a7\u06aa\u06ad\u06b2\u06b6\u06b9\u06bd\u06c1\u06c6\u06c9"+
		"\u06cb\u06cf\u06d6\u06dc\u06e0\u06e6\u06eb\u06ed\u06f3\u06f7\u06fd\u0704"+
		"\u0708\u070a\u070c\u0713\u071d\u0721\u0723\u0725\u0729\u072c\u0732\u073c"+
		"\u0758\u075e\u0766\u076a\u076d\u0771\u0776\u0779\u077c\u0780\u0785\u078f"+
		"\u0796\u079b\u079f\u07a4\u07aa\u07ae\u07b4\u07ba\u07be\u07c3\u07c9\u07cd"+
		"\u07d0\u07d4\u07d7\u07d9\u07dc\u07e6\u07eb\u07ed\u07f0\u07f3\u07f6\u07ff"+
		"\u0809\u080e\u0811\u0815\u0818\u081b\u081f\u0828\u0837\u083d\u0841\u0845"+
		"\u0849\u084d\u0851\u0855\u0859\u085c\u0860\u086b\u086f\u0876\u087a\u087f"+
		"\u0884\u088b\u088f\u0899\u08a9\u08ae\u08b2\u08b5\u08b9\u08bf\u08c2\u08c6"+
		"\u08d0\u08d3\u08db\u08e0\u08e5\u08ed\u08f4\u08f8\u08ff\u0905\u0909\u090f"+
		"\u0918\u091c\u091f\u092f\u0936\u093f\u0945\u0949\u094c\u0950\u0954\u0959"+
		"\u0960\u0966\u096a\u0973\u09a9\u09b1\u09b6";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}