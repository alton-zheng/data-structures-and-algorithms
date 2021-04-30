class Solution {

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     * Example 1:
     * <p>
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * <p>
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * <p>
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * Example 4:
     * <p>
     * Input: s = ""
     * Output: 0
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        /**
         * 解题思路：
         * 1. 将字符解析成 char[]
         * 2. 遍历 char[] ,将元素放入到 temp list
         * 3. 遍历过程中，如发现字符重复出现，max list 保存长度最大的无重复 temp list
         * 4. 遇到重复字符时，将 tempStr 已经存在重复字符以及此字符之前的所有字符全部删除， 以此类推
         */

        /*List<Integer> max = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            int item = s.charAt(i);

            if (temp.contains(item)) {
                if (temp.size() > max.size()) {
                    max = new ArrayList<>(temp);
                }

                int reStrIndex = temp.indexOf(item);

                for (int j = 0; j <= reStrIndex; j++) {
                    temp.remove(0);
                }

            }

            temp.add(item);
        }

        if (temp.size() > max.size()) {
            max = temp;
        }

        return max.size();*/

        /**
         * 解题思路：
         * 1. 遍历字符
         * 2. 通过 Map 记录字符出现的位置
         * 3. 出现重复字符时，start 发生变化， 为重复字符上一次出现索引位置，往后移一位
         * 4. res 保存最大，无重复子串的长度
         */

        /*
        int n = s.length();

        int res = 0;
        int start = 0;
        Map<Integer, Integer> strAndIndex = new HashMap<>();
        for(int i = 0; i < n; i++) {

            int index = s.charAt(i);
            if (strAndIndex.containsKey(index)) {
                start = Math.max(start, strAndIndex.get(index) + 1);
            }

            strAndIndex.put(index, i);
            res = Math.max(res, i - start + 1);
        }

        return res;*/

        /**
         * 1. 首先构建以字符 char 为索引的 int[], 用来存储字符出现位置
         * 2. 初始化数组元素值为 -1
         * 3. 定义结果长度变量 result 和 非重复字符开始位置 start
         * 4. 开始遍历字符
         * 5. 存储 字符所在位置到 temp
         * 6. 当字符重复出现时，将 start 赋值 为 字符上一次出现索引位置后一位
         * 7. 非重复字符长度 result， 在每遍历一个str char 时，都与当前result 长度进行比对. 仅保留最长长度
         */

        int[] temp = new int[128];

        for (int i = 0; i < 128; i++) {
            temp[i] = -1;
        }

        int start = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int strCharAt = s.charAt(i);

            start = Math.max(start, temp[strCharAt] + 1);
            result = Math.max(result, i - start + 1);

            temp[strCharAt] = i;

        }

        return result;

    }

}