import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ShortestPathVisitingAllNodesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[][]{{1,2,3},{0},{0},{0}}, 4}, //[example1]
                {new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}}, 4}, //[example2]
                {new int[][]{{1,4},{0,3,4,7,9},{6,10},{1,10},{1,0},{6},{7,2,5},{6,1,8},{7},{1},{2,3}}, 12} //time-limit
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] graph, int expected) {
        System.out.println("Initial graph: ");
        for (int[] connections : graph) {
            System.out.println(Arrays.toString(connections));
        }

        long startTime = System.nanoTime();
        int actual1 = new ShortestPathVisitingAllNodes().shortestPathLength(graph);
        long endTime1 = System.nanoTime();
        int actual2 = new ShortestPathVisitingAllNodes().shortestPathLength2(graph);
        long endTime2 = System.nanoTime();

        System.out.println("Solution1 run time: " + (endTime1 - startTime) / 1000000d + " milliseconds.");
        System.out.println("Solution2 run time: " + (endTime2 - endTime1) / 1000000d + " milliseconds.");
        assertEquals(actual1, expected);
        assertEquals(actual2, expected);
    }
}
