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
    // The original code was doing a double loop when it could be a single loop.
    // Reduced time complexity from O(n^2) to O(n)
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum = sum + i * i;
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
    // Can calculate the sum of triangular numbers directly using a formula.
    // Reduced time complexity from O(n^2) to O(1).
    return n * (n + 1) * (n + 2) / 6;
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
    // Use a HashMap to count occurrences efficiently.
    // Reduced time complexity from O(n^2) to O(n).
    HashMap<Integer, Integer> counts = new HashMap<>();
    int pairs = 0;

    for (int num : arr) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }

    for (int count : counts.values()) {
      if (count == 2) {
        pairs++;
      }
    }

    return pairs;
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
    // Removed unnecessary nested loop.
    // Reduced time complexity from O(n^2) to O(n)
    int count = 0;
    if (arr0.length != arr1.length) {
      return 0; // Or throw an exception, depending on desired behavior
    }
    for (int i = 0; i < arr0.length; i++) {
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