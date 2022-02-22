import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /*
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than n / 2 times.
    You may assume that the majority element always exists in the array.

    Constraints:

    n == nums.length
    1 <= n <= 5 * 10^4
    -2^31 <= nums[i] <= 2^31 - 1
     */


    /*
    Boyer–Moore majority vote algorithm
    Time: O(n) Space: O(1)
    If there is no guarantee that majority exists - need 2nd run to confirm the number. Not confirmed - no solution.
    And return is not necessarily the element that occurs most often.
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int tracker = nums[0];
        int num;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            if (tracker == num) count++;
            else {
                if (count == 1) tracker = num;
                else count--;
            }
        }
        return tracker;
    }

    //Time: O(n * log n) Space: O(1) version
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //Time: O(n) Space: O(n) version
    public int majorityElement3(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            int cur = counts.getOrDefault(num, 0);
            if (cur == (len / 2)) return num;
            else counts.put(num, cur + 1);
        }
        return -1;
    }
}
