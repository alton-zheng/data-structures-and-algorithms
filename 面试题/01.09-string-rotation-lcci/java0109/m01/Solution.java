package java0109.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-29 09:08
 * @Update Date Time: 2022-09-29 09:08
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public boolean isFlipedString(String s1, String s2) {

        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len != s2Len) {
            return false;
        }

        if (s1Len == 0) {
            return true;
        }

        for (int i = 0; i < s1Len; i++) {
            boolean flag = true;

            for (int j = 0; j < s2Len; j++) {
                if (s1.charAt((i + j) % s1Len) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }
}
