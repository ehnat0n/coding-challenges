import java.util.Arrays;

public class UniquePathsV2 {

    /*
    You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
    The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.

    An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

    The testcases are generated so that the answer will be less than or equal to 2 * 10^9.

    Constraints:

    m == obstacleGrid.length
    n == obstacleGrid[i].length
    1 <= m, n <= 100
    obstacleGrid[i][j] is 0 or 1.
     */

    /*
    This solution simply refills original grid with new values, showing how many paths could lead to this particular cell.
    Starting cell - 1, top row and left column can only be filled from left or top accordingly.
    The rest of the cells - top + left counts. Return value from destination cell.

    T/S: O(m * n)/ O(1) - only constant additional memory since reusing the grid. Iterate over each cell - m * n.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if ((obstacleGrid[0][0] == 1) || (obstacleGrid[m - 1][n - 1] == 1)) return 0; //blocked start or destination

        //starting to fill possible path counts to this cell from start to destination
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else if (i == 0) obstacleGrid[0][j] = obstacleGrid[0][j - 1];
                else if (j == 0) obstacleGrid[i][0] = obstacleGrid[i - 1][0];
                else obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m - 1][n -1];
    }

    /*
    This solution uses recursion and extra m * n storage to fill in all valid cells with amount of available paths.
    Filling goes backwards from destination to starting cell. Final number with paths available from starting cell is returned.

    T/S: O(m * n)/ O(m * n) - there are a lot of recursive calls, but stack depth not going above m + n calls.
    Total number of calls can't be more than m * n * 2.
     */
    private int m, n;
    private int[][] grid;
    private int[][] knownPathCount;
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if ((obstacleGrid[0][0] == 1) || (obstacleGrid[m - 1][n - 1] == 1)) return 0; //blocked start or destination

        grid = obstacleGrid;
        knownPathCount = new int[m][n];
        for (int[] row : knownPathCount) Arrays.fill(row,-1); //filling with -1 since 0 is a valid option
        knownPathCount[m - 1][n - 1] = 1; //init destination cell - technically it's a recursion base case

        return findPath(0, 0);
    }

    private int findPath(int i, int j) {
        if (i == m || j == n || grid[i][j] == 1) return 0;
        if (knownPathCount[i][j] != -1) return knownPathCount[i][j];

        knownPathCount[i][j] = findPath(i + 1, j) + findPath(i, j + 1);
        return knownPathCount[i][j];
    }
}