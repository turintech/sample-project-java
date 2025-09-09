package control;

import java.util.Objects;

/**
 * Utility class for single-indexed numerical and array operations.
 * Not instantiable.
 */
public final class Single {
  private Single() {
    throw new AssertionError("Utility class - not to be instantiated");
  }
  /**
   * This method is used to calculate the sum of the first n natural numbers.
   * n exclusive
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers.
   */
  /**
   * Computes the sum of the first n natural numbers (0 to n-1).
   *
   * @param n non-negative upper bound (exclusive)
   * @return the sum of the first n natural numbers, or 0 if n < 0
   */
  public static int sumRange(final int n) {
    if (n < 0) {
      return 0;
    }
    return n * (n - 1) / 2;
  }

  /**
   * This method calculates the maximum value in an array of integers.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array.
   */
  /**
   * Returns the maximum value of the given array.
   *
   * @param arr the array of integers, not null
   * @return maximum value, or Integer.MIN_VALUE if the array is empty
   * @throws NullPointerException if arr is null
   */
  public static int maxArray(final int[] arr) {
    Objects.requireNonNull(arr, "Input array cannot be null");
    if (arr.length == 0) {
      return Integer.MIN_VALUE;
    }
    int max = Integer.MIN_VALUE;
    for (final int value : arr) {
      if (value > max) {
        max = value;
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
  /**
   * Calculates the sum of non-negative integers less than n that are multiples of m.
   *
   * @param n the upper bound (exclusive) for the integers
   * @param m the modulus
   * @return the sum of all i where 0 <= i < n and i % m == 0
   * @throws IllegalArgumentException if m is zero
   */
  public static int sumModulus(final int n, final int m) {
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