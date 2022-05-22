import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PalindromicSubstringsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"abc", 3}, //[example1]
                {"aaa", 6}, //[example2]
                {"a",   1}  //edge - min length
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new PalindromicSubstrings().countSubstrings(s);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
