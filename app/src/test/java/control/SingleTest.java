package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SingleTest {
  @Test
  public void testSumRange() {
    // Standard
    assertEquals(0, Single.sumRange(0));
    assertEquals(0, Single.sumRange(1));
    assertEquals(1, Single.sumRange(2));
    assertEquals(3, Single.sumRange(3));
    assertEquals(6, Single.sumRange(4));
    assertEquals(45, Single.sumRange(10));
    // Negative n
    assertEquals(0, Single.sumRange(-1));
    assertEquals(0, Single.sumRange(-100));
  }

  @Test
  public void testMaxArray() {
    // Standard
    assertEquals(0, Single.maxArray(new int[] { 0 }));
    assertEquals(5, Single.maxArray(new int[] { 1, 2, 3, 4, 5 }));
    assertEquals(1, Single.maxArray(new int[] { 1, 1, 1, 1, 0 }));
    assertEquals(0, Single.maxArray(new int[] { -1, -1, -1, -1, 0 }));
    // Only negatives
    assertEquals(-1, Single.maxArray(new int[] { -1, -3, -5 }));
    // Large negative and positive
    assertEquals(10, Single.maxArray(new int[] { -10, 10 }));
    // Empty array: defined behavior is Integer.MIN_VALUE
    assertEquals(Integer.MIN_VALUE, Single.maxArray(new int[] {}));
  }

  @Test
  public void testSumModulus() {
    // Standard positive values
    assertEquals(0, Single.sumModulus(0, 1));
    assertEquals(0, Single.sumModulus(1, 2));
    assertEquals(0, Single.sumModulus(2, 2));
    assertEquals(2, Single.sumModulus(3, 2));
    assertEquals(2, Single.sumModulus(4, 2));
    assertEquals(20, Single.sumModulus(10, 2));
    assertEquals(18, Single.sumModulus(10, 3));
    assertEquals(12, Single.sumModulus(10, 4));
    // Negative n (should produce 0, only non-negatives are summed)
    assertEquals(0, Single.sumModulus(-10, 2));
    // Negative m (valid, negative divisor)
    assertEquals(20, Single.sumModulus(10, -2));
    // m==1 (all numbers: 0 to n-1)
    assertEquals(45, Single.sumModulus(10, 1));
  }

  @Test
  public void testSumModulus_throwsExceptionOnZeroModulus() {
    try {
      Single.sumModulus(10, 0);
      throw new AssertionError("Expected IllegalArgumentException for m==0");
    } catch (IllegalArgumentException e) {
      // expected
    }
  }
}
