package java01422;

/**
 * @Author: alton
 * @Date: Created in 5/19/21 1:44 PM
 * @Description: 1422. Maximum Score After Splitting a String #21
 * Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).
 * <p>
 * The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "011101"
 * Output: 5
 * Explanation:
 * All possible ways of splitting s into two non-empty substrings are:
 * left = "0" and right = "11101", score = 1 + 4 = 5
 * left = "01" and right = "1101", score = 1 + 3 = 4
 * left = "011" and right = "101", score = 1 + 2 = 3
 * left = "0111" and right = "01", score = 1 + 1 = 2
 * left = "01110" and right = "1", score = 2 + 1 = 3
 * Example 2:
 * <p>
 * Input: s = "00111"
 * Output: 5
 * Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
 * Example 3:
 * <p>
 * Input: s = "1111"
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= s.length <= 500
 * The string s consists of characters '0' and '1' only.
 * <p>
 * Time Complexity: O(2sLen)
 * Space Complexity: O(sLen)
 */
class Solution2 {

    public int maxScore(String s) {

        char[] sChar = s.toCharArray();
        int slen = sChar.length;

        // 初始化 l, r
        int l = sChar[0] == '0' ? 1 : 0, r = 0;

        // 第一次遍历，统计除首字符外的其它字符中 1 的个数
        for (int i = 1; i < slen; i++) {
            r += sChar[i] == '1' ? 1 : 0;
        }

        // 初始化  max = l（首字符为0时，1，为1时，0) + 上面遍历 1 的数量
        int max = l + r;

        // 第二次遍历, 不考虑最后一位，最后一位（跟 l 无关），
        // 相当于第二次遍历其实就是 l 在往右移动
        // 最后一位， r 的处理，在上面已经完成
        for (int i = 1; i < slen - 1; i++) {

            // 遇 0 l++, 遇 1 r--
            if (sChar[i] == '1') {
                l++;
            } else {
                r--;
            }

            max = Math.max(max, l + r);
        }

        return max;
    }

}

/**
 * 上面这种方式，需要时间复杂度相对高了点，下面通过一次循环搞定
 * Time Complexity: O(sLen)
 * Space Complexity: O(sLen)
 */
class Solution {

    public int maxScore(String s) {

        char[] sChar = s.toCharArray();
        int slen = sChar.length;

        // 初始化 l, r
        int l = sChar[0] == '0' ? 1 : 0, r = 0;

        // 初始化  max， 目前相当于只判断了首 char
        int max = l + r;

        // 接下来遍历剩余字符,从原理上来讲，是 l 往右移动，意味着遇到 '1' 时 r 要减去 1
        // 意味着，遍历后，其实统计的是 l 相对于 r 的最大优势数量
        for (int i = 1; i < slen; i++) {

            /**
             * 当遍历到最后一个字符时，跟 l 无关了
             * 也就是说,max 与 l 逻辑处理后，即为 max
             * 此时，也是返回结果的时机
             */
            if (i == slen - 1) {
                // max 减去 r;
               return max - (r - (sChar[slen - 1] == '1' ? 1 : 0));
            }

            // 遇到 '1' 时， r 减去 1， 由于没有统计过 1 的总数，所有，这里减去了多少
            // '1' 的数量就是多少
            if (sChar[i] == '1') {
                r--;
            } else {
                max = Math.max(max, ++l + r);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore("00111"));
    }
}