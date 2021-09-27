package java00609.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/9/27 3:35 下午
 * @Description:
 */
class Solution {
    static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int len = s.length();

        // a = f[i-2], b = f[i-1], c = f[i]
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= len; ++i) {
            c = b * judge1(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * judge2(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    private int judge1(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    private int judge2(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }
}
