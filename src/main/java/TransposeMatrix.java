public class TransposeMatrix {

    /*
    Given a 2D integer array matrix, return the transpose of matrix.

    The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

    Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 1000
    1 <= m * n <= 10^5
    -10^9 <= matrix[i][j] <= 10^9
     */

    /*
    Singe matrix may not be square we create a transposed copy. Otherwise, could do it in place.
    T/S: O(m * n)/O(m * n)
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0]. length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
