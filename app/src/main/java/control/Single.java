package control;

import java.util.Vector;

public class Single {
  /**
   * This method is used to calculate the sum of the first n natural numbers.
   * n exclusive
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers.
   */
  public static int sumRange(int n) {
    // Using the mathematical formula for sum of arithmetic sequence: sum = n(n-1)/2
    // This avoids creating an array and looping twice
    return n * (n - 1) / 2;
  }

  /**
   * This method calculates the maximum value in an array of integers.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array.
   */
  public static int maxArray(int[] arr) {
    // Initialize max with the first element of array or Integer.MIN_VALUE if empty
    if (arr.length == 0) {
      return 0; // Maintaining original behavior for empty arrays
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
   * This method calculates the sum of the first n natural numbers, modulo m.
   *
   * @param n The number of natural numbers to sum.
   * @param m The modulus.
   */
  public static int sumModulus(int n, int m) {
    // Direct calculation without using a Vector
    int sum = 0;
    for (int i = 0; i < n; i += m) {
      sum += i;
    }
    return sum;
  }
}