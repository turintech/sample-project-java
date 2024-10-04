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
    int low = 0, mid = 0, high = v.size() - 1;
    while (mid <= high) {
      if (v.get(mid) < pivot_value) {
        Collections.swap(v, low++, mid++);
      } else if (v.get(mid) > pivot_value) {
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
    if (n >= v.size()) {
      return new Vector<>(v);
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);
    for (int num : v) {
      if (minHeap.size() < n) {
        minHeap.offer(num);
      } else if (num > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(num);
      }
    }
    Vector<Integer> ret = new Vector<>(minHeap);
    Collections.reverse(ret);
    return ret;
  }
}