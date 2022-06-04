public class RangeSumQuery2DImmutable {

    /*
    Given a 2D matrix matrix, handle multiple queries of the following type:

        - Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1)
        and lower right corner (row2, col2).

    Implement the NumMatrix class:

        - NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
        - int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside
          the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

    Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 200
    -10^5 <= matrix[i][j] <= 10^5
    0 <= row1 <= row2 < m
    0 <= col1 <= col2 < n
    At most 10^4 calls will be made to sumRegion.
     */

    private final int[][] dp;
    /*
    We precalculate rectangle sums (r() function) where current cell is right bottom corner and top left is always (0,0).
    Then we may notice that every rectangle ABCD in the matrix can be calculated as r(D) - r(B) - r(C) + r(A). Since r(A)
    is part of both r(B) and r(C).

    T: O(m * n) on constructor call, O(1) for every request
    S: O(m * n) to hold rectangle sums
     */
    public RangeSumQuery2DImmutable(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows + 1][cols + 1];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dp[row + 1][col + 1] = dp[row][col + 1] + dp[row + 1][col] - dp[row][col] + matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }

    /*
    2D version of 1D problem. We apply 1D approach to every row. Then we just need to do linear calculation
    for every request (amount of rows). Precalculate (prefix sum) rows in constructor.
    Sum the difference of last  and first column for every row.

    T: O(m * n) on constructor call, O(m) for every request
    S: O(m * n) to hold prefix sums
     */
//    public RangeSumQuery2DImmutable(int[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        dp = new int[rows][cols + 1];
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < cols; col++) {
//                dp[row][col + 1] = dp[row][col] + matrix[row][col];
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int i = row1; i <= row2; i++) {
//            int rowSum = dp[i][col2 + 1] - dp[i][col1];
//            sum += rowSum;
//        }
//        return sum;
//    }
}
