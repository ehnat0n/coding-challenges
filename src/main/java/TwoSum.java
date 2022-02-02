import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
     */
    public int[] twoSum(int[] nums, int target) {
        int currentNum;
        int[] result = new int[2];
        Map<Integer, Integer> differenceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currentNum = nums[i];
            if (differenceMap.containsKey(currentNum)) {
                result[0] = differenceMap.get(currentNum);
                result[1] = i;
                break;
            }
            else differenceMap.put(target - currentNum, i);
        }
        return result;
    }
}
