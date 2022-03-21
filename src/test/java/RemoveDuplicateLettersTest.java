import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveDuplicateLettersTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"bcabc",    "abc" }, //[example1]
                {"cbacdcbc", "acdb"}, //[example2]
                {"a",        "a"   }, //edge
                {"bbcaac",   "bac" }  //consequent duplicates
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, String expected) {
        long startTime, endTime;
        String actual;

        startTime = System.nanoTime();
        actual = new RemoveDuplicateLetters().removeDuplicateLetters(s);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
