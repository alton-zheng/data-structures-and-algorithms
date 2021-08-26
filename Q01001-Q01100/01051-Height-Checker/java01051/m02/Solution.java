package java01051.m02;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Height Checker.
 * Memory Usage: 37 MB, less than 29.89% of Java online submissions for Height Checker.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int heightChecker(int[] heights) {

        int[] help = new int[101];

        for (int height: heights) {
            help[height]++;
        }

        int res = 0;
        int idx = 0;
        for (int i = 1; i <= 100; i++) {
            while (help[i] > 0) {
                if (heights[idx++] != i) {
                    res++;
                }
                help[i]--;
            }
        }

        return res;
    }
}