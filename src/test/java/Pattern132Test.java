import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Pattern132Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,2,3,4}, false}, //[example1]
                {new int[]{3,1,4,2},  true}, //[example2]
                {new int[]{-1,2,1,0}, true}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, boolean expected) {
        long startTime, endTime;
        boolean actual;

        startTime = System.nanoTime();
        actual = new Pattern132().find132Pattern(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
