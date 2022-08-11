package java00003.m02;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-11 15:49
 * @Update Date Time: 2022-08-11 15:49
 * @Updated-By: alton_z
 * @Update-Location:
 * 3. Longest Substring Without Repeating Characters #423
 * 解题思路：
 * 1. 遍历字符
 * 2. 通过 Map 记录字符出现的位置
 * 3. 出现重复字符时，start 发生变化， 为重复字符上一次出现索引位置，往后移一位
 * 4. res 保存最大，无重复子串的长度
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        // 定义 res , 保持结果值
        // 定义 start, 保存不重复字符串的 start 索引位
        int res = 0, start = 0;

        // map 保存 char 和 索引位置
        // 当出现重复 char 后， index 位置会更新为新位置
        Map<Integer, Integer> strAndIndex = new HashMap<>();

        // 遍历 s
        for(int i = 0; i < s.length(); i++) {

            // 注意点，这里将 char int 化（这是很自然的行为，不要诧异）
            int index = s.charAt(i);

            // 当出现重复字符时
            if (strAndIndex.containsKey(index)) {

                // 将  start 更新为重复字符上次出现位置往后移动一位
                start = Math.max(start, strAndIndex.get(index) + 1);
            }

            // map 保存 char 和 索引位
            strAndIndex.put(index, i);

            // 更新结果值为 [start, i] 区间长度 -> i - start + 1
            res = Math.max(res, i - start + 1);
        }

        // 返回 res 值
        return res;
    }
}
