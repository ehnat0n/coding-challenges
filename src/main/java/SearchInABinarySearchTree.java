import extras.TreeNode;

public class SearchInABinarySearchTree {

    /*
    You are given the root of a binary search tree (BST) and an integer val.

    Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
    If such a node does not exist, return null.
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curNode = root;
        while (curNode != null) {
            if (val == curNode.getValue()) break;
            if (val < curNode.getValue()) curNode = curNode.getLeftNode();
            else curNode = curNode.getRightNode();
        }
        return curNode;
    }
}
