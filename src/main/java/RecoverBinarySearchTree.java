import extras.TreeNode;

public class RecoverBinarySearchTree {

    /*
    You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree
    were swapped by mistake. Recover the tree without changing its structure.

    Constraints:

    The number of nodes in the tree is in the range [2, 1000].
    -2^31 <= Node.val <= 2^31 - 1
     */
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);

        int temp = first.getValue();
        first.setVal(second.getValue());
        second.setVal(temp);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;

        inOrderTraversal(node.getLeftNode());

        boolean drop = node.getValue() < prev.getValue();
        if ((first == null) && drop) first = prev;
        if (drop) second = node;
        prev = node;

        inOrderTraversal(node.getRightNode());
    }
}
