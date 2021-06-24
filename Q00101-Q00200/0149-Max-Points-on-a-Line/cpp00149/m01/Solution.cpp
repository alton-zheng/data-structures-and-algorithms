// Runtime: 8 ms, faster than 95.16% of C++ online submissions for Max Points on a Line.
// Memory Usage: 8.6 MB, less than 80.96% of C++ online submissions for Max Points on a Line.
class Solution {
public:
    int gcd(int a, int b) {
        return b ? gcd(b, a % b) : a;
    }

    int maxPoints(vector<vector<int>>& points) {

        int n = points.size();

        // 在点的总数量小于等于 22 的情况下，我们总可以用一条直线将所有点串联，此时我们直接返回点的总数量即可
        if (n <= 2) {
            return n;
        }

        int res = 0;

        for (int i = 0; i < n; i++) {

            // 当我们找到一条直线经过了图中超过半数的点时，我们即可以确定该直线即为经过最多点的直线；
            // 当我们枚举到点 i（假设编号从 0 开始）时，我们至多只能找到 n−i 个点共线。
            // 假设此前找到的共线的点的数量的最大值为 k，如果有 k ≥ n−i，那么此时我们即可停止枚举，因为不可能再找到更大的答案了
            if (res >= n - i || res > n / 2) {
                break;
            }

            unordered_map<int, int> help;

            // 当我们枚举到点 i 时，我们只需要考虑编号大于 i 的点到点 i 的斜率，
            // 因为如果直线同时经过编号小于点 i 的点 j，那么当我们枚举到 j 时就已经考虑过该直线了；
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    // 我们将二元组中两个数同时取相反数即可
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    // 将分子和分母同时除以二者绝对值的最大公约数
                    int gcdXY = gcd(abs(x), abs(y));
                    x /= gcdXY, y /= gcdXY;
                }

                // 斜率 ： slope =  Δy/Δx
                // 由于 x, y 在题目中取值范围， 将 x 乘以 20001 , 避免 help key 冲突
                help[y + x * 20001]++;
            }
            int maxn = 0;
            for (auto& [_, num] : help) {
                maxn = max(maxn, num + 1);
            }

            // 取每种斜率中点数最多的点数
            res = max(res, maxn);
        }
        return res;
    }
};