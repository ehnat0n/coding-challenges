import java.util.*;

public class DeleteAndEarn {

    /*
    You are given an integer array nums. You want to maximize the number of points you get by performing the following
    operation any number of times:
    Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element
    equal to nums[i] - 1 and every element equal to nums[i] + 1.
    Return the maximum number of points you can earn by applying the above operation some number of times.

    Constraints:

    1 <= nums.length <= 2 * 10^4
    1 <= nums[i] <= 10^4
     */
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1); //filling the frequency map
            min = Math.min(min, num); //and getting min/max in the same cycle
            max = Math.max(max, num);
        }

        /*
        DP
        We have to consider cases:
        x - included, then x-1 has to be excluded
        x - excluded, then x-1 can be both included and excluded
        Since we are iterating from min to max, x+1 case will be handled correctly on the next step with the case:
        x+1 - excluded, x - included
         */
        int withPrev = 0;
        int withoutPrev = 0;
        int incThis;
        int excThis;
        for (int i = min; i <= max; i++) {
            incThis = withoutPrev + i * counts.getOrDefault(i, 0);
            excThis = Math.max(withPrev, withoutPrev);
            withPrev = incThis;
            withoutPrev = excThis;
        }

        return Math.max(withPrev, withoutPrev);
    }
}
