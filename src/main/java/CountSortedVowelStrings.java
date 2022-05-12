public class CountSortedVowelStrings {

    /*
    Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u)
    and are lexicographically sorted.

    A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

    Constraints:

    1 <= n <= 50
     */
    public int countVowelStrings(int n) {
        int a, e, i, o, u;
        a = e = i = o = u = 1;

        /*
        Pattern:
        a = a + e + i + o + u;
        e = e + i + o + u;
        i = i + o + u;
        o = o + u;
        u = u;
         */
        for (int t = 1; t < n; t++) {
            o = o + u;
            i = i + o;
            e = e + i;
            a = a + e;
        }
        return a + e + i + o + u;
    }
}
