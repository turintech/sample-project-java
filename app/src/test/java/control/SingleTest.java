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

    // Boundary: Integer.MAX_VALUE
    assertEquals(-1073741824, Single.sumRange(65536)); // Known Java wraparound
    // Overflow fuzzing: try a range of large values to assert correct Java wrap semantics
    for (int val : new int[] {46341, 46340, 70000, Integer.MAX_VALUE, Integer.MIN_VALUE, -123456789 }) {
      try {
        int expected = val * (val - 1) / 2;
        assertEquals(expected, Single.sumRange(val));
      } catch (Throwable t) {
        // We test for exceptions from extreme overflows, like OutOfMemoryError (should not occur)
        // Fail if exception occurs unexpectedly
        throw new AssertionError("Exception for n=" + val + ": " + t, t);
      }
    }
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

    // Fuzz: randomized large/small arrays, with boundary integers
    int[] boundaries = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0, -100, 100, 42};
    assertEquals(Integer.MAX_VALUE, Single.maxArray(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}));
    for (int size = 1; size <= 500; size *= 10) {
      int[] arr = new int[size];
      for (int i = 0; i < size; i++) arr[i] = i - 250; // Center at -250
      int expected = size > 0 ? size - 251 : Integer.MIN_VALUE;
      assertEquals(expected, Single.maxArray(arr));
    }
    // Check all-boundary
    int[] huge = new int[0x100];
    java.util.Arrays.fill(huge, Integer.MIN_VALUE);
    huge[100] = Integer.MAX_VALUE;
    assertEquals(Integer.MAX_VALUE, Single.maxArray(huge));
  }

  @Test
  public void testSumModulus() {
    // Standard case and low bounds
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
    int val = Single.sumModulus(100, -10);
    int manualSum = java.util.stream.IntStream.range(0, 100).filter(i -> i % -10 == 0).sum();
    assertEquals(manualSum, val);

    // Large n (overflow test: result will wrap)
    int sum = Single.sumModulus(65535, 2);
    int manual = 0;
    for (int i = 0; i < 65535; i++) {
      if (i % 2 == 0) manual += i;
    }
    assertEquals(manual, sum);

    // Fuzz/randomized modulus
    for (int modulus : new int[] {1, 2, 3, 5, 7, 11, 17, Integer.MAX_VALUE, -19}) {
      for (int nval : new int[] {0, 1, 5, 10, 100, 1000, 10000}) {
        int expected = java.util.stream.IntStream.range(0, nval).filter(i -> modulus != 0 && i % modulus == 0).sum();
        if (modulus != 0)
          assertEquals(expected, Single.sumModulus(nval, modulus));
      }
    }
    // m=0 should throw exception
    try {
      Single.sumModulus(10, 0);
      throw new AssertionError("sumModulus(10, 0) should throw IllegalArgumentException");
    } catch (IllegalArgumentException expected) {}
    // Large/fuzz: random fuzzing for overflow semantics
    int[] testN = {100, 1000, 25000, 46341, 65536, Integer.MAX_VALUE};
    int[] testM = {1, 2, 3, 11, 1000, Integer.MAX_VALUE, -777};
    for (int nn : testN) {
      for (int mm : testM) {
        if (mm != 0) {
          int manualFuzz = java.util.stream.IntStream.range(0, nn).filter(i -> i % mm == 0).sum();
          assertEquals(manualFuzz, Single.sumModulus(nn, mm));
        }
      }
    }
  }
}
