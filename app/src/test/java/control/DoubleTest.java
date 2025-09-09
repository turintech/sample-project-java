package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DoubleTest {
  @Test
  public void testSumSquare() {
    // Edge and negative cases
    assertEquals(0, Double.sumSquare(0));
    assertEquals(0, Double.sumSquare(-5));
    assertEquals(1, Double.sumSquare(1));
    // Core cases
    assertEquals(1, Double.sumSquare(2));
    assertEquals(5, Double.sumSquare(3));
    assertEquals(285, Double.sumSquare(10));
  }

  @Test
  public void testSumTriangle() {
    // Edge and negative cases
    assertEquals(0, Double.sumTriangle(0));
    assertEquals(0, Double.sumTriangle(-2));
    assertEquals(1, Double.sumTriangle(1));
    // Core cases
    assertEquals(4, Double.sumTriangle(2));
    assertEquals(10, Double.sumTriangle(3));
    assertEquals(220, Double.sumTriangle(10));
  }

  @Test
  public void testCountPairs() {
    // Edge: null and empty arrays
    assertEquals(0, Double.countPairs(null));
    assertEquals(0, Double.countPairs(new int[] {}));
    assertEquals(0, Double.countPairs(new int[] { 0 }));
    assertEquals(0, Double.countPairs(new int[] { 1, 2, 3 }));
    assertEquals(0, Double.countPairs(new int[] { 1, 1, 1 }));
    assertEquals(1, Double.countPairs(new int[] { 1, 1, 2 }));
    assertEquals(2, Double.countPairs(new int[] { 1, 1, 2, 2 }));
    assertEquals(3, Double.countPairs(new int[] { 0, 0, 1, 1, 2, 2 }));
    assertEquals(3, Double.countPairs(new int[] { 0, 0, 1, 1, 2, 2, 3 }));
  }

  @Test
  public void testCountDuplicates() {
    // Edge: null, empty, length mismatch
    assertEquals(0, Double.countDuplicates(null, null));
    assertEquals(0, Double.countDuplicates(new int[] {}, new int[] {}));
    assertEquals(0, Double.countDuplicates(new int[] { 1, 2 }, null));
    assertEquals(0, Double.countDuplicates(null, new int[] { 1, 2 }));
    assertEquals(0, Double.countDuplicates(new int[] { 1 }, new int[] { 2 }));
    assertEquals(1, Double.countDuplicates(new int[] { 0 }, new int[] { 0 }));
    assertEquals(0, Double.countDuplicates(new int[] { 1, 2, 3 }, new int[] { 2, 3, 1 }));
    assertEquals(1, Double.countDuplicates(new int[] { 1, 1, 1 }, new int[] { 1, 2, 3 }));
    assertEquals(2, Double.countDuplicates(new int[] { 1, 1, 2 }, new int[] { 1, 2, 2 }));
    assertEquals(4, Double.countDuplicates(new int[] { 1, 1, 2, 2 }, new int[] { 1, 1, 2, 2 }));
  }

  @Test
  public void testSumMatrix() {
    // Edge: null, empty arrays, and ragged
    assertEquals(0, Double.sumMatrix(null));
    assertEquals(0, Double.sumMatrix(new int[][]{}));
    assertEquals(0, Double.sumMatrix(new int[][]{null, null}));
    assertEquals(0, Double.sumMatrix(new int[][]{{}}));
    assertEquals(0, Double.sumMatrix(new int[][]{{}, {}, {}}));
    assertEquals(0, Double.sumMatrix(new int[][]{{0}}));
    assertEquals(6, Double.sumMatrix(new int[][]{{0,1},{2,3}}));
    assertEquals(36, Double.sumMatrix(new int[][]{{0,1,2},{3,4,5},{6,7,8}}));
    assertEquals(6, Double.sumMatrix(new int[][]{{1,2,3}, null, {}, {}}));
  }
}
