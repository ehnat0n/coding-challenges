import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SummaryRangesTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{0,1,2,4,5,7  }, List.of("0->2","4->5","7")    }, //[example1]
                {new int[]{0,2,3,4,6,8,9}, List.of("0","2->4","6","8->9")}, //[example2]
                {new int[]{},              new ArrayList<>()             }, //edge, empty
                {new int[]{1},             List.of("1")                  }, //edge, min for 1 interval
                {new int[]{-1},            List.of("-1")                 }, //edge, single negative
                {new int[]{-3,-2,-1},      List.of("-3->-1")             }, //negative interval
                {new int[]{-1,0,1},        List.of("-1->1")              }, //negative into positive interval
                {new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, List.of("1->20")} //capacity
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, List<String> expected) {
        System.out.println("Input: " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        List<String> actual = new SummaryRanges().summaryRanges(nums);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
