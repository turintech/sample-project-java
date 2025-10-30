package control;

public final class Single {

  private Single() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Calculates the sum of integers from 0 to n-1 using the arithmetic series formula.
   * This method computes: 0 + 1 + 2 + ... + (n-1) using the formula n*(n-1)/2
   *
   * @param n The upper limit (exclusive) of numbers to sum. Must be non-negative.
   * @return The sum of integers from 0 to n-1, or 0 if n &lt;= 0.
   * @throws ArithmeticException if the result would overflow the int type.
   */
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0;
    }

    // Use long to prevent overflow during calculation
    long result = (long) n * (n - 1) / 2;

    // Check for overflow
    if (result > Integer.MAX_VALUE) {
      throw new ArithmeticException("Sum overflow: result exceeds Integer.MAX_VALUE");
    }

    return (int) result;
  }

  /**
   * Finds the maximum value in an array of integers.
   * Iterates through the array to find the largest integer value.
   *
   * @param arr The array of integers to search. Cannot be null or empty.
   * @return The maximum value found in the array.
   * @throws IllegalArgumentException if the array is null or empty.
   */
  public static int maxArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
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
   * Uses an O(1) arithmetic series formula: m * (0 + 1 + ... + k) = m * k * (k+1) / 2
   *
   * @param n The upper bound (exclusive) for the multiples.
   * @param m The modulus (the number whose multiples are summed). Must be positive.
   * @return The sum of the multiples (0, m, 2m, ..., km where km &lt; n), or 0 if n &lt;= 0.
   * @throws IllegalArgumentException if m is zero or negative.
   * @throws ArithmeticException if the result would overflow the int type.
   */
  public static int sumModulus(int n, int m) {
    if (m <= 0) {
      throw new IllegalArgumentException("Modulus 'm' must be positive.");
    }

    if (n <= 0) {
      return 0;
    }

    // Find the number of multiples: how many times m fits into the range [0, n)
    int numMultiples = (n - 1) / m;

    // Calculate sum using arithmetic series formula
    // Sum = m * (0 + 1 + 2 + ... + numMultiples) = m * numMultiples * (numMultiples + 1) / 2
    try {
      long product = Math.multiplyExact((long) m, numMultiples);
      long sum = Math.multiplyExact(product, (numMultiples + 1)) / 2;

      if (sum > Integer.MAX_VALUE) {
        throw new ArithmeticException("Sum overflow: result exceeds Integer.MAX_VALUE");
      }

      return (int) sum;
    } catch (ArithmeticException e) {
      throw new ArithmeticException("Sum overflow: result exceeds Integer.MAX_VALUE");
    }
  }
}
