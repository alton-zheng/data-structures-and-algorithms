package java01496;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author: alton
 * @Date: Created in 6/9/21 4:48 PM
 * @Description:
 * 1496. Path Crossing #92
 *
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 *
 * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
 * Example 1:
 *
 *
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 * Example 2:
 *
 *
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 104
 * path[i] is either 'N', 'S', 'E', or 'W'.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Point
 * Runtime: 2 ms, faster than 67.19% of Java online submissions for Path Crossing.
 * Memory Usage: 38.9 MB, less than 45.37% of Java online submissions for Path Crossing.
 */
class Solution {

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isPathCrossing(String path) {

        Set<Point> help = new HashSet<>();
        Point p = new Point(0, 0);
        help.add(p);

        for (char m: path.toCharArray()) {
            Point n = p;
            switch (m) {
                case 'E' :
                    n = new Point(p.x + 1, p.y);
                    break;
                case 'S':
                    n = new Point(p.x, p.y - 1);
                    break;
                case 'W':
                    n = new Point(p.x - 1, p.y);
                    break;
                default:
                    n = new Point(p.x, p.y + 1);
            }

            if (help.contains(n)) {
                return false;
            }

            p = n;

        }

        return true;

    }
}
