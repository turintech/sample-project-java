package algorithms;
import java.util.PriorityQueue;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Vector;

public class Sort {
  /**
   * Sorts a vector of integers in ascending order
   *
   * @param v The vector to be sorted
   * @throws IllegalArgumentException if v is null
   */
  public static void SortVector(Vector<Integer> v) {
    if (v == null) {
      throw new IllegalArgumentException("Input vector cannot be null");
    }
    Collections.sort(v);
  }

  /**
   * Partitions a vector of integers around a pivot
   *
   * @param v           The vector to be partitioned
   * @param pivot_value The value to partition around
   * @throws IllegalArgumentException if v is null
   */
  public static void DutchFlagPartition(Vector<Integer> v, int pivot_value) {
    if (v == null) {
      throw new IllegalArgumentException("Input vector cannot be null");
    }
    
    int next_value = 0;
    int size = v.size();

    // First pass: move elements less than pivot to front
    for (int i = 0; i < size; i++) {
      if (v.get(i) < pivot_value) {
        Collections.swap(v, i, next_value++);
      }
    }

    // Second pass: move elements equal to pivot after the smaller elements
    for (int i = next_value; i < size; i++) {
      if (v.get(i) == pivot_value) {
        Collections.swap(v, i, next_value++);
      }
    }
  }

  /**
   * Returns the largest n elements in a vector
   *
   * @param v The vector to be sorted
   * @param n The number of elements to return
   * @return A vector of the largest n elements in v
   * @throws IllegalArgumentException if v is null or n is invalid
   */
  public static Vector<Integer> MaxN(Vector<Integer> v, int n) {
    if (v == null) {
      throw new IllegalArgumentException("Input vector cannot be null");
    }
    if (n < 0 || n > v.size()) {
      throw new IllegalArgumentException("n must be between 0 and vector size");
    }
    if (n == 0) {
      return new Vector<>();
    }

    // Use a min-heap to keep track of the n largest elements
    PriorityQueue<Integer> pq = new PriorityQueue<>(n);
    
    // Initialize with first n elements
    for (int i = 0; i < n; i++) {
      pq.offer(v.get(i));
    }
    
    // For remaining elements, if larger than smallest in heap, update heap
    for (int i = n; i < v.size(); i++) {
      if (v.get(i) > pq.peek()) {
        pq.poll();
        pq.offer(v.get(i));
      }
    }
    
    // Convert heap to vector in descending order
    Vector<Integer> ret = new Vector<>(n);
    while (!pq.isEmpty()) {
      ret.add(0, pq.poll());
    }

    return ret;
  }
}