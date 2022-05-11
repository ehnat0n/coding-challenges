import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CombinationSumV3Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {3, 7, List.of(List.of(4,2,1))                                }, //[example1]
                {3, 9, List.of(List.of(6,2,1), List.of(5,3,1), List.of(4,3,2))}, //[example2]
                {4, 1, new ArrayList<>()                                      }  //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int k, int n, List<List<Integer>> expected) {
        long startTime, endTime;
        List<List<Integer>> actual;

        startTime = System.nanoTime();
        actual = new CombinationSumV3().combinationSum3(k, n);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
