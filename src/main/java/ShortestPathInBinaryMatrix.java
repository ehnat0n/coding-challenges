import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    /*
    Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

    A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

    The length of a clear path is the number of visited cells of this path.

    Constraints:

    n == grid.length
    n == grid[i].length
    1 <= n <= 100
    grid[i][j] is 0 or 1
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] moves = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int step = 0;

        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            int[] cell;
            for (int i = 0; i < size; i++) {
                cell = q.poll();
                if ((cell[0] == (n - 1)) && (cell[1] == (n - 1))) return step;
                for (int[] move : moves) {
                    int x = cell[0] + move[0];
                    int y = cell[1] + move[1];
                    if ((x < 0) || (x >= n) || (y < 0) || (y >= n) || (grid[x][y] == 1)) continue;
                    grid[x][y] = 1; //using blocking 1 value as a "visited" flag, it works since all valid cells will be in the queue anyway
                    q.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}