package control;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility methods for mathematical and array-based calculations.
 * (No-op edit to force clean build due to persistent test framework cache)
 */
public class Double {
  /**
   * Sums all values squared from 0 to n
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers squared.
   */
  /**
   * Returns the sum of squares from 0 (inclusive) to n (exclusive): sum(i^2) for i in [0, n).
   *
   * @param n The exclusive upper bound.
   * @return The sum of the first n natural numbers squared. Returns 0 if n <= 0.
   */
  public static int sumSquare(int n) {
    if (n <= 0) return 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += i * i;
    }
    return sum;
  }

  /**
   * Sums all triangular numbers from T(1) to T(n)
   *
   * @param n The number of triangular numbers to sum.
   * @return The sum of the first n triangular numbers.
   */
  /**
   * Returns the sum of the first n triangular numbers, i.e., sum(T(i)) for i=1 to n, with T(i)=i*(i+1)/2.
   *
   * @param n The number of triangular numbers to sum.
   * @return The sum of T(1) to T(n). Returns 0 if n <= 0.
   */
  public static int sumTriangle(int n) {
    if (n <= 0) return 0;
    // Efficient formula: S(n) = n(n+1)(n+2)/6
    // Use iterative approach for clarity, but comment mathematical alternative for maintainability.
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i * (i + 1) / 2;
    }
    return sum;
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
   * Counts the number of distinct integers in the array that appear exactly twice.
   *
   * @param arr The array of integers.
   * @return The number of unique values that appear exactly twice.
   */
  public static int countPairs(int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    Map<Integer, Integer> counts = new HashMap<>();
    for (int value : arr) {
      counts.put(value, counts.getOrDefault(value, 0) + 1);
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
   * Counts the number of positions where arr0 and arr1 have equal values at the same index.
   *
   * @param arr0 The first array of integers.
   * @param arr1 The second array of integers.
   * @return The number of matching index-value pairs (up to the shorter array length).
   */
  public static int countDuplicates(int[] arr0, int[] arr1) {
    if (arr0 == null || arr1 == null) return 0;
    int count = 0;
    int length = Math.min(arr0.length, arr1.length);
    for (int i = 0; i < length; i++) {
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
   * Sums all values in an (arbitrary) rectangular 2D array.
   *
   * @param arr The 2D array of integers. For ragged or empty arrays, only present elements are summed.
   * @return The total sum of all elements. Returns 0 for null or empty arrays.
   */
  public static int sumMatrix(int[][] arr) {
    if (arr == null) return 0;
    int sum = 0;
    for (int[] row : arr) {
      if (row == null) continue;
      for (int value : row) {
        sum += value;
      }
    }
    return sum;
  }
}