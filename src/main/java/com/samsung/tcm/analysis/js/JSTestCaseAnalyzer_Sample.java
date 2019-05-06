//package com.samsung.tcm.analysis.js;
//
//import com.samsung.tcm.core.parser.js.JavaScriptParser;
//import com.samsung.tcm.core.parser.js.JavaScriptParserBaseListener;
//import org.antlr.v4.runtime.ParserRuleContext;
//import org.antlr.v4.runtime.RuleContext;
//
//import java.util.LinkedList;
//import java.util.Stack;
//
///**
// * 1. IDENTIFICATION OF A FUNCTION CALL
// * <p>
// * 1) An 'argument expression' can be 'new expression' or 'function call expression'
// * 2) In grammar, there is no rule for expressing function call due to javascript's nature
// * 3) However, if accept limitation, we can define a function with the below characteristics
// * 4) The new expression and function call have an 'arguments' optionally.
// * 5) Except for the above two, there is no expression that has one or more 'arguments' in its child
// * 6) A new expression has an argument expression in its right below child
// * 7) Therefore, the 'argument expression' whose right upper parent is not 'new expression' is the function call
// * <p>
// * 2. DEFINITION OF A TEST CASE / TEST SUITE
// * <p>
// * 1) There are two methods to define a test case / test suite.
// * 2) One method is to define one by calling a function
// * 3) The other is to define one by declaring a function
// * In order to identify test case definition in a program,
// * 4) in the case of the later, we need to track function declaration expression that is defined at AST given by parser
// * 5) However, in the other case, we need to track function call. This is not a node of AST.
// * 6) This is reason why we have to define a rule for identifying a function call, "call flow analysis".
// * <p>
// * 3. LIMITATION OF THIS SAMPLE
// * <p>
// * 1) There might be logical bugs
// * 2) There are other ways to call a function in javaScript
// * 3) This only considers a case that a parameter given to a function call is a literal or a function expression.
// * 4) In order to handle the case that variables are given to a function call as its parameters, "flow and type analysis" is required
// */
//
//public class JSTestCaseAnalyzer_Sample extends JavaScriptParserBaseListener {
//    // STACKS FOR STATE VARIABLE
//    private static final int HEAD = 0;
//
//    // TRUE IF IT IS POSSIBLY VALID FUNCTION CALL
//    private LinkedList<Boolean> callStateStack = new LinkedList<>();
//
//    // TRUE IF IT IS POSSIBLY VALID FUNCTION-CALL FOR TEST SUITE
//    private LinkedList<Boolean> callForSuiteStateStack = new LinkedList<>();
//
//    // TRUE IF IT IS POSSIBLY VALID FUNCTION-CALL FOR TEST CASE
//    private LinkedList<Boolean> callForCaseStateStack = new LinkedList<>();
//
//    // TRUE IF IT IS IN ARGUMENTS OF POSSIBLY VALID FUNCTION CALL
//    private LinkedList<Boolean> inArgStateStack = new LinkedList<>();
//
//    // CALL STACK
//    private Stack<CallTreeNode> callStack = new Stack<>();
//
//    // RESULT OF STRUCTURING TEST SUITE & TEST CASE BY CALLING FUNCTIONS
//    public CallTreeNode callTree = new CallTreeNode();
//
//    // RESULT OF DEFINING TEST CASE WITHOUT TEST SUITE
//    public LinkedList<CallTreeNode> orphanList = new LinkedList<>();
//
//    // PREDEFINED TOKENS FOR FUNCTIONS TO DEFINE TEST SUITE AND TEST CASEs
//    private static final String SUITE_FUNC_NAME = "describe", TEST_FUNC_NAME = "it";
//
//    // CANDIDATE IDENTIFIER FOR TEST SUITE AND TEST CASE
//    private String candidateTSIdentifier = null, candidateTCIdentifier = null;
//
//    // WHETHER A CALL IS FOR DEFINING A TEST SUITE OR TEST CASE
//    // private boolean validCallForSuite = false, validCallForCase = false;
//
//    public JSTestCaseAnalyzer_Sample() {
//        this.callStack.push(callTree);// ADD A DUMMY NODE AS ROOT
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    //      AST NODE TRAVERSAL : ONLY FOR TEST CASE OR TEST SUITE (DEFINED BY FUNCTION CALL)
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * <p>
//     * CONDITIONS FOR A FUNCTION CALL (e.g., 'describe()' & 'it')
//     * ALL THE BELOW CONDITIONS MUST BE SATISFIED
//     * <p>
//     * 1) The 'ArgumentExpression' node is visited, and its right upper parent is not type of 'NewExpression' node
//     * 2) The 'IdentifierExpression' node is visited, and whose identifier text is 'describe' or 'it'
//     * 3) The 'Arguments' node is visited
//     * 4) The 1st argument is type of 'string literal' node or 'IdentifierExpression' node
//     * 5) The 2nd argument is type of 'FunctionExpression' node or 'IdentifierExpression' node
//     */
//    @Override
//    public void enterArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
//        super.enterArgumentsExpression(ctx);
//
//        inArgStateStack.addFirst(false);
//        callStateStack.addFirst(false);
//
//        ParserRuleContext parent = ctx.getParent();
//        if (!(parent instanceof JavaScriptParser.NewExpressionContext))
//            callStateStack.set(HEAD, true);
//    }
//
//    @Override
//    public void enterIdentifierExpression(JavaScriptParser.IdentifierExpressionContext ctx) {
//        super.enterIdentifierExpression(ctx);
//        if ((peek(callForCaseStateStack) || peek(callForSuiteStateStack))
//                && peek(inArgStateStack)) { //CHECK FUNCTION PARAMETER FOR FUNCTION CALL TODO inArgStateStack 이 필요한가?
//
//            ParserRuleContext parent = ctx.getParent();
//            if (parent == null) return;
//            if (!(parent instanceof JavaScriptParser.ArgumentsContext)) return;
//
//            parent = parent.getParent();
//            if (parent == null) return;
//            if (!(parent instanceof JavaScriptParser.ArgumentsExpressionContext)) return;
//
//            if (callStateStack.getFirst()) {
//                System.out.println("[WARNING] Does not support call flow analysis for variable as the 1st parameter");
//            } else {
//                System.out.println("[WARNING] Does not support call flow analysis for variable as the 2nd parameter");
//            }
//            if (callForSuiteStateStack.getFirst()) {
//                callForSuiteStateStack.removeFirst();
//                candidateTSIdentifier = null;
//            }
//            if (callForCaseStateStack.getFirst()) {
//                callForCaseStateStack.removeFirst();
//                candidateTCIdentifier = null;
//            }
//        } else { // CHECK FUNCTION NAME MATCHES WITH GIVEN STRING
//            RuleContext parent = ctx.parent;
//
//            // RETURN UNLESS THIS IDENTIFIER IS NOT FOR FUNCTION CALL
//            if (parent == null) return;
//            if (!(parent instanceof JavaScriptParser.ArgumentsExpressionContext)) {
//                callStateStack.set(HEAD, false);
//                return;
//            }
//            if (!callStateStack.getFirst()) return;
//
//            String identifier = ctx.Identifier().getText();
//
//            if (identifier.equals(SUITE_FUNC_NAME)) {
//                callForSuiteStateStack.push(true);
//            } else if (identifier.equals(TEST_FUNC_NAME)) {
//                callForCaseStateStack.push(true);
//            } else {
//                callStateStack.set(HEAD, false);
//            }
//        }
//    }
//
//    @Override
//    public void enterArguments(JavaScriptParser.ArgumentsContext ctx) {
//        super.enterArguments(ctx);
//
//        ParserRuleContext parent = ctx.getParent();
//        if (parent == null) return;
//        if (!(parent instanceof JavaScriptParser.ArgumentsExpressionContext)) return;
//
//        if (!callStateStack.getFirst()) return;
//        if (!peek(callForSuiteStateStack) && !peek(callForCaseStateStack)) return;
//
//        inArgStateStack.set(HEAD, true);
//    }
//
////    @Override
////    public void exitArguments(JavaScriptParser.ArgumentsContext ctx) {
////        super.exitArguments(ctx);
////
////        ParserRuleContext parent = ctx.getParent();
////        if (parent == null) return;
////        if (!(parent instanceof JavaScriptParser.ArgumentsExpressionContext)) return;
////
////        inArgStateStack.removeFirst();
////    }
//
//    @Override
//    public void enterLiteralExpression(JavaScriptParser.LiteralExpressionContext ctx) {
//        super.enterLiteralExpression(ctx);
//
//        ParserRuleContext parent = ctx.getParent();
//        if (parent == null) return;
//        if (!(parent instanceof JavaScriptParser.ArgumentsContext)) return;
//
//        parent = parent.getParent();
//        if (parent == null) return;
//        if (!(parent instanceof JavaScriptParser.ArgumentsExpressionContext)) return;
//
//        // CHECK FUNCTION NAME AT FUNCTION CALL
//        if (!callStateStack.getFirst()) return;
//        if (!peek(callForSuiteStateStack) && !peek(callForCaseStateStack)) return;
//        // if (!inArgStateStack.getFirst()) return; // TODO 필요한지 고려해보기
//
//        if (ctx.literal() == null || ctx.literal().StringLiteral() == null) {
//            callStateStack.set(HEAD, false);
//            return;
//        }
//
//        if (peek(callForSuiteStateStack)) {
//            if (peek(callForCaseStateStack)) {                  // NEW TEST CASE FOR A TEST SUITE
//                candidateTCIdentifier = ctx.literal().getText();
//            } else {                                            // NEW TEST SUITE
//                candidateTSIdentifier = ctx.literal().StringLiteral().getText();
//            }
//        } else {                                                // NEW TEST CASE WITHOUT TEST SUITE
//            candidateTCIdentifier = ctx.literal().getText();
//        }
//    }
//
//    @Override
//    public void enterFunctionExpression(JavaScriptParser.FunctionExpressionContext ctx) {
//        super.enterFunctionExpression(ctx);
//
//        ParserRuleContext parent = ctx.getParent();
//        if (parent == null) return;
//        if (!(parent instanceof JavaScriptParser.ArgumentsContext)) return;
//
//        parent = parent.getParent();
//        if (parent == null) return;
//        if (!(parent instanceof JavaScriptParser.ArgumentsExpressionContext)) return;
//
//        if (!callStateStack.getFirst()) return;
//        if (!peek(callForSuiteStateStack) && !peek(callForCaseStateStack)) return;
//        // if (!inArgStateStack.getFirst()) return;
//
//        //AT THE CASE WHEN SATISFIED ALL THE CONDITIONS FOR TC OR TEST SUITE
//        if (peek(callForSuiteStateStack)) {
//            if (peek(callForCaseStateStack)) {                      // NEW TEST CASE FOR A TEST SUITE
//                if (ctx.functionBody() != null) {
//                    TestCase newCase = new TestCase(candidateTCIdentifier);
//                    newCase.setFunctionBody(ctx.functionBody().getText());
//                    // TODO HOW TO SKIP VISITING NEXT FUNCTION EXPRESSION NODE ?
//                    if (callStack.peek() != null) {
//                        // ADD THIS TEST CASE INTO PARENT'S CHILD
//                        callStack.peek().addChild(newCase);
//                    } else {
//                        System.out.println("[WARNING] Stack is empty!");
//                    }
//                }
//            } else {                                // NEW TEST SUITE
//                TestSuite newSuite = new TestSuite(candidateTSIdentifier);
//                // ADD THIS TEST SUITE INTO PARENT'S CHILD
//                callStack.peek().addChild(newSuite);
//                // ADD THIS TEST SUITE TO TOP
//                callStack.push(newSuite);
//            }
//        } else {
//            if (ctx.functionBody() != null) {       // NEW TEST CASE WITHOUT TEST SUITE
//                TestCase newCase = new TestCase(candidateTCIdentifier);
//                newCase.setFunctionBody(ctx.functionBody().getText());
//                // ADD THIS TEST CASE INTO LIST
//                orphanList.addLast(newCase);
//            }
//        }
//    }
//
//    @Override
//    public void exitArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
//        super.exitArgumentsExpression(ctx);
//
//        inArgStateStack.removeFirst();
//
//        ParserRuleContext parent = ctx.getParent();
//        if (!(parent instanceof JavaScriptParser.NewExpressionContext))
//            callStateStack.set(HEAD, true);
//
//        if (!callStateStack.removeFirst()) return;
//        if (!peek(callForSuiteStateStack) && !peek(callForCaseStateStack)) return;
//
//        if (peek(callForSuiteStateStack)) {
//            if (peek(callForCaseStateStack)) {              // WAS NEW TEST CASE FOR A TEST SUITE, LEAF NODE
//                callForCaseStateStack.removeFirst();
//                candidateTCIdentifier = null;
//            } else {                                        // WAS NEW TEST SUITE
//                callStack.pop();
//                callForSuiteStateStack.removeFirst();
//                candidateTSIdentifier = null;
//            }
//        } else {                                            // WAS NEW TEST CASE WITHOUT TEST SUITE
//            callForCaseStateStack.removeFirst();
//            candidateTCIdentifier = null;
//        }
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    //                                              UTILITY
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    private boolean peek(LinkedList<Boolean> list) {
//        if (list.size() > 0) {
//            return list.getFirst();
//        }
//        return false;
//    }
//}