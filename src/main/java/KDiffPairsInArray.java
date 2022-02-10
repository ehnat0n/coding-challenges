import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {

    /*
    Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

    A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
    0 <= i < j < nums.length
    |nums[i] - nums[j]| == k

    Notice that |val| denotes the absolute value of val.

    Constraints:

    1 <= nums.length <= 10^4
    -10^7 <= nums[i] <= 10^7
    0 <= k <= 10^7
     */
    public int findPairs(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int counter = 0;
        for (int num : map.keySet()) {
            if (((k == 0) && (map.get(num) > 1)) || ((k != 0) && map.containsKey(num - k))) counter++;
        }
        return counter;
    }
}
