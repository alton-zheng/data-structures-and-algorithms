// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Target Sum.
// Memory Usage: 9.3 MB, less than 45.03% of C++ online submissions for Target Sum.
class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {

        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int negative = diff / 2;
        vector<int> help(negative + 1);
        help[0] = 1;
        for (int num : nums) {
            for (int j = negative; j >= num; j--) {
                help[j] += help[j - num];
            }
        }

        return help[negative];
    }
};
