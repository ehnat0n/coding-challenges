import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {

    /*
    You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
    You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

    Return the length of the shortest path that visits every node. You may start and stop at any node,
    you may revisit nodes multiple times, and you may reuse edges.

    Constraints:

    n == graph.length
    1 <= n <= 12
    0 <= graph[i].length < n
    graph[i] does not contain i.
    If graph[a] contains b, then graph[b] contains a.
    The input graph is always connected.
     */

    int v; //graph.length - amount of vertices

    private static class Pair {
        int id;
        int mask;

        Pair (int id, int mask) {
            this.id = id;
            this.mask = mask;
        }
    }

    //simultaneous BFS
    public int shortestPathLength(int[][] graph) {
        v = graph.length; //vertices
        if (v == 1) return 0;

        int doneMask = (1 << v) - 1; //final state
        boolean[][] visited = new boolean[v][1 << v]; //starting vertices as rows, columns = masks

        //init queue with all vertices and corresponding masks that mark them as visited
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            q.add(new Pair(i, 1 << i));
        }

        //simultaneous BFS
        int step = -1;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair node = q.poll();
                if (node.mask == doneMask) return step;
                if (visited[node.id][node.mask]) continue;
                visited[node.id][node.mask] = true;
                for (int next : graph[node.id]) {
                    q.add(new Pair(next, node.mask | (1 << next)));
                }
            }
        }
        return step;
    }


    private final int maxDistance = 100000; //max possible distance - mimic "infinity"
    private int[][] distance;

    //brute force - too slow
    public int shortestPathLength2(int[][] graph) {
        v = graph.length;
        if (v == 1) return 0;

        int result = Integer.MAX_VALUE;

        distance = fw(graph); //fill up distances with Floyd-Warshall algorithm

        for (int i = 0; i < v; i++) {
            result = Math.min(result, visit(i, (1 << i))); //comparing different start points
        }
        return result;
    }

    private int visit(int node, int mask) {
        int best = Integer.MAX_VALUE;
        if (mask == (1 << v) - 1) return 0; //everything visited - stop recursion
        for (int i = 0; i < v; i++) {
            if (((1 << i) & (mask)) == 0) { //if something not visited yet
                //min distance from here (FW), mark as visited + distance to all other non visited nodes
                best = Math.min(best, visit(i, (1 << i) | mask) + distance[node][i]);
            }
        }
        return best;
    }

    //Floyd-Warshall with all weights = 1, O(v^3)
    private int[][] fw(int[][] graph) {
        int[][] distance = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i == j) continue;
                if (hasEdge(graph, i, j)) distance[i][j] = 1;
                else distance[i][j] = maxDistance;
            }
        }
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        return distance;
    }

    private boolean hasEdge(int[][] graph, int i, int j) {
        for (int k = 0; k < graph[i].length; k++) {
            if (graph[i][k] == j) return true;
        }
        return false;
    }
}
