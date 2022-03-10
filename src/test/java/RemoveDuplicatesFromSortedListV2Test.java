import extras.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class RemoveDuplicatesFromSortedListV2Test {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode list2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode list3 = new ListNode(1, new ListNode(1));
        ListNode list4 = new ListNode(1, new ListNode(2, new ListNode(2)));
        return new Object[][]{
                {list1, new ListNode(1, new ListNode(2, new ListNode(5)))}, //[example1]
                {list2, new ListNode(2, new ListNode(3))                     }, //[example2]
                {null,  null                                                         }, //edge - empty list
                {list3, null                                                         }, //non-empty list with same values
                {list4, new ListNode(1)                                          }  //duplicates at the end
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode head, ListNode expected) {
        long startTime = System.nanoTime();
        ListNode actual = new RemoveDuplicatesFromSortedListV2().deleteDuplicates(head);
        long endTime = System.nanoTime();

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
    }
}
