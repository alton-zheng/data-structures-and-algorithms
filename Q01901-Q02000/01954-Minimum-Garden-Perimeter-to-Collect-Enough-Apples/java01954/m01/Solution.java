package java01954.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/1 4:21 下午
 * @Description:
 * 1954. Minimum Garden Perimeter to Collect Enough Apples #261
 *
 * In a garden represented as an infinite 2D grid, there is an apple tree planted at every integer coordinate. The apple tree planted at an integer coordinate (i, j) has |i| + |j| apples growing on it.
 *
 * You will buy an axis-aligned square plot of land that is centered at (0, 0).
 *
 * Given an integer neededApples, return the minimum perimeter of a plot such that at least neededApples apples are inside or on the perimeter of that plot.
 *
 * The value of |x| is defined as:
 *
 * x if x >= 0
 * -x if x < 0
 *
 *
 * Example 1:
 *
 *
 * Input: neededApples = 1
 * Output: 8
 * Explanation: A square plot of side length 1 does not contain any apples.
 * However, a square plot of side length 2 has 12 apples inside (as depicted in the image above).
 * The perimeter is 2 * 4 = 8.
 * Example 2:
 *
 * Input: neededApples = 13
 * Output: 16
 * Example 3:
 *
 * Input: neededApples = 1000000000
 * Output: 5040
 *
 *
 * Constraints:
 *
 * 1 <= neededApples <= 1015
 *
 * Time Complexity: O(logN)
 * Space Complexity : O(1)
 * Runtime: 12 ms, faster than 66.67% of Java online submissions for Minimum Garden Perimeter to Collect Enough Apples.
 * Memory Usage: 35.8 MB, less than 66.67% of Java online submissions for Minimum Garden Perimeter to Collect Enough Apples.
 */
class Solution {
    public long minimumPerimeter(long neededApples) {

        long l;

        for (l = 1; 2*l*(l + 1)*(2*l + 1) < neededApples; l++);

        return 8 * l;

    }
}
