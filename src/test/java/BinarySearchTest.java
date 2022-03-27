import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BinarySearchTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{-1,0,3,5,9,12}, 9,  4}, //[example1] target in array
                {new int[]{-1,0,3,5,9,12}, 2, -1}  //[example2] no target in array
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int target, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new BinarySearch().search(nums, target);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
