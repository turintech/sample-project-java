package control;
import java.util.Map;
import java.util.HashMap;

public class Double {
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
    int sum = 0;
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < i; j++) {
        sum = sum + j;
      }
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
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    int count = 0;

    for (int num : arr) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    for (int frequency : frequencyMap.values()) {
      if (frequency == 2) {
        count++;
      }
    }

    return count;
  }

public static int countDuplicates(int[] arr0, int[] arr1) {
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