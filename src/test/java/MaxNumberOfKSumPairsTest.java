import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaxNumberOfKSumPairsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,2,3,4},   5, 2}, //[example1]
                {new int[]{3,1,3,4,3}, 6, 1}, //[example2]
                {new int[]{3,3,3,3},   6, 2}, //same pairs
                {new int[]{3,3,3},     6, 1}, //leftover elements, same as in valid pairs
                {new int[]{3},         3, 0}  //edge - min entry
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int k, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new MaxNumberOfKSumPairs().maxOperations(nums, k);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
