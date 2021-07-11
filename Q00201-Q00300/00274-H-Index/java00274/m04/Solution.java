package java00274.m04;

/**
 * @Author: alton
 * @Date: Created in 7/11/21 9:29 AM
 * @Description:
 *
 * 274. H-Index #195
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.
 *
 * If there are several possible values for h, the maximum one is taken as the h-index.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 *
 * Input: citations = [1,3,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index.
 * Memory Usage: 38.8 MB, less than 12.48% of Java online submissions for H-Index.
 */
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] help = new int[len + 1];

        for (int c: citations) {
            if (c < len) {
                help[c]++;
            } else {
                help[len]++;
            }
        }

        // 从最高 h 开始遍历
        for (int h = len, total = 0; h >= 0; h--) {

            // 累计引用次数大于等于 h 的文章数 total
            if (help[h] > 0) {
                total += help[h];
            }

            // 文章数满足 h 的直接返回
            if (total >= h) {
                return h;
            }

        }
        return 0;
    }
}
