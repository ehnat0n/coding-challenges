import java.util.Arrays;

public class MinCostToConnectAllPoints {

    /*
    You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

    The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
    where |val| denotes the absolute value of val.

    Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path
    between any two points.

    Constraints:

    1 <= points.length <= 1000
    -10^6 <= xi, yi <= 10^6
    All pairs (xi, yi) are distinct.
     */

    //using Minimum Spanning Tree and Prim's algorithm ideas
    public int minCostConnectPoints(int[][] points) {
        int sum = 0;
        int len = points.length;
        boolean[] visited = new boolean[len];
        int[] weights = new int[len];
        Arrays.fill(weights, Integer.MAX_VALUE);

        int cycle = 0; //cycle counter to make sure we do (len - 1) edge lookups
        visited[0] = true;
        int current = 0; //current point
        while (cycle < len - 1) {
            int minWeight = Integer.MAX_VALUE; //edge to the next point
            int next = -1; //next point where we get by using minWeight edge
            for (int i = 0; i < len; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(points[current][0] - points[i][0]) + Math.abs(points[current][1] - points[i][1]);
                    weights[i] = Math.min(distance, weights[i]);
                    if (weights[i] < minWeight) {
                        minWeight = weights[i];
                        next = i;
                    }
                }
            }
            sum += minWeight;
            current = next;
            visited[current] = true;
            cycle++;
        }
        return sum;
    }
}
