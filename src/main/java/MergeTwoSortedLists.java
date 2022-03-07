import extras.ListNode;

public class MergeTwoSortedLists {

    /*
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.

    Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode zeroNode = new ListNode(); //dummy node to save head link
        ListNode result = zeroNode;
        while ((list1 != null) && (list2 != null)) {
            if (list1.getValue() < list2.getValue()) {
                result.setNext(list1);
                list1 = list1.getNext();
            } else {
                result.setNext(list2);
                list2 = list2.getNext();
            }
            result = result.getNext();
        }
        if (list1 == null) result.setNext(list2);
        else result.setNext(list1);
        return zeroNode.getNext();
    }
}
