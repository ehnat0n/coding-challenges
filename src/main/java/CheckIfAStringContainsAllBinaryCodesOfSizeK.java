import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

    /*
    Given a binary string s and an integer k, return true if every binary code of length k is a substring of s.
    Otherwise, return false.

    Constraints:

    1 <= s.length <= 5 * 10^5
    s[i] is either '0' or '1'.
    1 <= k <= 20
     */

    /*
    T/S: O(len)/O(2^k)
     */
    public boolean hasAllCodes(String s, int k) {
        int len = s.length();
        int uniquesSize = 1 << k; //all binary codes are simply 2^k
        int minLen = k + uniquesSize - 1; //one char adds only one option, so we can easily tell minimum length needed
        if (len < minLen) return false; //quick fail if not enough length
        int dupesLeft = len - minLen; //amount of duplicates allowed, can use to stop early if not going to reach uniques count

        boolean[] got = new boolean[uniquesSize];
        int maxValue = uniquesSize - 1; //all ones for correct amount of bits, going to use it as a length cutting mask
        int hash = 0;
        for (int i = 0; i < k - 1; i++) {
            hash = ((hash << 1) | (s.charAt(i) - '0')); //initial chars hash, up to k - 2 so next k - 1 char would generate first legitimate hash for checking
        }
        for (int j = k - 1; j < len; j++) {
            hash = ((hash << 1) & maxValue) | (s.charAt(j) - '0'); //discard left bit, cut with mask to keep length - add 1 if needed
            if (got[hash]) {
                dupesLeft--;
                if (dupesLeft < 0) return false; //used all possible duplicates - no need to continue
            } else {
                got[hash] = true;
                uniquesSize--;
                if (uniquesSize == 0) return true; //found them all - no need to continue
            }
        }
        return false;
    }

    /*
    We have 'len' iterations and process 'k' chars to calculate hash for comparison. We store up to 'len' strings with 'k' chars.
    Alternatively, we can say that it's 2^k * k since in case of len < 2^k we have no solution and fail quickly.
    T/S: O(len * k)/O(len * k)
     */
    public boolean hasAllCodes2(String s, int k) {
        int len = s.length();
        int uniquesSize = 1 << k; //all binary codes are simply 2^k
        int minLen = k + uniquesSize - 1; //one char adds only one option, so we can easily tell minimum length needed
        if (len < minLen) return false; //quick fail if not enough length
        int dupesLeft = len - minLen; //amount of duplicates allowed, can use to stop early if not going to reach uniques count

        Set<String> uniques = new HashSet<>();
        String value;
        for (int i = 0; i <= len - k; i++) {
            value = s.substring(i, i + k);
            if (!uniques.add(value)) {
                dupesLeft--;
                if (dupesLeft < 0) return false; //used all possible duplicates - no need to continue
            }
            else {
                uniquesSize--;
                if (uniquesSize == 0) return true; //found them all - no need to continue
            }
        }
        return false; //should never execute
    }
}
