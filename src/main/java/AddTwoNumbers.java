import extras.ListNode;

public class AddTwoNumbers {

    /*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode zeroNode = new ListNode();
        ListNode resultList = zeroNode;
        int carry = 0;
        int result;
        while (l1 != null || l2 != null) {
            result = 0;
            if (l1 != null) {
                result += l1.getValue();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                result += l2.getValue();
                l2 = l2.getNext();
            }
            result += carry;
            carry = result / 10;
            resultList.setNext(new ListNode(result % 10));
            resultList = resultList.getNext();
        }
        if (carry == 1) resultList.setNext(new ListNode(1));
        return zeroNode.getNext();
    }
}
