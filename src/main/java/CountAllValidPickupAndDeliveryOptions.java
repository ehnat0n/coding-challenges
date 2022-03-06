public class CountAllValidPickupAndDeliveryOptions {

    /*
    Given n orders, each order consist in pickup and delivery services.
    Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
    Since the answer may be too large, return it modulo 10^9 + 7.

    Constraints:

    1 <= n <= 500
     */
    public int countOrders(int n) {
        /*
        Imagine all possible pairs: (P1,D1) (P2,D2) ... (Pn, Dn)
        There are 2n elements for n pairs. We can take all possible permutations (2n)!
        They will have both good ones (Px before Dx) and bad ones (Dx before Px) for every pair.
        We can say that we are going to ignore permutations inside individual pair - take only PxDx from two possible options.
        Therefore, final formula to calculate the answer is (2n)! / 2^n.
        2n - means we have n even numbers there - can divide each one by 2.
        (1 * 2 * 3 * 4 * ... * 2n - 1 * 2n) / 2 ^ n ---> 1 * 1 * 3 * 2 * ... * 2n - 1 * n ---> n! * 1 * 3 * 5 * ... * 2n - 1
         */
        long result = 1;
        int m = 1000000007;
        for (int i = 1; i <= n; i++) {
            result *= i * (2L * i - 1); //max value here ~500 000 billions which is still within long range
            result %= m;
        }
        return (int) result;
    }
}
