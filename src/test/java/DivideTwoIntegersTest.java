import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTwoIntegersTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {10, 3,  3}, //[example1]
                {7, -3, -2}, //[example2]
                {Integer.MAX_VALUE,  1, Integer.MAX_VALUE    }, //edge cases with abs(divisor) = 1
                {Integer.MAX_VALUE, -1, Integer.MIN_VALUE + 1}, //
                {Integer.MIN_VALUE,  1, Integer.MIN_VALUE    }, //
                {Integer.MIN_VALUE, -1, Integer.MAX_VALUE    }, //

                {Integer.MIN_VALUE, Integer.MAX_VALUE, -1}, //edge cases with MIN/MAX values
                {Integer.MAX_VALUE, Integer.MIN_VALUE,  0}, //
                {Integer.MAX_VALUE, Integer.MAX_VALUE,  1}, //
                {Integer.MIN_VALUE, Integer.MIN_VALUE,  1}, //

                {Integer.MAX_VALUE,  2,  1073741823},  //to make sure we stay within range if shifting left
                {Integer.MAX_VALUE, -2, -1073741823},  //
                {Integer.MIN_VALUE,  2, -1073741824},  //
                {Integer.MIN_VALUE, -2,  1073741824}   //
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int dividend, int divisor, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new DivideTwoIntegers().divide(dividend, divisor);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
