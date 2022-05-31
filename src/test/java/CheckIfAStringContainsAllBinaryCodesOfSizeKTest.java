import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckIfAStringContainsAllBinaryCodesOfSizeKTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"00110110", 2,  true}, //[example1]
                {"0110",     1,  true}, //[example2]
                {"0110",     2, false}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, int k, boolean expected) {
        long startTime, endTime;
        boolean actual;

        startTime = System.nanoTime();
        actual = new CheckIfAStringContainsAllBinaryCodesOfSizeK().hasAllCodes(s, k);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
