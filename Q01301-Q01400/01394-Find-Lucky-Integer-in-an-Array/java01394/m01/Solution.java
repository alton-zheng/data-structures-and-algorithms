package java01394.m01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 6/14/21 7:20 AM
 * @Description:
 *
 * 1394. Find Lucky Integer in an Array #111
 *
 * Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
 *
 * Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * Example 2:
 *
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 * Example 3:
 *
 * Input: arr = [2,2,2,3,3]
 * Output: -1
 * Explanation: There are no lucky numbers in the array.
 * Example 4:
 *
 * Input: arr = [5]
 * Output: -1
 * Example 5:
 *
 * Input: arr = [7,7,7,7,7,7,7]
 * Output: 7
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 *
 * Time Complexity : O(NLogN)
 * Space Complexity : O(1)
 * Runtime: 1 ms, faster than 99.54% of Java online submissions for Find Lucky Integer in an Array.
 * Memory Usage: 38.4 MB, less than 84.32% of Java online submissions for Find Lucky Integer in an Array.
 *
 */
class Solution {
    public int findLucky(int[] arr) {

        Arrays.sort(arr);
        int cur = 0, count = -1;
        for (int i = arr.length - 1; i >= 0; i--) {

            if (cur != arr[i]) {
                if (count == cur) {
                    return count;
                }
                cur = arr[i];
                count = 1;
            } else {
                count++;
            }
        }

        return count == cur ? count : -1;
    }
}
