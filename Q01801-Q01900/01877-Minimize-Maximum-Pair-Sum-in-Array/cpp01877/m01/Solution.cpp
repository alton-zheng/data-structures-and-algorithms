// Runtime: 236 ms, faster than 62.17% of C++ online submissions for Minimize Maximum Pair Sum in Array.
// Memory Usage: 96.4 MB, less than 17.83% of C++ online submissions for Minimize Maximum Pair Sum in Array.
class Solution {
public:
    int minPairSum(vector<int>& nums) {

        sort(nums.begin(), nums.end());
        int len = nums.size();

        int res = -1;
        int left = 0, right = len - 1;

        while (left < right) {
            res = max(res, nums[left++] + nums[right--]);
        }

        return res;
    }
};