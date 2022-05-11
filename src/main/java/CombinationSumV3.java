import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSumV3 {

    /*
    Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

    Only numbers 1 through 9 are used.
    Each number is used at most once.

    Return a list of all possible valid combinations. The list must not contain the same combination twice,
    and the combinations may be returned in any order.

    Constraints:

    2 <= k <= 9
    1 <= n <= 60
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int maxSum = ((9 - k + 1) + 9) * k / 2; //n can not be bigger than sum of highest k digits
        if ((n > maxSum) || (n < 3)) return result;

        addCombos(k, n, 9, 0, result, new Stack<>());
        return result;
    }

    private void addCombos(int k, int n, int i, int sum, List<List<Integer>> result, Stack<Integer> set) {
        if ((k == 0) && (sum == n)) {
            result.add(new ArrayList<>(set));
            return;
        }
        for (int j = i; j > 0; j--) {
            set.push(j);
            sum += j;
            addCombos(k - 1, n, j - 1, sum, result, set);
            sum -= j;
            set.pop();
        }
    }
}
