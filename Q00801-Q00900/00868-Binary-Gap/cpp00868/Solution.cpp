class Solution {
public:
    int binaryGap(int n) {
        // 将N 二进制的前一个 1 的位置初始化为 -1
        // 结果值根据题意初始化 为 0
        int last = -1, res = 0;

        // 获取数字 N 的最高有效位
        int max = 0;
        int temp = n;
        while (temp > 0) {
            temp >>= 1;
            max++;
        }

        for (int i = 0; i < max; ++i) {

            // 判断二进制向右移动 i 位后，最小位是否为 1
            if (((n >> i) & 1) == 1) {

                // 更新最大间隔 res
                if (last >= 0) {
                    res = res >= i - last ? res : i - last;
                }

                // 更新二进制前 1 的位置
                last = i;
            }
        }

        return res;
    }
};