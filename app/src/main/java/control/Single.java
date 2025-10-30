package control;

public final class Single {

  private Single() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Calculates the sum of integers from 0 to n-1 using the arithmetic series formula.
   *
   * @param n The upper limit (exclusive) of numbers to sum.
   * @return The sum of integers from 0 to n-1, or 0 if n &lt;= 0.
   */
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0;
    }
    // Use long to prevent overflow, then safely cast back
    long result = (long) n * (n - 1) / 2;
    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    return (int) result;
  }

  /**
   * Finds the maximum value in an array of integers.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array, or {@code Integer.MIN_VALUE} if null or empty.
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
   * Uses an O(1) arithmetic series formula for efficiency.
   *
   * @param n The upper bound (exclusive) for the multiples.
   * @param m The modulus (the number whose multiples are summed).
   * @return The sum of the multiples, or 0 if n &lt;= 0.
   * @throws IllegalArgumentException If m is 0.
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

    // Calculate sum using arithmetic series formula: absM * k * (k + 1) / 2
    long sum = (long) absM * k * (k + 1) / 2;

    if (sum > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }

    return (int) sum;
  }
}