import extras.TreeNodeN;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeV2 {

    /*
    Given a binary tree, populate each next pointer to point to its next right node. If there is no next right node,
    the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.

    Constraints:

    The number of nodes in the tree is in the range [0, 6000].
    -100 <= Node.val <= 100
     */

    public TreeNodeN connect(TreeNodeN root) {
        if (root == null) return root;

        Queue<TreeNodeN> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNodeN node = q.poll();
                if (i < size - 1) node.setNext(q.peek());
                if (node.getLeftNode() != null) q.add(node.getLeftNode());
                if (node.getRightNode() != null) q.add(node.getRightNode());
            }
        }
        return root;
    }
}
