package java00003.m01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-10 22:53
 * @Update Date Time: 2022-08-10 22:53
 * @Updated-By: alton_z
 * @Update-Location:
 *
 * 3. Longest Substring Without Repeating Characters #423
 *
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 3. Longest Substring Without Repeating Characters #423
 *
 * 解题思路：
 * 1. 将字符解析成 char[]
 * 2. 遍历 char[] ,将元素放入到 temp list
 * 3. 遍历过程中，如发现字符重复出现，max list 保存长度最大的无重复 temp list
 * 4. 遇到重复字符时，将 tempStr 已经存在重复字符以及此字符之前的所有字符全部删除， 以此类推
 *
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {

        List<Character> max = new ArrayList<>();
        List<Character> temp = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            // 获取当前位置的字符 char
            char c = s.charAt(i);

            // 判断现有 temp 是否包含当前 char
            if (temp.contains(c)) {

                // 包含说明字符重复了
                // 当 temp list 的大小大于 max 时，说明 temp 的长度已经超过 max list
                if (temp.size() > max.size()) {

                    // 用 temp 重新创建一个 list 赋值给 max
                    // 执行完后， max 就是遍历到当前位置时，最大长度char
                    // 发散思维下， 这里为什么不直接赋值，而是重新创建呢？
                    // 这设计到底层知识，懂得都懂，不懂自己想
                    max = new ArrayList<>(temp);
                }

                // 将重复 c 的索引位置找出
                int reStrIndex = temp.indexOf(c);

                // 并将 c 位置位置及之前的字符全部从 temp 中移除
                for (int j = 0; j <= reStrIndex; j++) {
                    temp.remove(0);
                }

            }

            // 将当前位置 c 添加到 temp list 中
            temp.add(c);
        }

        // 边界场景1： 遍历完后， temp 的大小已经超过 max
        if (temp.size() > max.size()) {
            // max 引用指向 temp
            max = temp;
        }

        return max.size();

    }
}
