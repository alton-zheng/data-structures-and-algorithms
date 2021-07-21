// Runtime: 32 ms, faster than 45.95% of C++ online submissions for Rotate Array.
// Memory Usage: 25.7 MB, less than 16.31% of C++ online submissions for Rotate Array.
class Solution {
public:
    void rotate(vector<int>& nums, int k) {

        int len = nums.size();
        k %= len;
        vector<int> help(len);

        for (int i = 0; i < len; i++) {
            help[(i + k) % len] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = help[i];
        }
    }
};