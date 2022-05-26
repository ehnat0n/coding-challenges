import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {

    /*
    You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

    One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

    Return the maximum number of envelops you can Russian doll (i.e., put one inside the other).

    Note: You cannot rotate an envelope.

    Constraints:

    1 <= envelopes.length <= 10^5
    envelopes[i].length == 2
    1 <= wi, hi <= 10^5
     */
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len == 1) return 1;

        /*
        Key idea: sort array in ascending order for width and the problem becomes 'Longest Subsequence for height'.
        If envelop comes with higher index - it means it can potentially hold all below it unless their width is exactly the same.
        In this case we want height to be sorted in descending order - it makes every entry with matching width to be
        considered as subsequence of length 1 instead of whole group matching.

        Example: (1,2) - (2,3) (2,4) (2,5) - (3,6) vs (1,2) - (2,5) (2,4) (2,3) - (3,6)
        First option gives LIS of length 5 (wrong) and second option gives answer 3 which is correct.
         */
        Arrays.sort(envelopes, (a,b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));

        List<Integer> sequence = new ArrayList<>();
        sequence.add(envelopes[0][1]);

        int height;
        for (int i = 1; i < len; i++) {
            height = envelopes[i][1];
            if (height > sequence.get(sequence.size() - 1)) sequence.add(height);
            else sequence.set(binarySearch(sequence, height), height);
        }
        return sequence.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int mid;
        int midVal;
        while (left < right) {
            mid = (left + right) / 2;
            midVal = list.get(mid);
            if (midVal == target) return mid;
            else if (midVal < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
