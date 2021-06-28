package java00815.m01;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 6/28/21 3:47 PM
 * @Description:
 * 815. Bus Routes #154
 *
 * You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
 *
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
 *
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 *
 *
 *
 * Example 1:
 *
 * Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * Output: 2
 * Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 * Example 2:
 *
 * Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * All the values of routes[i] are unique.
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 *
 * Time Complexity : O(nm+n^2)
 * Space Complexity :O(n^2 + m)
 *
 * Runtime: 33 ms, faster than 89.50% of Java online submissions for Bus Routes.
 * Memory Usage: 60 MB, less than 80.84% of Java online submissions for Bus Routes.
 *
 */
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        int l = routes.length;

        // 维护哪些公交路线有公共公交站
        char[][] edge = new char[l][l];

        // 维护公交站所在的所有公交路线
        Map<Integer, List<Integer>> rec = new HashMap<>();

        for (int b = 0; b < l; b++) {
            for (int st : routes[b]) {
                List<Integer> list = rec.getOrDefault(st, new ArrayList<>());
                for (int idx : list) {
                    edge[b][idx] = edge[idx][b] = '1';
                }

                list.add(b);
                rec.put(st, list);
            }
        }

        if (!rec.containsKey(source) || !rec.containsKey(target)) {
            return -1;
        }


        Queue<Integer> queue = new LinkedList<>();

        int[] nums = new int[l];

        for (int i : rec.getOrDefault(source, new ArrayList<>())) {
            nums[i] = 1;
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer bus = queue.poll();

            for (int i = 0; i < l; i++) {
                if (edge[bus][i] == '1' && nums[i] == 0) {
                    nums[i] = nums[bus] + 1;
                    queue.offer(i);
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for (int t: rec.getOrDefault(target, new ArrayList<>())) {
            if (nums[t] != 0) {
                res = Math.min(res, nums[t]);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
    }
}
