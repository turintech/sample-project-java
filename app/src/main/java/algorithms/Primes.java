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
 * Checks if a number is prime using an efficient method (6k ± 1 optimization).
 *
 * @param n the number to check
 * @return {@code true} if {@code n} is prime, {@code false} otherwise
 */
public static boolean isPrime(int n) {
    if (n < 2) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    int sqrtN = (int)Math.sqrt(n);
    for (int i = 5; i <= sqrtN; i += 6) {
        if (n % i == 0 || n % (i+2) == 0) return false;
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
   * Sums all prime numbers up to a given non-negative limit (exclusive).
   * Uses the Sieve of Eratosthenes for efficiency.
   *
   * @param n the exclusive upper bound
   * @return the sum of all prime numbers less than {@code n}
   * @throws IllegalArgumentException if {@code n < 0}
   */
  public static int sumPrimes(int n) {
    if (n < 0)
      throw new IllegalArgumentException("n must be non-negative");
    if (n <= 2)
      return 0;
    boolean[] isComposite = new boolean[n];
    int sum = 0;
    for (int i = 2; i < n; i++) {
      if (!isComposite[i]) {
        sum += i;
        for (int j = i + i; j < n; j += i) {
          isComposite[j] = true;
        }
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
   * Computes all prime factors of a number efficiently.
   * @param n the integer to factorize (>1)
   * @return a List of all prime factors of {@code n} (in ascending order)
   * @throws IllegalArgumentException if {@code n < 2}
   */
  public static List<Integer> primeFactors(int n) {
    if (n < 2) throw new IllegalArgumentException("n must be greater than 1");
    List<Integer> ret = new ArrayList<>();
    // Handle divisibility by 2
    while (n % 2 == 0) {
      ret.add(2);
      n /= 2;
    }
    // Handle divisibility by 3
    while (n % 3 == 0) {
      ret.add(3);
      n /= 3;
    }
    // Check possible factors of form 6k ± 1
    for (int i = 5; i <= Math.sqrt(n); i += 6) {
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