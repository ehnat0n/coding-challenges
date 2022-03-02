public class CountingBits {

    /*
    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
    ans[i] is the number of 1's in the binary representation of i.

    Constraints:

    0 <= n <= 10^5
     */

    /*
    Based on observation that every even number n is n/2 number shifted left with identical pattern.
    Odd number is previous even + 1.
    O(n)/O(n)
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) result[i] = result[i / 2];
            else result[i] = result[i - 1] + 1;
        }
        return result;
    }

    /*
    Here we reset last 1-bit to 0, can also simply shift right >> and count 1-bits at the end.
    O(n*logn)/O(n)
     */
    public int[] countBits2(int n) {
        int[] result = new int[n + 1];
        int count;
        int num;
        for (int i = 1; i <= n; i++) {
            count = 0;
            num = i;
            while (num > 0) {
                num &= num - 1;
                count++;
            }
            result[i] = count;
        }

        return result;
    }
}
