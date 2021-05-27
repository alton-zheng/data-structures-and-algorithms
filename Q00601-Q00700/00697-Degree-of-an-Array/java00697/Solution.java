package java00697;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 5/27/21 3:18 PM
 * @Description:
 * 697. Degree of an Array #48
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 *
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 *
 * Constraints:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 *
 * Time Complexity: O()
 * Space Complexity: O()
 */
class Solution {
    public int findShortestSubArray(int[] nums) {

        Map<Integer, int[]> map = new HashMap<>();
        int number = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int[] temp = new int[3];
                temp[0] = i;
                temp[1] = i;
                map.put(nums[i], temp);
            } else {
                map.get(nums[i])[1] = i;
                map.get(nums[i])[2] = map.get(nums[i])[2] + 1;
            }

            number = Math.max(number, map.get(nums[i])[2]);

        }

        int res = Integer.MAX_VALUE;

        for (int[] value: map.values()) {
            if (number == value[2]) {
                res = Math.min(res, value[1] - value[0] + 1);
            }
        }

        return res;
    }
}