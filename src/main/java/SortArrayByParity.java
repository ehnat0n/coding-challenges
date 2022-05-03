public class SortArrayByParity {

    /*
    Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

    Return any array that satisfies this condition.

    Constraints:

    1 <= nums.length <= 5000
    0 <= nums[i] <= 5000
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int temp;
        while (left < right) {
            if (nums[left] % 2 == 1) {
                if (nums[right] % 2 == 0) {
                    temp = nums[left];
                    nums[left++] = nums[right];
                    nums[right] = temp;
                }
                right--;
            } else left++;
        }
        return nums;
    }
}
