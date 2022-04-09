import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ThreeSumWithMultiplicityTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,1,2,2,3,3,4,4,5,5}, 8, 20}, //[example1]
                {new int[]{1,1,2,2,2,2},         5, 12}  //[example2]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] arr, int target, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new ThreeSumWithMultiplicity().threeSumMulti(arr, target);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
