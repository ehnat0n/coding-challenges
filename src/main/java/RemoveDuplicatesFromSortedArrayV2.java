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
        if (len < 2) return len;

        boolean isDouble = false;
        int leftInd = 0;
        for (int rightInd = 1; rightInd < len; rightInd++) {
            if (nums[leftInd] != nums[rightInd]) {
                nums[++leftInd] = nums[rightInd];
                isDouble = false;
            } else {
                if (!isDouble) {
                    isDouble = true;
                    if (rightInd - leftInd > 1) { //double but spread - need to move left 2nd occurrence
                        nums[++leftInd] = nums[rightInd];
                    } else leftInd++; //double one by one
                }
            }
        }
        return leftInd + 1;
    }
}
