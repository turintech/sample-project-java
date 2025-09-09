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
   * Sums all prime numbers from 0 to n
   *
   * @param n The number of prime numbers to sum.
   * @return The sum of the first n prime numbers.
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

  /**
   * Implements the Sieve of Eratosthenes algorithm to find all prime numbers up to n
   * 
   * @param n The upper bound to check for primes
   * @return Boolean array where array[i] indicates if i is prime
   */
  private static boolean[] sieveOfEratosthenes(int n) {
    // Handle edge case: n < 2
    if (n < 2) {
      return new boolean[0]; // Return empty array for n < 2
    }
    
    // Initialize boolean array of size n, assuming all numbers are prime initially
    boolean[] isPrime = new boolean[n];
    for (int i = 0; i < n; i++) {
      isPrime[i] = true;
    }
    
    // Mark 0 and 1 as non-prime (if within bounds)
    if (n > 0) isPrime[0] = false;
    if (n > 1) isPrime[1] = false;
    
    // Implement sieve logic: for each prime p, mark all multiples as composite
    // Optimize loop bounds: outer loop only needs to go up to √n
    for (int p = 2; p * p < n; p++) {
      // If isPrime[p] is not changed, then it is a prime
      if (isPrime[p]) {
        // Start marking multiples from p² (smaller multiples already marked by smaller primes)
        for (int i = p * p; i < n; i += p) {
          isPrime[i] = false;
        }
      }
    }
    
    // Return the boolean array with correct prime markings
    return isPrime;
  }
}
