import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LastStoneWeightTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{2,7,4,1,8,1}, 1}, //[example1] 1 stone at the end
                {new int[]{1},           1}, //[example2] edge - min entry
                {new int[]{1,1},         0}  //edge - no stones left
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] stones, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new LastStoneWeight().lastStoneWeight(stones);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
