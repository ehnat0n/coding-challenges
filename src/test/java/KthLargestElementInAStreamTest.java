import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KthLargestElementInAStreamTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {3, new int[]{4,5,8,2}, new int[]{3,5,10,9,4}, new int[]{4,5,5,8,8}   }, //[example1]
                {1, new int[]{},        new int[]{3,5,10,9,4}, new int[]{3,5,10,10,10}}  //original array has k - 1 elements
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int k, int[] nums, int[] additions, int[] expected) {
        long startTime, endTime;
        KthLargestElementInAStream actual;

        startTime = System.nanoTime();
        actual = new KthLargestElementInAStream(k, nums);
        for (int i = 0; i < additions.length; i++) {
            int cur = actual.add(additions[i]);
            assertEquals(cur, expected[i]);
        }
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        System.out.println();
    }
}
