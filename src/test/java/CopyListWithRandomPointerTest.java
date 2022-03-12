import extras.NodeR;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CopyListWithRandomPointerTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        int[][] list1 = new int[][]{{7,-1}, {13,0}, {11,4}, {10,2}, {1,0}};
        int[][] list2 = new int[][]{{1,1}, {2,1}};
        int[][] list3 = new int[][]{{3,-1}, {3,0}, {3,-1}};

        return new Object[][]{
                {list1        }, //[example1]
                {list2        }, //[example2]
                {list3        }, //[example3]
                {new int[][]{}}  //edge - empty list
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[][] expected) {
        System.out.println("Expected list: ");
        System.out.print("[");
        for (int[] node: expected) System.out.print(Arrays.toString(node) + " ");
        System.out.println("\b]");

        NodeR listToClone = null;
        if (expected.length > 0) listToClone = new CopyListWithRandomPointer().deserialize(expected);

        long startTime = System.nanoTime();
        NodeR result1 = new CopyListWithRandomPointer().copyRandomList(listToClone);
        long endTime1 = System.nanoTime();
        NodeR result2 = new CopyListWithRandomPointer().copyRandomList2(listToClone);
        long endTime2 = System.nanoTime();

        System.out.println("Solution1 run time: " + (endTime1 - startTime) / 1000000d + " milliseconds.");
        int[][] actual1 = new CopyListWithRandomPointer().serialize(result1);
        System.out.println("Actual1 list: ");
        System.out.print("[");
        for (int[] node: actual1) System.out.print(Arrays.toString(node) + " ");
        System.out.println("\b]");
        Assert.assertEquals(actual1, expected);

        System.out.println("Solution2 run time: " + (endTime2 - endTime1) / 1000000d + " milliseconds.");
        int[][] actual2 = new CopyListWithRandomPointer().serialize(result2);
        System.out.println("Actual2 list: ");
        System.out.print("[");
        for (int[] node: actual2) System.out.print(Arrays.toString(node) + " ");
        System.out.println("\b]");
        Assert.assertEquals(actual2, expected);

        System.out.println();
    }
}
