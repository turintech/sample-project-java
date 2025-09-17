package control;

import java.util.HashMap;
import java.util.Map;

public class Double {
  /**
   * Sums all values squared from 0 to n
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers squared.
   */
  /**
   * Computes the sum of squares of the first n natural numbers (from 0 to n-1).
   * Returns 0 if n <= 0.
   * Uses the formula: sum_{i=0}^{n-1} i^2 = (n-1) * n * (2n-1) / 6
   *
   * @param n The number of natural numbers to sum. If n <= 0, returns 0.
   * @return The sum of squares from 0 to n-1, or 0 if n <= 0.
   */
  public static int sumSquare(int n) {
    if (n <= 0) {
      return 0;
    }
    // Formula: S = (n-1)*n*(2n-1)/6
    return (n - 1) * n * (2 * n - 1) / 6;
  }

  /**
   * Sums all triangular numbers from T(1) to T(n)
   *
   * @param n The number of triangular numbers to sum.
   * @return The sum of the first n triangular numbers.
   */
  /**
   * Computes the sum of all triangular numbers from T(1) to T(n).
   * Returns 0 if n < 0.
   * Uses the tetrahedral formula: n*(n+1)*(n+2)/6
   *
   * @param n Number of triangular numbers to sum; if n < 0 returns 0.
   * @return The sum of the first n triangular numbers.
   */
  public static int sumTriangle(int n) {
    if (n < 0) {
      return 0;
    }
    // Formula: tetrahedral number
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
  /**
   * Counts the number of values that appear exactly twice in the given array.
   * Returns 0 if input is null.
   *
   * @param arr The array of integers, may be null.
   * @return The number of distinct values with exactly two occurrences.
   */
  public static int countPairs(int[] arr) {
    if (arr == null) {
      return 0;
    }
    Map<Integer, Integer> counts = new HashMap<>();
    for (int num : arr) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    int pairs = 0;
    for (int count : counts.values()) {
      if (count == 2) {
        pairs++;
      }
    }
    return pairs;
  }

  /**
   * Counts the number of instances where the values at the same index are equal
   *
   * @param arr0 The first array of integers.
   * @param arr1 The second array of integers.
   * @return The number of instances where the values at the same index are
   *         equal.
   */
  /**
   * Counts the number of identical values at the same index in two arrays.
   * Handles null arrays gracefully.
   *
   * @param arr0 The first array, may be null.
   * @param arr1 The second array, may be null.
   * @return The number of same values at corresponding indices.
   */
  public static int countDuplicates(int[] arr0, int[] arr1) {
    if (arr0 == null || arr1 == null) {
      return 0;
    }
    int count = 0;
    int limit = Math.min(arr0.length, arr1.length);
    for (int i = 0; i < limit; i++) {
      if (arr0[i] == arr1[i]) {
        count++;
      }
    }
    return count;
  }

  /**
   * Sums all values in a 2D array
   *
   * note: dimensions must be equal
   *
   * @param arr The 2D array of integers.
   * @return The sum of all values in the 2D array.
   */
  /**
   * Computes the sum of all values in a 2D integer array. Skips null rows.
   * Returns 0 if array is null.
   *
   * @param arr The 2D array of integers, rows may be null.
   * @return The sum of all values in the matrix.
   */
  public static int sumMatrix(int[][] arr) {
    if (arr == null) {
      return 0;
    }
    int sum = 0;
    for (int[] row : arr) {
      if (row != null) {
        for (int value : row) {
          sum += value;
        }
      }
    }
    return sum;
  }
}