package algorithms;

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
    for (int i = 2; i < n; i++) {
      if (n % i == 0 && i != n) {
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
    for (int i = 0; i < n; i++) {
      if (IsPrime(i)) {
        sum = sum + i;
      }
    }
    return sum;
  }

/**
   * Finds all primes factors of a number
   *
   * @param n The number to find the prime factors of.
   * @return An vector of all prime factors of n.
   */ 
  public static Vector<Integer> PrimeFactors(int n) {
    Vector<Integer> ret = new Vector<Integer>();

    for (int i = 2; i * i <= n; i++) {
      while (n % i == 0) {
        ret.add(i);
        n /= i;
      }
    }

    if (n > 1) {
      ret.add(n);
    }

    return ret;
  }
}