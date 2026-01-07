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
    // Simplified: sum of i^2 from 0 to n-1
    int sum = 0;
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
    // Triangular number T(i) = i*(i-1)/2
    // Sum of T(1) to T(n) can be calculated efficiently
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i * (i - 1) / 2;
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
    // Use HashMap to count occurrences in O(n) time
    HashMap<Integer, Integer> counts = new HashMap<>();
    for (int num : arr) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    
    int count = 0;
    for (int occurrences : counts.values()) {
      if (occurrences == 2) {
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
    // Single pass comparison - no nested loop needed
    int count = 0;
    int minLength = Math.min(arr0.length, arr1.length);
    for (int i = 0; i < minLength; i++) {
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
      for (int j = 0; j < n; j++) {
        sum += arr[i][j];
      }
    }
    return sum;
  }
}
