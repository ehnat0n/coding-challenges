import extras.ListNode; //support class from extras


public class MergeKSortedLists {

    /*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

    Merge all the linked-lists into one sorted linked-list and return it.

    Constraints:

    k == lists.length
    0 <= k <= 10^4
    0 <= lists[i].length <= 500
    -10^4 <= lists[i][j] <= 10^4
    lists[i] is sorted in ascending order.
    The sum of lists[i].length won't exceed 10^4.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode finalList = null;

        boolean changed;
        ListNode currentList;
        do {
            changed = false;
            for (int i = 0; i < lists.length; i++) {
                currentList = lists[i];
                if (currentList != null) {
                    finalList = insertNode(currentList, finalList); //returning refreshed list (could be new first node)
                    lists[i] = currentList.getNext(); //jumping to next node for this list
                    changed = true;
                }
            }
        } while (changed);
        return finalList;
    }

    private ListNode insertNode(ListNode listToProcess, ListNode finalList) {
        ListNode newNode = new ListNode(listToProcess.getValue());
        if (finalList == null) return newNode;
        if (newNode.getValue() < finalList.getValue()) {
            newNode.setNext(finalList);
            return newNode;
        }

        ListNode prevNode = finalList;
        ListNode curNode = prevNode.getNext();
        while (curNode != null) {
            if (newNode.getValue() < curNode.getValue()) {
                newNode.setNext(curNode);
                break;
            }
            prevNode = curNode;
            curNode = curNode.getNext();
        }
        prevNode.setNext(newNode);
        return finalList;
    }
}
