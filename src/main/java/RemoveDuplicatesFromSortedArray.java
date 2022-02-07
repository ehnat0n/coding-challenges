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
        int len = nums.length;
        if (len < 2) return len;

        int leftInd = 0;
        int leftValue = nums[leftInd];
        int rightValue;
        for (int rightInd = 1; rightInd < len; ++rightInd) {
            rightValue = nums[rightInd];
            if (rightValue != leftValue) {
                leftInd++;
                if (rightInd != leftInd) nums[leftInd] = rightValue;
                leftValue = rightValue;
            }
        }
        return leftInd + 1;
    }
}
