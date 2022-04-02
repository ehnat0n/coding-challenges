public class ReverseString {

    /*
    Write a function that reverses a string. The input string is given as an array of characters s.
    You must do this by modifying the input array in-place with O(1) extra memory.

    Constraints:

    1 <= s.length <= 10^5
    s[i] is a printable ascii character.
     */
    public void reverseString(char[] s) {
        int len = s.length;
        char temp;
        for (int i = 0; i < len / 2; i++) {
            temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }
}
