package java00769.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-10-13 14:00
 * @Update Date Time: 2022-10-13 14:00
 * @Updated-By: alton_z
 * @Update-Location:
 * 00769-Max-Chunks-To-Make-Sorted
 *
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {

        int max = 0, res = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
            if (i == max) {
                res++;
            }
        }

        return res;
    }
}
