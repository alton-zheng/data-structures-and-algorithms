package java01331.m01;

/**
 * @Author: alton
 * @Date: Created in 6/29/21 7:32 PM
 * @Description:
 * 1331. Rank Transform of an Array #158
 *
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following rules:
 *
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 *
 *
 * Example 1:
 *
 * Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
 * Example 2:
 *
 * Input: arr = [100,100,100]
 * Output: [1,1,1]
 * Explanation: Same elements share the same rank.
 * Example 3:
 *
 * Input: arr = [37,12,28,9,100,56,80,5,12]
 * Output: [5,3,4,2,8,6,7,1,3]
 *
 *
 * Constraints:
 *
 * 0 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 *
 * Time Complexity : O(3n)
 * Space Complexity ： O(max - min)
 *
 * Runtime: 4 ms, faster than 99.20% of Java online submissions for Rank Transform of an Array.
 * Memory Usage: 53.7 MB, less than 73.56% of Java online submissions for Rank Transform of an Array.
 */
class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // 遍历一遍数组获取 min 和 max
        for (int num: arr) {
            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        // 存在的元素置为 1 标记
        int[] count = new int[max - min + 1];
        for (int num: arr) {
            count[num - min] = 1;
        }

        // 统计出前缀和
        int[] preSum = new int[count.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + count[i - 1];
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = preSum[arr[i] - min] + 1;
        }

        return res;
    }
}
