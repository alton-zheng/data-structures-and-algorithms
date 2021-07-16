// Runtime: 96 ms, faster than 98.00% of C++ online submissions for Best Time to Buy and Sell Stock.
// Memory Usage: 93.3 MB, less than 50.89% of C++ online submissions for Best Time to Buy and Sell Stock.
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int res = 0;
        int low = prices[0], high = prices[0];

        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] < low) {
                low = prices[i];
                high = prices[i];
            }

            if (prices[i] > high) {
                high = prices[i];
            }

            res = max(res, high - low);
        }

        return res;
    }
};