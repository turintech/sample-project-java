package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SingleTest {
  @Test
  public void testSumRange() {
    // Removed redundant calls by parameterizing test cases for efficiency in case of expansion
    int[][] testCases = {
      {0, 0},
      {1, 0},
      {2, 1},
      {3, 3},
      {4, 6},
      {10, 45}
    };
    for (int[] tc : testCases) {
      assertEquals(tc[1], Single.sumRange(tc[0]));
    }
  }

  @Test
  public void testMaxArray() {
    // No memory improvement here, but for runtime, batch test cases
    assertEquals(0, Single.maxArray(new int[] { 0 }));
    assertEquals(5, Single.maxArray(new int[] { 1, 2, 3, 4, 5 }));
    assertEquals(1, Single.maxArray(new int[] { 1, 1, 1, 1, 0 }));
    assertEquals(0, Single.maxArray(new int[] { -1, -1, -1, -1, 0 }));
  }

  @Test
  public void testSumModulus() {
    // Condense parameters for slightly less object creation
    int[][] modCases = {
      {0, 1, 0},
      {1, 2, 0},
      {2, 2, 0},
      {3, 2, 2},
      {4, 2, 2},
      {10, 2, 20},
      {10, 3, 18},
      {10, 4, 12}
    };
    for (int[] mc : modCases) {
      assertEquals(mc[2], Single.sumModulus(mc[0], mc[1]));
    }
  }
}