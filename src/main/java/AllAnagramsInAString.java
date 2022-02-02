import java.util.ArrayList;
import java.util.List;

public class AllAnagramsInAString {

    /*
    Given two strings s and p, return an array of all the start indices of p's anagrams in s.
    You may return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    1 <= s.length, p.length <= 3 * 104
    s and p consist of lowercase English letters.
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen) return result;

        //initial big fill, the only place we use p
        int[] charBuckets = new int[26];
        for (int i = 0; i < pLen; i++) {
            charBuckets[s.charAt(i) - 'a']++;
            charBuckets[p.charAt(i) - 'a']--;
        }
        //sliding window  by one char only
        for (int j = 0; j < sLen - pLen; j++) {
            if (isAnagram(charBuckets)) {
                result.add(j);
            }
            charBuckets[s.charAt(j) - 'a']--;
            charBuckets[s.charAt(j+pLen) - 'a']++;
        }
        //check after last slide - can't do inside the cycle - will slide out of bounds
        if (isAnagram(charBuckets)) result.add(sLen - pLen);
        return result;
    }

    private boolean isAnagram(int[] buckets) {
        for (int count : buckets) {
            if (count != 0) return false;
        }
        return true;
    }
}
