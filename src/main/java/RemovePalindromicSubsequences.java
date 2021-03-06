public class RemovePalindromicSubsequences {

    /*
    You are given a string s consisting only of letters 'a' and 'b'. In a single step you can remove one palindromic subsequence from s.

    Return the minimum number of steps to make the given string empty.

    A string is a subsequence of a given string if it is generated by deleting some characters of a given string without changing its order. Note that a subsequence does not necessarily need to be contiguous.

    A string is called palindrome if is one that reads the same backward as well as forward.

    Constraints:

    1 <= s.length <= 1000
    s[i] is either 'a' or 'b'.
     */

    /*
    Problem looks complicated at the first glance, but a few observations can be made:
    - every single letter is a palindrome - answer can't be more than string length and is at least 1 since s.length is >= 1;
    - if the word is a palindrome - you get result in one iteration;
    - any sequence of the same letter is a palindrome (a, aa, aaa...;
    - since we can remove unlimited number of letters - can always remove all entries of the same letter, which gives us
      the answer in 2 step max;

    Essentially, the problem is to check whether the string is a palindrome, but instead of binary true/false or 1/0 answer
    we give 1/2 answer.
     */

    // T/S: O(n)/O(1), n = s.length
    public int removePalindromeSub(String s) {
        if (isPalindrome(s)) return 1;
        else return 2;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
