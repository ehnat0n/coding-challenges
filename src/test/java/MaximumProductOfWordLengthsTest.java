import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaximumProductOfWordLengthsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}, 16}, //[example1]
                {new String[]{"a","ab","abc","d","cd","bcd","abcd"},      4}, //[example2]
                {new String[]{"a","aa","aaa","aaaa"},                     0}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String[] words, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new MaximumProductOfWordLengths().maxProduct(words);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
