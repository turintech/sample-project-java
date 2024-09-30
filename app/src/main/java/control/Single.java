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
    return (n * (n - 1)) / 2;
  }

  /**
   * This method calculates the maximum value in an array of integers.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array.
   */
  public static int maxArray(int[] arr) {
    if (arr.length == 0) {
      throw new IllegalArgumentException("Array is empty");
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
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (i % m == 0) {
        sum += i;
      }
    }
    return sum;
  }
}