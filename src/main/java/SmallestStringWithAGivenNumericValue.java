public class SmallestStringWithAGivenNumericValue {

    /*
    The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet,
    so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.

    The numeric value of a string consisting of lowercase characters is defined as the sum of its characters'
    numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.

    You are given two integers n and k. Return the lexicographically smallest string with length equal to
    n and numeric value equal to k.

    Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is,
    either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.

    Constraints:

    1 <= n <= 10^5
    n <= k <= 26 * n
     */

    /*
    Easier (but slower) way is to fill array with 'a', reduce k by n and then just "top off" slots starting from the right using mod 25.
    In this case we have to do branching for 3 cases (starting on the right):
        - k still >= 26 after leaving 1 for all slots, but current one
        - k less than 26, but bigger than 'a' - we do unique letter in this slot
        - rest of the slots fill with 'a' for value 1
     */
    public String getSmallestString(int n, int k) {
        char[] letters = new char[n];
        int pos = n - 1;
        while (k > 0) {
            if (k - pos >= 26) {
                letters[pos--] = 'z';
                k -= 26;
            } else if (k - pos > 1) {
                letters[pos] = (char)('a' + k - pos - 1);
                k = pos;
                pos--;
            } else {
                letters[pos--] = 'a';
                k--;
            }
        }
        return new String(letters);
    }
}
