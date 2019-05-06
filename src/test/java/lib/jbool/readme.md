* 해당 페이지는 [JBOOL EXPRESSION](https://github.com/bpodgursky/jbool_expressions) 에서 가지고 온 것이다.
* TCM 은 [JBOOL EXPRESSION](https://github.com/bpodgursky/jbool_expressions) 이 지원하는 모든 연산자를 지원하지 않을 것이다. 왜냐면 사용자의 오류를 유발하기 때문이다
* 즉 단순화를 위해 AND, OR, PARENTHIS 만을 지원하고
* TC 메타 YAML 에서는 사용자가 & | () 의 4개의 토큰으로 논리식을 구성하도록 한다.
* 리터럴에 대해서는 세부 체크가 필요하다


Project jbool_expressions
========
jbool_expressions is a simple open-source library for creating and manipulating boolean expressions in java.

Example / Usage
====

A basic propositional expression is built out of the types `And`, `Or`, `Not`, `Variable` and `Literal`.  All of these extend the base type Expression.  For example,

```java
    Expression<String> expr = And.of(
        Variable.of("A"),
        Variable.of("B"),
        Or.of(Variable.of("C"), Not.of(Variable.of("C"))));
    System.out.println(expr);
```

We see the expression is what we expect:

```bash
((!C | C) & A & B)
```

### Simplification ###

Of course, this expression contains a useless term (either C or (! C) is always true.)  We can simplify the expression, and see that the extra term is simplified out:

```java
    Expression<String> simplified = RuleSet.simplify(expr);
    System.out.println(expr);
```
outputs:
```bash
(A & B)
```

### Variable Assignment ###

We can assign a value to one of the variables, and see that the expression is simplified after assigning "A" a value:

```java
    Expression<String> halfAssigned = RuleSet.assign(simplified, Collections.singletonMap("A", true));
    System.out.println(halfAssigned);
```
outputs:
```bash
B
```

We can assign the last variable, and see that the expression resolves to a literal "true".

```java
    Expression<String> resolved = RuleSet.assign(halfAssigned, Collections.singletonMap("B", true));
    System.out.println(resolved);
```
outputs:
```bash
true
```

All expressions are immutable (we got a new expression back each time we performed an operation), so we can see that the original expression is unmodified:

```java
    System.out.println(expr);
```
outputs:
```bash
((!C | C) & A & B)
```

### Input String Parsing ###

Alternatively, we could have provided our expression as a String in prefix notation and parsed it.  We can verify that this expression is identical to the one we built manually:

```java
    Expression<String> parsedExpression = RuleSet.simplify(ExprParser.parse("( ( (! C) | C) & A & B)"));
    System.out.println(parsedExpression);
    System.out.println(parsedExpression.equals(simplified));
```
output:
```bash
(A & B)
true
```

### Converting to Disjunctive Normal (Sum-of-Products) Form ###

We can also convert expressions to sum-of-products form instead of just simplifying them.  For example:

```java
    Expression<String> nonStandard = ExprParser.parse("((A | B) & (C | D))");
    System.out.println(nonStandard);

    Expression<String> sopForm = RuleSet.toDNF(nonStandard);
    System.out.println(sopForm);
```
output:
```bash
((A | B) & (C | D))
((A & C) | (A & D) | (B & C) | (B & D))
```

### Converting to Conjunctive Normal (Product-of-Sums) form ###

Likewise, we can convert an expression to product-of-sums form.  For example:

```java
    Expression<String> nonStandard = ExprParser.parse("((A & B) | (C & D))");
    System.out.println(nonStandard);

    Expression<String> posForm = RuleSet.toCNF(nonStandard);
    System.out.println(posForm);

```
output:
```bash
((A & B) | (C & D))
((A | C) & (A | D) & (B | C) & (B | D))
```


All of these examples can also be found in [ExampleRunner](https://github.com/bpodgursky/jbool_expressions/blob/master/src/main/java/com/bpodgursky/jbool_expressions/example/ExampleRunner.java)

Rules
====

The current simplification rules define fairly simple and fast optimizations, and is defined in [RuleSet](https://github.com/bpodgursky/jbool_expressions/blob/master/src/main/java/com/bpodgursky/jbool_expressions/rules/RuleSet.java).
I'm happy to add more sophisticated rules (let me know about them via a PR or issue).  The current rules include:

Literal removal:

```bash
(false & A) => false
(true & A) => A

(false | A) => A
(true | A) => true
```

Negation simplification:

```bash
(!!A ) => A
(A & !A) => false
(A | !A) => true
```

And / Or de-duplication and flattening:

```bash
(A & A & (B & C)) => (A & B & C)
(A | A | (B | C)) => (A | B | C)
```

Child expression simplification:

```bash
(A | B) & (A | B | C) => (A | B)
((A & B) | (A & B & C)) => (A & B)
```

Additional rules for converting to sum-of-products form:

Propagating &:

```bash
( A & ( C | D)) => ((A & C) | (A & D))
```

De Morgan's law:

```bash
(! ( A | B)) => ( (! A) & (! B))
```

Downloading
====

jbool_expressions is available via maven central:

```xml
<dependency>
    <groupId>com.bpodgursky</groupId>
    <artifactId>jbool_expressions</artifactId>
    <version>1.13</version>
</dependency>
```

Building
====

jbool_expressions is built with Maven.  To build from source,

```bash
> mvn package
```

generates a snapshot jar target/jbool_expressions-1.0-SNAPSHOT.jar.

To run the test suite locally,

```bash
> mvn test
```

Development
====

jbool_expressions is very much in-development, and is in no way, shape, or form guaranteed to be stable or bug-free.  Bugs, suggestions, or pull requests are all very welcome.

License
====
Copyright 2013 Ben Podgursky

Licensed under the Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0

