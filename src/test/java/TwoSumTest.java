import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TwoSumTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{2,7,11,15},   9, new int[]{0,1}}, //[example1] two first
                {new int[]{3,2,4},       6, new int[]{1,2}}, //[example2] two last, not sorted
                {new int[]{3,3},         6, new int[]{0,1}}, //[example2] minimal length, two identical numbers
                {new int[]{2,5,8},      10, new int[]{0,2}}, //two numbers not in order, first and last
                {new int[]{0,-1},       -1, new int[]{0,1}}, //negative numbers and zero
                {new int[]{2,4,1,11,5}, 15, new int[]{1,3}}, //not on the edge, not in order
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] arr, int target, int[] indexes) {
        int[] result = new TwoSum().twoSum(arr, target);

        assertEquals(result[0] + result[1], indexes[0] + indexes[1]);
        assertEquals(arr[result[0]] + arr[result[1]], target);
    }
}
