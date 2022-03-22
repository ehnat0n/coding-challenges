import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SmallestStringWithAGivenNumericValueTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {3, 27, "aay"  }, //[example1]
                {5, 73, "aaszz"}, //[example2]
                {1, 1,  "a"    }, //edge - min entry
                {1, 26, "z"    }, //edge - max single letter
                {3, 3,  "aaa"  }, //min letter only
                {3, 78, "zzz"  }  //max letter only
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int n, int k, String expected) {
        long startTime, endTime;
        String actual;

        startTime = System.nanoTime();
        actual = new SmallestStringWithAGivenNumericValue().getSmallestString(n, k);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
