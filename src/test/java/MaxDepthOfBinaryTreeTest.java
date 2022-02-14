import extras.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaxDepthOfBinaryTreeTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        return new Object[][]{
                {root1, 3},
                {root2, 2},
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNode root, int expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int result = new MaxDepthOfBinaryTree().maxDepth(root);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);

        System.out.println();
    }
}
