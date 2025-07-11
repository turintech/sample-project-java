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
    int smaller = 0, equal = 0, larger = v.size() - 1;
    // Use three-way partitioning for O(n) partition in-place
    while (equal <= larger) {
      int value = v.get(equal);
      if (value < pivot_value) {
        Collections.swap(v, smaller++, equal++);
      } else if (value == pivot_value) {
        equal++;
      } else {
        Collections.swap(v, equal, larger--);
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

    // Use a fixed-size minHeap of size n (saves memory)
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);
    for (int i = 0; i < v.size(); ++i) {
      if (minHeap.size() < n) {
        minHeap.offer(v.get(i));
      } else if (v.get(i) > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(v.get(i));
      }
    }

    Vector<Integer> ret = new Vector<>(n);
    while (!minHeap.isEmpty()) {
      ret.add(minHeap.poll());
    }
    Collections.reverse(ret); // Now the largest is first, descending order
    return ret;
  }
}