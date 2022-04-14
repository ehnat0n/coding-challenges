import extras.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchInABinarySearchTreeTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNode exp1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode tn1 = new TreeNode(4, exp1, new TreeNode(7));

        TreeNode tn2 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        return new Object[][]{
                {tn1, 2, exp1}, //[example1] element found
                {tn2, 5, null}  //[example2] element not found
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNode root, int val, TreeNode expected) {
        long startTime, endTime;
        TreeNode actual;

        startTime = System.nanoTime();
        actual = new SearchInABinarySearchTree().searchBST(root, val);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        assertEquals(actual, expected);

        System.out.println();
    }
}
