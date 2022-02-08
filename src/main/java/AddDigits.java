public class AddDigits {

    /*
    Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

    Constraints:
    0 <= num <= 2^31 - 1
     */
    public int addDigits(int num) {
        /*
        Using congruence formula for digital root in base B = 10.
        drB(num) = 0, if num = 0;
        drB(num) = 1 + (n - 1) % (B - 1);  --> dr10(num) = 1 + (n - 1) % 9;

        Maybe easier to understand by using derived property: drB(a1 + a2) = drB(drB(a1) + drB(a2))
        And take into account rule of divisibility for 9: if sum of digits is divisible by 9 then the whole number is divisible by 9.
        Then can imagine any number as a sum of the last number down divisible by 9 and remainder: 101 = (99 + 2).
         */
        return 1 + (num - 1) % 9;
    }
}
