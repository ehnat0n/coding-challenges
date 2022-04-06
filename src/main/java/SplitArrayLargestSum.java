public class SplitArrayLargestSum {

    /*
    Given an array nums which consists of non-negative integers and an integer m, you can split the array
    into m non-empty continuous subarrays.

    Write an algorithm to minimize the largest sum among these m subarrays.

    Constraints:

    1 <= nums.length <= 1000
    0 <= nums[i] <= 10^6
    1 <= m <= min(50, nums.length)
     */
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int sum = 0;
        int maxValue = nums[0];
        for (int num : nums) {
            if (num > maxValue) maxValue = num;
            sum += num;
        }
        if (m == 1) return sum;
        if (m == len) return maxValue;

        int low = maxValue;
        int high = sum;
        int mid;
        int minSum = Integer.MAX_VALUE;
        while (low <= high) {
            mid = (low + high) / 2;
            if (canSplit(nums, mid, m)) {
                minSum = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return minSum;
    }

    private boolean canSplit(int[] nums, int targetSum, int m) {
        int cur = 0;
        int parts = 0;
        for (int num : nums) {
            if (cur + num <= targetSum) cur += num;
            else {
                parts++;
                cur = num;
            }
        }
        if (cur <= targetSum) parts++;
        return parts <= m;
    }
}
