import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BackspaceStringCompareTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"ab#c", "ad#c",  true}, //[example1]
                {"ab##", "c#d#",  true}, //[example2]
                {"a#c", "b",     false}, //[example3]
                {"#", "##",       true}, //no real chars, but different amount of 'backspace' calls, should be true since 2 empty strings
                {"abcd", "bbcd", false}, //bad code check - it will fail if you use for loop on stack size with stack.pop inside
                {"zabc", "abc",  false}  //unequal length
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, String t, boolean expected) {
        long startTime, endTime;
        boolean actual;

        startTime = System.nanoTime();
        actual = new BackspaceStringCompare().backspaceCompare(s, t);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
