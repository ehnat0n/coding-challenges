public class BinarySearch {

    /*
    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
    to search target in nums. If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.

    Constraints:

    1 <= nums.length <= 10^4
    -10^4 < nums[i], target < 10^4
    All the integers in nums are unique.
    nums is sorted in ascending order.
     */
    public int search(int[] nums, int target) {
        return myBinarySearch(nums, 0, nums.length - 1, target);
    }

    private int myBinarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        if (start == end) return (nums[start] == target) ? start : -1;

        int mid = start + (end - start + 1) / 2;
        int cur = nums[mid];
        if (cur == target) return mid;
        if (cur < target) return myBinarySearch(nums, mid, end, target);
        else return myBinarySearch(nums, start, mid - 1, target);
    }
}
