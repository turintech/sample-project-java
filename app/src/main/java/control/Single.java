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
  public static int sumRange(int n) {
    if (n <= 0) {
      return 0;
    }
    // Overflow not guarded: possible for large n. Use long to avoid, or check with Math.addExact/multiplyExact for production.
    return n * (n - 1) / 2;
  }

  /**
   * Returns the sum of the first n natural numbers, using long to prevent integer overflow.
   * If n <= 0 then 0L is returned.
   * @param n Length of the range; must be non-negative.
   * @return long sum of the range [0, n), or 0 if n <= 0.
   */
  public static long sumRangeLong(int n) {
    if (n <= 0) {
      return 0L;
    }
    // Use long for intermediate result to avoid int overflow
    return ((long) n * (n - 1)) / 2;
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
   *   <li>If {@code arr} is {@code null}, throws an {@link IllegalArgumentException} with descriptive message.</li>
   * </ul>
   *
   * @param arr The int array (must not be null).
   * @return The largest element in the array, or Integer.MIN_VALUE if empty.
   * @throws IllegalArgumentException if arr is null.
   */
  public static int maxArray(int[] arr) {
    if (arr == null) {
      throw new IllegalArgumentException("Input array must not be null");
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
  public static int sumModulus(int n, int m) {
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }
    if (n <= 0) {
      return 0;
    }
    // Overflow not checked. For guaranteed correctness use BigInteger or checked arithmetic if needed.
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (i % m == 0) {
        sum += i;
      }
    }
    return sum;
  }

  /**
   * Returns the sum of all non-negative integers less than {@code n} that are multiples of {@code m}.
   * Uses long accumulator to avoid integer overflow and allow n up to Integer.MAX_VALUE.
   * @param n The exclusive upper bound (must be >= 0)
   * @param m The divisor for multiples (must not be 0)
   * @return The sum as a long value
   * @throws IllegalArgumentException if m is zero.
   */
  public static long sumModulusLong(int n, int m) {
    if (m == 0) {
      throw new IllegalArgumentException("Modulus 'm' cannot be zero.");
    }
    if (n <= 0) {
      return 0L;
    }
    long sum = 0L;
    for (int i = 0; i < n; i++) {
      if (i % m == 0) {
        sum += i;
      }
    }
    return sum;
  }

  /**
   * Returns the maximum value in the provided integer array using Java Streams API.
   * @param arr The int array, must not be null.
   * @return The largest element, or Integer.MIN_VALUE if array is empty.
   * @throws IllegalArgumentException if arr is null.
   */
  public static int maxArrayStream(int[] arr) {
    if (arr == null) {
      throw new IllegalArgumentException("Input array must not be null");
    }
    return java.util.Arrays.stream(arr).reduce(Integer.MIN_VALUE, Integer::max);
  }
}