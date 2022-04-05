import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContainerWithMostWaterTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,8,6,2,5,4,6,3,7}, 49}, //[example1]
                {new int[]{1,1},                1}  //[example2] edge - min entry
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] height, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new ContainerWithMostWater().maxArea(height);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
