import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LongestIncreasingPathInAMatrixTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{9,9,4}, {6,6,8}, {2,1,1}}, 4}, //[example1]
                {new int[][]{{3,4,5}, {3,2,6}, {2,2,1}}, 4}, //[example2]
                {new int[][]{{1}},                       1}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] matrix, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new LongestIncreasingPathInAMatrix().longestIncreasingPath(matrix);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
