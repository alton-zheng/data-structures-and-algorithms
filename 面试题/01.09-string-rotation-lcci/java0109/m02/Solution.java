package java0109.m02;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-29 09:09
 * @Update Date Time: 2022-09-29 09:09
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
