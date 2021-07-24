package java01423.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/7/24 上午10:24
 * @Description:
 * 1423. Maximum Points You Can Obtain from Cards #235
 * There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
 *
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 *
 * Your score is the sum of the points of the cards you have taken.
 *
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 *
 *
 *
 * Example 1:
 *
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * Example 2:
 *
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 * Example 3:
 *
 * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 * Output: 55
 * Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 * Example 4:
 *
 * Input: cardPoints = [1,1000,1], k = 1
 * Output: 1
 * Explanation: You cannot take the card in the middle. Your best score is 1.
 * Example 5:
 *
 * Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * Output: 202
 *
 *
 * Constraints:
 *
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 *
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 *
 * slice window
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Points You Can Obtain from Cards.
 * Memory Usage: 48.2 MB, less than 63.38% of Java online submissions for Maximum Points You Can Obtain from Cards.
 *
 *
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {

        // 卡牌数量
        int cardNum = cardPoints.length;

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
        int min = help;

        // 从卡片数组从 cardNum - k 到 cardNum - 1
        for (int i = cardNum - k; i < cardNum; i++) {

            // 窗口后面新增值
            help += cardPoints[i];

            // 窗口前面减去一个值
            help -= cardPoints[i + k - cardNum];

            // 求出最大的结果值
            min = Math.min(min, help);
        }

        return preSum - min;

    }
}