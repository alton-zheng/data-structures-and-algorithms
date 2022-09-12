package java01608.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-12 09:25
 * @Update Date Time: 2022-09-12 09:25
 * @Updated-By: alton_z
 * @Update-Location:
 * 1608. Special Array With X Elements Greater Than or Equal X #474
 */
class Solution {
    public int specialArray(int[] nums) {

        int[] help = new int[1001];

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            help[num]++;
            max = Math.max(max, num);
        }


        for (int i = max - 1; i >= 0; i--) {
            help[i] += help[i + 1];
        }

        System.out.println(help[3]);
        int res = -1;
        for (int i = max; i >= 1; i--) {
            if (help[i] == i) {
                return i;
            }
        }

        return res;

    }
}
