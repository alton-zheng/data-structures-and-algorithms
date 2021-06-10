// Runtime: 20 ms, faster than 51.30% of C++ online submissions for Coin Change 2.
// Memory Usage: 7.1 MB, less than 75.10% of C++ online submissions for Coin Change 2.
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> help(amount + 1);

        help[0] = 1;
        for (int coin: coins) {
            for (int c = coin; c <= amount; c++) {
                help[c] += help[c - coin];
            }
        }

        return help[amount];
    }
};