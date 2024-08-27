package strings;

public class Strops {
  /**
   * Reverses a string
   *
   * @param str The string to reverse.
   * @return The reversed string.
   */
  public String reverse(String str) {
    String reversed = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      reversed += str.charAt(i);
    }
    return reversed;
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

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        return false;
      }
    }

    return true;
  }
}
