package algorithms;

import java.util.Collections;
import java.util.Vector;
import java.util.PriorityQueue;

public class Sort {
  /**
   * Sorts a vector of integers in ascending order
   *
   * @param v The vector to be sorted
   */
  public static void SortVector(Vector<Integer> v) {
    Collections.sort(v);
  }

  /**
   * Partitions a vector of integers around a pivot
   *
   * @param v           The vector to be partitioned
   * @param pivot_value
   */
  public static void DutchFlagPartition(Vector<Integer> v, int pivot_value) {
    int next_value = 0;

    // Iterate through the vector to partition values less than the pivot
    for (int i = 0; i < v.size(); i++) {
      if (v.get(i) < pivot_value) {
        Collections.swap(v, i, next_value);
        next_value++;
      }
    }

    // Iterate through the vector to partition values equal to the pivot
    for (int i = next_value; i < v.size(); i++) {
      if (v.get(i) == pivot_value) {
        Collections.swap(v, i, next_value);
        next_value++;
      }
    }
  }

  /**
   * Returns the largest n elements in a vector
   *
   * @param v The vector to be sorted
   * @param n The number of elements to return
   * @return A vector of the largest n elements in v
   */
  public static Vector<Integer> MaxN(Vector<Integer> v, int n) {
    // Validate input parameters
    if (n <= 0 || v == null || v.size() < n) {
      throw new IllegalArgumentException("Invalid input parameters");
    }

    // Create a min-heap to keep track of the largest n elements
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);
    
    // Iterate through the vector to populate the min-heap
    for (int num : v) {
      if (minHeap.size() < n) {
        minHeap.offer(num);
      } else if (num > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(num);
      }
    }

    // Convert the min-heap to a vector and sort it in descending order
    Vector<Integer> ret = new Vector<>(minHeap);
    Collections.sort(ret, Collections.reverseOrder());
    return ret;
  }
}