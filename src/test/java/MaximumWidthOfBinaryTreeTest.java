import extras.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaximumWidthOfBinaryTreeTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        TreeNode root2 = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), null);
        TreeNode root3 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root4 = new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null), new TreeNode(2, null, new TreeNode(9, null, new TreeNode(7))));
        return new Object[][]{
                {root1, 4}, //[example1]
                {root2, 2}, //[example2]
                {root3, 2}, //[example3]
                {root4, 8}  //empty middle part that has to be counted
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNode root, int expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int result = new MaximumWidthOfBinaryTree().widthOfBinaryTree(root);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);

        System.out.println();
    }
}
