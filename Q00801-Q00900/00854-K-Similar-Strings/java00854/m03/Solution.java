package java00854.m03;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-21 21:00
 * @Update Date Time: 2022-09-21 21:00
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {

    int k;
    String target;

    public int kSimilarity(String s1, String s2) {

        if (s1.equals(s2)) {
            return 0;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // 因为 s1, s2 是相同长度的字符串，因此我们只要遍历一次即可
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
            }
        }

        target = sb2.toString();
        int len = sb1.length();
        k = len - 1;

        dfs(sb1.toString(), 0, 0);

        return k;
    }

    private void dfs(String sb1, int offset, int cost) {

        if (cost > k || cost + minCost(sb1, offset) >= k) {
            return;
        }

        while (offset < sb1.length() && sb1.charAt(offset) == target.charAt(offset)) {
            offset++;
        }


        if (offset == sb1.length())  {
            k = Math.min(k, cost);
            return;
        }


        for (int i = offset + 1; i < sb1.length(); i++) {
            if (sb1.charAt(i) == target.charAt(offset)) {
                String temp = swap(sb1, i, offset);
                dfs(temp, offset + 1, cost + 1);
            }
        }

    }

    private int minCost(String sb1, int offset) {

        int res = 0;

        for (int i = offset; i < sb1.length(); i++) {
            if (sb1.charAt(i) != target.charAt(i)) {
                res++;
            }
        }

        return (res + 1) / 2;
    }

    private String swap(String sb1, int i , int j) {
        char[] cr = sb1.toCharArray();

        char temp = cr[i];
        cr[i] = cr[j];
        cr[j] = temp;

        return new String(cr);

    }
}
