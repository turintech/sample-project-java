package control;

import java.util.Vector; // Keep Vector import as it was in the original, even if not used in refactored code.
import java.util.ArrayList; // Added for potential use, but will avoid for sumModulus optimization

public class Single {
  /**
   * This method calculates the sum of natural numbers from 0 up to (but not including) n.
   * This is equivalent to the sum of the first n natural numbers starting from 0.
   * For example, if n=3, it sums 0 + 1 + 2 = 3.
   *
   * @param n The count of natural numbers to sum, starting from 0. Must be non-negative.
   * @return The sum of the first n natural numbers (0 to n-1). Returns 0 if n is 0 or negative.
   */
  public static int sumRange(int n) {
    // The sum of numbers from 0 to n-1 is an arithmetic series.
    // The formula for the sum of an arithmetic series 0 to k is k * (k + 1) / 2.
    // Here, k = n - 1. So the sum is (n - 1) * ((n - 1) + 1) / 2 = (n - 1) * n / 2.
    // Handle negative n by returning 0, as there are no natural numbers to sum.
    if (n <= 0) {
      return 0;
    }
    return n * (n - 1) / 2;
  }

  /**
   * This method calculates the maximum value in an array of integers.
   * It handles arrays containing negative numbers and empty arrays.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array. Returns {@link Integer#MIN_VALUE} if the array is empty.
   */
  public static int maxArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      return Integer.MIN_VALUE; // Return smallest possible int value for an empty array.
                                // The original code would return 0, which is incorrect for all-negative arrays or empty arrays.
    }

    int max = arr[0]; // Initialize max with the first element to correctly handle negative numbers.
                      // This ensures max is always an element from the array (or Integer.MIN_VALUE if empty).
    for (int i = 1; i < arr.length; i++) { // Start loop from the second element
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  /**
   * This method calculates the sum of all natural numbers 'i' from 0 up to (but not including) 'n'
   * such that 'i' is a multiple of 'm'.
   *
   * @param n The upper bound (exclusive) for natural numbers to consider.
   * @param m The modulus. Numbers considered for summation must be multiples of 'm'.
   *          Must not be zero to avoid an ArithmeticException.
   * @return The sum of natural numbers (0 to n-1) that are multiples of m.
   * @throws IllegalArgumentException if m is 0.
   */
  public static int sumModulus(int n, int m) {
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }

    // Replace Vector and stream processing with a direct sum for efficiency and clarity.
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (i % m == 0) {
        sum += i;
      }
    }
    return sum;
  }
}