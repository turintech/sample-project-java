package algorithms;
import java.util.ArrayList;
import java.lang.Math;

import java.util.Vector;

public class Primes {
  /**
   * Checks if a number is prime
   *
   * @param n The number to check.
   * @return True if the number is prime, false otherwise.
   */
  public static boolean IsPrime(int n) {
    if (n < 2) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sums all prime numbers from 0 to n
   *
   * @param n The number of prime numbers to sum.
   * @return The sum of the first n prime numbers.
   */
  public static int SumPrimes(int n) {
    int sum = 0;
    for (int i = 2; i < n; i++) {
      if (IsPrime(i)) {
        sum += i;
      }
    }
    return sum;
  }

  /**
   * Finds all primes factors of a number
   *
   * @param n The number to find the prime factors of.
   * @return An ArrayList of all prime factors of n.
   */
  public static ArrayList<Integer> PrimeFactors(int n) {
    ArrayList<Integer> ret = new ArrayList<>();

    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0 && IsPrime(i)) {
        ret.add(i);
      }
    }
    return ret;
  }
}