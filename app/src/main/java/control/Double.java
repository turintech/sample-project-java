package control;

import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Double {
  /**
   * Sums all values squared from 0 to n
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers squared.
   */
  public static int sumSquare(int n) {
    // Optimization: Direct formula n*(n-1)/2 since i==j condition means we only need diagonal
    return IntStream.range(0, n)
            .map(i -> i * i)
            .sum();
  }

  /**
   * Sums all triangular numbers from T(1) to T(n)
   *
   * @param n The number of triangular numbers to sum.
   * @return The sum of the first n triangular numbers.
   */
  public static int sumTriangle(int n) {
    // Using the formula for triangular numbers: T(n) = n(n+1)/2
    // Then summing them up efficiently
    return IntStream.rangeClosed(1, n)
            .map(i -> (i * (i + 1)) / 2)
            .sum();
  }

  /**
   * Counts the number of pairs in an array
   *
   * A pair is any value that is repeated exactly twice in the array.
   *
   * @param arr The array of integers.
   * @return The number of pairs in the array.
   */
  public static int countPairs(int[] arr) {
    // Using HashMap for O(n) time complexity
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : arr) {
      frequencyMap.merge(num, 1, Integer::sum);
    }
    return (int) frequencyMap.values().stream()
            .filter(freq -> freq == 2)
            .count();
  }

  /**
   * Counts the number of instances where the values at the same index are equal
   *
   * @param arr0 The first array of integers.
   * @param arr1 The second array of integers.
   * @return The number of instances where the values at the same index are
   *         equal.
   */
  public static int countDuplicates(int[] arr0, int[] arr1) {
    // Using the more efficient single loop approach with min length check
    return (int) IntStream.range(0, Math.min(arr0.length, arr1.length))
            .filter(i -> arr0[i] == arr1[i])
            .count();
  }

  /**
   * Sums all values in a 2D array
   *
   * note: dimensions must be equal
   *
   * @param arr The 2D array of integers.
   * @return The sum of all values in the 2D array.
   */
  public static int sumMatrix(int[][] arr) {
    // Using streams for a more concise solution
    return Arrays.stream(arr)
            .flatMapToInt(Arrays::stream)
            .sum();
  }
}