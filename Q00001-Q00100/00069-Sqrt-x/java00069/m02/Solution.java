package java00069.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/8/24 9:02 下午
 * @Description:
 * 袖珍计算器解法
 * sqrt(x) = x ^ (1/2) = (e^(lnx)^1/2) = e^(1/2*lnx)
 *
 * 这种解法也是挺无聊的，既然要用公式，还不如直接平凡根公式求解
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sqrt(x).
 * Memory Usage: 36.3 MB, less than 35.18% of Java online submissions for Sqrt(x).
 *
 */
class Solution {
    public int mySqrt(int x) {

        if (x == 0) {
            return 0;
        }

        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;

    }
}
