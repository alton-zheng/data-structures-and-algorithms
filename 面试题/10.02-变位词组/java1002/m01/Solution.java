package java1002.m01;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 7/18/21 7:52 AM
 * @Description:
 * group-anagrams-lcci #218
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * Time Complexity:  O(NL*logL)
 * Space Complexity: O(NL)
 *
 *
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> help = new HashMap<>();

        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> value = help.getOrDefault(key, new ArrayList<>());
            value.add(str);
            help.put(key, value);
        }

        return new ArrayList<>(help.values());
    }
}
