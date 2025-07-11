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
    // Original algorithm was O(n^2), but the pattern is 0^2 + 1^2 + ... + (n-1)^2
    // which can be computed with a formula: sum_{i=0}^{n-1} i^2 = (n-1)n(2n-1)/6
    // But as per comments, returning sum of first n natural numbers squared from i = 0
    // sum = 0^2 + 1^2 + ... + (n-1)^2
    // To keep in line with intended calculation:
    return (n - 1) * n * (2 * n - 1) / 6;
  }

  /**
   * Sums all triangular numbers from T(1) to T(n)
   *
   * @param n The number of triangular numbers to sum.
   * @return The sum of the first n triangular numbers.
   */
  public static int sumTriangle(int n) {
    // The k-th triangular number is T(k) = k*(k+1)/2, sum over k=1..n:
    // sum_{k=1}^{n} T(k) = sum_{k=1}^{n} k*(k+1)/2
    // = (1/2) * sum_{k=1}^{n} (k^2 + k)
    // = (1/2) * (sum_{k=1}^n k^2 + sum_{k=1}^n k)
    // sum_{k=1}^{n} k = n(n+1)/2
    // sum_{k=1}^{n} k^2 = n(n+1)(2n+1)/6
    int sum1 = n * (n + 1) / 2;
    int sum2 = n * (n + 1) * (2 * n + 1) / 6;
    return (sum1 + sum2) / 2;
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
    // O(n^2) version replaced with one-pass O(n) using HashMap
    HashMap<Integer, Integer> freq = new HashMap<>();
    for (int value : arr) {
      freq.put(value, freq.getOrDefault(value, 0) + 1);
    }
    int count = 0;
    for (int c : freq.values()) {
      if (c == 2) {
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
      for (int j = 0; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
    }
    return sum;
  }
}