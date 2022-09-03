package java00646.m01;

import java.util.Arrays;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-03 11:31
 * @Update Date Time: 2022-09-03 11:31
 * @Updated-By: alton_z
 * @Update-Location:
 * 贪心，当然了此题有很多方法解题
 * 646. Maximum Length of Pair Chain #461
 */
class Solution {
    public int findLongestChain(int[][] pairs) {

        // 定义当前 cur pair 数和 res 值
        int curr = Integer.MIN_VALUE, res = 0;

        // 排序， 自定义的比较器，以 pair 首元素进行排序，从小到大
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        // 遍历 pairs 对
        for (int[] p : pairs) {

            // 符合题意的数， res 加 1， 且 curr 数替换成比较对的首元素
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }

        // 返回结果值
        return res;
    }
}
