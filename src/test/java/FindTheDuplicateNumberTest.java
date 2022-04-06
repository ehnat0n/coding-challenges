import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindTheDuplicateNumberTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,3,4,2,2}, 2}, //[example1]
                {new int[]{3,1,3,4,2}, 3}, //[example2]
                {new int[]{1,1},       1}  //edge - min valid entry
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new FindTheDuplicateNumber().findDuplicate(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
