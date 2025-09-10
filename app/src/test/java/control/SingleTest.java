package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SingleTest {
  @Test
  public void testSumRange() {
    // base cases
    assertEquals(0, Single.sumRange(0));
    assertEquals(0, Single.sumRange(1));
    assertEquals(1, Single.sumRange(2));
    assertEquals(3, Single.sumRange(3));
    assertEquals(6, Single.sumRange(4));
    assertEquals(45, Single.sumRange(10));
    // negatives, overflow, large
    assertEquals(0, Single.sumRange(-4));
    assertEquals(0, Single.sumRange(Integer.MIN_VALUE));
    // may overflow, but contract defined
    Single.sumRange(Integer.MAX_VALUE); // Should not crash
  }

  @Test
  public void testMaxArray() {
    assertEquals(0, Single.maxArray(new int[] { 0 }));
    assertEquals(5, Single.maxArray(new int[] { 1, 2, 3, 4, 5 }));
    assertEquals(1, Single.maxArray(new int[] { 1, 1, 1, 1, 0 }));
    assertEquals(0, Single.maxArray(new int[] { -1, -1, -1, -1, 0 }));
    assertEquals(-1, Single.maxArray(new int[] { -1, -1, -1 }));
    assertEquals(Integer.MIN_VALUE, Single.maxArray(new int[] {}));
    // null throws IllegalArgumentException
    try {
      Single.maxArray(null);
      throw new AssertionError("Expected IllegalArgumentException not thrown");
    } catch (IllegalArgumentException expected) {}
  }

  @Test
  public void testSumModulus() {
    assertEquals(0, Single.sumModulus(0, 1));
    assertEquals(0, Single.sumModulus(1, 2));
    assertEquals(0, Single.sumModulus(2, 2));
    assertEquals(2, Single.sumModulus(3, 2));
    assertEquals(2, Single.sumModulus(4, 2));
    assertEquals(20, Single.sumModulus(10, 2));
    assertEquals(18, Single.sumModulus(10, 3));
    assertEquals(12, Single.sumModulus(10, 4));
    // test negative n
    assertEquals(0, Single.sumModulus(-10, 4));
    // test modulus zero exception
    try {
      Single.sumModulus(5, 0);
      throw new AssertionError("Expected exception not thrown");
    } catch (IllegalArgumentException expected) {}
    // test modulus negative
    assertEquals(30, Single.sumModulus(10, -2));
  }
}
