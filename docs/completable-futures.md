# Completable Futures

## What are Completable Futures in Java?

- JDK 5 introduced the `Future` interface for representing the result of an asynchronous operation
- What do we mean by asynchronous here? Non-blocking.
- The `Future` interface is limited:
    - The primary methods it has are `done` and `get`
    - You can't easily represent in a non-blocking way:
        - Registering callbacks
        - Composing/combining the results of asynchronous operations
        - Error-handling
- Lots of third-party libraries implemented better APIs for handling asynchronous operations in Java, e.g. Guava's `ListenableFuture`
- JDK 8 shipped with the `CompletableFuture` API which uses ideas from these other libraries and leverages lambdas for more declarative code

## Syntax

```
        // This will execute in the common pool as no custom executor is supplied
        final CompletableFuture<String> asyncResult = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "my data";
        });
        
        // Add a transformation (thenApply) and a operation that will react to the result (whenComplete)
        final CompletableFuture<String> formattedAsyncResult = asyncResult.thenApply(String::toUpperCase)
                                                                            .whenComplete((res, ex) -> System.out.println("Result: " + res + ", Exception: " + ex));
        
        //Do some other things on the current thread

        //Get the result; this is a blocking call!
        String result = formattedAsyncResult.join();

```

## CompletableFutures vs Parallel Streams

- Typically you will want to use CompletableFutures for I/O-bound operations (e.g. network calls):
    - Microservices tend to make lots of network calls as they can be fairly chatty between services.
    - Also, modern web applications often make use of lots of external services.
    - Using futures allows you to free up resources as the calling thread does not block as with a normal synchronous operation.
- Parallel streams are better for CPU-bound operations:
    - The `CompletableFuture` API makes it easy to supply your own thread pool
    - However, Parallel streams push you to use the common ForkJoin pool in the JVM, which defaults to a low size (the number of processors minus 1).
    - Generally for CompletableFutures you should supply a thread pool (via an executor), unless there is another non-common thread pool
being supplied by library code (for instance, a non-blocking HTTP client)

## APIs

- We should generally evolve towards using CompletableFutures
- This may mean adapting third-party APIs to use this interface
- Better than having 3+ different interfaces that represent the same type of operation

## Important

- Note that most `CompletableFuture` API calls have an `async` suffixed variant. This just means that the call will execute on a separate thread 
to the thread that is 'completing' the previous future.
- There are some complexities around exception-handling (CompletionException); consult the javadoc for more details.
- There are some complexities around which thread executes non-async CompletableFuture operations (e.g. thenAccept). This may cause issues in 
certain cases (e.g. blocking operation applied to Async HTTP client future) that you should bear in mind.

## Exercises

Look at `com.tom.problems.FootballerCompletableFuturesExercisesTest`. The goal is to make all the tests pass without
modifying the test class itself. Make sure to read the javadoc class-under-test for hints. When implementing the
solution, don't worry about including robust error-handling.