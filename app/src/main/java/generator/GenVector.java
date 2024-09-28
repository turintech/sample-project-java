package generator;

import java.util.Random;
import java.util.Vector;

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
    Vector<Integer> ret = new Vector<Integer>(n);
    Random rand = new Random();

    for (int i = 0; i < n; i++) {
      ret.add(rand.nextInt(m));
    }

    return ret;
  }
}