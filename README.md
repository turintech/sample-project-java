# Algorithms and Data Structures Demo

A comprehensive Java educational project demonstrating various algorithms, data structures, and programming concepts. This project serves as a learning resource for understanding fundamental computer science concepts through practical implementations.

## Overview

This project contains implementations of common algorithms and data structures, along with examples of control flow patterns and data generation utilities. It's designed to be both educational and practical, providing clear examples of how these concepts work in Java.

## Features

- **Algorithm Implementations**: Prime number generation, sorting algorithms
- **Data Structures**: Vector operations and manipulations
- **Control Flow Examples**: Single and double loop patterns
- **Data Generation**: Utilities for creating test data
- **Comprehensive Testing**: JUnit-based test suite

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── algorithms/       # Algorithm implementations
│   │       │   ├── Primes.java
│   │       │   └── Sort.java
│   │       ├── control/          # Control flow examples
│   │       │   ├── DoubleLoop.java
│   │       │   └── SingleLoop.java
│   │       ├── datastructures/   # Data structure implementations
│   │       │   └── Vector.java
│   │       ├── generator/        # Data generation utilities
│   │       │   └── Generator.java
│   │       └── run/
│   │           └── java/
│   │               └── App.java  # Main application entry point
│   └── test/
│       └── java/                 # JUnit test files
├── build.gradle.kts             # Gradle build configuration
└── README.md                    # This file
```

## Requirements

- Java 17 or higher
- Gradle 8.5 or higher

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <project-directory>
   ```

2. Build the project:
   ```bash
   ./gradlew build
   ```

## Usage

### Running the Application

To run the main application that demonstrates all features:

```bash
./gradlew run
```

### Building Without Tests

To build the project without running tests:

```bash
./gradlew build -x test
```

### Running Individual Components

You can also run specific components by importing them into your Java code:

```java
// Example: Using the Prime algorithm
import algorithms.Primes;

public class Example {
    public static void main(String[] args) {
        Primes primes = new Primes();
        // Use prime generation methods
    }
}
```

## Testing

Run the test suite to verify all implementations:

```bash
./gradlew test
```

To run tests with verbose output:

```bash
./gradlew test --info
```

## Module Details

### Algorithms
- **Primes**: Implementation of prime number generation and testing algorithms
- **Sort**: Various sorting algorithm implementations

### Control Flow
- **SingleLoop**: Examples of single loop patterns and use cases
- **DoubleLoop**: Examples of nested loop patterns and applications

### Data Structures
- **Vector**: Vector operations including basic manipulations and utilities

### Generator
- **Generator**: Utility classes for generating test data and sample inputs

## Performance Optimization

This project serves as a sample for showcasing how optimization can be performed in Java applications. Future enhancements will include:

- Benchmarking utilities for performance testing
- Optimization examples and comparisons
- Performance analysis tools

## Contributing

This is an educational project. Feel free to:
- Add new algorithm implementations
- Improve existing code with better performance or clarity
- Add more comprehensive test cases
- Enhance documentation and examples

## License

This project is intended for educational purposes.
