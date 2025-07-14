package algorithms;
import java.util.Vector;
import java.util.Arrays; // Added for Sieve of Eratosthenes

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
    if (n == 2 || n == 3) { // 2 and 3 are prime numbers
      return true;
    }
    // Check for divisibility by 2 and 3. Any number divisible by 2 or 3 (that isn't 2 or 3 itself) is not prime.
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }
    // All primes greater than 3 can be written in the form 6k ± 1.
    // We only need to check divisors of this form. This reduces the number of checks significantly.
    for (int i = 5; i * i <= n; i = i + 6) {
      if (n % i == 0 || n % (i + 2) == 0) { // Check i and i+2 (which corresponds to 6k+1 and 6k+5)
        return false;
      }
    }
    return true;
  }

  /**
   * Sums all prime numbers less than n.
   *
   * @param n The upper limit (exclusive). Prime numbers less than this value will be summed.
   * @return The sum of all prime numbers less than n.
   */
  public static int SumPrimes(int n) { // Kept return type int to avoid breaking consumers
    if (n <= 2) { // Primes are 2, 3, 5... so no primes less than or equal to 2 (except if n=2 which means sum primes < 2, so 0)
      return 0;
    }

    // Use Sieve of Eratosthenes to find all primes up to n-1.
    // This is much more efficient than calling IsPrime repeatedly for each number, especially for larger n,
    // as it computes primality for all numbers up to n in a single pass.
    boolean[] isPrime = new boolean[n]; // Array to store primality of numbers up to n-1
    Arrays.fill(isPrime, true); // Initialize all entries as true

    isPrime[0] = false; // 0 is not prime
    isPrime[1] = false; // 1 is not prime

    // Start marking multiples from p*p, as smaller multiples would have already been marked by smaller prime factors.
    for (int p = 2; p * p < n; p++) {
      // If isPrime[p] is true, then p is a prime number
      if (isPrime[p]) {
        // Mark all multiples of p (starting from p*p) as not prime.
        for (int i = p * p; i < n; i += p) {
          isPrime[i] = false;
        }
      }
    }

    int sum = 0; // Sum of primes
    // Iterate through the boolean array and sum up all numbers that are marked as prime.
    for (int i = 0; i < n; i++) {
      if (isPrime[i]) {
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

    // Handle factor 2 separately. This optimizes by allowing subsequent loops to only check odd numbers,
    // reducing iterations by half.
    while (n % 2 == 0) {
      ret.add(2);
      n /= 2;
    }

    // Now n must be odd. Iterate through odd numbers starting from 3 up to sqrt(n).
    // No need to check IsPrime(i) within the loop. If 'i' divides 'n' at this point,
    // it must be a prime factor because all smaller prime factors (including 2) would have already
    // divided 'n' down, and if 'i' were composite, its own prime factors would have been handled earlier.
    for (int i = 3; i * i <= n; i += 2) { // Only check odd factors
      while (n % i == 0) {
        ret.add(i);
        n /= i; // Reduce n to avoid redundant checks and find subsequent factors efficiently.
      }
    }
    // If n is still greater than 1 after the loop, it means the remaining n is a prime factor itself.
    // This happens if the original number was prime, or if its largest prime factor is greater than sqrt(original_n).
    if (n > 1) {
        ret.add(n);
    }
    return ret;
  }
}