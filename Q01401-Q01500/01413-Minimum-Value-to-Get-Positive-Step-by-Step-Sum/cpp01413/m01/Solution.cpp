
// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Minimum Value to Get Positive Step by Step Sum.
// Memory Usage: 7.4 MB, less than 15.63% of C++ online submissions for Minimum Value to Get Positive Step by Step Sum.
class Solution {
public:
    int minStartValue(vector<int>& nums) {

        int preSum = nums[0];
        int m = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            preSum += nums[i];
            m = min(m, preSum);
        }

        return m > 0 ? 1 : abs(m) + 1;

    }
};