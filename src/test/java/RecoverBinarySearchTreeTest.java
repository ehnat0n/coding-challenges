import extras.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RecoverBinarySearchTreeTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNode tn1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        TreeNode exp1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null);

        TreeNode tn2 = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        TreeNode exp2 = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));

        TreeNode tn3 = new TreeNode(5, new TreeNode(3, new TreeNode(-2147483648), new TreeNode(2)), new TreeNode(9));
        TreeNode exp3 = new TreeNode(5, new TreeNode(2, new TreeNode(-2147483648), new TreeNode(3)), new TreeNode(9));
        return new Object[][]{
                {tn1, exp1}, //[example1]
                {tn2, exp2},  //[example2]
                {tn3, exp3},  //edge - min node value present
                {new TreeNode(1, new TreeNode(2), null), new TreeNode(2, new TreeNode(1), null)} //edge - min amount of nodes
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNode root, TreeNode expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        new RecoverBinarySearchTree().recoverTree(root);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertTrue(isTheSameTree(root, expected));

        System.out.println();
    }

    private boolean isTheSameTree(TreeNode actual, TreeNode expected) {
        if (actual == null) return expected == null;
        else if (expected == null) return false;
        if (actual.getValue() != expected.getValue()) return false;
        return (isTheSameTree(actual.getLeftNode(), expected.getLeftNode()) && isTheSameTree(actual.getRightNode(), expected.getRightNode()));
    }
}
