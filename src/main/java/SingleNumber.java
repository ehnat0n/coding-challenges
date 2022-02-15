public class SingleNumber {

    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.

    Constraints:

    1 <= nums.length <= 3 * 10^4
    -3 * 10^4 <= nums[i] <= 3 * 10^4
    Each element in the array appears twice except for one element which appears only once.
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //a ^ a = 0;   a ^ 0 = a;   a ^ (b ^ c) = (a ^ b) ^ c;   a ^ b = b ^ a;
            result ^= nums[i];
        }
        return result;
    }
}
