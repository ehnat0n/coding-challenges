import java.util.*;

public class PermutationsV2 {

    /*
    Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

    Constraints:

    1 <= nums.length <= 8
    -10 <= nums[i] <= 10
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList<>();
        addCombinations(nums, combinations, new ArrayList<>(), new boolean[nums.length]);
        return combinations;
    }

    private void addCombinations(int[] nums, List<List<Integer>> combinations, List<Integer> combination, boolean[] processed) {
        if (nums.length == combination.size()) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (processed[i]) continue;
            /*
            !processed[i - 1] is for the cases when we try to restart with a duplicate (just released) number
            but if it's locked - we still use it since we need to fill all slots
             */
            if ((i > 0) && (!processed[i - 1]) && (nums[i] == nums[i - 1])) continue;

            processed[i] = true;
            combination.add(nums[i]);

            addCombinations(nums, combinations, combination, processed);

            combination.remove(combination.size() - 1);
            processed[i] = false;
        }
    }
}
