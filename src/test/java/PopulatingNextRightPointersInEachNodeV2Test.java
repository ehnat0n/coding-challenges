import extras.TreeNodeN;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PopulatingNextRightPointersInEachNodeV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        TreeNodeN tn1 = new TreeNodeN(1, new TreeNodeN(2, new TreeNodeN(4), new TreeNodeN(5), null), new TreeNodeN(3, null, new TreeNodeN(7), null), null);
        TreeNodeN node7 = new TreeNodeN(7);
        TreeNodeN node3 = new TreeNodeN(3, null, node7, null);
        TreeNodeN node5 = new TreeNodeN(5, null, null, node7);
        TreeNodeN node4 = new TreeNodeN(4, null, null, node5);
        TreeNodeN node2 = new TreeNodeN(2, node4, node5, node3);
        TreeNodeN exp1 = new TreeNodeN(1, node2, node3, null);
        return new Object[][]{
                {tn1,  exp1}, //[example1]
                {null, null}  //[example2]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(TreeNodeN root, TreeNodeN expected) {
        long startTime, endTime;
        TreeNodeN actual;

        startTime = System.nanoTime();
        actual = new PopulatingNextRightPointersInEachNodeV2().connect(root);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertTrue(isTheSameTree(actual, expected));
    }

    private boolean isTheSameTree(TreeNodeN actual, TreeNodeN expected) {
        if (actual == null) return expected == null;
        else if (expected == null) return false;

        if (actual.getValue() != expected.getValue()) return false;
        return (isTheSameTree(actual.getLeftNode(), expected.getLeftNode()) &&
                isTheSameTree(actual.getRightNode(), expected.getRightNode()) &&
                isTheSameTree(actual.getNextNode(), expected.getNextNode()));
    }
}
