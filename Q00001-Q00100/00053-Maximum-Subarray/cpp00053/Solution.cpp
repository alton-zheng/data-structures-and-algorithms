// Runtime: 4 ms, faster than 91.38% of C++ online submissions for Maximum Subarray.
// Memory Usage: 13.1 MB, less than 50.43% of C++ online submissions for Maximum Subarray.
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int numsLen = nums.size();
        int pre = nums[0];
        int res = nums[0];

        for (int i = 1; i < numsLen; i++) {
            pre = max(nums[i], pre + nums[i]);
            res = max(res, pre);
        }

        return res;
    }
};