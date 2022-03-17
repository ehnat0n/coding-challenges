public class ScoreOfParentheses {

    /*
    Given a balanced parentheses string s, return the score of the string.

    The score of a balanced parentheses string is based on the following rule:
        - "()" has score 1.
        - AB has score A + B, where A and B are balanced parentheses strings.
        - (A) has score 2 * A, where A is a balanced parentheses string.

    Constraints:

    2 <= s.length <= 50
    s consists of only '(' and ')'.
    s is a balanced parentheses string.
     */
    public int scoreOfParentheses(String s) {
        int len = s.length();
        int score = 0;
        double factor = 0.5;
        char c;
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            if (c == '(') factor *= 2;
            else {
                score += factor;
                factor /= 2;
                while (((i + 1) < len) && (s.charAt(i + 1) == ')')) {
                    factor /= 2;
                    i++;
                }
            }
        }
        return score;
    }
}
