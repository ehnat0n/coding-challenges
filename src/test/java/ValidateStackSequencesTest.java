import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ValidateStackSequencesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1},  true}, //[example1]
                {new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}, false}, //[example2]
                {new int[]{0},             new int[]{0},              true}  //min length
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] pushed, int[] popped, boolean expected) {
        long startTime, endTime, endTime2;

        //order is important since we modify arrays in solution2
        startTime = System.nanoTime();
        boolean actual = new ValidateStackSequences().validateStackSequences(pushed, popped);
        endTime = System.nanoTime();
        boolean actual2 = new ValidateStackSequences().validateStackSequences2(pushed, popped);
        endTime2 = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
        System.out.println("Solution2 run time: " + (endTime2 - endTime) / 1000000d + " milliseconds.");
        assertEquals(actual2, expected);

        System.out.println();
    }
}
