// Runtime: 4 ms, faster than 62.47% of C++ online submissions for Subsets.
// Memory Usage: 7.1 MB, less than 82.93% of C++ online submissions for Subsets.
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {

        vector<vector<int>> res;

        int n = nums.size();

        for (int i = 0; i < 1 << n ; i++) {
            vector<int> subset;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.push_back(nums[j]);
                }
            }

            res.push_back(subset);
        }

        return res;
    }
};