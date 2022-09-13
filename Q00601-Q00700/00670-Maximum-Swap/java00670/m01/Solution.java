package java00670.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-13 14:33
 * @Update Date Time: 2022-09-13 14:33
 * @Updated-By: alton_z
 * @Update-Location:
 * 670. Maximum Swap #475
 */
class Solution {
    public int maximumSwap(int num) {
        // 将数字 char[] 化
        char[] source = String.valueOf(num).toCharArray();

        // 定义两个交换的位置变量
        // 前面最小的和最大的进行交换，即可满足题意
        int one = -1, two = -1;

        // source 长度，最长为 8
        int len = source.length;

        int maxIndex = len - 1;

        for (int i = len - 2; i >= 0; i--) {

            // 一旦前边有 char 大于后面，更新 maxIndex
            if (source[i] > source[maxIndex]) {
                maxIndex = i;
                continue;
            }

            // 遇到条件符合的场景，更新需要替换的 2 个位置变量
            if (source[i] < source[maxIndex]) {
                one = i;
                two = maxIndex;
            }
        }

        if (one > -1) {
            char tmp = source[one];
            source[one] = source[two];
            source[two] = tmp;
            return Integer.parseInt(new String(source));
        }

        return num;
    }
}
