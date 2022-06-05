public class RangeSumQueryImmutable {

    /*
    Given an integer array nums, handle multiple queries of the following type:

        - Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

    Implement the NumArray class:

        - NumArray(int[] nums) Initializes the object with the integer array nums.
        - int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and
          right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

    Constraints:

    1 <= nums.length <= 10^4
    -10^5 <= nums[i] <= 10^5
    0 <= left <= right < nums.length
    At most 10^4 calls will be made to sumRange.
     */

    private final int[] prefix;

    // T: O(n) to create object, O(1) each sumRange call
    // S: O(n) to store prefix sums
    public RangeSumQueryImmutable(int[] nums) {
        int len = nums.length;
        prefix = new int[len + 1];
        prefix[0] = 0;
        for (int i = 1; i <= len; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
