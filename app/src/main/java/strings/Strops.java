package strings;

public class Strops {
  /**
   * Reverses a string
   *
   * @param str The string to reverse.
   * @return The reversed string.
   */
  public String reverse(String str) {
    StringBuilder reversed = new StringBuilder();
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
    final int len = str.length();
    if (len == 0) {       
      return false;     
    }      
    int mid = len >> 1;
    for (int i = 0; i < mid; i++) {       
      if (str.charAt(i) != str.charAt(len - i - 1)) {         
        return false;       
      }     
    }      
    return true;   
  }
}