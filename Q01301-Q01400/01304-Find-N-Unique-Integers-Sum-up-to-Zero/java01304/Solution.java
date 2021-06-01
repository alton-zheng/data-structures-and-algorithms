package java01304;

/**
 * @Author: alton
 * @Date: Created in 6/1/21 7:02 PM
 * @Description:
 * 1304. Find N Unique Integers Sum up to Zero #65
 *
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
 * Memory Usage: 39.5 MB, less than 5.55% of Java online submissions for Find N Unique Integers Sum up to Zero.
 */
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = i - n / 2;
            res[i] = temp;
            count += temp;
        }

        res[n - 1] = -count;
        return res;
    }
}
