# Optionals

## What are Optionals in Java?

- Introduced in version 8
- Represent a possibly absent value in a clear way. This is to help avoid NullPointerExceptions and
make APIs clearer.
- Generally intended to be used as a return type, not as a parameter type.
- You may have used the Guava Optional in the GOL project; I have been encouraging its use. The JDK 8
Optional is very similar but more powerful as takes advantage of lambdas.
- JDK 8 also contains primitive specializations of Optionals (e.g. OptionalInt).

## Syntax

Constructing Optionals:
```
Optional<Customer> missingCustomer = Optional.empty();
Optional<Customer> optionalCustomer1 = Optional.of(customer);
Optional<Customer> optionalCustomer2 = Optional.ofNullable(customerThatMightBeNull);
```

Extracting a value from an Optional:
```
Optional<Customer> optionalCustomer = customerRepository.getCustomer(id);
if (optionalCustomer.isPresent()) {
    // Optional.get will throw an exception if Optional.isPresent returns false
    processCustomer(optionalCustomer.get());
} else {
    throw new CustomerNotFoundException();
}
```

APIs are much clearer with Optionals:
```
public interface CustomerRepository {
    Optional<Customer> getCustomer(long id);   
}

```

## Exercises

Look at `com.tom.problems.FootballerOptionalsExercisesTest`. The goal is to make all the tests pass without
modifying the test class itself. Make sure to read the javadoc class-under-test for hints. When implementing the
solution, don't worry about including robust error-handling.
