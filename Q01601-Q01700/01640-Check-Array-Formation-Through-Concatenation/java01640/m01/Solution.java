package java01640.m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-22 13:49
 * @Update Date Time: 2022-09-22 13:49
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {

        int[] help = new int[101];

        for (int i = 0; i < arr.length; i++) {
            help[arr[i]] = i + 1;
        }

        for (int[] piece : pieces) {
            int index = help[piece[0]] - 1;
            for (int p : piece) {
                if (index < 0 || index >= arr.length || help[arr[index]] == 0 || arr[index++] != p) {
                    return false;
                }
            }
        }

        return true;
    }
}
