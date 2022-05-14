package extras;

public class TreeNodeN {
    private int val;
    private TreeNodeN left;
    private TreeNodeN right;

    private TreeNodeN next;

    public TreeNodeN() {
    }

    public TreeNodeN(int val) {
        this.val = val;
    }

    public TreeNodeN(int val, TreeNodeN left, TreeNodeN right, TreeNodeN next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public int getValue() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNodeN getLeftNode() {
        return left;
    }

    public TreeNodeN getRightNode() {
        return right;
    }

    public TreeNodeN getNextNode() {
        return next;
    }

    public void setLeft(TreeNodeN left) {
        this.left = left;
    }

    public void setRight(TreeNodeN right) {
        this.right = right;
    }

    public void setNext(TreeNodeN next) {
        this.next = next;
    }
}
