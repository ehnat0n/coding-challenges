import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberOf1BitsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {11,  3}, //[example1]
                {128, 1}, //[example2]
                {-3, 31}, //[example3]
                {0,   0}  //edge
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int num, int expected) {

        long startTime = System.nanoTime();
        int actual = new NumberOf1Bits().hammingWeight(num);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
