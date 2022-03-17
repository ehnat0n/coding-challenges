import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinimumRemoveToMakeValidParenthesesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"lee(t(c)o)de)", "lee(t(c)o)de"}, //[example1]
                {"a)b(c)d",       "ab(c)d"      }, //[example2]
                {"))((",          ""            }  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, String expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        String actual = new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
