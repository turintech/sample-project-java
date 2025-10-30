package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for prime number operations.
 * This class cannot be instantiated.
 */
public final class Primes {
  /**
   * Maximum safe value for sumPrimes to prevent memory issues.
   * Arrays larger than this may cause OutOfMemoryError.
   */
  private static final int MAX_SIEVE_SIZE = 100_000_000;

  /**
   * Private constructor to prevent instantiation of utility class.
   */
  private Primes() {
    throw new AssertionError("Utility class should not be instantiated");
  }
  /**
   * Checks if a number is prime.
   * <p>
   * Examples:
   * <ul>
   *   <li>isPrime(2) returns true</li>
   *   <li>isPrime(17) returns true</li>
   *   <li>isPrime(4) returns false</li>
   *   <li>isPrime(-5) returns false</li>
   * </ul>
   *
   * @param n The number to check.
   * @return True if the number is prime, false otherwise.
   */
  public static boolean isPrime(final int n) {
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
   * <p>
   * This method efficiently calculates the sum using a sieve algorithm.
   * For very large values of n, consider memory constraints.
   * <p>
   * Examples:
   * <ul>
   *   <li>sumPrimes(10) returns 17 (2 + 3 + 5 + 7)</li>
   *   <li>sumPrimes(2) returns 0</li>
   *   <li>sumPrimes(100) returns 1060</li>
   * </ul>
   *
   * @param n The upper limit (exclusive) for prime numbers to sum.
   * @return The sum of all prime numbers less than n, or 0 if n <= 2.
   * @throws IllegalArgumentException if n is negative or exceeds maximum safe size.
   */
  public static long sumPrimes(final int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must be non-negative");
    }
    if (n > MAX_SIEVE_SIZE) {
      throw new IllegalArgumentException(
          String.format("n must not exceed %d to prevent memory issues", MAX_SIEVE_SIZE));
    }
    if (n <= 2) {
      return 0;
    }
    final boolean[] isPrime = new boolean[n];
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
   * <p>
   * Returns the prime factorization of n with repetitions.
   * For example, 12 = 2 × 2 × 3, so primeFactors(12) returns [2, 2, 3].
   * <p>
   * Examples:
   * <ul>
   *   <li>primeFactors(12) returns [2, 2, 3]</li>
   *   <li>primeFactors(13) returns [13]</li>
   *   <li>primeFactors(1) returns []</li>
   * </ul>
   *
   * @param n The number to find the prime factors of.
   * @return A List of all prime factors of n in ascending order.
   *         Returns an empty list if n <= 1.
   * @throws IllegalArgumentException if n is negative.
   */
  public static List<Integer> primeFactors(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must be non-negative");
    }
    if (n <= 1) {
      return Collections.emptyList();
    }

    final List<Integer> factors = new ArrayList<>();

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
