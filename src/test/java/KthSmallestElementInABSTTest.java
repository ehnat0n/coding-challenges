import extras.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KthSmallestElementInABSTTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNode tn1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        TreeNode tn2 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));

        return new Object[][]{
                {tn1, 1, 1}, //[example1]
                {tn2, 3, 3}, //[example2]
                {new TreeNode(5), 1, 5}, //edge, min entry
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNode root, int k, int expected) {
        long startTime, endTime;
        int actual;

        startTime = System.nanoTime();
        actual = new KthSmallestElementInABST().kthSmallest(root, k);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertEquals(actual, expected);

        System.out.println();
    }
}
