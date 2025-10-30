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
   * <p>
   * Examples:
   * <ul>
   *   <li>{@code sumRange(0)} returns {@code 0}</li>
   *   <li>{@code sumRange(1)} returns {@code 0}</li>
   *   <li>{@code sumRange(4)} returns {@code 6} (0+1+2+3)</li>
   *   <li>{@code sumRange(10)} returns {@code 45} (0+1+2+...+9)</li>
   * </ul>
   * </p>
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
   * <p>
   * Iterates through the array to find the largest integer value. Works correctly
   * with negative numbers and duplicate values.
   * </p>
   * <p>
   * Examples:
   * <ul>
   *   <li>{@code maxArray(new int[]{1, 2, 3})} returns {@code 3}</li>
   *   <li>{@code maxArray(new int[]{-5, -2, -10})} returns {@code -2}</li>
   *   <li>{@code maxArray(new int[]{5})} returns {@code 5}</li>
   * </ul>
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
   * Uses an O(1) arithmetic series formula for efficiency instead of iterating through all values.
   * </p>
   * <p>
   * Examples:
   * <ul>
   *   <li>{@code sumModulus(10, 3)} returns {@code 18} (0+3+6+9)</li>
   *   <li>{@code sumModulus(10, 2)} returns {@code 20} (0+2+4+6+8)</li>
   *   <li>{@code sumModulus(5, 10)} returns {@code 0} (no multiples of 10 less than 5)</li>
   *   <li>{@code sumModulus(0, 3)} returns {@code 0} (no positive n)</li>
   * </ul>
   * </p>
   *
   * @param n The upper bound (exclusive) for the multiples. Must be positive to get non-zero result.
   * @param m The modulus (the number whose multiples are summed). Must be positive.
   * @return The sum of the multiples (0, m, 2m, ..., km where km &lt; n), 
   *         or 0 if n &lt;= 0.
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
    
    // Find the largest k such that m * k < n
    int k = (n - 1) / m;

    // Calculate sum using arithmetic series formula: m * k * (k + 1) / 2
    // This computes: m * (0 + 1 + 2 + ... + k) = m * k * (k + 1) / 2
    long sum = (long) m * k * (k + 1) / 2;

    // Check for overflow
    if (sum > Integer.MAX_VALUE) {
      throw new ArithmeticException("Sum overflow: result exceeds Integer.MAX_VALUE");
    }

    return (int) sum;
  }
}