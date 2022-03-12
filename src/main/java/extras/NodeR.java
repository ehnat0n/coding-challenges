package extras;

public class NodeR {

    private int val;
    private NodeR next;
    private NodeR random;

    public NodeR() {
        this.val = 0;
        this.next = null;
        this.random = null;
    }

    public NodeR(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public NodeR(int val, NodeR next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public NodeR getNext() {
        return next;
    }

    public void setNext(NodeR next) {
        this.next = next;
    }

    public NodeR getRandom() {
        return random;
    }

    public void setRandom(NodeR random) {
        this.random = random;
    }
}
