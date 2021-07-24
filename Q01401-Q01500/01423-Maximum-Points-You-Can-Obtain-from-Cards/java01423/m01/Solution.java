package java01423.m01;

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
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Points You Can Obtain from Cards.
 * Memory Usage: 48.2 MB, less than 63.38% of Java online submissions for Maximum Points You Can Obtain from Cards.
 *
 *
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {

        // 卡牌数量
        int cardNum = cardPoints.length;

        // 定义 help 值，一直保持 k 个卡片值和
        int help = 0;

        // 首先从尾部向前取 k 个卡片，求出他们的卡片数值和
        for (int i = cardNum - k; i < cardNum; i++) {
            help += cardPoints[i];
        }


        // 定义结果值 ，初始化为 help
        int res = help;

        // 从卡片数组从 0 到 k - 1 ， 每取前面一个值，同时减去后面窗口最后的取得值
        for (int i = 0; i < k; i++) {
            // 前面多取一个值
            help += cardPoints[i];

            // 后面窗口减去窗口最前面的值
            help -= cardPoints[cardNum - k + i];

            // 求出最大的结果值
            res = Math.max(res, help);
        }

        return res;
    }
}