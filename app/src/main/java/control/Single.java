package control;

// The 'java.util.Vector' import is removed as it is no longer used after refactoring
// the 'sumModulus' method. This improves clarity and reduces unnecessary dependencies.

public class Single {
  /**
   * Calculates the sum of the first n natural numbers (exclusive, from 0 up to n-1).
   *
   * Edge Cases:
   * - For n <= 0, returns 0.
   *
   * @param n The upper bound (exclusive) to sum (n >= 0).
   * @return The sum of the first n natural numbers.
   */
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0;
    }
    return n * (n - 1) / 2;
  }

  /**
   * Finds the maximum value in an array of integers.
   *
   * Edge Cases:
   * - If arr is null or empty, returns Integer.MIN_VALUE.
   *
   * @param arr The array of integers (can be null).
   * @return The maximum value in the array or Integer.MIN_VALUE if arr is empty or null.
   */
  public static int maxArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      return Integer.MIN_VALUE;
    }
    int max = Integer.MIN_VALUE;
    for (int i : arr) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }

  /**
   * Calculates the sum of non-negative integers less than n that are multiples of m.
   *
   * Edge Cases:
   * - If m == 0, throws IllegalArgumentException.
   * - If n <= 0, returns 0.
   * - Negative m is supported (prints same results as for positive m, but sign differs).
   *
   * @param n The upper bound (exclusive) for the integers (n >= 0).
   * @param m The modulus (nonzero).
   * @return The sum of all multiples of m less than n (0 if n <= 0).
   * @throws IllegalArgumentException if m is zero.
   */
  public static int sumModulus(int n, int m) {
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }
    if (n <= 0) {
      return 0;
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (i % m == 0) {
        sum += i;
      }
    }
    return sum;
  }
}