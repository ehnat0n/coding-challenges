import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CountSortedVowelStringsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {1,      5}, //[example1]
                {2,     15}, //[example1]
                {33, 66045}  //[example1]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int n, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new CountSortedVowelStrings().countVowelStrings(n);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
