package java01961.m02;

/**
 * Runtime: 1 ms, faster than 66.67% of Java online submissions for Check If String Is a Prefix of Array.
 * Memory Usage: 39.2 MB, less than 33.33% of Java online submissions for Check If String Is a Prefix of Array.
 */
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        StringBuilder res = new StringBuilder();
        for (String word: words) {
            res.append(word);
            if (res.toString().equals(s)) {
                return true;
            }
        }
        
        return false;
        
    }
}