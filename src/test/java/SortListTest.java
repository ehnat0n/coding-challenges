import extras.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class SortListTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        ListNode list1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode expected1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode list2 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode expected2 = new ListNode(-1, new ListNode(0, new ListNode(3, new ListNode(4, new ListNode(5)))));

        return new Object[][]{
                {list1, expected1}, //[example1]
                {list2, expected2}, //[example2]
                {null, null} //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode original, ListNode expected) {
        System.out.println("Test case: " + new SortList().printList(original));
        ListNode clone = new SortList().cloneList(original);

        long startTime = System.nanoTime();
        ListNode actual1 = new SortList().sortList(original);
        long endTime1 = System.nanoTime();
        ListNode actual2 = new SortList().sortList2(clone);
        long endTime2 = System.nanoTime();

        System.out.println("Solution1 run time: " + (endTime1 - startTime) / 1000000d + " milliseconds.");
        System.out.println("Solution2 run time: " + (endTime2 - endTime1) / 1000000d + " milliseconds.");
        System.out.println();

        checkEqual(actual1, expected);
        checkEqual(actual2, expected);
    }

    private void checkEqual(ListNode result, ListNode expected) {
        if (expected != null) {
            while (expected.getNext() != null && result.getNext() != null) {
                assertEquals(expected.getValue(), result.getValue());
                expected = expected.getNext();
                result = result.getNext();
            }
            assertNull(expected.getNext());
            assertNull(result.getNext());
        } else assertNull(result);
    }
}
