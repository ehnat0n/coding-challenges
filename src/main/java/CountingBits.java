public class CountingBits {

    /*
    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
    ans[i] is the number of 1's in the binary representation of i.

    Constraints:

    0 <= n <= 10^5
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int count;
        int num;
        for (int i = 1; i <= n; i++) {
            count = 0;
            num = i;
            while (num > 0) {
                num &= num - 1; //here we reset last 1-bit to 0, can also simply shift right and count 1-bits at the end
                count++;
            }
            result[i] = count;
        }

        return result;
    }
}
