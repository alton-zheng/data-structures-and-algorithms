package java01838.m01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 7/19/21 8:44 AM
 * @Description:
 *
 * 1838. Frequency of the Most Frequent Element
 *
 * The frequency of an element is the number of times it occurs in an array.
 *
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 *
 * Return the maximum possible frequency of an element after performing at most k operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 * Example 2:
 *
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 * Example 3:
 *
 * Input: nums = [3,9,6], k = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= 10^5
 *
 * Time Complexity : O(N*logN + N^2)
 * Space Complexity: O(logN)
 * force solution
 *
 * Runtime: 129 ms, faster than 16.77% of Java online submissions for Frequency of the Most Frequent Element.
 * Memory Usage: 55.5 MB, less than 50.97% of Java online submissions for Frequency of the Most Frequent Element.
 */
class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int maxFrequency = 0;

        int equalIdx = -1;

        for (int i = nums.length - 1; i >= 0; i = equalIdx == -1 ? i - 1 : equalIdx - 1) {
            int tmp = k;
            int curFrequency = 1;
            equalIdx = -1;
            for (int j = i - 1; j >= 0; j--) {

                if (nums[i] == nums[j]) {
                    curFrequency++;
                    equalIdx = j;
                } else {
                    tmp -= nums[i] - nums[j];
                    if (tmp >= 0) {
                        curFrequency++;
                    } else {
                        break;
                    }
                }
            }

            if (curFrequency > maxFrequency) {
                maxFrequency = curFrequency;
                if (maxFrequency == i + 1) {
                    break;
                }
            }
        }

        return maxFrequency;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxFrequency(new int[]{1, 2, 4,4, 4}, 5));
    }
}
