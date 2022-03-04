import java.util.*;

public class ChampagneTower {

    /*
    We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses,
    and so on until the 100th row.  Each glass holds one cup of champagne.

    Then, some champagne is poured into the first glass at the top.  When the topmost glass is full,
    any excess liquid poured will fall equally to the glass immediately to the left and right of it.
    When those glasses become full, any excess champagne will fall equally to the left and right of those glasses,
    and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)

    For example, after one cup of champagne is poured, the top most glass is full.
    After two cups of champagne are poured, the two glasses on the second row are half full.
    After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.
    After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses
    are a quarter full.

    Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is
    (both i and j are 0-indexed.)

    Constraints:

    0 <= poured <= 10^9
    0 <= query_glass <= query_row < 100
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0.0;

        /*
        Original big bucket and overfilled glasses later that have all the champagne (could be more than 1).
        It pours on the level below with appropriate flow amount.
         */
        List<Double> fillerRow = new ArrayList<>(List.of((double)poured));
        /*
        Glasses on current level that get overfilled to preserve the correct flow amount.
         */
        List<Double> curRow;

        for (int r = 0; r < query_row; r++) { //iterate only to our query row - no point to do full calculation
            curRow = new ArrayList<>();
            /*
            Amount in first and last glass.
            Taking max with 0 to account for situations when glass above is not filled yet.
            In that case we'd get a negative value in bottom glass.
             */
            Double singleGlass = Math.max(0, (fillerRow.get(0) - 1) / 2);
            curRow.add(singleGlass); //add first

            //fill middle glasses that have two sources each
            for (int i = 1; i < fillerRow.size(); i++) {
                curRow.add(Math.max(0, (fillerRow.get(i - 1) - 1) / 2) + //top left glass
                           Math.max(0, (fillerRow.get(i) - 1) / 2));     //top right glass
            }

            curRow.add(singleGlass); //add last
            fillerRow = curRow;
        }
        return Math.min(1, fillerRow.get(query_glass)); //in case we query "overfilled" glass in the middle of the tower
    }
}
