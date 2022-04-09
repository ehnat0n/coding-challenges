import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {

    /*
    Given an integer array arr, and an integer target, return the number of tuples i, j, k such that
    i < j < k and arr[i] + arr[j] + arr[k] == target.

    As the answer can be very large, return it modulo 10^9 + 7.

    Constraints:

    3 <= arr.length <= 3000
    0 <= arr[i] <= 100
    0 <= target <= 300
     */

    //T/S: O(n + w^2)/O(w)
    //n - arr length, w - max element
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1_000_000_007;
        int aMax = 100;
        long[] counts = new long[aMax + 1];
        for (int num : arr) counts[num]++;
        long result = 0;

        //all different
        for (int x = 0; x <= aMax; x++) {
            for (int y = x + 1; y <= aMax; y++) {
                int z = target - x - y;
                if ((y < z) && (z <= aMax)) {
                    result += counts[x] * counts[y] * counts[z];
                    result %= mod;
                }
            }
        }

        //x == y != z
        for (int x = 0; x <= aMax; x++) {
            int z = target - 2 * x;
            if ((x < z) && (z <= aMax)) {
                result += counts[x] * (counts[x] - 1) / 2 * counts[z];
                result %= mod;
            }
        }

        //x != y == z
        for (int x = 0; x <= aMax; x++) {
            if ((target % 2) == (x % 2)) { //otherwise, incorrect division
                int y = (target - x) / 2;
                if (x < y && y <= aMax) {
                    result += counts[x] * counts[y] * (counts[y] - 1) / 2;
                }
            }
        }

        //x == y == z
        if (target % 3 == 0) {
            int x = target / 3;
            if ((0 <= x) && (x <= aMax)) {
                result += counts[x] * (counts[x] - 1) * (counts[x] - 2) / 6;
                result %= mod;
            }
        }

        return (int) result;
    }

    //Adaptation of 3sum with unique numbers. T/S: O(n + w + u^2)/O(w + u)
    //n - arr length, w - max element, u - number of unique elements, u <= w.
    public int threeSumMulti2(int[] arr, int target) {
        int mod = 1_000_000_007;
        long[] counts = new long[101];
        int uniques = 0;
        for (int num : arr) { //counting all numbers
            counts[num]++;
            if (counts[num] == 1) uniques++;
        }
        int[] keys = new int[uniques];
        int ind = 0;
        for (int i = 0; i <= 100; i++) { //creating a set of unique numbers
            if (counts[i] > 0) keys[ind++] = i;
        }

        long result = 0;
        int len = keys.length;
        for (int i = 0; i < len; i++) { //doing 3sum for each unique number with count modifications inside
            int ai = keys[i];
            int newTarget = target - ai;
            int j = i, k = len - 1;
            while (j <= k) {
                int aj = keys[j];
                int ak = keys[k];
                if (aj + ak < newTarget) j++;
                else if (aj + ak > newTarget) k--;
                else {
                    if (i < j && j < k) result += counts[ai] * counts[aj] * counts[ak];
                    else if (i == j && j < k) result += counts[ai] * (counts[ai] - 1) / 2 * counts[ak];
                    else if (i < j && j == k) result += counts[ai] * counts[aj] * (counts[aj] - 1) / 2;
                    else result += counts[ai] * (counts[ai] - 1) * (counts[ai] - 2) / 6;
                    result %= mod;
                    j++;
                    k--;
                }
            }
        }
        return (int) result;
    }

    //Iterate over n 2sum problems with new targets. T/S: O(n^2)/O(1)
    public int threeSumMulti3(int[] arr, int target) {
        int len = arr.length;
        int mod = 1_000_000_007;
        long count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < len - 2; i++) { //iteration to get new targets for internal two sum problem
            int curTarget = target - arr[i];
            int j = i + 1, k = len - 1;
            while (j < k) {
                int aj = arr[j];
                int ak = arr[k];
                if (aj + ak < curTarget) j++;
                else if (aj + ak > curTarget) k--;
                else {
                    if (aj == ak) { //leftover numbers are the same
                        count += (long) (k - j + 1) * (k - j) / 2; //binomial coefficient to get all pairs of the same number
                        count %= mod;
                        break;
                    } else { //counting amounts of each number when they differ
                        int jCount = 1, kCount = 1;
                        while (((j + 1) < k) && (arr[j] == arr[j + 1])) {
                            j++;
                            jCount++;
                        }
                        while (((k - 1) > j) && (arr[k] == arr[k - 1])) {
                            k--;
                            kCount++;
                        }
                        count += (long) jCount * kCount;
                        count %= mod;
                        j++;
                        k--;
                    }
                }
            }
        }
        return (int) count;
    }

    //Using 2sum with hashmap. T/S: O(n^2)/O(n^2)
    //Was ~2s runtime, bottom 5%, but accepted
    public int threeSumMulti4(int[] arr, int target) {
        long count = 0;
        int mod = 1000000007;
        for (int i = arr.length - 1; i > 1; i--) {
            int end = i - 1;
            int newTarget = target - arr[i];
            int currentNum;
            Map<Integer, Integer> differenceMap = new HashMap<>();
            for (int j = 0; j <= end; j++) {
                currentNum = arr[j];
                int curCount = differenceMap.getOrDefault(currentNum, 0);
                if (curCount > 0) count += curCount;
                differenceMap.put(newTarget - currentNum, differenceMap.getOrDefault(newTarget - currentNum, 0) + 1);
            }
            count %= mod;
        }
        return (int) count;
    }
}
