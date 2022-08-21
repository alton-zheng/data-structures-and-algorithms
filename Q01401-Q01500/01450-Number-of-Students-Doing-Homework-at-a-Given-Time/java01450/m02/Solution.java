package java01450.m02;

import java.util.Arrays;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-19 15:17
 * @Update Date Time: 2022-08-19 15:17
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        // 求出学生人数
        int len = startTime.length;

        // 最大结束时间
        int maxEndTime = Arrays.stream(endTime).max().getAsInt();

        // 边界条件， queryTime 大于最大结束时间，说明 queryTime 在所有学生都结束写作业后
        // 一切没有意义， 没有一个学生在写作业
        if (queryTime > maxEndTime) {
            return 0;
        }

        // 定义差分数组 cnt
        int[] cnt = new int[maxEndTime + 2];

        // 统计出
        for (int i = 0; i < len; i++) {
            cnt[startTime[i]]++;
            cnt[endTime[i] + 1]--;
        }


        int res = 0;
        for (int i = 0; i <= queryTime; i++) {
            res += cnt[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().busyStudent(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}, 4));
    }
}
