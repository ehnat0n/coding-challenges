import extras.TreeNode;

import java.util.*;

public class MaximumWidthOfBinaryTree {

    //quick Pair implementation to track node index in the tree
    private static class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode node, int num) {
            this.num = num;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int levelSize;
        List<Pair> level;
        Pair p;
        TreeNode left, right;
        int count;
        while (!q.isEmpty()) {
            levelSize = q.size();
            level = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                p = q.poll();
                left = p.node.getLeftNode(); //ok since we only have non-null elements in queue
                right = p.node.getRightNode();
                if (left != null) level.add(new Pair(left, p.num * 2 + 1)); //calculating index based on a parent
                if (right != null) level.add(new Pair(right, p.num * 2 + 2));
            }
            if (level.size() > 0) {
                count = level.get(level.size() - 1).num - level.get(0).num + 1; //index of last level element - first one + 1
                if (count > maxWidth) maxWidth = count;
                q.addAll(level);
            }
        }
        return maxWidth;
    }
}
