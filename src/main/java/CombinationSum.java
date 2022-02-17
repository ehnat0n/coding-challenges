import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /*
    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
    of candidates where the chosen numbers sum to target. You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if
    the frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations
     for the given input.

    Constraints:

    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    All elements of candidates are distinct.
    1 <= target <= 500
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return addCombosForNumber(new ArrayList<>(), candidates, 0, target);
    }

    private List<List<Integer>> addCombosForNumber(List<Integer> currentSubset, int[] candidates, int candidatesStartInd, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = candidates.length;
        for (int i = candidatesStartInd; i < len; i++) {
            int num = candidates[i];
            int maxNumCount = target / num;
            if (maxNumCount == 0) continue; //works in both cases: target = 0 or number is bigger than remaining non-zero target
            int remainder = target % num;
            if (remainder == 0) {
                List<Integer> list = new ArrayList<>(currentSubset);
                for (int k = 0; k < maxNumCount; k++) list.add(num);
                result.add(list);
            }
            if (i < len - 1) {
                for (int k = maxNumCount; k > 0; k--) {
                    List<Integer> list = new ArrayList<>(currentSubset);
                    for (int l = 1; l <= k; l++) list.add(num);
                    result.addAll(addCombosForNumber(list, candidates, i + 1, target - num * k));
                }
            }
        }
        return result;
    }
}
