import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ValidPalindromeV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"aba",             true}, //[example1]
                {"abca",            true}, //[example2] delete mid
                {"abc",            false}, //[example3] min invalid - 3 letters
                {"a",               true}, //edge - one letter is a palindrome, odd
                {"aa",              true}, //edge - min palindrome with even count
                {"ab",              true}, //edge - min valid entry with deletion
                {"caa",             true}, //delete first
                {"aac",             true}, //delete last
                {"lcupuuffuupucul", true}, // cupu - upucu
                {"acxcybycxcxa",    true}  // cxc - cxcx
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, boolean expected) {
        long startTime, endTime;
        boolean actual;

        startTime = System.nanoTime();
        actual = new ValidPalindromeV2().validPalindrome(s);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
