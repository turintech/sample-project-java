package strings;

public class Strops {
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
    if (str.length() <= 1) {
      return str.length() == 1;
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