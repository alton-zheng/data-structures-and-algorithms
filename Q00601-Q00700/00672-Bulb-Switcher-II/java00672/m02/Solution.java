package java00672.m02;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-15 17:50
 * @Update Date Time: 2022-09-15 17:50
 * @Updated-By: alton_z
 * @Update-Location:
 */
public class Solution {

    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }

        if (n == 1) {
            return 2;
        }

        if (n == 2) {
            return presses == 1 ? 3 : 4;
        }

        return presses == 1 ? 4 : presses == 2 ? 7 : 8;
    }
}
