package java01610;

import com.sun.prism.shader.AlphaOne_Color_AlphaTest_Loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 5/25/21 8:59 PM
 * @Description: 
 * 
 * 1610. Maximum Number of Visible Points #42
 * 
 * You are given an array points, an integer angle, and your location, where location = [posx, posy] and points[i] = [xi, yi] both denote integral coordinates on the X-Y plane.
 * 
 * Initially, you are facing directly east from your position. You cannot move from your position, but you can rotate. In other words, posx and posy cannot be changed. Your field of view in degrees is represented by angle, determining how wide you can see from any given view direction. Let d be the amount in degrees that you rotate counterclockwise. Then, your field of view is the inclusive range of angles [d - angle/2, d + angle/2].
 * 
 * 
 * You can see some set of points if, for each point, the angle formed by the point, your position, and the immediate east direction from your position is in your field of view.
 * 
 * There can be multiple points at one coordinate. There may be points at your location, and you can always see these points regardless of your rotation. Points do not obstruct your vision to other points.
 * 
 * Return the maximum number of points you can see.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]
 * Output: 3
 * Explanation: The shaded region represents your field of view. All points can be made visible in your field of view, including [3,3] even though [2,2] is in front and in the same line of sight.
 * Example 2:
 * 
 * Input: points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]
 * Output: 4
 * Explanation: All points can be made visible in your field of view, including the one at your location.
 * Example 3:
 * 
 * 
 * Input: points = [[1,0],[2,1]], angle = 13, location = [1,1]
 * Output: 1
 * Explanation: You can only see one of the two points, as shown above.
 * 
 * 
 * Constraints:
 * 
 * 1 <= points.length <= 105
 * points[i].length == 2
 * location.length == 2
 * 0 <= angle < 360
 * 0 <= posx, posy, xi, yi <= 100
 * 
 * Time Complexity: O()
 * Space Complexity: O()
 */
class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {

        // 由题目可知， points 和 location 里的元素都只会有 2 个节点，分别对应坐标 x, y  angle 为可视角度，不大于等于 360 度（度数本身没负数）

        // 首先定义重点，以及其它点和人所在点的角度
        int equalPoints = 0;

        // 定义 x, y ， 用于遍历 points
        int x = 0, y = 0;

        // 定义 angles， 用于存储和人不在同一位置的点和人的角度
        List<Double> angles = new ArrayList<>();

        // 开始遍历所有的 points
        for (List<Integer> point: points) {
            x = point.get(0) - location.get(0);
            y = point.get(1) - location.get(1);

            if (x == 0 && y == 0) {
                // 都相等时， 相等点变量 + 1
                equalPoints++;
            } else {
                // 不相等，存储角度信息
                angles.add(Math.atan2(y, x) * 180 / Math.PI);
            }
        }

        // 排序所有点的角度信息
        Collections.sort(angles);

        // 将角度加上 360 , 添加到 angles 中，解决环的问题
        for(int i = 0, n = angles.size(); i < n; i++) {
            angles.add(angles.get(i) + 360);
        }

        // 将答案初始化为相同点数
        int ans = equalPoints;

        // 遍历所有角度，将在 angle 视线最大能看到的点找出
        for (int i = 0, j = 0; i < angles.size(); i++) {
            while (j < angles.size() && angles.get(j++) - angles.get(i) <= angle + 1e-9);

            ans = Math.max(j - i + equalPoints, ans);
        }

        // 返回最大可看到的点数
        return ans;

    }
}
