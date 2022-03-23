import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimplifyPathTest {

    @DataProvider(name = "testData")
    public Object[][] createDataObject() {
        return new Object[][]{
                {"/home/",                "/home"    }, //[example1] slash at the end
                {"/../",                  "/"        }, //[example2] .. that does nothing
                {"/home//foo/",           "/home/foo"}, //[example3] double slash
                {"/a/b/../c",             "/a/c"     }, // .. proper skip
                {"/...",                  "/..."     }, // ... = dir name!
                {"/..hidden",             "/..hidden"}, // ..as part of the dir name
                {"/.hidden",              "/.hidden" }, // .as part of the dir name
                {"/.",                    "/"        }, // . proper ignore
                {"/a//b////c/d//././/..", "/a/b/c"   }  //combo
        };
    }

    @Test(dataProvider = "testData")
    public void testSolution(String path, String expected) {
        long startTime, endTime, endTime2;
        String actual, actual2;

        startTime = System.nanoTime();
        actual = new SimplifyPath().simplifyPath(path);
        endTime = System.nanoTime();
        actual2 = new SimplifyPath().simplifyPath2(path);
        endTime2 = System.nanoTime();

        System.out.println("Solution run time: " + (endTime - startTime) / 1000000d + " milliseconds.");
        assertEquals(actual, expected);
        System.out.println("Solution2 run time: " + (endTime2 - endTime) / 1000000d + " milliseconds.");
        assertEquals(actual2, expected);

        System.out.println();
    }
}
