import extras.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class IncreasingOrderSearchTreeTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNode tn1 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9))));
        TreeNode exp1 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7, null, new TreeNode(8, null, new TreeNode(9)))))))));

        TreeNode tn2 = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        TreeNode exp2 = new TreeNode(1, null, new TreeNode(5, null, new TreeNode(7)));

        return new Object[][]{
                {tn1,  exp1}, //[example1]
                {tn2,  exp2}, //[example2]
                {new TreeNode(1), new TreeNode(1)} //edge - one node
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNode root, TreeNode expected) {
        long startTime, endTime;
        TreeNode actual;

        startTime = System.nanoTime();
        actual = new IncreasingOrderSearchTree().increasingBST(root);
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
