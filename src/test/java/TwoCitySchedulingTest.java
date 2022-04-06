import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TwoCitySchedulingTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{10,20}, {30,200}, {400,50}, {30,20}},                                                    110}, //[example1]
                {new int[][]{{259,770}, {448,54}, {926,667}, {184,139}, {840, 118}, {577,469}},                       1859}, //[example2]
                {new int[][]{{515,563}, {451,713}, {537,709}, {343,819}, {855, 779}, {457,60}, {650, 359}, {631,42}}, 3086}, //[example3]
                {new int[][]{{10,20}, {10,20}, {10,20}, {10,20}},                                                       60}  //same costs
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] costs, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new TwoCityScheduling().twoCitySchedCost(costs);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
