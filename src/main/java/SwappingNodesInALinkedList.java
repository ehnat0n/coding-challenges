import extras.ListNode;

public class SwappingNodesInALinkedList {

    /*
    You are given the head of a linked list, and an integer k.

    Return the head of the linked list after swapping the values of the kth node from the beginning and
    the kth node from the end (the list is 1-indexed).

    Constraints:

    The number of nodes in the list is n.
    1 <= k <= n <= 10^5
    0 <= Node.val <= 100
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode leftNode = head;
        ListNode rightNode = head;
        ListNode runner;
        for (int i = 1; i < k; i++) leftNode = leftNode.getNext();
        runner = leftNode;
        while (runner.getNext() != null) {
            runner = runner.getNext();
            rightNode = rightNode.getNext();
        }
        int temp = leftNode.getValue();
        leftNode.setVal(rightNode.getValue());
        rightNode.setVal(temp);
        return head;
    }
}
