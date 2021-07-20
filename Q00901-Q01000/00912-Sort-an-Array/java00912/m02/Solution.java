package java00912.m02;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 7/20/21 1:39 PM
 * @Description:
 * 912. Sort an Array
 *
 * Given an array of integers nums, sort the array in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 10^4
 * -5 * 10^4 <= nums[i] <= 5 * 10^4
 * Runtime: 5 ms, faster than 98.59% of Java online submissions for Sort an Array.
 * Memory Usage: 48 MB, less than 67.82% of Java online submissions for Sort an Array.
 * 
 */
class Solution {
    public int[] sortArray(int[] nums) {

        int BOUND = 50000;
        int help[] = new int[2 * BOUND + 2];
        int min = BOUND, max = -BOUND;

        for (int num: nums) {
            help[num + BOUND]++;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int cur = 0;
        for (int i = min + BOUND; i <= max + BOUND; i++) {
            while (help[i] > 0) {
                nums[cur++] = i - BOUND;
                help[i]--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sortArray(new int[]{5, 1, 2}));
    }
}
