public class LongestIncreasingPathInAMatrix {

    /*
    Given an m x n integers matrix, return the length of the longest increasing path in matrix.

    From each cell, you can either move in four directions: left, right, up, or down.
    You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

    Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 200
    0 <= matrix[i][j] <= 2^31 - 1
     */
    private static final int[][] moves = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};

    //DFS
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] maxPathFromCell = new int[m][n];
        int maxPath = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, calculateMaxPathFromCell(matrix, m, n, i, j, maxPathFromCell));
            }
        }
        return maxPath;
    }

    private int calculateMaxPathFromCell(int[][] matrix, int m, int n, int i, int j, int[][] maxPathFromCell) {
        if (maxPathFromCell[i][j] > 0) return maxPathFromCell[i][j];

        int max4 = 0;
        for (int[] move : moves) {
            int row = i + move[0];
            int col = j + move[1];
            if (row < 0 || row >= m || col < 0 || col >= n || matrix[row][col] <= matrix[i][j]) continue;
            max4 = Math.max(max4, calculateMaxPathFromCell(matrix, m, n, row, col, maxPathFromCell));
        }
        maxPathFromCell[i][j] = max4 + 1;
        return maxPathFromCell[i][j];
    }
}
