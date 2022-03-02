public class IsSubsequence {

    /*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
    of the characters without disturbing the relative positions of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    Constraints:

    0 <= s.length <= 100
    0 <= t.length <= 10^4
    s and t consist only of lowercase English letters.
     */
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        if (sLen == 0) return true;
        if (sLen > t.length()) return false;

        char c;
        int entry = 0;
        for (int i = 0; i < sLen; i++) {
            c = s.charAt(i);
            entry = t.indexOf(c, entry);
            if (entry == -1) return false;
            else entry++;
        }
        return true;
    }
}
