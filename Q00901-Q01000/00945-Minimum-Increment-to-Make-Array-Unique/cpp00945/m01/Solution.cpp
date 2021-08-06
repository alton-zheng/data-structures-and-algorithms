
// Runtime: 140 ms, faster than 22.89% of C++ online submissions for Minimum Increment to Make Array Unique.
// Memory Usage: 94.1 MB, less than 5.01% of C++ online submissions for Minimum Increment to Make Array Unique.
class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {


        int len = nums.size();
        vector<int> help(100002);
        int minv = INT_MAX, maxv = INT_MIN;

        for (int i = 0; i < len; i++) {
            help[nums[i]]++;
            minv = min(minv, nums[i]);
            maxv = max(maxv, nums[i]);
        }

        int res = 0;
        int cur = minv;
        while (cur <= maxv) {
            if (help[cur] > 1) {
                help[cur + 1] += help[cur] - 1;
                res += help[cur] - 1;
            }

            cur++;
        }

        int x = help[maxv + 1] - 1;
        res += x > 0 ? x * (x + 1) / 2 : 0;

        return res;

    }
};

