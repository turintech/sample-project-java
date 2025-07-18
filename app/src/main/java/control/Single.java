package control;

public class Single {
  /**
   * This method is used to calculate the sum of the first n natural numbers.
   * n exclusive
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers.
   */
  public static int sumRange(int n) {
    if (n < 0) {
      // The original code would create an array of negative size,
      // throwing a NegativeArraySizeException. We preserve this behavior.
      throw new NegativeArraySizeException("n cannot be negative");
    }
    // The sum of numbers from 0 to n-1 can be calculated using the
    // formula for an arithmetic series. This avoids allocating an array
    // and looping, providing O(1) time and space complexity.
    // The original was O(n) for both.
    return n * (n - 1) / 2;
  }

  /**
   * This method calculates the maximum value in an array of integers.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array.
   */
  public static int maxArray(int[] arr) {
    // The original code would throw a NullPointerException for a null array.
    // Accessing arr.length first preserves this behavior.
    if (arr.length == 0) {
      return 0; // The original code returns 0 for an empty array.
    }

    // The original initialization `max = 0` was buggy for arrays containing
    // only negative numbers. Initializing with the first element corrects this.
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  /**
   * This method calculates the sum of the first n natural numbers, modulo m.
   *
   * @param n The number of natural numbers to sum.
   * @param m The modulus.
   */
  public static int sumModulus(int n, int m) {
    // The original implementation used a Vector and a stream, which is
    // inefficient. A mathematical formula provides an O(1) time and space
    // solution, versus O(n) time and O(n/m) space.

    if (m == 0) {
      // Replicate the original behavior of throwing an exception.
      throw new ArithmeticException("/ by zero");
    }
    if (n <= 1) {
      // The only possible multiple of m in the range [0, n-1] is 0. Sum is 0.
      return 0;
    }

    // The condition `i % m == 0` is equivalent to `i % abs(m) == 0`.
    // The edge case m = Integer.MIN_VALUE is handled separately because
    // its absolute value cannot be represented as a positive int.
    if (m == Integer.MIN_VALUE) {
      // The only non-negative multiple of Integer.MIN_VALUE is 0.
      return 0;
    }
    int effectiveM = m > 0 ? m : -m;

    // We are summing multiples of effectiveM: 0, M, 2M, ..., p*M where p*M < n.
    // The largest integer multiplier `p` is (n - 1) / effectiveM.
    int p = (n - 1) / effectiveM;

    // The sum is M * (0 + 1 + 2 + ... + p).
    // The sum of the series 0..p is p * (p + 1) / 2.
    // Note: Integer overflow can occur here for large n, same as the original.
    int sumOfCoefficients = p * (p + 1) / 2;
    return effectiveM * sumOfCoefficients;
  }
}