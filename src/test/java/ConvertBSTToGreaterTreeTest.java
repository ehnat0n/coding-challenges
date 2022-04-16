import extras.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ConvertBSTToGreaterTreeTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNode tn1 = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        TreeNode exp1 = new TreeNode(30, new TreeNode(36, new TreeNode(36), new TreeNode(35, null, new TreeNode(33))), new TreeNode(21, new TreeNode(26), new TreeNode(15, null, new TreeNode(8))));

        TreeNode tn2 = new TreeNode(0, null, new TreeNode(1));
        TreeNode exp2 = new TreeNode(1, null, new TreeNode(1));

        TreeNode tn3 = new TreeNode(0, null, new TreeNode(-1));
        TreeNode exp3 = new TreeNode(-1, null, new TreeNode(-1));
        return new Object[][]{
                {tn1,  exp1}, //[example1]
                {tn2,  exp2}, //[example2]
                {tn3,  exp3}, //negative sum
                {null, null}, //edge - empty tree
                {new TreeNode(1), new TreeNode(1)} //edge - one node
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNode root, TreeNode expected) {
        long startTime, endTime;
        TreeNode actual;

        startTime = System.nanoTime();
        actual = new ConvertBSTToGreaterTree().convertBST(root);
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
