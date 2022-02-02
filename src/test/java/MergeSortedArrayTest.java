import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MergeSortedArrayTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][] {
            {new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6},   3, new int[]{1,2,2,3,5,6}}, //[example1] spread duplicates, m = n
            {new int[]{1},           1, new int[]{},        0, new int[]{1}          }, //[example2] edge case 1-0
            {new int[]{0},           0, new int[]{1},       1, new int[]{1}          }, //[example3] edge case 0-1
            {new int[]{0,0,0,0,0,0}, 3, new int[]{0,0,0},   3, new int[]{0,0,0,0,0,0}}, //all zero
            {new int[]{1,1,3,0,0,0}, 3, new int[]{2,5,5},   3, new int[]{1,1,2,3,5,5}}, //duplicates in one array, duplicates on the edge of the array
            {new int[]{1,3,3,0,0,0}, 3, new int[]{2,2,5},   3, new int[]{1,2,2,3,3,5}}, //duplicates in one array, duplicates on the edge of the array
            {new int[]{2,3,5,6,0,0}, 4, new int[]{1,4},     2, new int[]{1,2,3,4,5,6}}, //unique numbers, m > n
            {new int[]{2,3,0,0,0,0}, 2, new int[]{1,4,5,6}, 4, new int[]{1,2,3,4,5,6}}  //unique numbers, m < n
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums1, int m, int[] nums2, int n, int[] expectedNums) {
        new MergeSortedArray().merge(nums1, m, nums2, n);

        for (int i = 0; i < m + n; i++) {
            assertEquals(nums1[i], expectedNums[i]);
        }
    }
}