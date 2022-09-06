package java00828.m01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-06 10:44
 * @Update Date Time: 2022-09-06 10:44
 * @Updated-By: alton_z
 * @Update-Location:
 * 828. Count Unique Characters of All Substrings of a Given String #467
 */
class Solution {
    public int uniqueLetterString(String s) {

        Map<Character, List<Integer>> help = new HashMap<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (!help.containsKey(c)) {
                help.put(c, new ArrayList<>());

                // 在每个字符 list 中首位置添加 -1 索引
                help.get(c).add(-1);
            }

            // 添加字符所在位置
            help.get(c).add(i);
        }

        // 定义结果值
        int res = 0;

        // 开始遍历所有去重字符（help）
        for (Map.Entry<Character, List<Integer>> cs: help.entrySet()) {
            List<Integer> arr = cs.getValue();

            // 实际得到当前字符贡献值前，先添加 len
            // 能很方便的计算末尾位置到字符结尾位置的贡献值
            arr.add(len);
            for (int i = 1; i < arr.size() - 1; i++) {

                // 某个位置的贡献值等于
                // (i - 1, i]区间贡献值乘以(i + 1) - i]
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }

        return res;
    }
}
