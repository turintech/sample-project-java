package algorithms;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class PrimesTest {
    @Test
    public void testIsPrimeBasic() {
        assertFalse(Primes.isPrime(-1));
        assertFalse(Primes.isPrime(0));
        assertFalse(Primes.isPrime(1));
        assertTrue(Primes.isPrime(2));
        assertTrue(Primes.isPrime(3));
        assertFalse(Primes.isPrime(4));
        assertTrue(Primes.isPrime(5));
        assertFalse(Primes.isPrime(9));
    }
    @Test
    public void testSumPrimes() {
        assertEquals(0, Primes.sumPrimes(2));
        assertEquals(2, Primes.sumPrimes(3));
        assertEquals(5, Primes.sumPrimes(5));
        assertEquals(17, Primes.sumPrimes(10));
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
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPrimeFactorsEdge() {
        Primes.primeFactors(1);
    }
    
    @Test
    public void testSumPrimesLarge() {
        int sum10000 = Primes.sumPrimes(10000);
        // This value is known: 5736396
        assertEquals(5736396, sum10000);
    }

    @Test
    public void testPrimeFactorsLarge() {
        int big = 2 * 2 * 3 * 11 * 17 * 41; // 1848
        List<Integer> expected = Arrays.asList(2,2,3,11,17,41);
        assertEquals(expected, Primes.primeFactors(big));
    }

    @Test
    public void testIsPrimeLargePrimes() {
        assertTrue(Primes.isPrime(7919));
        assertFalse(Primes.isPrime(10000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrimeFactorsNegative() {
        Primes.primeFactors(-10);
    }
}
