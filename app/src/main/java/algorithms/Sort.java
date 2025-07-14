package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
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
    int low = 0;
    int mid = 0;
    int high = v.size() - 1;

    while (mid <= high) {
      int cmp = v.get(mid).compareTo(pivot_value);
      if (cmp < 0) {
        Collections.swap(v, low++, mid++);
      } else if (cmp > 0) {
        Collections.swap(v, mid, high--);
      } else {
        mid++;
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
    if (n <= 0 || n > v.size()) {
      return new Vector<Integer>();
    }

    // Build the min-heap in linear time from the first n elements.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(v.subList(0, n));

    for (int i = n; i < v.size(); ++i) {
      if (v.get(i) > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(v.get(i));
      }
    }

    Vector<Integer> ret = new Vector<>(n);
    ret.setSize(n);
    // Poll elements from min-heap (ascending order) and insert into vector from the end
    // to get the final result in descending order.
    for (int i = n - 1; i >= 0; --i) {
      ret.set(i, minHeap.poll());
    }
    return ret;
  }
}