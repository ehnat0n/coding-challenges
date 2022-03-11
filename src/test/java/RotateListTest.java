import extras.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class RotateListTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result1 = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(2, new ListNode(3)))));

        ListNode list2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode result2 = new ListNode(2, new ListNode(0, new ListNode(1)));

        return new Object[][]{
                {list1,                2, result1            }, //[example1]
                {list2,                4, result2            }, //[example2]
                {null,                10, null               }, //edge - zero nodes, rotation gives nothing
                {new ListNode(0), 10, new ListNode(0)}, //edge - one element, rotation gives nothing
                {list1,                0, list1              }  //edge - zero rotations - no action needed
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode list, int k, ListNode expected) {
        long startTime = System.nanoTime();
        ListNode actual = new RotateList().rotateRight(list, k);
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
