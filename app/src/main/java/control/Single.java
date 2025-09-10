package control;

// The 'java.util.Vector' import is removed as it is no longer used after refactoring
// the 'sumModulus' method. This improves clarity and reduces unnecessary dependencies.

public class Single {
  /**
   * This method is used to calculate the sum of the first n natural numbers.
   * n exclusive
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers.
   */
  public static int sumRange(int n) {
    // Refactored to use the arithmetic series sum formula: sum(0 to n-1) = n * (n - 1) / 2.
    // This is significantly more efficient than creating an array and iterating,
    // avoiding array allocation and multiple loops.
    // For n=0, the formula correctly returns 0 (sum of an empty set).
    // For n < 0, the concept of "first n natural numbers" is ill-defined. The original
    // code would throw a NegativeArraySizeException for n < 0. To handle invalid negative
    // inputs gracefully without crashing, this method returns 0, aligning with the behavior
    // for n=0 where the sum is also 0.
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
  public static int maxArray(int[] arr) {
    // Refactored to correctly handle arrays containing only negative numbers.
    // The original implementation would incorrectly return 0 if all elements were negative
    // (e.g., maxArray({-5, -1}) would return 0 instead of -1).
    // Initializing 'max' with Integer.MIN_VALUE ensures correct comparison for all integer values.
    // For an empty array (arr.length == 0), this method will now return Integer.MIN_VALUE,
    // which is a more semantically correct sentinel than 0 for an empty set, or when no
    // element is greater than Integer.MIN_VALUE.
    // Passing a null array will still result in a NullPointerException, preserving that original behavior.
    if (arr.length == 0) {
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
   * This method calculates the sum of non-negative integers less than n that are multiples of m.
   *
   * @param n The upper bound (exclusive) for the integers.
   * @param m The modulus.
   * @return The sum of multiples.
   * @throws IllegalArgumentException if m is zero.
   */
  /**
   * Calculates the sum of all non-negative integers less than n that are multiples of m.
   * Throws IllegalArgumentException if m == 0. Returns 0 if n <= 0.
   *
   * @param n upper bound (exclusive)
   * @param m modulus
   * @return sum of multiples
   * @throws IllegalArgumentException if m == 0
   */
  public static int sumModulus(final int n, final int m) {
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