package java06189.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-25 14:13
 * @Update Date Time: 2022-09-25 14:13
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int bitSize = 1 << n;
        int maxValue = 0;
        int res = 0;
        for(int i = 0;i<n;i++) maxValue = Math.max(maxValue, nums[i]);

        int temp = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == maxValue) {
                temp++;
            }

            if (nums[i] != maxValue) {
                if (temp > 0) {
                    res = Math.max(temp, res);
                    temp = 0;
                }
            }
        }
        return temp > 0 ? Math.max(res, temp) : res;
    }
}
