import extras.ListNode;

public class SwapNodesInPairs {

    /*
    Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
    modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

    Constraints:

    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null; //no elements

        ListNode pair = head.getNext();
        if (pair == null) return head; //only one element

        swapNextTwoFromThis(head, null); // more than one element - new entry point = pair
        return pair;
    }

    private void swapNextTwoFromThis(ListNode current, ListNode prev) {
        ListNode pair = current.getNext();
        if (pair == null) return; //odd number of elements - stop at the end of the list

        ListNode next = pair.getNext();
        current.setNext(next);
        pair.setNext(current);
        if (prev != null) prev.setNext(pair); // restoring link with previous elements if not a first cycle
        if (next != null) swapNextTwoFromThis(next, current); //even number of elements - stop at the end of the list
    }
}
