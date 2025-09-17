package algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Vector;

public class Sort {
  /**
   * Sorts a vector of integers in ascending order
   *
   * @param v The vector to be sorted
   */
  /**
   * Sorts a vector of integers in ascending order.
   * This method does nothing if the input is null.
   *
   * @param v The vector to be sorted. Can be null.
   */
  public static void sortVector(Vector<Integer> v) {
    if (v == null) return;
    Collections.sort(v);
  }

  /**
   * Partitions a vector of integers around a pivot using the Dutch National Flag algorithm.
   * This is done in-place in a single pass. After partitioning, elements smaller
   * than the pivot will appear first, followed by elements equal to the pivot,
   * and then elements larger than the pivot.
   *
   * @param v           The vector to be partitioned
   * @param pivot_value The value to partition around
   */
  /**
   * Partitions a vector of integers around a pivot using the Dutch National Flag algorithm.
   * After partitioning, elements smaller than the pivot appear first, followed by elements equal,
   * then elements larger than the pivot. Operates in-place; does nothing if v is null or empty.
   *
   * @param v           The vector to be partitioned. Not modified if null/empty.
   * @param pivotValue  The value to partition around
   */
  public static void dutchFlagPartition(Vector<Integer> v, int pivotValue) {
    if (v == null || v.isEmpty()) return;
    int low = 0;
    int mid = 0;
    int high = v.size() - 1;
    while (mid <= high) {
      Integer midVal = v.get(mid);
      if (midVal == null) {
        mid++; // skip nulls
        continue;
      }
      if (midVal < pivotValue) {
        Collections.swap(v, low++, mid++);
      } else if (midVal.equals(pivotValue)) {
        mid++;
      } else { // midVal > pivotValue
        Collections.swap(v, mid, high--);
      }
    }
  }

  /**
   * Returns the largest n elements in a vector.
   *
   * @param v The input vector
   * @param n The number of elements to return
   * @return A vector of the largest n elements in v, sorted in descending order
   */
  /**
   * Returns the largest n elements in a vector, sorted in descending order.
   * Returns an empty vector if n <= 0, if v is null, or if n > v.size().
   *
   * @param v The input vector. If null or n invalid, returns empty vector.
   * @param n The number of elements to return.
   * @return A vector of the largest n elements in v, sorted in descending order.
   */
  public static Vector<Integer> maxN(Vector<Integer> v, int n) {
    if (v == null || n <= 0 || n > v.size()) {
      return new Vector<>();
    }
    // Defensive: avoid nulls in vector
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int added = 0;
    for (Integer val : v) {
      if (val == null) continue;
      if (added < n) {
        minHeap.offer(val);
        added++;
      } else if (val > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(val);
      }
    }
    Vector<Integer> ret = new Vector<>(minHeap);
    ret.sort(Collections.reverseOrder()); // Sort in descending order
    return ret;
  }
}