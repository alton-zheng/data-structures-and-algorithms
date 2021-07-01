package java01539.m01;

/**
 * @Author: alton
 * @Date: Created in 7/1/21 11:23 PM
 * @Description:
 *
 * 1539. Kth Missing Positive Number #166
 *
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Find the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 *
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Missing Positive Number.
 * Memory Usage: 38.6 MB, less than 65.35% of Java online submissions for Kth Missing Positive Number.
 *
 */
class Solution {
    public int findKthPositive(int[] arr, int k) {

        for (int item: arr) {
            if (item <= k) {
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        System.out.println(new java01539.m01.Solution().findKthPositive(new int[]{2, 3, 4, 7, 10}, 7));
    }

}
