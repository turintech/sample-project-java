package algorithms;
import java.util.PriorityQueue;

import java.util.Collections;
import java.util.Vector;

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

    for (int i = 0; i < v.size(); i++) {
      if (v.get(i) < pivot_value) {
        Collections.swap(v, i, next_value);
        next_value++;
      }
    }

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
    // Use a PriorityQueue to store the largest n elements
    java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < v.size(); i++) {
      maxHeap.offer(v.get(i));
      // If the heap size exceeds n, remove the smallest element
      if (maxHeap.size() > n) {
        maxHeap.poll();
      }
    }
    // Extract the elements from the heap
    Vector<Integer> ret = new Vector<Integer>();
    while (!maxHeap.isEmpty()) {
      ret.add(maxHeap.poll());
    }
    // Reverse the vector to get the elements in ascending order
    Collections.reverse(ret);
    return ret;
  }
}