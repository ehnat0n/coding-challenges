import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ScoreOfParenthesesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"()",         1}, //[example1]
                {"(())",       2}, //[example2]
                {"()()",       2}, //[example3]
                {"(()())(())", 6}  // multiple scores inside - double after sum
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, int expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int actual = new ScoreOfParentheses().scoreOfParentheses(s);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
