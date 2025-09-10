package algorithms;
import java.util.ArrayList;
import java.util.List;

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
   * Uses the 6k±1 optimization for improved performance.
   */
  public static boolean isPrime(int n) {
    if (n < 2) return false;
    if (n == 2 || n == 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
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
   * Uses Sieve of Eratosthenes for better efficiency.
   */
  public static int sumPrimes(int n) {
    if (n < 0) throw new IllegalArgumentException("n must be non-negative");
    if (n <= 2) return 0;
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i < n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j < n; j += i) {
          isPrime[j] = false;
        }
      }
    }
    int sum = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime[i]) {
        sum += i;
      }
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
   * Uses optimized trial division.
   * Factors out 2 and 3 first. Then uses increments of 6.
   */
  public static List<Integer> primeFactors(int n) {
    if (n < 2)
      throw new IllegalArgumentException("n must be greater than 1");
    List<Integer> ret = new ArrayList<>();
    // factor out all 2s
    while (n % 2 == 0) {
      ret.add(2);
      n /= 2;
    }
    // factor out all 3s
    while (n % 3 == 0) {
      ret.add(3);
      n /= 3;
    }
    for (int i = 5; i * i <= n; i += 6) {
      while (n % i == 0) {
        ret.add(i);
        n /= i;
      }
      while (n % (i + 2) == 0) {
        ret.add(i + 2);
        n /= (i + 2);
      }
    }
    if (n > 1) {
      ret.add(n);
    }
    return ret;
  }
}