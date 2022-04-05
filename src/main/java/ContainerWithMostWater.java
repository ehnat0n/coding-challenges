public class ContainerWithMostWater {

    /*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
    the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.

    Constraints:

    n == height.length
    2 <= n <= 10^5
    0 <= height[i] <= 10^4
     */
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = calculateMax(height, left, right);
        while (left < right) {
            if (height[left] <= height[right]) left++;
            else right--;
            max = Math.max(max, calculateMax(height, left, right));
        }
        return max;
    }

    private int calculateMax(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}
