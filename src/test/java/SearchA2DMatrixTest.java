import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchA2DMatrixTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}},  3,  true}, //[example1]
                {new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13, false}, //[example2]
                {new int[][]{{1}, {3}},                                 0, false}, //target out of matrix "range" - smaller
                {new int[][]{{1}, {3}},                                 4, false}  //target out of matrix "range" - bigger
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] matrix, int target, boolean expected) {
        long startTime, endTime;
        boolean actual;

        startTime = System.nanoTime();
        actual = new SearchA2DMatrix().searchMatrix(matrix, target);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
