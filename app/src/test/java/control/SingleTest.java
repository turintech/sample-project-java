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
    int manual = (int) ((long) n * (n - 1) / 2);
    assertEquals(manual, sumJava);

    // Test safeSumRange (long version avoids overflow)
    long manualLong = (long) n * (n - 1) / 2;
    assertEquals(manualLong, Single.safeSumRange(n));
    assertEquals(0L, Single.safeSumRange(0));
    assertEquals(0L, Single.safeSumRange(-100));
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
    // Null array: should throw NullPointerException
    try {
      Single.maxArray(null);
      throw new AssertionError("maxArray(null) should throw NullPointerException");
    } catch (NullPointerException expected) {}
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

    // Compare brute force and algorithm for various combinations (up to n=100)
    for (int m = -5; m <= 5; m++) {
      if (m == 0) continue;
      for (int n = 0; n <= 100; n++) {
        int expected = 0;
        for (int i = 0; i < n; i++) {
          if (m > 0) { if (i % m == 0) expected += i; }
          else if (m < 0) { if (i % -m == 0) expected += i; }
        }
        assertEquals(expected, Single.sumModulus(n, m), "Failed for n="+n+", m="+m);
      }
    }

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
}
