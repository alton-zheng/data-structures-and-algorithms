package java01128.m01;

/**
 * @Author: alton
 * @Date: Created in 7/16/21 1:36 PM
 * @Description:
 * 1128. Number of Equivalent Domino Pairs #213
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
 *
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 *
 * Example 1:
 *
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 *
 * Time Complexity : O(N)
 * Space Complexity : O(100)
 *
 * Runtime: 2 ms, faster than 99.25% of Java online submissions for Number of Equivalent Domino Pairs.
 * Memory Usage: 48.3 MB, less than 60.90% of Java online submissions for Number of Equivalent Domino Pairs.
 *
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] help = new int[100];

        for (int[] domi : dominoes) {
            int cur = domi[0] > domi[1] ? domi[0] * 10 + domi[1] : domi[1] * 10 + domi[0];
            res += help[cur];
            help[cur]++;
        }

        return res;
    }
}
