import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class LetterCombinationsOfAPhoneNumberTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"23", List.of("ad","ae","af","bd","be","bf","cd","ce","cf")}, //[example1]
                {"",   new ArrayList<>()                                    }, //[example2] edge - empty input - empty output
                {"2",  List.of("a","b","c")                                 }, //[example3]
                {"27", List.of("ap","aq","ar", "as", "bp","bq","br", "bs","cp","cq","cr", "cs")} //4-letter digit
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String digits, List<String> expected) {
        long startTime, endTime;
        List<String> actual;

        startTime = System.nanoTime();
        actual = new LetterCombinationsOfAPhoneNumber().letterCombinations(digits);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
