public class ArithmeticSlices {

    /*
    An integer array is called arithmetic if it consists of at least three elements and if the difference
    between any two consecutive elements is the same.

    For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.

    Given an integer array nums, return the number of arithmetic subarrays of nums.
    A subarray is a contiguous subsequence of the array.
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) return 0;

        int sliceCount = 0;
        boolean isSlice = false;
        int sliceStart = 0;
        int midNum;
        for (int i = 2; i < len; i++) {
            midNum = nums[i - 1];
            if ((midNum - nums[i - 2]) == (nums[i] - midNum)) {
                if (!isSlice) {
                    isSlice = true;
                    sliceStart = i - 2;
                }
            } else {
                if (isSlice) {
                    isSlice = false;
                    sliceCount += getSliceCount(i - sliceStart);
                }
            }
        }
        if (isSlice) sliceCount += getSliceCount(len - sliceStart);
        return sliceCount;
    }

    private int getSliceCount(int sliceLen) {
        int sliceCount = 0;
        for (int j = 2; j < sliceLen; j++) sliceCount += sliceLen - j;
        return sliceCount;
    }
}
