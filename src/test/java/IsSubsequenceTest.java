import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IsSubsequenceTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"abc", "ahbgdc",  true}, //[example1]
                {"axc", "ahbgdc", false}, //[example2]
                {"",    "ahbgdc",  true}, //edge, empty substring
                {"",    "",        true}, //edge, both empty
                {"abc", "",       false}  //edge, empty or shorter string
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, String t, boolean expected) {

        long startTime = System.nanoTime();
        boolean actual = new IsSubsequence().isSubsequence(s, t);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
