package java00149.m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 6/24/21 7:45 PM
 * @Description:
 *
 * 149. Max Points on a Line #142
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * Example 2:
 *
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * All the points are unique.
 *
 * Time Complexity : O(N^2*logm)
 * Space Complexity : O(N)
 *
 * Runtime: 7 ms, faster than 76.23% of Java online submissions for Max Points on a Line.
 * Memory Usage: 38.5 MB, less than 71.36% of Java online submissions for Max Points on a Line.
 *
 */
class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length;

        if (len <= 2) {
            return len;
        }

        int res = 0;

        for (int i = 0; i < len; i++) {
            if (res >= len - i || res > len / 2) {
                break;
            }

            Map<Integer, Integer> help = new HashMap<>();

            for (int j = i + 1; j < len; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        y = -y;
                        x = -x;
                    }

                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }

                int key = y + x * 20001;
                help.put(key, help.getOrDefault(key, 0) + 1);
            }

            int m = 0;
            for (Integer value : help.values()) {
                m = Math.max(m, value + 1);
            }

            res = Math.max(res, m);
        }

        return res;
    }

    private int gcd(int a, int b) {
        return b != 0 ?  gcd(b, a % b): a;
    }
}
