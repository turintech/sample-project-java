package control;

// The 'java.util.Vector' import is removed as it is no longer used after refactoring
// the 'sumModulus' method. This improves clarity and reduces unnecessary dependencies.

public class Single {
  /**
   * Returns the sum of the first n natural numbers (i.e., numbers in range [0, n)).
   * Uses the efficient arithmetic progression formula: n*(n-1)/2.
   *
   * <b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code n <= 0} then {@code 0} is returned.</li>
   *   <li>If calculation overflows, result is the wrapped int per Java semantics (not checked).</li>
   * </ul>
   *
   * @param n Length of the range; must be non-negative for the mathematical meaning. Negative values yield 0.
   * @return The sum of the range [0, n), or 0 if n &lt;= 0.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Summation#Properties">Summation Properties (Wikipedia)</a>
   */
  /**
   * Returns the sum of the first n natural numbers (i.e., numbers in range [0, n)).
   * Uses the efficient arithmetic progression formula: n*(n-1)/2. This method computes the result
   * using intermediate long arithmetic to avoid overflow in most cases, and returns the result as int (may still overflow).
   * 
   * <b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code n <= 0} then {@code 0} is returned.</li>
   *   <li>If calculation overflows int, result is the wrapped int per Java semantics (not checked).</li>
   * </ul>
   *
   * @param n Length of the range; must be non-negative for the mathematical meaning. Negative values yield 0.
   * @return The sum of the range [0, n), or 0 if n <= 0 (as int, may overflow).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Summation#Properties">Summation Properties (Wikipedia)</a>
   */
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0;
    }
    // Overflow is avoided in multiplication using long, but returned as int (may still overflow if sum > Integer.MAX_VALUE).
    long sum = (long) n * (n - 1) / 2;
    return (int) sum;
  }

  /**
   * Returns the sum of the first n natural numbers (i.e., numbers in range [0, n)) as a long value, avoiding intermediate overflow.
   *
   * <b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code n <= 0} then {@code 0L} is returned.</li>
   * </ul>
   *
   * @param n Length of the range; must be non-negative for the mathematical meaning. Negative values yield 0.
   * @return The sum of the range [0, n), or 0 if n <= 0, as a long.
   */
  public static long safeSumRange(int n) {
    if (n <= 0) {
      return 0L;
    }
    return (long) n * (n - 1) / 2;
  }

  /**
   * Returns the maximum value in the provided integer array.
   *
   * <b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code arr} is empty, returns {@link Integer#MIN_VALUE}.</li>
   *   <li>If array is {@code null}, method throws a NullPointerException (same as original contract).</li>
   * </ul>
   *
   * @param arr The int array (must not be null).
   * @return The largest element in the array, or Integer.MIN_VALUE if empty.
   */
  /**
   * Returns the maximum value in the provided integer array.
   *
   * <b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code arr} is empty, returns {@link Integer#MIN_VALUE}.</li>
   *   <li>If array is {@code null}, method throws a NullPointerException (same as original contract).</li>
   * </ul>
   * <b>Performance:</b> O(n), with early break if maximal int is found.
   *
   * @param arr The int array (must not be null).
   * @return The largest element in the array, or Integer.MIN_VALUE if empty.
   */
  public static int maxArray(int[] arr) {
    if (arr.length == 0) {
      return Integer.MIN_VALUE;
    }
    int max = Integer.MIN_VALUE;
    for (int i : arr) {
      if (i > max) {
        max = i;
        if (max == Integer.MAX_VALUE) {
          break; // Early exit, cannot be larger
        }
      }
    }
    return max;
  }

  /**
   * Returns the sum of all non-negative integers less than {@code n} that are multiples of {@code m}.
   *
   * <b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code m == 0}, throws {@link IllegalArgumentException} (API guarantee).</li>
   *   <li>If {@code n <= 0}, returns 0 (empty range).</li>
   *   <li>Overflow is not checked, so large n or m may produce incorrect negative results (Java semantics).</li>
   * </ul>
   *
   * @param n The exclusive upper bound (must be integer).
   * @param m The divisor for multiples (must not be 0).
   * @return The sum of values in {@code [0, n)} divisible by {@code m}.
   * @throws IllegalArgumentException if m is zero.
   */
  /**
   * Returns the sum of all non-negative integers less than {@code n} that are multiples of {@code m}.
   * Uses efficient arithmetic progression if possible to improve performance.
   *
   * <b>Boundary/Edge Cases:</b>
   * <ul>
   *   <li>If {@code m == 0}, throws {@link IllegalArgumentException} (API guarantee).</li>
   *   <li>If {@code n <= 0}, returns 0 (empty range).</li>
   *   <li>If m < 0, Java modulus semantics are followed; behavior is symmetric around zero.</li>
   *   <li>Overflow is not checked, so large n or m may produce incorrect negative results (Java semantics).</li>
   * </ul>
   *
   * @param n The exclusive upper bound (must be integer).
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
    // Normalize m to positive for sum formula, preserve Java mod semantics for negatives.
    int absM = Math.abs(m);
    int maxK = (n - 1) / absM;
    // Sum multiples of |m| < n efficiently: sum = m * (k*(k+1)/2) where k = number of terms - 1
    // For negative m, multiples in [0, n) are same as m positive (symmetry of multiples)
    long sum = (long) absM * maxK * (maxK + 1) / 2;
    return (int) sum;
  }
}