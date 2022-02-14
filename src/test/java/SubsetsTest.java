import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class SubsetsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,2,3}, List.of(new ArrayList<>(), List.of(1), List.of(2), List.of(3), List.of(1,2), List.of(1,3), List.of(2, 3), List.of(1,2,3))}, //[example1]
                {new int[]{0}, List.of(new ArrayList<>(), List.of(0))} //[example2]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, List<List<Integer>> expected) {
        System.out.println("Data: " + Arrays.toString(nums));
        long startTime, endTime;

        startTime = System.nanoTime();
        List<List<Integer>> result = new Subsets().subsets(nums);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        Set<List<Integer>> resultSet = new HashSet<>(result);
        Set<List<Integer>> expectedSet = new HashSet<>(expected);
        System.out.println(resultSet);
        System.out.println(expectedSet);
        assertEquals(resultSet, expectedSet);

        System.out.println();
    }
}
