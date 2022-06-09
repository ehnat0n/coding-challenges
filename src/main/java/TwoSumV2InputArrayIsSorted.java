public class TwoSumV2InputArrayIsSorted {

    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and
    numbers[index2] where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

    The tests are generated such that there is exactly one solution. You may not use the same element twice.

    Your solution must use only constant extra space.

    Constraints:

    2 <= numbers.length <= 3 * 10^4
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.
     */

    /*
    While solution looks trivial, maybe not obvious why it works. One way to see is to draw a square matrix where
    rows and columns are elements of the array.
    We start from the top right corner - meaning we sum the smallest and the biggest elements of the array. If sum = target -
    we solved it. Only two other options possible:
        - sum < target - means the whole top row is 'eliminated' now - we move one cell down or increase our lowest number
        - sum > target - means the whole right column is 'eliminated' - we move one cell left or decrease our biggest number
    Since we have a guaranteed solution somewhere - this algo will find it.

    T/S: O(n)/O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];
        while (sum != target) {
            if (sum < target) left++;
            else right--;
            sum = numbers[left] + numbers[right];
        }
        return new int[]{left + 1, right + 1};
    }
}
