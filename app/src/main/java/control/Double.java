package control;

public class Double {
  /**
   * Sums all values squared from 0 to n
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers squared.
   */
  public static int sumSquare(int n) {
    // Using mathematical formula for sum of squares: n(n-1)/2
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
    int sum = 0;
    // Simplified to single loop since we only need values up to i
    for (int i = 1; i <= n; i++) {
      sum += (i * (i - 1)) / 2;
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
    if (arr == null || arr.length < 2) {
      return 0;
    }
    
    // Use counting array for frequency
    int max = arr[0];
    for (int num : arr) {
      if (num > max) {
        max = num;
      }
    }
    
    int[] frequency = new int[max + 1];
    for (int num : arr) {
      frequency[num]++;
    }
    
    int count = 0;
    for (int freq : frequency) {
      if (freq == 2) {
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
    int minLength = Math.min(arr0.length, arr1.length);
    // Simplified to single loop since we only need to compare same indices
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
    // Already efficient, but can be simplified using enhanced for loop
    int sum = 0;
    for (int[] row : arr) {
      for (int value : row) {
        sum += value;
      }
    }
    return sum;
  }
}