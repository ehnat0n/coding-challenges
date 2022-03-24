public class BrokenCalculator {

    /*
    There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:

    - multiply the number on display by 2, or
    - subtract 1 from the number on display.

    Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

    Constraints:

    1 <= x, y <= 10^9
     */
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target) return startValue - target;
        int result = ((target % 2) == 0) ? brokenCalc(startValue, target / 2) : brokenCalc(startValue, target + 1);
        return result + 1;
    }
}
