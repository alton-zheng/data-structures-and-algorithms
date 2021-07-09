package java00383.m01;

/**
 * @Author: alton
 * @Date: Created in 7/9/21 11:20 PM
 * @Description:
 * 383. Ransom Note #190
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 *
 * Time Complexity : O()
 * Space Complexity : O()
 *
 * Runtime: 3 ms, faster than 79.16% of Java online submissions for Ransom Note.
 * Memory Usage: 39.1 MB, less than 83.46% of Java online submissions for Ransom Note.
 *
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        // 新建小写字母频次统计数组，0-25 分别代表 a-z
        int[] charCountRN = new int[26];
        int[] charCountM = new int[26];

        // 将 String 转化成 char[] 可以加速程序，因为 String.charAt() 每次调用都会检查下标是否越界
        char[] charArrayRN = ransomNote.toCharArray();
        char[] charArrayM = magazine.toCharArray();

        // 统计救赎信的各个字母出现次数
        for (char c : charArrayRN) {
            charCountRN[c-'a']++;
        }

        // 统计杂志的各个字母出现次数
        for (char c : charArrayM) {
            charCountM[c-'a']++;
        }

        // 对每个字母的出现次数进行比较
        for (int i = 0; i < 26; i++) {
            if(charCountRN[i] > charCountM[i]){
                return false;
            }
        }

        return true;
    }
}
