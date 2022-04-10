import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BaseballGameTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new String[]{"5","2","C","D","+"}, 30}, //[example1]
                {new String[]{"5","-2","4","C","D","9","+","+"}, 27}, //[example2]
                {new String[]{"1"}, 1}, //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String[] ops, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new BaseballGame().calPoints(ops);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
