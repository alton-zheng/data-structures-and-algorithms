package java01818.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 7/14/21 9:33 AM
 * @Description:
 * 1818. Minimum Absolute Sum Difference #205
 *
 * You are given two positive integer arrays nums1 and nums2, both of length n.
 *
 * The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).
 *
 * You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.
 *
 * Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large, return it modulo 109 + 7.
 *
 * |x| is defined as:
 *
 * x if x >= 0, or
 * -x if x < 0.
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,5], nums2 = [2,3,5]
 * Output: 3
 * Explanation: There are two possible optimal solutions:
 * - Replace the second element with the first: [1,7,5] => [1,1,5], or
 * - Replace the second element with the third: [1,7,5] => [1,5,5].
 * Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5| = 3.
 * Example 2:
 *
 * Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * Output: 0
 * Explanation: nums1 is equal to nums2 so no replacement is needed. This will result in an
 * absolute sum difference of 0.
 * Example 3:
 *
 * Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * Output: 20
 * Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,10,4,4,2,7].
 * This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 *
 *
 * Constraints:
 *
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 *
 * Time Complexity : O(n*logn)
 * Space Complexity : O(n)
 *
 * Runtime: 45 ms, faster than 80.56% of Java online submissions for Minimum Absolute Sum Difference.
 * Memory Usage: 56.8 MB, less than 45.99% of Java online submissions for Minimum Absolute Sum Difference.
 *
 */
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        final int mod = 1000000007;
        int nums1Len = nums1.length;
        int[] help = Arrays.copyOf(nums1, nums1Len);
        Arrays.sort(help);

        int sum = 0, max = 0;
        for (int i = 0; i < nums1Len; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + abs) % mod;

            int j = bs(help, nums2[i]);

            if (j < nums1Len) {
                max = Math.max(max, abs - (help[j] - nums2[i]));
            }

            if (j > 0) {
                max = Math.max(max, abs - (nums2[i] - help[j - 1]));
            }

        }
        return (sum - max + mod) % mod;
    }

    private int bs(int[] help, int target) {
        int left = 0, right = help.length - 1;
        if (help[right] < target) {
            return right + 1;
        }

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (help[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}