import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TopKFrequentElementsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,1,1,2,2,3}, 2, new int[]{1,2}}, //[example1]
                {new int[]{1},           1, new int[]{1}  }  //[example2]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int k, int[] expected) {
        long startTime, endTime;
        int[] actual;

        startTime = System.nanoTime();
        actual = new TopKFrequentElements().topKFrequent(nums, k);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
