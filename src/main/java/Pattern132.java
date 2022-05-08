import java.util.Stack;
import java.util.TreeMap;

public class Pattern132 {

    /*
    Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
    such that i < j < k and nums[i] < nums[k] < nums[j].

    Return true if there is a 132 pattern in nums, otherwise, return false.

    Constraints:

    n == nums.length
    1 <= n <= 2 * 10^5
    -10^9 <= nums[i] <= 10^9
     */

    //Same as a stack solution - just use array tail for it
    // T/S: O(n)/O(1)
    public boolean find132Pattern(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;

        int topInd = len; //init with invalid out-of-bounds value
        int rightMax = Integer.MIN_VALUE; //min value from restrictions is -10^9 so this acts as invalid one
        int curNum;
        for (int i = len - 1; i >= 0; i--) {
            curNum = nums[i];
            if (curNum < rightMax) return true; //means we have some valid value in rightMax which in turn means we have valid (numJ > rightMax) pair in stack
            while ((topInd < len) && (curNum > nums[topInd])) rightMax = nums[topInd++]; //guarantees we have valid pair (numJ > rightMax)
            nums[--topInd] = curNum;
        }
        return false;
    }

    // T/S: O(n)/O(n)
    public boolean find132Pattern2(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;

        Stack<Integer> stackJK = new Stack<>();
        int rightMax = Integer.MIN_VALUE; //min value from restrictions is -10^9 so this acts as invalid one
        int curNum;
        for (int i = len - 1; i >= 0; i--) {
            curNum = nums[i];
            if (rightMax > curNum) return true; //means we have valid rightMax value which in turn means we have valid (numJ > rightMax) pair
            while (!stackJK.isEmpty() && (curNum > stackJK.peek())) rightMax = stackJK.pop(); //guarantees we have valid pair (numJ > rightMax)
            stackJK.push(curNum);
        }
        return false;
    }

    // T/S: O(n * log n)/O(n)
    public boolean find132Pattern3(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;

        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        for (int i = 2; i < len; i++) {
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
        }

        int leftMin = nums[0];
        for (int j = 1; j < len - 1; j++) {
            if (leftMin < nums[j]) {
                Integer numK = rightMap.ceilingKey(leftMin + 1);
                if ((numK != null) && (numK < nums[j])) return true;
            }

            leftMin = Math.min(leftMin, nums[j]);
            rightMap.put(nums[j + 1], rightMap.get(nums[j + 1]) - 1);
            if (rightMap.get(nums[j + 1]) == 0) rightMap.remove(nums[j + 1]);
        }
        return false;
    }
}
