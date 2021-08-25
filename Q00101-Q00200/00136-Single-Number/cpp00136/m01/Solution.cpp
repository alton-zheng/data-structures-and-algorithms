// Runtime: 16 ms, faster than 84.66% of C++ online submissions for Single Number.
// Memory Usage: 17 MB, less than 51.76% of C++ online submissions for Single Number.
class Solution {
public:
    int singleNumber(vector<int>& nums) {

        int res = 0;

        for (int num: nums) {
            res ^= num;
        }

        return res;

    }
};