import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EncodeAndDecodeTinyURLTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"https://leetcode.com/problems/design-tinyurl"} //[example1]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String url) {
        long startTime, endTime;
        String actual;

        startTime = System.nanoTime();
        EncodeAndDecodeTinyURL codec = new EncodeAndDecodeTinyURL();
        actual = codec.decode(codec.encode(url));
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertEquals(actual, url);
    }
}
