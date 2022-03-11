import extras.ListNode;

public class RotateList {

    /*
    Given the head of a linked list, rotate the list to the right by k places.

    Constraints:

    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 10^9
     */
    public ListNode rotateRight(ListNode head, int k) {
        //0 rotations or empty list or 1 element list - no action needed
        if (k == 0 || head == null || head.getNext() == null) return head;

        //calculate the length and take k % len to check if we need to do any rotation at all
        int len = 0;
        ListNode tracker = head;
        while (tracker != null) {
            len++;
            tracker = tracker.getNext();
        }
        k = k % len;
        if (k == 0) return head;

        //main rotation part, just find the split point and rearrange the links
        ListNode oldHead = head;
        ListNode preSplit = head;
        tracker = head;
        for (int i = 0; i < len - k; i++) {
            preSplit = tracker;
            tracker = tracker.getNext();
        }
        preSplit.setNext(null);
        head = tracker;
        for (int i = 1; i < k; i++) tracker = tracker.getNext();
        tracker.setNext(oldHead);
        return head;
    }
}
