import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindTheDifferenceTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"abcd", "abcde", 'e'}, //[example1] no shuffle, new char at the end
                {"",     "y",     'y'}, //[example2] edge case, empty original
                {"abcd", "dcbae", 'e'}, //shuffled, new char at the end
                {"abcd", "edcba", 'e'}, //shuffled, new char at the start
                {"abcd", "dceba", 'e'}  //shuffled, new char in the middle
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, String t, char expected) {
        char result = new FindTheDifference().findTheDifference(s, t);
        assertEquals(result, expected);
    }
}
