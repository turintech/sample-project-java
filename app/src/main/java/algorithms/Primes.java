package algorithms;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for prime number computations.
 */
public class Primes {
  /**
   * Checks if a number is prime.
   * Skips even numbers and those divisible by 3 after basic checks, for improved performance.
   * <p>
   * Time complexity: O(√n/6), as we check fewer numbers.
   * Example usage:
   * <pre>
   *   boolean is5Prime = Primes.isPrime(5); // returns true
   * </pre>
   * @param n the number to check
   * @return {@code true} if {@code n} is prime, {@code false} otherwise
   */
  public static boolean isPrime(int n) {
    if (n < 2) return false;
    if (n == 2 || n == 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i <= Math.sqrt(n); i += 6) {
      if (n % i == 0 || n % (i + 2) == 0)
        return false;
    }
    return true;
  }

  /**
   * Sums all prime numbers up to a given non-negative limit (exclusive).
   * <p>
   * Time complexity: O(n sqrt n).
   * Example usage:
   * <pre>
   *   int sum = Primes.sumPrimes(10); // returns 17
   * </pre>
   * @param n the exclusive upper bound
   * @return the sum of all prime numbers less than {@code n}
   * @throws IllegalArgumentException if {@code n < 0}
   */
  public static int sumPrimes(int n) {
    if (n < 0) throw new IllegalArgumentException("n must be non-negative");
    int sum = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) {
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
  public static List<Integer> primeFactors(int n) {
    if (n < 2) throw new IllegalArgumentException("n must be greater than 1");
    List<Integer> ret = new ArrayList<>();
    for (int i = 2; i <= n / i; i++) {
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

  /**
   * Finds all primes up to n using the Sieve of Eratosthenes.
   * <p>
   * Time complexity: O(n log log n). Returns all primes in [2, n).
   * Example usage:
   * <pre>
   *   List<Integer> primes = Primes.sieveOfEratosthenes(10); // [2, 3, 5, 7]
   * </pre>
   * @param n the exclusive upper bound (>1)
   * @return list of all primes less than n
   * @throws IllegalArgumentException if {@code n < 2}
   */
  public static List<Integer> sieveOfEratosthenes(int n) {
    if (n < 2) throw new IllegalArgumentException("n must be at least 2");
    boolean[] isComposite = new boolean[n];
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i < n; i++) {
      if (!isComposite[i]) {
        primes.add(i);
        for (int j = i * 2; j < n; j += i) {
          isComposite[j] = true;
        }
      }
    }
    return primes;
  }
}