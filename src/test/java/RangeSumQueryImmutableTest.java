import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RangeSumQueryImmutableTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        List<int[]> ranges = new ArrayList<>();
        ranges.add(new int[]{0,2});
        ranges.add(new int[]{2,5});
        ranges.add(new int[]{0,5});
        return new Object[][]{
                {new int[]{-2,0,3,-5,2,-1}, ranges, new int[]{1,-1,-3}} //[example1]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, List<int[]> ranges, int[] expected) {
        long startTime, endTime;
        int[] actual = new int[ranges.size()];

        startTime = System.nanoTime();
        for (int i = 0; i < ranges.size(); i++) {
            int[] range = ranges.get(i);
            actual[i] = new RangeSumQueryImmutable(nums).sumRange(range[0], range[1]);
        }
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
