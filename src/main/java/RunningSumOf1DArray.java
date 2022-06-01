public class RunningSumOf1DArray {

    /*
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0], ..., nums[i]).

    Return the running sum of nums.
     */

    // No original array modification. T/S: O(n)/O(n)
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] rSum = new int[len];
        rSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            rSum[i] = rSum[i - 1] + nums[i];
        }
        return rSum;
    }

    // If it's ok to modify original array - can do it in place. T/S: O(n)/O(1)
    public int[] runningSum2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
