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
    int equal_value = 0;

    for (int i = 0; i < v.size(); i++) {
      if (v.get(i) < pivot_value) {
        Collections.swap(v, i, next_value);
        if (next_value != equal_value) {
          Collections.swap(v, i, equal_value);
        }
        next_value++;
        equal_value++;
      } else if (v.get(i) == pivot_value) {
        Collections.swap(v, i, equal_value);
        equal_value++;
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
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);

    for (int num : v) {
      if (minHeap.size() < n) {
        minHeap.add(num);
      } else if (num > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(num);
      }
    }

    Vector<Integer> ret = new Vector<>(minHeap);
    Collections.sort(ret, Collections.reverseOrder());
    return ret;
  }
}