import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShortestPathInBinaryMatrixTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{0,1}, {1,0}},               2}, //[example1]
                {new int[][]{{0,0,0}, {1,1,0}, {1,1,0}},  4}, //[example2]
                {new int[][]{{1,0,0}, {1,1,0}, {1,1,0}}, -1}, //[example3]
                {new int[][]{{0}},                        1}  //edge - valid 1 cell input
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] grid, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
