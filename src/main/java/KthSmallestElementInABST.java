import extras.TreeNode;

public class KthSmallestElementInABST {

    /*
    Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed)
    of all the values of the nodes in the tree.

    Constraints:

    The number of nodes in the tree is n.
    1 <= k <= n <= 10^4
    0 <= Node.val <= 10^4
     */
    private int counter;
    private int val = -1;

    public int kthSmallest(TreeNode root, int k) {
        counter = k;
        traverseBST(root);
        return val;
    }

    private void traverseBST(TreeNode node) {
        if ((node == null) || (counter <= 0)) return;
        traverseBST(node.getLeftNode());
        if (--counter == 0) {
            val = node.getValue();
            return;
        }
        traverseBST(node.getRightNode());
    }
}
