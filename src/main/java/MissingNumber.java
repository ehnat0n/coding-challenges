import java.util.Arrays;

public class MissingNumber {

    /*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
    that is missing from the array.

    Follow up:
    Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

    Constraints:

    n == nums.length
    1 <= n <= 10^4
    0 <= nums[i] <= n
    All the numbers of nums are unique.
     */


    /*
    Idea here is to use XOR operator.
    We have 3 possible cases:
    1) Zero is missing. We will have numbers 1..n with indexes 0..n-1
    2) Middle number is missing. 1..k-1, k+1..n with indexes 0..n-1
    3) N is missing. 1..n-1 with 0..n-1
    If we XOR all numbers with indexes we will get following outcomes: n, k^n, 0. With proper answers: 0, k, n.
    Clearly we just need to XOR our end result with n.

    T/S: O(n)/O(1)
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0; //can make it equal 'n' or just use one variable, but easier to read/understand this way
        for (int i = 0; i < n; i++) {
            result ^= (i ^ nums[i]);
        }
        return result ^ n;
    }

    /*
    Easier to understand. Sort and find first element that is not matching with its index. Can be zero or any element
    in the middle. If no such element found - means missing number is n.
    T/S: O(n * log n)/O(1)
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > i) return i;
        }
        return n;
    }
}
