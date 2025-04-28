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
    int limit = (int) Math.sqrt(n);     
    for (int i = 3; i <= limit; i += 2) { // Optimized loop condition       
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
  
  // Handle 2 separately to optimize odd number iterations
  if (n % 2 == 0) {
    while (n % 2 == 0) {
      ret.add(2);
      n /= 2;
    }
  }
  
  // Now we only need to check odd numbers, as all even numbers are divisible by 2
  for (int i = 3; i * i <= n; i += 2) {
    // No need to check if i is prime, as any composite number would have
    // been divided out by its smaller prime factors already
    while (n % i == 0) {
      ret.add(i);
      n /= i;
    }
  }
  
  if (n > 1) { // Add any remaining prime factor.
    ret.add(n);
  }
  
  return ret;
}
}