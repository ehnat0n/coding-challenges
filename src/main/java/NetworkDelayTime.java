import java.util.*;

public class NetworkDelayTime {

    /*
    You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as
    directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time
    it takes for a signal to travel from source to target.

    We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
    If it is impossible for all the n nodes to receive the signal, return -1.

    Constraints:

    1 <= k <= n <= 100
    1 <= times.length <= 6000
    times[i].length == 3
    1 <= ui, vi <= n
    ui != vi
    0 <= wi <= 100
    All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
     */

    //Lazy Dijkstra's
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] weights = new int[n + 1]; //to avoid using -1 for array indexes
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[0] = 0; //zero out unused node
        weights[k] = 0; //zero out starting node

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> weights[a[1]]));
        pq.offer(new int[]{k, k, 0}); //add starting edge, to init PQ
        int nodeCount = 0; //using a counter to detect if there are any unconnected nodes

        while (!pq.isEmpty()) {
            int curNode = pq.poll()[1];
            if (visited[curNode]) continue; //possible to have multiple entries in PQ if multiple updates happened before processing

            visited[curNode] = true;
            nodeCount++;

            for (int[] edge : times) {
                if (edge[0] == curNode) {
                    int nextNode = edge[1];
                    if (visited[nextNode]) continue; //ignoring edges to visited nodes
                    int newWeight = edge[2] + weights[curNode];
                    if (newWeight < weights[nextNode]) {
                        weights[nextNode] = newWeight;
                        pq.offer(edge);
                    }
                }
            }
        }

        int ans = 0;
        if (nodeCount == n) {
            for (int weight : weights) {
                if (ans < weight) ans = weight;
            }
        } else ans = -1;
        return ans;
    }
}
