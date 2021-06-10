// Runtime: 68 ms, faster than 34.76% of C++ online submissions for Find All Numbers Disappeared in an Array.
// Memory Usage: 33.8 MB, less than 51.31% of C++ online submissions for Find All Numbers Disappeared in an Array.
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int len = nums.size();

        for (auto& num: nums) {
            int i = (num - 1) % len;
            nums[i] += len;
        }

        vector<int> res;

        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                res.push_back(i + 1);
            }
        }

        return res;
    }
};