import extras.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IntersectionOfTwoLinkedListsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        ListNode tail1 = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode tail2 = new ListNode(2, new ListNode(4));
        return new Object[][]{
                {new ListNode(4, new ListNode(1, tail1)),
                 new ListNode(5, new ListNode(6, new ListNode(1, tail1))),
                 tail1}, //[example1]

                {new ListNode(1, new ListNode(9, new ListNode(1, tail2))),
                 new ListNode(3, tail2),
                 tail2}, //[example2]

                {new ListNode(2, new ListNode(6, new ListNode(4))),
                 new ListNode(1, new ListNode(5)),
                 null}   //[example3]
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode headA, ListNode headB, ListNode expected) {
        long startTime, endTime;
        ListNode actual;

        startTime = System.nanoTime();
        actual = new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headB);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
    }
}
