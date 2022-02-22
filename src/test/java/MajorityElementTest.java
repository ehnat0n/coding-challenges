import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MajorityElementTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{3,2,3}, 3}, //[example1] majority, but middle element is different
                {new int[]{2,2,1,1,1,2,2}, 2}, //[example2] non-single digit groups, middle is not a majority
                {new int[]{0}, 0} //min length
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int actual = new MajorityElement().majorityElement(nums);
        endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertEquals(actual, expected);
    }
}
