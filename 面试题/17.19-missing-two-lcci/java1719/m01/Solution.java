package java1719.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-26 11:17
 * @Update Date Time: 2022-09-26 11:17
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public int[] missingTwo(int[] nums) {

        int len = nums.length + 2;
        int twoSum = len * (len + 1) >> 1;
        for (int num: nums) {
            twoSum -= num;
        }

        int half = twoSum >> 1;

        int first = half * (half + 1) >> 1;
        for (int num: nums) {
            if (num <= half) {
                first -= num;
            }
        }

        return new int[]{first, twoSum - first};

    }
}
