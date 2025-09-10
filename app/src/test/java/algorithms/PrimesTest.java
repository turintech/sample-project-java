package algorithms;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class PrimesTest {
    @Test
    public void testIsPrimeBasic() {
        // Non-positive
        assertFalse(Primes.isPrime(-1));
        assertFalse(Primes.isPrime(0));
        assertFalse(Primes.isPrime(1));
        // Small primes and composites
        assertTrue(Primes.isPrime(2));
        assertTrue(Primes.isPrime(3));
        assertFalse(Primes.isPrime(4));
        assertTrue(Primes.isPrime(5));
        assertFalse(Primes.isPrime(9));
        // Larger composites
        assertFalse(Primes.isPrime(25));
        assertTrue(Primes.isPrime(97));
        // Test a large prime
        assertTrue(Primes.isPrime(15485863)); // 1 millionth prime
        // Test a large composite
        assertFalse(Primes.isPrime(100000002));
    }
    @Test
    public void testSumPrimes() {
        assertEquals(0, Primes.sumPrimes(2));
        assertEquals(2, Primes.sumPrimes(3));
        assertEquals(5, Primes.sumPrimes(5));
        assertEquals(17, Primes.sumPrimes(10));
        // Sum of primes below 30: 2+3+5+7+11+13+17+19+23+29 = 129
        assertEquals(129, Primes.sumPrimes(30));
        // Sum for a large bound, deterministic
        assertEquals(76127, Primes.sumPrimes(800));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSumPrimesNegative() {
        Primes.sumPrimes(-3);
    }
    @Test
    public void testPrimeFactorsBasic() {
        assertEquals(Arrays.asList(2,2,3), Primes.primeFactors(12));
        assertEquals(Arrays.asList(7), Primes.primeFactors(7));
        assertEquals(Arrays.asList(2,2,2,2), Primes.primeFactors(16));
        // Prime factors of a product of large primes
        assertEquals(Arrays.asList(15485863, 15485867), Primes.primeFactors(15485863 * 15485867));
        assertEquals(Arrays.asList(3, 3, 3, 37), Primes.primeFactors(999));
        // Prime power
        assertEquals(Collections.nCopies(10, 2), Primes.primeFactors(1024));
        // Largest 32-bit prime: Should be itself
        assertEquals(Arrays.asList(2147483647), Primes.primeFactors(2147483647));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPrimeFactorsEdgeBelow2() {
        Primes.primeFactors(1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPrimeFactorsZero() {
        Primes.primeFactors(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPrimeFactorsNegative() {
        Primes.primeFactors(-12345);
    }
}
