import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TransposeMatrixTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}, new int[][]{{1,4,7}, {2,5,8}, {3,6,9}}}, //[example1]
                {new int[][]{{1,2,3}, {4,5,6}},          new int[][]{{1,4}, {2,5}, {3,6}}      }  //[example2]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] matrix, int[][] expected) {
        long startTime, endTime;
        int[][] actual;

        startTime = System.nanoTime();
        actual = new TransposeMatrix().transpose(matrix);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        for (int row = 0; row < actual.length; row++) {
            assertEquals(actual[row], expected[row]);
        }
    }
}
