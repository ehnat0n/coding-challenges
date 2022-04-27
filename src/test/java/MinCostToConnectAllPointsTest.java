import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinCostToConnectAllPointsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{0,0}, {2,2}, {3,10}, {5,2}, {7,0}}, 20}, //[example1]
                {new int[][]{{3,12}, {-2,5}, {-4,1}},             18}, //[example2]
                {new int[][]{{0,0}, {1,1}, {1,0}, {-1,1}},         4}, //
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] points, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new MinCostToConnectAllPoints().minCostConnectPoints(points);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
