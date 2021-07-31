// Runtime: 4 ms, faster than 93.40% of C++ online submissions for Third Maximum Number.
// Memory Usage: 9.1 MB, less than 57.38% of C++ online submissions for Third Maximum Number.

class Solution {
public:
    int thirdMax(vector<int>& nums) {
        int len  = nums.size();

        // 长度小于等于 2 时，取最大值即可
        if (len <= 2) {
            return max(nums[0], nums[len - 1]);
        }

        long first, second, third;
        first = second = third = LONG_MIN;

        for (int i = 0; i < len; i++) {

            int cur = nums[i];

            // 由于第几大都是不能重复的，也就是说当前元素 cur 如果等于 first, second 时，忽略即可
            if (cur == first || cur == second) {
                // 忽略当前元素
                continue;
            }

            // 当前元素大于 first, 更新 first, second, third
            if (cur > first) {
                third = second;
                second = first;
                first = cur;
                continue;
            }

            // 当前元素大于 second, 更新 third, second 指针
            if (cur > second) {
                third = second;
                second = cur;
                continue;
            }

            // 大于 third 时，更新 third 指针
            if (cur > third) {
                third = cur;
            }
        }

        return third == LONG_MIN ? (int)first : (int)third;

    }
};