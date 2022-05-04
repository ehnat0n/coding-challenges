import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    /*
    You are given an integer array nums and an integer k.

    In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

    Return the maximum number of operations you can perform on the array.

    Constraints:

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9
    1 <= k <= 10^9
     */

    // T/S: O(n)/O(n)
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for (int num : nums) {
            if (map.containsKey(num) && (map.get(num) > 0)) {
                counter++;
                map.put(num, map.get(num) - 1);
            } else map.put(k - num, map.getOrDefault(k - num, 0) + 1);
        }
        return counter;
    }
}
