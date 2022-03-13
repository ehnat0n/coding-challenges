import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ValidParenthesesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"()",                       true}, //[example1] min valid
                {"()[]{}",                   true}, //[example2] all types, valid
                {"(]",                      false}, //[example3] min invalid pair
                {"(",                       false}, //odd length - false by default
                {")(",                      false}, //valid pair, wrong order
                {"{(})",                    false}, //valid pairs, proper order for each, but wrong closing order - invalid result
                {"{([])}",                   true}, //valid pairs inside other valid pairs
                {"{[({}])}",                false}, //valid pairs inside other invalid pairs
                {"{{()[]{}",                false}, //even length, but if you use stack - will be non-empty at the end with validation passing
                {"{[({}((()[[({}())]])))]}", true}  //closing and reopening pairs inside other valid pairs
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s, boolean expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        boolean actual = new ValidParentheses().isValid(s);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
