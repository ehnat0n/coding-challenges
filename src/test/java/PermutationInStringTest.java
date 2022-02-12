import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PermutationInStringTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"ab",   "eidbaooo",  true}, //[example1] anagram solution in the middle
                {"ab",   "eidboaoo", false}, //[example2] non-continuous subset - no solution
                {"",     "a",        false}, //edge case - invalid input
                {"a",    "",         false}, //edge case - invalid input
                {"a",    "a",         true}, //minimal length with solution
                {"a",    "b",        false}, //minimal length - no solution
                {"ab",   "b",        false}, //s1 length bigger than s2 - can't be a substring
                {"aaaa", "aaaa",      true}, //identical strings, with non-minimal length
                {"aaa",  "aaaa",      true}, //substring with two overlapping matches
                {"aa",   "aabaa",     true}  //substring with two non-overlapping matches
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String s1, String s2, boolean expected) {
        System.out.println("Data: " + s1 + " - " + s2);

        long startTime = System.nanoTime();
        boolean result = new PermutationInString().checkInclusion(s1, s2);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);

        System.out.println();
    }
}
