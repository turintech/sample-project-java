package control;

// The 'java.util.Vector' import is removed as it is no longer used after refactoring
// the 'sumModulus' method. This improves clarity and reduces unnecessary dependencies.

public class Single {
  /**
   * Returns the sum of the first n natural numbers (0 + 1 + ... + (n-1)).
   * <p>
   * For n &lt;= 0, returns 0. Large n may result in integer overflow (returns negative values).
   *
   * @param n The number of natural numbers to sum (exclusive upper bound)
   * @return sum from 0 to n-1, or 0 if n &lt;= 0
   */
  public static int sumRange(final int n) {
    if (n <= 0) {
      return 0;
    }
    return n * (n - 1) / 2;
  }

  /**
   * Returns the maximum value in an array of integers.
   * <p>
   * If the array is empty, returns Integer.MIN_VALUE.
   * If arr is null, returns Integer.MIN_VALUE.
   *
   * @param arr Array of integers (may be null)
   * @return The maximum value in the array, or Integer.MIN_VALUE for null/empty input
   */
  public static int maxArray(final int[] arr) {
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
   * Returns the sum of all numbers k such that 0 &lt;= k &lt; n and k is a multiple of m.
   * <p>
   * If m is zero, throws IllegalArgumentException. Returns 0 if n &lt;= 0. Negative modulus m is allowed.
   *
   * @param n upper bound (exclusive)
   * @param m the multiple base (must not be zero)
   * @return sum of multiples of m below n; 0 if n &lt;= 0
   * @throws IllegalArgumentException if m == 0
   */
  public static int sumModulus(final int n, final int m) {
    if (n <= 0) return 0;
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
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