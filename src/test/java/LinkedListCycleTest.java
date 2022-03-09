import extras.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LinkedListCycleTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        ListNode cycleNode12 = new ListNode(-4);
        ListNode cycleNode11 = new ListNode(2, new ListNode(0, cycleNode12));
        cycleNode12.setNext(cycleNode11);
        ListNode list1 = new ListNode(3, cycleNode11);

        ListNode cycleNode22 = new ListNode(2);
        ListNode list2 = new ListNode(1, cycleNode22);
        cycleNode22.setNext(list2);
        return new Object[][]{
                {list1,                true}, //[example1]
                {list2,                true}, //[example2]
                {new ListNode(1), false}, //[example3]
                {null,                false}  //edge - empty list
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(ListNode list, boolean expected) {
        long startTime = System.nanoTime();
        boolean actual = new LinkedListCycle().hasCycle(list);
        long endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");


        assertEquals(actual, expected);
    }
}
