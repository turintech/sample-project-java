package strings;

public class Strops {
  /**
   * Reverses a string
   *
   * @param str The string to reverse.
   * @return The reversed string.
   */
  public String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }

  /**
   * Checks if a string is a palindrome
   *
   * @param str The string to check.
   * @return True if the string is a palindrome, false otherwise.
   */
  public boolean isPalindrome(String str) {
    if (str.length() == 0) {
      return false;
    }

    int length = str.length();
    for (int i = 0; i < length / 2; i++) {
      if (str.charAt(i) != str.charAt(length - 1 - i)) {
        return false;
      }
    }

    return true;
  }
}