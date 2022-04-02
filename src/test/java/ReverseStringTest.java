import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ReverseStringTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new char[]{'h','e','l','l','o'},     "olleh" }, //[example1]
                {new char[]{'H','a','n','n','a','h'}, "hannaH"}, //[example2]
                {new char[]{'a'},                     "a"     }  //edge - min entry
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(char[] s, String expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        new ReverseString().reverseString(s);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(new String(s), expected);

        System.out.println();
    }
}
