package control;

// The 'java.util.Vector' import is removed as it is no longer used after refactoring
// the 'sumModulus' method. This improves clarity and reduces unnecessary dependencies.

public class Single {
  /**
   * Returns the sum of the first n natural numbers (i.e., numbers in range [0, n)).
   * Uses the efficient arithmetic progression formula: n*(n-1)/2.
   *
   * <p><b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code n &lt;= 0} then {@code 0} is returned.</li>
   *   <li>If calculation overflows, result is the wrapped int per Java semantics (not checked).</li>
   * </ul>
   *
   * <b>API Warning:</b> This method does not guard against integer overflow for large n. Overflow will wrap around per Java arithmetic semantics. For safe calculation with large n, consider using {@code long} or checked arithmetic like {@code Math.addExact} / {@code Math.multiplyExact}.
   *
   * @param n Length of the range. Negative values yield 0.
   * @return The sum of the range [0, n), or 0 if n &lt;= 0.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Summation#Properties">Summation Properties (Wikipedia)</a>
   */
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0;
    }
    // Overflow not guarded: possible for large n. For safety use Math.addExact/multiplyExact or long if overflow is a concern.
    return n * (n - 1) / 2;
  }

  /**
   * Returns the maximum value in the provided integer array.
   *
   * <p><b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code arr} is empty, returns {@link Integer#MIN_VALUE}.</li>
   *   <li>If {@code arr} is {@code null}, a {@link NullPointerException} is thrown.</li>
   * </ul>
   *
   * <b>API Warning:</b> Passing {@code null} will throw a {@link NullPointerException}.
   *
   * @param arr The int array (must not be null).
   * @return The largest element in the array, or Integer.MIN_VALUE if empty.
   */
  public static int maxArray(int[] arr) {
    if (arr == null) {
      throw new NullPointerException("Input array must not be null");
    }
    if (arr.length == 0) {
      return Integer.MIN_VALUE;
    }
    int max = Integer.MIN_VALUE;
    for (int i : arr) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }

  /**
   * Returns the sum of all non-negative integers less than {@code n} that are multiples of {@code m}.
   *
   * <p><b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code m == 0}, throws {@link IllegalArgumentException} (API guarantee).</li>
   *   <li>If {@code n <= 0}, returns 0 (empty range).</li>
   *   <li>Overflow is not checked; for large n and m, result may be negative due to wrap-around (per Java integer semantics).</li>
   * </ul>
   *
   * <b>API Warning:</b> No overflow protection: for large n and m, sum may wrap and become negative. Use BigInteger or perform safe checks for numeric safety in critical code.
   *
   * @param n The exclusive upper bound (must be integer; negative yields 0).
   * @param m The divisor for multiples (must not be 0).
   * @return The sum of values in {@code [0, n)} divisible by {@code m}.
   * @throws IllegalArgumentException if m is zero.
   */
  public static int sumModulus(int n, int m) {
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }
    if (n <= 0) {
      return 0;
    }
    // Alternative Java 8+ solution using IntStream for clarity
    // Not necessarily more performant, but succinct and expressive.
    return java.util.stream.IntStream.range(0, n)
            .filter(i -> i % m == 0)
            .reduce(0, Integer::sum);
  }
}