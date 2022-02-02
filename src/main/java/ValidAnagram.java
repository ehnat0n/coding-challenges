public class ValidAnagram {

    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.
     */
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (t.length() != len) return false;

        int[] charBuckets = new int[26];
        for (int i = 0; i < len; i++) {
            charBuckets[s.charAt(i) - 'a']++;
            charBuckets[t.charAt(i) - 'a']--;
        }

        for (int count : charBuckets) {
            if (count != 0) return false;
        }
        return true;
    }
}
