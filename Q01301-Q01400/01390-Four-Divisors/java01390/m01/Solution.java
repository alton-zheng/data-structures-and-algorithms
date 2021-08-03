package java01390.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/3 3:52 下午
 * @Description:
 *
 * 1390. Four Divisors
 *
 * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
 *
 * If there is no such integer in the array, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [21,4,7]
 * Output: 32
 * Explanation:
 * 21 has 4 divisors: 1, 3, 7, 21
 * 4 has 3 divisors: 1, 2, 4
 * 7 has 2 divisors: 1, 7
 * The answer is the sum of divisors of 21 only.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * Runtime: 14 ms, faster than 83.95% of Java online submissions for Four Divisors.
 * Memory Usage: 39.2 MB, less than 45.87% of Java online submissions for Four Divisors.
 *
 *
 */
class Solution {
    public int sumFourDivisors(int[] nums) {

        int res = 0;

        for (int num: nums) {

            int sum = 0;
            int cnt = 0;

            for (int i = 1; i * i < num; i++) {
                if (num % i == 0) {
                    cnt += 2;
                    sum += (i + num / i);
                }

                if (cnt > 4) {
                    break;
                }
            }

            int s = (int)Math.sqrt(num);

            if (s * s == num) {
                continue;
            }

            if (cnt == 4) {
                res += sum;
            }

        }

        return res;

    }
}
