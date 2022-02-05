import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import extras.ListNode; //support class from extras

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class MergeKSortedListsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {list1, list2, list3};
        ListNode exampleResult = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6))))))));
        return new Object[][]{
                {lists, exampleResult}, //[example]
                {new ListNode[]{}, null}, //empty array
                {new ListNode[]{null}, null} //array with null list, if not null - will have at least one value
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode[] lists, ListNode expected) {
        long startTime = System.nanoTime();
        ListNode actual = new MergeKSortedLists().mergeKLists(lists);
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
