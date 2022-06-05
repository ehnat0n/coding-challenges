import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NQueensTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {4, List.of(List.of(".Q..","...Q","Q...","..Q."), List.of("..Q.","Q...","...Q",".Q.."))}, //[example1]
                {1, List.of(List.of("Q"))}, //[example2] - one solution
                {2, new ArrayList<>()} //no solutions
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int n, List<List<String>> expected) {
        long startTime, endTime;
        List<List<String>> actual;

        startTime = System.nanoTime();
        actual = new NQueens().solveNQueens(n);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
