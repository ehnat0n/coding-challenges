import java.util.Stack;

public class ValidParentheses {

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

    Constraints:

    1 <= s.length <= 10^4
    s consists of parentheses only '()[]{}'.
     */
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                default -> {
                    if (stack.isEmpty() || (c != stack.pop())) return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
