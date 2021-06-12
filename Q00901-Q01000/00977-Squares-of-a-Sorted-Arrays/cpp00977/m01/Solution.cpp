// Runtime: 32 ms, faster than 60.62% of C++ online submissions for Squares of a Sorted Array.
// Memory Usage: 25.8 MB, less than 80.48% of C++ online submissions for Squares of a Sorted Array.
class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        vector<int> res(nums.size());

        for (int i = 0; i < nums.size(); i++) {
            res[i] = nums[i] * nums[i];
        }

        sort(res.begin(), res.end());

        return res;
    }
};