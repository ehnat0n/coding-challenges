import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class WordLadderTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        List<String> wordList1 = new ArrayList<>();
        wordList1.add("hot");
        wordList1.add("dot");
        wordList1.add("dog");
        wordList1.add("lot");
        wordList1.add("log");
        wordList1.add("cog");
        List<String> wordList2 = new ArrayList<>();
        wordList2.add("hot");
        wordList2.add("dot");
        wordList2.add("dog");
        wordList2.add("lot");
        wordList2.add("log");
        List<String> wordList3 = new ArrayList<>();
        wordList3.add("hot");
        wordList3.add("dot");
        wordList3.add("lot");
        wordList3.add("cog");
        List<String> wordList4 = new ArrayList<>();
        wordList4.add("dabz");
        wordList4.add("gaby");
        wordList4.add("zabx");
        wordList4.add("daba");
        wordList4.add("gaba");
        wordList4.add("zaba");
        wordList4.add("kobe");
        wordList4.add("vopo");
        wordList4.add("nimi");
        wordList4.add("zaby");
        wordList4.add("koce");
        wordList4.add("loba");
        wordList4.add("lobf");
        wordList4.add("koba");
        wordList4.add("sdgr");
        wordList4.add("lobm");
        wordList4.add("zany");
        wordList4.add("baba");
        wordList4.add("coba");
        return new Object[][]{
                {"hit", "cog",   wordList1, 5}, //[example1] endWord exists with a path, no extra entries
                {"hit", "cog",   wordList2, 0}, //[example2] endWord doesn't exist - no point building
                {"hit", "cog",   wordList3, 0}, //endWord exists with no path
                {"boba", "zany", wordList4, 5}  //endWord exists with a path, extra dead entries. DFS will find a solution, but not the shortest one.
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String start, String end, List<String> list, int expected) {
        System.out.println("Data: " + start + " - " + end);

        List<String> listCopy = new ArrayList<>(list);
        long startTime = System.nanoTime();
        int result = new WordLadder().ladderLength(start, end, list);
        long endTime = System.nanoTime();
        int result2 = new WordLadder().ladderLength2(start, end, listCopy);
        long endTime2 = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(result, expected);

        System.out.println("Solution2 run time: " + (endTime2 - endTime) / 1000000d + " milliseconds.");
        assertEquals(result2, expected);

        System.out.println();
    }
}
