import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SplitArrayLargestSumTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{7,2,5,10,8},                         2, 18}, //[example1]
                {new int[]{1,2,3,4,5},                          2,  9}, //[example2]
                {new int[]{1,4,4},                              3,  4}, //[example3] m = nums.length
                {new int[]{1,4,4},                              1,  9}, //edge, m = 1
                {new int[]{1,1,1,11,1},                         3, 11}, //first sub array can never reach target
                {new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8}, 8, 25}, //
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int m, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new SplitArrayLargestSum().splitArray(nums, m);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
