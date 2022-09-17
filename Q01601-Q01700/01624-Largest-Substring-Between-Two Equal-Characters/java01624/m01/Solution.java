package java01624.m01;/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-17 10:40
 * @Update Date Time: 2022-09-17 10:40
 * @Updated-By: alton_z
 * @Update-Location:
 * 1624. Largest Substring Between Two Equal Characters #479
 */
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        int[] help = new int[26];

        for (int i = 0; i < 26; i++) {
            help[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (help[s.charAt(i) - 'a'] == -1) {
                help[s.charAt(i) - 'a'] = i;
                continue;
            }

            res = Math.max(res, i - help[s.charAt(i) - 'a'] - 1);

        }

        return res;
    }
}
