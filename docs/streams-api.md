# Streams API

## What are Streams in Java?

- An API for processing a sequence of elements that comes from a data source
- Typically the data source will be a collection
- Allows you to express data processing operations declaratively; iteration is abstracted away
- Provides lots of common high-level data processing operations
- Efficiently pipelines operations and uses short-circuiting
- Can be transparently parallelized to take advantage of multi-core hardware 
- Fluent API

## Syntax

```
final List<String> result = list.stream() //start the stream from a list of strings (intermediate)
                                .map(String::toUpperCase) // transform each element to uppercase (intermediate)
                                .filter(s -> s.length() > 10) // only keep elements that are over length 10 (intermediate)
                                .collect(Collectors.toList());  //collect the elements into a list (terminal)

```

## Streams are Lazy

- Stream operations come in two types: intermediate and terminal.
- Intermediate operations return a stream.
- Terminal operations return something else (e.g. a list, an integer, etc)
- Nothing happens until a terminal operation is invoked on a stream.
- Only one terminal operation can be invoked on a stream. The stream cannot be reused after this.

## Common Intermediate Operations

```

filter(Predicate) // only keep elements in the stream that match the predicate

map(Function) // transforms each element in the stream using the function

limit(int) // truncates the length of the stream

distinct() // removes duplicate elements from the stream

sorted() // sorts the stream

```

## Common Terminal Operations

```
count() // Returns an int

collect(Collectors.toList()) // Returns a List<T>

collect(Collectors.groupingBy(Product::getType)) // Returns a Map<Type, List<Product>> 

findFirst() // Returns an Optional<T>

```

## Parallel Streams 

- You can parallelize the processing of a stream by using the `parallel()` intermediate operation.
- Behind the scenes the stream will be processed in parallel.
- The idea is to make use of multiple cores without having to write complex (and error-prone) concurrent code.
- The parallel processing by default will use the Common ForkJoin pool that is shared in the JDK. 
- Often there won't be much reason to use this feature; we should generally justify doing so with a benchmark. Depending on the situation
it may end up taking longer than normal sequential processing.

## Data sources

- Collections are the primary data source you will use
- But there are lots of others, e.g. arrays, files, etc
- The JDK provides APIs for handling these different sources

## Primitive Streams

- The JDK also provide primitive specializations of streams, e.g. IntStream. 
- These allow you to more efficiently process primitive data by avoiding boxing.
- The APIs also provide useful specialised operations, e.g. `Intstream.average()`

## Exercises

Look at `com.tom.problems.FootballerStreamsExercisesTest`. The goal is to make all the tests pass without
modifying the test class itself. Make sure to read the javadoc class-under-test for hints. When implementing the
solution, don't worry about including robust error-handling.
