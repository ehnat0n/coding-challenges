import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    /*
    Given an integer array nums and an integer k, return the k most frequent elements.
    You may return the answer in any order.

    Constraints:

    1 <= nums.length <= 10^5
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.
     */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) result[i] = pq.poll().getKey();

        return result;
    }
}
