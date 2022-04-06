public class FindTheDuplicateNumber {

    /*
    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

    There is only one repeated number in nums, return this repeated number.

    You must solve the problem without modifying the array nums and use only constant extra space.

    Constraints:

    1 <= n <= 10^5
    nums.length == n + 1
    1 <= nums[i] <= n
    All the integers in nums appear only once except for precisely one integer which appears two or more times.
     */

    //hare-tortoise, T/S: O(n)/O(1)
    public int findDuplicate(int[] nums) {
        int hare = 0;
        int tortoise = 0;
        do {
            hare = nums[nums[hare]];
            tortoise = nums[tortoise];
        } while (hare != tortoise); //detected cycle - meeting point on a circle

        hare = 0;
        while (hare != tortoise) { //moving to cycle starting point
            hare = nums[hare];
            tortoise = nums[tortoise];
        }
        return hare;
    }

    //binary search, T/S: O(n * log n)/O(1)
    public int findDuplicate2(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int mid, count;
        while (low < high) {
            mid = (low + high) / 2;
            count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count <= mid) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    //brute force with T/S: O(n^2)/O(1)
    public int findDuplicate3(int[] nums) {
        int len = nums.length;
        int num;
        for (int i = 0; i < len; i++) {
            num = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (num == nums[j]) return num;
            }
        }
        return len; //invalid, shouldn't get there if restrictions are correct
    }
}
