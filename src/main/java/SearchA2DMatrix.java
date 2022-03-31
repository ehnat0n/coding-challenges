public class SearchA2DMatrix {

    /*
    Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
    This matrix has the following properties:

    - Integers in each row are sorted from left to right.
    - The first integer of each row is greater than the last integer of the previous row.

    Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -10^4 <= matrix[i][j], target <= 10^4
     */

    // T/S: O(log m + log n)/O(log m + log n) - recursive stack calls
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if ((target < matrix[0][0]) || (matrix[m - 1][n - 1] < target)) return false;

        //target inside matrix range now
        int rowInd = searchRow(matrix, 0, m - 1, target);
        return myBinarySearch(matrix[rowInd], 0, n - 1, target);
    }

    private boolean myBinarySearch(int[] nums, int start, int end, int target) {
        if (end < start) return false;
        if (end == start) return (nums[end] == target);

        int mid = start + (end - start) / 2;
        int midVal = nums[mid];
        if (target == midVal) return true;
        if (target < midVal) return myBinarySearch(nums, start, mid - 1, target);
        else return myBinarySearch(nums, mid + 1, end, target);
    }

    private int searchRow(int[][] matrix, int start, int end, int target) {
        if (end == start) return end;

        int mid = start + (end - start) / 2; //split left if even number
        int midVal = matrix[mid][0];
        if (target < midVal) return searchRow(matrix, start, mid - 1, target); //target inside matrix range so (mid - 1) call is fine
        else if (target < matrix[mid + 1][0]) return mid;
        else return searchRow(matrix, mid + 1, end, target);
    }
}
