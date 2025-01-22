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
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    for (int i = 3; i * i <= n; i += 2) { // Only check odd numbers
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
    if (n < 2) {
      return 0;
    }
    sum += 2; // Include 2 as the first prime
    for (int i = 3; i < n; i += 2) { // Only check odd numbers
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
   * @return An vector of all prime factors of n.
   */
  public static Vector<Integer> PrimeFactors(int n) {
    Vector<Integer> ret = new Vector<Integer>();
    
    // Handle 2 separately
    while (n % 2 == 0) {
      ret.add(2);
      n /= 2;
    }

    // Check odd numbers only
    for (int i = 3; i * i <= n; i += 2) {
      while (n % i == 0) {
        if (IsPrime(i)) {
          ret.add(i);
          n /= i;
        } else {
          break;
        }
      }
    }
    if (n > 1) { // Add any remaining prime factor.
        ret.add(n);
    }
    return ret;
  }
}