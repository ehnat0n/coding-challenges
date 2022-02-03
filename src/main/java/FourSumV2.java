import java.util.HashMap;
import java.util.Map;

public class FourSumV2 {

    /*
    Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
    0 <= i, j, k, l < n
    nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

    1 <= n <= 200
    -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> twoSum = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                twoSum.compute(num1 + num2, (k, v) -> (v == null) ? 1 : v + 1);
            }
        }
        int counter = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                counter += twoSum.getOrDefault(-(num3 + num4), 0);
            }
        }
        return counter;
    }
}
