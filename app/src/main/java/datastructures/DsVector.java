package datastructures;

import java.util.Collections; // Added import for Collections utility class
import java.util.Vector;

public class DsVector {
  /**
   * Adds 1 to each element of the vector
   *
   * @param arr the vector to be incremented
   * @return the incremented vector
   */
  public static Vector<Integer> modifyVector(Vector<Integer> v) {
    for (int i = 0; i < v.size(); i++) {
      v.set(i, v.get(i) + 1);
    }
    return v;
  }

  /**
   * Searches the vector for all instances of n
   *
   * @param v the vector to be searched
   * @ A vector of all indices where n was found
   */
  public static Vector<Integer> searchVector(Vector<Integer> v, int n) {
    Vector<Integer> indices = new Vector<Integer>();
    for (int i = 0; i < v.size(); i++) {
      if (v.get(i) == n) {
        indices.add(i);
      }
    }
    return indices;
  }

  /**
   * Sorts the vector in ascending order
   *
   * @param v the vector to be sorted
   * @return the sorted vector
   */
  public static Vector<Integer> sortVector(Vector<Integer> v) {
    // Create a copy of the input vector as the original method returns a new sorted vector.
    Vector<Integer> ret = new Vector<Integer>(v);

    // Replace the inefficient O(N^2) bubble sort with Collections.sort,
    // which typically uses Timsort (O(N log N) average and worst case).
    // This significantly improves runtime performance for larger vectors.
    Collections.sort(ret);

    return ret;
  }

  /**
   * Reverses the vector
   *
   * @param v the vector to be reversed
   * @return the reversed vector
   */
  public static Vector<Integer> reverseVector(Vector<Integer> v) {
    // Create a copy of the input vector as the original method returns a new reversed vector.
    Vector<Integer> ret = new Vector<Integer>(v);

    // Use Collections.reverse for an optimized in-place reversal.
    // This is generally more efficient than a manual loop due to native implementations.
    Collections.reverse(ret);
    return ret;
  }

  /**
   * Rotates the vector by n
   *
   * @param v the vector to be rotated
   * @param n the number of times to rotate the vector
   * @return the rotated vector
   */
  public static Vector<Integer> rotateVector(Vector<Integer> v, int n) {
    // Create a copy of the input vector as the original method returns a new rotated vector.
    Vector<Integer> ret = new Vector<Integer>(v);

    // Use Collections.rotate for an optimized in-place rotation.
    // This is generally more efficient than a manual loop and handles rotation logic robustly.
    Collections.rotate(ret, n);
    return ret;
  }

  /**
   * Merges two vectors
   *
   * @param v1 the first vector to be merged
   * @param v2 the second vector to be merged
   * @return the merged vector
   */
  public static Vector<Integer> mergeVectors(Vector<Integer> v1,
      Vector<Integer> v2) {
    // Pre-allocate the capacity of the new vector to the sum of the sizes of v1 and v2.
    // This reduces the number of reallocations (and associated memory copying)
    // that occur as elements are added, improving both runtime and memory efficiency.
    Vector<Integer> ret = new Vector<Integer>(v1.size() + v2.size());

    // Use addAll for bulk addition. This is often more efficient than adding
    // elements one by one in a loop, as addAll can potentially optimize the process
    // and leverage the pre-allocated capacity.
    ret.addAll(v1);
    ret.addAll(v2);

    return ret;
  }
}