package java01619.m01;

import java.util.Arrays;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-14 21:14
 * @Update Date Time: 2022-09-14 21:14
 * @Updated-By: alton_z
 * @Update-Location:
 * 1619. Mean of Array After Removing Some Elements #477
 */
class Solution {
    public double trimMean(int[] arr) {

        int len = arr.length;
        Arrays.sort(arr);

        long sum = 0;
        for(int i = len/20; i < len*19/20; i++) {
            sum += arr[i];
        }

        return sum / (len * 0.9);
    }
}
