package java01588.m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 7/7/21 4:27 PM
 * @Description:
 * 1590. Make Sum Divisible by P #183
 *
 * Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.
 *
 * Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
 *
 * A subarray is defined as a contiguous block of elements in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,4,2], p = 6
 * Output: 1
 * Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
 * Example 2:
 *
 * Input: nums = [6,3,5,2], p = 9
 * Output: 2
 * Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
 * Example 3:
 *
 * Input: nums = [1,2,3], p = 3
 * Output: 0
 * Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.
 * Example 4:
 *
 * Input: nums = [1,2,3], p = 7
 * Output: -1
 * Explanation: There is no way to remove a subarray in order to get a sum divisible by 7.
 * Example 5:
 *
 * Input: nums = [1000000000,1000000000,1000000000], p = 3
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 * Runtime: 28 ms, faster than 96.06% of Java online submissions for Make Sum Divisible by P.
 * Memory Usage: 60.3 MB, less than 45.32% of Java online submissions for Make Sum Divisible by P.
 *
 */
class Solution {
    public int minSubarray(int[] nums, int p) {

        long sum = 0;

        for (int num: nums) {
            sum += num;
        }

        long mod = sum % p;
        if (mod == 0) {
            return 0;
        }

        Map<Long, Integer> help = new HashMap<>();
        help.put((long)0, -1);

        long curMod = 0;
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){

            curMod = (curMod + nums[i]) % p;
            long target  = (curMod - mod + p) % p;
            if(help.containsKey(target)){
                res = Math.min(res, i - help.get(target));
                if (res == 1 && res != nums.length) {
                    return res;
                }
            }
            help.put(curMod, i);
        }
        return res == nums.length ? -1 : res;
    }
}
