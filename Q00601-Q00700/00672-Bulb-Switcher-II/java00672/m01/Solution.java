package java00672.m01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-15 13:51
 * @Update Date Time: 2022-09-15 13:51
 * @Updated-By: alton_z
 * @Update-Location:
 * 672. Bulb Switcher II #478
 */
class Solution {
    public int flipLights(int n, int presses) {

        // 定义 seen
        Set<Integer> seen = new HashSet<>();

        // 每个按钮 2 种状态， 组合就是 16 种状态
        for (int i = 0; i < 1 << 4; i++) {

            // 定义 pressArr 数组，长度为 4
            // 用来表示 4 个按钮的按动情况
            int[] pressArr = new int[4];

            // 每一种状态，判断4个开关状态，按 -》 1 不按 -》 0
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (i >> j) & 1;
            }

            // 统计最后处于按状态的开关个数
            int sum = Arrays.stream(pressArr).sum();

            // 最终灯状态按的状态大于要求的次数时，不符合要求，直接遗弃 sum > presses
            // 按的次数和要求的次数，必须同为奇数或者偶数，否则状态失效， 说明按的次数和要求的次数是不匹配的
            if (sum % 2 == presses % 2 && sum <= presses) {
                // 初始状态只有 1 栈或 3 栈灯亮， status 才为 1
                int status = pressArr[0] ^ pressArr[1] ^ pressArr[3];

                // status 的意思很明显，意味着4组灯亮灭状态
                if (n >= 2) {
                    status |= (pressArr[0] ^ pressArr[1]) << 1;
                }
                if (n >= 3) {
                    status |= (pressArr[0] ^ pressArr[2]) << 2;
                }
                if (n >= 4) {
                    status |= (pressArr[0] ^ pressArr[1] ^ pressArr[3]) << 3;
                }

                // 添加当前 status 到结果集中
                seen.add(status);
            }
        }

        // 返回 status 的个数
        return seen.size();
    }
}
