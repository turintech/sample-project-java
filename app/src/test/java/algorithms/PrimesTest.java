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
        assertEquals(1060, Primes.sumPrimes(100));
        assertEquals(76127, Primes.sumPrimes(1000));
    }

    @Test
    public void testIsPrimeLarge() {
        assertTrue(Primes.isPrime(7919));
        assertFalse(Primes.isPrime(7920));
        assertTrue(Primes.isPrime(104729)); // 10000th prime
        assertFalse(Primes.isPrime(104730));
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
        assertEquals(Arrays.asList(13, 17), Primes.primeFactors(221));
        assertEquals(Arrays.asList(97), Primes.primeFactors(97));
    }

    @Test
    public void testPrimeFactorsLarge() {
        // 2^8 * 3^3 * 5^2 = 2^8 = 256, 3^3 = 27, 5^2 = 25, so n = 256*27*25 = 172800
        int n = 256 * 27 * 25;
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 8; ++i) expected.add(2);
        for (int i = 0; i < 3; ++i) expected.add(3);
        for (int i = 0; i < 2; ++i) expected.add(5);
        assertEquals(expected, Primes.primeFactors(n));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrimeFactorsEdge() {
        Primes.primeFactors(1);
    }
}
