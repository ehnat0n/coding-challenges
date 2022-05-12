import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class PermutationsV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,1,2}, List.of(List.of(1,1,2),List.of(1,2,1),List.of(2,1,1))}, //[example1]
                {new int[]{1,2,3}, List.of(List.of(1,2,3),List.of(1,3,2),List.of(2,1,3), List.of(2,3,1), List.of(3,1,2), List.of(3,2,1))}  //[example2]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] digits, List<List<Integer>> expected) {
        long startTime, endTime;
        List<List<Integer>> actual;

        startTime = System.nanoTime();
        actual = new PermutationsV2().permuteUnique(digits);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
