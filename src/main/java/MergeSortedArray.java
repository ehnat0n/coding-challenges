public class MergeSortedArray {

    /*
    You are given two integer arrays 'nums1' and 'nums2', sorted in non-decreasing order, and two integers 'm' and 'n',
    representing the number of elements in 'nums1' and 'nums2' respectively.

    Merge 'nums1' and 'nums2' into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array 'nums1'.
    To accommodate this, 'nums1' has a length of 'm + n', where the first 'm' elements denote the elements
    that should be merged, and the last 'n' elements are set to '0' and should be ignored. 'nums2' has a length of 'n'.

    Constraints:

    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -10^9 <= nums1[i], nums2[j] <= 10^9
     */

    /*
    Idea is that if there is nothing to copy from second array - the job is done, since we put result in the first one
    and the space will match.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int res = m + n - 1;
        while (right >= 0) {
            while (left >= 0 && nums1[left] > nums2[right]) {
                nums1[res--] = nums1[left--];
            }
            nums1[res--] = nums2[right--];
        }
    }
}
