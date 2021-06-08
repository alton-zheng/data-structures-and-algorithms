package java01049;

/**
 * @Author: alton
 * @Date: Created in 6/8/21 9:00 AM
 * @Description:
 *
 * 1049. Last Stone Weight II #87
 *
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
 * Example 2:
 *
 * Input: stones = [31,26,33,21,40]
 * Output: 5
 * Example 3:
 *
 * Input: stones = [1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 * Time Complexity: O(n * sum)
 * Space Complexity: O(n * sum)
 *
 * Runtime: 2 ms, faster than 81.26% of Java online submissions for Last Stone Weight II.
 * Memory Usage: 36.1 MB, less than 89.23% of Java online submissions for Last Stone Weight II.
 */
class Solution {
    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (int stone: stones) {
            sum += stone;
        }

        int bun = sum / 2;
        boolean[] help = new boolean[bun + 1];
        help[0] = true;

        for (int stoneWeight: stones) {
            for (int b = bun; b >= stoneWeight; b--) {
                help[b] = help[b] || help[b - stoneWeight];
            }
        }


        for (int b = bun;; b--) {
            if (help[b]) {
                return sum - 2 * b;
            }
        }
    }
}
