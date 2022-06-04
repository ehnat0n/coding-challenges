import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RangeSumQuery2DImmutableTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        List<int[]> regions = new ArrayList<>();
        regions.add(new int[]{2,1,4,3});
        regions.add(new int[]{1,1,2,2});
        regions.add(new int[]{1,2,2,4});
        return new Object[][]{
                {new int[][]{{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}}, regions, new int[]{8,11,12}} //[example1]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] matrix, List<int[]> regions, int[] expected) {
        long startTime, endTime;
        int[] actual = new int[regions.size()];

        startTime = System.nanoTime();
        for (int i = 0; i < regions.size(); i++) {
            int[] rectangle = regions.get(i);
            actual[i] = new RangeSumQuery2DImmutable(matrix).sumRegion(rectangle[0], rectangle[1], rectangle[2], rectangle[3]);
        }
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
