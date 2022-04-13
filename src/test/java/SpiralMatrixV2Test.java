import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SpiralMatrixV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {3, new int[][]{{1,2,3}, {8,9,4}, {7,6,5}}}, //[example1] n is odd
                {1, new int[][]{{1}}                      }, //[example2] edge - min entry, odd
                {2, new int[][]{{1,2},{4,3}}              }, //n = 2, even
                {4, new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}}} //n = 4, even
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int n, int[][] expected) {
        long startTime, endTime;
        int[][] actual;

        startTime = System.nanoTime();
        actual = new SpiralMatrixV2().generateMatrix(n);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        for (int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }

        System.out.println();
    }
}
