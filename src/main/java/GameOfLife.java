public class GameOfLife {

    /*
    According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
    the British mathematician John Horton Conway in 1970."

    The board is made up of an m x n grid of cells, where each cell has an initial state:
    live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors
    (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

    - Any live cell with fewer than two live neighbors dies as if caused by under-population.
    - Any live cell with two or three live neighbors lives on to the next generation.
    - Any live cell with more than three live neighbors dies, as if by over-population.
    - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

    The next state is created by applying the above rules simultaneously to every cell in the current state,
    where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

    Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 25
    board[i][j] is 0 or 1.
     */

    private final int[][] shifts = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int sum;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = calculateSum(board, i, j, m, n);
                //these values represent current/next cycle combinations, using last two bits: 00 01 10 11
                if ((board[i][j] & 1) == 1) board[i][j] = ((sum < 2) || (sum > 3)) ? 1 : 3;
                else if (sum == 3) board[i][j] = 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1; //shifting one bit right to discard previous cycle and put new values in the slot
            }
        }
    }

    private int calculateSum(int[][] board, int i, int j, int m, int n) {
        int sum = 0;
        int iNew, jNew;
        for (int[] shift: shifts) {
            iNew = i + shift[0];
            jNew = j + shift[1];
            if (isValidPosition(iNew, jNew, m, n)) {
                sum += board[iNew][jNew] & 1; //to filter rightmost bit which represents current cycle value
            }
        }
        return sum;
    }

    private boolean isValidPosition(int i, int j, int m, int n) {
        return (i >= 0) && (j >= 0) && (i < m) && (j < n);
    }
}
