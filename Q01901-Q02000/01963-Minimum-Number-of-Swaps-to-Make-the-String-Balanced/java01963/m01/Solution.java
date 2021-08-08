package java01963.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/8 3:52 下午
 * @Description:
 *
 * 1963. Minimum Number of Swaps to Make the String Balanced #286
 *
 * You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
 *
 * A string is called balanced if and only if:
 *
 * It is the empty string, or
 * It can be written as AB, where both A and B are balanced strings, or
 * It can be written as [C], where C is a balanced string.
 * You may swap the brackets at any two indices any number of times.
 *
 * Return the minimum number of swaps to make s balanced.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "][]["
 * Output: 1
 * Explanation: You can make the string balanced by swapping index 0 with index 3.
 * The resulting string is "[[]]".
 * Example 2:
 *
 * Input: s = "]]][[["
 * Output: 2
 * Explanation: You can do the following to make the string balanced:
 * - Swap index 0 with index 4. s = "[]][[]".
 * - Swap index 1 with index 5. s = "[[][]]".
 * The resulting string is "[[][]]".
 * Example 3:
 *
 * Input: s = "[]"
 * Output: 0
 * Explanation: The string is already balanced.
 *
 *
 * Constraints:
 *
 * n == s.length
 * 2 <= n <= 106
 * n is even.
 * s[i] is either '[' or ']'.
 * The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * 执行用时： 16 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 46.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
 * 竞赛
 */
class Solution {
    public int minSwaps(String s) {
        int left = 0, right = 0;

        for (char c: s.toCharArray()) {
            if (c == '[') {
                left++;
            }else {

                if (left > 0) {
                    left--;
                } else {
                    right++;
                }

            }
        }

        if (right == 0 || right == 1) {
            return right;
        }

        int half = right >> 1;

        return right == half * 2 ? half : half + 1;
    }
}
