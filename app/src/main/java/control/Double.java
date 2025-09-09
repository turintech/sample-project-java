package control;

import java.util.HashMap;
import java.util.Map;

public class Double {
  /**
   * Sums all squares 0^2 + 1^2 + ... + (n-1)^2.
   * <p>
   * For n &lt;= 0, the sum is 0. If n is large (near Integer.MAX_VALUE), the result may overflow.
   *
   * @param n the exclusive upper bound (sum from 0 to n-1 squared)
   * @return the sum of squares from 0 to n-1; 0 if n &lt;= 0.
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
   * Returns the sum of the first n triangular numbers, i.e., sum of T(i) for i=1..n where T(i) = i*(i+1)/2.
   * <p>
   * For n &lt;= 0, the sum is 0. For large n, result may overflow.
   *
   * @param n number of triangular numbers to sum (non-negative)
   * @return the sum T(1) + T(2) + ... + T(n), or 0 if n &lt;= 0.
   */
  public static int sumTriangle(final int n) {
    if (n <= 0) return 0;
    int sum = 0;
    int triangularNumber = 0;
    for (int i = 1; i <= n; i++) {
      triangularNumber += i;
      sum += triangularNumber;
    }
    return sum;
  }

  /**
   * Counts values that appear exactly twice in the array (i.e., "pairs").
   * <p>
   * A pair is any integer value that occurs exactly twice. Null arrays count as 0 pairs. For empty or
   * singleton arrays, result is 0.
   *
   * @param arr the input array (may be null)
   * @return number of unique values occurring exactly twice, or 0 for null/empty input
   */
  public static int countPairs(final int[] arr) {
    if (arr == null || arr.length < 2) return 0;
    Map<Integer, Integer> counts = new HashMap<>();
    for (int value : arr) {
      counts.put(value, counts.getOrDefault(value, 0) + 1);
    }
    int pairs = 0;
    for (int count : counts.values()) {
      if (count == 2) {
        pairs++;
      }
    }
    return pairs;
  }

  /**
   * Counts positions where arr0[i] == arr1[i], for all possible i. Null or empty arrays return 0 matches.
   * <p>
   * Only indexes within both arrays' bounds are compared. No exception for differing lengths; excess elements ignored.
   *
   * @param arr0 first array (may be null)
   * @param arr1 second array (may be null)
   * @return count of matching elements at identical positions; 0 if either array is null
   */
  public static int countDuplicates(final int[] arr0, final int[] arr1) {
    if (arr0 == null || arr1 == null) return 0;
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
   * <p>
   * If arr is null, returns 0. Ignores null rows. For a non-rectangular array, all provided elements are summed.
   *
   * @param arr the 2D array (may be null or ragged)
   * @return the sum of all int values in the matrix; 0 for null or empty input
   */
  public static int sumMatrix(final int[][] arr) {
    if (arr == null) return 0;
    int sum = 0;
    for (int[] row : arr) {
      if (row == null) continue;
      for (int value : row) {
        sum += value;
      }
    }
    return sum;
  }
}