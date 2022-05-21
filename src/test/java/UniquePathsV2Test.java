import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UniquePathsV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}}, 10}, //[example1]
                {new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}, 2}, //[example1]
                {new int[][]{{0,1}, {0,0}},              1}, //[example2]
                {new int[][]{{0,0}},                     1}, //one line grid - can move one way only
                {new int[][]{{0,1}, {1,0}},              0}  //all moves blocked
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] obstacleGrid, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new UniquePathsV2().uniquePathsWithObstacles(obstacleGrid);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
