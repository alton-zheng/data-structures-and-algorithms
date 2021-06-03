// Runtime: 216 ms, faster than 5.33% of C++ online submissions for Contiguous Array.
// Memory Usage: 83.9 MB, less than 40.96% of C++ online submissions for Contiguous Array.
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int res = 0, ones = 0, temp = 0, numsLen = nums.size();

        unordered_map<int, int> help;
        help[0] = -1;

        for (int i = 0; i < numsLen; i++) {
            temp = nums[i] == 1 ?  ones++ : ones--;
            temp = help.count(ones) ? res = max(res, i - help[ones]) : help[ones] = i;
        }

        return res;
    }
};