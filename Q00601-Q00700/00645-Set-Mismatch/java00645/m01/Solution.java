package java00645.m01;

/**
 * @Author: alton
 * @Date: Created in 7/4/21 8:41 AM
 * @Description:
 * 645. Set Mismatch #173
 *
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Set Mismatch.
 * Memory Usage: 40.8 MB, less than 43.74% of Java online submissions for Set Mismatch.
 */
class Solution {
    public int[] findErrorNums(int[] nums) {

        int[] help = new int[nums.length + 1];

        for (int num: nums) {
            help[num]++;
        }

        int[] res = new int[2];
        int flag = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (help[i] == 2) {
                res[0] = i;
                flag++;
            }

            if (help[i] == 0) {
                res[1] = i;
                flag++;
            }

            if (flag == 2) {
                return res;
            }
        }

        return new int[]{-1,-1};
    }
}
