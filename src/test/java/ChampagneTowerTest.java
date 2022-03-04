import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ChampagneTowerTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {1,          1,  1,     0.0}, //[example1] query glass that is not filled yet
                {2,          1,  1,     0.5}, //[example2] query partially filled glass
                {100000009, 33, 17,     1.0}, //[example3] query overfilled glass
                {25,         6,  1, 0.18750}  //query partially filled glass when we have empty sources mixed in
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int poured, int query_row, int query_glass, double expected) {

        long startTime = System.nanoTime();
        double actual = new ChampagneTower().champagneTower(poured, query_row, query_glass);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
