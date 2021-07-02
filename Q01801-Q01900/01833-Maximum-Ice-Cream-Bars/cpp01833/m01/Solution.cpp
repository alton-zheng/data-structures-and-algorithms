// Runtime: 140 ms, faster than 97.95% of C++ online submissions for Maximum Ice Cream Bars.
// Memory Usage: 80.6 MB, less than 5.19% of C++ online submissions for Maximum Ice Cream Bars.
class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        int ma = INT_MIN, mi = INT_MAX;
        for (int cost: costs) {
            ma = max(ma, cost);
            mi = min(mi, cost);
        }

        vector<int> help(ma + 1);

        for (int cost: costs) {
            help[cost]++;
        }

        int res = 0;
        for (int i = mi; i <= ma; i++) {
            if (coins >= i) {
                int count = min(help[i], coins / i);
                res += count;
                coins -= i * count;
            }
        }

        return res;
    }
};