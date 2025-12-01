package control;

public class Single {
  /**
   * Calculates the sum of integers from 0 to n-1 using the arithmetic series formula.
   * Time complexity: O(1), Space complexity: O(1).
   *
   * @param n The upper bound (exclusive). Must be non-negative.
   * @return The sum of integers from 0 to n-1.
   * @throws NegativeArraySizeException if n is negative.
   */
  public static int sumRange(int n) {
    if (n < 0) {
      throw new NegativeArraySizeException("n must be non-negative.");
    }
    return n * (n - 1) / 2;
  }

  /**
   * Finds the maximum value in an array of integers.
   * Correctly handles arrays with negative numbers.
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
   * Calculates the sum of multiples of m in the range [0, n).
   * Uses arithmetic series formula for O(1) time complexity.
   * Example: sumModulus(10, 3) = 0 + 3 + 6 + 9 = 18
   *
   * @param n The upper bound (exclusive).
   * @param m The modulus. Must not be zero.
   * @return The sum of multiples of m that are less than n.
   * @throws IllegalArgumentException if m is 0.
   */
  public static int sumModulus(int n, int m) {
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }
    if (n <= 0) {
      return 0;
    }

    // Calculate the number of multiples: 0, m, 2m, ..., km where km < n
    // The largest k is floor((n-1) / m)
    int absM = Math.abs(m);
    int k = (n - 1) / absM;
    
    // Sum = m * (0 + 1 + 2 + ... + k) = m * k * (k + 1) / 2
    return absM * k * (k + 1) / 2;
  }
}