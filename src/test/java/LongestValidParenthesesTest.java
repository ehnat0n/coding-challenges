import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LongestValidParenthesesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"(()",    2}, //[example1]
                {")()())", 4}, //[example2]
                {"",       0}, //[example3]
                {"()())",  4}, //
                {"(((((",  0}, //
                {")))))",  0}, //
                {"()()()", 6}, //
                {")(",     0}, //
                {")",      0}, //
                {"(",      0}, //
                {")()()(", 4}, //
                {")()()",  4}, //
                {"()(())", 6}  // two groups, one has nested group inside
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new LongestValidParentheses().longestValidParentheses(s);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
