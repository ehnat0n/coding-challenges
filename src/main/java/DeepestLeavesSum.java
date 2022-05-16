import extras.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

    /*
    Given the root of a binary tree, return the sum of values of its deepest leaves.

    Constraints:

    The number of nodes in the tree is in the range [1, 10^4].
    1 <= Node.val <= 100
     */


    //DFS
    public int deepestLeavesSum(TreeNode root) {
        int depth = findDepth(root, 0);
        return calculateSum(root, depth, 0, 0);
    }

    private int calculateSum(TreeNode root, int depth, int curDepth, int sum) {
        if (root == null) return sum;
        curDepth++;
        if (depth == curDepth) sum += root.getValue();
        else sum = calculateSum(root.getLeftNode(), depth, curDepth, sum) + calculateSum(root.getRightNode(), depth, curDepth, sum);
        return sum;
    }

    private int findDepth(TreeNode root, int curDepth) {
        if (root == null) return curDepth;
        curDepth++;
        return Math.max(findDepth(root.getLeftNode(), curDepth), findDepth(root.getRightNode(), curDepth));
    }

    //BFS
    public int deepestLeavesSum2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.getValue();
                if (cur.getLeftNode() != null) q.offer(cur.getLeftNode());
                if (cur.getRightNode() != null) q.offer(cur.getRightNode());
            }
        }
        return sum;
    }
}
