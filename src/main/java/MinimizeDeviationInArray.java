import java.util.SortedSet;
import java.util.TreeSet;

public class MinimizeDeviationInArray {

    /*
    You are given an array nums of n positive integers.
    You can perform two types of operations on any element of the array any number of times:

    If the element is even, divide it by 2.
        For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
    If the element is odd, multiply it by 2.
        For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].

    The deviation of the array is the maximum difference between any two elements in the array.
    Return the minimum deviation the array can have after performing some number of operations.

    Constraints:

    n == nums.length
    2 <= n <= 10^5
    1 <= nums[i] <= 10^9
     */
    public int minimumDeviation(int[] nums) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num % 2 == 1) num *= 2; //if odd - multiply by 2 to max it out
            set.add(num);
        }

        int deviation =  set.last() - set.first();
        int max;
        while ((deviation > 0) && ((set.last() % 2) == 0)) { //checking deviation in case we have a set like {32,32,32,32,64} - cuts it early
            max = set.last();
            set.remove(max); //remove current max
            set.add(max / 2); //add halved number back
            deviation = Math.min(deviation, set.last() - set.first());
        }
        return deviation;
    }
}
