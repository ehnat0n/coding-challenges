import java.util.Arrays;

public class RemoveCoveredIntervals {

    /*
    Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that
    are covered by another interval in the list.
    The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
    Return the number of remaining intervals.

    Constraints:

    1 <= intervals.length <= 1000
    intervals[i].length == 2
    0 <= li <= ri <= 10^5
    All the given intervals are unique.
     */
    public int removeCoveredIntervals(int[][] intervals) {
        //ascending sort on interval start, unless shared - then it's convenient to have descending order for this subgroup
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int len = intervals.length;
        int count = len;
        int maxEnd = intervals[0][1];
        int curEnd;
        for (int i = 1; i < len; i++) {
            curEnd = intervals[i][1];
            if (curEnd <= maxEnd) count--;
            else maxEnd = curEnd;
        }
        return count;
    }
}
