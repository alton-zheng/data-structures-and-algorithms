package java00003.m03;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-11 15:50
 * @Update Date Time: 2022-08-11 15:50
 * @Updated-By: alton_z
 * @Update-Location:
 * 3. Longest Substring Without Repeating Characters #423
 *
 * 解题思路：
 * 1. 首先构建以字符 char 为索引的 int[], 用来存储字符出现位置
 * 2. 初始化数组元素值为 -1
 * 3. 定义结果长度变量 result 和 非重复字符开始位置 start
 * 4. 开始遍历字符
 * 5. 存储 字符所在位置到 temp
 * 6. 当字符重复出现时，将 start 赋值 为 字符上一次出现索引位置后一位
 * 7. 非重复字符长度 result， 在每遍历一个str char 时，都与当前result 长度进行比对. 仅保留最长长度
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        // 1. 首先构建以字符 char 为索引的 int[], 用来存储字符出现位置
        int[] help = new int[128];

        // 2. 初始化数组元素值为 -1
        for (int i = 0; i < 128; i++) {
            help[i] = -1;
        }

        // 3. 定义结果长度变量 result 和 非重复字符开始位置 start
        int start = 0;
        int result = 0;

        // 4. 开始遍历字符
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);

            // 字符上次出现位置后移一位
            // 如果非重复字符， start 不会变
            start = Math.max(start, help[c] + 1);


            // 将最大长度赋值给 result, [start, i]
            result = Math.max(result, i - start + 1);

            // 5. 存储 字符所在位置到 help
            help[c] = i;

        }

        return result;
    }
}
