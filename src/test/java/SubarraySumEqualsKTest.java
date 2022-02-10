import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class SubarraySumEqualsKTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,1,1},       2, 2}, //[example1] same numbers, multiple overlapping solutions
                {new int[]{1,2,3},       3, 2}, //[example2] multiple separated, but connected solutions
                {new int[]{},            5, 0}, //edge case, invalid input - zero length
                {new int[]{1},           1, 1}, //edge case, min input - one solution
                {new int[]{1},           2, 0}, //edge case, min input - no solution
                {new int[]{1,2,9,3},     3, 2}, //multiple separated with a 'blocker' solutions
                {new int[]{1,2,1,3},     3, 3}, //multiple overlapping and side-by-side solutions
                {new int[]{3,2,1,3},     3, 3}, //multiple side-by-side, first and last elements alone are solutions
                {new int[]{3,-5,3},      3, 2}, //first and last, separated by negative 'blocker' - drops sum below target
                {new int[]{1,2,-5,3},    3, 2}, //multiple solutions, separated by a negative 'blocker'
                {new int[]{3,0,0,0,3},   3, 8}, //zeros that can be added to solutions in both directions
                {new int[]{1,0,2,0,0,3}, 3, 6}  //multiple solutions with zeros in between
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int k, int expected) {
        System.out.println("Data: " + Arrays.toString(nums) + ", k = " + k);

        long startTime = System.nanoTime();
        int result = new SubarraySumEqualsK().subarraySum1(nums, k);
        long endTime = System.nanoTime();
        int result2 = new SubarraySumEqualsK().subarraySum2(nums, k);
        long endTime2 = System.nanoTime();

        System.out.println("Solution1 run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);

        System.out.println("Solution2 run time: " + (endTime2 - endTime) / 1000000d + " milliseconds.");
        assertEquals(result2, expected);

        System.out.println();
    }
}
