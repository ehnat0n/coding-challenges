import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinimumDominoRotationsForEqualRowTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{2,1,2,4,2,2},     new int[]{5,2,6,2,3,2},     2}, //[example1]
                {new int[]{3,5,1,2,3},       new int[]{3,6,3,3,4},      -1}, //[example2]
                {new int[]{1,2,1,1,1,2,2,2}, new int[]{2,1,2,2,2,2,2,2}, 1}  //matching numbers on two sides - don't count
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] tops, int[] bottoms, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new MinimumDominoRotationsForEqualRow().minDominoRotations(tops, bottoms);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
