import extras.TreeNode;

public class ConvertBSTToGreaterTree {

    /*
    Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
    is changed to the original key plus the sum of all keys greater than the original key in BST.

    As a reminder, a binary search tree is a tree that satisfies these constraints:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Constraints:

    The number of nodes in the tree is in the range [0, 10^4].
    -10^4 <= Node.val <= 10^4
    All the values in the tree are unique.
    root is guaranteed to be a valid binary search tree.
     */

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        convertBST(root.getRightNode());
        sum += root.getValue();
        root.setVal(sum);
        convertBST(root.getLeftNode());

        return root;
    }
}
