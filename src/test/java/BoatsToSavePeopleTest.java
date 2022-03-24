import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoatsToSavePeopleTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,2},                                         3, 1}, //[example1]
                {new int[]{3,2,2,1},                                     3, 3}, //[example2]
                {new int[]{3,5,3,4},                                     5, 4}, //[example3]
                {new int[]{5,3,4,7},                                   10,  2}, // +1 boat if you go one by one without sorting
                {new int[]{3,8,4,9,2,2,7,1,6,10,6,7,1,7,7,6,4,4,10,1}, 10, 11}  //multiple identical matches - need counts
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] people, int limit, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new BoatsToSavePeople().numRescueBoats(people, limit);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
