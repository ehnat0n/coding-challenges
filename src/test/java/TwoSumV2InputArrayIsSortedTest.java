import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TwoSumV2InputArrayIsSortedTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{2,7,11,15}, 9, new int[]{1,2}}, //[example1]
                {new int[]{2,3,4},     6, new int[]{1,3}}, //[example2]
                {new int[]{-1,0},     -1, new int[]{1,2}}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] numbers, int target, int[] expected) {
        long startTime, endTime;
        int[] actual;

        startTime = System.nanoTime();
        actual = new TwoSumV2InputArrayIsSorted().twoSum(numbers, target);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
