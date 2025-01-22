package control;

import java.util.HashMap;
import java.util.Map;
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
    // Using the mathematical formula n(n+1)(2n+1)/6 for sum of squares
    return n * (n + 1) * (2 * n + 1) / 6;
  }

  /**
   * Sums all triangular numbers from T(1) to T(n)
   *
   * @param n The number of triangular numbers to sum.
   * @return The sum of the first n triangular numbers.
   */
  public static int sumTriangle(int n) {
    // Using the mathematical formula n(n+1)(n+2)/6 for sum of triangular numbers
    return n * (n + 1) * (n + 2) / 6;
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
    return (int) Arrays.stream(arr)
        .boxed()
        .collect(java.util.stream.Collectors.groupingBy(
            i -> i,
            java.util.stream.Collectors.counting()))
        .values()
        .stream()
        .filter(count -> count == 2)
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
    if (arr0 == null || arr1 == null) {
      return 0;
    }
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
    if (arr == null || arr.length == 0) {
      return 0;
    }
    return Arrays.stream(arr)
        .flatMapToInt(Arrays::stream)
        .sum();
  }
}