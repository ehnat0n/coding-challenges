import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortArrayByParityTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{3,1,2,4}, new int[]{4,2,1,3}}, //[example1]
                {new int[]{0},       new int[]{0}      }  //[example2]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int[] expected) {
        long startTime, endTime;
        int[] actual;

        startTime = System.nanoTime();
        actual = new SortArrayByParity().sortArrayByParity(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
