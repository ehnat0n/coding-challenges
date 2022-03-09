import extras.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    /*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
    connected to. Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.

    Constraints:

    The number of the nodes in the list is in the range [0, 10^4].
    -10^5 <= Node.val <= 10^5
    pos is -1 or a valid index in the linked-list.
     */

    //Floyd cycle detection (hare/tortoise)
    //T/S: O(n)/O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode hare = head;
        ListNode tortoise = head;
        while (hare.getNext() != null && hare.getNext().getNext() != null) {
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
            if (hare == tortoise) return true;
        }
        return false;
    }

    //T/S: O(n)/O(n)
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.getNext();
        }
        return false;
    }
}
