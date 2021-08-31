package java01588.m01;


/**
 * @Author: alton
 * @Date: Created in 5/17/21 8:10 PM
 * @Description:
 * 1588. Sum of All Odd Length Subarrays
 * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * Return the sum of all odd-length subarrays of arr.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,4,2,5,3]
 * Output: 58
 * Explanation: The odd-length subarrays of arr and their sums are:
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: 3
 * Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
 * Example 3:
 *
 * Input: arr = [10,11,12]
 * Output: 66
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 * 下面的方法比较取巧，也可以说是一种找规律解题的一种方法
 * 遍历一遍所有的元素，然后查看这个元素会在多少个长度为奇数的数组中出现过
 * 然后数组中的每个元素都乘以出现的次数，即可计算出总和
 * 重难点是如何找到元素在多少个长度为奇数的数组中出现过
 * 对于一个数字它所在的数组，
 *   left: left = i + 1 种选择；
 *   right: right = n - i 中选择
 * 意味着如果在数字前面有偶数个数字，后面也必须要有偶数个数字，才能够构成奇数长度的数组；
 * 如果在前面选择了奇数个数字，那么在后面，也必须选择奇数个数字，这样加上它自身，才构成奇数长度的数组；
 * leetcode cost: 0 ms
 * fast than 100.00% of java online submissions for Sum of All Odd Length Subarrays
 * Memory Usage: 36.3 MB , less than 93.66% of java online submisssions for Sum of all Odd length subarrays
 *
 * Time Complexity: O(N)
 * Space Complexity:O(1)
 */
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {

        int res = 0;
        int aLen = arr.length;
        for (int i = 0; i < aLen; i++) {
            int left = i + 1, right = aLen - i;
            int leftEven = (left + 1) / 2, rightEven = (right + 1) / 2;
            int leftOdd = left / 2, rightOdd = right / 2;
            res += (leftEven * rightEven + leftOdd * rightOdd) * arr[i];
        }
        return res;
    }
}