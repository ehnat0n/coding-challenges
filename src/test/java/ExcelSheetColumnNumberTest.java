import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExcelSheetColumnNumberTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"A", 1}, //[example1] min entry
                {"AB", 28}, //[example2]
                {"ZY", 701}, //[example3]
                {"FXSHRXW", 2147483647} //max capacity
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String title, int expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int actual = new ExcelSheetColumnNumber().titleToNumber(title);
        endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertEquals(actual, expected);
    }
}
