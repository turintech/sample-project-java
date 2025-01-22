package algorithms;
import java.util.List;
import java.util.ArrayList;
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
   * Sums all prime numbers from 0 to n
   *
   * @param n The number of prime numbers to sum.
   * @return The sum of the first n prime numbers.
   */
  public static int SumPrimes(int n) {
    int sum = 0;
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      if (IsPrime(i)) {
        primes.add(i);
      }
    }
    for (int p : primes) {
        sum += p;
    }
    return sum;
  }

  /**
   * Finds all primes factors of a number
   *
   * @param n The number to find the prime factors of.
   * @return An vector of all prime factors of n.
   */
  public static List<Integer> PrimeFactors(int n) {
    List<Integer> ret = new ArrayList<>();

    for (int i = 2; i * i <= n; i++) { // Optimized loop condition
      while (n % i == 0 && IsPrime(i)) { // Optimized to handle repeated factors
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
