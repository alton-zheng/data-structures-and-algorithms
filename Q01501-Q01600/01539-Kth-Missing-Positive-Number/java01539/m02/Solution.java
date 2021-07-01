package java01539.m02;

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

        // 当 k 比首个元素还小时，直接返回 k
        if (arr[0] > k) {
            return k;
        }

        // 初始化 left = 0, right = length(arr)
        int left = 0, right = arr.length;
        while (left < right) {

            // 二分找中间索引值
            int mid = (left + right) >> 1;

            // mid 的值， 在长度范围内， 取数组中的值，否则取数字最大值
            int value = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;

            // 这里才是关键， value - mid - 1 可以找出当前位置前面缺失了多少个正整数 (当前值减去到当前位置的数组元素个数，很好理解)
            // 数量大于等于K，说明结果值是小于 value 的，意味着 right 左移
            if (value - mid - 1 >= k) {
                right = mid;
            } else {
                // 否则 left 右移动
                left = mid + 1;
            }
        }

        // 这里的结果需要数学推导，就不多解释了。
        // 结论， 最后的 left 值指的是数组中有多少元素是小于等于 (k 加上小于 k 的元素个数)， 多理解下就明白了
        return k + left;
    }
}
