public class PermutationInString {

    /*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
    In other words, return true if one of s1's permutations is the substring of s2.

    Constraints:

    1 <= s1.length, s2.length <= 10^4
    s1 and s2 consist of lowercase English letters.
     */
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if ((s1Len < 1) || (s2Len < 1) || (s1Len > s2Len)) return false;

        int[] buckets = new int[26];
        for (int i = 0; i < s1Len; i++) {
            buckets[s1.charAt(i) - 'a']--;
            buckets[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i + s1Len < s2Len; i++) {
            if (foundAnagram(buckets)) return true;
            buckets[s2.charAt(i) - 'a']--;
            buckets[s2.charAt(i + s1Len) - 'a']++;
        }
        return foundAnagram(buckets);
    }

    private boolean foundAnagram(int[] buckets) {
        for (int bucket : buckets) {
            if (bucket != 0) return false;
        }
        return true;
    }
}
