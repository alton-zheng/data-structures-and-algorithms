package java00645.m02;

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
 * 2 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^4
 *
 * Time Complexity : O(5N)
 * Space Complexity : O(1)
 * Runtime: 3 ms, faster than 59.53% of Java online submissions for Set Mismatch.
 * Memory Usage: 52.2 MB, less than 7.04% of Java online submissions for Set Mismatch.
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        // xor： 根据异或的结合律和交换律，可以推断出 xor 为重复数值与缺失数值的亦或值
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= nums[i - 1];
            xor ^= i;
        }

        // low 为 重复数值与缺失数值二进制中最低的不同位
        int low = xor & (-xor);


        int num1 = 0, num2 = 0;

        // 分成 2 种场景，一种与 low & 操作为 0， 一种 & 操作不为 0，求出 2 个值
        for (int i = 1; i <= n; i++) {
            if ((i & low) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
            int curValue = nums[i - 1];
            if ((curValue & low) == 0) {
                num1 ^= curValue;
            } else {
                num2 ^= curValue;
            }
        }

        for (int num : nums) {
            // 找出重复的是哪个数值，那么另一个就是缺失的
            if (num == num1) {
                return new int[]{num1, num2};
            }

        }
        return new int[]{num2, num1};
    }
}