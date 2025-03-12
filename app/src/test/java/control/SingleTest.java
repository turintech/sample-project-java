package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SingleTest {
  private static final int[] SINGLE_ELEMENT_ARRAY = { 0 };
  private static final int[] INCREASING_ARRAY = { 1, 2, 3, 4, 5 };
  private static final int[] REPEATING_ONE_ARRAY = { 1, 1, 1, 1, 0 };
  private static final int[] NEGATIVE_ARRAY = { -1, -1, -1, -1, 0 };

  @Test
  public void testSumRange() {
    assertEquals(0, Single.sumRange(0));
    assertEquals(0, Single.sumRange(1));
    assertEquals(1, Single.sumRange(2));
    assertEquals(3, Single.sumRange(3));
    assertEquals(6, Single.sumRange(4));
    assertEquals(45, Single.sumRange(10));
  }

  @Test
  public void testMaxArray() {
    assertEquals(0, Single.maxArray(SINGLE_ELEMENT_ARRAY));
    assertEquals(5, Single.maxArray(INCREASING_ARRAY));
    assertEquals(1, Single.maxArray(REPEATING_ONE_ARRAY));
    assertEquals(0, Single.maxArray(NEGATIVE_ARRAY));
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
  }
}