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
    public void testSieveOfEratosthenesBasic() {
        assertEquals(Arrays.asList(2, 3, 5, 7), Primes.sieveOfEratosthenes(10));
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19), Primes.sieveOfEratosthenes(20));
        assertEquals(Collections.emptyList(), Primes.sieveOfEratosthenes(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSieveThrowsOnTooSmall() {
        Primes.sieveOfEratosthenes(1);
    }

    @Test(timeout = 2000)
    public void testLargePrimePerformance() {
        // Sieve finds all primes below 1_000_000 efficiently
        List<Integer> primes = Primes.sieveOfEratosthenes(1_000_000);
        assertEquals(78498, primes.size());
        assertEquals((Integer)999983, primes.get(primes.size() - 1));
    }

    @Test(timeout = 2000)
    public void testSumPrimesLarge() {
        // Sums primes less than 100_000; known value from OEIS
        assertEquals(454396537, Primes.sumPrimes(100_000));
    }

    @Test(timeout = 2000)
    public void testPrimeFactorsCompositeLarge() {
        // Test a large composite: 2^10 * 3^2 * 7
        int n = (1 << 10) * 9 * 7;
        List<Integer> factors = Primes.primeFactors(n);
        int[] freq = {0,0,0,0,0,0,0,0,0,0,0};
        for (int x : factors) freq[x] = freq[x]+1;
        assertEquals(10, freq[2]);
        assertEquals(2, freq[3]);
        assertEquals(1, freq[7]);
        assertEquals(13, factors.size());
    }
}
