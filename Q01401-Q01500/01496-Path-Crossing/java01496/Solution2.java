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
 * Set
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Crossing.
 * Memory Usage: 37.7 MB, less than 81.16% of Java online submissions for Path Crossing.
 */
class Solution2 {

    public boolean isPathCrossing(String path) {

        int x = 0, y = 0;
        Set<Integer> help = new HashSet<>();
        help.add(x * 20001 + y);

        for (char m: path.toCharArray()) {
            switch (m) {
                case 'E' :
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    y++;
            }

            int value = x * 20001 + y;

            if (help.contains(value)) {
                return true;
            } else {
                help.add(value);
            }
        }

        return false;

    }
}
