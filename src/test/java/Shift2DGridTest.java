import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Shift2DGridTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(List.of(9,1,2));
        expected1.add(List.of(3,4,5));
        expected1.add(List.of(6,7,8));
        List<List<Integer>> expected2 = new ArrayList<>();
        expected2.add(List.of(12,0,21,13));
        expected2.add(List.of(3,8,1,9));
        expected2.add(List.of(19,7,2,5));
        expected2.add(List.of(4,6,11,10));
        List<List<Integer>> expected3 = new ArrayList<>();
        expected3.add(List.of(1,2,3));
        expected3.add(List.of(4,5,6));
        expected3.add(List.of(7,8,9));
        return new Object[][]{
                {new int[][]{{1,2,3},{4,5,6},{7,8,9}},                       1, expected1}, //[example1]
                {new int[][]{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}}, 4, expected2}, //[example2]
                {new int[][]{{1,2,3},{4,5,6},{7,8,9}},                       9, expected3}  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] grid, int k, List<List<Integer>> expected) {
        long startTime, endTime;
        List<List<Integer>> actual;

        startTime = System.nanoTime();
        actual = new Shift2DGrid().shiftGrid(grid, k);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
