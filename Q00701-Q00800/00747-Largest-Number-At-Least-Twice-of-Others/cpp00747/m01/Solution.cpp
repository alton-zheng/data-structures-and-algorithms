// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Largest Number At Least Twice of Others.
// Memory Usage: 10.8 MB, less than 67.22% of C++ online submissions for Largest Number At Least Twice of Others.
class Solution {
public:
    int dominantIndex(vector<int>& nums) {

        int max = INT_MIN;
        int idx = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }

        for (int num : nums) {
            if (num != max) {
                if (max < num * 2) {
                    return -1;
                }
            }
        }

        return idx;
    }
};