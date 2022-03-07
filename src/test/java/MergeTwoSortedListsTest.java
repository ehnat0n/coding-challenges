import extras.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class MergeTwoSortedListsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode expectedList = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))));
        return new Object[][]{
                {list1, list2,               expectedList       }, //[example1]
                {null,  null,                null               }, //two empty lists
                {null,  new ListNode(0), new ListNode(0)}  //one empty list
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode list1, ListNode list2, ListNode expected) {
        long startTime = System.nanoTime();
        ListNode actual = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
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
