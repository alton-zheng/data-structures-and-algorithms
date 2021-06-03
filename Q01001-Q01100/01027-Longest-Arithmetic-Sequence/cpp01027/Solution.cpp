// Runtime: 120 ms, faster than 91.15% of C++ online submissions for Longest Arithmetic Subsequence.
// Memory Usage: 13.9 MB, less than 89.65% of C++ online submissions for Longest Arithmetic Subsequence.
class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {

        int numsLen = nums.size();
        int maxNum = *max_element(nums.begin(), nums.end());

        // dp[i][j]：以第i位数为结尾且公差为j的最长等差子序列长度
        int dp[numsLen][maxNum * 2 + 2];

        // 初始化 dp 元素，为 0
        memset(dp, 0, sizeof(dp));

        // 初始化结果值为 2， numsLen >= 2, 说明结果值最小为 2
        int result = 2;

        for (int i = 1; i < numsLen; i++) {
            for (int j = i - 1; j >= 0; j--) {

                // 计算公差
                int diff = (nums[i] - nums[j]) + maxNum;

                // 计算 nums[i] 结尾的 diff 的最长子序列长度
                dp[i][diff] = max(dp[i][diff], dp[j][diff] == 0 ? 2 : dp[j][diff] + 1);

                // 求 result 最大值
                result = max(result, dp[i][diff]);
            }
        }
        return result;
    }
};