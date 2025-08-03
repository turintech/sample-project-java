package strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class StropsTest {
    
    @Test
    public void testReverse() {
        Strops strops = new Strops();
        
        assertEquals("", strops.reverse(""));
        assertEquals("a", strops.reverse("a"));
        assertEquals("cba", strops.reverse("abc"));
        assertEquals("dlrow", strops.reverse("world"));
    }
    
    @Test
    public void testIsPalindrome() {
        Strops strops = new Strops();
        
        // Test regular palindromes
        assertTrue(strops.isPalindrome("a"));
        assertTrue(strops.isPalindrome("aba"));
        assertTrue(strops.isPalindrome("racecar"));
        assertTrue(strops.isPalindrome("madam"));
        
        // Test non-palindromes
        assertFalse(strops.isPalindrome("ab"));
        assertFalse(strops.isPalindrome("hello"));
        assertFalse(strops.isPalindrome("world"));
        
        // Test edge case - empty string should be a palindrome
        // This test will FAIL before the bug fix and PASS after
        assertTrue(strops.isPalindrome(""));
    }
}
