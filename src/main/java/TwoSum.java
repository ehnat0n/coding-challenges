import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
     */
    public int[] twoSum(int[] nums, int target) {
        int currentNum;
        Map<Integer, Integer> difference = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currentNum = nums[i];
            if (difference.containsKey(currentNum)) return new int[]{difference.get(currentNum), i};
            else difference.put(target - currentNum, i);
        }
        return new int[]{0, 0};
    }
}
