import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{10,9,2,5,3,7,101,18}, 4}, //[example1]
                {new int[]{0,1,0,3,2,3},         4}, //[example2]
                {new int[]{7,7,7,7,7,7,7},       1}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new LongestIncreasingSubsequence().lengthOfLIS(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
