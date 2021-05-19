class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int numsLen = nums.size();

        // 加 2 个位置，收尾为 1， 为了处理时不超出边界
        vector<int> search(numsLen + 2);
        search[0] = search[numsLen + 1] = 1;

        // 存储在不同 start, end 时，能获取的最大 Coins 数
        vector<vector<int>> help = vector<vector<int>>(numsLen + 2, vector<int>(numsLen + 2));

        // search 数组，初始化（除收尾）
        for (int i = 1; i <= numsLen; i++) {
            search[i] = nums[i - 1];
        }


        // 倒数第二个索引位置开始，留位置给 mid, end
        for (int start = numsLen - 1; start >= 0; start--){

            // 至少比 start 大 2， 留出一个位给 mid
            for (int end = start + 2; end <= numsLen + 1; end++) {

                /**
                 * 请注意： mid 索引位置的气球是最后被戳破
                 * 它将 start, end 中间的气球，以 mid 位置，分成了两组气球，分而治之
                 * 虽然在此实现，并未分工合作
                 * 不断循环各个组合情况，求出最大值
                 */
                for (int mid = start + 1; mid < end; mid++) {
                    int sum = search[start] * search[mid] * search[end];
                    sum += help[start][mid] + help[mid][end];
                    help[start][end] = max(help[start][end], sum);
                }
            }
        }

        return help[0][numsLen + 1];
    }
};