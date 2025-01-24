package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test class for the Double utility class which contains methods for various numerical computations.
 */
public class DoubleTest {
  /**
   * Tests the sumSquare method which calculates the sum of squares up to n-1.
   * For example, sumSquare(3) = 0^2 + 1^2 + 2^2 = 5
   */
  @Test
  public void testSumSquare() {
    assertEquals(0, Double.sumSquare(1));
    assertEquals(1, Double.sumSquare(2));
    assertEquals(5, Double.sumSquare(3));
    assertEquals(285, Double.sumSquare(10));
  }

  /**
   * Tests the sumTriangle method which calculates the sum of products i*j where
   * i ranges from 0 to n-1 and j ranges from i+1 to n-1.
   */
  @Test
  public void testSumTriangle() {
    assertEquals(0, Double.sumTriangle(1));
    assertEquals(1, Double.sumTriangle(2));
    assertEquals(4, Double.sumTriangle(3));
    assertEquals(165, Double.sumTriangle(10));
  }

  /**
   * Tests the countPairs method which counts the number of adjacent pairs
   * of equal elements in an array.
   */
  @Test
  public void testCountPairs() {
    assertEquals(0, Double.countPairs(new int[] { 0 }));
    assertEquals(0, Double.countPairs(new int[] { 1, 2, 3 }));
    assertEquals(0, Double.countPairs(new int[] { 1, 1, 1 }));
    assertEquals(1, Double.countPairs(new int[] { 1, 1, 2 }));
    assertEquals(2, Double.countPairs(new int[] { 1, 1, 2, 2 }));
    assertEquals(3, Double.countPairs(new int[] { 0, 0, 1, 1, 2, 2 }));
    assertEquals(3, Double.countPairs(new int[] { 0, 0, 1, 1, 2, 2, 3 }));
  }

  /**
   * Tests the countDuplicates method which counts the number of positions
   * where two arrays have the same value.
   */
  @Test
  public void testCountDuplicates() {
    assertEquals(1, Double.countDuplicates(new int[] { 0 }, new int[] { 0 }));
    assertEquals(
        0, Double.countDuplicates(new int[] { 1, 2, 3 }, new int[] { 2, 3, 1 }));
    assertEquals(
        1, Double.countDuplicates(new int[] { 1, 1, 1 }, new int[] { 1, 2, 3 }));
    assertEquals(
        2, Double.countDuplicates(new int[] { 1, 1, 2 }, new int[] { 1, 2, 2 }));
    assertEquals(4, Double.countDuplicates(new int[] { 1, 1, 2, 2 },
        new int[] { 1, 1, 2, 2 }));
  }

  /**
   * Tests the sumMatrix method which calculates the sum of all elements
   * in a square matrix.
   */
  @Test
  public void testSumMatrix() {
    assertEquals(0, Double.sumMatrix(new int[][] { { 0 } }));
    assertEquals(6, Double.sumMatrix(new int[][] { { 0, 1 }, { 2, 3 } }));
    assertEquals(
        36, Double.sumMatrix(new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } }));
  }
}