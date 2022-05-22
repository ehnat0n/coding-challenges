public class PalindromicSubstrings {

    /*
    Given a string s, return the number of palindromic substrings in it.

    A string is a palindrome when it reads the same backward as forward.

    A substring is a contiguous sequence of characters within the string.

    Constraints:

    1 <= s.length <= 1000
    s consists of lowercase English letters.
     */

    private int len;

    public int countSubstrings(String s) {
        len = s.length();
        if (len == 1) return 1;

        int result = 0;
        for (int i = 0; i < len - 1; i++) {
            result += countPalindromes(s, i, i);
            result += countPalindromes(s, i, i + 1);
        }
        return result + 1; //adding one for last char in a string
    }

    private int countPalindromes(String s, int start, int end) {
        int count = 0;
        while ((start >= 0) && (end < len)) {
            if (!(s.charAt(start) == s.charAt(end))) break;
            count++;
            start--;
            end++;
        }
        return count;
    }
}
