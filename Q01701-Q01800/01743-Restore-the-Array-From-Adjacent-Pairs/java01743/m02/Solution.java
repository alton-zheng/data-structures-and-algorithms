package java01743.m02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 2021/7/25 上午8:43
 * @Description:
 * 1743. Restore the Array From Adjacent Pairs
 *
 * 1743. Restore the Array From Adjacent Pairs #238
 *
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 *
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 *
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 * Return the original array nums. If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 *
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 *
 * Input: adjacentPairs = [[helpLen,-helpLen]]
 * Output: [helpLen,-helpLen]
 *
 *
 * Constraints:
 *
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 10^5
 * -10^5 <= nums[i], ui, vi <= 10^5
 * There exists some nums that has adjacentPairs as its pairs.
 *
 * Time Complexity: O()
 * Space Complexity: O()
 * Runtime: 89 ms, faster than 97.77% of Java online submissions for Restore the Array From Adjacent Pairs.
 * Memory Usage: 160.4 MB, less than 36.01% of Java online submissions for Restore the Array From Adjacent Pairs.
 */
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {

        int minValue = 100001, maxValue = -100001;
        for (int[] adjacentPair: adjacentPairs) {
            int first = adjacentPair[0], second = adjacentPair[1];
            if (first <= second) {
                minValue = Math.min(minValue, first);
                maxValue = Math.max(maxValue, second);
            } else {
                minValue = Math.min(minValue, second);
                maxValue = Math.max(maxValue, first);
            }
        }

        int helpLen = 0;

        if (maxValue < 0) {
            helpLen = Math.abs(minValue) + 1;
        } else if (minValue >= 0) {
            helpLen = Math.abs(maxValue) + 1;
        } else {
            helpLen = Math.max(Math.abs(minValue), Math.abs(maxValue));
        }

        List<Integer>[] help = new ArrayList[helpLen * 2];

        for (int[] adjacentPair  : adjacentPairs) {
            List<Integer> list1 = help[adjacentPair[0] + helpLen];

            if (list1 == null) {
                list1 = new ArrayList<>();
            }

            list1.add(adjacentPair[1]);
            help[adjacentPair[0] + helpLen] = list1;

            List<Integer> list2 = help[adjacentPair[1] + helpLen];
            if (list2 == null) {
                list2= new ArrayList<>();
            }

            list2.add(adjacentPair[0]);
            help[adjacentPair[1] + helpLen] = list2;
        }

        int len = adjacentPairs.length + 1;
        int[] res = new int[len];
        for (int i = 0; i < help.length; i++) {
            if (help[i] != null && help[i].size() == 1) {
                res[0] = i - helpLen;
                res[1] = help[i].get(0);
                break;
            }
        }

        for (int i = 2; i < len; i++) {
            List<Integer> cur = help[res[i - 1] + helpLen];
            res[i] = res[i - 2] == cur.get(0) ? cur.get(1) : cur.get(0);
        }

        return res;
    }
}