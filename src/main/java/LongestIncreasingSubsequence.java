import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    /*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.

    A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
    the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

    Constraints:

    1 <= nums.length <= 2500
    -10^4 <= nums[i] <= 10^4
     */

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1) return 1;

        List<Integer> sequence = new ArrayList<>();
        sequence.add(nums[0]);
        int num;
        for (int i = 1; i < len; i++) {
            num = nums[i];
            if (num > sequence.get(sequence.size() - 1)) sequence.add(num);
            else sequence.set(binarySearch(sequence, num), num);
        }
        return sequence.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int mid;
        int midVal;
        while (left < right) {
            mid = (left + right) / 2;
            midVal = list.get(mid);
            if (midVal == target) return mid;
            else if (midVal < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
