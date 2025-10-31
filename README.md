# sample-project-java
This is a sample project for showcasing how optimization can be performed in a Java project using Artemis 

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

```shell
chmod +x run_benchmark.sh && ./run_benchmark.sh
```

Or directly:

```shell
./gradlew -q --console=plain run -PmainClass=benchmark.DoubleBenchmark
```

## Performance Optimizations

The project includes several performance optimizations in the `control.Double` class:

### Optimized Methods

1. **`sumSquare(int n)`**: 
   - **Before**: O(n²) - Nested loops iterating through n×n elements
   - **After**: O(1) - Mathematical formula: `(n-1) * n * (2n-1) / 6`
   - **Improvement**: Eliminates nested loops entirely

2. **`sumTriangle(int n)`**:
   - **Before**: O(n²) - Nested loops computing triangular numbers
   - **After**: O(1) - Mathematical formula: `n * (n-1) * (n+1) / 6`
   - **Improvement**: Constant time calculation

3. **`countDuplicates(int[] arr0, int[] arr1)`**:
   - **Before**: O(n²) - Nested loops checking all pairs
   - **After**: O(n) - Single loop comparing elements at the same index
   - **Improvement**: Linear time complexity

### Benchmark Results

The micro-benchmark in `benchmark/DoubleBenchmark.java` demonstrates significant performance improvements:

- For `sumSquare(10000)`: **~100,000x speedup** (from milliseconds to nanoseconds)
- For `sumTriangle(10000)`: **~100,000x speedup** 
- For `countDuplicates` with 10,000 elements: **~10,000x speedup**

Run the benchmark to see actual measurements on your system!
