package java00939.m01;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 2021/7/22 上午8:59
 * @Description:
 * 939. Minimum Area Rectangle
 *
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 * Example 2:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 *
 *
 * Note:
 *
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 *
 * Time Complexity:  O(N^2)
 * Space Complexity: O(N)
 * 按列排列
 */
class Solution {
    public int minAreaRect(int[][] points) {

        Map<Integer, List<Integer>> help = new TreeMap<>();
        for (int[] point: points) {
            int x = point[0], y = point[1];
            help.computeIfAbsent(x, z-> new ArrayList<>()).add(y);
        }

        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> curX = new HashMap<>();
        for (int x: help.keySet()) {
            List<Integer> row = help.get(x);
            Collections.sort(row);
            for (int i = 0; i < row.size(); i++) {
                for (int j = i + 1; j < row.size(); j++) {
                    int y1 = row.get(i), y2 = row.get(j);
                    int code = 40001 * y1 + y2;
                    if (curX.containsKey(code)) {
                        res = Math.min(res, (x - curX.get(code)) * (y2 - y1));
                    }
                    curX.put(code, x);
                }
            }
        }

        return res < Integer.MAX_VALUE ? res : 0;
    }
}