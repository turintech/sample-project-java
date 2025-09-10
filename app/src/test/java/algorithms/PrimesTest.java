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
    public void testIsPrimeAdditional() {
        int[] primes = {11, 13, 17, 19, 23, 7919};
        for (int p : primes) {
            assertTrue(Primes.isPrime(p));
        }
        int[] nonPrimes = {15, 20, 25, 27, 1001};
        for (int n : nonPrimes) {
            assertFalse(Primes.isPrime(n));
        }
        // Large edge case
        assertTrue(Primes.isPrime(104729)); // 10000th prime
    }
    @Test
    public void testSumPrimes() {
        assertEquals(0, Primes.sumPrimes(2));
        assertEquals(2, Primes.sumPrimes(3));
        assertEquals(5, Primes.sumPrimes(5));
        assertEquals(17, Primes.sumPrimes(10));
        assertEquals(76127, Primes.sumPrimes(1000)); // larger n
    }

    @Test
    public void testSumPrimesInputZeroOne() {
        assertEquals(0, Primes.sumPrimes(0));
        assertEquals(0, Primes.sumPrimes(1));
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

    @Test
    public void testPrimeFactorsAdditional() {
        assertEquals(Arrays.asList(2, 2, 5, 5), Primes.primeFactors(100));
        assertEquals(Arrays.asList(3, 3, 3, 37), Primes.primeFactors(999));
        assertEquals(Collections.singletonList(104729), Primes.primeFactors(104729)); // prime itself
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13), Primes.primeFactors(30030));
    }

    @Test
    public void testPrimeFactorsLargePower() {
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 10; ++i) expected.add(2);
        assertEquals(expected, Primes.primeFactors(1024));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPrimeFactorsEdge() {
        Primes.primeFactors(1);
    }
}
