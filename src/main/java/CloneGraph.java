import extras.Node;

import java.util.*;

public class CloneGraph {

    /*
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

    class Node {
        public int val;
        public List<Node> neighbors;
    }

    Test case format:

    For simplicity, each node's value is the same as the node's index (1-indexed).
    For example, the first node with val == 1, the second node with val == 2, and so on.
    The graph is represented in the test case using an adjacency list.

    An adjacency list is a collection of unordered lists used to represent a finite graph.
    Each list describes the set of neighbors of a node in the graph.
    The given node will always be the first node with val = 1.
    You must return the copy of the given node as a reference to the cloned graph.

    Constraints:

    The number of nodes in the graph is in the range [0, 100].
    1 <= Node.val <= 100
    Node.val is unique for each node.
    There are no repeated edges and no self-loops in the graph.
    The Graph is connected and all nodes can be visited starting from the given node.
     */

    public Node cloneGraph1(Node node) {
        if (node == null) return null;
        return getGraphFromList(getListFromGraph(node));
    }

    public Node cloneGraph2(Node node) {
        if (node == null) return null;

        Node newGraph;
        int value = node.getVal();
        newGraph = new Node(value);

        Node[] processed = new Node[100]; //node link storage for future linking, 100 is max by restrictions
        processed[value - 1] = newGraph;

        processNode(node, newGraph, processed);

        return newGraph;
    }

    private void processNode(Node node, Node newNode, Node[] processed) {
        ArrayList<Node> newNeighbors = new ArrayList<>();
        for (Node linkedNode : node.getNeighbors()) {
            int value = linkedNode.getVal();
            if (processed[value - 1] != null) {
                newNeighbors.add(processed[value - 1]);
            } else {
                Node createdNode = new Node(value);
                newNeighbors.add(createdNode);
                processed[value - 1] = createdNode;
                processNode(linkedNode, createdNode, processed);
            }
        }
        newNode.setNeighbors(newNeighbors);
    }

    public List<List<Integer>> getListFromGraph(Node root) {
        List<List<Integer>> nodeList = new LinkedList<>();
        if (root == null) return nodeList;

        Set<Integer> processed = new HashSet<>();
        PriorityQueue<Node> nodesToProcess = new PriorityQueue<>(Comparator.comparingInt(Node::getVal));
        nodesToProcess.add(root);
        processed.add(root.getVal());
        while (!nodesToProcess.isEmpty()) {
            Node node = nodesToProcess.poll();
            int value = node.getVal();
            List<Node> neighbours = node.getNeighbors();
            List<Integer> neighboursAsList = new ArrayList<>();
            for (Node neighbour : neighbours) {
                int nValue = neighbour.getVal();
                neighboursAsList.add(nValue);
                if (!processed.contains(nValue)) {
                    nodesToProcess.add(neighbour);
                    processed.add(nValue);
                }
            }
            nodeList.add(value - 1, neighboursAsList);
        }
        return nodeList;
    }

    public Node getGraphFromList(List<List<Integer>> graphAsList) {
        List<Node> nodeList = new LinkedList<>();
        int nodeCount = graphAsList.size();
        for (int i = 0; i < nodeCount; i++) {
            nodeList.add(new Node(i + 1));
        }
        for (int j = 0; j < nodeCount; j++) {
            List<Integer> nodeNumbers = graphAsList.get(j);
            List<Node> neighbours = new ArrayList<>();
            for (Integer k : nodeNumbers) {
                neighbours.add(nodeList.get(k - 1));
            }
            nodeList.get(j).setNeighbors(neighbours);
        }
        return nodeList.get(0);
    }
}
