import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    /*
    You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

    Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

    Return a list of integers representing the size of these parts.

    Constraints:

    1 <= s.length <= 500
    s consists of lowercase English letters.
     */
    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        Map<Character, Integer> lastInd = new HashMap<>();
        for (int i = 0; i < len; i++) {
            lastInd.put(s.charAt(i), i); //fill up with last entry index
        }
        int intEnd = 0;
        int prev = -1;
        char c;
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < len; j++) {
            c = s.charAt(j);
            intEnd = Math.max(lastInd.get(c), intEnd); //last index may be pushed to the right here
            if (j == intEnd) { //if we managed to reach our last index - means no new letters inside this partition
                result.add(j - prev);
                prev = j;
            }
        }
        return result;
    }
}
