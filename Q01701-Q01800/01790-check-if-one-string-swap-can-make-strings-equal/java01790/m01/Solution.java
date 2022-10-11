package java01790.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-10-11 12:20
 * @Update Date Time: 2022-10-11 12:20
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }
        int eq = 0;
        int a = -1, b = -2 , c = -3, d = -4;
        for (int i = 0; i < s1.length(); i++) {
            char x = s1.charAt(i), y = s2.charAt(i);
            if (x != y)  {
                if (eq == 0) {
                    a = x;
                    c = y;
                } else {
                    b = x;
                    d = y;
                }
                eq++;
            }
        }

        return eq < 3 && (a == d && b == c);
    }
}
