public class SearchInRotatedSortedArrayV2 {

    /*
    There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

    Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
    such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

    Given the array nums after the rotation and an integer target, return true if target is in nums, or false
    if it is not in nums.

    You must decrease the overall operation steps as much as possible.

    Constraints:

    1 <= nums.length <= 5000
    -10^4 <= nums[i] <= 10^4
    nums is guaranteed to be rotated at some pivot.
    -10^4 <= target <= 10^4
     */
    public boolean search(int[] nums, int target) {
        return customSearch(nums, 0, nums.length - 1, target);
    }

    private boolean customSearch(int[] nums, int startInd, int endInd, int target) {
        if (endInd < startInd) return false;
        if (endInd == startInd) return nums[startInd] == target;

        int startVal = nums[startInd];
        int endVal = nums[endInd];
        int midInd = startInd + (endInd - startInd + 1) / 2;
        int midVal = nums[midInd];
        if (midVal == target || startVal == target || endVal == target) return true;

        if (startVal < midVal) {
            if ((target > startVal) && (target < midVal)) return customSearch(nums, startInd, midInd - 1, target);
            else return customSearch(nums, midInd, endInd, target);
        } else if (startVal > midVal) {
            if ((target > midVal) && (target < endVal)) return customSearch(nums, midInd, endInd, target);
            else return customSearch(nums, startInd, midInd - 1, target);
        } else {
            return (customSearch(nums, startInd, midInd - 1, target) || customSearch(nums, midInd, endInd, target));
        }
    }
}
