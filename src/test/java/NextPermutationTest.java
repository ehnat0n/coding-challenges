import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NextPermutationTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,2,3},     new int[]{1,3,2}}, //[example1]
                {new int[]{3,2,1},     new int[]{1,2,3}}, //[example2]
                {new int[]{1,1,5},     new int[]{1,5,1}}, //[example3]
                {new int[]{2,3,1},     new int[]{3,1,2}}, //
                {new int[]{1,3,2},     new int[]{2,1,3}}, //
                {new int[]{1,2,3,2}, new int[]{1,3,2,2}}, //
                {new int[]{2,4,3,1}, new int[]{3,1,2,4}}  //
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int[] expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        new NextPermutation().nextPermutation(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(nums, expected);

        System.out.println();
    }
}
