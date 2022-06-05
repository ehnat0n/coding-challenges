public class NQueensV2 {

    /*
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

    Given an integer n, return the number of distinct solutions to the n-queens puzzle.

    Constraints:

    1 <= n <= 9
     */

    private int n;
    private int result;

    /*
    T: O(n!) - essentially, column permutations with fixed row order: choose column for row 1 out of n, then
    column for row 2 out of n-1 etc.
    S: O(n) - solution counter is O(1), but we will have O(n) recursive calls on stack
     */
    public int totalNQueens(int n) {
        this.n = n;
        result = 0;
        findSolution(0, 0, 0, 0);
        return result;
    }

    private void findSolution(int curRow, int usedCols, int usedDiags, int usedXDiags) {
        if (curRow == n) { //got n queens placed - increase result count
            result++;
            return;
        }

        for (int curCol = 0; curCol < n; curCol++) {
            //formulas to enumerate diagonals '/' and xDiagonals '\'
            int curDiag = curRow - curCol + n; // '\', adding n to offset into positive numbers
            int curXDiag = curRow + curCol; // '/'

            /*
            Checking for other queens placed on the same lines/diagonals.
            Using bit manipulation here. Int numbers storing blocked lines/diagonals as separate enumerated bits.
             */
            if ((usedCols & (1 << curCol)) != 0 || (usedDiags & (1 << curDiag)) != 0 || (usedXDiags & (1 << curXDiag)) != 0) continue;

            //place the queen and adjust bits
            usedCols |= (1 << curCol);
            usedDiags |= (1 << curDiag);
            usedXDiags |= (1 << curXDiag);

            //jump to the next row since this one has a queen now
            findSolution(curRow + 1, usedCols, usedDiags, usedXDiags);

            //undo changes and continue on the same row
            usedCols ^= (1 << curCol);
            usedDiags ^= (1 << curDiag);
            usedXDiags ^= (1 << curXDiag);
        }
    }
}
