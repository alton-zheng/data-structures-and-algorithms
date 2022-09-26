package java1719.m02;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-26 16:07
 * @Update Date Time: 2022-09-26 16:07
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public int[] missingTwo(int[] nums) {

        // xorRes 为 2 个消失数的异或结果值
        int len = nums.length + 2, xorRes = 0;
        for (int num: nums) {
            xorRes ^= num;
        }

        for (int i = 1; i <= len; i++) {
            xorRes ^= i;
        }

        // 两个消失数二进制 1 差几个
        int diff = xorRes & -xorRes;

        // 定义消失的其中一位变量
        int first = 0;

        for (int num: nums) {
            if ((diff & num) > 0) {
                first ^= num;
            }
        }

        for (int i = 1; i <= len; i++) {
            if ((diff & i) > 0) {
                first ^= i;
            }
        }

        return new int[]{first, xorRes ^ first};

    }
}
