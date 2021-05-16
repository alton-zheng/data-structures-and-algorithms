class Solution {
public:
    int getMoneyAmount(int n) {
        /**
         * 我们需要使用一个 dp 矩阵， 其中 dp[i, j] 中最坏情况下最下开销的代价。
         * 现在我们只需要考虑如何求出这个 dp 数组
         * 如果区间只剩下一个数 k, 那么猜中的代价永远为 0，也就是说 dp(k, k) 都初始化为 0.
         */
        vector<vector<int>> dp(n + 1, vector<int>(n + 1));

        /**
         * 然后对于长度为 2 的区间，我们需要长度为 1 的区间的结果。
         * 因此我们可以看出，为了求出长度为 len 区间的值，我们需要所有长度为 len - 1 的解
         * 因此我们按照长度从短到长求出 dp 数组
         */
        for (int len = 2; len <= n; len++) {
            for(int start = 1; start <= n - len + 1; start++) {
                int minRes = 0x7fffffff;
                /**
                 * dp[i][j] = min(pivot + max(dp[i][pivot - 1], dp[pivot][n])
                 * pivot 为以哪个元素为轴
                 * 优化： pivot 以 start + (len  - 1)/2 为 起点，到 start + len - 1 为终点
                 */
                for (int pivot = start + (len - 1) / 2; pivot < start + len - 1; pivot++){
                    int temp = pivot + max(dp[start][pivot - 1], dp[pivot + 1][start + len - 1]);
                    minRes = temp <= minRes ? temp : minRes;
                }

                dp[start][start + len - 1] = minRes;
            }
        }

        return dp[1][n];
    }
};