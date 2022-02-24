import extras.ListNode;

import java.util.PriorityQueue;

public class SortList {

    /*
    Given the head of a linked list, return the list after sorting it in ascending order.

    Constraints:

    The number of nodes in the list is in the range [0, 5 * 10^4].
    -10^5 <= Node.val <= 10^5
     */

    public ListNode sortList(ListNode head) {
        if (head == null || head.getNext() == null) return head;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(head.getValue());
        ListNode curNode = head;
        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
            queue.add(curNode.getValue());
        }

        curNode = head;
        while (queue.size() > 0) {
            curNode.setVal(queue.poll());
            curNode = curNode.getNext();
        }

        return head;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.getNext() == null) return head;
        ListNode splitNode = getSplitNode(head);
        ListNode rightHead = splitNode.getNext();
        splitNode.setNext(null);
        return mergeLists(sortList2(head), sortList2(rightHead));
    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode lead = new ListNode();
        ListNode tracker = lead;
        while ((list1 != null) && (list2 != null)) {
            if (list1.getValue() < list2.getValue()) {
                tracker.setNext(list1);
                list1 = list1.getNext();
            } else {
                tracker.setNext(list2);
                list2 = list2.getNext();
            }
            tracker = tracker.getNext();
        }
        if (list1 != null) tracker.setNext(list1);
        if (list2 != null) tracker.setNext(list2);
        return lead.getNext();
    }

    //split given list in two by using slow/fast pointers
    private ListNode getSplitNode(ListNode head) {
        ListNode last = null;
        ListNode slow = head;
        ListNode fast = head;
        while ((fast != null) && (fast.getNext() != null)) {
            last = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return last;
    }

    public ListNode cloneList(ListNode original) {
        if (original == null) return null;

        ListNode clone = new ListNode(original.getValue());
        ListNode tracker = clone;
        while (original.getNext() != null) {
            original = original.getNext();
            ListNode newNode = new ListNode(original.getValue());
            tracker.setNext(newNode);
            tracker = tracker.getNext();
        }

        return clone;
    }

    public String printList(ListNode list) {
        if (list == null) return "null";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (list.getNext() != null) {
            sb.append(list.getValue()).append(", ");
            list = list.getNext();
        }
        sb.append(list.getValue()).append("]");
        return sb.toString();
    }
}
