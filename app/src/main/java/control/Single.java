package control;

public final class Single {

  private Single() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Calculates the sum of integers from 0 to n-1 using the arithmetic series formula.
   * <p>
   * This method computes: 0 + 1 + 2 + ... + (n-1) using the formula n*(n-1)/2
   * </p>
   *
   * @param n The upper limit (exclusive) of numbers to sum. Must be non-negative.
   * @return The sum of integers from 0 to n-1, or 0 if n &lt;= 0.
   *         Returns {@code Integer.MAX_VALUE} if the result would overflow.
   */
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0;
    }
    
    // Use long to prevent overflow during calculation
    long result = (long) n * (n - 1) / 2;
    
    // Cap at Integer.MAX_VALUE if overflow would occur
    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    
    return (int) result;
  }

  /**
   * Finds the maximum value in an array of integers.
   * <p>
   * Iterates through the array to find the largest integer value.
   * </p>
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
   * <p>
   * Uses an O(1) arithmetic series formula for efficiency.
   * For example, sumModulus(10, 3) returns 0 + 3 + 6 + 9 = 18.
   * </p>
   *
   * @param n The upper bound (exclusive) for the multiples. Must be positive to get non-zero result.
   * @param m The modulus (the number whose multiples are summed). Cannot be zero.
   * @return The sum of the multiples (0, m, 2m, ..., km where km &lt; n), 
   *         or 0 if n &lt;= 0. Returns {@code Integer.MAX_VALUE} if overflow would occur.
   * @throws IllegalArgumentException if m is 0.
   */
  public static int sumModulus(int n, int m) {
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }
    
    if (n <= 0) {
      return 0;
    }

    // Use absolute value to handle negative modulus
    int absM = Math.abs(m);
    
    // Find the largest k such that absM * k < n
    int k = (n - 1) / absM;

    // Calculate sum using arithmetic series formula: absM * k * (k + 1) / 2
    // This computes: absM * (0 + 1 + 2 + ... + k) = absM * k * (k + 1) / 2
    long sum = (long) absM * k * (k + 1) / 2;

    // Cap at Integer.MAX_VALUE if overflow would occur
    if (sum > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }

    return (int) sum;
  }
}