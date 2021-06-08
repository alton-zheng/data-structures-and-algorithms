package java00796;

/**
 * @Author: alton
 * @Date: Created in 6/8/21 6:40 PM
 * @Description:
 * 796- Rotate String #88
 * 
 * We are given two strings, s and goal.
 * 
 * A shift on s consists of taking string s and moving the leftmost character to the rightmost position. For example, if s = 'abcde', then it will be 'bcdea' after one shift on s. Return true if and only if s can become goal after some number of shifts on s.
 * 
 * Example 1:
 * Input: s = 'abcde', goal = 'cdeab'
 * Output: true
 * 
 * Example 2:
 * Input: s = 'abcde', goal = 'abced'
 * Output: false
 * Note:
 * 
 * s and goal will have length at most 100.
 * 
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 * 
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate String.
 * Memory Usage: 36.9 MB, less than 66.20% of Java online submissions for Rotate String.
 */
class Solution {
    public boolean rotateString(String s, String goal) {

        return s.length() == goal.length() && (s + s).contains(goal);

    }

    public static void main(String[] args) {
        System.out.println(new Solution().rotateString("abcde", "cdeab"));
    }

}
