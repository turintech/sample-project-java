package control;

/**
 * Utility methods for simple array and mathematical operations.
 */
public class Single {
  /**
   * This method is used to calculate the sum of the first n natural numbers.
   * n exclusive
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers.
   */
  /**
   * Returns the sum of the first n natural numbers (exclusive; sums 0..n-1).
   *
   * @param n The upper bound (exclusive).
   * @return The sum of 0 + 1 + ... + (n-1), or 0 if n <= 0.
   */
  public static int sumRange(int n) {
    if (n <= 0) return 0;
    return n * (n - 1) / 2;
  }

  /**
   * This method calculates the maximum value in an array of integers.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array.
   */
  /**
   * Finds the maximum value in an array of integers.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array, or Integer.MIN_VALUE if array is empty or null.
   */
  public static int maxArray(int[] arr) {
    if (arr == null || arr.length == 0) return Integer.MIN_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i : arr) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }

  /**
   * This method calculates the sum of non-negative integers less than n that are multiples of m.
   *
   * @param n The upper bound (exclusive) for the integers.
   * @param m The modulus.
   * @return The sum of multiples.
   * @throws IllegalArgumentException if m is zero.
   */
  public static int sumModulus(int n, int m) {
    // Defect fix: Modulus by zero (m == 0) results in an ArithmeticException.
    // It is better practice to validate input and throw an IllegalArgumentException
    // for invalid parameters, making the API contract clearer.
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }

    // Refactored to directly sum the multiples, avoiding intermediate collection creation (Vector)
    // and stream processing overhead. This preserves the exact behavior of the original loop
    // for both positive and negative 'm' values, while significantly improving performance
    // and memory usage.
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (i % m == 0) {
        sum += i;
      }
    }
    return sum;
  }
}