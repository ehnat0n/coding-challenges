public class RemoveDuplicatesFromSortedArray {

    /*
    Given an integer array 'nums' sorted in non-decreasing order,
    remove the duplicates in-place such that each unique element appears only once.
    The relative order of the elements should be kept the same.

    Have the result placed in the first part of the array 'nums'.
    More formally, if there are 'k' elements after removing the duplicates,
    then the first 'k' elements of 'nums' should hold the final result.
    It does not matter what you leave beyond the first 'k' elements.

    Return 'k' after placing the final result in the first 'k' slots of 'nums'.

    Do not allocate extra space for another array.
    You must do this by modifying the input array in-place with O(1) extra memory.
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        for (int right = 1; right < nums.length; ++right) {
            if (nums[right] == nums[left]) continue;
            nums[++left] = nums[right];
        }
        return left + 1;
    }
}
