package control;

public class Single {
  /**
   * This method is used to calculate the sum of the first n natural numbers.
   * n exclusive
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers.
   */
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0;
    }
    // Use the formula for the sum of an arithmetic series (0 + 1 + ... + (n-1)),
    // which is significantly more efficient than creating and iterating over an array.
    return n * (n - 1) / 2;
  }

  /**
   * This method calculates the maximum value in an array of integers.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array.
   */
  public static int maxArray(int[] arr) {
    // A null array will cause a NullPointerException, preserving original behavior.
    if (arr.length == 0) {
      return 0; // Preserves original behavior for an empty array.
    }

    // The original implementation initialized max to 0, which is a bug for
    // arrays containing only negative numbers. Initializing with the first
    // element fixes this.
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  /**
   * This method calculates the sum of all multiples of m that are less than n.
   *
   * @param n The upper bound (exclusive).
   * @param m The number whose multiples are to be summed.
   */
  public static int sumModulus(int n, int m) {
    // The original implementation inefficiently used a Vector and a Stream.
    // A simple loop is more performant and readable.
    int sum = 0;
    // For m = 0, this will throw an ArithmeticException, preserving original behavior.
    for (int i = 0; i < n; i++) {
      if (i % m == 0) {
        sum += i;
      }
    }
    return sum;
  }
}