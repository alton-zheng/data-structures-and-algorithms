// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Predict the Winner.
// Memory Usage: 7.3 MB, less than 87.15% of C++ online submissions for Predict the Winner.
class Solution {
public:
    bool PredictTheWinner(vector<int>& nums) {
        int len = nums.size();
        vector<int> help(len);

        for (int i = 0; i < len; i++) {
            help[i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                help[j] = max(nums[i] - help[j], nums[j] - help[j - 1]);
            }
        }

        return help[len - 1] >= 0;
    }
};