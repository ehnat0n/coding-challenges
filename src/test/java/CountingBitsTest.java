import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CountingBitsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {2, new int[]{0,1,1}      }, //[example1]
                {5, new int[]{0,1,1,2,1,2}}, //[example2]
                {0, new int[]{0}          } //edge
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int num, int[] expected) {

        long startTime = System.nanoTime();
        int[] actual = new CountingBits().countBits(num);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
