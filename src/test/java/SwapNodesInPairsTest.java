import extras.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class SwapNodesInPairsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {null,                               null}, //[example2] edge - null value
                {new ListNode(1), new ListNode(1)}, //[example3] edge - one element

                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))),
                        new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(3))))}, //[example1] two pairs - even number of elements

                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                        new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(5)))))} //odd number of elements
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode head, ListNode expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        ListNode actual = new SwapNodesInPairs().swapPairs(head);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        if (expected != null) {
            while (expected.getNext() != null && actual.getNext() != null) {
                assertEquals(expected.getValue(), actual.getValue());
                expected = expected.getNext();
                actual = actual.getNext();
            }
            assertNull(expected.getNext());
            assertNull(actual.getNext());
        } else assertNull(actual);
        System.out.println();
    }
}
