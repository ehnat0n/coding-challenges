import java.util.Arrays;

public class CoinChange {

    /*
    You are given an integer array coins representing coins of different denominations and an integer amount
    representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.

    Constraints:

    1 <= coins.length <= 12
    1 <= coins[i] <= 2^31 - 1
    0 <= amount <= 10^4
     */

    /*
    Dynamic programming: bottom up.
    T/S: O(amount * coins.length)/O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); //using amount + 1 as invalid value (above possible max)
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
