package strings;

public class Strops {
  /**
   * Reverses a string
   *
   * @param str The string to reverse.
   * @return The reversed string.
   */
  public String reverse(String str) {
    StringBuilder reversed = new StringBuilder(str.length());
    for (int i = str.length() - 1; i >= 0; i--) {
      reversed.append(str.charAt(i));
    }
    return reversed.toString();
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

    int len = str.length();
    for (int i = 0; i < len / 2; i++) {
      if (str.charAt(i) != str.charAt(len - 1 - i)) {
        return false;
      }
    }

    return true;
  }
}