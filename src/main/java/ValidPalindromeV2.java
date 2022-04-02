public class ValidPalindromeV2 {

    /*
    Given a string s, return true if the s can be palindrome after deleting at most one character from it.

    Constraints:

    1 <= s.length <= 10^5
    s consists of lowercase English letters.
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char cL, cR;
        while (left < right) {
            cL = s.charAt(left++);
            cR = s.charAt(right--);
            if (cL != cR) return (isPalindrome(s, left, right + 1) || isPalindrome(s, left - 1, right));
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        char cL, cR;
        while (left < right) {
            cL = s.charAt(left++);
            cR = s.charAt(right--);
            if (cL != cR) return false;
        }
        return true;
    }
}
