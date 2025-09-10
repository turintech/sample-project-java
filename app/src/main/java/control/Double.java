package control;

import java.util.HashMap;
import java.util.Map;

public class Double {
  /**
   * Sums the squares of all natural numbers from 0 up to, but not including, n.
   *
   * Edge Cases:
   *   If n <= 0, returns 0.
   *
   * @param n The upper bound (exclusive) for squaring, must be >= 0.
   * @return The sum of the squares of all natural numbers from 0 up to n-1.
   */
  public static int sumSquare(int n) {
    if (n <= 0) {
      return 0;
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += i * i;
    }
    return sum;
  }

  /**
   * Sums all triangular numbers from T(1) to T(n) (inclusive).
   *
   * Edge Cases:
   *   Returns 0 for n <= 0.
   *
   * @param n The number of triangular numbers to sum (n >= 0).
   * @return The sum of the first n triangular numbers (0 if n <= 0).
   */
  public static int sumTriangle(int n) {
    if (n <= 0) {
      return 0;
    }
    int sum = 0;
    int triangularNumber = 0;
    for (int i = 1; i <= n; i++) {
      triangularNumber += i;
      sum += triangularNumber;
    }
    return sum;
  }

  /**
   * Counts the number of pairs in an array.
   *
   * A pair is any value that is repeated exactly twice in the array.
   *
   * Edge Cases:
   * - If arr is null, returns 0. If arr has no pairs or is empty, returns 0.
   *
   * @param arr The array of integers (can be null).
   * @return The number of values with exactly two occurrences in the array.
   */
  public static int countPairs(int[] arr) {
    if (arr == null) {
      return 0;
    }
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
   * in two arrays.
   *
   * Edge Cases:
   * - If either array is null, returns 0.
   *
   * @param arr0 The first array of integers (can be null).
   * @param arr1 The second array of integers (can be null).
   * @return The number of instances where the values at the same index are equal.
   */
  public static int countDuplicates(int[] arr0, int[] arr1) {
    if (arr0 == null || arr1 == null) {
      return 0;
    }
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
   * Sums all values in a 2D array.
   *
   * Note: Only square matrices are supported by the caller, but this sums all elements in arr.
   *
   * Edge Cases:
   * - If arr is null or any row is null, returns 0.
   * - If any dimension has zero length, returns 0.
   *
   * @param arr The 2D array of integers (can be null).
   * @return The sum of all values in the 2D array. 0 if arr or a row is null.
   */
  public static int sumMatrix(int[][] arr) {
    if (arr == null) {
      return 0;
    }
    int sum = 0;
    for (int[] row : arr) {
      if (row == null) {
        return 0;
      }
      for (int value : row) {
        sum += value;
      }
    }
    return sum;
  }
}