package java00509.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-10 16:58
 * @Update Date Time: 2022-09-10 16:58
 * @Updated-By: alton_z
 * @Update-Location:
 * 509. Fibonacci Number #472
 */
class Solution {
    public int fib(int n) {

        // 当 n 小于 2 时，不需要处理，直接返回 n
        if (n < 2) {
            return n;
        }

        // M 矩阵
        int[][] m = {{1, 1}, {1, 0}};

        // 求 m ^(n - 1)
        int[][] res = pow(m, n - 2);
        return res[0][0] + res[1][0];
    }

    //
    public int[][] pow(int[][] a, int n) {
        // ret[i][i] = 1
        int[][] ret = {{1, 0}, {0, 1}};

        // 开始处理，直到 n = 0
        while (n > 0) {

            // 当 n & 1 = 1, ret 结果矩阵乘以 m 矩阵 （a）
            // 为 0  时，不操作
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }

            // n 右移 2
            n >>= 1;

            // a 矩阵自乘
            a = multiply(a, a);
        }

        // 返回结果 ret
        return ret;
    }

    // 矩阵相乘
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
