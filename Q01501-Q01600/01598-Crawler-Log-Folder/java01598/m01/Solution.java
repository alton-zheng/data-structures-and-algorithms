package java01598.m01;

import java.util.Objects;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-09 12:05
 * @Update Date Time: 2022-09-09 12:05
 * @Updated-By: alton_z
 * @Update-Location:
 *
 * 1598. Crawler Log Folder
 *
 *
 */
class Solution {
    public int minOperations(String[] logs) {

        int res = 0;

        for (String log: logs) {
            if ("./".equals(log)) {
                continue;
            }

            if (!"../".equals(log)) {
                res++;
            } else {
                if (res > 0) {
                    res--;
                }
            }
        }

        return res;
    }
}
