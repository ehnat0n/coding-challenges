import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeleteAndEarnTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{3,4,2},       6}, //[example1]
                {new int[]{2,2,3,3,3,4}, 9}, //[example2]
                {new int[]{1},           1}  //edge - min valid entry
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {

        long startTime = System.nanoTime();
        int actual = new DeleteAndEarn().deleteAndEarn(nums);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
