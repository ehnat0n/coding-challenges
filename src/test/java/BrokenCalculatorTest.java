import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BrokenCalculatorTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {2, 3,           2}, //[example1]
                {5, 8,           2}, //[example2]
                {3, 10,          3}, //[example3]
                {5, 5,           0}, //edge - no difference, 0 steps
                {1, 2,           1}, //1 step
                {1, 1000000000, 39}  //max possible difference
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int startValue, int target, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new BrokenCalculator().brokenCalc(startValue, target);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
