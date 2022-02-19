import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveKDigitsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"1432219", 3, "1219"}, //[example1] earlier peak - higher priority
                {"10200",   1, "200" }, //[example2] leading zeros after removal of peaks
                {"10",      2, "0"   }, //[example3] trivial - k = length
                {"0",       1, "0"   }, // edge - minimal entry
                {"12",      1, "1"   }, //non descending - remove tail

                {"1020345",  2, "345"  }, // checking zero detection
                {"10020345", 2, "345"  }, // ^
                {"10200345", 2, "345"  }, // ^
                {"1200345",  2, "345"  }, // ^
                {"1230045",  2, "10045"}, // ^

                {"210000000000354",  3, "34" }, // ^
                {"2100000000003504", 3, "304"}, // ^

                {"9",       1, "0"   }, // trivial with min length - should be zeroed out
                {"1000",    1, "0"   }, //can remove all numbers, but lots of zeros after
                {"112",     1, "11"  }, //repeating numbers
                {"10001",   4, "0"   }, //can remove all numbers, first and last digits are non zeros
                {"1432999", 3, "1299"}, //need to remove both early peak and 9 tail
                {"21112",   4, "1"   } // 10001 without zeros
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String num, int k, String expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        String actual = new RemoveKDigits().removeKdigits(num, k);
        endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertEquals(actual, expected);
    }
}
