// Runtime: 12 ms, faster than 99.56% of C++ online submissions for Find Pivot Index.
// Memory Usage: 31.1 MB, less than 64.91% of C++ online submissions for Find Pivot Index.
class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        // 将数组分成 3 部分， pre, cur, preSum - cur
        // pre = preSum - cur 时，返回 cur 位置索引
        int pre = 0, cur = 0, len = nums.size();
        int preSum = 0;

        for (int i = 0; i < len; i++) {
            preSum += nums[i];
        }

        for (int i = 0; i < len; i++) {
            // 到当前索引为止的前缀和 cur
            cur = pre + nums[i];

            // pre = preSum - cur 时，意味着前后之和相等
            if (pre == preSum - cur) {
                return i;
            }
            pre = cur;
        }

        return -1;
    }
};