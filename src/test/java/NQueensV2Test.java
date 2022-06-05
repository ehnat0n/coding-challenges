import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NQueensV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {4, 2}, //[example1]
                {1, 1}, //[example2] - one solution
                {2, 0}  //no solutions
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int n, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new NQueensV2().totalNQueens(n);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
