import extras.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class SwappingNodesInALinkedListTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expected1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5)))));

        ListNode list2 = new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(3, new ListNode(0, new ListNode(9, new ListNode(5))))))))));
        ListNode expected2 = new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(8, new ListNode(7, new ListNode(3, new ListNode(0, new ListNode(9, new ListNode(5))))))))));

        return new Object[][]{
                {list1,                                    2, expected1                               }, //[example1]
                {list2,                                    5, expected2                               }, //[example2]
                {new ListNode(1),                      1, new ListNode(1)                     }, //edge - single element
                {new ListNode(1, new ListNode(2)), 2, new ListNode(2, new ListNode(1))}  //edge - min swap with 2 elements
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode list, int k, ListNode expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        new SwappingNodesInALinkedList().swapNodes(list, k);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        if (expected != null) {
            while (expected.getNext() != null && list.getNext() != null) {
                assertEquals(expected.getValue(), list.getValue());
                expected = expected.getNext();
                list = list.getNext();
            }
            assertNull(expected.getNext());
            assertNull(list.getNext());
        } else assertNull(list);
    }
}
