import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CountAllValidPickupAndDeliveryOptionsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {1,         1}, //[example1]
                {2,         6}, //[example2]
                {3,        90}, //[example3]
                {4,      2520}, // guess - (2n)! / 2^n
                {8, 729647433}  // getting out of int range here - need long before taking modulo
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int n, int expected) {

        long startTime = System.nanoTime();
        int actual = new CountAllValidPickupAndDeliveryOptions().countOrders(n);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
