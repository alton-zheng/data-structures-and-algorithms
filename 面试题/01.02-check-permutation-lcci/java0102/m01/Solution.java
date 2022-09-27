package java0102.m01;

import java.util.Arrays;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-27 10:23
 * @Update Date Time: 2022-09-27 10:23
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
