package benchmark;

import control.Double;

/**
 * Micro-benchmark to measure performance improvements in Double class methods.
 * 
 * This benchmark compares the optimized implementations against the original
 * O(n²) nested loop implementations for sumSquare, sumTriangle, and countDuplicates.
 */
public class DoubleBenchmark {

    /**
     * Measures execution time of a method in nanoseconds.
     */
    private static long measureTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Original unoptimized implementation of sumSquare for comparison.
     */
    private static int sumSquareOriginal(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sum = sum + i * j;
                }
            }
        }
        return sum;
    }

    /**
     * Original unoptimized implementation of sumTriangle for comparison.
     */
    private static int sumTriangleOriginal(int n) {
        int sum = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                sum = sum + j;
            }
        }
        return sum;
    }

    /**
     * Original unoptimized implementation of countDuplicates for comparison.
     */
    private static int countDuplicatesOriginal(int[] arr0, int[] arr1) {
        int count = 0;
        for (int i = 0; i < arr0.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (i == j && arr0[i] == arr1[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Benchmarks sumSquare method.
     */
    private static void benchmarkSumSquare(int n, int iterations) {
        System.out.println("\n=== Benchmarking sumSquare with n=" + n + " ===");

        // Warmup
        for (int i = 0; i < 1000; i++) {
            sumSquareOriginal(n);
            Double.sumSquare(n);
        }

        long totalOriginal = 0;
        long totalOptimized = 0;

        for (int i = 0; i < iterations; i++) {
            totalOriginal += measureTime(() -> sumSquareOriginal(n));
            totalOptimized += measureTime(() -> Double.sumSquare(n));
        }

        long avgOriginal = totalOriginal / iterations;
        long avgOptimized = totalOptimized / iterations;
        double speedup = (double) avgOriginal / avgOptimized;

        System.out.println("Original (O(n²)):  " + avgOriginal + " ns");
        System.out.println("Optimized (O(1)): " + avgOptimized + " ns");
        System.out.println("Speedup: " + String.format("%.2f", speedup) + "x");
    }

    /**
     * Benchmarks sumTriangle method.
     */
    private static void benchmarkSumTriangle(int n, int iterations) {
        System.out.println("\n=== Benchmarking sumTriangle with n=" + n + " ===");

        // Warmup
        for (int i = 0; i < 1000; i++) {
            sumTriangleOriginal(n);
            Double.sumTriangle(n);
        }

        long totalOriginal = 0;
        long totalOptimized = 0;

        for (int i = 0; i < iterations; i++) {
            totalOriginal += measureTime(() -> sumTriangleOriginal(n));
            totalOptimized += measureTime(() -> Double.sumTriangle(n));
        }

        long avgOriginal = totalOriginal / iterations;
        long avgOptimized = totalOptimized / iterations;
        double speedup = (double) avgOriginal / avgOptimized;

        System.out.println("Original (O(n²)):  " + avgOriginal + " ns");
        System.out.println("Optimized (O(1)): " + avgOptimized + " ns");
        System.out.println("Speedup: " + String.format("%.2f", speedup) + "x");
    }

    /**
     * Benchmarks countDuplicates method.
     */
    private static void benchmarkCountDuplicates(int size, int iterations) {
        System.out.println("\n=== Benchmarking countDuplicates with array size=" + size + " ===");

        // Create test arrays
        int[] arr0 = new int[size];
        int[] arr1 = new int[size];
        for (int i = 0; i < size; i++) {
            arr0[i] = i % 10;
            arr1[i] = i % 10;
        }

        // Warmup
        for (int i = 0; i < 1000; i++) {
            countDuplicatesOriginal(arr0, arr1);
            Double.countDuplicates(arr0, arr1);
        }

        long totalOriginal = 0;
        long totalOptimized = 0;

        for (int i = 0; i < iterations; i++) {
            totalOriginal += measureTime(() -> countDuplicatesOriginal(arr0, arr1));
            totalOptimized += measureTime(() -> Double.countDuplicates(arr0, arr1));
        }

        long avgOriginal = totalOriginal / iterations;
        long avgOptimized = totalOptimized / iterations;
        double speedup = (double) avgOriginal / avgOptimized;

        System.out.println("Original (O(n²)): " + avgOriginal + " ns");
        System.out.println("Optimized (O(n)): " + avgOptimized + " ns");
        System.out.println("Speedup: " + String.format("%.2f", speedup) + "x");
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("Performance Optimization Micro-Benchmark");
        System.out.println("======================================");

        int iterations = 10000;

        // Benchmark sumSquare with different input sizes
        benchmarkSumSquare(100, iterations);
        benchmarkSumSquare(1000, iterations);
        benchmarkSumSquare(10000, iterations);

        // Benchmark sumTriangle with different input sizes
        benchmarkSumTriangle(100, iterations);
        benchmarkSumTriangle(1000, iterations);
        benchmarkSumTriangle(10000, iterations);

        // Benchmark countDuplicates with different array sizes
        benchmarkCountDuplicates(100, iterations);
        benchmarkCountDuplicates(1000, iterations);
        benchmarkCountDuplicates(10000, iterations / 10); // Fewer iterations for larger arrays

        System.out.println("\n======================================");
        System.out.println("Benchmark Complete!");
        System.out.println("======================================");
    }
}
