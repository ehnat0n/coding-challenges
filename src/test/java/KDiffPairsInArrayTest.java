import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KDiffPairsInArrayTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{3,1,4,1,5},     2, 2}, //[example1] two of the same pairs - count one
                {new int[]{1,2,3,4,5},     1, 4}, //[example2] shared numbers in pairs
                {new int[]{1,3,1,5,4},     0, 1}, //[example3] 0 diff pair
                {new int[]{1,1,1,1,1},     0, 1}, //all the same with 0 diff - one solution
                {new int[]{1,2,3,4,5},     0, 0}, //all different - no 0 diff solution
                {new int[]{1,1,1,2,2},     0, 2}, //multiple groups that give 0 diff solution
                {new int[]{1,1,3,4,4},     0, 2}, //multiple groups that give 0 diff solution, but not a single number
                {new int[]{-1,-3,1,-6,-8}, 2, 3}, //negative numbers - diff counted properly
                {new int[]{0,1},           1, 1}  // min entry
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int k, int expected) {
        long startTime = System.nanoTime();
        int result = new KDiffPairsInArray().findPairs(nums, k);
        long endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);
    }
}
