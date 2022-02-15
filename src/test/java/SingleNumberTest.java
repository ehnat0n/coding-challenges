import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SingleNumberTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{2,2,1},     1}, //[example1] solution is last element
                {new int[]{4,1,2,1,2}, 4}, //[example2] solution is first element
                {new int[]{1},         1}  //[example3] edge - min length
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int result = new SingleNumber().singleNumber(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);

        System.out.println();
    }
}
