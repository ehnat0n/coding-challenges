import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RunningSumOf1DArrayTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,2,3,4},       new int[]{1,3,6,10}}, //[example1]
                {new int[]{1,1,1,1,1},    new int[]{1,2,3,4,5}}, //[example2]
                {new int[]{3,1,2,10,1}, new int[]{3,4,6,16,17}}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int[] expected) {
        long startTime, endTime;
        int[] actual;

        startTime = System.nanoTime();
        actual = new RunningSumOf1DArray().runningSum(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
