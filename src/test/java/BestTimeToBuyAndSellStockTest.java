import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BestTimeToBuyAndSellStockTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{7,1,5,3,6,4},     5}, //[example1] - peak forward is smaller than peak back, but is the solution
                {new int[]{7,6,4,3,1},       0}, //[example2] - no peaks - zero profit
                {new int[]{7},               0}, //no solution
                {new int[]{7,3,2,1,0,9},     9}, //peak on last element
                {new int[]{0,7,3,2,1,4,9},   9}, //peak on last element, buy on day 1
                {new int[]{0,7,7,2,2,1,1,7}, 7}, //repeating numbers, multiple peaks giving the same solution
                {new int[]{0,1,2,3,4,5,6,7}, 7}  //all increasing
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {
        long startTime = System.nanoTime();
        int result = new BestTimeToBuyAndSellStock().maxProfit(nums);
        long endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);
    }
}
