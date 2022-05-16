import extras.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeepestLeavesSumTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
        TreeNode root2 = new TreeNode(6, new TreeNode(7, new TreeNode(2, new TreeNode(9), null), new TreeNode(7, new TreeNode(1), new TreeNode(4))), new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))));
        return new Object[][]{
                {root1, 15}, //[example1]
                {root2, 19}  //[example2]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNode root, int expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int result = new DeepestLeavesSum().deepestLeavesSum(root);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);

        System.out.println();
    }
}
