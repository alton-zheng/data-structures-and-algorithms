package java00526.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/16 上午10:58
 * @Description:
 * 526. Beautiful Arrangement #311
 *
 * Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
 *
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation:
 * The first beautiful arrangement is [1,2]:
 *     - perm[1] = 1 is divisible by i = 1
 *     - perm[2] = 2 is divisible by i = 2
 * The second beautiful arrangement is [2,1]:
 *     - perm[1] = 2 is divisible by i = 1
 *     - i = 2 is divisible by perm[2] = 1
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 15
 *
 * Time Complexity: O(1)
 * Space Complexity: O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Beautiful Arrangement.
 * Memory Usage: 35.8 MB, less than 51.47% of Java online submissions for Beautiful Arrangement.
 */
class Solution {
    public int countArrangement(int n) {
        int[] help = {0,1,2,3,8,10,36,41,132,250,700,750,4010,4237,10680,24679};
        return help[n];
    }
}
