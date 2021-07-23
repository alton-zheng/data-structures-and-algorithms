package java01893.m01;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: alton
 * @Date: Created in 2021/7/23 下午8:02
 * @Description:
 * 1893. Check if All the Integers in a Range Are Covered
 *
 * You are given a 2D integer array ranges and two integers left and right. Each ranges[i] = [starti, endi] represents an inclusive interval between starti and endi.
 *
 * Return true if each integer in the inclusive range [left, right] is covered by at least one interval in ranges. Return false otherwise.
 *
 * An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi.
 *
 *
 *
 * Example 1:
 *
 * Input: ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * Output: true
 * Explanation: Every integer between 2 and 5 is covered:
 * - 2 is covered by the first range.
 * - 3 and 4 are covered by the second range.
 * - 5 is covered by the third range.
 * Example 2:
 *
 * Input: ranges = [[1,10],[10,20]], left = 21, right = 21
 * Output: false
 * Explanation: 21 is not covered by any range.
 *
 *
 * Constraints:
 *
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 *
 * Time Complexity: O(N*L)
 * Space Complexity: O(1)
 *
 * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/solution/2chong-fang-fa-du-chao-100-by-alton-z-abio/
 *
 */
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {

        int[] help = new int[51];

        for (int i = 0; i < ranges.length; i++) {

            int l = ranges[i][0], r = ranges[i][1];

            // 当 left 大于 right 时，说明 [left, right] 全覆盖了，没有值了
            if (left > right) {
                return true;
            }

            // [l, r] 覆盖 [left, right] 左范围区间
            if (l <= left && r >= left) {
                left = r + 1;
                continue;
            }

            // [l, r] 覆盖 [right, left] 右范围区间
            if (l <= right && r >= right) {
                right = l - 1;
                continue;
            }


            // [l, r] 在 [left, right] 区间中间部分，没法将 left , right 左右移动
            for (int j = l; j <= r; j++) {
                help[j]++;
            }
        }

        // 一旦 [left, right] 区间有一个元素没被覆盖，返回 false
        for(int i = left; i <= right; i++) {
            if (help[i] <= 0) {
                return false;
            }
        }

        return true;
    }
}
