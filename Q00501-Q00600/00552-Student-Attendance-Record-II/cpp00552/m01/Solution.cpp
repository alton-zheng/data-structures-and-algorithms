

class Solution {
public:
    int checkRecord(int n) {

        const int mod = 1000000007;
        // 第一维度为考勤记录天数 n, [0, n]
        // 第二维度为 A  [0, 1] 合理范围，最多只有一个 A
        // 第二维度为 L [0, 2] 合理范围， 最多连续 'L' 只有 2 个,超过 2 个清零
        vector<vector<vector<int>>> help(n + 1, vector<vector<int>>(2, vector<int>(3)));

        help[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {

            // 考勤记录为 A 时， 第二维度为 1，  i - 1 天的记录第二维度必须为 0才有意义
            // 第三维度请零
            for (int k = 0; k <= 2; k++) {
                help[i][1][0] = (help[i][1][0] + help[i - 1][0][k]) % mod;
            }

            // 考勤记录为 P 时
            // A 数量不变
            // L 数量清零
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    help[i][j][0] = (help[i][j][0] + help[i - 1][j][k]) % mod;
                }
            }

            // 考勤记录为 L 时
            // A 数量不变
            // L 数量加 1
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    help[i][j][k] = (help[i][j][k] + help[i - 1][j][k - 1]) % mod;
                }
            }
        }

        int res = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                res = (res + help[n][j][k]) % mod;
            }

        }

        return res;
    }
};