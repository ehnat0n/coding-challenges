import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveAllAdjacentDuplicatesInStringV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"abcd",                 2, "abcd"}, //[example1]
                {"deeedbbcccbdaa",       3,   "aa"}, //[example2]
                {"pbbcggttciiippooaais", 2,   "ps"}, //[example3]
                {"a",                    2,    "a"}, //edge - min length
                {"aa",                   2,     ""}, //edge - min length with deletion
                {"aaa",                  2,    "a"}  // count % k != 0
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, int k, String expected) {
        long startTime, endTime;
        String actual;

        startTime = System.nanoTime();
        actual = new RemoveAllAdjacentDuplicatesInStringV2().removeDuplicates(s, k);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
