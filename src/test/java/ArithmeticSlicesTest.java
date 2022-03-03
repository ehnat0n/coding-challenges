import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArithmeticSlicesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,2,3,4},  3}, //[example1]
                {new int[]{1},        0}, //[example2]
                {new int[]{1,1,1},    1}, //min length, 0 diff
                {new int[]{-5,-4,-3}, 1}, //negative numbers
                {new int[]{-5,-4,-3, 0, 2,3,4}, 2}, //2 sub arrays
                {new int[]{1,3,5,7,9}, 6}, //diff more than 1
                {new int[]{3,-1,-5,-9}, 3}, //descending order
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {

        long startTime = System.nanoTime();
        int actual = new ArithmeticSlices().numberOfArithmeticSlices(nums);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
