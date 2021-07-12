package java00275.m01;

/**
 * @Author: alton
 * @Date: Created in 7/12/21 7:43 PM
 * @Description:
 *
 * 275. H-Index II #198
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in an ascending order, return compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.
 *
 * If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * You must write an algorithm that runs in logarithmic time.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 *
 * Input: citations = [1,2,100]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == citations.length
 * 1 <= n <= 105
 * 0 <= citations[i] <= 1000
 * citations is sorted in ascending order.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 * Runtime: 1 ms, faster than 18.74% of Java online submissions for H-Index II.
 * Memory Usage: 45.8 MB, less than 86.01% of Java online submissions for H-Index II.
 *
 *
 */
class Solution {
    public int hIndex(int[] citations) {

        int len = citations.length;

        int h = len;
        for (int i = len; i >= 0; i--) {
            if (citations[len - h] > h) {
                return h;
            }
        }
        return h;
    }
}
