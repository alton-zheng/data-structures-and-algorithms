package java00326.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/8/28 9:59 上午
 * @Description:
 *
 * Runtime: 30 ms, faster than 5.45% of Java online submissions for Power of Three.
 * Memory Usage: 39.2 MB, less than 18.87% of Java online submissions for Power of Three.
 *
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
