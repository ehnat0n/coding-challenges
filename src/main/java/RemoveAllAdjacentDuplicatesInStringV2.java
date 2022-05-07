import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringV2 {

    /*
    You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters
    from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

    We repeatedly make k duplicate removals on s until we no longer can.

    Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

    Constraints:

    1 <= s.length <= 10^5
    2 <= k <= 10^4
    s only contains lower case English letters.
     */
    public String removeDuplicates(String s, int k) {
        if (s.length() < k) return s;

        Stack<int[]> charCounts = new Stack<>();
        int[] pair;

        for (char c : s.toCharArray()) {
            if (!charCounts.isEmpty()) {
                pair = charCounts.peek();
                if (pair[0] == c) {
                    if (pair[1] == k - 1) charCounts.pop();
                    else pair[1]++;
                } else charCounts.push(new int[]{c, 1});
            } else charCounts.push(new int[]{c, 1});
        }

        StringBuilder sb = new StringBuilder();
        while (!charCounts.isEmpty()) {
            pair = charCounts.pop();
            sb.append(String.valueOf((char)pair[0]).repeat(pair[1]));
        }
        return sb.reverse().toString();
    }
}
