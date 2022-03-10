import extras.ListNode;

public class RemoveDuplicatesFromSortedListV2 {

    /*
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
    leaving only distinct numbers from the original list. Return the linked list sorted as well.

    Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.getNext() == null) return head;

        ListNode zeroNode = new ListNode(head.getValue() - 1, head);
        ListNode endCandidate = head;
        ListNode end = zeroNode;
        ListNode tracker = head.getNext();
        boolean isDuplicate = false;
        while (tracker != null) {
            if (tracker.getValue() != endCandidate.getValue()) {
                if (!isDuplicate) {
                    end = endCandidate;
                } else {
                    end.setNext(tracker);
                    isDuplicate = false;
                }
                endCandidate = tracker;
            } else {
                isDuplicate = true;
            }
            tracker = tracker.getNext();
        }
        if (isDuplicate) end.setNext(null);
        return zeroNode.getNext();
    }
}
