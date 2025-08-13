package algorithms;
import java.util.ArrayList;

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
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    for (int i = 3; i * i <= n; i += 2) { // Optimized loop condition
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sums all prime numbers from 0 to n
   *
   * @param n The number of prime numbers to sum.
   * @return The sum of the first n prime numbers.
   */
  public static int SumPrimes(int n) {
    int sum = 0;
    for (int i = 2; i < n; i++) {
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
  public static ArrayList<Integer> PrimeFactors(int n) {
    ArrayList<Integer> ret = new ArrayList<Integer>();

    // Handle factor 2 separately
    while (n % 2 == 0) {
      ret.add(2);
      n /= 2;
    }

    for (int i = 3; i * i <= n; i += 2) { // Optimized loop condition
      while (n % i == 0) { // Optimized to handle repeated factors
        ret.add(i);
        n /= i; // Reduce n to avoid redundant checks.
      }
    }
    if (n > 1) { // Add any remaining prime factor.
        ret.add(n);
    }
    return ret;
  }
}
