import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RussianDollEnvelopesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{5,4}, {6,4}, {6,7}, {2,3}},        3}, //[example1]
                {new int[][]{{1,1}, {1,1}, {1,1}},               1}, //[example2]
                {new int[][]{{2,4}, {2,3}, {3,6}, {1,2}, {2,5}}, 3}  //
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] envelopes, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new RussianDollEnvelopes().maxEnvelopes(envelopes);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
