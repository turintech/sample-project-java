package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SingleTest {
  @Test
  public void testSumRange() {
    // Edge and negative cases
    assertEquals(0, Single.sumRange(0));
    assertEquals(0, Single.sumRange(-9));
    assertEquals(0, Single.sumRange(1));
    // Core cases
    assertEquals(1, Single.sumRange(2));
    assertEquals(3, Single.sumRange(3));
    assertEquals(6, Single.sumRange(4));
    assertEquals(45, Single.sumRange(10));
  }

  @Test
  public void testMaxArray() {
    // Edge: empty array and null array
    assertEquals(Integer.MIN_VALUE, Single.maxArray(null));
    assertEquals(Integer.MIN_VALUE, Single.maxArray(new int[]{}));
    assertEquals(0, Single.maxArray(new int[] { 0 }));
    assertEquals(5, Single.maxArray(new int[] { 1, 2, 3, 4, 5 }));
    assertEquals(1, Single.maxArray(new int[] { 1, 1, 1, 1, 0 }));
    assertEquals(0, Single.maxArray(new int[] { -1, -1, -1, -1, 0 }));
    assertEquals(-1, Single.maxArray(new int[] { -1, -2, -3, -8 }));
  }

  @Test
  public void testSumModulus() {
    // Edge: zero, negatives, throws, large input
    assertEquals(0, Single.sumModulus(0, 1));
    assertEquals(0, Single.sumModulus(1, 2));
    assertEquals(0, Single.sumModulus(2, 2));
    assertEquals(2, Single.sumModulus(3, 2));
    assertEquals(2, Single.sumModulus(4, 2));
    assertEquals(20, Single.sumModulus(10, 2));
    assertEquals(18, Single.sumModulus(10, 3));
    assertEquals(12, Single.sumModulus(10, 4));
    assertEquals(0, Single.sumModulus(-50, 3));
    assertEquals(0, Single.sumModulus(10, -2));
    // Throws on modulus 0
    assertThrows(IllegalArgumentException.class, () -> Single.sumModulus(10, 0));
  }
}
