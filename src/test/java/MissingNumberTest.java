import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MissingNumberTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{3,0,1},             2}, //[example1]
                {new int[]{0,1},               2}, //[example2]
                {new int[]{9,6,4,2,3,5,7,0,1}, 8}, //[example3]
                {new int[]{9,6,4,2,3,5,7,8,1}, 0}  //missing zero
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new MissingNumber().missingNumber(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
