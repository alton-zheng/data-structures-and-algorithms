// Runtime: 292 ms, faster than 5.21% of C++ online submissions for Continuous Subarray Sum.
// Memory Usage: 96.3 MB, less than 85.32% of C++ online submissions for Continuous Subarray Sum.
class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {

        int numsLen = nums.size();

        if (numsLen < 2) {
            return false;
        }
        int remainder = 0;
        unordered_map<int, int> help;
        help[0] = -1;

        for (int i = 0; i < numsLen; i++) {
            remainder = (remainder + nums[i]) % k;

            if (help.count(remainder)) {
                if ((i - help[remainder]) > 1) {
                    return true;
                }
            } else {
                help[remainder] = i;
            }

        }

        return false;

    }
};
