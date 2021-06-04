package java01509;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 6/4/21 5:51 PM
 * @Description:
 *
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves #74
 *
 * Given an array nums, you are allowed to choose one element of nums and change it by any value in one move.
 *
 * Return the minimum difference between the largest and smallest value of nums after perfoming at most 3 moves.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,3,2,4]
 * Output: 0
 * Explanation: Change the array [5,3,2,4] to [2,2,2,2].
 * The difference between the maximum and minimum is 2-2 = 0.
 * Example 2:
 *
 * Input: nums = [1,5,0,10,14]
 * Output: 1
 * Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1].
 * The difference between the maximum and minimum is 1-0 = 1.
 * Example 3:
 *
 * Input: nums = [6,6,0,1,1,4,6]
 * Output: 2
 * Example 4:
 *
 * Input: nums = [1,5,6,14,15]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * When a given array is no longer than 4,
 * we can always make all the numbers the same,
 * so let's just consider arrays of length greater than 4.
 *
 * Notice that each change has to be either to make the maximum smaller or to make the minimum larger,
 * so that the difference between the maximum and the minimum is as small as possible.
 *
 * So we just need to find the largest four and the smallest four.
 * When we delete the smallest number of k(0≤k≤3),
 * we also need to delete 3−k maxima.
 *
 * Just enumerate these four cases.
 *
 * Method two:
 * We can directly maintain the largest four numbers and the smallest four numbers.
 * We use two arrays to record the maximum and minimum values respectively, and update it.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Runtime: 4 ms, faster than 98.53% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
 * Memory Usage: 62 MB, less than 6.90% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
 *
 */
class Solution {
    public int minDifference(int[] nums) {

        int numsLen = nums.length;

        /**
         * when a given array is no longer than 4
         * we can always make all the numbers the same,
         * so let's consider arrays of length greater than 4.
         */
        if (numsLen <= 4) {
            return 0;
        }

        /**
         * -10^9 <= nums[i] <= 10^9
         */
        int[] minimums = new int[4];
        int[] maximums = new int[4];

        Arrays.fill(minimums, 1000000000);
        Arrays.fill(maximums, -1000000000);

        int four;
        for (int i = 0; i < numsLen; i++) {
            four = 0;
            while (four < 4 && maximums[four] > nums[i]) {
                four++;
            };

            if (four < 4) {
                for (int j = 3; j > four; j--) {
                    maximums[j] = maximums[j - 1];
                }
                maximums[four] = nums[i];
            }

            four = 0;
            while (four < 4 && minimums[four] < nums[i]) {
                four++;
            }

            if (four < 4) {
                for (int j = 3; j > four; j--) {
                    minimums[j] = minimums[j - 1];
                }
                minimums[four] = nums[i];
            }
        }

        // define res variable
        int res = Integer.MAX_VALUE;

        // get min res value
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, maximums[i] - minimums[3 - i]);
        }

        return res;

    }
}
