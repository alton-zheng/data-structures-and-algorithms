package java00793.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-28 08:58
 * @Update Date Time: 2022-08-28 08:58
 * @Updated-By: alton_z
 * @Update-Location:
 *
 * 793. Preimage Size of Factorial Zeroes Function #445
 *
 */
class Solution {
    public int preimageSizeFZF(int k) {
        return (int) (f(k + 1) - f(k));
    }

    public long f(int k) {

        // 初始化 r 为 5k
        long r = 5L * k;
        long l = 0;

        // 开始二分找到等于 k 的数
        while (l <= r) {

            long mid = (r + l) / 2;
            if (zeroCount(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r + 1;
    }

    /**
     * x 阶乘， 结尾 0 的个数
     */
    public long zeroCount(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }
}
