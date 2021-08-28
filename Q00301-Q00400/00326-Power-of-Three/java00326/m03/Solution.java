package java00326.m03;

/**
 * @Author: alton
 * @Date: Created in 2021/8/28 10:02 上午
 * @Description:
 * 1162261467 = 3^19
 *
 * Runtime: 11 ms, faster than 60.98% of Java online submissions for Power of Three.
 * Memory Usage: 38.6 MB, less than 72.39% of Java online submissions for Power of Three.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
