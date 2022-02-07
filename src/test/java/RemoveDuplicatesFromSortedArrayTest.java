import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RemoveDuplicatesFromSortedArrayTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
            {new int[]{1,1,2},               new int[]{1,2}      }, //[example1] minimal duplicate, duplicate at start
            {new int[]{0,0,1,1,1,2,3,3,3,4}, new int[]{0,1,2,3,4}}, //[example2] multiple duplicates
            {new int[]{},                    new int[]{}         }, //edge case, empty array
            {new int[]{1},                   new int[]{1}        }, //edge case, one element array
            {new int[]{1,2,3},               new int[]{1,2,3}    }, //all unique
            {new int[]{1,2,2},               new int[]{1,2}      }  //duplicate at the end
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int[] expectedNums) {
        long startTime = System.nanoTime();
        int k = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        long endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(k, expectedNums.length);
        for (int i = 0; i < k; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }
}