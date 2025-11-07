package control;

import java.util.HashMap;
import java.util.Map;

public class Double {
  /**
   * Sums all values squared from 0 to n
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers squared.
   */
  public static int sumSquare(int n) {
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
    int totalSum = 0;
    int currentTriangularSum = 0;
    for (int i = 0; i <= n; i++) {
      totalSum += currentTriangularSum;
      currentTriangularSum += i;
    }
    return totalSum;
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
    Map<Integer, Integer> counts = new HashMap<>();
    for (int num : arr) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }

    int pairCount = 0;
    for (int count : counts.values()) {
      if (count == 2) {
        pairCount++;
      }
    }
    return pairCount;
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
    int limit = Math.min(arr0.length, arr1.length);
    for (int i = 0; i < limit; i++) {
      if (arr0[i] == arr1[i]) {
        count++;
      }
    }
    return count;
  }

  /**
   * Sums all values in a 2D array
   *
   * @param arr The 2D array of integers.
   * @return The sum of all values in the 2D array.
   */
  public static int sumMatrix(int[][] arr) {
    int sum = 0;
    for (int[] row : arr) {
      for (int val : row) {
        sum += val;
      }
    }
    return sum;
  }
}