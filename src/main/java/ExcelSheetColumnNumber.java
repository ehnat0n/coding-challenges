public class ExcelSheetColumnNumber {

    /*
    Given a string columnTitle that represents the column title as appear in an Excel sheet,
    return its corresponding column number.

    Constraints:

    1 <= columnTitle.length <= 7
    columnTitle consists only of uppercase English letters.
    columnTitle is in the range ["A", "FXSHRXW"].
     */


    /*
    Using ascii codes for capital letters: 65-90
    Task comes down to base 26 to base 10 conversion: L1 * B^6 + L2 * B^5 + ... + B * L6 + L7
     */
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int num = columnTitle.charAt(len - 1) - 'A' + 1;
        int result = num;
        int order = 1;
        for (int i = len - 2; i >= 0; i--) {
            num = columnTitle.charAt(i) - 'A' + 1;
            order *= 26;
            result += num * order;
        }
        return result;
    }
}
