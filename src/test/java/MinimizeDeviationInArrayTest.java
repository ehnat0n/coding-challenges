import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinimizeDeviationInArrayTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,2,3,4},    1}, //[example1]
                {new int[]{4,1,5,20,3}, 3}, //[example2]
                {new int[]{2,10,8},     3}, //[example3]
                {new int[]{1,1},        0}, //edge case - min length, no need to change anything - zero deviation
                {new int[]{1,2},        0}, //edge case - min length, can make deviation zero
                {new int[]{7,9,12},     3}, //minimal possible change is bigger than original deviation
                {new int[]{7,12},       1}  //minimal possible change is bigger than original deviation
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int actual = new MinimizeDeviationInArray().minimumDeviation(nums);
        endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertEquals(actual, expected);
    }
}
