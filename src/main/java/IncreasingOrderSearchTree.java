import extras.TreeNode;

public class IncreasingOrderSearchTree {

    /*
    Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now
    the root of the tree, and every node has no left child and only one right child.

    Constraints:

    The number of nodes in the given tree will be in the range [1, 100].
    0 <= Node.val <= 1000
     */
    private TreeNode tailNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode zeroNode = new TreeNode();
        tailNode = zeroNode;
        orderTree(root);
        return zeroNode.getRightNode();
    }

    private void orderTree(TreeNode node) {
        if (node == null) return;

        orderTree(node.getLeftNode());
        node.setLeft(null);
        tailNode.setRight(node);
        tailNode = tailNode.getRightNode();
        orderTree(node.getRightNode());
    }
}
