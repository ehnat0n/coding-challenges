import extras.ListNode;

public class IntersectionOfTwoLinkedLists {

    /*
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
    If the two linked lists have no intersection at all, return null.

    The test cases are generated such that there are no cycles anywhere in the entire linked structure.

    Note that the linked lists must retain their original structure after the function returns.

    Custom Judge:

    The inputs to the judge are given as follows (your program is not given these inputs):

        - intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
        - listA - The first linked list.
        - listB - The second linked list.
        - skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
        - skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.

    The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your
    program. If you correctly return the intersected node, then your solution will be accepted.

    Constraints:

    The number of nodes of listA is in the m.
    The number of nodes of listB is in the n.
    1 <= m, n <= 3 * 10^4
    1 <= Node.val <= 10^5
    0 <= skipA < m
    0 <= skipB < n
    intersectVal is 0 if listA and listB do not intersect.
    intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
     */

    // T/S: O(n + m)/O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode runnerA = headA;
        ListNode runnerB = headB;

        //calculate the length of given lists
        int m = 0;
        int n = 0;
        while (runnerA != null) {
            m++;
            runnerA = runnerA.getNext();
        }
        while (runnerB != null) {
            n++;
            runnerB = runnerB.getNext();
        }

        //skip head nodes in longer list
        int diff;
        runnerA = headA;
        runnerB = headB;
        if (m >= n) {
            diff = m - n;
            for (int i = 0; i < diff; i++) {
                runnerA = runnerA.getNext();
            }
        } else {
            diff = n - m;
            for (int j = 0; j < diff; j++) {
                runnerB = runnerB.getNext();
            }
        }

        //compare nodes to find the intersection, if it exists
        while (runnerA != null) {
            if (runnerA == runnerB) break;
            runnerA = runnerA.getNext();
            runnerB = runnerB.getNext();
        }
        return runnerA;
    }
}
