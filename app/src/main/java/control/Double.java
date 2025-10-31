package control;

public class Double {
  /**
   * Sums all values squared from 0 to n
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers squared.
   */
  public static int sumSquare(int n) {
    // Optimized: Use mathematical formula instead of nested loops
    // Sum of i² from 0 to n-1 = (n-1) * n * (2n-1) / 6
    if (n <= 0) {
      return 0;
    }
    return (n - 1) * n * (2 * n - 1) / 6;
  }

  /**
   * Sums all triangular numbers from T(1) to T(n)
   *
   * @param n The number of triangular numbers to sum.
   * @return The sum of the first n triangular numbers.
   */
  public static int sumTriangle(int n) {
    // Optimized: Use mathematical formula instead of nested loops
    // T(k) = k*(k-1)/2
    // Sum of T(0) to T(n) = Sum of k*(k-1)/2 from k=0 to n
    // = (1/2) * [Sum(k²) - Sum(k)] from k=0 to n
    // = (1/2) * [n*(n+1)*(2n+1)/6 - n*(n+1)/2]
    if (n < 0) {
      return 0;
    }
    return n * (n - 1) * (n + 1) / 6;
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
    for (int i = 0; i < arr.length; i++) {
      int nDuplicates = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          nDuplicates++;
        }
      }
      if (nDuplicates == 2) {
        count++;
      }
    }
    return count / 2;
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
    // Optimized: Remove unnecessary nested loop since we only check when i == j
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
