package control;

public class Single {
  /**
   * This method calculates the sum of integers from 0 up to (but not including) n.
   * For example, if n is 5, it sums 0 + 1 + 2 + 3 + 4 = 10.
   *
   * @param n The upper limit (exclusive) of numbers to sum.
   * @return The sum of the integers from 0 to n-1. Returns 0 if n is less than or equal to 0.
   */
  public static int sumRange(int n) {
    // Optimization: Use the arithmetic series formula.
    // The sum of integers from 0 to (n-1) is n * (n-1) / 2.
    // This approach is O(1) in time complexity,
    // compared to the original O(n) which also used O(n) space.
    if (n <= 0) {
      return 0; // If n is not positive, there are no non-negative numbers less than n to sum.
    }
    return n * (n - 1) / 2;
  }

  /**
   * This method calculates the maximum value in an array of integers.
   * It handles arrays containing negative numbers correctly.
   * If the array is {@code null} or empty, it returns {@code Integer.MIN_VALUE}.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array, or {@code Integer.MIN_VALUE} if the array is null or empty.
   */
  public static int maxArray(int[] arr) {
    // Handle null or empty array explicitly.
    // Returning Integer.MIN_VALUE is a common sentinel for "no maximum found"
    // and is consistent with correctly finding the maximum in arrays containing only negative numbers.
    if (arr == null || arr.length == 0) {
      return Integer.MIN_VALUE;
    }

    // Initialize max with the first element to correctly handle arrays
    // containing only negative numbers (e.g., maxArray({-5, -2, -8}) should be -2, not 0).
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) { // Start loop from the second element
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  /**
   * This method calculates the sum of all non-negative multiples of {@code m}
   * that are strictly less than {@code n}.
   * For example, if n=10 and m=3, it sums 0 + 3 + 6 + 9 = 18.
   *
   * @param n The upper bound (exclusive) for the multiples.
   * @param m The modulus (the number whose multiples are summed). Must be non-zero.
   * @return The sum of the multiples. Returns 0 if n is less than or equal to 0.
   * @throws IllegalArgumentException If m is 0, as modulo by zero is undefined.
   */
  public static int sumModulus(int n, int m) {
    // Fix defect: Prevent ArithmeticException for m == 0.
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }
    // If n is not positive, there are no non-negative numbers less than n to sum.
    if (n <= 0) {
      return 0;
    }

    // Handle negative modulus by using its absolute value
    // (multiples of -3 are the same as multiples of 3)
    int absM = Math.abs(m);

    // Optimization: Use arithmetic series formula for O(1) time complexity.
    // The multiples of m less than n are: 0, m, 2m, 3m, ..., km where km < n
    // The largest k is: k = (n-1) / m (integer division)
    // Sum = m * (0 + 1 + 2 + ... + k) = m * k * (k + 1) / 2
    int k = (n - 1) / absM;
    return absM * k * (k + 1) / 2;
  }
}