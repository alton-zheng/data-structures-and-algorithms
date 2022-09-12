package java01608.m02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-12 09:39
 * @Update Date Time: 2022-09-12 09:39
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }

        for (int i = 1; i <= len; i++) {
            if (nums[i - 1] >= i && (i == len || nums[i] < i)) {
                return i;
            }
        }

        return -1;
    }

}
