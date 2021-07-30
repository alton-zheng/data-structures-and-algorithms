// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Valid Perfect Square.
// Memory Usage: 5.9 MB, less than 62.46% of C++ online submissions for Valid Perfect Square.
class Solution {
public:
    bool isPerfectSquare(int num) {

        // 等于 1 时，是个特例，不在半数约束内，直接返回即可
        if (num == 1) {
            return true;
        }

        // 定义二分左右边界， 1 是特例，所以 left = 2
        // right 为输入 num 的一半
        int left = 2, right = num >> 1;

        while (left <= right) {

            // 获取 p 值
            int p = ((right - left) >> 1) + left;

            // 由于 p * p 可能超出 int 的上限，强转 long
            // 相等值，说明 num 属于完全平方数
            if ((long) p * p == num) {

                // 这时候返回 true 即可
                return true;
            }

            // 如果 p 平方大于 num, 意味着当前值相比 num 的近似平方根要大
            // 此时将 right 左移
            if ((long)p * p > num) {
                right = p - 1;
            } else {

                // 反之 left 右移
                left = p + 1;
            }
        }

        // 都不满足条件时，说明 num 非完全平方根
        return false;
    }
};