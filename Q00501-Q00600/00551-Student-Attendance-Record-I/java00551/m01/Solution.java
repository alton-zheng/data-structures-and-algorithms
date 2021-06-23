package java00551.m01;

/**
 * @Author: alton
 * @Date: Created in 6/23/21 8:53 PM
 * @Description:
 * 00551-Student-Attendance-Record-I
 *
 * You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
 *
 * 'A': Absent.
 * 'L': Late.
 * 'P': Present.
 * The student is eligible for an attendance award if they meet both of the following criteria:
 *
 * The student was absent ('A') for strictly fewer than 2 days total.
 * The student was never late ('L') for 3 or more consecutive days.
 * Return true if the student is eligible for an attendance award, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "PPALLP"
 * Output: true
 * Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
 * Example 2:
 *
 * Input: s = "PPALLL"
 * Output: false
 * Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Student Attendance Record I.
 * Memory Usage: 37.3 MB, less than 43.40% of Java online submissions for Student Attendance Record I.
 *
 */
class Solution {
    public boolean checkRecord(String s) {

        int aN = 0, lN = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                aN++;
            }

            if (i > 0 && s.charAt(i - 1) == 'L' && s.charAt(i) == 'L') {
                lN++;
            } else {
                lN = 1;
            }

            if (aN > 1 || lN > 2) {
                return false;
            }
        }

        return true;
    }
}
