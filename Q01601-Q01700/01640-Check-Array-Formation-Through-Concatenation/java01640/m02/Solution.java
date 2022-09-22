package java01640.m02;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-22 16:19
 * @Update Date Time: 2022-09-22 16:19
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, Integer> help = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            help.put(arr[i], i);
        }

        for (int[] piece : pieces) {
            int index = help.getOrDefault(piece[0], -1);
            for (int p : piece) {
                if (index < 0 || index >= arr.length || !help.containsKey(arr[index]) || arr[index++] != p) {
                    return false;
                }
            }
        }

        return true;
    }
}
