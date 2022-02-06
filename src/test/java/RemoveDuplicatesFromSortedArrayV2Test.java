import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveDuplicatesFromSortedArrayV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {new int[]{1,1,1,2,2,3},       new int[]{1,1,2,2,3}    }, //[example1] one 'deletion' at the start
                {new int[]{0,0,1,1,1,1,2,3,3}, new int[]{0,0,1,1,2,3,3}}, //[example2] double 2+ spots after last 'deletion' - need to move two of the same
                {new int[]{},                  new int[]{}             }, //edge case, empty array
                {new int[]{1},                 new int[]{1}            }, //edge case, one element array
                {new int[]{1,2,3,4,5},         new int[]{1,2,3,4,5}    }, //all unique
                {new int[]{1,2,2,2},           new int[]{1,2,2}        }, //'deletion' at the end
                {new int[]{1,1,2,3,3},         new int[]{1,1,2,3,3}    }, //single in mid, all valid
                {new int[]{1,2,2,3,3},         new int[]{1,2,2,3,3}    }, //single at the start, all valid
                {new int[]{1,1,2,2,3},         new int[]{1,1,2,2,3}    }  //single at the end, all valid
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] nums, int[] expectedNums) {
        long startTime = System.nanoTime();
        int k = new RemoveDuplicatesFromSortedArrayV2().removeDuplicates(nums);
        long endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(k, expectedNums.length);
        for (int i = 0; i < k; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }
}
