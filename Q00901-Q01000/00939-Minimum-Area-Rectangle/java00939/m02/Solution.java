package java00939.m02;

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
 * 枚举对角线
 * Runtime: 123 ms, faster than 83.95% of Java online submissions for Minimum Area Rectangle.
 * Memory Usage: 39.4 MB, less than 47.64% of Java online submissions for Minimum Area Rectangle.
 */
class Solution {
    public int minAreaRect(int[][] points) {

        Set<Integer> pointSet = new HashSet<>();

        for (int[] point: points) {
            pointSet.add(40001 * point[0] + point[1]);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {

                // x 不相等， y 不相等， 说明此两个点与 x, y 轴是不平行的。可以形成对角线
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {

                    // 并且存在上述 2 点， 所对应矩形另外一条对角线的两个端点
                    // 才能说明此 4 个点刚好组成矩形
                    if (pointSet.contains(40001 * points[i][0] + points[j][1]) &&
                            pointSet.contains(40001 * points[j][0] + points[i][1])) {

                        // 获取最小面积
                        res = Math.min(res, Math.abs(points[j][0] - points[i][0]) *
                                Math.abs(points[j][1] - points[i][1]));
                    }
                }
            }
        }

        return res < Integer.MAX_VALUE ? res : 0;
    }
}