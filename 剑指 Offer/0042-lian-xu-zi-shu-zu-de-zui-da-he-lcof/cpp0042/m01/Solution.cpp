// 执行用时： 24 ms , 在所有 C++ 提交中击败了 66.42% 的用户
// 内存消耗： 22.4 MB , 在所有 C++ 提交中击败了 42.34% 的用户
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int pre = 0, res = INT_MIN;

        for (int num: nums) {

            if (pre <= 0) {
                res = max(res, num);
                pre = 0;
            } else {
                res = max(res, pre + num);
            }

            pre += num;

        }

        return res;
    }
};