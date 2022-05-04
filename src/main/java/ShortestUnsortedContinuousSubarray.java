import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    /*
    Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray
    in ascending order, then the whole array will be sorted in ascending order.

    Return the shortest such subarray and output its length.

    Constraints:

    1 <= nums.length <= 10^4
    -10^5 <= nums[i] <= 10^5
     */

    // T/S: O(n)/O(1)
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;

        int end = -1;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] < max) end = i;
            else max = nums[i];
        }


        int start = 0;
        int min = nums[len - 1];
        for (int j = len - 2; j >= 0 ; j--) {
            if (nums[j] > min) start = j;
            else min = nums[j];
        }
        return end - start + 1;
    }

    // T/S: O(n * log n)/O(n)
    public int findUnsortedSubarray2(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);

        int left = 0;
        int right = nums.length - 1;
        boolean foundStart = false;
        boolean foundEnd = false;
        while ((left < right) && (!foundStart || !foundEnd)) {
            if (!foundStart) {
                if (nums[left] == clone[left]) left++;
                else foundStart = true;
            }
            if (!foundEnd) {
                if (nums[right] == clone[right]) right--;
                else foundEnd = true;
            }
        }
        return (left == right) ? 0 : right - left + 1;
    }
}
