public class MaximumProductOfWordLengths {

    /*
    Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not
    share common letters. If no such two words exist, return 0.

    Constraints:

    2 <= words.length <= 1000
    1 <= words[i].length <= 1000
    words[i] consists only of lowercase English letters.
     */

    /*
    T/S: O(len * (sMax + len))/O(len)
    Considering both words.length is <= 1000 and max individual word length is <= 1000, we get T/S: O(len^2)/O(len)
     */
    public int maxProduct(String[] words) {
        int len = words.length;

        /*
        Creating array with single bits set for each power of 2 from 0 to 25 to represent individual letters.
        Fixed O(1) time, fixed O(1) memory.
         */
        int[] alphaMasks = new int[26];
        alphaMasks[0] = 1;
        for (int i = 1; i < 26; i++) {
            alphaMasks[i] = alphaMasks[i - 1] << 2;
        }

        /*
        Creating array with bit masks representing each word.
        O(s0 +..+ sLen) time, where s0 - sLen are word lengths. Can say it is <= O(len * sMax). O(len) memory.
         */
        int[] wordMasks = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                wordMasks[i] |= alphaMasks[c - 'a'];
            }
        }

        /*
        Main part where we compare bit masks.
        O(len * len) / O(1)
         */
        int max = 0;
        for (int j = 0; j < len; j++) {
            for (int k = j + 1; k < len; k++) {
                if ((wordMasks[j] & wordMasks[k]) == 0) {
                    int product = words[j].length() * words[k].length();
                    max = Math.max(max, product);
                }
            }
        }
        return max;
    }
}
