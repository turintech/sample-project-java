package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DoubleTest {
  private static final int[] COUNT_PAIRS_CASE_1 = { 0 };
  private static final int[] COUNT_PAIRS_CASE_2 = { 1, 2, 3 };
  private static final int[] COUNT_PAIRS_CASE_3 = { 1, 1, 1 };
  private static final int[] COUNT_PAIRS_CASE_4 = { 1, 1, 2 };
  private static final int[] COUNT_PAIRS_CASE_5 = { 1, 1, 2, 2 };
  private static final int[] COUNT_PAIRS_CASE_6 = { 0, 0, 1, 1, 2, 2 };
  private static final int[] COUNT_PAIRS_CASE_7 = { 0, 0, 1, 1, 2, 2, 3 };

  private static final int[] COUNT_DUPLICATES_CASE_1_A = { 0 };
  private static final int[] COUNT_DUPLICATES_CASE_1_B = { 0 };
  private static final int[] COUNT_DUPLICATES_CASE_2_A = { 1, 2, 3 };
  private static final int[] COUNT_DUPLICATES_CASE_2_B = { 2, 3, 1 };
  private static final int[] COUNT_DUPLICATES_CASE_3_A = { 1, 1, 1 };
  private static final int[] COUNT_DUPLICATES_CASE_3_B = { 1, 2, 3 };
  private static final int[] COUNT_DUPLICATES_CASE_4_A = { 1, 1, 2 };
  private static final int[] COUNT_DUPLICATES_CASE_4_B = { 1, 2, 2 };
  private static final int[] COUNT_DUPLICATES_CASE_5_A = { 1, 1, 2, 2 };
  private static final int[] COUNT_DUPLICATES_CASE_5_B = { 1, 1, 2, 2 };

  private static final int[][] SUM_MATRIX_CASE_1 = { { 0 } };
  private static final int[][] SUM_MATRIX_CASE_2 = { { 0, 1 }, { 2, 3 } };
  private static final int[][] SUM_MATRIX_CASE_3 = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };

  @Test
  public void testSumSquare() {
    assertEquals(0, Double.sumSquare(1));
    assertEquals(1, Double.sumSquare(2));
    assertEquals(5, Double.sumSquare(3));
    assertEquals(285, Double.sumSquare(10));
  }

  @Test
  public void testSumTriangle() {
    assertEquals(0, Double.sumTriangle(1));
    assertEquals(1, Double.sumTriangle(2));
    assertEquals(4, Double.sumTriangle(3));
    assertEquals(165, Double.sumTriangle(10));
  }

  @Test
  public void testCountPairs() {
    assertEquals(0, Double.countPairs(COUNT_PAIRS_CASE_1));
    assertEquals(0, Double.countPairs(COUNT_PAIRS_CASE_2));
    assertEquals(0, Double.countPairs(COUNT_PAIRS_CASE_3));
    assertEquals(1, Double.countPairs(COUNT_PAIRS_CASE_4));
    assertEquals(2, Double.countPairs(COUNT_PAIRS_CASE_5));
    assertEquals(3, Double.countPairs(COUNT_PAIRS_CASE_6));
    assertEquals(3, Double.countPairs(COUNT_PAIRS_CASE_7));
  }

  @Test
  public void testCountDuplicates() {
    assertEquals(1, Double.countDuplicates(COUNT_DUPLICATES_CASE_1_A, COUNT_DUPLICATES_CASE_1_B));
    assertEquals(
        0, Double.countDuplicates(COUNT_DUPLICATES_CASE_2_A, COUNT_DUPLICATES_CASE_2_B));
    assertEquals(
        1, Double.countDuplicates(COUNT_DUPLICATES_CASE_3_A, COUNT_DUPLICATES_CASE_3_B));
    assertEquals(
        2, Double.countDuplicates(COUNT_DUPLICATES_CASE_4_A, COUNT_DUPLICATES_CASE_4_B));
    assertEquals(4, Double.countDuplicates(COUNT_DUPLICATES_CASE_5_A,
        COUNT_DUPLICATES_CASE_5_B));
  }

  @Test
  public void testSumMatrix() {
    assertEquals(0, Double.sumMatrix(SUM_MATRIX_CASE_1));
    assertEquals(6, Double.sumMatrix(SUM_MATRIX_CASE_2));
    assertEquals(
        36, Double.sumMatrix(SUM_MATRIX_CASE_3));
  }
}