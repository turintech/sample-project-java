package algorithms;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for prime number computations.
 */
public class Primes {
  /**
   * Checks if a number is prime using trial division up to the square root of n.
   * <p>
   * Example usage:
   * <pre>
   *   boolean is5Prime = Primes.isPrime(5); // returns true
   * </pre>
   * @param n the number to check (must be a non-negative integer)
   * @return {@code true} if {@code n} is prime, {@code false} otherwise
   * @implNote This method is thread-safe. Input must be >= 0.
   */
  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i <= n / i; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sums all prime numbers up to a given non-negative limit (exclusive) using the Sieve of Eratosthenes.
   * This algorithm is more efficient for large values of n.
   * <p>
   * Example usage:
   * <pre>
   *   int sum = Primes.sumPrimes(10); // returns 17
   * </pre>
   * @param n the exclusive upper bound. Must be non-negative.
   * @return the sum of all prime numbers less than {@code n}
   * @throws IllegalArgumentException if {@code n < 0}
   * @implNote This method is thread-safe as it uses only local variables.
   */
  public static int sumPrimes(int n) {
    if (n < 0) throw new IllegalArgumentException("n must be non-negative");
    if (n <= 2) return 0;
    boolean[] isComposite = new boolean[n];
    int sum = 0;
    for (int i = 2; i < n; i++) {
      if (!isComposite[i]) {
        sum += i;
        // Mark multiples of i as composite
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
   * @param n the integer to factorize (>1). Must be >= 2.
   * @return a List of all prime factors of {@code n} (in ascending order)
   * @throws IllegalArgumentException if {@code n < 2}
   * @implNote This method is thread-safe as it uses only local variables.
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
}