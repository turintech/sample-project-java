package control;

// The 'java.util.Vector' import is removed as it is no longer used after refactoring
// the 'sumModulus' method. This improves clarity and reduces unnecessary dependencies.

public class Single {
  /**
   * Returns the sum of the first n natural numbers (from 0 to n-1).
   * <p>Special cases:
   * <ul>
   *   <li>If n &lt;= 0, returns 0 (empty range).</li>
   *   <li>If n is large enough to overflow, the result will wrap due to Java integer arithmetic.</li>
   * </ul>
   *
   * @param n the (exclusive) upper bound (must be non-negative).
   * @return the sum 0 + 1 + ... + (n-1), or 0 if n &lt;= 0.
   */
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0; // Clarified empty or invalid range case
    }
    // Note: Java int arithmetic may overflow for large n.
    return n * (n - 1) / 2;
  }

  /**
   * Returns the maximum value in the given integer array.
   * <p>
   * Special cases:
   * <ul>
   *   <li>If arr is null, throws IllegalArgumentException.</li>
   *   <li>If arr.length == 0, returns Integer.MIN_VALUE (no elements to compare).</li>
   * </ul>
   *
   * @param arr the array of integers to search (must not be null)
   * @return the maximum value of the array, or Integer.MIN_VALUE if empty
   */
  public static int maxArray(int[] arr) {
    if (arr == null) {
      throw new IllegalArgumentException("Input array cannot be null");
    }
    if (arr.length == 0) {
      return Integer.MIN_VALUE;
    }
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  /**
   * Returns the sum of all non-negative integers less than n that are divisible by m.
   * <ul>
   *   <li>If m == 0, throws IllegalArgumentException.</li>
   *   <li>If n &lt;= 0, returns 0 (no integers to sum).</li>
   * </ul>
   *
   * @param n the upper bound (exclusive), must be non-negative
   * @param m the modulus (divisor), must not be zero
   * @return the sum of all values in [0, n) exactly divisible by m
   * @throws IllegalArgumentException if m == 0
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