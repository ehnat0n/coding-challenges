import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    /*
    You are given a sorted unique integer array nums.
    Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
    That is, each element of nums is covered by exactly one of the ranges, and there is no integer x
    such that x is in one of the ranges but not in nums.

    Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b

    Constraints:

    0 <= nums.length <= 20
    -2^31 <= nums[i] <= 2^31 - 1
    All the values of nums are unique.
    nums is sorted in ascending order.
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return result;

        int rangeStart = nums[0];
        int diff = 0;
        int curNum;
        int prevNum;
        for (int i = 1; i < len; i++) {
            curNum = nums[i];
            prevNum = nums[i - 1];
            if ((curNum - prevNum) == 1) diff++;
            else {
                if (diff == 0) result.add(String.valueOf(prevNum));
                else result.add(rangeStart + "->" + (rangeStart + diff));
                rangeStart = curNum;
                diff = 0;
            }
        }
        if (diff == 0) result.add(String.valueOf(nums[len - 1]));
        else result.add(rangeStart + "->" + (rangeStart + diff));

        return result;
    }
}
