package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Primes {
  /**
   * Checks if a number is prime.
   *
   * @param n The number to check.
   * @return True if the number is prime, false otherwise.
   */
  public static boolean IsPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sums all prime numbers strictly less than n using the Sieve of Eratosthenes.
   *
   * @param n The upper limit (exclusive) for prime numbers to sum.
   * @return The sum of all prime numbers less than n.
   */
  public static long SumPrimes(int n) {
    if (n <= 2) {
      return 0;
    }
    boolean[] isPrime = new boolean[n];
    for (int i = 2; i < n; i++) {
      isPrime[i] = true;
    }
    for (int p = 2; p * p < n; p++) {
      if (isPrime[p]) {
        for (int i = p * p; i < n; i += p) {
          isPrime[i] = false;
        }
      }
    }
    long sum = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime[i]) {
        sum += i;
      }
    }
    return sum;
  }

  /**
   * Finds all prime factors of a number.
   *
   * @param n The number to find the prime factors of.
   * @return A List of all prime factors of n.
   */
  public static List<Integer> PrimeFactors(int n) {
    List<Integer> ret = new ArrayList<>();

    // Handle factor 2
    while (n % 2 == 0) {
      ret.add(2);
      n /= 2;
    }

    // Handle odd factors
    for (int i = 3; i * i <= n; i += 2) {
      while (n % i == 0) {
        ret.add(i);
        n /= i;
      }
    }
    
    // This condition handles the case where n is a prime number greater than 2.
    if (n > 1) {
      ret.add(n);
    }
    
    return ret;
  }
}
