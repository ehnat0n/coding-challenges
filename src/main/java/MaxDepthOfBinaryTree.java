import extras.TreeNode;

public class MaxDepthOfBinaryTree {

    /*
    Given the root of a binary tree, return its maximum depth.

    Constraints:

    The number of nodes in the tree is in the range [0, 10^4].
    -100 <= Node.val <= 100
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.getLeftNode()), maxDepth(root.getRightNode())) + 1;
    }
}
