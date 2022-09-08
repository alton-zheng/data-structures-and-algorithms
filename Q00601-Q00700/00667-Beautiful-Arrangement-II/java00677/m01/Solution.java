package java00677.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-08 12:16
 * @Update Date Time: 2022-09-08 12:16
 * @Updated-By: alton_z
 * @Update-Location:
 * 667. Beautiful Arrangement II #469
 *
 */
class Solution {
    public int[] constructArray(int n, int k) {

        // 定义结果值数组 res, 大小为 n
        int[] res = new int[n];

        // 索引初始化为 0
        int idx = 0;

        // 前[1, n - k - 1] 逐步递增放入 res 数组中
        for (int i = 1; i < n - k; i++) {
            res[idx++] = i;
        }


        // [n - k, n] 排列按
        // [n - k , n, n - k + 1, n - 1, n - k + 2, n + 2, ...] 排列
        for (int i = n - k, j = n; i <= j; ++i,--j) {
            // [n - k, n - k + 1 ...]
            res[idx++] = i;
            if (i != j) {

                // [n, n - 1, ...]
                res[idx++] = j;
            }


        }
        return res;
    }
}
