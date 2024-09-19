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
    if (n <= 2) return 0;
    boolean[] isComposite = new boolean[n];
    int sum = 2;
    for (int i = 3; i < n; i += 2) {
      if (!isComposite[i]) {
        sum += i;
        for (int j = i * i; j < n; j += i) {
          isComposite[j] = true;
        }
      }
    }
    return sum;
  }

public static Vector<Integer> PrimeFactors(int n) {
    Vector<Integer> ret = new Vector<Integer>();
    if (n <= 1) return ret;
    while (n % 2 == 0) {
        ret.add(2);
        n /= 2;
    }
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
        while (n % i == 0) {
            ret.add(i);
            n /= i;
        }
    }
    if (n > 2) {
        ret.add(n);
    }
    return ret;
}
}