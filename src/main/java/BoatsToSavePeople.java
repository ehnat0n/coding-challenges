import java.util.*;

public class BoatsToSavePeople {

    /*
    You are given an array people where people[i] is the weight of the ith person,
    and an infinite number of boats where each boat can carry a maximum weight of limit.
    Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

    Return the minimum number of boats to carry every given person.

    Constraints:

    1 <= people.length <= 5 * 10^4
    1 <= people[i] <= limit <= 3 * 10^4

     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0;
        int right = people.length - 1;
        int sum;
        while (left <= right) {
            sum = people[left] + people[right--];
            if (sum <= limit) left++;
            boats++;
        }
        return boats;
    }
}
