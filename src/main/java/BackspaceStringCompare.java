import java.util.Stack;

public class BackspaceStringCompare {

    /*
    Given two strings s and t, return true if they are equal when both are typed into empty text editors.
    '#' means a backspace character.

    Note that after backspacing an empty text, the text will continue empty.

    Constraints:

    1 <= s.length, t.length <= 200
    s and t only contain lowercase letters and '#' characters.
     */

    // T/S: O(n)/O(1)
    public boolean backspaceCompare(String s, String t) {
        int skipS = 0;
        int skipT = 0;
        int lenS = s.length() - 1;
        int lenT = t.length() - 1;
        while ((lenS >= 0) || (lenT >= 0)) {
            while (lenS >= 0) {
                if (s.charAt(lenS) == '#') {
                    skipS++;
                    lenS--;
                } else if (skipS > 0) {
                    skipS--;
                    lenS--;
                } else break;
            }
            while (lenT >= 0) {
                if (t.charAt(lenT) == '#') {
                    skipT++;
                    lenT--;
                } else if (skipT > 0) {
                    skipT--;
                    lenT--;
                } else break;
            }

            if (((lenS >= 0) && (lenT >= 0) && (s.charAt(lenS) != t.charAt(lenT))) || //rightmost legitimate char in both strings doesn't match
                    ((lenS >= 0) ^ (lenT >= 0))) return false; //one string got empty and still chars in second
            lenS--;
            lenT--;
        }
        return true;
    }

    // T/S: O(n)/O(n)
    public boolean backspaceCompare2(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stackS.isEmpty()) stackS.pop();
            }
            else stackS.push(s.charAt(i));
        }
        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) == '#') {
                if (!stackT.isEmpty()) stackT.pop();
            }
            else stackT.push(t.charAt(j));
        }
        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackS.pop() != stackT.pop()) return false;
        }
        return stackS.isEmpty() && stackT.isEmpty();
    }
}
