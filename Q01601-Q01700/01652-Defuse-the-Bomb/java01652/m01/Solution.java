package java01652.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-24 18:37
 * @Update Date Time: 2022-09-24 18:37
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public int[] decrypt(int[] code, int k) {

        int len = code.length;
        if (k == 0) {
            return new int[len];
        }

        int[] help = new int[len * 3];
        help[0] = code[0];
        for (int i = 1; i < len * 3; i++) {
            help[i] = help[i - 1] + code[i % len];
        }

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {

            res[i] = k > 0 ? help[i + len + k] - help[i + len] : help[i + len - 1] - help[i + len - 1 + k];
        }

        return res;
    }

    public static void main(String[] args) {
        for (int a : new Solution().decrypt(new int[]{5,2,2,3,1}, 3)) {
            System.out.println(a);
        }
    }
}
