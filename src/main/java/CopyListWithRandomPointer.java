import extras.NodeR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListWithRandomPointer {

    /*
    A linked list of length n is given such that each node contains an additional random pointer,
    which could point to any node in the list, or null.

    Construct a deep copy of the list. The deep copy should consist of exactly n brand-new nodes,
    where each new node has its value set to the value of its corresponding original node.
    Both the next and random pointer of the new nodes should point to new nodes in the copied list such that
    the pointers in the original list and copied list represent the same list state.
    None of the pointers in the new list should point to nodes in the original list.

    For example, if there are two nodes X and Y in the original list, where X.random --> Y,
    then for the corresponding two nodes x and y in the copied list, x.random --> y.

    Return the head of the copied linked list.

    The linked list is represented in the input/output as a list of n nodes.
    Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
    or null if it does not point to any node.

    Your code will only be given the head of the original linked list.

    Constraints:

    0 <= n <= 1000
    -10^4 <= Node.val <= 10^4
    Node.random is null or is pointing to some node in the linked list.
     */
    public NodeR copyRandomList(NodeR head) {
        if (head == null) return null;
        /*
        Extract indexes for random node links from original list.
        Create new list of appropriate length with identical values, store node links in array.
         */
        int ind = 0;
        Map<NodeR, Integer> oldLinks = new HashMap<>();
        NodeR tracker = head;
        NodeR zeroNode = new NodeR();
        NodeR newTracker = zeroNode;
        NodeR newNode;
        List<NodeR> newLinks = new ArrayList<>();
        while (tracker != null) {
            oldLinks.put(tracker, ind);
            ind++;
            newNode = new NodeR(tracker.getVal());
            newTracker.setNext(newNode);
            newTracker = newTracker.getNext();
            newLinks.add(newTracker);
            tracker = tracker.getNext();
        }

        //setup random links
        tracker = head;
        newTracker = zeroNode.getNext();
        NodeR rnd;
        while (tracker != null) { //should be identical length for both lists
            rnd = tracker.getRandom();
            if (rnd != null) newTracker.setRandom(newLinks.get(oldLinks.get(rnd)));
            tracker = tracker.getNext();
            newTracker = newTracker.getNext();
        }
        return zeroNode.getNext();
    }

    public NodeR copyRandomList2(NodeR head) {
        return deserialize(serialize(head));
    }

    public NodeR deserialize(int[][] list) {
        int len = list.length;
        if (len == 0) return null;

        NodeR zeroNode = new NodeR();
        NodeR tracker = zeroNode;
        NodeR newNode;
        NodeR[] links = new NodeR[len];
        for (int i = 0; i < len; i++) {
            newNode = new NodeR(list[i][0]);
            tracker.setNext(newNode);
            tracker = tracker.getNext();
            links[i] = tracker;
        }
        tracker = zeroNode.getNext();
        int ind;
        for (int[] ints : list) {
            ind = ints[1];
            if (ind == -1) tracker.setRandom(null);
            else tracker.setRandom(links[ind]);
            tracker = tracker.getNext();
        }
        return zeroNode.getNext();
    }

    public int[][] serialize(NodeR head) {
        if (head == null) return new int[][]{};

        int len = 0;
        Map<NodeR, Integer> links = new HashMap<>();
        NodeR tracker = head;
        while (tracker != null) {
            links.put(tracker, len);
            len++;
            tracker = tracker.getNext();
        }
        int[][] result = new int[len][2];
        tracker = head;
        int i = 0;
        NodeR randomLink;
        while (tracker != null) {
            result[i][0] = tracker.getVal();
            randomLink = tracker.getRandom();
            if (randomLink == null) result[i][1] = -1;
            else result[i][1] = links.get(randomLink);
            i++;
            tracker = tracker.getNext();
        }
        return result;
    }
}
