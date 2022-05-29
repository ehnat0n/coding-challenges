public class NumberOfStepsToReduceANumberToZero {

    /*
    Given an integer num, return the number of steps to reduce it to zero.

    In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

    Constraints:

    0 <= num <= 10^6
     */

    //T/S: O(log(num))/O(1)
    public int numberOfSteps(int num) {
        if (num == 0) return num;

        int count = 0;
        while (num > 1) {
            if ((num & 1) == 1) count += 2;
            else count++;
            num >>= 1;
        }
        return count + 1;
    }
}
