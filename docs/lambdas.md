# Lambdas

## What are Lambdas in Java?

- Introduced in version 8
- Functions as first-class citizens
- Allow you to parameterize behaviour with less verbosity (compared to anonymous classes); this allows you to 
write more flexible, maintainable and concise code.
- Let's code up an example to demonstrate this...

## Syntax

### Basic Lambda Expressions

A function: 
```
x -> x+1
```

A supplier:
```
() -> "hello"

```

Both of these have a parameter list and a return type. The typing can be done via inference by the compiler (although you can type parameters explicitly for clarity).

Lamdas can be multi-line:
```
x -> { String str = x.toString(); 
       return str.toUpperCase(); }
```
However, you should consider refactoring multi-line lambdas of any complexity into a method reference. This will make your code more readable.

### Method References

A method reference:
```
Product::getWeight
```
which is equivalent to the function:
```
p -> p.getWeight()
```

You can also use method references for constructors:
```
Person::new
```

## Functional Interfaces

- The lambda has to have a 'target type', i.e. a variable assignment or a parameter type. It must match this 'target type'.
- The 'target type' must be a 'functional interface'. See the type annotation 'java.lang.FunctionalInterface' for detail.
- The jdk ships with many common functional interfaces. See under the 'java.util.function' package.
- The jdk also ships with functional interface specializations for primitive types (e.g. java.util.function.IntFunction). This is to avoid expensive boxing operations.

## Scoping

- Local variables used by lambdas must be 'effectively final' (this is due to the Java memory model).
- Fields do not have such constraints... but think twice about mutating fields inside lambdas.

## Composition of Lambdas

- The JDK Functional Interfaces often contain 'default methods' which allow you to compose them.
- For instance:
```
final Function<String, String> function1 = String::trim;
final Function<String, Double> doubleExtractor = function1.andThen(Formatter::removeIllegalCharacters).andThen(Double::parseDouble);
```
- The methods must be 'default' in order to maintain the functional interface contract. 

## Exercises

Look at `com.tom.problems.FootballerLambdaExercisesTest`. The goal is to make all the tests pass without
modifying the test class itself. Make sure to read the javadoc class-under-test for hints. When implementing the
solution, don't worry about including robust error-handling.


