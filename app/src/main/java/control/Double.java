package control;

import java.util.HashMap;

public class Double {
  /**
   * Sums all values squared from 0 to n
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers squared.
   */
  public static int sumSquare(int n) {
    int sum = 0;
    // Optimize: Only need to sum i*i over i = 0 to n-1
    for (int i = 0; i < n; i++) {
      sum += i * i;
    }
    return sum;
  }

  /**
   * Sums all triangular numbers from T(1) to T(n)
   *
   * @param n The number of triangular numbers to sum.
   * @return The sum of the first n triangular numbers.
   */
  public static int sumTriangle(int n) {
    int sum = 0;
    // Triangular number T(k) = k*(k+1)/2, sum over k = 1 to n
    for (int k = 1; k <= n; k++) {
      sum += k * (k + 1) / 2;
    }
    return sum;
  }

  /**
   * Counts the number of pairs in an array
   *
   * A pair is any value that is repeated exactly twice in the array.
   *
   * @param arr The array of integers.
   * @return The number of pairs in the array.
   */
  public static int countPairs(int[] arr) {
    int count = 0;
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    for (int num : arr) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }
    for (int v : freqMap.values()) {
      if (v == 2) {
        count++;
      }
    }
    return count;
  }

  /**
   * Counts the number of instances where the values at the same index are equal
   *
   * @param arr0 The first array of integers.
   * @param arr1 The second array of integers.
   * @return The number of instances where the values at the same index are
   *         equal.
   */
  public static int countDuplicates(int[] arr0, int[] arr1) {
    int count = 0;
    int minLen = Math.min(arr0.length, arr1.length);
    for (int i = 0; i < minLen; i++) {
      if (arr0[i] == arr1[i]) {
        count++;
      }
    }
    return count;
  }

  /**
   * Sums all values in a 2D array
   *
   * note: dimensions must be equal
   *
   * @param arr The 2D array of integers.
   * @return The sum of all values in the 2D array.
   */
  public static int sumMatrix(int[][] arr) {
    int sum = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < arr[i].length; j++) { // support jagged arrays
        sum += arr[i][j];
      }
    }
    return sum;
  }
}