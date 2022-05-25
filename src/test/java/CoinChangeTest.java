import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CoinChangeTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,2,5}, 11,  3}, //[example1]
                {new int[]{2},      3, -1}, //[example2]
                {new int[]{1},      0,  0}, //[example3]
                {new int[]{3,5},    9,  3}  //
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] coins, int amount, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new CoinChange().coinChange(coins, amount);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
