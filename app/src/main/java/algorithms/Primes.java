package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for prime number operations.
 */
public class Primes {
  /**
   * Checks if a number is prime.
   *
   * @param n The number to check.
   * @return True if the number is prime, false otherwise.
   */
  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    if (n == 2 || n == 3) {
      return true;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }
    // Check for divisors of the form 6k ± 1
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sums all prime numbers strictly less than n using the Sieve of Eratosthenes.
   *
   * @param n The upper limit (exclusive) for prime numbers to sum.
   * @return The sum of all prime numbers less than n, or 0 if n <= 2.
   * @throws IllegalArgumentException if n is negative.
   */
  public static long sumPrimes(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must be non-negative");
    }
    if (n <= 2) {
      return 0;
    }
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, 2, n, true);

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
   * @return A List of all prime factors of n in ascending order.
   *         Returns an empty list if n <= 1.
   */
  public static List<Integer> primeFactors(int n) {
    if (n <= 1) {
      return Collections.emptyList();
    }

    List<Integer> factors = new ArrayList<>();

    // Handle factor 2
    while (n % 2 == 0) {
      factors.add(2);
      n /= 2;
    }

    // Handle odd factors
    for (int i = 3; i * i <= n; i += 2) {
      while (n % i == 0) {
        factors.add(i);
        n /= i;
      }
    }

    // If n is still greater than 1, then it's a prime factor
    if (n > 1) {
      factors.add(n);
    }

    return factors;
  }
}
