package java00788.m01;

/**
 * 枚举方法
 */
class Solution {
    static int[] help = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            String cur = String.valueOf(i);
            boolean condition1 = true, condition2 = false;
            for (int j = 0; j < cur.length(); ++j) {
                char ch = cur.charAt(j);
                if (help[ch - '0'] == -1) {
                    condition1 = false;
                    break;
                }

                // women 没什么的
                if (help[ch - '0'] == 1) {
                    condition2 = true;
                }
            }

            if (condition1 && condition2) {
                res++;
            }
        }
        return res;
    }
}

