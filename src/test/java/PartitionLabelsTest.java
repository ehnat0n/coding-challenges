import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class PartitionLabelsTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"ababcbacadefegdehijhklij", List.of(9,7,8)         }, //[example1]
                {"eccbbbbdec",               List.of(10)            }, //[example2]
                {"e",                        List.of(1)             }, //edge - min length
                {"abcdef",                   List.of(1,1,1,1,1,1)   }, //all singles
                {"aabbcc",                   List.of(2,2,2)         }  //all doubles
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String path, List<Integer> expected) {
        long startTime, endTime;
        List<Integer> actual;

        startTime = System.nanoTime();
        actual = new PartitionLabels().partitionLabels(path);
        endTime = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);

        System.out.println();
    }
}
