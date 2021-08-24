package java00005.m02;

/**
 * 执行用时： 24 ms , 在所有 Java 提交中击败了 88.35% 的用户
 * 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 90.62% 的用户
 */
class Solution {
    public String longestPalindrome(String s) {

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {


            // 原地为中心
            int self = judgePalinedromeCenter(s, i, i);

            // 原地和原地后一个字符，两者为中心
            int len2 = judgePalinedromeCenter(s, i, i + 1);

            int len = Math.max(self, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    /**
     * 返回： 回文串的长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int judgePalinedromeCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
