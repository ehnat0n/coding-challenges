import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareVersionNumbersTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"1.01", "1.001", 0}, //[example1]
                {"1.0",  "1.0.0", 0}, //[example2]
                {"0.1",  "1.1",  -1}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String version1, String version2, int expected) {
        System.out.println("Test case: " + version1 + ", " + version2);

        long startTime = System.nanoTime();
        int actual = new CompareVersionNumbers().compareVersion(version1, version2);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertEquals(actual, expected);
    }
}
