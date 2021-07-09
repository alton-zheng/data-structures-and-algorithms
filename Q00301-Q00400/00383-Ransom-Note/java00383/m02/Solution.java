package java00383.m02;

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

        // 由于 ransomNote 和 magazine 都仅仅有小写字母，公用一份 help
        int[] help = new int[26];

        // 杂志加数量
        for(char c : magazine.toCharArray()){
            ++help[c - 'a'];
        }

        // 赎金信减去数量
        for(char c: ransomNote.toCharArray()){

            // 杂志字符数量不够时，返回 false
            if(--help[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
