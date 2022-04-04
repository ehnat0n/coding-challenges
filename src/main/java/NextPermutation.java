public class NextPermutation {

    /*
    A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

    For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].

    The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
    More formally, if all the permutations of the array are sorted in one container according to their lexicographical
    order, then the next permutation of that array is the permutation that follows it in the sorted container.
    If such arrangement is not possible, the array must be rearranged as the lowest possible order
    (i.e., sorted in ascending order).

    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical
    larger rearrangement.

    Given an array of integers nums, find the next permutation of nums.

    The replacement must be in place and use only constant extra memory.

    Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 100
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while ((i > 0) && (nums[i] <= nums[i - 1])) i--; //looking for the first peak on the right

        if (i == 0) reverseArrPart(nums, 0); //max permutation - reverse it to make a min one
        else {
            reverseArrPart(nums, i);
            int j = i;
            int numToSwap = nums[i - 1];
            while (numToSwap >= nums[j]) j++; //we have a bigger number for sure - no risk to go out of bounds
            swap(nums, j, i - 1); //swap first value down left from the peak with next available on the right
        }
    }

    private void reverseArrPart(int[] arr, int start) {
        int len = arr.length;
        for (int l = start; l < start + (len - start) / 2; l++) {
            swap(arr, l, len - (l - start) - 1);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
