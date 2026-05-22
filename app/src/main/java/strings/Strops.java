package strings;

public class Strops {
  /**
   * Reverses a string.
   *
   * @param str The string to reverse. Must not be null.
   * @return The reversed string.
   * @throws IllegalArgumentException if {@code str} is null.
   */
  public String reverse(String str) {
    if (str == null) {
      throw new IllegalArgumentException("Input string must not be null");
    }
    StringBuilder reversed = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      reversed.append(str.charAt(i));
    }
    return reversed.toString();
  }

  /**
   * Checks if a string is a palindrome.
   *
   * @param str The string to check. Must not be null.
   * @return True if the string is a palindrome, false otherwise. Returns false for empty strings.
   * @throws IllegalArgumentException if {@code str} is null.
   */
  public boolean isPalindrome(String str) {
    if (str == null) {
      throw new IllegalArgumentException("Input string must not be null");
    }
    if (str.length() == 0) {
      return false;
    }

    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }
}
