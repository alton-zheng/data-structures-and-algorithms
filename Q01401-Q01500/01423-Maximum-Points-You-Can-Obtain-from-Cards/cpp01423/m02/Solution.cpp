//Runtime: 48 ms, faster than 94.26% of C++ online submissions for Maximum Points You Can Obtain from Cards.
// Memory Usage: 42.5 MB, less than 48.49% of C++ online submissions for Maximum Points You Can Obtain from Cards.
class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {

        // 卡牌数量
        int cardNum = cardPoints.size();

        // 定义前缀和（所有卡片和）, 最后用它减去连续的 cardNum - k 个元素的最小值
        // 求出最终结果值
        int preSum = 0;

        for(int i = 0; i < cardNum; i++) {
            preSum += cardPoints[i];
        }

        // 定义 help 值，一直保持 cardNum - k 个卡片值和
        int help = 0;

        // 首先从尾部向前取 k 个卡片，求出他们的卡片数值和
        for (int i = 0; i < cardNum - k; i++) {
            help += cardPoints[i];
        }

        // 等于 0 时，意味着， 卡片数量刚好等于 k, 直接返回前缀和即可
        if (help == 0) {
            return preSum;
        }


        // 定义最小值 ，初始化为 help
        int minValue = help;

        // 从卡片数组从 cardNum - k 到 cardNum - 1
        for (int i = cardNum - k; i < cardNum; i++) {

            // 窗口后面新增值
            help += cardPoints[i];

            // 窗口前面减去一个值
            help -= cardPoints[i + k - cardNum];

            // 求出最大的结果值
            minValue = min(minValue, help);
        }

        return preSum - minValue;
    }
};