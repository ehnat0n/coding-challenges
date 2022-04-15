import extras.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TrimABinarySearchTreeTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNode tn1 = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        TreeNode exp1 = new TreeNode(1, null, new TreeNode(2));

        TreeNode tn2 = new TreeNode(3, new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4));
        TreeNode exp2 = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null);
        return new Object[][]{
                {tn1, 1, 2, exp1}, //[example1]
                {tn2, 1, 3, exp2}  //[example2]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNode root, int low, int high, TreeNode expected) {
        long startTime, endTime;
        TreeNode actual;

        startTime = System.nanoTime();
        actual = new TrimABinarySearchTree().trimBST(root, low, high);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertTrue(isTheSameTree(actual, expected));

        System.out.println();
    }

    private boolean isTheSameTree(TreeNode actual, TreeNode expected) {
        if (actual == null) return expected == null;
        else if (expected == null) return false;
        if (actual.getValue() != expected.getValue()) return false;
        return (isTheSameTree(actual.getLeftNode(), expected.getLeftNode()) && isTheSameTree(actual.getRightNode(), expected.getRightNode()));
    }
}
