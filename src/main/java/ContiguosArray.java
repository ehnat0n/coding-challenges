import java.util.HashMap;
import java.util.Map;

public class ContiguosArray {

    /*
    Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

    1 <= nums.length <= 10^5
    nums[i] is either 0 or 1.
     */

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;

        int maxLen = 0;
        Map<Integer, Integer> countToIndex = new HashMap<>();
        int runningTotal = 0;

        countToIndex.put(0, -1); //0 count to index -1 - leveled out before starting so can calculate correct length;
        for (int i = 0; i < len; i++) {
            runningTotal += (nums[i] == 0) ? 1 : -1;
            if (!countToIndex.containsKey(runningTotal)) countToIndex.put(runningTotal, i); //haven't seen this total yet -> saving
            else maxLen = Math.max(maxLen, i - countToIndex.get(runningTotal)); //seen that total before -> equal amount of 1s & 0s in between
        }
        return maxLen;
    }
}
