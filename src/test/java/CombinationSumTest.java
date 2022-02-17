import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CombinationSumTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        Map<Integer, Integer> map1_1 = new HashMap<>();
        map1_1.put(2,2);
        map1_1.put(3,1);
        Map<Integer, Integer> map1_2 = new HashMap<>();
        map1_2.put(7,1);
        Map<Integer, Integer> map2_1 = new HashMap<>();
        map2_1.put(2,4);
        Map<Integer, Integer> map2_2 = new HashMap<>();
        map2_2.put(2,1);
        map2_2.put(3,2);
        Map<Integer, Integer> map2_3 = new HashMap<>();
        map2_3.put(3,1);
        map2_3.put(5,1);
        return new Object[][]{
                {new int[]{2,3,6,7},      7, Set.of(map1_1, map1_2)        }, //[example1] target = one of the candidates
                {new int[]{2,3,5},        8, Set.of(map2_1, map2_2, map2_3)}, //[example2] target is a multiple of the same candidate
                {new int[]{2},            1, Set.of()                      }  //[example3] edge case - min length, no solution
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(int[] candidates, int target, Set<Map<Integer, Integer>> expected) {
        long startTime, endTime;

        startTime = System.nanoTime();
        List<List<Integer>> actual = new CombinationSum().combinationSum(candidates, target);
        endTime = System.nanoTime();
        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");

        //converting to Sets since answer can be given in any order
        Set<Map<Integer,Integer>> actualSet = new HashSet<>();
        for (List<Integer> list : actual) {
            Map<Integer,Integer> map = new HashMap<>();
            for (Integer num : list) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            actualSet.add(map);
        }

        assertEquals(actualSet.size(), expected.size());
        for (Map<Integer, Integer> solution : expected) {
            assertTrue(actualSet.contains(solution));
        }
    }
}
