public class RemoveDuplicatesFromSortedArrayV2 {

    /*
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that
    each unique element appears at most twice. The relative order of the elements should be kept the same.
    Since it is impossible to change the length of the array in some languages, you must instead have the result
    be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
    then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.

    Do not allocate extra space for another array.
    You must do this by modifying the input array in-place with O(1) extra memory.

    Constraints:
    1 <= nums.length <= 3 * 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 3) return len;

        int writeInd = 2; //first possible write spot
        int trackValue = nums[writeInd - 2]; //track the value of writing spot - 2
        int rightValue;
        for (int rightInd = 2; rightInd < len; rightInd++) {
            rightValue = nums[rightInd];
            if (trackValue != rightValue) { //whenever we have a different value compare to track one -> move left
                if (rightInd != writeInd) nums[writeInd] = rightValue; // if already at the writing spot - no need to write
                writeInd++;
                trackValue = nums[writeInd - 2];
            }
        }
        return writeInd;
    }
}
