package algorithms;
import java.util.Vector;

public class Primes {
  /**
   * Checks if a number is prime
   * test comment
   * @param n The number to check.
   * @return True if the number is prime, false otherwise.
   */
  public static boolean IsPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i * i <= n; i++) { // Optimized loop condition
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sums all prime numbers less than n.
   *
   * @param n The upper limit (exclusive) for prime numbers to sum.
   * @return The sum of all prime numbers less than n.
   */
  public static int SumPrimes(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (IsPrime(i)) {
        sum = sum + i;
      }
    }
    return sum;
  }

  /**
   * Finds all primes factors of a number
   *
   * @param n The number to find the prime factors of.
   * @return An vector of all prime factors of n.
   */
  public static Vector<Integer> PrimeFactors(int n) {
    Vector<Integer> ret = new Vector<Integer>();

    // Handle non-positive numbers as having no prime factors
    if (n <= 1) {
        return ret;
    }

    for (int i = 2; i * i <= n; i++) { // Optimized loop condition
      // The IsPrime(i) check is redundant here because if 'i' divides 'n',
      // and 'i' itself is composite, then 'n' would have already been divided
      // by the prime factors of 'i' earlier in the loop (since 'i' increments).
      // Thus, if 'n % i == 0', 'i' must be prime.
      while (n % i == 0) {
        ret.add(i);
        n /= i; // Reduce n to avoid redundant checks.
      }
    }
    if (n > 1) { // Add any remaining prime factor. This happens if n itself is prime.
        ret.add(n);
    }
    return ret;
  }
}