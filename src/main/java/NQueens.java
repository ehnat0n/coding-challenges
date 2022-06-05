import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    /*
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

    Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
    a queen and an empty space, respectively.

    Constraints:

    1 <= n <= 9
     */

    private char[][] board;
    private List<List<String>> result;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        result = new ArrayList<>();
        findSolution(0, 0, 0, 0);
        return result;
    }

    private void findSolution(int curRow, int usedCols, int usedDiags, int usedXDiags) {
        if (curRow == n) { //got n queens placed - record board state
            recordCurrentSolution();
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
            board[curRow][curCol] = 'Q';
            usedCols |= (1 << curCol);
            usedDiags |= (1 << curDiag);
            usedXDiags |= (1 << curXDiag);

            //jump to the next row since this one has a queen now
            findSolution(curRow + 1, usedCols, usedDiags, usedXDiags);

            //undo changes and continue on the same row
            board[curRow][curCol] = '.';
            usedCols ^= (1 << curCol);
            usedDiags ^= (1 << curDiag);
            usedXDiags ^= (1 << curXDiag);
        }
    }

    private void recordCurrentSolution() {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        result.add(solution);
    }
}
