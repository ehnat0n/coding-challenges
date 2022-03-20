public class MinimumDominoRotationsForEqualRow {

    /*
    In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino.
    (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

    We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

    Return the minimum number of rotations so that all the values in tops are the same,
    or all the values in bottoms are the same.

    If it cannot be done, return -1.

    Constraints:

    2 <= tops.length <= 2 * 10^4
    bottoms.length == tops.length
    1 <= tops[i], bottoms[i] <= 6
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int min = Integer.MAX_VALUE;
        int numMin;
        for (int num = 1; num <= 6; num++) {
            numMin = getMinForNum(num, tops, bottoms);
            if ((numMin != -1) && (numMin < min)) min = numMin;
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private int getMinForNum(int num, int[] tops, int[] bottoms) {
        int len = tops.length;
        int counterBotTop = 0;
        int counterTopBot = 0;
        int top, bottom;
        for (int i = 0; i < len; i++) {
            top = tops[i];
            bottom = bottoms[i];
            //check if solution exists for this num
            if ((top != num) && (bottom != num)) return -1;
            //if both match the number - nothing happens
            if (top != num) counterBotTop++;
            else if (bottom != num) counterTopBot++;
        }
        return Math.min(counterBotTop, counterTopBot);
    }
}
