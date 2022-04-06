import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchInRotatedSortedArrayV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{2,5,6,0,0,1,2},   0,  true}, //[example1]
                {new int[]{2,5,6,0,0,1,2},   3, false}, //[example2]
                {new int[]{2,5,6,0,0,1,2},   5,  true}, //
                {new int[]{2,5,6,6,0,0,1,2}, 6,  true}, //
                {new int[]{1,0,1,1,1},       0,  true}, //
                {new int[]{3,5,1},           1,  true}, //
                {new int[]{5,1,2,3},         1,  true}, //
                {new int[]{1,3},             1,  true}, //
                {new int[]{1,1},             0, false}, //
                {new int[]{3,3,0,1,3},       1,  true}, //
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int target, boolean expected) {
        long startTime, endTime;
        boolean actual;

        startTime = System.nanoTime();
        actual = new SearchInRotatedSortedArrayV2().search(nums, target);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
