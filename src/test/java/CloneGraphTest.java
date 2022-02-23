import extras.Node;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class CloneGraphTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        List<List<Integer>> graphAsList1 = new LinkedList<>();
        List<Integer> node1 = new ArrayList<>();
        node1.add(2);
        node1.add(4);
        graphAsList1.add(node1);
        List<Integer> node2 = new ArrayList<>();
        node2.add(1);
        node2.add(3);
        graphAsList1.add(node2);
        List<Integer> node3 = new ArrayList<>();
        node3.add(2);
        node3.add(4);
        graphAsList1.add(node3);
        List<Integer> node4 = new ArrayList<>();
        node4.add(1);
        node4.add(3);
        graphAsList1.add(node4);

        List<List<Integer>> graphAsList2 = new LinkedList<>();
        List<Integer> node21 = new ArrayList<>();
        graphAsList2.add(node21);

        List<List<Integer>> graphAsList3 = new LinkedList<>();
        List<Integer> node31 = new ArrayList<>();
        node31.add(2);
        graphAsList3.add(node31);
        List<Integer> node32 = new ArrayList<>();
        node32.add(1);
        node32.add(3);
        node32.add(4);
        graphAsList3.add(node32);
        List<Integer> node33 = new ArrayList<>();
        node33.add(2);
        graphAsList3.add(node33);
        List<Integer> node34 = new ArrayList<>();
        node34.add(2);
        node34.add(5);
        graphAsList3.add(node34);
        List<Integer> node35 = new ArrayList<>();
        node35.add(4);
        graphAsList3.add(node35);

        return new Object[][]{
                {graphAsList1}, //[example1] [[2,4],[1,3],[2,4],[1,3]]
                {graphAsList2}, //[example2] [[]] - single element with value 1
                {new LinkedList<>()}, //[example3] - empty graph
                {graphAsList3}  // [[2],[1,3,4],[2],[2,5],[4]]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(List<List<Integer>> expected) {
        System.out.println("Expected graph as list: " + expected);
        Node graphToClone = null;
        if (expected.size() > 0) graphToClone = new CloneGraph().getGraphFromList(expected);

        long startTime = System.nanoTime();
        Node result = new CloneGraph().cloneGraph1(graphToClone);
        long endTime1 = System.nanoTime();
        Node result2 = new CloneGraph().cloneGraph2(graphToClone);
        long endTime2 = System.nanoTime();

        System.out.println("Solution1 run time: " + (endTime1 - startTime) / 1000000d + " milliseconds.");
        List<List<Integer>> actual1 = new CloneGraph().getListFromGraph(result);
        System.out.println("Actual1 graph as list: " + actual1);
        assertEquals(actual1, expected);

        System.out.println("Solution2 run time: " + (endTime2 - endTime1) / 1000000d + " milliseconds.");
        List<List<Integer>> actual2 = new CloneGraph().getListFromGraph(result2);
        System.out.println("Actual2 graph as list: " + actual2);
        assertEquals(actual2, expected);
    }
}
