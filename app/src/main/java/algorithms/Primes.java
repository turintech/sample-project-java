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
    // Optimize prime checking with square root limit
    for (int i = 2; i <= Math.sqrt(n); i++) {
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
  public static ArrayList<Integer> PrimeFactors(int n) {
    ArrayList<Integer> ret = new ArrayList<>();

    for (int i = 2; i <= Math.sqrt(n); i++) {
      while (n % i == 0) {
        if (IsPrime(i)) {
          ret.add(i);
        }
        n /= i;
      }
    }
    
    // If n > 1, it means n itself is a prime factor
    if (n > 1) {
      ret.add(n);
    }
    
    return ret;
  }
}