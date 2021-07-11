package java00274.m02;

import java.util.Arrays;

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
 * Time Complexity : O(N + logN)
 * Space Complexity: O(1)
 *
 * Runtime: 2 ms, faster than 20.05% of Java online submissions for H-Index.
 * Memory Usage: 39.2 MB, less than 5.34% of Java online submissions for H-Index.
 *
 * Binary search
 *
 */
class Solution {
    public int hIndex(int[] citations) {

        int left = 0 , right = citations.length + 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int cur = 0;

            // 对比方法二， 这里根据用例，对引用数组会遍历多次
            for (int c: citations) {
                if (c >= mid) {
                    cur++;
                }
            }

            if (cur < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
