package java00069.m04;

/**
 * @Author: alton
 * @Date: Created in 2021/8/24 9:14 下午
 * @Description:
 *
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 * x_(i + 1) = 1/2*(x_i  + C/x_i)
 * 方法三：牛顿迭代
 */
class Solution {
    public int mySqrt(int x) {

        if (x == 0) {
            return 0;
        }

        // C 值即为需要求平凡根的输入， x0 初始化为输入值
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);

            // 当 2 次 值小于无限大于零值的 1e-7 或 1e-6 时，此时的 x0 即为答案
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }

        return (int) x0;
    }
}
