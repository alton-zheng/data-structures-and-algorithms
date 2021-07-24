// Runtime: 20 ms, faster than 95.16% of C++ online submissions for Non-decreasing Array.
// Memory Usage: 27 MB, less than 52.84% of C++ online submissions for Non-decreasing Array.

class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        int time = 0;

        for (int i = 0; i < nums.size() - 1; i++ ) {
            int cur = nums[i], next = nums[i + 1];

            if (cur > next) {
                time++;

                if (time > 1) {
                    return false;
                }

                if (i > 0 && next < nums[i - 1]) {
                    nums[i + 1] = cur;
                }

            }
        }

        return true;
    }
};