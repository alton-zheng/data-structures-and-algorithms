package j01512;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 5/11/21 2:28 PM
 * @Description:
 * 1512. Number of Good Pairs
 * Given an array of integers nums.
 *
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 *
 * Return the number of good pairs.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * Accepted
 * 172,371
 * Submissions
 * 196,780
 *
 * Time Complexity: O(i^2)
 * Space Complexity: O(1)
 *
 */
class Solution {
    public int numIdenticalPairs(int[] nums) {

        int num = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    num++;
                }
            }
        }

        return num;
    }
}

/**
 * Time Complexity: O(2n)
 * Space Complexity: O(n)
 */
class Solution2 {
    public int numIdenticalPairs(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            int value = integerIntegerEntry.getValue();
            ans += value * (value - 1) / 2;
        }

        return ans;

    }
}