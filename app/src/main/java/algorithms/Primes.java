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
   * @param n The upper limit (exclusive) for summing prime numbers.
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

    for (int i = 2; i * i <= n; i++) { // Optimized loop condition
      // A factor 'i' found at this point is guaranteed to be prime
      // because any composite factors smaller than 'i' would have already divided 'n'.
      while (n % i == 0) { // Removed redundant IsPrime(i) check for performance
        ret.add(i);
        n /= i; // Reduce n to avoid redundant checks.
      }
    }
    if (n > 1) { // Add any remaining prime factor. This covers the case where n itself is a prime greater than 1.
        ret.add(n);
    }
    return ret;
  }
}