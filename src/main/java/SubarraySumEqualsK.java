import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /*
    Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

    Constraints:

    1 <= nums.length <= 2 * 10^4
    -1000 <= nums[i] <= 1000
    -10^7 <= k <= 10^7
     */

    //prefix sum (accepted)
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        if (len < 1) return 0;

        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1); //for cases when we have sub array starting from the first element

        int count = 0;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            if (prefixSumCounts.containsKey(prefixSum - k)) count += prefixSumCounts.get(prefixSum - k);
            prefixSumCounts.put(prefixSum, prefixSumCounts.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    //brute force (accepted)
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        if (len < 1) return 0;

        int count = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
            sum = 0;
        }
        return count;
    }
}
