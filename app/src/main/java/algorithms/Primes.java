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
   * Returns whether {@code n} is a prime number.
   * Uses 6k +/- 1 optimization for performance with larger numbers.
   * <p>
   * @param n integer to check for primality
   * @return {@code true} if n is prime, otherwise {@code false}
   */
  public static boolean isPrime(int n) {
    if (n < 2) return false;
    if (n < 4) return true; // 2 and 3 are primes
    if (n % 2 == 0 || n % 3 == 0) return false;
    int sqrtN = (int) Math.sqrt(n);
    for (int i = 5; i <= sqrtN; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) return false;
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
  /**
   * Returns the list of prime factors for {@code n}, in ascending order.
   * <p>
   * @param n value to factorize (must be >1)
   * @return List of prime factors (possibly with repeats)
   * @throws IllegalArgumentException if n < 2
   */
  public static List<Integer> primeFactors(int n) {
    if (n < 2) throw new IllegalArgumentException("n must be greater than 1");
    List<Integer> ret = new ArrayList<>();
    // Remove factors of 2
    while (n % 2 == 0) {
      ret.add(2);
      n /= 2;
    }
    // Remove factors of 3
    while (n % 3 == 0) {
      ret.add(3);
      n /= 3;
    }
    int sqrtN = (int) Math.sqrt(n);
    for (int i = 5; i <= sqrtN && n > 1; i += 6) {
      while (n % i == 0) {
        ret.add(i);
        n /= i;
      }
      while (n % (i + 2) == 0) {
        ret.add(i + 2);
        n /= (i + 2);
      }
    }
    if (n > 1) ret.add(n);
    return ret;
  }
}