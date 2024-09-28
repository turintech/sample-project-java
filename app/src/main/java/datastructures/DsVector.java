package datastructures;

import java.util.Vector;

import java.util.Collections;
import java.util.List;

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
    Collections.reverse(v);
    return v;
  }

  /**
   * Rotates the vector by n
   *
   * @param v the vector to be rotated
   * @param n the number of times to rotate the vector
   * @return the rotated vector
   */
  public static Vector<Integer> rotateVector(Vector<Integer> v, int n) {
    Vector<Integer> ret = new Vector<Integer>();

    for (int i = n; i < v.size(); i++) {
      ret.add(v.get(i));
    }
    for (int i = 0; i < n; i++) {
      ret.add(v.get(i));
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
    Vector<Integer> ret = new Vector<Integer>();

    ret.addAll(v1);
    ret.addAll(v2);
    return ret;
  }
}