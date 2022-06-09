import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemovePalindromicSubsequencesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"ababa", 1}, //[example1]
                {"abb",   2}, //[example2]
                {"baabb", 2}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new RemovePalindromicSubsequences().removePalindromeSub(s);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
