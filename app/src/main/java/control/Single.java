package control;

public class Single {
  /**
   * Calculates the sum of integers from 0 to n-1 using the arithmetic series formula.
   * Time complexity: O(1), Space complexity: O(1).
   *
   * @param n The upper bound (exclusive). Must be non-negative.
   * @return The sum of integers from 0 to n-1.
   * @throws IllegalArgumentException if n is negative.
   */
  public static int sumRange(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must be non-negative.");
    }
    return n * (n - 1) / 2;
  }

  /**
   * Finds the maximum value in an array of integers.
   *
   * @param arr The array of integers. Cannot be null.
   * @return The maximum value in the array, or 0 if the array is empty.
   * @throws IllegalArgumentException if the array is null.
   */
  public static int maxArray(int[] arr) {
    if (arr == null) {
      throw new IllegalArgumentException("Array cannot be null.");
    }
    if (arr.length == 0) {
      return 0;
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
   * Calculates the sum of all multiples of m in the range [0, n).
   * Uses the arithmetic series formula for optimal performance.
   * Time complexity: O(1), Space complexity: O(1).
   *
   * @param n The upper bound (exclusive). Returns 0 if n is negative or zero.
   * @param m The modulus. Must not be zero.
   * @return The sum of multiples of m in the range [0, n).
   * @throws IllegalArgumentException if m is zero.
   */
  public static int sumModulus(int n, int m) {
    if (m == 0) {
      throw new IllegalArgumentException("Modulus cannot be zero.");
    }
    if (n <= 0) {
      return 0;
    }

    // Calculate the number of multiples of m in range [0, n)
    // Multiples are: 0, m, 2m, 3m, ..., km where km < n
    int absM = Math.abs(m);
    int count = (n - 1) / absM + 1; // +1 to include 0
    
    // Sum of arithmetic series: 0 + m + 2m + ... + (count-1)m
    // = m * (0 + 1 + 2 + ... + (count-1))
    // = m * (count - 1) * count / 2
    return absM * (count - 1) * count / 2;
  }
}