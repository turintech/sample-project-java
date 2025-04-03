package algorithms;
import java.util.ArrayList;
import java.util.List;

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
    for (int i = 3; i * i <= n; i += 2) { // Skip even numbers
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
    for (int i = 2; i < n; i++) { // Start from 2 as 0 and 1 are not prime
      if (IsPrime(i)) {
        sum += i;
      }
    }
    return sum;
  }

  /**
   * Finds all primes factors of a number
   *
   * @param n The number to find the prime factors of.
   * @return A list of all prime factors of n.
   */
  public static List<Integer> PrimeFactors(int n) {
    List<Integer> ret = new ArrayList<>();

    for (int i = 2; i * i <= n; i++) { // Optimized loop condition
      while (n % i == 0) { // No need to check IsPrime(i) here
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