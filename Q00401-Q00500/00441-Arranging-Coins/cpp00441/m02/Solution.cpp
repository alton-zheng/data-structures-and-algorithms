// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Arranging Coins.
// Memory Usage: 5.9 MB, less than 67.64% of C++ online submissions for Arranging Coins.
class Solution {
public:
    int arrangeCoins(int n) {
        int res = n;
        int right = min(n, 66000), left = 1;
        while (right >= left) {
            int level = left + (right - left) / 2;
            long total = (long)level * (level + 1) / 2;
            if (total > n) {
                right = level - 1;
            } else {
                left = level + 1;
                res = level;
            }
        }
        return res;
    }
};