public class SpiralMatrixV2 {

    /*
    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

    Constraints:

    1 <= n <= 20
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        return fillPerimeter(matrix, n, 0, 0);
    }

    private int[][] fillPerimeter(int[][] matrix, int size, int start, int count) {
        if (size <= 0) return matrix;

        int end = start + size;
        for (int j = start; j < end; j++) matrix[start][j] = ++count;
        for (int i = start + 1; i < end; i++) matrix[i][end - 1] = ++count;
        for (int k = end - 2; k >= start; k--) matrix[end - 1][k] = ++count;
        for (int l = end - 2; l > start; l--) matrix[l][start] = ++count;

        return fillPerimeter(matrix, size - 2, start + 1, count);
    }
}
