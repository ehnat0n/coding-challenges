import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShortestUnsortedContinuousSubarrayTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{2,6,4,8,10,9,15}, 5}, //[example1]
                {new int[]{1,2,3,4},         0}, //[example2] even, already sorted
                {new int[]{1},               0}, //[example3] edge - min length
                {new int[]{1,2,3,4,5},       0}, //odd number, already sorted
                {new int[]{1,3,2,4,5,6,7},   2}, //non-symmetrical sub array positioning
                {new int[]{1,2,4,5,3},       3}  //sorting interval triggers at the very end, multiple numbers before to sort
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
