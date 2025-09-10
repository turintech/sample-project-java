package algorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Utility class for prime number computations.
 */
public class Primes {
  /**
   * Checks if a number is prime.
   * <p>
   * Example usage:
   * <pre>
   *   boolean is5Prime = Primes.isPrime(5); // returns true
   * </pre>
   * @param n the number to check
   * @return {@code true} if {@code n} is prime, {@code false} otherwise
   */
  /**
   * Efficiently checks whether a number is prime.
   * Uses trial division up to sqrt(n) and handles even numbers early.
   *
   * @param n Number to check
   * @return true if n is prime, false otherwise
   */
  public static boolean isPrime(int n) {
    if (n < 2) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    int sqrt = (int) Math.sqrt(n);
    for (int i = 3; i <= sqrt; i += 2) {
      if (n % i == 0) return false;
    }
    return true;
  }

  /**
   * Sums all prime numbers up to a given non-negative limit (exclusive).
   * <p>
   * Example usage:
   * <pre>
   *   int sum = Primes.sumPrimes(10); // returns 17
   * </pre>
   * @param n the exclusive upper bound
   * @return the sum of all prime numbers less than {@code n}
   * @throws IllegalArgumentException if {@code n < 0}
   */
  /**
   * Computes the sum of all prime numbers less than n.
   * Uses the Sieve of Eratosthenes for efficient computation.
   * @param n exclusive upper bound
   * @return sum of all primes less than n
   * @throws IllegalArgumentException if n < 0
   */
  public static int sumPrimes(int n) {
    if (n < 0)
      throw new IllegalArgumentException("n must be non-negative");
    if (n <= 2)
      return 0;
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, 2, n, true);
    for (int i = 2; i * i < n; ++i) {
      if (isPrime[i]) {
        for (int j = i * i; j < n; j += i) {
          isPrime[j] = false;
        }
      }
    }
    int sum = 0;
    for (int i = 2; i < n; ++i) {
      if (isPrime[i]) sum += i;
    }
    return sum;
  }

  /**
   * Computes all prime factors of a number.
   * <p>
   * Example usage:
   * <pre>
   *   List<Integer> factors = Primes.primeFactors(12); // returns [2, 2, 3]
   * </pre>
   * @param n the integer to factorize (>1)
   * @return a List of all prime factors of {@code n} (in ascending order)
   * @throws IllegalArgumentException if {@code n < 2}
   */
  /**
   * Computes all prime factors of a number (n > 1).
   * Uses trial division up to sqrt(n).
   * @param n Integer to factorize (>1)
   * @return List of prime factors
   * @throws IllegalArgumentException if n < 2
   */
  public static List<Integer> primeFactors(int n) {
    if (n < 2) throw new IllegalArgumentException("n must be greater than 1");
    List<Integer> ret = new ArrayList<>();
    for (int i = 2; i * i <= n; i++) {
      while (n % i == 0) {
        ret.add(i);
        n /= i;
      }
    }
    if (n > 1) ret.add(n);
    return ret;
  }
}