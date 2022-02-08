import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddDigitsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {38,         2}, //[example1]
                {0,          0}, //[example2] edge case, 1 digit and 0
                {111,        3}, //multiple digits, answer in one cycle
                {2147483647, 1}  //edge case, max capacity
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int num, int expected) {
        long startTime = System.nanoTime();
        int result = new AddDigits().addDigits(num);
        long endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);
    }
}
