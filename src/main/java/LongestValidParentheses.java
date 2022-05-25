public class LongestValidParentheses {

    /*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    Constraints:

    0 <= s.length <= 3 * 10^4
    s[i] is '(', or ')'.
     */

    //T/S: O(n)/O(n)
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0) return 0;

        int max = 0;
        int[] dp = new int[len];
        int openBrackets = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (openBrackets > 0) { //guarantees that we have unpaired ( bracket left in cases like (..(..))
                    dp[i] = dp[i - 1] + 2; //either '2' for basic case () or 'previous valid + 2' for ..)) case
                    dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0; //picking up previous valid group value if connected ()()
                    openBrackets--;
                    if (max < dp[i]) max = dp[i];
                }
            } else openBrackets++;
        }
        return max;
    }
}
