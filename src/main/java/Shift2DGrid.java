import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    /*
    Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

    In one shift operation:

    Element at grid[i][j] moves to grid[i][j + 1].
    Element at grid[i][n - 1] moves to grid[i + 1][0].
    Element at grid[m - 1][n - 1] moves to grid[0][0].

    Return the 2D grid after applying shift operation k times.

    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m <= 50
    1 <= n <= 50
    -1000 <= grid[i][j] <= 1000
    0 <= k <= 100
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();

        int totalCount = m * n;
        k %= totalCount; //to remove full cycle rotations
        int distanceToOldSelf = totalCount - k;

        for (int i = 0; i < m; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int prevInd1D = ((i * n + j) + distanceToOldSelf) % totalCount;
                rowList.add(grid[prevInd1D / n][prevInd1D % n]);
            }
            result.add(rowList);
        }
        return result;
    }
}
