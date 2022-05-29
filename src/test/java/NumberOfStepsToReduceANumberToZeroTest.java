import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberOfStepsToReduceANumberToZeroTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {14,   6}, //[example1]
                {8,    4}, //[example2]
                {123, 12}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int num, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new NumberOfStepsToReduceANumberToZero().numberOfSteps(num);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
