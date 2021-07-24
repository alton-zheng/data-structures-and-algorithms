//Runtime: 56 ms, faster than 69.80% of C++ online submissions for Maximum Points You Can Obtain from Cards.
// Memory Usage: 42.3 MB, less than 96.79% of C++ online submissions for Maximum Points You Can Obtain from Cards.

class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        // 卡牌数量
        int cardNum = cardPoints.size();

        // 定义 help 值，一直保持 k 个卡片值和
        int help = 0;

        // 首先从尾部向前取 k 个卡片，求出他们的卡片数值和
        for (int i = cardNum - k; i < cardNum; i++) {
            help += cardPoints[i];
        }


        // 定义结果值 ，初始化为当前 help 值
        int res = help;

        // 从卡片数组从 0 到 k - 1 ， 每取前面一个值，同时减去后面窗口最后的取得值
        for (int i = 0; i < k; i++) {
            // 前面多取一个值
            help += cardPoints[i];

            // 后面窗口减去窗口最前面的值
            help -= cardPoints[cardNum - k + i];

            // 求出最大的结果值
            res = max(res, help);
        }

        return res;
    }
};