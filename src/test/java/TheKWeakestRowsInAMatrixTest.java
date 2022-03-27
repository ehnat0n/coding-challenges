import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TheKWeakestRowsInAMatrixTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{1, 1, 0, 0, 0},
                             {1, 1, 1, 1, 0},
                             {1, 0, 0, 0, 0},
                             {1, 1, 0, 0, 0},
                             {1, 1, 1, 1, 1}},
                        3, new int[]{2, 0, 3}}, //[example1]
                {new int[][]{{1, 0, 0, 0},
                             {1, 1, 1, 1},
                             {1, 0, 0, 0},
                             {1, 0, 0, 0}},
                        2, new int[]{0, 2}}, //[example2]
                {new int[][]{{1, 0},
                             {1, 0},
                             {1, 0},
                             {1, 1}},
                        4, new int[]{0, 1, 2, 3}} //run out of zeros, but k > 0 - add rows with 1s at the end
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] mat, int k, int[] expected) {
        long startTime, endTime;
        int[] actual;

        startTime = System.nanoTime();
        actual = new TheKWeakestRowsInAMatrix().kWeakestRows(mat, k);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
