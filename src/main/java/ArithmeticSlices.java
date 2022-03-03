public class ArithmeticSlices {

    /*
    An integer array is called arithmetic if it consists of at least three elements and if the difference
    between any two consecutive elements is the same.

    For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.

    Given an integer array nums, return the number of arithmetic subarrays of nums.
    A subarray is a contiguous subsequence of the array.
     */
    public int numberOfArithmeticSlices(int[] nums) {
        /*
        Count for slices ending at the previous index. We can add all those as a combo with new number + 1 for new triple.
        If there were no slices there - just going to get count 1 for our first triple.
         */
        int prevSlices = 0;

        int sliceCount = 0;
        int midNum;
        for (int i = 2; i < nums.length; i++) {
            midNum = nums[i - 1];
            if ((midNum - nums[i - 2]) == (nums[i] - midNum)) {
                sliceCount += ++prevSlices;
            } else {
                prevSlices = 0;
            }
        }
        return sliceCount;
    }
}
