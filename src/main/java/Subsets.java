import java.util.*;

public class Subsets {

    /*
    Given an integer array nums of unique elements, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.

    Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.
     */
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if (len < 1) return new ArrayList<>();

        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());

        /*
        Starting from first number, take all existing sets and add new number. Add these new sets to resulting set that
        we are going to iterate over again with next number.
         */
        for (int num : nums) {
            List<List<Integer>> numberSubset = new ArrayList<>();
            for (List<Integer> existingList : resultList) {
                List<Integer> newList = new ArrayList<>(existingList);
                newList.add(num);
                numberSubset.add(newList);
            }
            resultList.addAll(numberSubset);
        }
        return resultList;
    }
}
