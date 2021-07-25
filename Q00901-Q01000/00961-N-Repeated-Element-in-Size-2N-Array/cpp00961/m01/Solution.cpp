// Runtime: 54 ms, faster than 29.96% of C++ online submissions for N-Repeated Element in Size 2N Array.
// Memory Usage: 29.9 MB, less than 31.97% of C++ online submissions for N-Repeated Element in Size 2N Array.
class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        vector<int> help(10001);

        for (int num: nums) {
            help[num]++;
            if (help[num] > 1) {
                return num;
            }
        }

        return -1;
    }
};