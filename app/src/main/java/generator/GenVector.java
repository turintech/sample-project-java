package generator;
import java.util.ArrayList;

import java.util.Random;
import java.util.Vector;

public class GenVector {
  /**
   * Generates a random vector of integers, length n
   *
   * @param n The length of the vector
   * @param m The maximum value of any element in the vector (non-inclusive)
   * @return A vector of length n
   */
  public static Vector<Integer> generateVector(int n, int m) {
    // Use ArrayList for better performance. Vectors are synchronized, which adds overhead.
    // Initialize ArrayList with capacity 'n' to minimize reallocations as elements are added.
    ArrayList<Integer> ret = new ArrayList<>(n); 
    Random rand = new Random();

    for (int i = 0; i < n; i++) {
      ret.add(rand.nextInt(m));
    }

    // Convert back to vector as the method's return type is Vector.
    // This maintains the contract of the method signature.
    return new Vector<>(ret); 
  }
}