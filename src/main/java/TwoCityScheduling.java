import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    /*
    A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti],
    the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

    Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

    Constraints:

    2 * n == costs.length
    2 <= costs.length <= 100
    costs.length is even.
    1 <= aCosti, bCosti <= 1000
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));

        int sum = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n * 2; i++) {
            if (i < n) sum += costs[i][0];
            else sum += costs[i][1];
        }
        return sum;
    }
}
