import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ValidAnagramTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"anagram", "nagaram", true }, //[example1]
                {"rat",     "car",     false}, //[example2]
                {"a",       "a",       true }, //minimal length
                {"a",       "ab",      false}  //different length - always false
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, String p, boolean expected) {
        boolean result = new ValidAnagram().isAnagram(s, p);
        assertEquals(result, expected);
    }
}
