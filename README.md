# sample-project-java
This is a sample project for showcasing how optimization can be performed in a Java project using Artemis 

## Recent Improvements

This project has undergone significant optimization and refactoring to improve performance, code quality, and maintainability. The following changes have been implemented:

### Algorithm Optimizations (`algorithms/Primes.java`)
- **Fixed SumPrimes documentation**: Clarified that the method sums all prime numbers less than n (not the first n primes)
- **Enhanced PrimeFactors method**: 
  - Added proper handling for non-positive numbers (returns empty result)
  - Removed redundant `IsPrime(i)` check in the factorization loop for better performance
  - Added comprehensive comments explaining the optimization logic
  - Improved edge case handling for prime numbers

### Control Flow Optimizations (`control/Single.java`)
- **Optimized sumRange method**: Replaced inefficient array creation and iteration with mathematical formula `n * (n - 1) / 2`
- **Fixed maxArray method**: 
  - Corrected bug where arrays with only negative numbers would return incorrect results
  - Now properly initializes max value with the first array element
  - Added proper handling for empty arrays
- **Enhanced sumModulus method**: Replaced Vector and Stream usage with a simple, more performant loop

### Data Structure Enhancements
#### `datastructures/DsLinkedList.java`
- **Generics support**: Made `shuffle()` and `slice()` methods generic to work with any type `<T>`, not just Integer
- **Improved documentation**: Added comprehensive JavaDoc comments with type parameters
- **Better code clarity**: Added inline comments explaining the implementation approach

#### `datastructures/DsVector.java`
- **Fixed documentation**: Corrected malformed JavaDoc tags and added missing parameter documentation
- **Optimized bubble sort**: Improved the sorting algorithm to reduce unnecessary comparisons (`ret.size() - 1 - i`)
- **Enhanced rotateVector method**:
  - Added proper handling for empty vectors
  - Implemented modulo operation to handle rotations larger than vector size
  - Added support for negative rotation values
  - Improved edge case robustness

## Usage

Build:

```shell
./gradlew build -x test
```

Run Main:

```shell
./gradlew run
```

Run Unit Tests:

```shell
./gradlew test
```

Run Benchmarking:

(will be added later)

## Project Structure

- `algorithms/` - Mathematical algorithms and computations
- `control/` - Control flow and utility methods
- `datastructures/` - Data structure implementations and operations
- `generator/` - Code generation utilities
- `run/` - Main execution classes
- `strings/` - String manipulation utilities
