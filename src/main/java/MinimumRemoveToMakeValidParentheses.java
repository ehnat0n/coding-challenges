import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    /*
    Given a string s of '(' , ')' and lowercase English characters.

    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
    parentheses string is valid and return any valid string.

    Formally, a parentheses string is valid if and only if:
        - It is the empty string, contains only lowercase characters, or
        - It can be written as AB (A concatenated with B), where A and B are valid strings, or
        - It can be written as (A), where A is a valid string.

    Constraints:

    1 <= s.length <= 10^5
    s[i] is either'(' , ')', or lowercase English letter.
     */
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        char c;
        for (int i = len - 1; i >= 0; i--) {
            c = sb.charAt(i);
            switch (c) {
                case ')' -> stack.push(i);
                case '(' -> {
                    if (stack.isEmpty()) sb.deleteCharAt(i);
                    else stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            for (Integer ind : stack) sb.deleteCharAt(ind);
        }
        return sb.toString();
    }
}
