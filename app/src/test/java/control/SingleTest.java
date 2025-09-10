package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SingleTest {
  @Test
  public void testSumRange() {
    // Standard cases
    assertEquals(0, Single.sumRange(0));
    assertEquals(0, Single.sumRange(1));
    assertEquals(1, Single.sumRange(2));
    assertEquals(3, Single.sumRange(3));
    assertEquals(6, Single.sumRange(4));
    assertEquals(45, Single.sumRange(10));

    // Negative inputs: must return 0
    assertEquals(0, Single.sumRange(-1));
    assertEquals(0, Single.sumRange(-100));

    // Large value (overflow expected: Integer.MAX_VALUE will wrap)
    int n = 65536; // (n * (n-1))/2 > Integer.MAX_VALUE, triggers overflow
    int sumJava = Single.sumRange(n); // Documented to wrap per Java semantics
    int manual = n * (n - 1) / 2;
    assertEquals(manual, sumJava);
  }

  @Test
  public void testSumRangeLong() {
    // Standard cases
    assertEquals(0L, Single.sumRangeLong(0));
    assertEquals(0L, Single.sumRangeLong(1));
    assertEquals(1L, Single.sumRangeLong(2));
    assertEquals(3L, Single.sumRangeLong(3));
    assertEquals(6L, Single.sumRangeLong(4));
    assertEquals(45L, Single.sumRangeLong(10));
    assertEquals(49995000L, Single.sumRangeLong(10000));

    // Negative inputs
    assertEquals(0L, Single.sumRangeLong(-5));

    // Large n
    int n = Integer.MAX_VALUE;
    long expected = ((long) n * (n - 1)) / 2;
    assertEquals(expected, Single.sumRangeLong(n));
  }

  @Test
  public void testMaxArray() {
    // Single element
    assertEquals(0, Single.maxArray(new int[] { 0 }));
    // All positive
    assertEquals(5, Single.maxArray(new int[] { 1, 2, 3, 4, 5 }));
    // All same
    assertEquals(1, Single.maxArray(new int[] { 1, 1, 1, 1, 0 }));
    // Contains negative
    assertEquals(0, Single.maxArray(new int[] { -1, -1, -1, -1, 0 }));
    // All negative
    assertEquals(-1, Single.maxArray(new int[] { -1, -10, -30 }));
    // Empty array: edge contract
    assertEquals(Integer.MIN_VALUE, Single.maxArray(new int[] {}));
    // Null array: should throw IllegalArgumentException
    try {
      Single.maxArray(null);
      throw new AssertionError("maxArray(null) should throw IllegalArgumentException");
    } catch (IllegalArgumentException expected) {}
  }

  @Test
  public void testMaxArrayStream() {
    // Single element
    assertEquals(0, Single.maxArrayStream(new int[] { 0 }));
    // Multiple elements
    assertEquals(7, Single.maxArrayStream(new int[] { 1, 2, 3, 7, 4, 3 }));
    // All negative
    assertEquals(-2, Single.maxArrayStream(new int[] { -100, -2, -15 }));
    // Empty: should return Integer.MIN_VALUE
    assertEquals(Integer.MIN_VALUE, Single.maxArrayStream(new int[] {}));
    // Null array: should throw IllegalArgumentException
    try {
      Single.maxArrayStream(null);
      throw new AssertionError("maxArrayStream(null) should throw IllegalArgumentException");
    } catch (IllegalArgumentException expected) {}
  }

  @Test
  public void testSumModulus() {
    // Standard case
    assertEquals(0, Single.sumModulus(0, 1));
    assertEquals(0, Single.sumModulus(1, 2));
    assertEquals(0, Single.sumModulus(2, 2));
    assertEquals(2, Single.sumModulus(3, 2));
    assertEquals(2, Single.sumModulus(4, 2));
    assertEquals(20, Single.sumModulus(10, 2));
    assertEquals(18, Single.sumModulus(10, 3));
    assertEquals(12, Single.sumModulus(10, 4));
    // n <= 0
    assertEquals(0, Single.sumModulus(-1, 3));
    assertEquals(0, Single.sumModulus(-120, 5));
    // m negative
    assertEquals(20, Single.sumModulus(10, -2)); // Negative modulus is allowed
    // Large n (overflow test: result will wrap)
    int sum = Single.sumModulus(65535, 2);
    int manual = 0;
    for (int i = 0; i < 65535; i++) {
      if (i % 2 == 0) manual += i;
    }
    assertEquals(manual, sum);
    // m=0 should throw exception
    try {
      Single.sumModulus(10, 0);
      throw new AssertionError("sumModulus(10, 0) should throw IllegalArgumentException");
    } catch (IllegalArgumentException expected) {}
  }

  @Test
  public void testSumModulusLong() {
    // Standard cases
    assertEquals(0L, Single.sumModulusLong(0, 2));
    assertEquals(0L, Single.sumModulusLong(1, 2));
    assertEquals(0L, Single.sumModulusLong(2, 2));
    assertEquals(2L, Single.sumModulusLong(3, 2));
    assertEquals(20L, Single.sumModulusLong(10, 2));
    assertEquals(18L, Single.sumModulusLong(10, 3));

    // Large n
    int n = 100_000;
    int m = 8;
    long sum = Single.sumModulusLong(n, m);
    long manual = 0;
    for (int i = 0; i < n; i++) {
      if (i % m == 0) manual += i;
    }
    assertEquals(manual, sum);

    // Extreme large n: should work, no overflow
    n = Integer.MAX_VALUE;
    m = 999_983;
    // For these, just ensure no exception and value is non-negative
    long result = Single.sumModulusLong(n, m);
    assertEquals(true, result >= 0);

    // Negative divisors
    assertEquals(20L, Single.sumModulusLong(10, -2));
    // Negative n
    assertEquals(0L, Single.sumModulusLong(-10, 2));
    // m=0 should throw exception
    try {
      Single.sumModulusLong(10, 0);
      throw new AssertionError("sumModulusLong(10, 0) should throw IllegalArgumentException");
    } catch (IllegalArgumentException expected) {}
  }
}
