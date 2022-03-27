public class TheKWeakestRowsInAMatrix {

    /*
    You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
    The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of
    all the 0's in each row.

    A row i is weaker than a row j if one of the following is true:

    - The number of soldiers in row i is less than the number of soldiers in row j.
    - Both rows have the same number of soldiers and i < j.

    Return the indices of the k the weakest rows in the matrix ordered from weakest to strongest.

    Constraints:

    m == mat.length
    n == mat[i].length
    2 <= n, m <= 100
    1 <= k <= m
    matrix[i][j] is either 0 or 1.
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int column = 0;
        int row;

        int[] result = new int[k];
        int resultInd = 0;
        boolean[] visited = new boolean[m];

        while ((k > 0) && (column < n)) {
            row = 0;
            while ((k > 0) && (row < m)) {
                if ((mat[row][column] == 0) && !visited[row]) {
                    result[resultInd++] = row;
                    visited[row] = true;
                    k--;
                }
                row++;
            }
            column++;
        }
        row = 0;
        while ((k > 0) && (row < m)) {
            if (!visited[row]) {
                result[resultInd++] = row;
                k--;
            }
            row++;
        }
        return result;
    }
}
