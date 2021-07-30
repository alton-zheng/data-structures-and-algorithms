// Runtime: 44 ms, faster than 90.89% of C++ online submissions for Array Partition I.
// Memory Usage: 28.3 MB, less than 6.32% of C++ online submissions for Array Partition I.
class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int res = 0;
        for (int i = 0; i < nums.size(); i += 2) {
            res += nums[i];
        }

        return res;
    }
};