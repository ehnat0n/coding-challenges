public class DivideTwoIntegers {

    /*
    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

    The integer division should truncate toward zero, which means losing its fractional part.
    For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

    Return the quotient after dividing dividend by divisor.

    Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
    [−2^31, 2^31 − 1]. For this problem, if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1,
    and if the quotient is strictly less than -2^31, then return -2^31.

    Constraints:

    -2^31 <= dividend, divisor <= 2^31 - 1
    divisor != 0
     */

    // T/S: O(log(dividend))/O(1)
    public int divide(int dividend, int divisor) {
        //determine the sign for final answer
        boolean negative = (dividend < 0) ^ (divisor < 0);

        /*
        Convert to negative absolute values since it's easier to handle situations with 'MIN_VALUE' as a dividend.
        Edge case 'MIN_VALUE/-1' for example.
        Note: -abs(Integer.MIN_VALUE) is still Integer.MIN_VALUE
         */
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int quotient = 0;
        int power = 0;
        /*
        Use the idea that 'dividend = divisor * quotient + remainder', where quotient can be represented by powers of 2
        (bits in integer number: 2^k + 2^k-1 + ... + 2^0) and remainder < divisor.
        We are looking for highest one bit in quotient first.
        Make sure we don't shift left after passing 'MIN_VALUE >> 1' (half way to MIN_VALUE) even if divisor is still
        higher than dividend. It would produce incorrect number and there is no need since dividend is definitely >= MIN_VALUE -
        therefore it's the last shift anyway.
         */
        while ((divisor >= dividend) && (divisor >= (Integer.MIN_VALUE >> 1))) {
            divisor <<= 1;
            power++;
        }
        /*
        Now deducting chunks starting with the highest bit (power of two) we found for the quotient. Then iterate down
        to check for all other less significant bits.
        And we use '-' since operating in negative range.
         */
        while (power >= 0) {
            if (divisor >= dividend) {
                quotient -= (1 << power); //set the bit for this power of 2 in quotient
                dividend -= divisor;
            }
            divisor >>= 1;
            power--;
        }
        /*
        We do get negative quotient at the end - return as is if supposed to be negative.
        Otherwise, need to account for edge case 'MIN_VALUE / -1' which is going to overflow past MAX_VALUE, so we limit it.
         */
        return negative ? quotient :
                         (quotient == Integer.MIN_VALUE ? Integer.MAX_VALUE : -quotient);
    }
}
