import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GameOfLifeTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}}, new int[][]{{0,0,0}, {1,0,1}, {0,1,1}, {0,1,0}}}, //[example1]
                {new int[][]{{1,1}, {1,0}},                       new int[][]{{1,1}, {1,1}}                      }, //[example2]
                {new int[][]{{1}}, new int[][]{{0}}}, //edge
                {new int[][]{{0}}, new int[][]{{0}}}  //edge
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] board, int[][] expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        new GameOfLife().gameOfLife(board);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        for (int i = 0; i < board.length; i++) {
            assertEquals(board[i], expected[i]);
        }

        System.out.println();
    }
}
