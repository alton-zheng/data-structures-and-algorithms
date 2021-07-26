// Runtime: 8 ms, faster than 92.58% of C++ online submissions for Longest Increasing Subsequence.
// Memory Usage: 10.4 MB, less than 83.49% of C++ online submissions for Longest Increasing Subsequence.
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        // 定义 len , nums 的长度
        int len = nums.size();

        // 定义结果集
        vector<int> res;

        // 开始遍历数组
        for(int num: nums) {

            // 获取当前结果集大小
            int s = res.size();

            // 定义 left, right 边界
            int left = 0, right = s - 1;

            // 当结果集为空或者结果集最大值小于数组当前值时，不进入搜索，直接将 left 赋值为 s 的尺寸值，加快查询
            if (s == 0 || res[s - 1] < num) {
                left = s;
                right = -1;
            }

            // left 小于 right 时，进入二分搜索
            while (left < right) {

                // 找到 mid 值
                int mid = left + ((right - left) >> 1);

                // 当 结果集 mid 值小于数据当前值时，到右半部分找
                if (res[mid] < num) {
                    left = mid + 1;
                } else {
                    // 反之，左半部分找
                    right = mid;
                }
            }

            // left 等于 结果集大小时，说明当前结果集最大值小于当前数组值，直接添加到结果集即可
            if (left == res.size()) {
                // 新增
                res.push_back(num);
            } else {
                // 修改
                res[left] = num;
            }

        }

        // 返回结果集大小
        return res.size();
    }
};