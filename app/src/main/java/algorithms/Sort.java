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
    int low = 0;
    int mid = 0;
    int high = v.size() - 1;

    while (mid <= high) {
      if (v.get(mid) < pivot_value) {
        Collections.swap(v, low, mid);
        low++;
        mid++;
      } else if (v.get(mid) == pivot_value) {
        mid++;
      } else {
        Collections.swap(v, mid, high);
        high--;
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
    if (n <= 0 || v.isEmpty()) {
      return new Vector<>();
    }
    n = Math.min(n, v.size());
    PriorityQueue<Integer> pq = new PriorityQueue<>(n);
    for (Integer num : v) {
      if (pq.size() < n) {
        pq.offer(num);
      } else if (num > pq.peek()) {
        pq.poll();
        pq.offer(num);
      }
    }
    Vector<Integer> ret = new Vector<>(n);
    while (!pq.isEmpty()) {
      ret.add(pq.poll());
    }
    Collections.reverse(ret);
    return ret;
  }
}