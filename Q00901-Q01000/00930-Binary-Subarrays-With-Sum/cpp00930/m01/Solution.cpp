// Runtime: 24 ms, faster than 88.53% of C++ online submissions for Binary Subarrays With Sum.
// Memory Usage: 45.4 MB, less than 5.24% of C++ online submissions for Binary Subarrays With Sum.
class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {

        int sum = 0;
        int len = nums.size();
        vector<int> help(2 * len + 1);
        int res = 0;

        for (int num : nums) {
            help[sum + len]++;
            sum += num;
            res += help[sum - goal + len];
        }

        return res;

    }
};