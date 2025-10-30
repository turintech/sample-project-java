package control;

public class Single {
  /**
   * Calculates the sum of integers from 0 to n-1 (exclusive of n).
   * Uses the arithmetic series formula: n * (n-1) / 2 for O(1) complexity.
   *
   * @param n The upper limit (exclusive) of numbers to sum
   * @return The sum of integers from 0 to n-1, or 0 if n <= 0
   */
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0;
    }
    return n * (n - 1) / 2;
  }

  /**
   * Finds the maximum value in an array of integers.
   * Correctly handles arrays with negative numbers.
   *
   * @param arr The array of integers
   * @return The maximum value, or {@code Integer.MIN_VALUE} if array is null or empty
   */
  public static int maxArray(int[] arr) {
    if (arr == null || arr.length == 0) {
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
   * Calculates the sum of all non-negative multiples of m that are less than n.
   * Uses the arithmetic series formula for O(1) complexity.
   *
   * @param n The upper bound (exclusive) for the multiples
   * @param m The modulus (must be non-zero)
   * @return The sum of multiples, or 0 if n <= 0
   * @throws IllegalArgumentException if m is 0
   */
  public static int sumModulus(int n, int m) {
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }
    if (n <= 0) {
      return 0;
    }

    int absM = Math.abs(m);
    int k = (n - 1) / absM;
    return absM * k * (k + 1) / 2;
  }
}