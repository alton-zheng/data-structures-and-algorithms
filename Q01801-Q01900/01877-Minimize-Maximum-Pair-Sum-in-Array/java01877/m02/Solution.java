package java01877.m02;

import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 7/20/21 8:36 AM
 * @Description: The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
 * <p>
 * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
 * Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
 * <p>
 * Each element of nums is in exactly one pair, and
 * The maximum pair sum is minimized.
 * Return the minimized maximum pair sum after optimally pairing up the elements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,5,2,3]
 * Output: 7
 * Explanation: The elements can be paired up into pairs (3,3) and (5,2).
 * The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
 * Example 2:
 * <p>
 * Input: nums = [3,5,4,2,4,6]
 * Output: 8
 * Explanation: The elements can be paired up into pairs (3,5), (4,4), and (6,2).
 * The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 2 <= n <= 10^5
 * n is even.
 * 1 <= nums[i] <= 10^5
 * <p>
 * Time Complexity : O(N)
 * Space Complexity :O(M)
 * Runtime: 8 ms, faster than 100.00% of Java online submissions for Minimize Maximum Pair Sum in Array.
 * Memory Usage: 54.3 MB, less than 96.03% of Java online submissions for Minimize Maximum Pair Sum in Array.
 * 桶排序
 */
class Solution {

    public int minPairSum(int[] nums) {

        int maxValue = 0;
        for (int num: nums) {
            maxValue = Math.max(maxValue, num);
        }
        int[] help = new int[maxValue + 1];
        for (int num : nums) {
            help[num]++;
        }

        int res = -1;
        int left = 0, right = maxValue;

        while (left <= right) {
            while (left <= right && help[left] == 0) {
                left++;
            }
            while (left <= right && help[right] == 0) {
                right--;
            }

            if (left <= right) {
                res = Math.max(res, left + right);
                help[left]--;
                help[right]--;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minPairSum(new int[]{5, 9, 8, 6, 8, 5, 10, 2, 2, 9, 7, 3, 6, 3, 8, 7, 1, 2, 9, 10}));
    }

}
