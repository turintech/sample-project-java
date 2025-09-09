package control;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Utility class for double-indexed and pair-wise array operations.
 * Not instantiable.
 */
public final class Double {
  private Double() {
    throw new AssertionError("Utility class - not to be instantiated");
  }
  /**
   * Sums all squares of values from 0 to n-1.
   *
   * @param n the exclusive upper bound, requires n >= 0
   * @return the sum of squares of the first n natural numbers
   */
  public static int sumSquare(final int n) {
    if (n <= 0) return 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += i * i;
    }
    return sum;
  }

  /**
   * Sums the first n triangular numbers, i.e., sum of T(i) for i = 0 to n-1, where T(i) = i * (i + 1) / 2.
   *
   * @param n number of terms to sum, requires n >= 0
   * @return the sum of the first n triangular numbers (starting at T(0) = 0)
   */
  public static int sumTriangle(final int n) {
    if (n <= 0) return 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += i * (i + 1) / 2;
    }
    return sum;
  }

  /**
   * Counts the number of distinct values that occur exactly twice in an array.
   *
   * @param arr the input array, not null
   * @return number of distinct values that appear exactly twice
   * @throws NullPointerException if the array is null
   */
  public static int countPairs(final int[] arr) {
    Objects.requireNonNull(arr, "Input array cannot be null");
    Map<Integer, Integer> counts = new HashMap<>();
    for (final int value : arr) {
      counts.put(value, counts.getOrDefault(value, 0) + 1);
    }
    int pairs = 0;
    for (final int count : counts.values()) {
      if (count == 2) {
        pairs++;
      }
    }
    return pairs;
  }

  /**
   * Counts the number of positions at which two arrays have the same value.
   * Only the overlapping range (up to the shorter array's length) is compared.
   *
   * @param arr0 first array, not null
   * @param arr1 second array, not null
   * @return number of indices i such that arr0[i] == arr1[i]
   * @throws NullPointerException if either array is null
   */
  public static int countDuplicates(final int[] arr0, final int[] arr1) {
    Objects.requireNonNull(arr0, "First array cannot be null");
    Objects.requireNonNull(arr1, "Second array cannot be null");
    int count = 0;
    int length = Math.min(arr0.length, arr1.length);
    for (int i = 0; i < length; i++) {
      if (arr0[i] == arr1[i]) {
        count++;
      }
    }
    return count;
  }

  /**
   * Sums all values in a rectangular 2D array (matrix).
   *
   * @param arr The 2D array of integers, not null
   * @return The sum of all values in the array
   * @throws NullPointerException if arr or any row is null
   */
  public static int sumMatrix(final int[][] arr) {
    Objects.requireNonNull(arr, "Input 2D array cannot be null");
    int sum = 0;
    for (final int[] row : arr) {
      Objects.requireNonNull(row, "Row in 2D array cannot be null");
      for (final int value : row) {
        sum += value;
      }
    }
    return sum;
  }
}