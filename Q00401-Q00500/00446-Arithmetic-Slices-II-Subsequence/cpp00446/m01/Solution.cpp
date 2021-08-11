

// Runtime: 640 ms, faster than 67.01% of C++ online submissions for Arithmetic Slices II - Subsequence.
// Memory Usage: 154.7 MB, less than 49.66% of C++ online submissions for Arithmetic Slices II - Subsequence.
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int len = nums.size();

        int res = 0;

        vector<unordered_map<long, int>> help(len);


        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                long d = (long)nums[j]- nums[i];
                auto a = help[i].find(d);
                int cnt = a == help[i].end() ? 0 : a -> second;
                res += cnt;
                help[j][d] += cnt + 1;
            }
        }

        return res;

    }
};