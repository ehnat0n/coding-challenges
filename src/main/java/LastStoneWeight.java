import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    /*
    You are given an array of integers stones where stones[i] is the weight of the ith stone.

    We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
    Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

    If x == y, both stones are destroyed, and
    If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.

    At the end of the game, there is at most one stone left.

    Return the smallest possible weight of the left stone. If there are no stones left, return 0.

    Constraints:

    1 <= stones.length <= 30
    1 <= stones[i] <= 1000
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int weight : stones) q.offer(weight);
        int stone1, stone2;
        while (q.size() > 1) {
            stone1 = q.poll();
            stone2 = q.poll();
            if (stone1 > stone2) q.offer(stone1 - stone2);
        }
        return (q.isEmpty()) ? 0 : q.peek();
    }
}
