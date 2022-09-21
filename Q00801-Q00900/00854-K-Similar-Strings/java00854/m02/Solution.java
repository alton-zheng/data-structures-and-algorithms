package java00854.m02;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-21 20:34
 * @Update Date Time: 2022-09-21 20:34
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {

    String target;
    int res = 101;

    public int kSimilarity(String s1, String s2) {
        int len = s1.length();

        target = s2;
        dfs(s1, 0, 0);

        // 返回 k
        return res;
    }

    public void dfs(String s1, int offset, int k) {
        if (s1.equals(target) || offset == s1.length()) {
            res = Math.min(res, k);
            return;
        }

        while (offset < s1.length() && s1.charAt(offset) == target.charAt(offset)) {
            offset++;
        }

        for (int i = offset + 1; i < s1.length(); i++) {
            if (s1.charAt(i) != target.charAt(i) && s1.charAt(i) == target.charAt(offset)) {
                String temp = swap(s1, i, offset);
                dfs(temp, offset + 1, k + 1);
            }

        }

    }

    /**
     * swap (cur, i, j)
     *
     * @param cur
     * @param i
     * @param j
     * @return
     */
    public String swap(String cur, int i, int j) {
        char[] arr = cur.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kSimilarity("abc", "bca"));

    }
}
