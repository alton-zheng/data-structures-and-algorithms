package java00218.m01;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 7/13/21 8:54 AM
 * @Description:
 * 218. The Skyline Problem
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 *
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 *
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 *
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
 *
 *
 *
 * Example 1:
 *
 *
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.
 * Example 2:
 *
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 *
 *
 * Constraints:
 *
 * 1 <= buildings.length <= 10^4
 * 0 <= lefti < righti <= 2^31 - 1
 * 1 <= heighti <= 2^31 - 1
 * buildings is sorted by lefti in non-decreasing order.
 *
 * Time Complexity : O(logN)
 * Space Complexity : O(N)
 *
 * Runtime: 12 ms, faster than 88.17% of Java online submissions for The Skyline Problem.
 * Memory Usage: 42 MB, less than 76.84% of Java online submissions for The Skyline Problem.
 *
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        int len = buildings.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> help = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((v1, v2) -> v2[1] - v1[1]);

        // 将每一建筑物的左右边界 x 坐标，存入 help list 中
        for (int[] build: buildings) {
            help.add(build[0]);
            help.add(build[1]);
        }

        Collections.sort(help);

        int curIndex = 0;

        for (int bundary: help) {
            // 因为 buildings 按首元素， 左边界 x 坐标值排好序，因此在这可按顺序跟所有建筑物边界值一一比较，将符合条件的数据入队列
            while (curIndex < len && buildings[curIndex][0] <= bundary) {
                queue.add(new int[]{buildings[curIndex][1], buildings[curIndex][2]});
                curIndex++;
            }

            // 将队列中右边界 x 坐标小于等于当前 bundary 的数据从队列中去除
            while (!queue.isEmpty() && queue.peek()[0] <= bundary) {
                queue.poll();
            }

            int hmax = queue.size() == 0 ? 0 : queue.peek()[1];

            if (res.size() == 0 || hmax != res.get(res.size() - 1).get(1)) {
                res.add(Arrays.asList(bundary, hmax));
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}}));
    }
}
