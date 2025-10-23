package datastructures;

import java.util.Vector;
import java.util.Collections; // Required for Collections.sort and Collections.reverse

public class DsVector {
  /**
   * Adds 1 to each element of the vector IN-PLACE.
   *
   * @param v the vector to be incremented
   * @return the incremented vector (the same instance passed as input)
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
   * @param n the integer to search for
   * @return A vector of all indices where n was found
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
   * Sorts the vector in ascending order. A new sorted vector is returned,
   * the original vector remains unchanged.
   *
   * @param v the vector to be sorted
   * @return a new sorted vector
   */
  public static Vector<Integer> sortVector(Vector<Integer> v) {
    Vector<Integer> ret = new Vector<Integer>(v); // Create a copy to avoid modifying the original
    Collections.sort(ret); // Use built-in sort for efficiency and clarity
    return ret;
  }

  /**
   * Reverses the vector. A new reversed vector is returned,
   * the original vector remains unchanged.
   *
   * @param v the vector to be reversed
   * @return a new reversed vector
   */
  public static Vector<Integer> reverseVector(Vector<Integer> v) {
    Vector<Integer> ret = new Vector<Integer>(v); // Create a copy to avoid modifying the original
    Collections.reverse(ret); // Use built-in reverse for efficiency and clarity
    return ret;
  }

  /**
   * Rotates the vector by n positions to the left. A new rotated vector is returned,
   * the original vector remains unchanged.
   *
   * @param v the vector to be rotated
   * @param n the number of times to rotate the vector (left rotation)
   * @return a new rotated vector
   */
  public static Vector<Integer> rotateVector(Vector<Integer> v, int n) {
    Vector<Integer> ret = new Vector<Integer>();

    // Handle negative rotations or rotations larger than size
    int effectiveRotation = n % v.size();
    if (effectiveRotation < 0) {
        effectiveRotation += v.size(); // Ensure positive rotation
    }

    // Add elements from effectiveRotation to the end
    for (int i = effectiveRotation; i < v.size(); i++) {
      ret.add(v.get(i));
    }
    // Add elements from the beginning up to effectiveRotation
    for (int i = 0; i < effectiveRotation; i++) {
      ret.add(v.get(i));
    }
    return ret;
  }

  /**
   * Merges two vectors into a new vector.
   * The elements of v1 are added first, followed by the elements of v2.
   *
   * @param v1 the first vector to be merged
   * @param v2 the second vector to be merged
   * @return a new merged vector
   */
  public static Vector<Integer> mergeVectors(Vector<Integer> v1,
      Vector<Integer> v2) {
    Vector<Integer> ret = new Vector<Integer>();

    ret.addAll(v1); // More concise way to add all elements
    ret.addAll(v2); // More concise way to add all elements

    return ret;
  }
}