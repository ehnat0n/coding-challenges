import extras.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class AddTwoNumbersTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result1 = new ListNode(7, new ListNode(0, new ListNode(8)));

        ListNode list3 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode list4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result2 = new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))));

        ListNode list5 = new ListNode(9);
        ListNode list6 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode result3 = new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1)))))))))));
        return new Object[][]{
                {list1,               list2,               result1            }, //[example1]
                {new ListNode(0), new ListNode(0), new ListNode(0)}, //[example2] edge - zero numbers, zero result
                {list3,               list4,               result2            }, //[example3]
                {list5,               list6,               result3            }  //out of range for integer if using digit order
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode l1, ListNode l2, ListNode expected) {
        long startTime = System.nanoTime();
        ListNode actual = new AddTwoNumbers().addTwoNumbers(l1, l2);
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
