package datastructures;

import java.util.Vector;
import java.util.Collections;

public class DsVector {
  /**
   * Adds 1 to each element of the vector
   *
   * @param arr the vector to be incremented
   * @return the incremented vector
   */
  public static Vector<Integer> modifyVector(Vector<Integer> v) {
    // Use size outside for speedup
    int size = v.size();
    for (int i = 0; i < size; i++) {
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
    // Presize indices to min 4 or v.size() for better memory management
    Vector<Integer> indices = new Vector<Integer>(
      Math.min(4, Math.max(1, v.size() / 16))
    );
    int size = v.size();
    for (int i = 0; i < size; i++) {
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
    // O(n log n) instead of bubble sort
    Vector<Integer> ret = new Vector<Integer>(v);
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
    Vector<Integer> ret = new Vector<Integer>(v.size());
    for (int i = v.size() - 1; i >= 0; i--) {
      ret.add(v.get(i));
    }
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
    int size = v.size();
    if (size == 0) return new Vector<Integer>();
    n = n % size;
    if (n < 0) n += size; // handle negative rotates

    Vector<Integer> ret = new Vector<Integer>(size);

    // Add in-place rather than using two loops and to avoid excess copying
    for (int i = 0; i < size; i++) {
      ret.add(v.get((n + i) % size));
    }
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
    Vector<Integer> ret = new Vector<Integer>(v1.size() + v2.size());
    ret.addAll(v1);
    ret.addAll(v2);
    return ret;
  }
}