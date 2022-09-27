package java0102.m02;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-27 10:26
 * @Update Date Time: 2022-09-27 10:26
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i) - 'a';
            table[c]--;
            if (table[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
