package java00926.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/10 5:09 下午
 * @Description:
 * Runtime: 8 ms, faster than 23.90% of Java online submissions for Flip String to Monotone Increasing.
 * Memory Usage: 39.8 MB, less than 21.07% of Java online submissions for Flip String to Monotone Increasing.
 */
class Solution {
    public int minFlipsMonoIncr(String s) {

        int len = s.length();
        int[] oneCnt = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            oneCnt[i] = oneCnt[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
        }

        int res = 100001;

        for (int i = 0; i <= len; i++) {
            res = Math.min(res, oneCnt[i] + len - i - (oneCnt[len] - oneCnt[i]));
        }

        return res;
    }
}
