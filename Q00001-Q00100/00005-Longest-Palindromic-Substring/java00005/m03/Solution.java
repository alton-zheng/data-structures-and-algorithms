package java00005.m03;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-11 20:27
 * @Update Date Time: 2022-09-11 20:27
 * @Updated-By: alton_z
 * @Update-Location:
 * manacher 算法
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // "12321" -> "#1#2#3#2#1#"
        // 加 % 处理串
        char[] str = manacherString(s);

        // 存储回文半径的大小
        int[] pHelp = new int[str.length];

        // 中心点位置
        int c = -1;

        // 扩成功 right 下一个位置
        int r = -1;

        // 初始 end 位置
        int end = 0;

        // 初始化最大值 max -> Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        // 遍历 str
        for (int i = 0; i < str.length; i++) { // 0 1 2

            // r 第一个违规的位置，i>= r
            // Math.min(pHelp[2 * c - i], r - i) 代表不用验证的半径区域
            // pHelp[2 * c - i] 代表 i^1
            pHelp[i] = r > i ? Math.min(pHelp[2 * c - i], r - i) : 1;

            // 满足边界条件的情况下， 处理
            while (i + pHelp[i] < str.length && i - pHelp[i] > -1) {

                // 更新回文范围，满足一次，半径 + 1
                // 一旦不满足，直接 break;
                if (str[i + pHelp[i]] == str[i - pHelp[i]]) {
                    pHelp[i]++;
                } else {
                    break;
                }
            }

            // 记录当前 end 值
            int e = 0;

            // r 需要发生变化（i 的回文半径越过之前的 r 时） 更新 end, r, c
            if (i + pHelp[i] > r) {


                // 更新 r -> i + pHelp[i]
                r = i + pHelp[i];

                //  r 是失效的点， -1  刚好为有效点
                e = r - 1;

                // 更新 c
                c = i;
            }

            // max -> 大的回文半径
            if (pHelp[i] > max) {
                max = pHelp[i];

                // 当前半径更大时，更新 end 变量值为 e
                // 其它场景 end 不需要发生变化
                end = e;
            }
        }

        // 半径大小 max - 1 等于原串回文长度
        int right = (end - 1) / 2;
        int left = right - max + 2;

        // 取最长回文串
        return s.substring(left, right + 1);

    }

    public char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '%' : charArr[index++];
        }
        return res;
    }
}
